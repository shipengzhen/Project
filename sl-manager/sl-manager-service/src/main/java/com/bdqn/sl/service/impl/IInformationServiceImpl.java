package com.bdqn.sl.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdqn.common.FtpUtil;
import com.bdqn.sl.mapper.InformationMapper;
import com.bdqn.sl.mapper.SysDictionaryMapper;
import com.bdqn.sl.mapper.SysUserMapper;
import com.bdqn.sl.pojo.Information;
import com.bdqn.sl.pojo.InformationExample;
import com.bdqn.sl.pojo.SysUser;
import com.bdqn.sl.pojo.InformationExample.Criteria;
import com.bdqn.sl.pojo.SysDictionary;
import com.bdqn.sl.service.IInformationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 资讯
 * @author lizhen
 */
@Service
public class IInformationServiceImpl implements IInformationService {

	@Autowired
	private InformationMapper informationMapper;			//资讯
	
	@Autowired
	private SysUserMapper sysUserMapper;		//用户
	
	@Resource
	private SysDictionaryMapper sysDictionaryMapper;	//字典
	
	

	
	
	//新增 资讯
	@Override
	public void addInfo(Information info) {
		info.setCreated(new Date());
		info.setUpdated(new Date());
		informationMapper.insert(info);
	}
	
	//查询
	@Override
	public PageInfo<Information> FindinfoList(Information info, Integer pageNo, Integer pageSize) {
		
		InformationExample example = new InformationExample();
		example.setOrderByClause("updated desc");
		Criteria criteria = example.createCriteria();
		if(info.getZtitle()!=null&&info.getZtitle()!="") {
			criteria.andZtitleEqualTo(info.getZtitle());		//标题
		}
		if(info.getStatus()!=null&&info.getStatus()>=0) {
			criteria.andStatusEqualTo(info.getStatus());		//状态
		}
		
		PageHelper.startPage(pageNo, pageSize);
		List<Information> list = informationMapper.selectByExample(example);
		
		list=this.findrefName(list);
		
		PageInfo<Information> pageInfo = new PageInfo<Information>(list);
		
		return pageInfo;
	}

	//赋值 创建人
	private  List<Information> findrefName(List<Information> list){
		
		if(list!=null&&list.size()>0) {
			for (int i = 0; i < list.size(); i++) {
				SysUser sysUser = sysUserMapper.selectByPrimaryKey(list.get(i).getCreateuid());
				list.get(i).setCreateUname(sysUser.getLoginname());
			}
		}
	
		return list;
	}

	//根据id查询
	@Override
	public Information findInfoById(Integer id) {
		
		Information information = informationMapper.selectByPrimaryKey(id);
		
		SysUser user = sysUserMapper.selectByPrimaryKey(information.getCreateuid());
		information.setCreateUname(user.getLoginname());//赋值名称！
		
		SysDictionary dictionary = sysDictionaryMapper.selectByPrimaryKey(information.getZtypeid());
		
		information.setTypeName(dictionary.getValuename());//类型名称
		
		return information;
	}
	
	//根据修改 资讯
	@Override
	public void updateInfo(Information info) {
		info.setUpdated(new Date());
		informationMapper.updateByPrimaryKeySelective(info);
	}

	//删除
	@Override
	public void delInfo(Integer id) {
		informationMapper.deleteByPrimaryKey(id);
	}
	//首页展示 5条
	@Override
	public List<Information> getInfoListMan() {
		InformationExample example = new InformationExample();
		example.setOrderByClause("updated desc");
		
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(0);	//发布
		
		PageHelper.startPage(1, 5);
		List<Information> list = informationMapper.selectByExample(example);
		
		return list;
	}
	//判断重名
	@Override
	public boolean findInfoByTitle(String title) {
		InformationExample example = new InformationExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andZtitleEqualTo(title);
		
		int i = informationMapper.countByExample(example);
		if(i>0) {
			return false;
		}
		return true;
	}
	
	
	
	
	
}

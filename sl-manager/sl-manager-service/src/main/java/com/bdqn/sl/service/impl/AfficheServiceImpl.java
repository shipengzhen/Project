package com.bdqn.sl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.sl.mapper.AfficheMapper;
import com.bdqn.sl.mapper.SysUserMapper;
import com.bdqn.sl.pojo.Affiche;
import com.bdqn.sl.pojo.AfficheExample;
import com.bdqn.sl.pojo.AfficheExample.Criteria;
import com.bdqn.sl.pojo.SysUser;
import com.bdqn.sl.service.IAfficheService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class AfficheServiceImpl implements IAfficheService {

	@Autowired
	private AfficheMapper afficheMapper;		//公告
	
	@Autowired
	private SysUserMapper sysUserMapper;		//用户

	
	//新增
	@Override
	public void addAffiche(Affiche affiche) {
		
		affiche.setUpdated(new Date());
		affiche.setCreated(new Date());
		afficheMapper.insert(affiche);
	}

	//分页集合
	@Override
	public PageInfo<Affiche> findAllAffiche(Integer type,int pageNum, int pageSize) {
		
		AfficheExample example = new AfficheExample();
		example.setOrderByClause("updated desc");
		
		Criteria criteria = example.createCriteria();
		//type ==1 管理员   2-》员工
		if(type==2) {
			criteria.andBegindateLessThan(new Date());		//大于
			criteria.andEnddateGreaterThan(new Date());	
		}
		
		PageHelper.startPage(pageNum, pageSize);
		List<Affiche> list = afficheMapper.selectByExample(example);
		
		list=this.findUserName(list);
		
		PageInfo<Affiche> info = new PageInfo<Affiche>(list,4);
		
		return info;
	}
	
	
	public List<Affiche> findUserName(List<Affiche> list){
		
	
		if(list!=null&&list.size()>0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getCreateuid());
				SysUser user = sysUserMapper.selectByPrimaryKey(list.get(i).getCreateuid());
				list.get(i).setUserName(user.getLoginname());
			}
		}
		return list;
	}

	//根据id查询
	@Override
	public Affiche findAfficheById(Integer id) {
		
		Affiche affiche = afficheMapper.selectByPrimaryKey(id);
		
		SysUser user = sysUserMapper.selectByPrimaryKey(affiche.getCreateuid());
		
		affiche.setUserName(user.getLoginname());
		
		return affiche;
	}
	
	//修改 公告
	@Override
	public void UpdateAffiche(Affiche affiche) {
		afficheMapper.updateByPrimaryKeySelective(affiche);
	}

	//删除
	@Override
	public void deleteAffiche(Integer id) {
		afficheMapper.deleteByPrimaryKey(id);
	}

}

package com.bdqn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.mapper.TbUserMapper;
import com.bdqn.pojo.TbUser;
import com.bdqn.pojo.TbUserExample;
import com.bdqn.pojo.TbUserExample.Criteria;
import com.bdqn.service.TbUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TbUserServiceImpl implements TbUserService {

	@Autowired
	private TbUserMapper tbUserMapper;
	
	//通过 loginName 查询用户 -- 登录
	@Override
	public TbUser findTbUserByLoginName(String loginName,String loginPwd) {
		
		TbUserExample example=new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginnameEqualTo(loginName);
		criteria.andLoginpwdEqualTo(loginPwd);
		List<TbUser> list = tbUserMapper.selectByExample(example);
		
		if (list.size()>0) 
			return list.get(0);
					
		return null;
	}
	//新增
	@Override
	public void AddTbUser(TbUser user) {
		user.setCreated(new Date());
		user.setUpdated(new Date());
		
		tbUserMapper.insert(user);
	}
	
	//判断用户 重名
	@Override
	public String findUserByName(String loginName) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginnameEqualTo(loginName);
		List<TbUser> list = tbUserMapper.selectByExample(example);
		System.out.println("list.size="+list.size());
		if(list.size()>0) {
				return "no";
		}
	    return "ok";
	}
	//用户 查询分页
	@Override
	public PageInfo<TbUser> findList(String loginname, Integer pageNo, Integer pageSize) {
		
		TbUserExample example = new  TbUserExample();
		example.setOrderByClause("updated desc");		//排序
		
		Criteria criteria = example.createCriteria();
		
		if(loginname!=null) {
			criteria.andLoginnameLike("%"+loginname+"%");
		}
		
		PageHelper.startPage(pageNo, pageSize);			//分页
		
		List<TbUser> list = tbUserMapper.selectByExample(example);
		
		PageInfo<TbUser> info = new PageInfo<TbUser>(list);
		
		return info;
	}
	//删除用户
	@Override
	public void deleteUserById(Integer id) {
		tbUserMapper.deleteByPrimaryKey(id);
	}
	//通过id 查询用户
	@Override
	public TbUser findUserById(Integer id) {
		TbUser user = tbUserMapper.selectByPrimaryKey(id);
		return user;
	}
	//修改用户
	@Override
	public void updateUser(TbUser user) {
		tbUserMapper.updateByPrimaryKeySelective(user);
	}
	
	

}

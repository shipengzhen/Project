package com.bdqn.sl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.sl.mapper.SysRoletypeMapper;
import com.bdqn.sl.pojo.SysRoletype;
import com.bdqn.sl.pojo.SysRoletypeExample;
import com.bdqn.sl.pojo.SysRoletypeExample.Criteria;
import com.bdqn.sl.service.ISysRoletypeService;

//会员类型 表
@Service
public class SysRoletypeServiceImpl implements ISysRoletypeService {

	@Autowired
	private SysRoletypeMapper sysRoletypeMapper;		//会员类型
	
	
	
	//根据 角色id  查询角色类型
	@Override
	public List<SysRoletype> findRtypeByroleid(Integer roleId) {

		SysRoletypeExample example = new SysRoletypeExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andRoleidEqualTo(roleId);
		List<SysRoletype> list = sysRoletypeMapper.selectByExample(example);
		
		return list;
	}


	//查询全部
	@Override
	public List<SysRoletype> findAll() {
		
		List<SysRoletype> list = sysRoletypeMapper.selectByExample(null);
		return list;
	}

	//根据角色 id 查询
	@Override
	public SysRoletype findRoleTypeById(Integer id) {
		
		SysRoletype roletype = sysRoletypeMapper.selectByPrimaryKey(id);
		
		return roletype;
	}

}

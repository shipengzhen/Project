package com.bdqn.sl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.sl.mapper.SysRoleMapper;
import com.bdqn.sl.pojo.SysRole;
import com.bdqn.sl.service.ISysRoleService2;

@Service
public class SysRoleServiceImpl2 implements ISysRoleService2 {

	
	@Autowired
	private SysRoleMapper sysRoleMapper;		//角色
	
	//角色集合
	@Override
	public List<SysRole> findAllRole() {
		
		List<SysRole> list = sysRoleMapper.selectByExample(null);
		
		return list;
	}
	//根据id查询
	@Override
	public SysRole findRoleByID(Integer id) {
		SysRole role = sysRoleMapper.selectByPrimaryKey(id);
		return role;
	}

}

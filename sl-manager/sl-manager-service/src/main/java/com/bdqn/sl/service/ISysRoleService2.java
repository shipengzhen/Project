package com.bdqn.sl.service;

import java.util.List;

import com.bdqn.sl.pojo.SysRole;

//角色 表
public interface ISysRoleService2 {
	
	/**
	 * 查询角色集合
	 * @return
	 */
	List<SysRole> findAllRole();
	
	/**
	 * 根据id查询
	 * @return
	 */
	SysRole findRoleByID(Integer id);
	
}

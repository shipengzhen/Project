package com.bdqn.sl.service;

import java.util.List;

import com.bdqn.sl.pojo.SysRoletype;

/**
 * 会员 类 型
 * @author lizhen
 */
public interface ISysRoletypeService {
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	SysRoletype findRoleTypeById(Integer id);
	
	/**
	 * 根据角色id查询 查询 会员类型
	 * @return
	 */
	List<SysRoletype> findRtypeByroleid(Integer roleId);
	
	/**
	 * 查询全部
	 * @return
	 */
	List<SysRoletype> findAll();
}

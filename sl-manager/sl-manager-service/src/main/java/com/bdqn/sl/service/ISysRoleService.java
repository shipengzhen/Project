/**
 * 
 */
package com.bdqn.sl.service;

import java.util.List;

import com.bdqn.sl.pojo.SysRole;

/**
 * @描述 sl-manager-service
 * @作者 施鹏振
 * @创建日期 2018年3月15日
 * @创建时间 下午8:35:37
 */
public interface ISysRoleService {

	/**
	 * 新增角色
	 * @param roleName
	 * @param status
	 * @param uId
	 * @return boolean
	 */
	public boolean addRole(String roleName,Integer status,Integer uId);
	
	/**
	 * 判断角色是否存在
	 * @param roleName
	 * @return boolean
	 */
	public boolean existRole(String roleName);
	
	/**
	 * 查询角色列表
	 * @return List<SysRole>
	 */
	public List<SysRole> findRoles();
	
	/**
	 * 修改角色
	 * @param role
	 * @return boolean
	 */
	public boolean modifyRole(SysRole role);
	
	/**
	 * 删除角色
	 * @param roleId
	 * @return boolean
	 */
	public boolean delRole(Integer roleId);
}

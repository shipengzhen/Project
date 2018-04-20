/**
 * 
 */
package com.bdqn.sl.service;

import java.util.List;

import com.bdqn.common.Menu;
import com.bdqn.sl.pojo.SysAuthority;

/**
 * @描述 sl-manager-service
 * @作者 施鹏振
 * @创建日期 2018年3月16日
 * @创建时间 下午3:52:45
 */
public interface ISysAuthorityService {

	/**
	 * 获取某权限的自子权限
	 * @param parentId
	 * @return List<SysAuthority>
	 */
	public List<SysAuthority> findAuthoritysByParentId(Integer parentId);
	
	/**
	 * 获取全部权限
	 * @return List<Menu>
	 */
	public List<Menu> findAuthoritys();
	
	/**
	 * 修改角色权限
	 * @param roleId
	 * @param authorityIds
	 * @return boolean
	 */
	public boolean modifyAuthority(Integer roleId,String[] authorityIds);
	
	/**
	 * 查询某角色所有的权限id
	 * @param roleId
	 * @return List<Integer>
	 */
	public List<Integer> findAuthorityIdsByRoleId(Integer roleId);
	
	/**
	 * 查询某角色所有的权限
	 * @param roleId
	 * @return List<Menu>
	 */
	public List<Menu> findAuthoritysByByRoleId(Integer roleId);
}

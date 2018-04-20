package com.bdqn.service;

import java.util.List;

import com.bdqn.pojo.TbRoleResourceKey;

/**
 * 角色 和 资源 中间表
 * @author lizhen
 * @date 2018年2月5日
 * @time 上午10:48:48
 */
public interface TbRoleResourceService {
	
	/**
	 * 新增多个
	 * @param items
	 * @param roleId
	 * @date 2018年2月5日
	 * @time 上午10:50:55
	 * @author lizhen
	 */
	void AddRoleResources(Integer[]items,Integer roleId);
	/**
	 * 根据角色id查询
	 * @param id
	 * @return
	 * @date 2018年2月8日
	 * @time 上午10:20:49
	 * @author lizhen
	 */
	List<TbRoleResourceKey> findAllByRoleId(Integer id);
	/**
	 * 删除多个 -- 角色id 
	 * @date 2018年2月8日
	 * @time 上午11:19:19
	 * @author lizhen
	 */
	void deleteByRoleId(Integer roleId);
	
}

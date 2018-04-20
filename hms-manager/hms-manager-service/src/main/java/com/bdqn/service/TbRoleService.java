package com.bdqn.service;

import java.util.List;

import com.bdqn.pojo.TbRole;
import com.github.pagehelper.PageInfo;

/**
 * 角色 管理
 * @author lizhen
 * @date 2018年2月3日
 * @time 上午11:05:07
 */
public interface TbRoleService {
	
	
	
	//-----------------------
	/**
	 * 角色添加
	 * @param tbRole
	 * @date 2018年2月3日
	 * @time 上午11:05:56
	 * @author lizhen
	 */
	void insertRole(TbRole tbRole);
	
	/**
	 * 通过名称查找
	 * @param roleName
	 * @date 2018年2月5日
	 * @time 上午11:37:50
	 * @author lizhen
	 */
	String findTbRoleByName(String roleName);
	/**
	 * 查询分页
	 * @param roleName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @date 2018年2月7日
	 * @time 下午6:18:37
	 * @author lizhen
	 */
	PageInfo<TbRole> findTbRoleLikeName(String roleName,Integer pageNo,Integer pageSize);
	/**
	 * 删除
	 * @param id
	 * @date 2018年2月7日
	 * @time 下午6:20:17
	 * @author lizhen
	 */
	void deleteRole(Integer id);
	/**
	 * 通过id删除
	 * @param id
	 * @return
	 * @date 2018年2月8日
	 * @time 上午11:08:04
	 * @author lizhen
	 */
	TbRole findRoleById(Integer id);
	/**
	 * 通过id修改
	 * @param id
	 * @date 2018年2月8日
	 * @time 上午11:08:33
	 * @author lizhen
	 */
	void updateRoleById(Integer[]items,TbRole role);
	/**
	 * 查询所有的 角色
	 * @return
	 * @date 2018年2月8日
	 * @time 下午1:05:33
	 * @author lizhen
	 */
	List<TbRole> findAllRole();
	
}

package com.bdqn.sl.service;


import java.util.List;

import com.bdqn.sl.pojo.SysUser;
import com.github.pagehelper.PageInfo;

/**
 * 用户service接口
 * @author lizhen
 */
public interface ISysUserService {
	
	//--------------------推荐查询
	
	/**
	 * 推荐查询  查询当前用户所推荐的人
	 */
	PageInfo<SysUser> findUserTJ(SysUser user,Integer pageNo,Integer pageSize);
		
	
	//-------------------------------------------------
	
	/**
	 * 用户角色
	 * @return
	 */
	PageInfo<SysUser> userHYList(SysUser user,Integer pageNo,Integer pageSize);
	/**
	 * 通过名称查询 用户对象
	 * @return
	 */
	SysUser findUserName(String loginName);
	
	/**
	 * 查询某角色的数量
	 * @param roleId
	 * @return Integer
	 */
	Integer findUserCountByRole(Integer roleid);
	
	
	
	
	
	//-------- 管理员
	
	boolean findUserByLoginName(String name);
	
	/**
	 * 删除
	 * @param id
	 */
	void deleteUser(Integer id);
	
	/**
	 * 修改
	 * @param user
	 */
	void updateUser(SysUser user);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	SysUser findUserbyId(Integer id);
	/**
	 * 查询 集合 分页
	 * @return
	 */
	
	PageInfo<SysUser> findUserList(Integer pageNo,Integer pageSize,SysUser user);
	
	/**
	 * 新增用户
	 * @param user
	 */
	void addUser(SysUser user);
	
	/**
	 * 登录
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	SysUser findUserByLoginName(String loginName,String loginPwd);
	/**
	 * 根据 推荐人 名字  模糊查询 用户id
	 * @param referre
	 * @return
	 */
	List<Integer> findUserIdByRef(String referre);
	
}

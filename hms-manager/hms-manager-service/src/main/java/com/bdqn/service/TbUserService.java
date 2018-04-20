package com.bdqn.service;

import com.bdqn.pojo.TbUser;
import com.github.pagehelper.PageInfo;
/**
 * 用戶操作
 * @author lizhen
 * @date 2018年1月29日
 * @time 下午1:34:39
 */
public interface TbUserService {
	
	
	void updateUser(TbUser user);
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 * @date 2018年2月21日
	 * @time 下午2:12:14
	 * @author lizhen
	 */
	TbUser findUserById(Integer id);
	/**
	 * 删除用户
	 * @param id
	 * @date 2018年2月21日
	 * @time 下午12:18:04
	 * @author lizhen
	 */
	void deleteUserById(Integer id);
	
	/**
	 * 用户查询分页
	 * @param rname
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @date 2018年2月21日
	 * @time 上午11:02:43
	 * @author lizhen
	 */
	PageInfo<TbUser> findList(String loginname,Integer pageNo,Integer pageSize);
	/**
	 * 验证重名
	 * @param username
	 * @return
	 * @date 2018年2月8日
	 * @time 下午3:13:08
	 * @author lizhen
	 */
	String findUserByName(String loginName);
	/**
	 * 通过 loginName 查询用户 -- 登录
	 * @return
	 * @date 2018年1月29日
	 * @time 下午1:35:01
	 * @author lizhen
	 */
	TbUser findTbUserByLoginName(String loginName,String loginPwd);
	
	/**
	 * 新增用户
	 * @param user
	 * @date 2018年2月10日
	 * @time 下午4:06:01
	 * @author lizhen
	 */
	void AddTbUser(TbUser user);
	
	
	
}

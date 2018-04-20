/**
 * 
 */
package com.spz.hospital.service;

import java.util.List;

import com.spz.hospital.pojo.Usee;

/**
 * @描述 hospital
 * @作者 施鹏振
 * @创建日期 2018年2月24日
 * @创建时间 下午5:53:11
 */
public interface IUseeService {

	/**
	 * 登录 TODO
	 * 
	 * @param uname
	 * @param password
	 * @return Usee
	 */
	Usee getUsee(String uname, String password);

	/**
	 * 修改密码
	 * 
	 * @param uid
	 * @param password
	 * @param newPassword
	 * @return Boolean
	 */
	Boolean modifyUsee(Integer uid, String password, String newPassword);

	/**
	 * 查询所有用户
	 * 
	 * @return List<Usee>
	 */
	List<Usee> getUsees();
}

/**
 * 
 */
package com.spz.hospital.dao;

import java.util.List;
import com.spz.hospital.pojo.Usee;

/**
 * @描述 hospital
 * @作者 施鹏振
 * @创建日期 2018年2月24日
 * @创建时间 下午3:47:55
 */
public interface IUseeDao {

	/**
	 * 根据用户名密码查询用户
	 * @param uname
	 * @param password
	 * @return Usee
	 */
	Usee findUsee(String uname,String password);
	
	/**
	 * 修改用户密码
	 * @param uname
	 * @param password
	 * @param newPassword
	 * @return Usee
	 */
	Usee findUsee(Integer uid);
	
	/**
	 * 查询所有用户
	 * @return List<Usee>
	 */
	List<Usee> findUsees();
}

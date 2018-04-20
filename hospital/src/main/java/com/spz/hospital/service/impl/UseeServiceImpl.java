/**
 * 
 */
package com.spz.hospital.service.impl;

import java.util.List;

import com.spz.hospital.dao.IUseeDao;
import com.spz.hospital.pojo.Usee;
import com.spz.hospital.service.IUseeService;

/**
 * @描述 hospital
 * @作者 施鹏振
 * @创建日期 2018年2月24日
 * @创建时间 下午6:14:20
 */
public class UseeServiceImpl implements IUseeService {

	private IUseeDao useeDao;
	
	public IUseeDao getUseeDao() {
		return useeDao;
	}

	public void setUseeDao(IUseeDao useeDao) {
		this.useeDao = useeDao;
	}

	/* （非 Javadoc）
	 * @see com.spz.hospital.service.IUseeService#getUsee(java.lang.String, java.lang.String)
	 */
	@Override
	public Usee getUsee(String uname, String password) {
		return useeDao.findUsee(uname, password);
	}

	/* （非 Javadoc）
	 * @see com.spz.hospital.service.IUseeService#updateUsee(java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean modifyUsee(Integer uid, String password, String newPassword) {
		Usee usee=useeDao.findUsee(uid);
		if (usee.getPassword().equals(password)) {
			usee.setPassword(newPassword);
			return true;
		}
		return false;
	}

	/* （非 Javadoc）
	 * @see com.spz.hospital.service.IUseeService#getUsees()
	 */
	@Override
	public List<Usee> getUsees() {
		return useeDao.findUsees();
	}

}

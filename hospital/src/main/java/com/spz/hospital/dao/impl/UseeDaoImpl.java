/**
 * 
 */
package com.spz.hospital.dao.impl;

import com.spz.hospital.dao.IUseeDao;
import com.spz.hospital.pojo.Usee;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * @描述 hospital
 * @作者 施鹏振
 * @创建日期 2018年2月24日
 * @创建时间 下午5:08:18
 */
public class UseeDaoImpl extends HibernateDaoSupport implements IUseeDao {

	/* （非 Javadoc）
	 * @see com.spz.hospital.dao.IUseeDao#findUsee(java.lang.String, java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Usee findUsee(String uname, String password) {
		String hql="from Usee where uname=:uname and password=:password";
		Session session = currentSession();
		Query<Usee> query=session.createQuery(hql);
		query.setParameter("uname", uname);
		query.setParameter("password", password);
		Usee usee=query.uniqueResult();
		return usee;
	}

	/* （非 Javadoc）
	 * @see com.spz.hospital.dao.IUseeDao#updateUsee(java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Usee findUsee(Integer uid) {
		return getHibernateTemplate().load(Usee.class,uid);
	}

	/* （非 Javadoc）
	 * @see com.spz.hospital.dao.IUseeDao#findUsees()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Usee> findUsees() {
		String hql="from Usee";
		Session session = currentSession();
		Query<Usee> query=session.createQuery(hql);
		List<Usee> usees=query.list();
		
		return usees;
	}


}

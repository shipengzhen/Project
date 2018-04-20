package com.yy.dao.impl;

import com.yy.model.*;
import com.yy.util.Page;
import com.yy.dao.*;
import com.fly.jdbc.*;
import java.util.*;

public class UseeDaoImpl implements IUseeDao {

	//�ײ�SqlFly����
	private SqlFly getFly() {
		return Fly.getFly();
	}

	/** ����һ����¼ */
	public int save(Usee usee) {
		String sql=" insert into Usee(uid,uname,password,ustate,uzsname,uemail,rid) value (0,?,?,?,?,?,?)";
		Object[] args={usee.getUname(),usee.getPassword(),usee.getUstate(),usee.getUzsname(),usee.getUemail(),usee.getRid()};
		return getFly().getUpdate(sql, args);
	}

	/** ɾ��һ����¼(��������) */
	public int delete(int id) {
		String sql="delete from Usee where uid=?";
		Object[] args={id};
		return getFly().getUpdate(sql, args);
	}

	/** �޸�һ����¼(��������) */
	public int update(Usee usee) {
		String sql="update Usee set uname=?,password=?,ustate=?,uzsname=?,uemail=?,rid=? where uid=?";
		Object[] args={usee.getUname(),usee.getPassword(),usee.getUstate(),usee.getUzsname(),usee.getUemail(),usee.getRid(),usee.getUid()};
		return getFly().getUpdate(sql, args);
	}

	/** ��ѯһ����¼(��������) */
	public Usee findById(int id) {
		String sql="SELECT * FROM Usee "
				+ "INNER JOIN Role ON Usee.rid=Role.rid "
				+ "WHERE uid=?";
		Object[] args={id};
		return getFly().getModel(sql, Usee.class, args);
	}

	/** ��ѯȫ�� */
	public List<Usee> findAll() {
		String sql="SELECT * FROM Usee "
				+ "INNER JOIN Role ON Usee.rid=Role.rid ";
		return getFly().getList(sql, Usee.class);
	}

	
	
	//�����û��ǳƣ���ѯָ����
	@Override
	public Usee getByUName(String uname) {
		String sql="SELECT * FROM Usee "
				+ "INNER JOIN Role ON Usee.rid=Role.rid "
				+ "WHERE uname=?";
		return getFly().getModel(sql, Usee.class, uname);
	}

	//��ѯ[��ҳ���ǳ�ģ��]
	@Override
	public List<Usee> getByPageUName(Page page,String uname) {
		String sql="SELECT Usee.*,Role.rname,Role.rstate FROM Usee "
				+ "INNER JOIN Role ON Usee.rid=Role.rid "
				+ "WHERE uname like concat('%',?,'%') "
				+ "order by uid";
		return getFly().getPageList(page,sql, Usee.class,uname);
	}

	//����in��ɾ��
	@Override
	public int doDelete(String inStr) {
		return getFly().getUpdate("delete from usee where uid in ("+inStr+")");
	}

	//�޸�����
	@Override
	public int doUpdatePwd(int uid, String password) {
		return getFly().getUpdate("update usee set password=? where uid=?",password,uid);
	}


	
	
	
	

}

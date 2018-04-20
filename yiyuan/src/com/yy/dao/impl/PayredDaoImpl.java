package com.yy.dao.impl;

import com.yy.model.*;
import com.yy.util.Page;
import com.yy.dao.*;
import com.fly.jdbc.*;
import java.util.*;

public class PayredDaoImpl implements IPayredDao {

	//�ײ�SqlFly����
	private SqlFly getFly() {
		return Fly.getFly();
	}

	/** ����һ����¼ */
	public int save(Payred payred) {
		String sql=" insert into Payred(prid,pdate,gid,pid) value (0,NOW(),?,?)";
		Object[] args={payred.getGid(),payred.getPid()};
		return getFly().getUpdate(sql, args);
	}

	/** ɾ��һ����¼(��������) */
	public int delete(int id) {
		String sql="delete from Payred where prid=?";
		Object[] args={id};
		return getFly().getUpdate(sql, args);
	}

	/** �޸�һ����¼(��������) */
	public int update(Payred payred) {
		String sql="update Payred set pdate=?,gid=?,pid=? where prid=?";
		Object[] args={payred.getPdate(),payred.getGid(),payred.getPid(),payred.getPrid()};
		return getFly().getUpdate(sql, args);
	}

	/** ��ѯһ����¼(��������) */
	public Payred findById(int id) {
		String sql="select * from Payred where prid=?";
		Object[] args={id};
		return getFly().getModel(sql, Payred.class, args);
	}

	/** ��ѯȫ�� */
	public List<Payred> findAll() {
		String sql="select * from Payred";
		Object[] args={};
		return getFly().getList(sql, Payred.class, args);
	}

	
	//��ѯָ��gid�������շѵǼ�
	@Override
	public List<Payred> getByTJ(Page page,int gid) {
		String sql= "select *,(select pname from Pay where pid=PayRed.pid) AS pname"
				+ " from PayRed where gid=?";
		return getFly().getPageList(page, sql, Payred.class, gid);
	}



}

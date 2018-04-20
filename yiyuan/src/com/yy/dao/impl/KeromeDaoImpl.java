package com.yy.dao.impl;

import com.yy.model.*;
import com.yy.dao.*;
import com.fly.jdbc.*;
import java.util.*;

public class KeromeDaoImpl implements IKeromeDao {

	//�ײ�SqlFly����
	private SqlFly getFly() {
		return Fly.getFly();
	}

	/** ����һ����¼ */
	public int save(Kerome kerome) {
		String sql=" insert into Kerome(kid,kname) value (?,?)";
		Object[] args={kerome.getKid(),kerome.getKname()};
		return getFly().getUpdate(sql, args);
	}

	/** ɾ��һ����¼(��������) */
	public int delete(int id) {
		String sql="delete from Kerome where kid=?";
		Object[] args={id};
		return getFly().getUpdate(sql, args);
	}

	/** �޸�һ����¼(��������) */
	public int update(Kerome kerome) {
		String sql="update Kerome set kname=? where kid=?";
		Object[] args={kerome.getKname(),kerome.getKid()};
		return getFly().getUpdate(sql, args);
	}

	/** ��ѯһ����¼(��������) */
	public Kerome findById(int id) {
		String sql="select * from Kerome where kid=?";
		Object[] args={id};
		return getFly().getModel(sql, Kerome.class, args);
	}

	/** ��ѯȫ�� */
	public List<Kerome> findAll() {
		String sql="select * from Kerome";
		Object[] args={};
		return getFly().getList(sql, Kerome.class, args);
	}



}

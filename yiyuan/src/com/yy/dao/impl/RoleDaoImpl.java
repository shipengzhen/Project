package com.yy.dao.impl;

import com.yy.model.*;
import com.yy.util.Page;
import com.yy.dao.*;
import com.fly.jdbc.*;
import java.util.*;

public class RoleDaoImpl implements IRoleDao {

	//�ײ�SqlFly����
	private SqlFly getFly() {
		return Fly.getFly();
	}

	/** ����һ����¼ ++[T] */
	public int save(Role role,List<Integer>mids) {
		String sql="insert into Role(rid,rname,rstate) value (0,?,?)";
		Object[] args={role.getRname(),role.getRstate()};
		getFly().beginTransaction().getUpdate(sql, args);
		
		int rid=getFly().getScalarInt("SELECT @@IDENTITY;");
		if(mids!=null) {
			for (int mid : mids) {
				FC.getIJurDao().save(rid,mid);
			}
		}
		getFly().commit();
		
		return 1;
	}

	/** ɾ��һ����¼(��������) */
	public int delete(int id) {
		String sql="delete from Role where rid=?";
		Object[] args={id};
		return getFly().getUpdate(sql, args);
	}

	/** �޸�һ����¼(��������) */
	public int update(Role role,List<Integer>mids) {
		String sql="update Role set rname=?,rstate=? where rid=?";
		Object[] args={role.getRname(),role.getRstate(),role.getRid()};
		getFly().beginTransaction().getUpdate(sql, args);	//�޸���Ϣ
		
		FC.getIJurDao().deleteByRid(role.getRid());	//ɾ����rid����������Դ
		if(mids!=null) {
			for (int mid : mids) {
				FC.getIJurDao().save(role.getRid(),mid);	//Ȼ���������Դ
			}
		}
		getFly().commit();
		return 1;
	}

	/** ��ѯһ����¼(��������) */
	public Role findById(int id) {
		String sql="select * from Role where rid=?";
		Object[] args={id};
		return getFly().getModel(sql, Role.class, args);
	}

	/** ��ѯȫ�� */
	public List<Role> findAll() {
		String sql="select * from Role";
		Object[] args={};
		return getFly().getList(sql, Role.class, args);
	}

	
	// ��ѯ������[��ҳ����ɫ����ģ����ѯ]
	@Override
	public List<Role> getByPageRName(Page page, String rname) {
		String sql="select * from Role where rname like concat('%',?,'%')";
		return getFly().getPageList(page, sql, Role.class, rname);
	}

	
	//����in��ɾ��
	@Override
	public int doDelete(String ids) {
		getFly().beginTransaction().getUpdate("delete from Jur where rid in ("+ids+")");	//ɾ��ɫ��Դ��Ӧ������
		getFly().getUpdate("UPDATE usee SET rid=NULL WHERE rid in ("+ids+")");				//��Usee��˽�ɫ�û����
		return getFly().getUpdateCommit("delete from Role where rid in ("+ids+")");		//ɾ���˽�ɫ
	}

	

	

}

package com.yy.dao.impl;

import com.yy.model.*;
import com.yy.util.Page;
import com.yy.dao.*;
import com.fly.jdbc.*;
import java.util.*;

public class YaoDaoImpl implements IYaoDao {

	//�ײ�SqlFly����
	private SqlFly getFly() {
		return Fly.getFly();
	}

	/** ����һ����¼ */
	public int save(Yao yao) {
		String sql=" insert into Yao"
				+ "(yno,y_img,y_jj,y_sj,y_name,y_type,y_ms,y_baozhi,y_xxms,y_sccs,y_state,y_kucun) "
				+ "value (?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] args={yao.getYno(),yao.getY_img(),yao.getY_jj(),yao.getY_sj(),yao.getY_name(),yao.getY_type(),yao.getY_ms(),yao.getY_baozhi(),yao.getY_xxms(),yao.getY_sccs(),yao.getY_state(),yao.getY_kucun()};
		return getFly().getUpdate(sql, args);
	}

	/** ɾ��һ����¼(��������) */
	public int delete(int id) {
		String sql="delete from Yao where yno=?";
		Object[] args={id};
		return getFly().getUpdate(sql, args);
	}

	/** �޸�һ����¼(��������) */
	public int update(Yao yao) {
		String sql="update Yao set y_img=?,y_jj=?,y_sj=?,y_name=?,y_type=?,y_ms=?,"
				+ "y_baozhi=?,y_xxms=?,y_sccs=?,y_state=?,y_kucun=? where yno=?";
		Object[] args={yao.getY_img(),yao.getY_jj(),yao.getY_sj(),yao.getY_name(),yao.getY_type(),
				yao.getY_ms(),yao.getY_baozhi(),yao.getY_xxms(),yao.getY_sccs(),yao.getY_state(),
				yao.getY_kucun(),yao.getYno()};
		return getFly().getUpdate(sql, args);
	}

	/** ��ѯһ����¼(��������) */
	public Yao findById(String id) {
		String sql="select * from Yao where yno=?";
		Object[] args={id};
		return getFly().getModel(sql, Yao.class, args);
	}

	/** ��ѯȫ�� */
	public List<Yao> findAll() {
		String sql="select * from Yao";
		Object[] args={};
		return getFly().getList(sql, Yao.class, args);
	}

	//ָ��yid��ӿ��
	@Override
	public int doAddKucun(String yno, int num) {
		return getFly().getUpdate("update Yao set y_kucun=y_kucun+? where yno=?", num,yno);
	}


	//��ѯ[��ҳ������ģ����ָ������]
	@Override
	public List<Yao> getByTJ(Page page, String y_name, int y_type) {
		String sql="SELECT * FROM Yao " + 
				"WHERE y_name LIKE CONCAT('%',?,'%')";
		List<Object>args=Fly.doListObj(y_name);
		
		if(y_type!=0) {
			sql+=Fly.sqlAppend(" AND y_type=?", args, y_type);
		}
		
		return getFly().getPageList(page, sql, Yao.class,args.toArray());
	}
	

	
}

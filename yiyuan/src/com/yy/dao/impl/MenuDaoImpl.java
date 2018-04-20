package com.yy.dao.impl;

import com.yy.model.*;
import com.yy.util.Page;
import com.yy.dao.*;
import com.fly.jdbc.*;
import java.util.*;

public class MenuDaoImpl implements IMenuDao {

	//�ײ�SqlFly����
	private SqlFly getFly() {
		return Fly.getFly();
	}

	/** ����һ����¼ */
	public int save(Menu menu) {
		String sql=" insert into Menu(mid,text,href,myx) value (0,?,?,?)";
		Object[] args={menu.getText(),menu.getHref(),menu.getMyx()};
		return getFly().getUpdate(sql, args);
	}

	/** ɾ��һ����¼(��������) */
	public int delete(int id) {
		String sql="delete from Menu where mid=?";
		Object[] args={id};
		return getFly().getUpdate(sql, args);
	}

	/** �޸�һ����¼(��������) */
	public int update(Menu menu) {
		String sql="update Menu set text=?,href=?,myx=? where mid=?";
		Object[] args={menu.getText(),menu.getHref(),menu.getMyx(),menu.getMid()};
		return getFly().getUpdate(sql, args);
	}

	/** ��ѯһ����¼(��������) */
	public Menu findById(int id) {
		String sql="select * from Menu where mid=?";
		Object[] args={id};
		return getFly().getModel(sql, Menu.class, args);
	}

	/** ��ѯȫ�� */
	public List<Menu> findAll() {
		return getFly().getList("select * from Menu", Menu.class);
	}

	
	//��ѯ���п���(û������)�Ĳ˵�ѡ�������mid as id
	@Override
	public List<Map<String, Object>> getByKY() {
		return getFly().getListMap("select mid as id,text,href from Menu where myx=1");
	}

	//���������urlģ����ѯһ����Ӧ��menu����
	@Override
	public Menu getByURL(String url) {
		String sql="SELECT * FROM menu " + 
				"WHERE ? LIKE CONCAT('%',href,'') AND myx!=0 AND LENGTH(href)>0";
		return getFly().getModel(sql, Menu.class, url);
	}

	//����ָ����ɫid������Ȩ�޲˵����
	@Override
	public List<Integer> getByRid(int rid) {
		return getFly().getBaseList("SELECT MID FROM Jur WHERE rid=?", int.class, rid);
	}

	
	//����in��ɾ��
	@Override
	public int doDelete(String inStr) {
		getFly().beginTransaction().getUpdate("delete from Jur where mid in ("+inStr+")");
		return getFly().getUpdateCommit("delete from Menu where mid in ("+inStr+")");
	}

	//��ѯ�����ݷ�ҳ��ģ����ѯ
	@Override
	public List<Menu> getByPageMH(Page page, String text) {
		String sql="select * from Menu where text like concat('%',?,'%')";
		return getFly().getPageList(page, sql, Menu.class, text);
	}

}

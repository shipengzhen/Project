package com.yy.dao.impl;

import com.yy.model.*;
import com.yy.util.Page;
import com.yy.dao.*;
import com.fly.jdbc.*;
import java.util.*;

public class MenuDaoImpl implements IMenuDao {

	//底层SqlFly对象
	private SqlFly getFly() {
		return Fly.getFly();
	}

	/** 增加一条记录 */
	public int save(Menu menu) {
		String sql=" insert into Menu(mid,text,href,myx) value (0,?,?,?)";
		Object[] args={menu.getText(),menu.getHref(),menu.getMyx()};
		return getFly().getUpdate(sql, args);
	}

	/** 删除一条记录(根据主键) */
	public int delete(int id) {
		String sql="delete from Menu where mid=?";
		Object[] args={id};
		return getFly().getUpdate(sql, args);
	}

	/** 修改一条记录(根据主键) */
	public int update(Menu menu) {
		String sql="update Menu set text=?,href=?,myx=? where mid=?";
		Object[] args={menu.getText(),menu.getHref(),menu.getMyx(),menu.getMid()};
		return getFly().getUpdate(sql, args);
	}

	/** 查询一条记录(根据主键) */
	public Menu findById(int id) {
		String sql="select * from Menu where mid=?";
		Object[] args={id};
		return getFly().getModel(sql, Menu.class, args);
	}

	/** 查询全部 */
	public List<Menu> findAll() {
		return getFly().getList("select * from Menu", Menu.class);
	}

	
	//查询所有可用(没被禁用)的菜单选项，别名：mid as id
	@Override
	public List<Map<String, Object>> getByKY() {
		return getFly().getListMap("select mid as id,text,href from Menu where myx=1");
	}

	//根据请求的url模糊查询一个对应的menu对象
	@Override
	public Menu getByURL(String url) {
		String sql="SELECT * FROM menu " + 
				"WHERE ? LIKE CONCAT('%',href,'') AND myx!=0 AND LENGTH(href)>0";
		return getFly().getModel(sql, Menu.class, url);
	}

	//返回指定角色id的所有权限菜单项集合
	@Override
	public List<Integer> getByRid(int rid) {
		return getFly().getBaseList("SELECT MID FROM Jur WHERE rid=?", int.class, rid);
	}

	
	//根据in串删除
	@Override
	public int doDelete(String inStr) {
		getFly().beginTransaction().getUpdate("delete from Jur where mid in ("+inStr+")");
		return getFly().getUpdateCommit("delete from Menu where mid in ("+inStr+")");
	}

	//查询，根据分页，模糊查询
	@Override
	public List<Menu> getByPageMH(Page page, String text) {
		String sql="select * from Menu where text like concat('%',?,'%')";
		return getFly().getPageList(page, sql, Menu.class, text);
	}

}

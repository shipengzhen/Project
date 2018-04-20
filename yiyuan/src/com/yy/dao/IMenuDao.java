package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IMenuDao{

	/** 新增一条记录 ++ */
	public int save(Menu obj);

	/** 删除一条记录(根据主键) */
	public int delete(int id);

	/** 修改一条记录(根据主键)++ */
	public int update(Menu obj);

	/** 查询一条记录(根据主键) */
	public Menu findById(int id);

	/** 查询全部  ++ */
	public List<Menu> findAll();

	
	/**
	 * 查询所有可用(没被禁用)的菜单选项，别名：mid as id
	 */
	public List<Map<String,Object>>getByKY();

	/**
	 * 根据请求的url模糊查询一个对应的menu对象
	 */
	public Menu getByURL(String url);
	
	/**
	 * 返回指定角色id的所有权限菜单项集合
	 */
	public List<Integer>getByRid(int rid);
	
	/**
	 * 查询，根据分页，模糊查询
	 */
	public List<Menu>getByPageMH(Page page,String text);
	
	/**
	 * 根据in串删除
	 */
	public int doDelete(String inStr);
	

}

package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IUseeDao{

	/** 新增一条记录++ */
	public int save(Usee obj);

	/** 删除一条记录(根据主键)++ */
	public int delete(int id);

	/** 修改一条记录(根据主键)++ */
	public int update(Usee obj);

	/** 查询一条记录(根据主键)++ */
	public Usee findById(int id);

	/** 查询全部++ */
	public List<Usee> findAll();

	/**
	 * 根据用户昵称，查询指定人
	 */
	public Usee getByUName(String uname);
	
	/**
	 * 查询[分页、昵称模糊]
	 */
	public List<Usee>getByPageUName(Page page,String uname);
	
	/**
	 * 根据in串删除
	 */
	public int doDelete(String inStr);
	
	/**
	 * 修改密码
	 */
	public int doUpdatePwd(int uid,String password);

}

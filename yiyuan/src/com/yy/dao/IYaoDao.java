package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IYaoDao{

	/** 新增一条记录++ */
	public int save(Yao obj);

	/** 删除一条记录(根据主键) */
	public int delete(int id);

	/** 修改一条记录(根据主键)++ */
	public int update(Yao obj);

	/** 查询一条记录(根据主键)++ */
	public Yao findById(String id);

	/** 查询全部++ */
	public List<Yao> findAll();


	//
	
	/**
	 * 指定yid添加库存
	 */
	public int doAddKucun(String yno,int num);
	
	/**
	 * 查询[分页、名称模糊、指定类型]
	 */
	public List<Yao>getByTJ(Page page,String y_name,int y_type);
	
	
	
	

}

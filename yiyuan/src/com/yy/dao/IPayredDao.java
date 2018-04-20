package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IPayredDao{

	/** 新增一条记录++ */
	public int save(Payred obj);

	/** 删除一条记录(根据主键) */
	public int delete(int id);

	/** 修改一条记录(根据主键) */
	public int update(Payred obj);

	/** 查询一条记录(根据主键) */
	public Payred findById(int id);

	/** 查询全部 */
	public List<Payred> findAll();

	//
	/**
	 * 查询指定gid的所有收费登记
	 */
	public List<Payred>getByTJ(Page page,int gid);
	
	
	

}

package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IFayaoDao{

	/** 新增一条记录++ */
	public int save(Fayao obj);

	/** 删除一条记录(根据主键) */
	public int delete(int id);

	/** 修改一条记录(根据主键) */
	public int update(Fayao obj);

	/** 查询一条记录(根据主键) */
	public Fayao findById(int id);

	/** 查询全部 */
	public List<Fayao> findAll();

	
	/**
	 * 指定gid的所有在线发药记录,并分页
	 */
	public List<Fayao> getByTJ(Page page,int gid);
	
	/**
	 * 指定zid，发药num
	 */
	public int fayao(int fid,int num);
	
	
}

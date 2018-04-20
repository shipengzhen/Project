package com.yy.dao;

import com.yy.model.*;
import java.util.*;

public interface IJurDao{

	/** 新增一条记录 ++ */
	public int save(int rid,int mid);

	/** 删除一条记录(根据主键) */
	public int delete(int id);

	/** 修改一条记录(根据主键) */
	public int update(Jur obj);

	/** 查询一条记录(根据主键) */
	public Jur findById(int id);

	/** 查询全部 */
	public List<Jur> findAll();

	
	/**
	 * 删除，根据rid
	 */
	public int deleteByRid(int rid);

}

package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IRoleDao{

	/** 新增一条记录 ++ [T]*/
	public int save(Role obj,List<Integer>mids);

	/** 删除一条记录(根据主键) */
	public int delete(int id);

	/** 修改一条记录(根据主键)++ */
	public int update(Role obj,List<Integer>mids);

	/** 查询一条记录(根据主键)++ */
	public Role findById(int id);

	/** 查询全部++ */
	public List<Role> findAll();

	
	/**
	 * 查询，根据[分页、角色名称模糊查询]
	 */
	public List<Role>getByPageRName(Page page,String rname);

	/**
	 * 根据in串删除
	 * @param ids
	 * @return
	 */
	public int doDelete(String ids);

	

}

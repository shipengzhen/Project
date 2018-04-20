package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IPayDao{

	/** 新增一条记录++ */
	public int save(Pay obj);

	/** 删除一条记录(根据主键) */
	public int delete(int id);

	/** 修改一条记录(根据主键)++ */
	public int update(Pay obj);

	/** 查询一条记录(根据主键)++ */
	public Pay findById(int id);

	/** 查询全部++ */
	public List<Pay> findAll();

	//
	//查询[分页,收费项名称模糊查询]
	public List<Pay> getByTJ(Page page,String pname);


	
	
	
}

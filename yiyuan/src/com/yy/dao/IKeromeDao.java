package com.yy.dao;

import com.yy.model.*;
import java.util.*;

public interface IKeromeDao{

	/** 新增一条记录 */
	public int save(Kerome obj);

	/** 删除一条记录(根据主键) */
	public int delete(int id);

	/** 修改一条记录(根据主键) */
	public int update(Kerome obj);

	/** 查询一条记录(根据主键) */
	public Kerome findById(int id);

	/** 查询全部++ */
	public List<Kerome> findAll();



}

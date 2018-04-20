package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IGuahaoDao{

	/** 新增一条记录++ */
	public int save(Guahao obj);

	/** 删除一条记录(根据主键) */
	public int delete(int id);

	/** 修改一条记录(根据主键)++ */
	public int update(Guahao obj);

	/** 查询一条记录(根据主键)++ */
	public Guahao findById(int id);

	/** 查询全部++ */
	public List<Guahao> findAll();

	
	//
	
	/**
	 * 修改指定gid的状态
	 */
	public int doUpdateStatus(int gid,String status);
	
	/**
	 * 查询[分页、gid模糊、主治医生名字模糊、所挂科室模糊、挂号时间kai到guan]
	 */
	public List<Guahao>getByTJ(Page page,String gid,String d_zsname,String kname,String kai,String end);
	
	/**
	 * 查询[分页、gid模糊、挂号人姓名模糊]
	 */
	public List<Guahao>getByTJ2(Page page,String gid,String gname);


}

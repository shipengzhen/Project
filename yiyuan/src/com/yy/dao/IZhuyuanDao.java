package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IZhuyuanDao{

	/** 新增一条记录++ */
	public int save(Zhuyuan obj);

	/** 删除一条记录(根据主键) */
	public int delete(int id);

	/** 修改一条记录(根据主键)++ */
	public int update(Zhuyuan obj);

	/** 查询一条记录(根据主键)++ */
	public Zhuyuan findById(int id);

	/** 查询全部 */
	public List<Zhuyuan> findAll();

	
	//
	/**
	 * 查询[分页,gid模糊,主治医生模糊,科室名模糊,住院时间开始,结束]
	 */
	public List<Zhuyuan> getByTJ(Page page,String gid,String d_zsname,String kname,String kai,String end);
	
	/**
	 * 指定zid缴纳押金
	 */
	public int doAddYJ(int zid,double z_yajin);

	/**
	 * 查询[分页、gid模糊、gname模糊]
	 */
	public List<Zhuyuan>getByTJ2(Page page,String gid,String gname);
	
	/**
	 * 指定zid结算
	 */
	public int doUpdateJS(int zid);
	
	
	

}

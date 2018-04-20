package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IDoctorDao{

	/** 新增一条记录++ */
	public int save(Doctor obj);

	/** 删除一条记录(根据主键)++ */
	public int delete(int id);

	/** 修改一条记录(根据主键)++ */
	public int update(Doctor obj);

	/** 查询一条记录(根据主键)++ */
	public Doctor findById(int id);

	/** 查询全部++ */
	public List<Doctor> findAll();

	/**
	 * 查询[分页、did模糊查询、医生姓名模糊查询、所属科室名字模糊查询]
	 */
	public List<Doctor> getByTJ(Page page,String did,String d_zsname,String kname);
	
	/**
	 * 根据科室kid获取json{did,dname}
	 */
	public List<Map<String, Object>>getJsonByKid(int kid);
	
	

}

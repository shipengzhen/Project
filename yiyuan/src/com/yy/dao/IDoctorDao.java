package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IDoctorDao{

	/** ����һ����¼++ */
	public int save(Doctor obj);

	/** ɾ��һ����¼(��������)++ */
	public int delete(int id);

	/** �޸�һ����¼(��������)++ */
	public int update(Doctor obj);

	/** ��ѯһ����¼(��������)++ */
	public Doctor findById(int id);

	/** ��ѯȫ��++ */
	public List<Doctor> findAll();

	/**
	 * ��ѯ[��ҳ��didģ����ѯ��ҽ������ģ����ѯ��������������ģ����ѯ]
	 */
	public List<Doctor> getByTJ(Page page,String did,String d_zsname,String kname);
	
	/**
	 * ���ݿ���kid��ȡjson{did,dname}
	 */
	public List<Map<String, Object>>getJsonByKid(int kid);
	
	

}

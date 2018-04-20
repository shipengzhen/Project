package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IZhuyuanDao{

	/** ����һ����¼++ */
	public int save(Zhuyuan obj);

	/** ɾ��һ����¼(��������) */
	public int delete(int id);

	/** �޸�һ����¼(��������)++ */
	public int update(Zhuyuan obj);

	/** ��ѯһ����¼(��������)++ */
	public Zhuyuan findById(int id);

	/** ��ѯȫ�� */
	public List<Zhuyuan> findAll();

	
	//
	/**
	 * ��ѯ[��ҳ,gidģ��,����ҽ��ģ��,������ģ��,סԺʱ�俪ʼ,����]
	 */
	public List<Zhuyuan> getByTJ(Page page,String gid,String d_zsname,String kname,String kai,String end);
	
	/**
	 * ָ��zid����Ѻ��
	 */
	public int doAddYJ(int zid,double z_yajin);

	/**
	 * ��ѯ[��ҳ��gidģ����gnameģ��]
	 */
	public List<Zhuyuan>getByTJ2(Page page,String gid,String gname);
	
	/**
	 * ָ��zid����
	 */
	public int doUpdateJS(int zid);
	
	
	

}

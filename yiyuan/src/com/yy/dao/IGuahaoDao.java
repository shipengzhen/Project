package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IGuahaoDao{

	/** ����һ����¼++ */
	public int save(Guahao obj);

	/** ɾ��һ����¼(��������) */
	public int delete(int id);

	/** �޸�һ����¼(��������)++ */
	public int update(Guahao obj);

	/** ��ѯһ����¼(��������)++ */
	public Guahao findById(int id);

	/** ��ѯȫ��++ */
	public List<Guahao> findAll();

	
	//
	
	/**
	 * �޸�ָ��gid��״̬
	 */
	public int doUpdateStatus(int gid,String status);
	
	/**
	 * ��ѯ[��ҳ��gidģ��������ҽ������ģ�������ҿ���ģ�����Һ�ʱ��kai��guan]
	 */
	public List<Guahao>getByTJ(Page page,String gid,String d_zsname,String kname,String kai,String end);
	
	/**
	 * ��ѯ[��ҳ��gidģ�����Һ�������ģ��]
	 */
	public List<Guahao>getByTJ2(Page page,String gid,String gname);


}

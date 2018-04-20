package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IYaoDao{

	/** ����һ����¼++ */
	public int save(Yao obj);

	/** ɾ��һ����¼(��������) */
	public int delete(int id);

	/** �޸�һ����¼(��������)++ */
	public int update(Yao obj);

	/** ��ѯһ����¼(��������)++ */
	public Yao findById(String id);

	/** ��ѯȫ��++ */
	public List<Yao> findAll();


	//
	
	/**
	 * ָ��yid��ӿ��
	 */
	public int doAddKucun(String yno,int num);
	
	/**
	 * ��ѯ[��ҳ������ģ����ָ������]
	 */
	public List<Yao>getByTJ(Page page,String y_name,int y_type);
	
	
	
	

}

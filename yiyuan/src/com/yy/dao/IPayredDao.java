package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IPayredDao{

	/** ����һ����¼++ */
	public int save(Payred obj);

	/** ɾ��һ����¼(��������) */
	public int delete(int id);

	/** �޸�һ����¼(��������) */
	public int update(Payred obj);

	/** ��ѯһ����¼(��������) */
	public Payred findById(int id);

	/** ��ѯȫ�� */
	public List<Payred> findAll();

	//
	/**
	 * ��ѯָ��gid�������շѵǼ�
	 */
	public List<Payred>getByTJ(Page page,int gid);
	
	
	

}

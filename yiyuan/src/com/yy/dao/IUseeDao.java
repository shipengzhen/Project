package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IUseeDao{

	/** ����һ����¼++ */
	public int save(Usee obj);

	/** ɾ��һ����¼(��������)++ */
	public int delete(int id);

	/** �޸�һ����¼(��������)++ */
	public int update(Usee obj);

	/** ��ѯһ����¼(��������)++ */
	public Usee findById(int id);

	/** ��ѯȫ��++ */
	public List<Usee> findAll();

	/**
	 * �����û��ǳƣ���ѯָ����
	 */
	public Usee getByUName(String uname);
	
	/**
	 * ��ѯ[��ҳ���ǳ�ģ��]
	 */
	public List<Usee>getByPageUName(Page page,String uname);
	
	/**
	 * ����in��ɾ��
	 */
	public int doDelete(String inStr);
	
	/**
	 * �޸�����
	 */
	public int doUpdatePwd(int uid,String password);

}

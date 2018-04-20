package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IMenuDao{

	/** ����һ����¼ ++ */
	public int save(Menu obj);

	/** ɾ��һ����¼(��������) */
	public int delete(int id);

	/** �޸�һ����¼(��������)++ */
	public int update(Menu obj);

	/** ��ѯһ����¼(��������) */
	public Menu findById(int id);

	/** ��ѯȫ��  ++ */
	public List<Menu> findAll();

	
	/**
	 * ��ѯ���п���(û������)�Ĳ˵�ѡ�������mid as id
	 */
	public List<Map<String,Object>>getByKY();

	/**
	 * ���������urlģ����ѯһ����Ӧ��menu����
	 */
	public Menu getByURL(String url);
	
	/**
	 * ����ָ����ɫid������Ȩ�޲˵����
	 */
	public List<Integer>getByRid(int rid);
	
	/**
	 * ��ѯ�����ݷ�ҳ��ģ����ѯ
	 */
	public List<Menu>getByPageMH(Page page,String text);
	
	/**
	 * ����in��ɾ��
	 */
	public int doDelete(String inStr);
	

}

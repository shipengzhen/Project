package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IRoleDao{

	/** ����һ����¼ ++ [T]*/
	public int save(Role obj,List<Integer>mids);

	/** ɾ��һ����¼(��������) */
	public int delete(int id);

	/** �޸�һ����¼(��������)++ */
	public int update(Role obj,List<Integer>mids);

	/** ��ѯһ����¼(��������)++ */
	public Role findById(int id);

	/** ��ѯȫ��++ */
	public List<Role> findAll();

	
	/**
	 * ��ѯ������[��ҳ����ɫ����ģ����ѯ]
	 */
	public List<Role>getByPageRName(Page page,String rname);

	/**
	 * ����in��ɾ��
	 * @param ids
	 * @return
	 */
	public int doDelete(String ids);

	

}

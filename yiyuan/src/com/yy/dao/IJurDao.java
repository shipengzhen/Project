package com.yy.dao;

import com.yy.model.*;
import java.util.*;

public interface IJurDao{

	/** ����һ����¼ ++ */
	public int save(int rid,int mid);

	/** ɾ��һ����¼(��������) */
	public int delete(int id);

	/** �޸�һ����¼(��������) */
	public int update(Jur obj);

	/** ��ѯһ����¼(��������) */
	public Jur findById(int id);

	/** ��ѯȫ�� */
	public List<Jur> findAll();

	
	/**
	 * ɾ��������rid
	 */
	public int deleteByRid(int rid);

}

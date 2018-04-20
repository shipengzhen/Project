package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IFayaoDao{

	/** ����һ����¼++ */
	public int save(Fayao obj);

	/** ɾ��һ����¼(��������) */
	public int delete(int id);

	/** �޸�һ����¼(��������) */
	public int update(Fayao obj);

	/** ��ѯһ����¼(��������) */
	public Fayao findById(int id);

	/** ��ѯȫ�� */
	public List<Fayao> findAll();

	
	/**
	 * ָ��gid���������߷�ҩ��¼,����ҳ
	 */
	public List<Fayao> getByTJ(Page page,int gid);
	
	/**
	 * ָ��zid����ҩnum
	 */
	public int fayao(int fid,int num);
	
	
}

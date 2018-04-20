package com.yy.dao;

import com.yy.model.*;
import com.yy.util.Page;

import java.util.*;

public interface IPayDao{

	/** ����һ����¼++ */
	public int save(Pay obj);

	/** ɾ��һ����¼(��������) */
	public int delete(int id);

	/** �޸�һ����¼(��������)++ */
	public int update(Pay obj);

	/** ��ѯһ����¼(��������)++ */
	public Pay findById(int id);

	/** ��ѯȫ��++ */
	public List<Pay> findAll();

	//
	//��ѯ[��ҳ,�շ�������ģ����ѯ]
	public List<Pay> getByTJ(Page page,String pname);


	
	
	
}

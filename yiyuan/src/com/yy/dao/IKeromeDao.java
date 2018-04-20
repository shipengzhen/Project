package com.yy.dao;

import com.yy.model.*;
import java.util.*;

public interface IKeromeDao{

	/** ����һ����¼ */
	public int save(Kerome obj);

	/** ɾ��һ����¼(��������) */
	public int delete(int id);

	/** �޸�һ����¼(��������) */
	public int update(Kerome obj);

	/** ��ѯһ����¼(��������) */
	public Kerome findById(int id);

	/** ��ѯȫ��++ */
	public List<Kerome> findAll();



}

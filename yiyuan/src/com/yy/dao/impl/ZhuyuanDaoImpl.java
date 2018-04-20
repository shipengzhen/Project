package com.yy.dao.impl;

import com.yy.model.*;
import com.yy.util.Page;
import com.yy.dao.*;
import com.fly.jdbc.*;
import java.util.*;

public class ZhuyuanDaoImpl implements IZhuyuanDao {

	private final String selectSql = "select * from Zhuyuan ";

	// �ײ�SqlFly����
	private SqlFly getFly() {
		return Fly.getFly();
	}

	/** ����һ����¼ */
	public int save(Zhuyuan zhuyuan) {
		String sql = " insert into Zhuyuan(zid,z_huli,z_cw,z_yajin,z_zydate,z_zy_state,z_js_state,gid) value (0,?,?,?,NOW(),'��סԺ','δ����',?)";
		Object[] args = { zhuyuan.getZ_huli(), zhuyuan.getZ_cw(), zhuyuan.getZ_yajin(), zhuyuan.getGid() };
		return getFly().getUpdate(sql, args);
	}

	/** ɾ��һ����¼(��������) */
	public int delete(int id) {
		String sql = "delete from Zhuyuan where zid=?";
		Object[] args = { id };
		return getFly().getUpdate(sql, args);
	}

	/** �޸�һ����¼(��������) */
	public int update(Zhuyuan zhuyuan) {
		String sql = "update Zhuyuan set z_huli=?,z_cw=? where zid=?";
		Object[] args = { zhuyuan.getZ_huli(), zhuyuan.getZ_cw(), zhuyuan.getZid() };
		return getFly().getUpdate(sql, args);
	}

	/** ��ѯһ����¼(��������) */
	public Zhuyuan findById(int id) {
		String sql = selectSql + 
				" where zid=?";
		Object[] args = { id };
		return getFly().getModel(sql, Zhuyuan.class, args);
	}

	/** ��ѯȫ�� */
	public List<Zhuyuan> findAll() {
		String sql = "select * from Zhuyuan";
		Object[] args = {};
		return getFly().getList(sql, Zhuyuan.class, args);
	}

	//��ѯ[��ҳ,gidģ��,����ҽ��ģ��,������ģ��,סԺʱ�俪ʼ,����]
	@Override
	public List<Zhuyuan> getByTJ(Page page, String gid, String d_zsname, String kname, String kai, String end) {
		String sql=selectSql+
				"WHERE gid IN (" + 
				"	SELECT gid FROM GuaHao" + 
				"	WHERE gid LIKE CONCAT('%',?,'%') " + 
				"	AND did IN (SELECT did FROM Doctor WHERE d_zsname LIKE CONCAT('%',?,'%'))" + 
				"	AND kid IN (SELECT kid FROM KeRome WHERE kname LIKE CONCAT('%',?,'%')) " + 
				")" + 
				"AND z_zydate BETWEEN ? AND ?";
		return getFly().getPageList(page, sql, Zhuyuan.class, gid,d_zsname,kname,kai,end);
	}

	//ָ��zid����Ѻ��
	@Override
	public int doAddYJ(int zid, double z_yajin) {
		return getFly().getUpdate("update ZhuYuan set z_yajin=z_yajin+? where zid=?", z_yajin,zid);
	}

	
	//��ѯ[��ҳ��gidģ����gnameģ��]
	@Override
	public List<Zhuyuan> getByTJ2(Page page, String gid, String gname) {
		String sql=selectSql+
				"WHERE gid IN (" + 
				"	SELECT gid FROM GuaHao" + 
				"	WHERE gid LIKE CONCAT('%',?,'%') "
				+ " AND gname LIKE CONCAT('%',?,'%') " + 
				")";
		return getFly().getPageList(page, sql, Zhuyuan.class, gid,gname);
	}

	// ָ��zid����
	@Override
	public int doUpdateJS(int zid) {
		System.out.println(zid);
		String sql="update zhuyuan set z_js_state='�ѽ���' where zid=?";
		return getFly().getUpdate(sql, zid);
	}

	
	
	
	
	
}

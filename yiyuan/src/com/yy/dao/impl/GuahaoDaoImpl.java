package com.yy.dao.impl;

import com.yy.model.*;
import com.yy.util.Page;
import com.yy.dao.*;
import com.fly.jdbc.*;
import java.util.*;

public class GuahaoDaoImpl implements IGuahaoDao {

	private final String selectSql=
			"SELECT *,(SELECT kname FROM KeRome WHERE kid=GuaHao.kid) AS kname," + 
			"(SELECT d_zsname FROM Doctor WHERE did=GuaHao.did) AS d_zsname  " + 
			"FROM GuaHao ";
	
	//底层SqlFly对象
	private SqlFly getFly() {
		return Fly.getFly();
	}

	/** 增加一条记录 */
	public int save(Guahao guahao) {
		String sql=" insert into Guahao"
				+ "(gid,gname,g_card,g_shebao,g_money,g_phone,g_zifei,g_sex,g_age,g_zhiye,g_cf,g_beizhu,g_status,g_data,kid,did) "
				+ "value (0,?,?,?,?,?,?,?,?,?,?,?,?,NOW(),?,?)";
		Object[] args={guahao.getGname(),guahao.getG_card(),guahao.getG_shebao(),guahao.getG_money(),
				guahao.getG_phone(),guahao.getG_zifei(),guahao.getG_sex(),guahao.getG_age(),
				guahao.getG_zhiye(),guahao.getG_cf(),guahao.getG_beizhu(),guahao.getG_status(),guahao.getKid(),guahao.getDid()};
		return getFly().getUpdate(sql, args);
	}

	/** 删除一条记录(根据主键) */
	public int delete(int id) {
		String sql="delete from Guahao where gid=?";
		Object[] args={id};
		return getFly().getUpdate(sql, args);
	}

	/** 修改一条记录(根据主键) */
	public int update(Guahao guahao) {
		String sql="update Guahao set gname=?,g_card=?,g_shebao=?,g_money=?,g_phone=?,g_zifei=?,g_sex=?,g_age=?,g_zhiye=?,g_cf=?,g_beizhu=?,kid=?,did=? where gid=?";
		Object[] args={guahao.getGname(),guahao.getG_card(),guahao.getG_shebao(),guahao.getG_money(),guahao.getG_phone(),guahao.getG_zifei(),guahao.getG_sex(),guahao.getG_age(),guahao.getG_zhiye(),guahao.getG_cf(),guahao.getG_beizhu(),guahao.getKid(),guahao.getDid(),guahao.getGid()};
		return getFly().getUpdate(sql, args);
	}

	/** 查询一条记录(根据主键) */
	public Guahao findById(int id) {
		String sql=selectSql+"where gid=?";
		Object[] args={id};
		return getFly().getModel(sql, Guahao.class, args);
	}

	/** 查询全部 */
	public List<Guahao> findAll() {
		String sql=selectSql;
		Object[] args={};
		return getFly().getList(sql, Guahao.class, args);
	}



	//修改指定gid的状态
	@Override
	public int doUpdateStatus(int gid, String status) {
		return getFly().getUpdate("update GuaHao set g_status=? where gid=?", status,gid);
	}

	//查询[分页、gid模糊、主治医生名字模糊、所挂科室模糊、挂号时间kai到guan]
	@Override
	public List<Guahao> getByTJ(Page page, String gid, String d_zsname, String kname, String kai, String end) {
		String sql=selectSql+
				"WHERE gid LIKE CONCAT('%',?,'%') " + 
				"AND did IN (SELECT did FROM Doctor WHERE d_zsname LIKE CONCAT('%',?,'%'))" + 
				"AND kid IN (SELECT kid FROM KeRome WHERE kname LIKE CONCAT('%',?,'%')) " + 
				"AND g_data BETWEEN ? AND ?";
		return getFly().getPageList(page, sql, Guahao.class, gid,d_zsname,kname,kai,end);
	}

	
	//查询[分页、gid模糊、挂号人姓名模糊]
	@Override
	public List<Guahao> getByTJ2(Page page, String gid, String gname) {
		String sql=selectSql+
				"WHERE gid LIKE CONCAT('%',?,'%') "
				+ "and gname like concat('%',?,'%')";
		return getFly().getPageList(page, sql, Guahao.class, gid,gname);
	}
	
	
	
	
	

}

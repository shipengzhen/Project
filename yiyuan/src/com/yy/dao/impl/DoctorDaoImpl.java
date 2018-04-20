package com.yy.dao.impl;

import com.yy.model.*;
import com.yy.util.Page;
import com.yy.dao.*;
import com.fly.jdbc.*;
import java.util.*;

public class DoctorDaoImpl implements IDoctorDao {

	//底层SqlFly对象
	private SqlFly getFly() {
		return Fly.getFly();
	}

	/** 增加一条记录 */
	public int save(Doctor doctor) {
		String sql=" insert into Doctor"
				+ "(did,d_zsname,d_card,d_phone,d_zuoji,d_sex,d_csday,d_age,d_email,d_xueli,d_beizhu,kid,uid) value "
				+ "(0,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] args={doctor.getD_zsname(),doctor.getD_card(),doctor.getD_phone(),doctor.getD_zuoji(),
				doctor.getD_sex(),doctor.getD_csday(),doctor.getD_age(),doctor.getD_email(),doctor.getD_xueli(),doctor.getD_beizhu(),doctor.getKid(),doctor.getUid()};
		return getFly().getUpdate(sql, args);
	}

	/** 删除一条记录(根据主键) */
	public int delete(int id) {
		String sql="delete from Doctor where did=?";
		return getFly().getUpdate(sql, id);
	}

	/** 修改一条记录(根据主键) */
	public int update(Doctor doctor) {
		String sql="update Doctor set d_zsname=?,d_card=?,d_phone=?,d_zuoji=?,d_sex=?,d_csday=?,d_age=?,d_email=?,d_xueli=?,d_beizhu=?,kid=?,uid=? where did=?";
		Object[] args={doctor.getD_zsname(),doctor.getD_card(),doctor.getD_phone(),doctor.getD_zuoji(),doctor.getD_sex(),doctor.getD_csday(),doctor.getD_age(),doctor.getD_email(),doctor.getD_xueli(),doctor.getD_beizhu(),doctor.getKid(),doctor.getUid(),doctor.getDid()};
		return getFly().getUpdate(sql, args);
	}

	/** 查询一条记录(根据主键) */
	public Doctor findById(int id) {
		String sql="select *,(select kname from KeRome where kid=Doctor.kid) as kname from Doctor where did=?";
		Object[] args={id};
		return getFly().getModel(sql, Doctor.class, args);
	}

	/** 查询全部 */
	public List<Doctor> findAll() {
		String sql="select *,(select kname from KeRome where kid=Doctor.kid) as kname from Doctor";
		return getFly().getList(sql, Doctor.class);
	}

	//查询[分页、did模糊查询、医生姓名模糊查询、所属科室名字模糊查询]
	@Override
	public List<Doctor> getByTJ(Page page,String did,String d_zsname,String kname) {
		String sql="SELECT *,(SELECT kname FROM KeRome WHERE kid=Doctor.kid) AS kname " + 
				"FROM Doctor " + 
				"WHERE did LIKE CONCAT('%',?,'%') AND d_zsname LIKE CONCAT('%',?,'%') " + 
				"AND kid IN (" + 
				"	SELECT kid FROM KeRome WHERE kname LIKE CONCAT('%',?,'%') " + 
				")";
		return getFly().getPageList(page, sql, Doctor.class, did,d_zsname,kname);
	}

	
	//根据科室kid获取json{did,dname}
	@Override
	public List<Map<String, Object>> getJsonByKid(int kid) {
		return getFly().getListMap("select did,d_zsname from Doctor where kid=?", kid);
	}



}

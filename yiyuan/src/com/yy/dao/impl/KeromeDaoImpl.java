package com.yy.dao.impl;

import com.yy.model.*;
import com.yy.dao.*;
import com.fly.jdbc.*;
import java.util.*;

public class KeromeDaoImpl implements IKeromeDao {

	//底层SqlFly对象
	private SqlFly getFly() {
		return Fly.getFly();
	}

	/** 增加一条记录 */
	public int save(Kerome kerome) {
		String sql=" insert into Kerome(kid,kname) value (?,?)";
		Object[] args={kerome.getKid(),kerome.getKname()};
		return getFly().getUpdate(sql, args);
	}

	/** 删除一条记录(根据主键) */
	public int delete(int id) {
		String sql="delete from Kerome where kid=?";
		Object[] args={id};
		return getFly().getUpdate(sql, args);
	}

	/** 修改一条记录(根据主键) */
	public int update(Kerome kerome) {
		String sql="update Kerome set kname=? where kid=?";
		Object[] args={kerome.getKname(),kerome.getKid()};
		return getFly().getUpdate(sql, args);
	}

	/** 查询一条记录(根据主键) */
	public Kerome findById(int id) {
		String sql="select * from Kerome where kid=?";
		Object[] args={id};
		return getFly().getModel(sql, Kerome.class, args);
	}

	/** 查询全部 */
	public List<Kerome> findAll() {
		String sql="select * from Kerome";
		Object[] args={};
		return getFly().getList(sql, Kerome.class, args);
	}



}

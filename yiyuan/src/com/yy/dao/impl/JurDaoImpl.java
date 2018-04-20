package com.yy.dao.impl;

import com.yy.model.*;
import com.yy.dao.*;
import com.fly.jdbc.*;
import java.util.*;

public class JurDaoImpl implements IJurDao {

	//底层SqlFly对象
	private SqlFly getFly() {
		return Fly.getFly();
	}

	/** 增加一条记录 */
	public int save(int rid,int mid) {
		String sql=" insert into Jur(Jid,rid,mid) value (0,?,?)";
		Object[] args={rid,mid};
		return getFly().getUpdate(sql, args);
	}

	/** 删除一条记录(根据主键) */
	public int delete(int id) {
		String sql="delete from Jur where Jid=?";
		Object[] args={id};
		return getFly().getUpdate(sql, args);
	}

	/** 修改一条记录(根据主键) */
	public int update(Jur jur) {
		String sql="update Jur set rid=?,mid=? where Jid=?";
		Object[] args={jur.getRid(),jur.getMid(),jur.getJid()};
		return getFly().getUpdate(sql, args);
	}

	/** 查询一条记录(根据主键) */
	public Jur findById(int id) {
		String sql="select * from Jur where Jid=?";
		Object[] args={id};
		return getFly().getModel(sql, Jur.class, args);
	}

	/** 查询全部 */
	public List<Jur> findAll() {
		String sql="select * from Jur";
		Object[] args={};
		return getFly().getList(sql, Jur.class, args);
	}

	
	//删除，根据rid
	@Override
	public int deleteByRid(int rid) {
		return getFly().getUpdate("delete from Jur where rid=?", rid);
	}



}

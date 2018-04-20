package com.yy.dao.impl;

import com.yy.model.*;
import com.yy.util.Page;
import com.yy.dao.*;
import com.fly.jdbc.*;
import java.util.*;

public class PayDaoImpl implements IPayDao {

	//底层SqlFly对象
	private SqlFly getFly() {
		return Fly.getFly();
	}

	/** 增加一条记录 */
	public int save(Pay pay) {
		String sql=" insert into Pay(pid,pname,pmoney,pdate) value (0,?,?,NOW())";
		Object[] args={pay.getPname(),pay.getPmoney()};
		return getFly().getUpdate(sql, args);
	}

	/** 删除一条记录(根据主键) */
	public int delete(int id) {
		String sql="delete from Pay where pid=?";
		Object[] args={id};
		return getFly().getUpdate(sql, args);
	}

	/** 修改一条记录(根据主键) */
	public int update(Pay pay) {
		String sql="update Pay set pname=?,pmoney=?,pdate=? where pid=?";
		Object[] args={pay.getPname(),pay.getPmoney(),pay.getPdate(),pay.getPid()};
		return getFly().getUpdate(sql, args);
	}

	/** 查询一条记录(根据主键) */
	public Pay findById(int id) {
		String sql="select * from Pay where pid=?";
		Object[] args={id};
		return getFly().getModel(sql, Pay.class, args);
	}

	/** 查询全部 */
	public List<Pay> findAll() {
		String sql="select * from Pay";
		Object[] args={};
		return getFly().getList(sql, Pay.class, args);
	}

	//查询[分页,收费项名称模糊查询]
	@Override
	public List<Pay> getByTJ(Page page, String pname) {
		String sql="select * from Pay where pname like concat('%',?,'%')";
		return getFly().getPageList(page, sql, Pay.class, pname);
	}

	
	
	
	


}

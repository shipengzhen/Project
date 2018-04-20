package com.yy.dao.impl;

import com.yy.model.*;
import com.yy.util.Page;
import com.yy.dao.*;
import com.fly.jdbc.*;
import java.util.*;

public class RoleDaoImpl implements IRoleDao {

	//底层SqlFly对象
	private SqlFly getFly() {
		return Fly.getFly();
	}

	/** 增加一条记录 ++[T] */
	public int save(Role role,List<Integer>mids) {
		String sql="insert into Role(rid,rname,rstate) value (0,?,?)";
		Object[] args={role.getRname(),role.getRstate()};
		getFly().beginTransaction().getUpdate(sql, args);
		
		int rid=getFly().getScalarInt("SELECT @@IDENTITY;");
		if(mids!=null) {
			for (int mid : mids) {
				FC.getIJurDao().save(rid,mid);
			}
		}
		getFly().commit();
		
		return 1;
	}

	/** 删除一条记录(根据主键) */
	public int delete(int id) {
		String sql="delete from Role where rid=?";
		Object[] args={id};
		return getFly().getUpdate(sql, args);
	}

	/** 修改一条记录(根据主键) */
	public int update(Role role,List<Integer>mids) {
		String sql="update Role set rname=?,rstate=? where rid=?";
		Object[] args={role.getRname(),role.getRstate(),role.getRid()};
		getFly().beginTransaction().getUpdate(sql, args);	//修改信息
		
		FC.getIJurDao().deleteByRid(role.getRid());	//删除此rid掌握所有资源
		if(mids!=null) {
			for (int mid : mids) {
				FC.getIJurDao().save(role.getRid(),mid);	//然后再添加资源
			}
		}
		getFly().commit();
		return 1;
	}

	/** 查询一条记录(根据主键) */
	public Role findById(int id) {
		String sql="select * from Role where rid=?";
		Object[] args={id};
		return getFly().getModel(sql, Role.class, args);
	}

	/** 查询全部 */
	public List<Role> findAll() {
		String sql="select * from Role";
		Object[] args={};
		return getFly().getList(sql, Role.class, args);
	}

	
	// 查询，根据[分页、角色名称模糊查询]
	@Override
	public List<Role> getByPageRName(Page page, String rname) {
		String sql="select * from Role where rname like concat('%',?,'%')";
		return getFly().getPageList(page, sql, Role.class, rname);
	}

	
	//根据in串删除
	@Override
	public int doDelete(String ids) {
		getFly().beginTransaction().getUpdate("delete from Jur where rid in ("+ids+")");	//删角色资源对应表数据
		getFly().getUpdate("UPDATE usee SET rid=NULL WHERE rid in ("+ids+")");				//改Usee表此角色用户外键
		return getFly().getUpdateCommit("delete from Role where rid in ("+ids+")");		//删除此角色
	}

	

	

}

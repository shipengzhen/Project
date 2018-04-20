package com.yy.dao.impl;

import com.yy.model.*;
import com.yy.util.Page;
import com.yy.dao.*;
import com.fly.jdbc.*;
import java.util.*;

public class FayaoDaoImpl implements IFayaoDao {

	//底层SqlFly对象
	private SqlFly getFly() {
		return Fly.getFly();
	}

	/** 增加一条记录 */
	public int save(Fayao fayao) {
		String sql=" insert into Fayao(fid,gid,yno,f_num,f_ynum,f_wnum) value (0,?,?,?,?,?)";
		Object[] args={fayao.getGid(),fayao.getYno(),fayao.getF_num(),0,fayao.getF_num()};
		return getFly().getUpdate(sql, args);
	}

	/** 删除一条记录(根据主键) */
	public int delete(int id) {
		String sql="delete from Fayao where fid=?";
		Object[] args={id};
		return getFly().getUpdate(sql, args);
	}

	/** 修改一条记录(根据主键) */
	public int update(Fayao fayao) {
		String sql="update Fayao set gid=?,yno=?,f_num=?,f_ynum=?,f_wnum=? where fid=?";
		Object[] args={fayao.getGid(),fayao.getYno(),fayao.getF_num(),fayao.getF_ynum(),fayao.getF_wnum(),fayao.getFid()};
		return getFly().getUpdate(sql, args);
	}

	/** 查询一条记录(根据主键) */
	public Fayao findById(int id) {
		String sql="select * from Fayao where fid=?";
		Object[] args={id};
		return getFly().getModel(sql, Fayao.class, args);
	}

	/** 查询全部 */
	public List<Fayao> findAll() {
		String sql="select * from Fayao";
		Object[] args={};
		return getFly().getList(sql, Fayao.class, args);
	}

	
	//指定gid的所有在线发药记录
	@Override
	public List<Fayao> getByTJ(Page page,int gid) {
		String sql="select *,(select y_name from Yao where yno=FaYao.yno) as y_name "
				+ "from FaYao where gid=?";
		return getFly().getPageList(page, sql, Fayao.class,gid);
	}

	//指定zid，发药num
	@Override
	public int fayao(int fid, int num) {
		String sql="update fayao set f_wnum=f_wnum-?,f_ynum=f_ynum+? where fid=? and f_wnum>=?";
		return getFly().getUpdate(sql, num,num,fid,num);
	}

	
	
	
	


}

package com.yy.model;

import java.sql.*;

/**
 * @author kong
 *
 */
public class Payred{

	private int prid;		//ID号，主键，自增
	private Timestamp pdate;		//收费日期
	private int gid;		//病历号ID，外键
	private int pid;		//收费项目ID，外键

	/**
	 * @return ID号，主键，自增
	 */
	public int getPrid(){
		return prid;
	}
	/**
	 * @param prid ID号，主键，自增
	 */
	public Payred setPrid(int prid) {
		this.prid=prid;
		return this;
	}
	/**
	 * @return 收费日期
	 */
	public Timestamp getPdate(){
		return pdate;
	}
	/**
	 * @param pdate 收费日期
	 */
	public Payred setPdate(Timestamp pdate) {
		this.pdate=pdate;
		return this;
	}
	/**
	 * @return 病历号ID，外键
	 */
	public int getGid(){
		return gid;
	}
	/**
	 * @param gid 病历号ID，外键
	 */
	public Payred setGid(int gid) {
		this.gid=gid;
		return this;
	}
	/**
	 * @return 收费项目ID，外键
	 */
	public int getPid(){
		return pid;
	}
	/**
	 * @param pid 收费项目ID，外键
	 */
	public Payred setPid(int pid) {
		this.pid=pid;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Payred [prid=" + prid + 
				" ,pdate=" + pdate + 
				" ,gid=" + gid + 
				" ,pid=" + pid + "]";
	}

	//额外字段
	private String pname;	//收费项名字

	/**
	 * 收费项名字
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * 收费项名字
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
	
	

}

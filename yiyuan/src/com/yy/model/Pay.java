package com.yy.model;

import java.sql.*;

public class Pay{

	private int pid;		//ID号，主键，自增
	private String pname;		//收费项名称
	private double pmoney;		//收费金额
	private Timestamp pdate;		//创建日期

	/**
	 * @return ID号，主键，自增
	 */
	public int getPid(){
		return pid;
	}
	/**
	 * @param pid ID号，主键，自增
	 */
	public Pay setPid(int pid) {
		this.pid=pid;
		return this;
	}
	/**
	 * @return 收费项名称
	 */
	public String getPname(){
		return pname;
	}
	/**
	 * @param pname 收费项名称
	 */
	public Pay setPname(String pname) {
		this.pname=pname;
		return this;
	}
	/**
	 * @return 收费金额
	 */
	public double getPmoney(){
		return pmoney;
	}
	/**
	 * @param pmoney 收费金额
	 */
	public Pay setPmoney(double pmoney) {
		this.pmoney=pmoney;
		return this;
	}
	/**
	 * @return 创建日期
	 */
	public Timestamp getPdate(){
		return pdate;
	}
	/**
	 * @param pdate 创建日期
	 */
	public Pay setPdate(Timestamp pdate) {
		this.pdate=pdate;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pay [pid=" + pid + 
				" ,pname=" + pname + 
				" ,pmoney=" + pmoney + 
				" ,pdate=" + pdate + "]";
	}


}

package com.yy.model;

import java.sql.*;

public class Pay{

	private int pid;		//ID�ţ�����������
	private String pname;		//�շ�������
	private double pmoney;		//�շѽ��
	private Timestamp pdate;		//��������

	/**
	 * @return ID�ţ�����������
	 */
	public int getPid(){
		return pid;
	}
	/**
	 * @param pid ID�ţ�����������
	 */
	public Pay setPid(int pid) {
		this.pid=pid;
		return this;
	}
	/**
	 * @return �շ�������
	 */
	public String getPname(){
		return pname;
	}
	/**
	 * @param pname �շ�������
	 */
	public Pay setPname(String pname) {
		this.pname=pname;
		return this;
	}
	/**
	 * @return �շѽ��
	 */
	public double getPmoney(){
		return pmoney;
	}
	/**
	 * @param pmoney �շѽ��
	 */
	public Pay setPmoney(double pmoney) {
		this.pmoney=pmoney;
		return this;
	}
	/**
	 * @return ��������
	 */
	public Timestamp getPdate(){
		return pdate;
	}
	/**
	 * @param pdate ��������
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

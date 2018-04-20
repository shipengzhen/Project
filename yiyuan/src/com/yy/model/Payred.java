package com.yy.model;

import java.sql.*;

/**
 * @author kong
 *
 */
public class Payred{

	private int prid;		//ID�ţ�����������
	private Timestamp pdate;		//�շ�����
	private int gid;		//������ID�����
	private int pid;		//�շ���ĿID�����

	/**
	 * @return ID�ţ�����������
	 */
	public int getPrid(){
		return prid;
	}
	/**
	 * @param prid ID�ţ�����������
	 */
	public Payred setPrid(int prid) {
		this.prid=prid;
		return this;
	}
	/**
	 * @return �շ�����
	 */
	public Timestamp getPdate(){
		return pdate;
	}
	/**
	 * @param pdate �շ�����
	 */
	public Payred setPdate(Timestamp pdate) {
		this.pdate=pdate;
		return this;
	}
	/**
	 * @return ������ID�����
	 */
	public int getGid(){
		return gid;
	}
	/**
	 * @param gid ������ID�����
	 */
	public Payred setGid(int gid) {
		this.gid=gid;
		return this;
	}
	/**
	 * @return �շ���ĿID�����
	 */
	public int getPid(){
		return pid;
	}
	/**
	 * @param pid �շ���ĿID�����
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

	//�����ֶ�
	private String pname;	//�շ�������

	/**
	 * �շ�������
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * �շ�������
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
	
	

}

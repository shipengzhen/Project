package com.yy.model;

import com.fly.jdbc.AtFly;

public class Usee{

	private int uid;		//�û�ID - ����,����1000,1 
	private String uname;		//��¼�ǳ� - Ψһ 
	private String password;		//����
	private int ustate;		//�˺�״̬ -> 1����,0����
	private String uzsname;		//��ʵ����
	private String uemail;		//����
	private int rid;		//������ɫID�����

	/**
	 * @return �û�ID - ����,����1000,1 
	 */
	public int getUid(){
		return uid;
	}
	/**
	 * @param uid �û�ID - ����,����1000,1 
	 */
	public Usee setUid(int uid) {
		this.uid=uid;
		return this;
	}
	/**
	 * @return ��¼�ǳ� - Ψһ 
	 */
	public String getUname(){
		return uname;
	}
	/**
	 * @param uname ��¼�ǳ� - Ψһ 
	 */
	public Usee setUname(String uname) {
		this.uname=uname;
		return this;
	}
	/**
	 * @return ����
	 */
	public String getPassword(){
		return password;
	}
	/**
	 * @param password ����
	 */
	public Usee setPassword(String password) {
		this.password=password;
		return this;
	}
	/**
	 * @return �˺�״̬ -> 1����,0����
	 */
	public int getUstate(){
		return ustate;
	}
	/**
	 * @param ustate �˺�״̬ -> 1����,0����
	 */
	public Usee setUstate(int ustate) {
		this.ustate=ustate;
		return this;
	}
	/**
	 * @return ��ʵ����
	 */
	public String getUzsname(){
		return uzsname;
	}
	/**
	 * @param uzsname ��ʵ����
	 */
	public Usee setUzsname(String uzsname) {
		this.uzsname=uzsname;
		return this;
	}
	/**
	 * @return ����
	 */
	public String getUemail(){
		return uemail;
	}
	/**
	 * @param uemail ����
	 */
	public Usee setUemail(String uemail) {
		this.uemail=uemail;
		return this;
	}
	/**
	 * @return ������ɫID�����
	 */
	public int getRid(){
		return rid;
	}
	/**
	 * @param rid ������ɫID�����
	 */
	public Usee setRid(int rid) {
		this.rid=rid;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usee [uid=" + uid + 
				" ,uname=" + uname + 
				" ,password=" + password + 
				" ,ustate=" + ustate + 
				" ,uzsname=" + uzsname + 
				" ,uemail=" + uemail + 
				" ,rid=" + rid + "]";
	}

	
	//�����ֶ�
	@AtFly(set="pojo")
	public Role role;	//��ɫ����

	/**
	 * @return ��ɫ����
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role ��ɫ����
	 */
	public void setRole(Role role) {
		this.role = role;
	}
		

}

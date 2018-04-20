package com.yy.model;

import com.fly.jdbc.AtFly;

public class Usee{

	private int uid;		//用户ID - 主键,自增1000,1 
	private String uname;		//登录昵称 - 唯一 
	private String password;		//密码
	private int ustate;		//账号状态 -> 1正常,0禁用
	private String uzsname;		//真实姓名
	private String uemail;		//邮箱
	private int rid;		//所属角色ID，外键

	/**
	 * @return 用户ID - 主键,自增1000,1 
	 */
	public int getUid(){
		return uid;
	}
	/**
	 * @param uid 用户ID - 主键,自增1000,1 
	 */
	public Usee setUid(int uid) {
		this.uid=uid;
		return this;
	}
	/**
	 * @return 登录昵称 - 唯一 
	 */
	public String getUname(){
		return uname;
	}
	/**
	 * @param uname 登录昵称 - 唯一 
	 */
	public Usee setUname(String uname) {
		this.uname=uname;
		return this;
	}
	/**
	 * @return 密码
	 */
	public String getPassword(){
		return password;
	}
	/**
	 * @param password 密码
	 */
	public Usee setPassword(String password) {
		this.password=password;
		return this;
	}
	/**
	 * @return 账号状态 -> 1正常,0禁用
	 */
	public int getUstate(){
		return ustate;
	}
	/**
	 * @param ustate 账号状态 -> 1正常,0禁用
	 */
	public Usee setUstate(int ustate) {
		this.ustate=ustate;
		return this;
	}
	/**
	 * @return 真实姓名
	 */
	public String getUzsname(){
		return uzsname;
	}
	/**
	 * @param uzsname 真实姓名
	 */
	public Usee setUzsname(String uzsname) {
		this.uzsname=uzsname;
		return this;
	}
	/**
	 * @return 邮箱
	 */
	public String getUemail(){
		return uemail;
	}
	/**
	 * @param uemail 邮箱
	 */
	public Usee setUemail(String uemail) {
		this.uemail=uemail;
		return this;
	}
	/**
	 * @return 所属角色ID，外键
	 */
	public int getRid(){
		return rid;
	}
	/**
	 * @param rid 所属角色ID，外键
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

	
	//额外字段
	@AtFly(set="pojo")
	public Role role;	//角色对象

	/**
	 * @return 角色对象
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role 角色对象
	 */
	public void setRole(Role role) {
		this.role = role;
	}
		

}

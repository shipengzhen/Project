package com.yy.model;

import java.sql.*;

public class Doctor{

	private int did;		//医生编号 - 主键，自增(1000,1)
	private String d_zsname;		//医生姓名 - 唯一
	private String d_card;		//身份证号
	private String d_phone;		//手机号
	private String d_zuoji;		//座机
	private String d_sex;		//性别
	private Timestamp d_csday;		//出生年月日
	private int d_age;		//年龄
	private String d_email;		//电子邮箱
	private String d_xueli;		//学历
	private String d_beizhu;		//备注
	private int kid;		//所属科室id，外键
	private int uid;		//所属user账号ID，外键

	/**
	 * @return 医生编号 - 主键，自增(1000,1)
	 */
	public int getDid(){
		return did;
	}
	/**
	 * @param did 医生编号 - 主键，自增(1000,1)
	 */
	public Doctor setDid(int did) {
		this.did=did;
		return this;
	}
	/**
	 * @return 医生姓名 - 唯一
	 */
	public String getD_zsname(){
		return d_zsname;
	}
	/**
	 * @param d_zsname 医生姓名 - 唯一
	 */
	public Doctor setD_zsname(String d_zsname) {
		this.d_zsname=d_zsname;
		return this;
	}
	/**
	 * @return 身份证号
	 */
	public String getD_card(){
		return d_card;
	}
	/**
	 * @param d_card 身份证号
	 */
	public Doctor setD_card(String d_card) {
		this.d_card=d_card;
		return this;
	}
	/**
	 * @return 手机号
	 */
	public String getD_phone(){
		return d_phone;
	}
	/**
	 * @param d_phone 手机号
	 */
	public Doctor setD_phone(String d_phone) {
		this.d_phone=d_phone;
		return this;
	}
	/**
	 * @return 座机
	 */
	public String getD_zuoji(){
		return d_zuoji;
	}
	/**
	 * @param d_zuoji 座机
	 */
	public Doctor setD_zuoji(String d_zuoji) {
		this.d_zuoji=d_zuoji;
		return this;
	}
	/**
	 * @return 性别
	 */
	public String getD_sex(){
		return d_sex;
	}
	/**
	 * @param d_sex 性别
	 */
	public Doctor setD_sex(String d_sex) {
		this.d_sex=d_sex;
		return this;
	}
	/**
	 * @return 出生年月日
	 */
	public Timestamp getD_csday(){
		return d_csday;
	}
	/**
	 * @param d_csday 出生年月日
	 */
	public Doctor setD_csday(Timestamp d_csday) {
		this.d_csday=d_csday;
		return this;
	}
	/**
	 * @return 年龄
	 */
	public int getD_age(){
		return d_age;
	}
	/**
	 * @param d_age 年龄
	 */
	public Doctor setD_age(int d_age) {
		this.d_age=d_age;
		return this;
	}
	/**
	 * @return 电子邮箱
	 */
	public String getD_email(){
		return d_email;
	}
	/**
	 * @param d_email 电子邮箱
	 */
	public Doctor setD_email(String d_email) {
		this.d_email=d_email;
		return this;
	}
	/**
	 * @return 学历
	 */
	public String getD_xueli(){
		return d_xueli;
	}
	/**
	 * @param d_xueli 学历
	 */
	public Doctor setD_xueli(String d_xueli) {
		this.d_xueli=d_xueli;
		return this;
	}
	/**
	 * @return 备注
	 */
	public String getD_beizhu(){
		return d_beizhu;
	}
	/**
	 * @param d_beizhu 备注
	 */
	public Doctor setD_beizhu(String d_beizhu) {
		this.d_beizhu=d_beizhu;
		return this;
	}
	/**
	 * @return 所属科室id，外键
	 */
	public int getKid(){
		return kid;
	}
	/**
	 * @param kid 所属科室id，外键
	 */
	public Doctor setKid(int kid) {
		this.kid=kid;
		return this;
	}
	/**
	 * @return 所属user账号ID，外键
	 */
	public int getUid(){
		return uid;
	}
	/**
	 * @param uid 所属user账号ID，外键
	 */
	public Doctor setUid(int uid) {
		this.uid=uid;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Doctor [did=" + did + 
				" ,d_zsname=" + d_zsname + 
				" ,d_card=" + d_card + 
				" ,d_phone=" + d_phone + 
				" ,d_zuoji=" + d_zuoji + 
				" ,d_sex=" + d_sex + 
				" ,d_csday=" + d_csday + 
				" ,d_age=" + d_age + 
				" ,d_email=" + d_email + 
				" ,d_xueli=" + d_xueli + 
				" ,d_beizhu=" + d_beizhu + 
				" ,kid=" + kid + 
				" ,uid=" + uid + "]";
	}

	//额外字段
	public String kname;	//所属科室名称

	/**
	 * @return 所属科室名称
	 */
	public String getKname() {
		return kname;
	}
	/**
	 * @param kname 所属科室名称
	 */
	public void setKname(String kname) {
		this.kname = kname;
	}

	
	

}

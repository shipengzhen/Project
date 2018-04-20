package com.yy.model;

import java.sql.Timestamp;

public class Guahao{

	private int gid;		//ID号，主键，自增(1001)
	private String gname;		//挂号人姓名
	private String g_card;		//身份证号
	private String g_shebao;		//社保号
	private double g_money;		//挂号费
	private String g_phone;		//联系电话
	private int g_zifei;		//是否自费 - 1是 2否
	private String g_sex;		//性别
	private int g_age;		//年龄
	private String g_zhiye;		//职业
	private int g_cf;		//初诊还是复诊,1初 2复
	private String g_beizhu;		//备注
	private String g_status;		//挂号状态(已挂号,已住院,已出院,已退号)
	private Timestamp g_data;		//挂号日期
	private int kid;		//所挂科室ID，外键
	private int did;		//主治医生ID

	/**
	 * @return ID号，主键，自增(1001)
	 */
	public int getGid(){
		return gid;
	}
	/**
	 * @param gid ID号，主键，自增(1001)
	 */
	public Guahao setGid(int gid) {
		this.gid=gid;
		return this;
	}
	/**
	 * @return 挂号人姓名
	 */
	public String getGname(){
		return gname;
	}
	/**
	 * @param gname 挂号人姓名
	 */
	public Guahao setGname(String gname) {
		this.gname=gname;
		return this;
	}
	/**
	 * @return 身份证号
	 */
	public String getG_card(){
		return g_card;
	}
	/**
	 * @param g_card 身份证号
	 */
	public Guahao setG_card(String g_card) {
		this.g_card=g_card;
		return this;
	}
	/**
	 * @return 社保号
	 */
	public String getG_shebao(){
		return g_shebao;
	}
	/**
	 * @param g_shebao 社保号
	 */
	public Guahao setG_shebao(String g_shebao) {
		this.g_shebao=g_shebao;
		return this;
	}
	/**
	 * @return 挂号费
	 */
	public double getG_money(){
		return g_money;
	}
	/**
	 * @param g_money 挂号费
	 */
	public Guahao setG_money(double g_money) {
		this.g_money=g_money;
		return this;
	}
	/**
	 * @return 联系电话
	 */
	public String getG_phone(){
		return g_phone;
	}
	/**
	 * @param g_phone 联系电话
	 */
	public Guahao setG_phone(String g_phone) {
		this.g_phone=g_phone;
		return this;
	}
	/**
	 * @return 是否自费 - 1是 2否
	 */
	public int getG_zifei(){
		return g_zifei;
	}
	/**
	 * @param g_zifei 是否自费 - 1是 2否
	 */
	public Guahao setG_zifei(int g_zifei) {
		this.g_zifei=g_zifei;
		return this;
	}
	/**
	 * @return 性别
	 */
	public String getG_sex(){
		return g_sex;
	}
	/**
	 * @param g_sex 性别
	 */
	public Guahao setG_sex(String g_sex) {
		this.g_sex=g_sex;
		return this;
	}
	/**
	 * @return 年龄
	 */
	public int getG_age(){
		return g_age;
	}
	/**
	 * @param g_age 年龄
	 */
	public Guahao setG_age(int g_age) {
		this.g_age=g_age;
		return this;
	}
	/**
	 * @return 职业
	 */
	public String getG_zhiye(){
		return g_zhiye;
	}
	/**
	 * @param g_zhiye 职业
	 */
	public Guahao setG_zhiye(String g_zhiye) {
		this.g_zhiye=g_zhiye;
		return this;
	}
	/**
	 * @return 初诊还是复诊,1初 2复
	 */
	public int getG_cf(){
		return g_cf;
	}
	/**
	 * @param g_cf 初诊还是复诊,1初 2复
	 */
	public Guahao setG_cf(int g_cf) {
		this.g_cf=g_cf;
		return this;
	}
	/**
	 * @return 备注
	 */
	public String getG_beizhu(){
		return g_beizhu;
	}
	/**
	 * @param g_beizhu 备注
	 */
	public Guahao setG_beizhu(String g_beizhu) {
		this.g_beizhu=g_beizhu;
		return this;
	}
	/**
	 * @return 所挂科室ID，外键
	 */
	public int getKid(){
		return kid;
	}
	/**
	 * @param kid 所挂科室ID，外键
	 */
	public Guahao setKid(int kid) {
		this.kid=kid;
		return this;
	}
	/**
	 * @return 主治医生ID
	 */
	public int getDid(){
		return did;
	}
	/**
	 * @param did 主治医生ID
	 */
	public Guahao setDid(int did) {
		this.did=did;
		return this;
	}
	/**
	 * @return the 挂号状态(已挂号,已住院,已出院,已退号)
	 */
	public String getG_status() {
		return g_status;
	}
	/**
	 * @param 挂号状态(已挂号,已住院,已出院,已退号)
	 */
	public void setG_status(String g_status) {
		this.g_status = g_status;
	}
	/**
	 * @return 挂号日期
	 */
	public Timestamp getG_data() {
		return g_data;
	}
	/**
	 * @param 挂号日期
	 */
	public void setG_data(Timestamp g_data) {
		this.g_data = g_data;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Guahao [gid=" + gid + 
				" ,gname=" + gname + 
				" ,g_card=" + g_card + 
				" ,g_shebao=" + g_shebao + 
				" ,g_money=" + g_money + 
				" ,g_phone=" + g_phone + 
				" ,g_zifei=" + g_zifei + 
				" ,g_sex=" + g_sex + 
				" ,g_age=" + g_age + 
				" ,g_zhiye=" + g_zhiye + 
				" ,g_cf=" + g_cf + 
				" ,g_beizhu=" + g_beizhu + 
				" ,kid=" + kid + 
				" ,did=" + did + "]";
	}

	
	//额外字段
	private String kname;	//所挂科室名字快
	private String d_zsname;	//主治医生名字

	/**
	 * @return 所挂科室名字快
	 */
	public String getKname() {
		return kname;
	}
	/**
	 * @param 所挂科室名字快
	 */
	public void setKname(String kname) {
		this.kname = kname;
	}
	/**
	 * @return 主治医生名字
	 */
	public String getD_zsname() {
		return d_zsname;
	}
	/**
	 * @param 主治医生名字
	 */
	public void setD_zsname(String d_zsname) {
		this.d_zsname = d_zsname;
	}
	
	

}

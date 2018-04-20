package com.yy.model;

public class Yao{

	private String yno;		//药品编号,自定义编号，主键
	private String y_img;		//药品图片名称
	private double y_jj;		//进价
	private double y_sj;		//售价
	private String y_name;		//药品名称
	private int y_type;		//药品类型(1-处方药，2-中药，3-西药)
	private String y_ms;		//简单描述
	private int y_baozhi;		//保质期,单位/月
	private String y_xxms;		//详细描述
	private String y_sccs;		//生产厂商
	private String y_state;		//药品状态(销售中,维护中)
	private int y_kucun;		//库存

	/**
	 * @return 药品编号,自定义编号，主键
	 */
	public String getYno(){
		return yno;
	}
	/**
	 * @param yno 药品编号,自定义编号，主键
	 */
	public Yao setYno(String yno) {
		this.yno=yno;
		return this;
	}
	/**
	 * @return 药品图片名称
	 */
	public String getY_img(){
		return y_img;
	}
	/**
	 * @param y_img 药品图片名称
	 */
	public Yao setY_img(String y_img) {
		this.y_img=y_img;
		return this;
	}
	/**
	 * @return 进价
	 */
	public double getY_jj(){
		return y_jj;
	}
	/**
	 * @param y_jj 进价
	 */
	public Yao setY_jj(double y_jj) {
		this.y_jj=y_jj;
		return this;
	}
	/**
	 * @return 售价
	 */
	public double getY_sj(){
		return y_sj;
	}
	/**
	 * @param y_sj 售价
	 */
	public Yao setY_sj(double y_sj) {
		this.y_sj=y_sj;
		return this;
	}
	/**
	 * @return 药品名称
	 */
	public String getY_name(){
		return y_name;
	}
	/**
	 * @param y_name 药品名称
	 */
	public Yao setY_name(String y_name) {
		this.y_name=y_name;
		return this;
	}
	/**
	 * @return 药品类型(1-处方药，2-中药，3-西药)
	 */
	public int getY_type(){
		return y_type;
	}
	/**
	 * @param y_type 药品类型(1-处方药，2-中药，3-西药)
	 */
	public Yao setY_type(int y_type) {
		this.y_type=y_type;
		return this;
	}
	/**
	 * @return 简单描述
	 */
	public String getY_ms(){
		return y_ms;
	}
	/**
	 * @param y_ms 简单描述
	 */
	public Yao setY_ms(String y_ms) {
		this.y_ms=y_ms;
		return this;
	}
	/**
	 * @return 保质期,单位/月
	 */
	public int getY_baozhi(){
		return y_baozhi;
	}
	/**
	 * @param y_baozhi 保质期,单位/月
	 */
	public Yao setY_baozhi(int y_baozhi) {
		this.y_baozhi=y_baozhi;
		return this;
	}
	/**
	 * @return 详细描述
	 */
	public String getY_xxms(){
		return y_xxms;
	}
	/**
	 * @param y_xxms 详细描述
	 */
	public Yao setY_xxms(String y_xxms) {
		this.y_xxms=y_xxms;
		return this;
	}
	/**
	 * @return 生产厂商
	 */
	public String getY_sccs(){
		return y_sccs;
	}
	/**
	 * @param y_sccs 生产厂商
	 */
	public Yao setY_sccs(String y_sccs) {
		this.y_sccs=y_sccs;
		return this;
	}
	/**
	 * @return 药品状态(销售中,维护中)
	 */
	public String getY_state(){
		return y_state;
	}
	/**
	 * @param y_state 药品状态(销售中,维护中)
	 */
	public Yao setY_state(String y_state) {
		this.y_state=y_state;
		return this;
	}
	/**
	 * @return 库存
	 */
	public int getY_kucun(){
		return y_kucun;
	}
	/**
	 * @param y_kucun 库存
	 */
	public Yao setY_kucun(int y_kucun) {
		this.y_kucun=y_kucun;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Yao [yno=" + yno + 
				" ,y_img=" + y_img + 
				" ,y_jj=" + y_jj + 
				" ,y_sj=" + y_sj + 
				" ,y_name=" + y_name + 
				" ,y_type=" + y_type + 
				" ,y_ms=" + y_ms + 
				" ,y_baozhi=" + y_baozhi + 
				" ,y_xxms=" + y_xxms + 
				" ,y_sccs=" + y_sccs + 
				" ,y_state=" + y_state + 
				" ,y_kucun=" + y_kucun + "]";
	}


}

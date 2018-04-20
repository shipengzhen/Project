package com.yy.model;

public class Fayao{

	private int fid;		//id，主键,自增
	private int gid;		//病号ID，外键
	private String yno;		//药品编号，外键
	private int f_num;		//该发多少
	private int f_ynum;		//已经发了多少
	private int f_wnum;		//还剩多少没发

	/**
	 * @return id，主键,自增
	 */
	public int getFid(){
		return fid;
	}
	/**
	 * @param fid id，主键,自增
	 */
	public Fayao setFid(int fid) {
		this.fid=fid;
		return this;
	}
	/**
	 * @return 病号ID，外键
	 */
	public int getGid(){
		return gid;
	}
	/**
	 * @param gid 病号ID，外键
	 */
	public Fayao setGid(int gid) {
		this.gid=gid;
		return this;
	}
	/**
	 * @return 药品编号，外键
	 */
	public String getYno(){
		return yno;
	}
	/**
	 * @param yno 药品编号，外键
	 */
	public Fayao setYno(String yno) {
		this.yno=yno;
		return this;
	}
	/**
	 * @return 该发多少
	 */
	public int getF_num(){
		return f_num;
	}
	/**
	 * @param f_num 该发多少
	 */
	public Fayao setF_num(int f_num) {
		this.f_num=f_num;
		return this;
	}
	/**
	 * @return 已经发了多少
	 */
	public int getF_ynum(){
		return f_ynum;
	}
	/**
	 * @param f_ynum 已经发了多少
	 */
	public Fayao setF_ynum(int f_ynum) {
		this.f_ynum=f_ynum;
		return this;
	}
	/**
	 * @return 还剩多少没发
	 */
	public int getF_wnum(){
		return f_wnum;
	}
	/**
	 * @param f_wnum 还剩多少没发
	 */
	public Fayao setF_wnum(int f_wnum) {
		this.f_wnum=f_wnum;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fayao [fid=" + fid + 
				" ,gid=" + gid + 
				" ,yno=" + yno + 
				" ,f_num=" + f_num + 
				" ,f_ynum=" + f_ynum + 
				" ,f_wnum=" + f_wnum + "]";
	}

	//额外字段
	public String y_name;	//药品名称

	/**
	 * @return 药品名称
	 */
	public String getY_name() {
		return y_name;
	}
	/**
	 * @param 药品名称
	 */
	public void setY_name(String y_name) {
		this.y_name = y_name;
	}
	

}

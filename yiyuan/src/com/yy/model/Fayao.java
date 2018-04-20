package com.yy.model;

public class Fayao{

	private int fid;		//id������,����
	private int gid;		//����ID�����
	private String yno;		//ҩƷ��ţ����
	private int f_num;		//�÷�����
	private int f_ynum;		//�Ѿ����˶���
	private int f_wnum;		//��ʣ����û��

	/**
	 * @return id������,����
	 */
	public int getFid(){
		return fid;
	}
	/**
	 * @param fid id������,����
	 */
	public Fayao setFid(int fid) {
		this.fid=fid;
		return this;
	}
	/**
	 * @return ����ID�����
	 */
	public int getGid(){
		return gid;
	}
	/**
	 * @param gid ����ID�����
	 */
	public Fayao setGid(int gid) {
		this.gid=gid;
		return this;
	}
	/**
	 * @return ҩƷ��ţ����
	 */
	public String getYno(){
		return yno;
	}
	/**
	 * @param yno ҩƷ��ţ����
	 */
	public Fayao setYno(String yno) {
		this.yno=yno;
		return this;
	}
	/**
	 * @return �÷�����
	 */
	public int getF_num(){
		return f_num;
	}
	/**
	 * @param f_num �÷�����
	 */
	public Fayao setF_num(int f_num) {
		this.f_num=f_num;
		return this;
	}
	/**
	 * @return �Ѿ����˶���
	 */
	public int getF_ynum(){
		return f_ynum;
	}
	/**
	 * @param f_ynum �Ѿ����˶���
	 */
	public Fayao setF_ynum(int f_ynum) {
		this.f_ynum=f_ynum;
		return this;
	}
	/**
	 * @return ��ʣ����û��
	 */
	public int getF_wnum(){
		return f_wnum;
	}
	/**
	 * @param f_wnum ��ʣ����û��
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

	//�����ֶ�
	public String y_name;	//ҩƷ����

	/**
	 * @return ҩƷ����
	 */
	public String getY_name() {
		return y_name;
	}
	/**
	 * @param ҩƷ����
	 */
	public void setY_name(String y_name) {
		this.y_name = y_name;
	}
	

}

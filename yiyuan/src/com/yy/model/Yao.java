package com.yy.model;

public class Yao{

	private String yno;		//ҩƷ���,�Զ����ţ�����
	private String y_img;		//ҩƷͼƬ����
	private double y_jj;		//����
	private double y_sj;		//�ۼ�
	private String y_name;		//ҩƷ����
	private int y_type;		//ҩƷ����(1-����ҩ��2-��ҩ��3-��ҩ)
	private String y_ms;		//������
	private int y_baozhi;		//������,��λ/��
	private String y_xxms;		//��ϸ����
	private String y_sccs;		//��������
	private String y_state;		//ҩƷ״̬(������,ά����)
	private int y_kucun;		//���

	/**
	 * @return ҩƷ���,�Զ����ţ�����
	 */
	public String getYno(){
		return yno;
	}
	/**
	 * @param yno ҩƷ���,�Զ����ţ�����
	 */
	public Yao setYno(String yno) {
		this.yno=yno;
		return this;
	}
	/**
	 * @return ҩƷͼƬ����
	 */
	public String getY_img(){
		return y_img;
	}
	/**
	 * @param y_img ҩƷͼƬ����
	 */
	public Yao setY_img(String y_img) {
		this.y_img=y_img;
		return this;
	}
	/**
	 * @return ����
	 */
	public double getY_jj(){
		return y_jj;
	}
	/**
	 * @param y_jj ����
	 */
	public Yao setY_jj(double y_jj) {
		this.y_jj=y_jj;
		return this;
	}
	/**
	 * @return �ۼ�
	 */
	public double getY_sj(){
		return y_sj;
	}
	/**
	 * @param y_sj �ۼ�
	 */
	public Yao setY_sj(double y_sj) {
		this.y_sj=y_sj;
		return this;
	}
	/**
	 * @return ҩƷ����
	 */
	public String getY_name(){
		return y_name;
	}
	/**
	 * @param y_name ҩƷ����
	 */
	public Yao setY_name(String y_name) {
		this.y_name=y_name;
		return this;
	}
	/**
	 * @return ҩƷ����(1-����ҩ��2-��ҩ��3-��ҩ)
	 */
	public int getY_type(){
		return y_type;
	}
	/**
	 * @param y_type ҩƷ����(1-����ҩ��2-��ҩ��3-��ҩ)
	 */
	public Yao setY_type(int y_type) {
		this.y_type=y_type;
		return this;
	}
	/**
	 * @return ������
	 */
	public String getY_ms(){
		return y_ms;
	}
	/**
	 * @param y_ms ������
	 */
	public Yao setY_ms(String y_ms) {
		this.y_ms=y_ms;
		return this;
	}
	/**
	 * @return ������,��λ/��
	 */
	public int getY_baozhi(){
		return y_baozhi;
	}
	/**
	 * @param y_baozhi ������,��λ/��
	 */
	public Yao setY_baozhi(int y_baozhi) {
		this.y_baozhi=y_baozhi;
		return this;
	}
	/**
	 * @return ��ϸ����
	 */
	public String getY_xxms(){
		return y_xxms;
	}
	/**
	 * @param y_xxms ��ϸ����
	 */
	public Yao setY_xxms(String y_xxms) {
		this.y_xxms=y_xxms;
		return this;
	}
	/**
	 * @return ��������
	 */
	public String getY_sccs(){
		return y_sccs;
	}
	/**
	 * @param y_sccs ��������
	 */
	public Yao setY_sccs(String y_sccs) {
		this.y_sccs=y_sccs;
		return this;
	}
	/**
	 * @return ҩƷ״̬(������,ά����)
	 */
	public String getY_state(){
		return y_state;
	}
	/**
	 * @param y_state ҩƷ״̬(������,ά����)
	 */
	public Yao setY_state(String y_state) {
		this.y_state=y_state;
		return this;
	}
	/**
	 * @return ���
	 */
	public int getY_kucun(){
		return y_kucun;
	}
	/**
	 * @param y_kucun ���
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

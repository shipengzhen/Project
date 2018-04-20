package com.yy.model;

import java.sql.Timestamp;

public class Guahao{

	private int gid;		//ID�ţ�����������(1001)
	private String gname;		//�Һ�������
	private String g_card;		//���֤��
	private String g_shebao;		//�籣��
	private double g_money;		//�Һŷ�
	private String g_phone;		//��ϵ�绰
	private int g_zifei;		//�Ƿ��Է� - 1�� 2��
	private String g_sex;		//�Ա�
	private int g_age;		//����
	private String g_zhiye;		//ְҵ
	private int g_cf;		//���ﻹ�Ǹ���,1�� 2��
	private String g_beizhu;		//��ע
	private String g_status;		//�Һ�״̬(�ѹҺ�,��סԺ,�ѳ�Ժ,���˺�)
	private Timestamp g_data;		//�Һ�����
	private int kid;		//���ҿ���ID�����
	private int did;		//����ҽ��ID

	/**
	 * @return ID�ţ�����������(1001)
	 */
	public int getGid(){
		return gid;
	}
	/**
	 * @param gid ID�ţ�����������(1001)
	 */
	public Guahao setGid(int gid) {
		this.gid=gid;
		return this;
	}
	/**
	 * @return �Һ�������
	 */
	public String getGname(){
		return gname;
	}
	/**
	 * @param gname �Һ�������
	 */
	public Guahao setGname(String gname) {
		this.gname=gname;
		return this;
	}
	/**
	 * @return ���֤��
	 */
	public String getG_card(){
		return g_card;
	}
	/**
	 * @param g_card ���֤��
	 */
	public Guahao setG_card(String g_card) {
		this.g_card=g_card;
		return this;
	}
	/**
	 * @return �籣��
	 */
	public String getG_shebao(){
		return g_shebao;
	}
	/**
	 * @param g_shebao �籣��
	 */
	public Guahao setG_shebao(String g_shebao) {
		this.g_shebao=g_shebao;
		return this;
	}
	/**
	 * @return �Һŷ�
	 */
	public double getG_money(){
		return g_money;
	}
	/**
	 * @param g_money �Һŷ�
	 */
	public Guahao setG_money(double g_money) {
		this.g_money=g_money;
		return this;
	}
	/**
	 * @return ��ϵ�绰
	 */
	public String getG_phone(){
		return g_phone;
	}
	/**
	 * @param g_phone ��ϵ�绰
	 */
	public Guahao setG_phone(String g_phone) {
		this.g_phone=g_phone;
		return this;
	}
	/**
	 * @return �Ƿ��Է� - 1�� 2��
	 */
	public int getG_zifei(){
		return g_zifei;
	}
	/**
	 * @param g_zifei �Ƿ��Է� - 1�� 2��
	 */
	public Guahao setG_zifei(int g_zifei) {
		this.g_zifei=g_zifei;
		return this;
	}
	/**
	 * @return �Ա�
	 */
	public String getG_sex(){
		return g_sex;
	}
	/**
	 * @param g_sex �Ա�
	 */
	public Guahao setG_sex(String g_sex) {
		this.g_sex=g_sex;
		return this;
	}
	/**
	 * @return ����
	 */
	public int getG_age(){
		return g_age;
	}
	/**
	 * @param g_age ����
	 */
	public Guahao setG_age(int g_age) {
		this.g_age=g_age;
		return this;
	}
	/**
	 * @return ְҵ
	 */
	public String getG_zhiye(){
		return g_zhiye;
	}
	/**
	 * @param g_zhiye ְҵ
	 */
	public Guahao setG_zhiye(String g_zhiye) {
		this.g_zhiye=g_zhiye;
		return this;
	}
	/**
	 * @return ���ﻹ�Ǹ���,1�� 2��
	 */
	public int getG_cf(){
		return g_cf;
	}
	/**
	 * @param g_cf ���ﻹ�Ǹ���,1�� 2��
	 */
	public Guahao setG_cf(int g_cf) {
		this.g_cf=g_cf;
		return this;
	}
	/**
	 * @return ��ע
	 */
	public String getG_beizhu(){
		return g_beizhu;
	}
	/**
	 * @param g_beizhu ��ע
	 */
	public Guahao setG_beizhu(String g_beizhu) {
		this.g_beizhu=g_beizhu;
		return this;
	}
	/**
	 * @return ���ҿ���ID�����
	 */
	public int getKid(){
		return kid;
	}
	/**
	 * @param kid ���ҿ���ID�����
	 */
	public Guahao setKid(int kid) {
		this.kid=kid;
		return this;
	}
	/**
	 * @return ����ҽ��ID
	 */
	public int getDid(){
		return did;
	}
	/**
	 * @param did ����ҽ��ID
	 */
	public Guahao setDid(int did) {
		this.did=did;
		return this;
	}
	/**
	 * @return the �Һ�״̬(�ѹҺ�,��סԺ,�ѳ�Ժ,���˺�)
	 */
	public String getG_status() {
		return g_status;
	}
	/**
	 * @param �Һ�״̬(�ѹҺ�,��סԺ,�ѳ�Ժ,���˺�)
	 */
	public void setG_status(String g_status) {
		this.g_status = g_status;
	}
	/**
	 * @return �Һ�����
	 */
	public Timestamp getG_data() {
		return g_data;
	}
	/**
	 * @param �Һ�����
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

	
	//�����ֶ�
	private String kname;	//���ҿ������ֿ�
	private String d_zsname;	//����ҽ������

	/**
	 * @return ���ҿ������ֿ�
	 */
	public String getKname() {
		return kname;
	}
	/**
	 * @param ���ҿ������ֿ�
	 */
	public void setKname(String kname) {
		this.kname = kname;
	}
	/**
	 * @return ����ҽ������
	 */
	public String getD_zsname() {
		return d_zsname;
	}
	/**
	 * @param ����ҽ������
	 */
	public void setD_zsname(String d_zsname) {
		this.d_zsname = d_zsname;
	}
	
	

}

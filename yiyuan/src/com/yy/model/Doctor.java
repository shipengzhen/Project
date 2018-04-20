package com.yy.model;

import java.sql.*;

public class Doctor{

	private int did;		//ҽ����� - ����������(1000,1)
	private String d_zsname;		//ҽ������ - Ψһ
	private String d_card;		//���֤��
	private String d_phone;		//�ֻ���
	private String d_zuoji;		//����
	private String d_sex;		//�Ա�
	private Timestamp d_csday;		//����������
	private int d_age;		//����
	private String d_email;		//��������
	private String d_xueli;		//ѧ��
	private String d_beizhu;		//��ע
	private int kid;		//��������id�����
	private int uid;		//����user�˺�ID�����

	/**
	 * @return ҽ����� - ����������(1000,1)
	 */
	public int getDid(){
		return did;
	}
	/**
	 * @param did ҽ����� - ����������(1000,1)
	 */
	public Doctor setDid(int did) {
		this.did=did;
		return this;
	}
	/**
	 * @return ҽ������ - Ψһ
	 */
	public String getD_zsname(){
		return d_zsname;
	}
	/**
	 * @param d_zsname ҽ������ - Ψһ
	 */
	public Doctor setD_zsname(String d_zsname) {
		this.d_zsname=d_zsname;
		return this;
	}
	/**
	 * @return ���֤��
	 */
	public String getD_card(){
		return d_card;
	}
	/**
	 * @param d_card ���֤��
	 */
	public Doctor setD_card(String d_card) {
		this.d_card=d_card;
		return this;
	}
	/**
	 * @return �ֻ���
	 */
	public String getD_phone(){
		return d_phone;
	}
	/**
	 * @param d_phone �ֻ���
	 */
	public Doctor setD_phone(String d_phone) {
		this.d_phone=d_phone;
		return this;
	}
	/**
	 * @return ����
	 */
	public String getD_zuoji(){
		return d_zuoji;
	}
	/**
	 * @param d_zuoji ����
	 */
	public Doctor setD_zuoji(String d_zuoji) {
		this.d_zuoji=d_zuoji;
		return this;
	}
	/**
	 * @return �Ա�
	 */
	public String getD_sex(){
		return d_sex;
	}
	/**
	 * @param d_sex �Ա�
	 */
	public Doctor setD_sex(String d_sex) {
		this.d_sex=d_sex;
		return this;
	}
	/**
	 * @return ����������
	 */
	public Timestamp getD_csday(){
		return d_csday;
	}
	/**
	 * @param d_csday ����������
	 */
	public Doctor setD_csday(Timestamp d_csday) {
		this.d_csday=d_csday;
		return this;
	}
	/**
	 * @return ����
	 */
	public int getD_age(){
		return d_age;
	}
	/**
	 * @param d_age ����
	 */
	public Doctor setD_age(int d_age) {
		this.d_age=d_age;
		return this;
	}
	/**
	 * @return ��������
	 */
	public String getD_email(){
		return d_email;
	}
	/**
	 * @param d_email ��������
	 */
	public Doctor setD_email(String d_email) {
		this.d_email=d_email;
		return this;
	}
	/**
	 * @return ѧ��
	 */
	public String getD_xueli(){
		return d_xueli;
	}
	/**
	 * @param d_xueli ѧ��
	 */
	public Doctor setD_xueli(String d_xueli) {
		this.d_xueli=d_xueli;
		return this;
	}
	/**
	 * @return ��ע
	 */
	public String getD_beizhu(){
		return d_beizhu;
	}
	/**
	 * @param d_beizhu ��ע
	 */
	public Doctor setD_beizhu(String d_beizhu) {
		this.d_beizhu=d_beizhu;
		return this;
	}
	/**
	 * @return ��������id�����
	 */
	public int getKid(){
		return kid;
	}
	/**
	 * @param kid ��������id�����
	 */
	public Doctor setKid(int kid) {
		this.kid=kid;
		return this;
	}
	/**
	 * @return ����user�˺�ID�����
	 */
	public int getUid(){
		return uid;
	}
	/**
	 * @param uid ����user�˺�ID�����
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

	//�����ֶ�
	public String kname;	//������������

	/**
	 * @return ������������
	 */
	public String getKname() {
		return kname;
	}
	/**
	 * @param kname ������������
	 */
	public void setKname(String kname) {
		this.kname = kname;
	}

	
	

}

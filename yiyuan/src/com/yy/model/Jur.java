package com.yy.model;

public class Jur{

	private int Jid;		//id�� - ����������
	private int rid;		//��ɫID - ���
	private int mid;		//�˵���ID - �õ�

	/**
	 * @return id�� - ����������
	 */
	public int getJid(){
		return Jid;
	}
	/**
	 * @param Jid id�� - ����������
	 */
	public Jur setJid(int Jid) {
		this.Jid=Jid;
		return this;
	}
	/**
	 * @return ��ɫID - ���
	 */
	public int getRid(){
		return rid;
	}
	/**
	 * @param rid ��ɫID - ���
	 */
	public Jur setRid(int rid) {
		this.rid=rid;
		return this;
	}
	/**
	 * @return �˵���ID - �õ�
	 */
	public int getMid(){
		return mid;
	}
	/**
	 * @param mid �˵���ID - �õ�
	 */
	public Jur setMid(int mid) {
		this.mid=mid;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Jur [Jid=" + Jid + 
				" ,rid=" + rid + 
				" ,mid=" + mid + "]";
	}

	//�����ֶ�
	
	public String rname;	//��ɫ����
	public String mname;	//�˵�������

	/**
	 * @return ��ɫ����
	 */
	public String getRname() {
		return rname;
	}
	/**
	 * @param rname ��ɫ����
	 */
	public void setRname(String rname) {
		this.rname = rname;
	}
	/**
	 * @return �˵�������
	 */
	public String getMname() {
		return mname;
	}
	/**
	 * @param �˵�������
	 */
	public void setMname(String mname) {
		this.mname = mname;
	}

}

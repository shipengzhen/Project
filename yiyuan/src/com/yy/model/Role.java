package com.yy.model;

public class Role{

	private int rid;		//ID - ����������
	private String rname;		//��ɫ����
	private int rstate;		//״̬(1����,0����)

	/**
	 * @return ID - ����������
	 */
	public int getRid(){
		return rid;
	}
	/**
	 * @param rid ID - ����������
	 */
	public Role setRid(int rid) {
		this.rid=rid;
		return this;
	}
	/**
	 * @return ��ɫ����
	 */
	public String getRname(){
		return rname;
	}
	/**
	 * @param rname ��ɫ����
	 */
	public Role setRname(String rname) {
		this.rname=rname;
		return this;
	}
	/**
	 * @return ״̬(1����,0����)
	 */
	public int getRstate(){
		return rstate;
	}
	/**
	 * @param rstate ״̬(1����,0����)
	 */
	public Role setRstate(int rstate) {
		this.rstate=rstate;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [rid=" + rid + 
				" ,rname=" + rname + 
				" ,rstate=" + rstate + "]";
	}


}

package com.yy.model;

public class Kerome{

	private int kid;		//����ID - ����,���� 
	private String kname;		//��������

	/**
	 * @return ����ID - ����,���� 
	 */
	public int getKid(){
		return kid;
	}
	/**
	 * @param kid ����ID - ����,���� 
	 */
	public Kerome setKid(int kid) {
		this.kid=kid;
		return this;
	}
	/**
	 * @return ��������
	 */
	public String getKname(){
		return kname;
	}
	/**
	 * @param kname ��������
	 */
	public Kerome setKname(String kname) {
		this.kname=kname;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Kerome [kid=" + kid + 
				" ,kname=" + kname + "]";
	}


}

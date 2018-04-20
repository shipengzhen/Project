package com.yy.util;
/**
 * ��ҳ ������
 */
public class Page {
	
	int pn;		//��ǰҳ
	int pz;		//ҳ��С
	int count;	//������
	int start;	//��ʼ����

	/**
	 * ��ǰҳ��ҳ��С
	 */
	public Page(int pn, int pz) {
		this.pn = pn;
		this.pz = pz;
	}
	
	/**
	 * ������������������ҳ��
	 */
	public int getzy(){
		return count%pz==0?count/pz:count/pz+1;
	}

	/**
	 * @return ���� pn pz ��������ʼ����
	 */
	public int getStart() {
		return start=(pn - 1) * pz;
	}

	
	
	/**
	 * @return the pn
	 */
	public int getPn() {
		return pn;
	}

	/**
	 * @param pn the pn to set
	 */
	public void setPn(int pn) {
		this.pn = pn;
	}

	/**
	 * @return the pz
	 */
	public int getPz() {
		return pz;
	}

	/**
	 * @param pz the pz to set
	 */
	public void setPz(int pz) {
		this.pz = pz;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	

}

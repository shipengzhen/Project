package com.yy.model;



public class Menu{

	private int mid;		//�˵���ID - ����������
	private String text;		//������
	private String href;		//��URL·��,�����/jsp/
	private int myx;		//���Ƿ���Ч - (1��Ч,0��Ч)

	/**
	 * @return �˵���ID - ����������
	 */
	public int getMid(){
		return mid;
	}
	/**
	 * @param mid �˵���ID - ����������
	 */
	public Menu setMid(int mid) {
		this.mid=mid;
		return this;
	}
	/**
	 * @return ������
	 */
	public String getText(){
		return text;
	}
	/**
	 * @param text ������
	 */
	public Menu setText(String text) {
		this.text=text;
		return this;
	}
	/**
	 * @return ��URL·��,�����/jsp/
	 */
	public String getHref(){
		return href;
	}
	/**
	 * @param href ��URL·��,�����/jsp/
	 */
	public Menu setHref(String href) {
		this.href=href;
		return this;
	}
	/**
	 * @return ���Ƿ���Ч - (1��Ч,0��Ч)
	 */
	public int getMyx(){
		return myx;
	}
	/**
	 * @param myx ���Ƿ���Ч - (1��Ч,0��Ч)
	 */
	public Menu setMyx(int myx) {
		this.myx=myx;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Menu [mid=" + mid + 
				" ,text=" + text + 
				" ,href=" + href + 
				" ,myx=" + myx + "]";
	}


}
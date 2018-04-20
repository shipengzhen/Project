package com.yy.util;


/**
 * ���ڲ�����ʱ
 * @author kong
 *
 */
public class CSTime {

	private long start=0;	//��ʼʱ��
	private long end=0;		//����ʱ��
	
	public static CSTime sc=new CSTime();	//static���ʹ��
	
	/**
	 * ��ʼ��ʱ
	 * @return
	 */
	public CSTime start() {
		start=System.currentTimeMillis();
		return this;
	}
	
	
	/**
	 * ������ʱ
	 */
	public CSTime end() {
		end=System.currentTimeMillis();
		return this;
	}

	
	/**
	 * �������ú�����
	 */
	public long returnMs() {
		return end-start;
	}
	
	/**
	 * ��ʽ��������
	 */
	public void outTime() {
		System.out.println(this.toString());
	}
	
	/**
	 * ��������ʽ��������
	 */
	public void endOutTime() {
		this.end().outTime();
	}
	
	@Override
	public String toString() {
		return "��ʱ��\t"+(returnMs()+0.0)/1000+"s";
	}
	
	
	
}

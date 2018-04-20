package com.yy.util;
/**
 * 分页 辅助类
 */
public class Page {
	
	int pn;		//当前页
	int pz;		//页大小
	int count;	//总条数
	int start;	//起始条数

	/**
	 * 当前页、页大小
	 */
	public Page(int pn, int pz) {
		this.pn = pn;
		this.pz = pz;
	}
	
	/**
	 * 根据总条数，计算总页数
	 */
	public int getzy(){
		return count%pz==0?count/pz:count/pz+1;
	}

	/**
	 * @return 根据 pn pz 计算获得起始条数
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

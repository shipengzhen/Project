package com.yy.model;



public class Menu{

	private int mid;		//菜单项ID - 主键，自增
	private String text;		//项名称
	private String href;		//项URL路径,相对于/jsp/
	private int myx;		//项是否有效 - (1有效,0无效)

	/**
	 * @return 菜单项ID - 主键，自增
	 */
	public int getMid(){
		return mid;
	}
	/**
	 * @param mid 菜单项ID - 主键，自增
	 */
	public Menu setMid(int mid) {
		this.mid=mid;
		return this;
	}
	/**
	 * @return 项名称
	 */
	public String getText(){
		return text;
	}
	/**
	 * @param text 项名称
	 */
	public Menu setText(String text) {
		this.text=text;
		return this;
	}
	/**
	 * @return 项URL路径,相对于/jsp/
	 */
	public String getHref(){
		return href;
	}
	/**
	 * @param href 项URL路径,相对于/jsp/
	 */
	public Menu setHref(String href) {
		this.href=href;
		return this;
	}
	/**
	 * @return 项是否有效 - (1有效,0无效)
	 */
	public int getMyx(){
		return myx;
	}
	/**
	 * @param myx 项是否有效 - (1有效,0无效)
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
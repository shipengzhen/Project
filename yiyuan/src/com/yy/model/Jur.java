package com.yy.model;

public class Jur{

	private int Jid;		//id好 - 主键，自增
	private int rid;		//角色ID - 外键
	private int mid;		//菜单项ID - 好的

	/**
	 * @return id好 - 主键，自增
	 */
	public int getJid(){
		return Jid;
	}
	/**
	 * @param Jid id好 - 主键，自增
	 */
	public Jur setJid(int Jid) {
		this.Jid=Jid;
		return this;
	}
	/**
	 * @return 角色ID - 外键
	 */
	public int getRid(){
		return rid;
	}
	/**
	 * @param rid 角色ID - 外键
	 */
	public Jur setRid(int rid) {
		this.rid=rid;
		return this;
	}
	/**
	 * @return 菜单项ID - 好的
	 */
	public int getMid(){
		return mid;
	}
	/**
	 * @param mid 菜单项ID - 好的
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

	//额外字段
	
	public String rname;	//角色名称
	public String mname;	//菜单项名称

	/**
	 * @return 角色名称
	 */
	public String getRname() {
		return rname;
	}
	/**
	 * @param rname 角色名称
	 */
	public void setRname(String rname) {
		this.rname = rname;
	}
	/**
	 * @return 菜单项名称
	 */
	public String getMname() {
		return mname;
	}
	/**
	 * @param 菜单项名称
	 */
	public void setMname(String mname) {
		this.mname = mname;
	}

}

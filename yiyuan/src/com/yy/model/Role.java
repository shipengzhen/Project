package com.yy.model;

public class Role{

	private int rid;		//ID - 主键，自增
	private String rname;		//角色名称
	private int rstate;		//状态(1启用,0禁用)

	/**
	 * @return ID - 主键，自增
	 */
	public int getRid(){
		return rid;
	}
	/**
	 * @param rid ID - 主键，自增
	 */
	public Role setRid(int rid) {
		this.rid=rid;
		return this;
	}
	/**
	 * @return 角色名称
	 */
	public String getRname(){
		return rname;
	}
	/**
	 * @param rname 角色名称
	 */
	public Role setRname(String rname) {
		this.rname=rname;
		return this;
	}
	/**
	 * @return 状态(1启用,0禁用)
	 */
	public int getRstate(){
		return rstate;
	}
	/**
	 * @param rstate 状态(1启用,0禁用)
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

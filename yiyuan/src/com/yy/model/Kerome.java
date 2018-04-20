package com.yy.model;

public class Kerome{

	private int kid;		//科室ID - 主键,自增 
	private String kname;		//科室名称

	/**
	 * @return 科室ID - 主键,自增 
	 */
	public int getKid(){
		return kid;
	}
	/**
	 * @param kid 科室ID - 主键,自增 
	 */
	public Kerome setKid(int kid) {
		this.kid=kid;
		return this;
	}
	/**
	 * @return 科室名称
	 */
	public String getKname(){
		return kname;
	}
	/**
	 * @param kname 科室名称
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

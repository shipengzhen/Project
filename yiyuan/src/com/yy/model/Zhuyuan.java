package com.yy.model;

import java.sql.*;

import com.fly.jdbc.AtFly;
import com.yy.dao.FC;

public class Zhuyuan{

	private int zid;		//ID号，主键，自增
	private String z_huli;		//护理
	private String z_cw;		//床位号
	private String z_yajin;		//交付押金，也即余额
	private Timestamp z_zydate;		//入院时间
	private String z_zy_state;		//住院状态(已住院，已出院)
	private String z_js_state;		//结算状态(未结算，已结算)
	private int gid;		//病例ID，外键

	/**
	 * @return ID号，主键，自增
	 */
	public int getZid(){
		return zid;
	}
	/**
	 * @param zid ID号，主键，自增
	 */
	public Zhuyuan setZid(int zid) {
		this.zid=zid;
		return this;
	}
	/**
	 * @return 护理
	 */
	public String getZ_huli(){
		return z_huli;
	}
	/**
	 * @param z_huli 护理
	 */
	public Zhuyuan setZ_huli(String z_huli) {
		this.z_huli=z_huli;
		return this;
	}
	/**
	 * @return 床位号
	 */
	public String getZ_cw(){
		return z_cw;
	}
	/**
	 * @param z_cw 床位号
	 */
	public Zhuyuan setZ_cw(String z_cw) {
		this.z_cw=z_cw;
		return this;
	}
	/**
	 * @return 交付押金，也即余额
	 */
	public String getZ_yajin(){
		return z_yajin;
	}
	/**
	 * @param z_yajin 交付押金，也即余额
	 */
	public Zhuyuan setZ_yajin(String z_yajin) {
		this.z_yajin=z_yajin;
		return this;
	}
	/**
	 * @return 入院时间
	 */
	public Timestamp getZ_zydate(){
		return z_zydate;
	}
	/**
	 * @param z_zydate 入院时间
	 */
	public Zhuyuan setZ_zydate(Timestamp z_zydate) {
		this.z_zydate=z_zydate;
		return this;
	}
	/**
	 * @return 住院状态(已住院，已出院)
	 */
	public String getZ_zy_state(){
		return z_zy_state;
	}
	/**
	 * @param z_zy_state 住院状态(已住院，已出院)
	 */
	public Zhuyuan setZ_zy_state(String z_zy_state) {
		this.z_zy_state=z_zy_state;
		return this;
	}
	/**
	 * @return 结算状态(未结算，已结算)
	 */
	public String getZ_js_state(){
		return z_js_state;
	}
	/**
	 * @param z_js_state 结算状态(未结算，已结算)
	 */
	public Zhuyuan setZ_js_state(String z_js_state) {
		this.z_js_state=z_js_state;
		return this;
	}
	/**
	 * @return 病例ID，外键
	 */
	public int getGid(){
		return gid;
	}
	/**
	 * @param gid 病例ID，外键
	 */
	public Zhuyuan setGid(int gid) {
		this.gid=gid;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Zhuyuan [zid=" + zid + 
				" ,z_huli=" + z_huli + 
				" ,z_cw=" + z_cw + 
				" ,z_yajin=" + z_yajin + 
				" ,z_zydate=" + z_zydate + 
				" ,z_zy_state=" + z_zy_state + 
				" ,z_js_state=" + z_js_state + 
				" ,gid=" + gid + "]";
	}

	//额外字段
	@AtFly(orm=false)
	public Guahao guahao;	//挂号表

	/**
	 * 挂号表
	 */
	public Guahao getGuahao() {
		if(guahao==null) {
			this.guahao=FC.getIGuahaoDao().findById(gid);
		}
		return guahao;
	}
	/**
	 * 挂号表
	 */
	public void setGuahao(Guahao guahao) {
		this.guahao = guahao;
	}
	
	
	
	
	
	
	
}

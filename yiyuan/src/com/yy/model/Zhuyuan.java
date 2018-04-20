package com.yy.model;

import java.sql.*;

import com.fly.jdbc.AtFly;
import com.yy.dao.FC;

public class Zhuyuan{

	private int zid;		//ID�ţ�����������
	private String z_huli;		//����
	private String z_cw;		//��λ��
	private String z_yajin;		//����Ѻ��Ҳ�����
	private Timestamp z_zydate;		//��Ժʱ��
	private String z_zy_state;		//סԺ״̬(��סԺ���ѳ�Ժ)
	private String z_js_state;		//����״̬(δ���㣬�ѽ���)
	private int gid;		//����ID�����

	/**
	 * @return ID�ţ�����������
	 */
	public int getZid(){
		return zid;
	}
	/**
	 * @param zid ID�ţ�����������
	 */
	public Zhuyuan setZid(int zid) {
		this.zid=zid;
		return this;
	}
	/**
	 * @return ����
	 */
	public String getZ_huli(){
		return z_huli;
	}
	/**
	 * @param z_huli ����
	 */
	public Zhuyuan setZ_huli(String z_huli) {
		this.z_huli=z_huli;
		return this;
	}
	/**
	 * @return ��λ��
	 */
	public String getZ_cw(){
		return z_cw;
	}
	/**
	 * @param z_cw ��λ��
	 */
	public Zhuyuan setZ_cw(String z_cw) {
		this.z_cw=z_cw;
		return this;
	}
	/**
	 * @return ����Ѻ��Ҳ�����
	 */
	public String getZ_yajin(){
		return z_yajin;
	}
	/**
	 * @param z_yajin ����Ѻ��Ҳ�����
	 */
	public Zhuyuan setZ_yajin(String z_yajin) {
		this.z_yajin=z_yajin;
		return this;
	}
	/**
	 * @return ��Ժʱ��
	 */
	public Timestamp getZ_zydate(){
		return z_zydate;
	}
	/**
	 * @param z_zydate ��Ժʱ��
	 */
	public Zhuyuan setZ_zydate(Timestamp z_zydate) {
		this.z_zydate=z_zydate;
		return this;
	}
	/**
	 * @return סԺ״̬(��סԺ���ѳ�Ժ)
	 */
	public String getZ_zy_state(){
		return z_zy_state;
	}
	/**
	 * @param z_zy_state סԺ״̬(��סԺ���ѳ�Ժ)
	 */
	public Zhuyuan setZ_zy_state(String z_zy_state) {
		this.z_zy_state=z_zy_state;
		return this;
	}
	/**
	 * @return ����״̬(δ���㣬�ѽ���)
	 */
	public String getZ_js_state(){
		return z_js_state;
	}
	/**
	 * @param z_js_state ����״̬(δ���㣬�ѽ���)
	 */
	public Zhuyuan setZ_js_state(String z_js_state) {
		this.z_js_state=z_js_state;
		return this;
	}
	/**
	 * @return ����ID�����
	 */
	public int getGid(){
		return gid;
	}
	/**
	 * @param gid ����ID�����
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

	//�����ֶ�
	@AtFly(orm=false)
	public Guahao guahao;	//�Һű�

	/**
	 * �Һű�
	 */
	public Guahao getGuahao() {
		if(guahao==null) {
			this.guahao=FC.getIGuahaoDao().findById(gid);
		}
		return guahao;
	}
	/**
	 * �Һű�
	 */
	public void setGuahao(Guahao guahao) {
		this.guahao = guahao;
	}
	
	
	
	
	
	
	
}

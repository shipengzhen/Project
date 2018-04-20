package com.bdqn.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TbRegisterSelect {
	
	private Integer id;
	
	private String doctorname;
	
	private String opdName;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date begin;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date end;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getOpdName() {
		return opdName;
	}
	public void setOpdName(String opdName) {
		this.opdName = opdName;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	
	
	
}

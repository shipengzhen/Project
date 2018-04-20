package com.bdqn.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 医生
 * @author lizhen
 * @date 2018年2月21日
 * @time 下午2:58:57
 */
public class TbDoctors {
    private Integer doctorid;

    private String opdName;
    
    private String doctorname;

    private String idcard;

    private String phone;

    private String telephone;

    private String sex;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    private String email;

    private Integer opdid;

    private String education;

    private String remarks;

    private Date created;

    private Date updated;

    
    
    
    public String getOpdName() {
		return opdName;
	}

	public void setOpdName(String opdName) {
		this.opdName = opdName;
	}

	public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname == null ? null : doctorname.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getOpdid() {
        return opdid;
    }

    public void setOpdid(Integer opdid) {
        this.opdid = opdid;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
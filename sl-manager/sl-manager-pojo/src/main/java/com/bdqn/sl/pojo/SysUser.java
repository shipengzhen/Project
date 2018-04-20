package com.bdqn.sl.pojo;

import java.util.Date;

public class SysUser {
    private Integer userid;

    private Integer roleid;

    private Integer referee;

    private Integer associatorid;

    private String loginname;

    private String loginpwd;

    private String loginpwd2;

    private String uname;

    private Integer cardtypeid;

    private String cardnumber;

    private String cardimg;

    private String yhimg;

    private String phone;

    private String email;

    private Integer postalcode;

    private String address;

    private String bankname;

    private String banknumber;

    private String bankuname;

    private Float ymoney;

    private Integer createuid;

    private Date created;

    private Integer updateuid;

    private Date updated;

    private String sex;

    private Integer status;

    
    private String refereeName;
    
    private String roleName;
    
    private String hyType;
    
    private String cardnumberName;
    
    private String oldPwd2;
    
   
    

	public String getOldPwd2() {
		return oldPwd2;
	}

	public void setOldPwd2(String oldPwd2) {
		this.oldPwd2 = oldPwd2;
	}

	public String getCardnumberName() {
		return cardnumberName;
	}

	public void setCardnumberName(String cardnumberName) {
		this.cardnumberName = cardnumberName;
	}

	public String getHyType() {
		return hyType;
	}

	public void setHyType(String hyType) {
		this.hyType = hyType;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRefereeName() {
		return refereeName;
	}

	public void setRefereeName(String refereeName) {
		this.refereeName = refereeName;
	}

	public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getReferee() {
        return referee;
    }

    public void setReferee(Integer referee) {
        this.referee = referee;
    }

    public Integer getAssociatorid() {
        return associatorid;
    }

    public void setAssociatorid(Integer associatorid) {
        this.associatorid = associatorid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd == null ? null : loginpwd.trim();
    }

    public String getLoginpwd2() {
        return loginpwd2;
    }

    public void setLoginpwd2(String loginpwd2) {
        this.loginpwd2 = loginpwd2 == null ? null : loginpwd2.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Integer getCardtypeid() {
        return cardtypeid;
    }

    public void setCardtypeid(Integer cardtypeid) {
        this.cardtypeid = cardtypeid;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber == null ? null : cardnumber.trim();
    }

    public String getCardimg() {
        return cardimg;
    }

    public void setCardimg(String cardimg) {
        this.cardimg = cardimg == null ? null : cardimg.trim();
    }

    public String getYhimg() {
        return yhimg;
    }

    public void setYhimg(String yhimg) {
        this.yhimg = yhimg == null ? null : yhimg.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(Integer postalcode) {
        this.postalcode = postalcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }

    public String getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(String banknumber) {
        this.banknumber = banknumber == null ? null : banknumber.trim();
    }

    public String getBankuname() {
        return bankuname;
    }

    public void setBankuname(String bankuname) {
        this.bankuname = bankuname == null ? null : bankuname.trim();
    }

    public Float getYmoney() {
        return ymoney;
    }

    public void setYmoney(Float ymoney) {
        this.ymoney = ymoney;
    }

    public Integer getCreateuid() {
        return createuid;
    }

    public void setCreateuid(Integer createuid) {
        this.createuid = createuid;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getUpdateuid() {
        return updateuid;
    }

    public void setUpdateuid(Integer updateuid) {
        this.updateuid = updateuid;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
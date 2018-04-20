package com.bdqn.sl.pojo;

import java.util.Date;

public class Recharge {
    private Integer reid;

    private Integer userid;

    private Float money;

    private String remark;

    private Integer mtype;

    private Integer status;

    private Date created;

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getMtype() {
        return mtype;
    }

    public void setMtype(Integer mtype) {
        this.mtype = mtype;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
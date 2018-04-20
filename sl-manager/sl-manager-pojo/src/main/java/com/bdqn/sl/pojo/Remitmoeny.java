package com.bdqn.sl.pojo;

import java.util.Date;

public class Remitmoeny {
    private Integer rmid;

    private Float rmmoney;

    private Integer rmtype;

    private String rmdoc;

    private String rmnum;

    private Integer createuid;

    private Date created;

    private Integer updateuid;

    private Date updated;

    public Integer getRmid() {
        return rmid;
    }

    public void setRmid(Integer rmid) {
        this.rmid = rmid;
    }

    public Float getRmmoney() {
        return rmmoney;
    }

    public void setRmmoney(Float rmmoney) {
        this.rmmoney = rmmoney;
    }

    public Integer getRmtype() {
        return rmtype;
    }

    public void setRmtype(Integer rmtype) {
        this.rmtype = rmtype;
    }

    public String getRmdoc() {
        return rmdoc;
    }

    public void setRmdoc(String rmdoc) {
        this.rmdoc = rmdoc == null ? null : rmdoc.trim();
    }

    public String getRmnum() {
        return rmnum;
    }

    public void setRmnum(String rmnum) {
        this.rmnum = rmnum == null ? null : rmnum.trim();
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
}
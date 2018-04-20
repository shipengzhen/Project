package com.bdqn.pojo;

import java.util.Date;

public class TbBeHospitalized {
    private Integer id;

    private Integer registerId;

    private Integer bedid;

    private String nurseid;

    private String circumstances;

    private Date created;

    private Date updated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public Integer getBedid() {
        return bedid;
    }

    public void setBedid(Integer bedid) {
        this.bedid = bedid;
    }

    public String getNurseid() {
        return nurseid;
    }

    public void setNurseid(String nurseid) {
        this.nurseid = nurseid == null ? null : nurseid.trim();
    }

    public String getCircumstances() {
        return circumstances;
    }

    public void setCircumstances(String circumstances) {
        this.circumstances = circumstances == null ? null : circumstances.trim();
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
package com.bdqn.pojo;

import java.util.Date;

public class TbDispensing {
    private Integer id;

    private Integer registerId;

    private String medicinenmae;

    private Integer medicinenumber;

    private Integer medicineyf;

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

    public String getMedicinenmae() {
        return medicinenmae;
    }

    public void setMedicinenmae(String medicinenmae) {
        this.medicinenmae = medicinenmae == null ? null : medicinenmae.trim();
    }

    public Integer getMedicinenumber() {
        return medicinenumber;
    }

    public void setMedicinenumber(Integer medicinenumber) {
        this.medicinenumber = medicinenumber;
    }

    public Integer getMedicineyf() {
        return medicineyf;
    }

    public void setMedicineyf(Integer medicineyf) {
        this.medicineyf = medicineyf;
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
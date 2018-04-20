package com.bdqn.sl.pojo;

import java.util.Date;

public class Setmeal {
    private Integer smid;

    private String smname;

    private Integer smtypeid;
    
    private String smTypeName;

    public String getSmTypeName() {
		return smTypeName;
	}

	public void setSmTypeName(String smTypeName) {
		this.smTypeName = smTypeName;
	}

	private Float smprice;

    private Integer smstatic;

    private Integer smnumber;

    private String smdoc;

    private Integer createuid;

    private Date created;

    private Integer updateuid;

    private Date updated;

    public Integer getSmid() {
        return smid;
    }

    public void setSmid(Integer smid) {
        this.smid = smid;
    }

    public String getSmname() {
        return smname;
    }

    public void setSmname(String smname) {
        this.smname = smname == null ? null : smname.trim();
    }

    public Integer getSmtypeid() {
        return smtypeid;
    }

    public void setSmtypeid(Integer smtypeid) {
        this.smtypeid = smtypeid;
    }

    public Float getSmprice() {
        return smprice;
    }

    public void setSmprice(Float smprice) {
        this.smprice = smprice;
    }

    public Integer getSmstatic() {
        return smstatic;
    }

    public void setSmstatic(Integer smstatic) {
        this.smstatic = smstatic;
    }

    public Integer getSmnumber() {
        return smnumber;
    }

    public void setSmnumber(Integer smnumber) {
        this.smnumber = smnumber;
    }

    public String getSmdoc() {
        return smdoc;
    }

    public void setSmdoc(String smdoc) {
        this.smdoc = smdoc == null ? null : smdoc.trim();
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
package com.bdqn.sl.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Affiche {
    private Integer gid;

    private String gtitle;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date begindate;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date enddate;

    private String gdoc;

    private Integer createuid;

    private Date created;

    private Integer updateuid;

    private Date updated;

    private String userName;
    
    
    
    
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGtitle() {
        return gtitle;
    }

    public void setGtitle(String gtitle) {
        this.gtitle = gtitle == null ? null : gtitle.trim();
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getGdoc() {
        return gdoc;
    }

    public void setGdoc(String gdoc) {
        this.gdoc = gdoc == null ? null : gdoc.trim();
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
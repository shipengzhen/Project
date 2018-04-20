package com.bdqn.sl.pojo;

import java.util.Date;

public class SysRole {
    private Integer roleid;

    private String rolename;

    private Integer status;

    private Integer createuid;

    private Date created;

    private Integer updateuid;

    private Date updated;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
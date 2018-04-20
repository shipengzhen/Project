package com.bdqn.sl.pojo;

import java.io.Serializable;
import java.util.Date;

public class SysAuthority implements Serializable {
    private Integer authorityid;

    private String authorityname;

    private String url;

    private Integer parentid;

    private Integer createuid;

    private Date created;

    private Integer updateuid;

    private Date updated;

    public Integer getAuthorityid() {
        return authorityid;
    }

    public void setAuthorityid(Integer authorityid) {
        this.authorityid = authorityid;
    }

    public String getAuthorityname() {
        return authorityname;
    }

    public void setAuthorityname(String authorityname) {
        this.authorityname = authorityname == null ? null : authorityname.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
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
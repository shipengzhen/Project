package com.bdqn.sl.pojo;

import java.util.Date;

public class Information {
    private Integer zid;

    private String ztitle;

    private Integer ztypeid;

    private String zfilesize;

    private String filename;

    private String zfile;

    private String zdoc;

    private Integer status;

    private Integer createuid;

    private Date created;

    private Integer updateuid;

    private Date updated;
    
    private String createUname;
    
    private String typeName;
    
    
    
    
    public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getCreateUname() {
		return createUname;
	}

	public void setCreateUname(String createUname) {
		this.createUname = createUname;
	}

	public Integer getZid() {
        return zid;
    }

    public void setZid(Integer zid) {
        this.zid = zid;
    }

    public String getZtitle() {
        return ztitle;
    }

    public void setZtitle(String ztitle) {
        this.ztitle = ztitle == null ? null : ztitle.trim();
    }

    public Integer getZtypeid() {
        return ztypeid;
    }

    public void setZtypeid(Integer ztypeid) {
        this.ztypeid = ztypeid;
    }

    public String getZfilesize() {
        return zfilesize;
    }

    public void setZfilesize(String zfilesize) {
        this.zfilesize = zfilesize == null ? null : zfilesize.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getZfile() {
        return zfile;
    }

    public void setZfile(String zfile) {
        this.zfile = zfile == null ? null : zfile.trim();
    }

    public String getZdoc() {
        return zdoc;
    }

    public void setZdoc(String zdoc) {
        this.zdoc = zdoc == null ? null : zdoc.trim();
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
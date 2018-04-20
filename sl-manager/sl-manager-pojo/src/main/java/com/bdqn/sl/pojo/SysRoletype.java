package com.bdqn.sl.pojo;

public class SysRoletype {
    private Integer id;

    private String roletypename;

    private Integer roleid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoletypename() {
        return roletypename;
    }

    public void setRoletypename(String roletypename) {
        this.roletypename = roletypename == null ? null : roletypename.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}
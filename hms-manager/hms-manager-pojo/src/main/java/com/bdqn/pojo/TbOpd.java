package com.bdqn.pojo;

import java.util.Date;
/**
 * 科室
 * @author lizhen
 * @date 2018年2月21日
 * @time 下午3:28:03
 */
public class TbOpd {
    private Integer id;

    private String name;

    private Date created;

    private Date updated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
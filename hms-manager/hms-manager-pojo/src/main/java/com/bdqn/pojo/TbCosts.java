package com.bdqn.pojo;

import java.util.Date;

/**
 * 收费项目登记
 * @author lizhen
 * @date 2018年2月23日
 * @time 下午2:24:45
 */
public class TbCosts {
	
    private Integer id;

    private Integer registerId;

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
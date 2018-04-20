package com.bdqn.sl.pojo;

import java.util.Date;

public class Commodity {
    private Integer commodityid;

    private String commodityname;

    private Float yprice;

    private Float xprice;

    private Integer number;

    private Integer status;

    private String specifications;

    private String details;

    private Integer createuid;

    private Date created;

    private Integer updateuid;

    private Date updated;

    public Integer getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }

    public String getCommodityname() {
        return commodityname;
    }

    public void setCommodityname(String commodityname) {
        this.commodityname = commodityname == null ? null : commodityname.trim();
    }

    public Float getYprice() {
        return yprice;
    }

    public void setYprice(Float yprice) {
        this.yprice = yprice;
    }

    public Float getXprice() {
        return xprice;
    }

    public void setXprice(Float xprice) {
        this.xprice = xprice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
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
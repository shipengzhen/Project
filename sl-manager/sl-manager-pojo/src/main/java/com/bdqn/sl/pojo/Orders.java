package com.bdqn.sl.pojo;

import java.util.Date;

public class Orders {
    private Integer orderid;

    private Float price;

    private Integer ordertype;

    private Integer createuid;
    
    private String uName;
    
    private String name;

    public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Date created;

    private Integer status;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
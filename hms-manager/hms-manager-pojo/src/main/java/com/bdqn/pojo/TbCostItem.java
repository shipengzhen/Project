package com.bdqn.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TbCostItem {
	
	private Integer itemid;			//	中间表
	private Integer costsid;		//挂号
	
	private String name;			//mc
	private Double cash_pledge;		//押金
	private Double HFcost;			//话费
	
	
	
    public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public Integer getCostsid() {
		return costsid;
	}

	public void setCostsid(Integer costsid) {
		this.costsid = costsid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCash_pledge() {
		return cash_pledge;
	}

	public void setCash_pledge(Double cash_pledge) {
		this.cash_pledge = cash_pledge;
	}

	public Double getHFcost() {
		return HFcost;
	}

	public void setHFcost(Double hFcost) {
		HFcost = hFcost;
	}

	private Integer id;

    private String costitemname;

    private BigDecimal cost;

    private Date created;

    private Date updated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCostitemname() {
        return costitemname;
    }

    public void setCostitemname(String costitemname) {
        this.costitemname = costitemname == null ? null : costitemname.trim();
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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
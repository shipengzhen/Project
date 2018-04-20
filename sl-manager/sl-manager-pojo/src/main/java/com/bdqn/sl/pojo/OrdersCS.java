package com.bdqn.sl.pojo;

public class OrdersCS extends OrdersCSKey {
    private Integer ocsCnum;

    public Integer getOcsCnum() {
        return ocsCnum;
    }

    public void setOcsCnum(Integer ocsCnum) {
        this.ocsCnum = ocsCnum;
    }
    
    private String name;
    
    private Float price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
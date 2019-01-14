package com.inspur.pds.data;

/**
 * @Author: HP
 * @Date: 2019/1/8 13:53
 * @Description:
 */
public class Customer {
    private String customerName; //客户名称
    private String simpleName; //简称
    private String trade; //行业
    private String address; //地址

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Customer(){

    }
    public Customer(String customerName, String simpleName, String trade, String address) {
        this.customerName = customerName;
        this.simpleName = simpleName;
        this.trade = trade;
        this.address = address;
    }
}

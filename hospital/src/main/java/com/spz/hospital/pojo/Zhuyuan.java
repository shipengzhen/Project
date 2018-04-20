package com.spz.hospital.pojo;

import java.sql.Timestamp;


/**
 * Zhuyuan entity. @author MyEclipse Persistence Tools
 */

public class Zhuyuan  implements java.io.Serializable {


    // Fields    

     private Integer zid;
     private Guahao guahao;
     private String ZHuli;
     private String ZCw;
     private String ZYajin;
     private Timestamp ZZydate;
     private String ZZyState;
     private String ZJsState;


    // Constructors

    /** default constructor */
    public Zhuyuan() {
    }

    
    /** full constructor */
    public Zhuyuan(Guahao guahao, String ZHuli, String ZCw, String ZYajin, Timestamp ZZydate, String ZZyState, String ZJsState) {
        this.guahao = guahao;
        this.ZHuli = ZHuli;
        this.ZCw = ZCw;
        this.ZYajin = ZYajin;
        this.ZZydate = ZZydate;
        this.ZZyState = ZZyState;
        this.ZJsState = ZJsState;
    }

   
    // Property accessors

    public Integer getZid() {
        return this.zid;
    }
    
    public void setZid(Integer zid) {
        this.zid = zid;
    }

    public Guahao getGuahao() {
        return this.guahao;
    }
    
    public void setGuahao(Guahao guahao) {
        this.guahao = guahao;
    }

    public String getZHuli() {
        return this.ZHuli;
    }
    
    public void setZHuli(String ZHuli) {
        this.ZHuli = ZHuli;
    }

    public String getZCw() {
        return this.ZCw;
    }
    
    public void setZCw(String ZCw) {
        this.ZCw = ZCw;
    }

    public String getZYajin() {
        return this.ZYajin;
    }
    
    public void setZYajin(String ZYajin) {
        this.ZYajin = ZYajin;
    }

    public Timestamp getZZydate() {
        return this.ZZydate;
    }
    
    public void setZZydate(Timestamp ZZydate) {
        this.ZZydate = ZZydate;
    }

    public String getZZyState() {
        return this.ZZyState;
    }
    
    public void setZZyState(String ZZyState) {
        this.ZZyState = ZZyState;
    }

    public String getZJsState() {
        return this.ZJsState;
    }
    
    public void setZJsState(String ZJsState) {
        this.ZJsState = ZJsState;
    }
   








}
package com.spz.hospital.pojo;

import java.sql.Timestamp;


/**
 * Payred entity. @author MyEclipse Persistence Tools
 */

public class Payred  implements java.io.Serializable {


    // Fields    

     private Integer prid;
     private Guahao guahao;
     private Pay pay;
     private Timestamp pdate;


    // Constructors

    /** default constructor */
    public Payred() {
    }

    
    /** full constructor */
    public Payred(Guahao guahao, Pay pay, Timestamp pdate) {
        this.guahao = guahao;
        this.pay = pay;
        this.pdate = pdate;
    }

   
    // Property accessors

    public Integer getPrid() {
        return this.prid;
    }
    
    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    public Guahao getGuahao() {
        return this.guahao;
    }
    
    public void setGuahao(Guahao guahao) {
        this.guahao = guahao;
    }

    public Pay getPay() {
        return this.pay;
    }
    
    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public Timestamp getPdate() {
        return this.pdate;
    }
    
    public void setPdate(Timestamp pdate) {
        this.pdate = pdate;
    }
   








}
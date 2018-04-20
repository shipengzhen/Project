package com.spz.hospital.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Pay entity. @author MyEclipse Persistence Tools
 */

public class Pay  implements java.io.Serializable {


    // Fields    

     private Integer pid;
     private String pname;
     private Double pmoney;
     private Timestamp pdate;
     private Set payreds = new HashSet(0);


    // Constructors

    /** default constructor */
    public Pay() {
    }

	/** minimal constructor */
    public Pay(String pname, Double pmoney, Timestamp pdate) {
        this.pname = pname;
        this.pmoney = pmoney;
        this.pdate = pdate;
    }
    
    /** full constructor */
    public Pay(String pname, Double pmoney, Timestamp pdate, Set payreds) {
        this.pname = pname;
        this.pmoney = pmoney;
        this.pdate = pdate;
        this.payreds = payreds;
    }

   
    // Property accessors

    public Integer getPid() {
        return this.pid;
    }
    
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return this.pname;
    }
    
    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getPmoney() {
        return this.pmoney;
    }
    
    public void setPmoney(Double pmoney) {
        this.pmoney = pmoney;
    }

    public Timestamp getPdate() {
        return this.pdate;
    }
    
    public void setPdate(Timestamp pdate) {
        this.pdate = pdate;
    }

    public Set getPayreds() {
        return this.payreds;
    }
    
    public void setPayreds(Set payreds) {
        this.payreds = payreds;
    }
   








}
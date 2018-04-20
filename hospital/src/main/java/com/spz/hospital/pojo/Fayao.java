package com.spz.hospital.pojo;



/**
 * Fayao entity. @author MyEclipse Persistence Tools
 */

public class Fayao  implements java.io.Serializable {


    // Fields    

     private Integer fid;
     private Guahao guahao;
     private Yao yao;
     private Integer FNum;
     private Integer FYnum;
     private Integer FWnum;


    // Constructors

    /** default constructor */
    public Fayao() {
    }

    
    /** full constructor */
    public Fayao(Guahao guahao, Yao yao, Integer FNum, Integer FYnum, Integer FWnum) {
        this.guahao = guahao;
        this.yao = yao;
        this.FNum = FNum;
        this.FYnum = FYnum;
        this.FWnum = FWnum;
    }

   
    // Property accessors

    public Integer getFid() {
        return this.fid;
    }
    
    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Guahao getGuahao() {
        return this.guahao;
    }
    
    public void setGuahao(Guahao guahao) {
        this.guahao = guahao;
    }

    public Yao getYao() {
        return this.yao;
    }
    
    public void setYao(Yao yao) {
        this.yao = yao;
    }

    public Integer getFNum() {
        return this.FNum;
    }
    
    public void setFNum(Integer FNum) {
        this.FNum = FNum;
    }

    public Integer getFYnum() {
        return this.FYnum;
    }
    
    public void setFYnum(Integer FYnum) {
        this.FYnum = FYnum;
    }

    public Integer getFWnum() {
        return this.FWnum;
    }
    
    public void setFWnum(Integer FWnum) {
        this.FWnum = FWnum;
    }
   








}
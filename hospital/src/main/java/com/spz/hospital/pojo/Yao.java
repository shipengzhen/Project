package com.spz.hospital.pojo;

import java.util.HashSet;
import java.util.Set;


/**
 * Yao entity. @author MyEclipse Persistence Tools
 */

public class Yao  implements java.io.Serializable {


    // Fields    

     private String yno;
     private String YImg;
     private Double YJj;
     private Double YSj;
     private String YName;
     private Integer YType;
     private String YMs;
     private Integer YBaozhi;
     private String YXxms;
     private String YSccs;
     private String YState;
     private Integer YKucun;
     private Set fayaos = new HashSet(0);


    // Constructors

    /** default constructor */
    public Yao() {
    }

	/** minimal constructor */
    public Yao(Double YJj, Double YSj, String YName, Integer YType, String YMs, Integer YBaozhi, String YXxms, String YSccs, String YState, Integer YKucun) {
        this.YJj = YJj;
        this.YSj = YSj;
        this.YName = YName;
        this.YType = YType;
        this.YMs = YMs;
        this.YBaozhi = YBaozhi;
        this.YXxms = YXxms;
        this.YSccs = YSccs;
        this.YState = YState;
        this.YKucun = YKucun;
    }
    
    /** full constructor */
    public Yao(String YImg, Double YJj, Double YSj, String YName, Integer YType, String YMs, Integer YBaozhi, String YXxms, String YSccs, String YState, Integer YKucun, Set fayaos) {
        this.YImg = YImg;
        this.YJj = YJj;
        this.YSj = YSj;
        this.YName = YName;
        this.YType = YType;
        this.YMs = YMs;
        this.YBaozhi = YBaozhi;
        this.YXxms = YXxms;
        this.YSccs = YSccs;
        this.YState = YState;
        this.YKucun = YKucun;
        this.fayaos = fayaos;
    }

   
    // Property accessors

    public String getYno() {
        return this.yno;
    }
    
    public void setYno(String yno) {
        this.yno = yno;
    }

    public String getYImg() {
        return this.YImg;
    }
    
    public void setYImg(String YImg) {
        this.YImg = YImg;
    }

    public Double getYJj() {
        return this.YJj;
    }
    
    public void setYJj(Double YJj) {
        this.YJj = YJj;
    }

    public Double getYSj() {
        return this.YSj;
    }
    
    public void setYSj(Double YSj) {
        this.YSj = YSj;
    }

    public String getYName() {
        return this.YName;
    }
    
    public void setYName(String YName) {
        this.YName = YName;
    }

    public Integer getYType() {
        return this.YType;
    }
    
    public void setYType(Integer YType) {
        this.YType = YType;
    }

    public String getYMs() {
        return this.YMs;
    }
    
    public void setYMs(String YMs) {
        this.YMs = YMs;
    }

    public Integer getYBaozhi() {
        return this.YBaozhi;
    }
    
    public void setYBaozhi(Integer YBaozhi) {
        this.YBaozhi = YBaozhi;
    }

    public String getYXxms() {
        return this.YXxms;
    }
    
    public void setYXxms(String YXxms) {
        this.YXxms = YXxms;
    }

    public String getYSccs() {
        return this.YSccs;
    }
    
    public void setYSccs(String YSccs) {
        this.YSccs = YSccs;
    }

    public String getYState() {
        return this.YState;
    }
    
    public void setYState(String YState) {
        this.YState = YState;
    }

    public Integer getYKucun() {
        return this.YKucun;
    }
    
    public void setYKucun(Integer YKucun) {
        this.YKucun = YKucun;
    }

    public Set getFayaos() {
        return this.fayaos;
    }
    
    public void setFayaos(Set fayaos) {
        this.fayaos = fayaos;
    }
   








}
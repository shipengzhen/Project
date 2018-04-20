package com.spz.hospital.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Guahao entity. @author MyEclipse Persistence Tools
 */

public class Guahao  implements java.io.Serializable {


    // Fields    

     private Integer gid;
     private Kerome kerome;
     private Doctor doctor;
     private String gname;
     private String GCard;
     private String GShebao;
     private Double GMoney;
     private String GPhone;
     private Integer GZifei;
     private String GSex;
     private Integer GAge;
     private String GZhiye;
     private Integer GCf;
     private String GBeizhu;
     private String GStatus;
     private Timestamp GData;
     private Set payreds = new HashSet(0);
     private Set zhuyuans = new HashSet(0);
     private Set fayaos = new HashSet(0);


    // Constructors

    /** default constructor */
    public Guahao() {
    }

	/** minimal constructor */
    public Guahao(Kerome kerome, Doctor doctor, String gname, String GCard, String GShebao, Double GMoney, String GPhone, Integer GZifei, String GSex, Integer GAge, Integer GCf, String GBeizhu, String GStatus, Timestamp GData) {
        this.kerome = kerome;
        this.doctor = doctor;
        this.gname = gname;
        this.GCard = GCard;
        this.GShebao = GShebao;
        this.GMoney = GMoney;
        this.GPhone = GPhone;
        this.GZifei = GZifei;
        this.GSex = GSex;
        this.GAge = GAge;
        this.GCf = GCf;
        this.GBeizhu = GBeizhu;
        this.GStatus = GStatus;
        this.GData = GData;
    }
    
    /** full constructor */
    public Guahao(Kerome kerome, Doctor doctor, String gname, String GCard, String GShebao, Double GMoney, String GPhone, Integer GZifei, String GSex, Integer GAge, String GZhiye, Integer GCf, String GBeizhu, String GStatus, Timestamp GData, Set payreds, Set zhuyuans, Set fayaos) {
        this.kerome = kerome;
        this.doctor = doctor;
        this.gname = gname;
        this.GCard = GCard;
        this.GShebao = GShebao;
        this.GMoney = GMoney;
        this.GPhone = GPhone;
        this.GZifei = GZifei;
        this.GSex = GSex;
        this.GAge = GAge;
        this.GZhiye = GZhiye;
        this.GCf = GCf;
        this.GBeizhu = GBeizhu;
        this.GStatus = GStatus;
        this.GData = GData;
        this.payreds = payreds;
        this.zhuyuans = zhuyuans;
        this.fayaos = fayaos;
    }

   
    // Property accessors

    public Integer getGid() {
        return this.gid;
    }
    
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Kerome getKerome() {
        return this.kerome;
    }
    
    public void setKerome(Kerome kerome) {
        this.kerome = kerome;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getGname() {
        return this.gname;
    }
    
    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGCard() {
        return this.GCard;
    }
    
    public void setGCard(String GCard) {
        this.GCard = GCard;
    }

    public String getGShebao() {
        return this.GShebao;
    }
    
    public void setGShebao(String GShebao) {
        this.GShebao = GShebao;
    }

    public Double getGMoney() {
        return this.GMoney;
    }
    
    public void setGMoney(Double GMoney) {
        this.GMoney = GMoney;
    }

    public String getGPhone() {
        return this.GPhone;
    }
    
    public void setGPhone(String GPhone) {
        this.GPhone = GPhone;
    }

    public Integer getGZifei() {
        return this.GZifei;
    }
    
    public void setGZifei(Integer GZifei) {
        this.GZifei = GZifei;
    }

    public String getGSex() {
        return this.GSex;
    }
    
    public void setGSex(String GSex) {
        this.GSex = GSex;
    }

    public Integer getGAge() {
        return this.GAge;
    }
    
    public void setGAge(Integer GAge) {
        this.GAge = GAge;
    }

    public String getGZhiye() {
        return this.GZhiye;
    }
    
    public void setGZhiye(String GZhiye) {
        this.GZhiye = GZhiye;
    }

    public Integer getGCf() {
        return this.GCf;
    }
    
    public void setGCf(Integer GCf) {
        this.GCf = GCf;
    }

    public String getGBeizhu() {
        return this.GBeizhu;
    }
    
    public void setGBeizhu(String GBeizhu) {
        this.GBeizhu = GBeizhu;
    }

    public String getGStatus() {
        return this.GStatus;
    }
    
    public void setGStatus(String GStatus) {
        this.GStatus = GStatus;
    }

    public Timestamp getGData() {
        return this.GData;
    }
    
    public void setGData(Timestamp GData) {
        this.GData = GData;
    }

    public Set getPayreds() {
        return this.payreds;
    }
    
    public void setPayreds(Set payreds) {
        this.payreds = payreds;
    }

    public Set getZhuyuans() {
        return this.zhuyuans;
    }
    
    public void setZhuyuans(Set zhuyuans) {
        this.zhuyuans = zhuyuans;
    }

    public Set getFayaos() {
        return this.fayaos;
    }
    
    public void setFayaos(Set fayaos) {
        this.fayaos = fayaos;
    }
   








}
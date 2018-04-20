package com.spz.hospital.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Doctor entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Doctor  implements java.io.Serializable {


    // Fields    

     private Integer did;
     private Kerome kerome;
     private String DZsname;
     private String DCard;
     private String DPhone;
     private String DZuoji;
     private String DSex;
     private Timestamp DCsday;
     private Integer DAge;
     private String DEmail;
     private String DXueli;
     private String DBeizhu;
     private Integer uid;
     private Set guahaos = new HashSet(0);


    // Constructors

    /** default constructor */
    public Doctor() {
    }

	/** minimal constructor */
    public Doctor(Kerome kerome, String DZsname, String DCard, String DPhone, String DZuoji, String DSex, Timestamp DCsday, Integer DAge, String DEmail, String DXueli, String DBeizhu, Integer uid) {
        this.kerome = kerome;
        this.DZsname = DZsname;
        this.DCard = DCard;
        this.DPhone = DPhone;
        this.DZuoji = DZuoji;
        this.DSex = DSex;
        this.DCsday = DCsday;
        this.DAge = DAge;
        this.DEmail = DEmail;
        this.DXueli = DXueli;
        this.DBeizhu = DBeizhu;
        this.uid = uid;
    }
    
    /** full constructor */
    public Doctor(Kerome kerome, String DZsname, String DCard, String DPhone, String DZuoji, String DSex, Timestamp DCsday, Integer DAge, String DEmail, String DXueli, String DBeizhu, Integer uid, Set guahaos) {
        this.kerome = kerome;
        this.DZsname = DZsname;
        this.DCard = DCard;
        this.DPhone = DPhone;
        this.DZuoji = DZuoji;
        this.DSex = DSex;
        this.DCsday = DCsday;
        this.DAge = DAge;
        this.DEmail = DEmail;
        this.DXueli = DXueli;
        this.DBeizhu = DBeizhu;
        this.uid = uid;
        this.guahaos = guahaos;
    }

   
    // Property accessors

    public Integer getDid() {
        return this.did;
    }
    
    public void setDid(Integer did) {
        this.did = did;
    }

    public Kerome getKerome() {
        return this.kerome;
    }
    
    public void setKerome(Kerome kerome) {
        this.kerome = kerome;
    }

    public String getDZsname() {
        return this.DZsname;
    }
    
    public void setDZsname(String DZsname) {
        this.DZsname = DZsname;
    }

    public String getDCard() {
        return this.DCard;
    }
    
    public void setDCard(String DCard) {
        this.DCard = DCard;
    }

    public String getDPhone() {
        return this.DPhone;
    }
    
    public void setDPhone(String DPhone) {
        this.DPhone = DPhone;
    }

    public String getDZuoji() {
        return this.DZuoji;
    }
    
    public void setDZuoji(String DZuoji) {
        this.DZuoji = DZuoji;
    }

    public String getDSex() {
        return this.DSex;
    }
    
    public void setDSex(String DSex) {
        this.DSex = DSex;
    }

    public Timestamp getDCsday() {
        return this.DCsday;
    }
    
    public void setDCsday(Timestamp DCsday) {
        this.DCsday = DCsday;
    }

    public Integer getDAge() {
        return this.DAge;
    }
    
    public void setDAge(Integer DAge) {
        this.DAge = DAge;
    }

    public String getDEmail() {
        return this.DEmail;
    }
    
    public void setDEmail(String DEmail) {
        this.DEmail = DEmail;
    }

    public String getDXueli() {
        return this.DXueli;
    }
    
    public void setDXueli(String DXueli) {
        this.DXueli = DXueli;
    }

    public String getDBeizhu() {
        return this.DBeizhu;
    }
    
    public void setDBeizhu(String DBeizhu) {
        this.DBeizhu = DBeizhu;
    }

    public Integer getUid() {
        return this.uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Set getGuahaos() {
        return this.guahaos;
    }
    
    public void setGuahaos(Set guahaos) {
        this.guahaos = guahaos;
    }
   








}
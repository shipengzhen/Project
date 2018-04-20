package com.spz.hospital.pojo;

import java.util.HashSet;
import java.util.Set;


/**
 * Kerome entity. @author MyEclipse Persistence Tools
 */

public class Kerome  implements java.io.Serializable {


    // Fields    

     private Integer kid;
     private String kname;
     private Set doctors = new HashSet(0);
     private Set guahaos = new HashSet(0);


    // Constructors

    /** default constructor */
    public Kerome() {
    }

	/** minimal constructor */
    public Kerome(String kname) {
        this.kname = kname;
    }
    
    /** full constructor */
    public Kerome(String kname, Set doctors, Set guahaos) {
        this.kname = kname;
        this.doctors = doctors;
        this.guahaos = guahaos;
    }

   
    // Property accessors

    public Integer getKid() {
        return this.kid;
    }
    
    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getKname() {
        return this.kname;
    }
    
    public void setKname(String kname) {
        this.kname = kname;
    }

    public Set getDoctors() {
        return this.doctors;
    }
    
    public void setDoctors(Set doctors) {
        this.doctors = doctors;
    }

    public Set getGuahaos() {
        return this.guahaos;
    }
    
    public void setGuahaos(Set guahaos) {
        this.guahaos = guahaos;
    }
   








}
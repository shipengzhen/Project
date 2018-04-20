package com.spz.hospital.pojo;

import java.util.HashSet;
import java.util.Set;


/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role  implements java.io.Serializable {


    // Fields    

     private Integer rid;
     private String rname;
     private Integer rstate;
     private Set usees = new HashSet(0);
     private Set menus = new HashSet(0);


    // Constructors

    /** default constructor */
    public Role() {
    }

	/** minimal constructor */
    public Role(String rname, Integer rstate) {
        this.rname = rname;
        this.rstate = rstate;
    }
    
    /** full constructor */
    public Role(String rname, Integer rstate, Set usees, Set menus) {
        this.rname = rname;
        this.rstate = rstate;
        this.usees = usees;
        this.menus = menus;
    }

   
    // Property accessors

    public Integer getRid() {
        return this.rid;
    }
    
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return this.rname;
    }
    
    public void setRname(String rname) {
        this.rname = rname;
    }

    public Integer getRstate() {
        return this.rstate;
    }
    
    public void setRstate(Integer rstate) {
        this.rstate = rstate;
    }

    public Set getUsees() {
        return this.usees;
    }
    
    public void setUsees(Set usees) {
        this.usees = usees;
    }

    public Set getMenus() {
        return this.menus;
    }
    
    public void setMenus(Set menus) {
        this.menus = menus;
    }
   








}
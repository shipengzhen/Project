package com.spz.hospital.pojo;

import java.util.HashSet;
import java.util.Set;


/**
 * Menu entity. @author MyEclipse Persistence Tools
 */

public class Menu  implements java.io.Serializable {


    // Fields    

     private Integer mid;
     private String text;
     private String href;
     private Integer myx;
     private Set roles = new HashSet(0);


    // Constructors

    /** default constructor */
    public Menu() {
    }

	/** minimal constructor */
    public Menu(String text, String href, Integer myx) {
        this.text = text;
        this.href = href;
        this.myx = myx;
    }
    
    /** full constructor */
    public Menu(String text, String href, Integer myx, Set roles) {
        this.text = text;
        this.href = href;
        this.myx = myx;
        this.roles = roles;
    }

   
    // Property accessors

    public Integer getMid() {
        return this.mid;
    }
    
    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return this.href;
    }
    
    public void setHref(String href) {
        this.href = href;
    }

    public Integer getMyx() {
        return this.myx;
    }
    
    public void setMyx(Integer myx) {
        this.myx = myx;
    }

    public Set getRoles() {
        return this.roles;
    }
    
    public void setRoles(Set roles) {
        this.roles = roles;
    }
   








}
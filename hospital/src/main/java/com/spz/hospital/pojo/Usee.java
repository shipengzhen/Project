package com.spz.hospital.pojo;



/**
 * Usee entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Usee  implements java.io.Serializable {


    // Fields    

     private Integer uid;
     private Role role;
     private String uname;
     private String password;
     private Integer ustate;
     private String uzsname;
     private String uemail;


    // Constructors

    /** default constructor */
    public Usee() {
    }

	/** minimal constructor */
    public Usee(String uname, String password, Integer ustate, String uzsname, String uemail) {
        this.uname = uname;
        this.password = password;
        this.ustate = ustate;
        this.uzsname = uzsname;
        this.uemail = uemail;
    }
    
    /** full constructor */
    public Usee(Role role, String uname, String password, Integer ustate, String uzsname, String uemail) {
        this.role = role;
        this.uname = uname;
        this.password = password;
        this.ustate = ustate;
        this.uzsname = uzsname;
        this.uemail = uemail;
    }

   
    // Property accessors

    public Integer getUid() {
        return this.uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }

    public String getUname() {
        return this.uname;
    }
    
    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUstate() {
        return this.ustate;
    }
    
    public void setUstate(Integer ustate) {
        this.ustate = ustate;
    }

    public String getUzsname() {
        return this.uzsname;
    }
    
    public void setUzsname(String uzsname) {
        this.uzsname = uzsname;
    }

    public String getUemail() {
        return this.uemail;
    }
    
    public void setUemail(String uemail) {
        this.uemail = uemail;
    }
   








}
package com.bdqn.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 挂号
 * @author lizhen
 * @date 2018年2月22日
 * @time 下午6:42:32
 */
public class TbRegister {
	// 新增
	private String doctorName;	//医生
	private String opdname;     //科室
	private Date ryDate;		//住院时间
	private Integer bedid;		//床号
	private String hushi;		//护士
	private double ymoeny;		//余额
	
	//发药
	private Integer did;		//发药id
	private Integer medicineNumber;	//药品数量
	private Integer medicineYF;		//已发药品数量
	private String 	medicineNmae;	//药品名称
  
	

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Integer getMedicineNumber() {
		return medicineNumber;
	}

	public void setMedicineNumber(Integer medicineNumber) {
		this.medicineNumber = medicineNumber;
	}

	public Integer getMedicineYF() {
		return medicineYF;
	}

	public void setMedicineYF(Integer medicineYF) {
		this.medicineYF = medicineYF;
	}

	public String getMedicineNmae() {
		return medicineNmae;
	}

	public void setMedicineNmae(String medicineNmae) {
		this.medicineNmae = medicineNmae;
	}

	public String getHushi() {
		return hushi;
	}

	public void setHushi(String hushi) {
		this.hushi = hushi;
	}

	public double getYmoeny() {
		return ymoeny;
	}

	public void setYmoeny(double ymoeny) {
		this.ymoeny = ymoeny;
	}

	public Date getRyDate() {
		return ryDate;
	}

	public void setRyDate(Date ryDate) {
		this.ryDate = ryDate;
	}

	public Integer getBedid() {
		return bedid;
	}

	public void setBedid(Integer bedid) {
		this.bedid = bedid;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getOpdname() {
		return opdname;
	}

	public void setOpdname(String opdname) {
		this.opdname = opdname;
	}

	private Integer id;

    private String name;

    private String idcard;

    private String seid;

    private BigDecimal cost;

    private String phone;

    private String isfy;

    private String sex;

    private String occupation;

    private Integer age;

    private String cfz;

    private Integer opdid;

    private Integer doctorid;

    private String remarks;

    private BigDecimal cashPledge;

    private BigDecimal hfcost;

    private Integer status;

    private Date created;

    private Date updated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getSeid() {
        return seid;
    }

    public void setSeid(String seid) {
        this.seid = seid == null ? null : seid.trim();
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIsfy() {
        return isfy;
    }

    public void setIsfy(String isfy) {
        this.isfy = isfy == null ? null : isfy.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCfz() {
        return cfz;
    }

    public void setCfz(String cfz) {
        this.cfz = cfz == null ? null : cfz.trim();
    }

    public Integer getOpdid() {
        return opdid;
    }

    public void setOpdid(Integer opdid) {
        this.opdid = opdid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public BigDecimal getCashPledge() {
        return cashPledge;
    }

    public void setCashPledge(BigDecimal cashPledge) {
        this.cashPledge = cashPledge;
    }

    public BigDecimal getHfcost() {
        return hfcost;
    }

    public void setHfcost(BigDecimal hfcost) {
        this.hfcost = hfcost;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
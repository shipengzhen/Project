package com.bdqn.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 药品管理
 * @author lizhen
 * @date 2018年2月23日
 * @time 下午3:58:22
 */
public class TbMedicine {
    private String id;

    private String img;

    private BigDecimal jprice;

    private BigDecimal sprice;

    private String medicinenmae;

    private String medicinetype;

    private String describe;

    private String qgp;

    private String doc;

    private String factory;

    private String eatdoc;

    private String remarks;

    private Integer stock;

    private Integer status;

    private Date created;

    private Date updated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public BigDecimal getJprice() {
        return jprice;
    }

    public void setJprice(BigDecimal jprice) {
        this.jprice = jprice;
    }

    public BigDecimal getSprice() {
        return sprice;
    }

    public void setSprice(BigDecimal sprice) {
        this.sprice = sprice;
    }

    public String getMedicinenmae() {
        return medicinenmae;
    }

    public void setMedicinenmae(String medicinenmae) {
        this.medicinenmae = medicinenmae == null ? null : medicinenmae.trim();
    }

    public String getMedicinetype() {
        return medicinetype;
    }

    public void setMedicinetype(String medicinetype) {
        this.medicinetype = medicinetype == null ? null : medicinetype.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getQgp() {
        return qgp;
    }

    public void setQgp(String qgp) {
        this.qgp = qgp == null ? null : qgp.trim();
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc == null ? null : doc.trim();
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    public String getEatdoc() {
        return eatdoc;
    }

    public void setEatdoc(String eatdoc) {
        this.eatdoc = eatdoc == null ? null : eatdoc.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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
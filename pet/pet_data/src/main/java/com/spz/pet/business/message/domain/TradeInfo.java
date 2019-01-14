package com.spz.pet.business.message.domain;

import java.io.Serializable;

/**  
 * Copyright © 2018Company. All rightsreserved.
 * @文件名 Message.java
 * @项目名 pet_data
 * @包名 com.spz.pet.domain
 * @类名 Message
 * @功能描述 TODO
 * @创建人 施鹏振 
 * @创建时间 2018年11月27日上午10:10:55
 * @版本 TODO
 */
public class TradeInfo implements Serializable {

    private static final long serialVersionUID = 2139404872563159493L;

    private String tradeNo;

    private String userId;

    private String address;

    private String message;

    private String contact;

    private String type;

    private String latitude;

    private String longitude;

    /**
     * @方法名 getTradeNo
     * @param String tradeNo
     * @return String
     * @功能描述 TODO
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:25:05
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * @方法名 setTradeNo
     * @param String tradeNo
     * @功能描述 TODO
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:25:05
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    /**
     * @方法名 getUserId
     * @param String userId
     * @return String
     * @功能描述 TODO
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:25:05
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @方法名 setUserId
     * @param String userId
     * @功能描述 TODO
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:25:05
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @方法名 getAddress
     * @param String address
     * @return String
     * @功能描述 TODO
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:25:05
     */
    public String getAddress() {
        return address;
    }

    /**
     * @方法名 setAddress
     * @param String address
     * @功能描述 TODO
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:25:05
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @方法名 getMessage
     * @param String message
     * @return String
     * @功能描述 TODO
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:25:05
     */
    public String getMessage() {
        return message;
    }

    /**
     * @方法名 setMessage
     * @param String message
     * @功能描述 TODO
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:25:05
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @方法名 getContact
     * @param String contact
     * @return String
     * @功能描述 TODO
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:25:05
     */
    public String getContact() {
        return contact;
    }

    /**
     * @方法名 setContact
     * @param String contact
     * @功能描述 TODO
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:25:05
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @方法名 getType
     * @param String type
     * @return String
     * @功能描述 TODO
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:25:05
     */
    public String getType() {
        return type;
    }

    /**
     * @方法名 setType
     * @param String type
     * @功能描述 TODO
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:25:05
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @方法名 getLatitude
     * @param String latitude
     * @return String
     * @功能描述 TODO
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:25:05
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @方法名 setLatitude
     * @param String latitude
     * @功能描述 TODO
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:25:05
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @方法名 getLongitude
     * @param String longitude
     * @return String
     * @功能描述 TODO
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:25:05
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @方法名 setLongitude
     * @param String longitude
     * @功能描述 TODO
     * @创建人 施鹏振 
     * @创建时间 2018年11月27日上午10:25:05
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}

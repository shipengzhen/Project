package com.inspur.tech.pds.data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import com.inspur.tech.pds.util.excel.ApiField;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Summary :〈一句话功能简述〉 Create on : 2018年8月10日 上午10:29:32 Description :〈功能详细描述〉
 * Copyright (C) Inspur Co.,Ltd.
 * 
 * @author changxuemin
 * @version 2018年8月10日
 * @since
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ScientificResearchDto extends ParentInfo {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -4050326607112765872L;

	/**
	 * 仪器名称
	 */
	@ApiField("name")
	private String instrumentName;

	/**
	 * 仪器序列号
	 */
	@ApiField("SERIAL_NUMBER")
	private String serialNumber;

	/**
	 * 仪器型号
	 */
	@ApiField("SPECIFICATION_TYPE")
	private String specificationType;

	/**
	 * 设备原值
	 */
	@ApiField("VALUE")
	private BigDecimal instrumentValue;

	/**
	 * 服务领域
	 */
	@ApiField("SERVICE_FIELD")
	private String serviceField;

	/**
	 * 购置时间
	 */
	@ApiField("PURCHASE_TIME")
	private Date purchaseTime;

	/**
	 * 现有面积
	 */
	@ApiField("AREA")
	private BigDecimal area;

	/**
	 * 依托单位配套经费
	 */
	@ApiField("FUNDING")
	private BigDecimal funding;

	/**
	 * 实验室自筹经费
	 */
	@ApiField("SELF_FINANCING")
	private BigDecimal selfFinancing;

	/**
	 * 更新时间
	 */
	@ApiField("UPDATE_TIME")
	private Timestamp updateTime;

}
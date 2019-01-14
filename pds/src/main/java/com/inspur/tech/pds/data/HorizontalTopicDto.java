package com.inspur.tech.pds.data;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.inspur.tech.pds.util.excel.ApiField;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class HorizontalTopicDto extends ParentInfo {

	private static final long serialVersionUID = 1L;

	/**
	 * 项目名称
	 */
	@ApiField("PROJECT_NAME")
	private String projectName;

	/**
	 * 项目编号
	 */
	@ApiField("PROJECT_NUMBER")
	private String projectNumber;

	/**
	 * 项目负责人
	 */
	@ApiField("PROJECT_PRINCIPAL")
	private String projectPrincipal;

	/**
	 * 证件类型
	 */
	@ApiField("ID_TYPE")
	private String idType;

	/**
	 * 证件号码
	 */
	@ApiField("ID_NUMBER")
	private String idNumber;

	/**
	 * 起止时间
	 */
	@ApiField("START_STOP_DATE")
	private String startStopDate;

	/**
	 * 项目实到经费
	 */
	@ApiField("ACTUALLY_RECEIVED_FUNDS")
	private BigDecimal actuallyReceivedFunds;

	/**
	 * 委托单位
	 */
	@ApiField("ORGANIZATION")
	private String organization;

	/**
	 * 更新时间
	 */
	@ApiField("UPDATE_TIME")
	private Timestamp updateTime;

}
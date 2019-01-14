package com.inspur.tech.pds.data;

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
public class LaboratoryBasicDto extends ParentInfo {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -4205885768933001498L;

	/**
	 * 实验室名称
	 */
	@ApiField("name")
	protected String laboratoryName;

	/**
	 * 实验室地址
	 */
	@ApiField("address")
	private String address;

	/**
	 * 实验室区域
	 */
	@ApiField("area")
	private String area;

	/**
	 * 实验室类型
	 */
	@ApiField("type")
	private String laboratoryType;

	/**
	 * 批准时间
	 */
	@ApiField("approval_time")
	private Date approvalTime;

	/**
	 * 实验室主任姓名
	 */
	@ApiField("laboratory_director")
	private String laboratoryDirector;

	/**
	 * 出生日期
	 */
	@ApiField("birthdate")
	private Date birthdate;

	/**
	 * 职称
	 */
	@ApiField("PROFESSIONAL_TITLE")
	private String professionalTitle;

	/**
	 * 职务
	 */
	@ApiField("TECHNICAL_POSITION")
	private String technicalPosition;

	/**
	 * 学科专长
	 */
	@ApiField("SUBJECT_EXPERTISE")
	private String subjectExpertise;

	/**
	 * 实验室主任最高学历
	 */
	@ApiField("EDUCATION")
	private String education;

	/**
	 * 联系人姓名
	 */
	@ApiField("CONTACT_NAME")
	private String contactName;

	/**
	 * 联系人电话
	 */
	@ApiField("CONTACT_TELEPHONE")
	private String contactTelephone;

	/**
	 * 联系人电子邮箱
	 */
	@ApiField("CONTACT_EMAIL")
	private String contactEmail;

	/**
	 * 主管部门
	 */
	@ApiField("COMPETENT_ORGANIZATION")
	private String competentOrganization;

	/**
	 * 依托单位名称
	 */
	@ApiField("RELYING_ORGANIZATION")
	private String relyingOrganization;

	/**
	 * 依托单位性质
	 */
	@ApiField("ORGANIZATION_PROPERTY")
	private String organizationProperty;

	/**
	 * 学科领域
	 */
	@ApiField("SUBJECT_FIELD")
	private String subjectField;

	/**
	 * 研究方向
	 */
	@ApiField("RESEARCH_DIRECTION")
	private String researchDirection;

	/**
	 * 按照知识分配额度
	 */
	@ApiField("KNOWLEDGE_ALLOCATION_QUOTA")
	private String knowledgeAllocationQuota;

	/**
	 * 实验室工资总额
	 */
	@ApiField("TOTAL_WAGES")
	private String totalWages;

	/**
	 * 更新时间
	 */
	@ApiField("UPDATE_TIME")
	private Timestamp updateTime;

}
package com.inspur.tech.pds.data;

import java.io.Serializable;

import com.inspur.tech.pds.util.excel.ApiField;

import lombok.Data;

/**
 * Copyright © 2019Company. All rightsreserved.
 * 
 * @文件名 ParentInfo.java
 * @项目名 pds
 * @包名 com.inspur.tech.pds.data
 * @类名 ParentInfo
 * @功能描述 父信息类
 * @创建人 施鹏振
 * @创建时间 2019年1月12日下午9:12:24
 * @版本 TODO
 */
@Data
public class ParentInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 唯一标识
	 */
	private String id;

	/**
	 * 实验室唯一标识
	 */
	protected String scientificId;

	/**
	 * 实验室名称
	 */
	@ApiField("LABORATORY_NAME")
	protected String laboratoryName;

	/**
	 * 备注
	 */
	private String remark;

}

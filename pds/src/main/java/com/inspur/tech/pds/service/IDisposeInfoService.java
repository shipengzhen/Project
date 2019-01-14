package com.inspur.tech.pds.service;

import java.io.File;

import com.inspur.tech.pds.data.ApiResult;

/**
 * Summary :〈一句话功能简述〉Service层 接口类，用于业务逻辑处理，事务控制等 Create on : 2018年8月10日
 * 下午3:03:18 Description :〈功能详细描述〉 Copyright (C) Inspur Co.,Ltd.
 * 
 * @author changxuemin
 * @version 2018年8月10日
 * @see
 * @since
 */
public interface IDisposeInfoService {

	/**
	 * @方法名 dipBasicInfo
	 * @return boolean
	 * @功能描述 处理基本信息
	 * @创建人 施鹏振
	 * @创建时间 2019年1月12日下午9:02:38
	 */
	public boolean dipBasicInfo(File file);

	/**
	 * @方法名 dipHorizontalTopicInfo
	 * @param file
	 * @param classs
	 * @return boolean
	 * @功能描述 处理横向课题信息
	 * @创建人 施鹏振
	 * @创建时间 2019年1月13日上午9:14:32
	 */
	public boolean dipHorizontalTopicInfo(File file);

	/**
	 * @方法名 dipScientificInfo
	 * @param file
	 * @return boolean
	 * @功能描述 处理科研保障信息
	 * @创建人 施鹏振
	 * @创建时间 2019年1月13日上午9:19:50
	 */
	public boolean dipScientificGuaranteeInfo(File file);

	/**
	 * @方法名 findFormInfo
	 * @param fileType
	 * @return ApiResult
	 * @功能描述 获取信息
	 * @创建人 施鹏振
	 * @创建时间 2019年1月13日下午1:37:25
	 */
	public ApiResult findFormInfo(String fileType, ApiResult apiResult);
}

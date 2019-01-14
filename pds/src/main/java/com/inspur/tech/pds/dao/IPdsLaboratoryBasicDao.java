package com.inspur.tech.pds.dao;

import java.util.List;
import java.util.Map;

import com.inspur.tech.pds.data.LaboratoryBasicDto;

/**
 * Dao层 接口类，用于持久化数据处理 Summary :〈一句话功能简述〉 Create on : 2018年8月10日 上午11:59:00
 * Description :〈功能详细描述〉 Copyright (C) Inspur Co.,Ltd.
 * 
 * @version 2018年8月10日
 * @since
 */
public interface IPdsLaboratoryBasicDao {

	/**
	 * Description: 查询实验室基本信息列表<br>
	 * 
	 * @param parameters
	 * @return
	 */
	List<LaboratoryBasicDto> listLaboratoryBasic(Map<String, Object> parameters);

	/**
	 * Description: 获取实验室基本信息<br>
	 * 
	 * @param id 唯一标识
	 * @return
	 */
	LaboratoryBasicDto selectLaboratoryBasicById(String id);

	/**
	 * @方法名 selectLaboratoryBasicIdByName
	 * @param name
	 * @return String
	 * @功能描述 通过名称查询
	 * @创建人 施鹏振
	 * @创建时间 2019年1月13日上午9:10:14
	 */
	public String selectLaboratoryBasicIdByName(String name);

	/**
	 * @方法名 selectLaboratoryBasic
	 * @return List<LaboratoryBasicDto>
	 * @功能描述 查询所有基本信息
	 * @创建人 施鹏振
	 * @创建时间 2019年1月13日下午3:26:40
	 */
	public List<LaboratoryBasicDto> selectLaboratoryBasic();

	/**
	 * 保存实验室基本信息
	 *
	 * @param laboratoryBasicDto 实验室基本信息
	 */
	int insert(LaboratoryBasicDto laboratoryBasicDto);

	/**
	 * 实验室基本信息列表保存
	 *
	 * @param laboratoryBasicDtoList 实验室基本信息列表
	 */
	int insertLaboratoryBasics(List<LaboratoryBasicDto> laboratoryBasicDtoList);
}

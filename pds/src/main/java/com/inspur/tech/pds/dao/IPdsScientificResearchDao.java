package com.inspur.tech.pds.dao;

import java.util.List;
import java.util.Map;

import com.inspur.tech.pds.data.ScientificResearchDto;

/**
 * Dao层 接口类，用于持久化数据处理 Summary :〈一句话功能简述〉 Create on : 2018年8月10日 上午11:59:00
 * Description :〈功能详细描述〉 Copyright (C) Inspur Co.,Ltd.
 * 
 * @version 2018年8月10日
 * @since
 */
public interface IPdsScientificResearchDao {

	/**
	 * Description: 查询科研保障信息列表<br>
	 * 
	 * @param parameters
	 * @return
	 */
	List<ScientificResearchDto> listScientificResearch(Map<String, Object> parameters);

	/**
	 * @方法名 selectScientificResearchList
	 * @return List<ScientificResearchDto>
	 * @功能描述 查询科研保障信息列表
	 * @创建人 施鹏振
	 * @创建时间 2019年1月13日下午3:30:38
	 */
	public List<ScientificResearchDto> selectScientificResearchList();

	/**
	 * Description: 获取科研保障信息<br>
	 * 
	 * @param id 唯一标识
	 * @return
	 */
	ScientificResearchDto selectScientificResearchById(String id);

	/**
	 * 保存科研保障信息
	 *
	 * @param scientificResearchDto 科研保障信息
	 */
	int insert(ScientificResearchDto scientificResearchDto);

	/**
	 * 科研保障信息列表保存
	 *
	 * @param scientificResearchDtos 科研保障信息列表
	 */
	int insertScientificResearchs(List<ScientificResearchDto> scientificResearchDtos);

	/**
	 * Description: 查询每个实验室的现有面积总和<br>
	 * 
	 * @return
	 */
	List<ScientificResearchDto> selectLaboratoryArea();
}

package com.inspur.tech.pds.dao;

import java.util.List;
import java.util.Map;

import com.inspur.tech.pds.data.HorizontalTopicDto;

/**
 * Dao层 接口类，用于持久化数据处理 Summary :〈一句话功能简述〉 Create on : 2018年8月10日 上午11:59:00
 * Description :〈功能详细描述〉 Copyright (C) Inspur Co.,Ltd.
 * 
 * @version 2018年8月10日
 * @since
 */
public interface IPdsHorizontalTopicDao {

	List<HorizontalTopicDto> listHorizontalTopic(Map<String, Object> parameters);

	HorizontalTopicDto selectHorizontalTopicById(String id);
	
	/**
	 * @方法名 selectHorizontalTopicList
	 * @return List<HorizontalTopicDto>
	 * @功能描述 查询所有横向课题
	 * @创建人 施鹏振 
	 * @创建时间 2019年1月13日下午3:28:58
	 */
	public List<HorizontalTopicDto> selectHorizontalTopicList();

	int insert(HorizontalTopicDto horizontalTopicDto);

	int insertHorizontalTopics(List<HorizontalTopicDto> horizontalTopicDtoList);
}

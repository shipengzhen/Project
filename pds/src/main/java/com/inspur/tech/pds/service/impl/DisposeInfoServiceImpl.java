package com.inspur.tech.pds.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspur.tech.pds.dao.IPdsHorizontalTopicDao;
import com.inspur.tech.pds.dao.IPdsLaboratoryBasicDao;
import com.inspur.tech.pds.dao.IPdsScientificResearchDao;
import com.inspur.tech.pds.data.ApiResult;
import com.inspur.tech.pds.data.HorizontalTopicDto;
import com.inspur.tech.pds.data.LaboratoryBasicDto;
import com.inspur.tech.pds.data.ScientificResearchDto;
import com.inspur.tech.pds.service.IDisposeInfoService;
import com.inspur.tech.pds.util.excel.ExcelClass;

/**
 * Summary :Service层 实现类，用于业务逻辑处理，事务控制等 Create on : 2018年8月10日 下午3:22:40
 * Description :〈功能详细描述〉 Copyright (C) Inspur Co.,Ltd.
 *
 * @author shaochanghe
 * @version 2018年8月10日
 * @see
 * @since
 */
@Service
public class DisposeInfoServiceImpl implements IDisposeInfoService {

	@Autowired
	private IPdsLaboratoryBasicDao pdsLaboratoryBasicDao;

	@Autowired
	private IPdsHorizontalTopicDao pdsHorizontalTopicDao;

	@Autowired
	private IPdsScientificResearchDao pdsScientificResearchDao;

	@Override
	public boolean dipBasicInfo(File file) {
		List<LaboratoryBasicDto> laboratoryBasicDtoList = ExcelClass.getList(LaboratoryBasicDto.class, file);
		int insertLaboratoryBasics = pdsLaboratoryBasicDao.insertLaboratoryBasics(laboratoryBasicDtoList);
		if (insertLaboratoryBasics > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean dipHorizontalTopicInfo(File file) {
		List<HorizontalTopicDto> horizontalTopicDtos = ExcelClass.getList(HorizontalTopicDto.class, file);

//		for (HorizontalTopicDto horizontalTopicDto : horizontalTopicDtos) {
//			String laboratoryName = horizontalTopicDto.getLaboratoryName();
//			String scientificId = pdsLaboratoryBasicDao.selectLaboratoryBasicIdByName(laboratoryName);
//			horizontalTopicDto.setScientificId(scientificId);
//		}
		int insertHorizontalTopics = pdsHorizontalTopicDao.insertHorizontalTopics(horizontalTopicDtos);
		if (insertHorizontalTopics > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean dipScientificGuaranteeInfo(File file) {
		List<ScientificResearchDto> scientificResearchDtos = ExcelClass.getList(ScientificResearchDto.class, file);
		int insertScientificResearchs = pdsScientificResearchDao.insertScientificResearchs(scientificResearchDtos);
		if (insertScientificResearchs > 0) {
			return true;
		}
		return false;
	}

	@Override
	public ApiResult findFormInfo(String fileType, ApiResult apiResult) {
		switch (fileType) {
		case "JB":
			apiResult.setData(pdsLaboratoryBasicDao.selectLaboratoryBasic());
			break;
		case "HX":
			apiResult.setData(pdsHorizontalTopicDao.selectHorizontalTopicList());
			break;
		case "KY":
			apiResult.setData(pdsScientificResearchDao.selectScientificResearchList());
			break;
		default:
			apiResult.setData(pdsLaboratoryBasicDao.selectLaboratoryBasic());
			break;
		}

		return apiResult;
	}

}

package com.inspur.tech.pds.controller;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inspur.tech.pds.data.ApiResult;
import com.inspur.tech.pds.service.IDisposeInfoService;
import com.inspur.tech.pds.util.FileUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Copyright © 2019Company. All rightsreserved.
 * 
 * @文件名 FormInfoController.java
 * @项目名 pds
 * @包名 com.inspur.tech.pds.controller
 * @类名 FormInfoController
 * @功能描述 信息填报
 * @创建人 施鹏振
 * @创建时间 2019年1月13日上午9:07:49
 * @版本 TODO
 */
@RestController
@Slf4j
public class FormInfoController {

	@Autowired
	private Environment env;

	@Autowired
	private IDisposeInfoService disposeInfoService;

	@RequestMapping("index")
	public String index() {
		return "我是首页";
	}

	@PostMapping("fileUpload")
	public ApiResult uploadMusicFile(@RequestParam(required = true) MultipartFile multipartFile,
			@RequestParam(required = true) String fileType) {
		log.info("上传文件开始---------------------->");
		ApiResult result = new ApiResult();
		try {
			String uploadFormFilePath = fileType + env.getProperty("uploadFormFilePath");
			if (StringUtils.isNotBlank(FileUtil.upload(multipartFile, fileType, uploadFormFilePath))) {
				// 上传时的原文件名
				String oleFileName = multipartFile.getOriginalFilename();
				File file = new File(oleFileName);
				boolean res = false;
				switch (fileType) {
				case "JB":
					res = disposeInfoService.dipBasicInfo(file);
					break;
				case "HX":
					res = disposeInfoService.dipHorizontalTopicInfo(file);
					break;
				case "KY":
					res = disposeInfoService.dipScientificGuaranteeInfo(file);
					break;
				default:
					res = disposeInfoService.dipBasicInfo(file);
					break;
				}
				if (res) {
					result.setCode(0);
					result.setMsg("成功");
					log.info("上传文件解析入口成功---------------------->");
					return result;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setMsg("系统异常");
		}
		log.info("上传文件结束---------------------->");
		return result;
	}

	public ApiResult formInfo(@RequestParam(required = true) String fileType, @RequestParam(required = true) int pageNo,
			@RequestParam(required = true) int pageSize) {
		ApiResult result = new ApiResult();
		try {

		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setMsg("系统异常");
		}
		return result;
	}

	@PostMapping("formInfo")
	public ApiResult formInfo(@RequestParam(required = true) String fileType) {
		ApiResult result = new ApiResult();
		try {
			disposeInfoService.findFormInfo(fileType, result);
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setMsg("系统异常");
		}
		return result;
	}

}

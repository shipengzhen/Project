package com.bdqn.sl.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传
 * @author lizhen
 */
public interface IPictureService {
	/**
	 * 上传图片
	 * @param uploadFile
	 * @return
	 */
	Map updatePicture(MultipartFile uploadFile,String type);
	
	/**
	 * 上传文件
	 */
	Map updateFile(MultipartFile uploadFile);
	
	/**
	 * 删除 
	 */
	boolean delFile(String path);
	
	/**
	 * 下载文件 路径
	 */
	boolean downloadFile(String path);
}

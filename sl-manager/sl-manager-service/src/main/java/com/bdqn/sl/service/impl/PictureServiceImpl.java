package com.bdqn.sl.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.filechooser.FileSystemView;

import org.apache.commons.io.FilenameUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bdqn.common.FtpUtil;
import com.bdqn.common.IDUtils;
import com.bdqn.sl.service.IPictureService;

@Service
public class PictureServiceImpl implements IPictureService {

	//使用spring 读取配置文件中的值	前提扫描
		@Value("${FTP_ADDRES}")
		private String ftp_address;
		
		@Value("${FTP_PROT}")
		private Integer ftp_prot;
		
		@Value("${FTP_USERNAME}")
		private String ftp_username;
		
		@Value("${FTP_PASSWORD}")
		private String ftp_password;
		
		@Value("${FTP_BASE_PATH}")
		private String ftp_basePath;		//上传的地址
		
		@Value("${IMAGE_BASE_URL}")
		private String imageBaseUrl;		//上传的地址 图片
		
		
	
	//上传图片
	@Override
	public Map updatePicture(MultipartFile uploadFile,String code) {
		
		Map<String,String> resultMap=new HashMap<String,String>(4);
		
		//取原文件名
		String oldNmae=uploadFile.getOriginalFilename();
		String prefix = FilenameUtils.getExtension(oldNmae);		 	  		// 原文件后缀	
				
		int filesize = 500000;	//大小
		if (uploadFile.getSize() > filesize) {										// 上传大小不得超过 500k
			resultMap.put("code","5");
			resultMap.put("message","图片过大");
			return resultMap;
		}
		if( prefix.equalsIgnoreCase("jpg")|| prefix.equalsIgnoreCase("png")
			|| prefix.equalsIgnoreCase("jpeg")|| prefix.equalsIgnoreCase("pneg")) {
			
			try {
				String newName="";											//生成新文件名
					
				if(code.equals("idcard")) {
					newName=System.currentTimeMillis()+ "_IDcard";			//拼接名字	时间的毫秒数
				}else if(code.equals("bank")) {
					newName=System.currentTimeMillis()+ "__bank";			//拼接名字	时间的毫秒数
				}
				
				newName=newName+oldNmae.substring(oldNmae.lastIndexOf(".")); 		//新名称 +旧文件的后缀名称
				String imagePath=new DateTime().toString("/yyyy/MM/dd");			//路径
				
				//图片上传							//地址                         端口			  用户名称			//密码
				boolean result= FtpUtil.uploadFile(ftp_address, ftp_prot, ftp_username, ftp_password,
						ftp_basePath, imagePath, newName, uploadFile.getInputStream());
						//根上传地址			//地址   图片名称	
				//返回结果
				if(!result) {
					System.out.println("失败");
					resultMap.put("code","1");
					resultMap.put("message","文件长传失败");
					return resultMap;
				}
				System.out.println("成功！");
				resultMap.put("code", "2");
				resultMap.put("url",imageBaseUrl+imagePath+"/"+newName);
				return resultMap;
			} catch (Exception e) {
				resultMap.put("code","3");
				resultMap.put("message","文件长传发生异常");
				return resultMap;
			}
			
		}else {
			resultMap.put("code","4");
			resultMap.put("message","图片格式不对");
			return resultMap;
		}
		
		

	}


	//上传文件
	@Override
	public Map updateFile(MultipartFile uploadFile) {
		

		Map<String,String> resultMap=new HashMap<String,String>(4);
		
		//取原文件名
		String oldNmae=uploadFile.getOriginalFilename();
		String prefix = FilenameUtils.getExtension(oldNmae);		 	  		// 原文件后缀	
				
		int filesize = 50000000;	//大小
		
		long size=uploadFile.getSize();		
		if (size > filesize) {										// 上传大小不得超过 500M
			resultMap.put("code","5");
			resultMap.put("message","文件过大");
			return resultMap;
		}
		if(	 prefix.equalsIgnoreCase("jpg")|| prefix.equalsIgnoreCase("png")
				|| prefix.equalsIgnoreCase("jpeg")|| prefix.equalsIgnoreCase("pneg")
				||prefix.equalsIgnoreCase("mp4")||prefix.equalsIgnoreCase("txt")
				||prefix.equalsIgnoreCase("doc")||prefix.equalsIgnoreCase("doxc")
				||prefix.equalsIgnoreCase("xlsx")||prefix.equalsIgnoreCase("pptx")) {
			
			try {
				String 	newName=System.currentTimeMillis()+ "file";					//拼接名字	时间的毫秒数
				
				newName=newName+oldNmae.substring(oldNmae.lastIndexOf(".")); 		//新名称 +旧文件的后缀名称
				String imagePath=new DateTime().toString("/yyyy/MM/dd");			//路径
				
				//图片上传							//地址                         端口			  用户名称			//密码
				boolean result= FtpUtil.uploadFile(ftp_address, ftp_prot, ftp_username, ftp_password,
						ftp_basePath, imagePath, newName, uploadFile.getInputStream());
						//根上传地址			//地址   图片名称	
				//返回结果
				if(!result) {
					System.out.println("失败");
					resultMap.put("code","1");
					resultMap.put("message","文件长传失败");
					return resultMap;
				}
				System.out.println("成功！");
				resultMap.put("code", "2");
				resultMap.put("oldFile",oldNmae);
				resultMap.put("newFile",newName);
				resultMap.put("fileSize",Long.toString(size));
				resultMap.put("url",imageBaseUrl+imagePath+"/"+newName);
				return resultMap;
			} catch (Exception e) {
				resultMap.put("code","3");
				resultMap.put("message","文件长传发生异常");
				return resultMap;
			}
			
		}else {
			resultMap.put("code","4");
			resultMap.put("message","图片格式不对");
			return resultMap;
		}
		
	}


	//删除
	@Override
	public boolean delFile(String path) {
		
		String fileName=path.substring(path.lastIndexOf("/")+1,path.length());
		String filePath="/home/ftpuser/SLshop/"+path.substring(path.lastIndexOf("images"),path.lastIndexOf("/"))+"/";
		
		try {
			boolean a=FtpUtil.deleteFile(ftp_address,ftp_prot,ftp_username,ftp_password,filePath, fileName);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	//下载 文件
	@Override
	public boolean downloadFile(String path) {
		//http://192.168.241.129/images/2018/03/28/1522240025403file.jpg
		//FtpUtil.downloadFtpFile("192.168.241.129", "ftpuser", "ftpuser", 21, "doc",com.getPath(),"123.jpg");
		
		System.out.println(path);
		
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File com=fsv.getHomeDirectory();   	//本地地址
		
		String fileName=path.substring(path.lastIndexOf("/")+1,path.length());	//文件名称
		String filePath=path.substring(path.lastIndexOf("images"),path.lastIndexOf("/"))+"/";
		System.out.println("下载！！！");
		System.out.println(fileName);
		System.out.println(filePath);
		try {
			FtpUtil.downloadFtpFile(ftp_address, ftp_username, ftp_password,ftp_prot,filePath,com.getPath(),fileName);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

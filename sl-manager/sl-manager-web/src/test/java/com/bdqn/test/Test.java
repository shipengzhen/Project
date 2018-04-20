package com.bdqn.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;

import javax.swing.filechooser.FileSystemView;

import org.apache.commons.net.ftp.FTPClient;

import com.bdqn.common.FtpUtil;

public class Test {
	
	
	@org.junit.Test
	public void file() throws SocketException, IOException {
		
		//boolean b = FtpUtil.downloadFile("192.168.241.129", 21, "ftpuser", "ftpuser","images","1522240025403file.jpg","D:\\");
		//System.out.println(b);
		
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File com=fsv.getHomeDirectory();   
		System.out.println(com.getPath()); //这便是桌面的具体路径
		
		
		FtpUtil.downloadFtpFile("192.168.241.129", "ftpuser", "ftpuser", 21, "doc",com.getPath(),"123.jpg");
	}
}

/**
 * 
 */
package com.spz.hospital.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

import com.spz.hospital.pojo.Usee;
import com.spz.hospital.service.IUseeService;

/**
 * @描述 hospital
 * @作者 施鹏振
 * @创建日期 2018年2月25日
 * @创建时间 下午3:39:52
 */
@RequestMapping("/")
public class LoginController {

	private IUseeService useeService;

	public IUseeService getUseeService() {
		return useeService;
	}

	public void setUseeService(IUseeService useeService) {
		this.useeService = useeService;
	}

	// 跳转登录页面
	@RequestMapping("login")
	public String login() {
		return "login";
	}

	// 登录
	@RequestMapping("dologin")
	public String doLogin(String uname, String password,HttpSession session) {
		Usee usee = useeService.getUsee(uname, password);
		if (usee != null) {
			session.setAttribute("usee",usee);
			return "index";
		}
		return "login";
	}
}

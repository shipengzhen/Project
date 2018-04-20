package com.yy.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yy.dao.FC;
import com.yy.model.Usee;
import com.yy.util.Json;

@Controller
public class LoginCon {

	
	//ת����¼ҳ��
	@RequestMapping("/jsp/login.html")
	public String login() {
		return "/jsp/login.jsp";
	}
	
	//ajax,�����¼
	@ResponseBody
	@RequestMapping("/jsp/doLogin.ajax")
	public String doLogin(String uname,String password,HttpSession session) {
		Usee usee=FC.getIUseeDao().getByUName(uname);
		if(usee==null||usee.getPassword().equals(password)==false) {
			return Json.toStr("res",-1);	//��¼ʧ��
		}else{
			session.setAttribute("usee", usee);
			return Json.toStr("res",1);		//��¼�ɹ�
		}
	}
	
	//ת��index.jsp
	@RequestMapping("/jsp/index.html")
	public String index(HttpServletRequest request) {
		request.setAttribute("menus", JSON.toJSONString(FC.getIMenuDao().getByKY(),true));
		return "/jsp/index.jsp";
	}
	
	
	
	
	
	
	
	
}

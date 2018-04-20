package com.yy.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yy.dao.FC;
import com.yy.model.Usee;
import com.yy.util.Json;
import com.yy.util.Page;
import com.yy.util.WebFly;

/**
 * 用户相关控制器
 */
@Controller
@RequestMapping("/jsp/User/")
public class UserCon {

	/**
	 * 转到index
	 */
	@RequestMapping("index.html")
	public String index(HttpServletRequest request,
			@RequestParam(defaultValue="1")int pn,
			@RequestParam(defaultValue="10")int pz,
			@RequestParam(defaultValue="")String uname
			) {
		uname=WebFly.getUtf8(uname);
		
		Page page=new Page(pn,pz);
		request.setAttribute("uname", uname);
		request.setAttribute("users", FC.getIUseeDao().getByPageUName(page, uname));
		request.setAttribute("page", page);
		
		return "index.jsp";
	}
	
	//ajax,根据in串删除
	@ResponseBody
	@RequestMapping("doDel.ajax")
	public String doDel(String ids) {
		int a=FC.getIUseeDao().doDelete(ids);
		return Json.toStr("res", a);
	}
	
	//转到添加页面
	@RequestMapping("addUser.html")
	public String addUser(HttpServletRequest request) {
		request.setAttribute("roles", FC.getIRoleDao().findAll());
		return "addUser.jsp";
	}
	
	//ajax,处理添加Usee
	@ResponseBody
	@RequestMapping("doAdd.ajax")
	public String doAdd(Usee usee) {
		int a=FC.getIUseeDao().save(usee);
		return Json.toStr("res", a);
	}
	
	//转到修改页
	@RequestMapping("editUser.html")
	public String edit(HttpServletRequest request,int uid) {
		request.setAttribute("u", FC.getIUseeDao().findById(uid));	//要修改的用户
		request.setAttribute("roles", FC.getIRoleDao().findAll());	//全部角色
		return "editUser.jsp";
	}
		
	//ajax，处理修改
	@ResponseBody
	@RequestMapping("doEdit.ajax")
	public String doEdit(Usee usee) {
		int a=FC.getIUseeDao().update(usee);
		return Json.toStr("res", a);
	}
		
	
	//转到密码修改页面
	@RequestMapping("password.html")
	public String password() {
		return "password.jsp";
	}
	
	//处理修改密码
	@ResponseBody
	@RequestMapping("doPassword.ajax")
	public String doPassword(HttpServletRequest request,String password,String newpassword) {
		Usee usee=(Usee)request.getSession().getAttribute("usee");
		int uid=usee.getUid();
		if(usee.getPassword().equals(password)==false) {
			return Json.toStr("res", -1);	//密码错误
		}
		int a=FC.getIUseeDao().doUpdatePwd(uid, newpassword);
		return Json.toStr("res", a);
	}
	
	@ExceptionHandler
	public void handlerException(Exception e,HttpServletRequest request){
		e.printStackTrace();
	}
	
	
}

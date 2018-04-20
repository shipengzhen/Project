package com.yy.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yy.dao.FC;
import com.yy.model.Role;
import com.yy.util.Json;
import com.yy.util.Page;
import com.yy.util.WebFly;

/**
 * ��ɫ������
 */
@Controller
@RequestMapping("/jsp/Role/")
public class RoleCon {

	
	//ת��Role/index.jspҳ��
	@RequestMapping("index.html")
	public String index(HttpServletRequest request,
			@RequestParam(defaultValue="")String rname,
			@RequestParam(defaultValue="1")int pn,
			@RequestParam(defaultValue="10")int pz
			) throws UnsupportedEncodingException {
		
		rname=WebFly.getUtf8(rname);
		
		Page page=new Page(pn,pz);
		request.setAttribute("rname", rname);
		request.setAttribute("roles", FC.getIRoleDao().getByPageRName(page, rname));
		request.setAttribute("page", page);
		return "index.jsp";
	}
	

	//ת�����ҳ��
	@RequestMapping("addRole.html")
	public String addRole(HttpServletRequest request) {
		request.setAttribute("menus", FC.getIMenuDao().findAll());;
		return "addRole.jsp";
	}
	
	//ajax,�������Role
	@ResponseBody
	@RequestMapping("doAdd.ajax")
	public String doAdd(Role role,@RequestParam(value="mids",required=false) List<Integer>mids) {
		System.out.println(mids);
		int a=FC.getIRoleDao().save(role,mids);
		return Json.toStr("res", a);
	}
	
	//ajax,����in��ɾ��
	@ResponseBody
	@RequestMapping("doDel.ajax")
	public String doDel(String ids) {
		System.out.println(ids);
		int a=FC.getIRoleDao().doDelete(ids);
		return Json.toStr("res", a);
	}
	
	//ת���޸�ҳ
	@RequestMapping("editRole.html")
	public String editRole(HttpServletRequest request,int rid) {
		request.setAttribute("role", FC.getIRoleDao().findById(rid));	//Ҫ�޸ĵ�Role
		
		request.setAttribute("mids", FC.getIMenuDao().getByRid(rid));	//��Role�����յ�����mid
		request.setAttribute("menus", FC.getIMenuDao().findAll()); 		//���в˵���
		return "editRole.jsp";
	}
	
	//ajax�������޸�
	@ResponseBody
	@RequestMapping("doEdit.ajax")
	public String doEdit(Role role,@RequestParam(value="mids",required=false) List<Integer>mids) {
		int a=FC.getIRoleDao().update(role,mids);
		return Json.toStr("res", a);
	}
	
	
	
	@ExceptionHandler
	public void handlerException(Exception e,HttpServletRequest request){
		e.printStackTrace();
	}
	
}

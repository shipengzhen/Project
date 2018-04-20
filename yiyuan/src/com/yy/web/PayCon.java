package com.yy.web;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yy.dao.FC;
import com.yy.model.Pay;
import com.yy.util.Json;
import com.yy.util.Page;
import com.yy.util.WebFly;

/**
 * 收费项目管理控制器
 * @author kong
 *
 */
@Controller
@RequestMapping("/jsp/hospital/")
public class PayCon {


	//转到资源管理index
	@RequestMapping("charge.html")
	public String charge(HttpServletRequest request,
			@RequestParam(defaultValue="1")int pn,
			@RequestParam(defaultValue="10")int pz,
			@RequestParam(defaultValue="")String pname
			){
		
		pname=WebFly.getUtf8(pname);
		
		Page page=new Page(pn,pz);
		request.setAttribute("pname", pname);
		request.setAttribute("pays", FC.getIPayDao().getByTJ(page, pname));
		request.setAttribute("page", page);
		return "charge.jsp";
	}
	
	//转到添加页面
	@RequestMapping("charge-edit1.html")
	public String charge_edit1() {
		return "charge-edit1.jsp";
	}
	
	//ajax,处理添加Pay
	@ResponseBody
	@RequestMapping("doPayAdd.ajax")
	public String doPayAdd(Pay pay) {
		int a=FC.getIPayDao().save(pay);
		return Json.toStr("res", a);
	}
	
	//ajax,根据pid删除
	@ResponseBody
	@RequestMapping("doChargeDel.ajax")
	public String doChargeDel(int pid) {
		try {
			int a=FC.getIPayDao().delete(pid);
			return Json.toStr("res", a);
		} catch (Exception e) {
			return Json.toStr("res", -1);
		}
	}
	
	
	

	@ExceptionHandler
	public void handlerException(Exception e,HttpServletRequest request){
		e.printStackTrace();
	}
	
	
	
}

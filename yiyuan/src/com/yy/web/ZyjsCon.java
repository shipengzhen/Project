package com.yy.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yy.dao.FC;
import com.yy.util.Json;
import com.yy.util.Page;
import com.yy.util.WebFly;

/**
 * 住院结算记录表
 */
@Controller
@RequestMapping("/jsp/hospital/")
public class ZyjsCon {

	//转到account.html
	@RequestMapping("account.html")
	public String account(HttpServletRequest request,
			@RequestParam(defaultValue="1")int pn,
			@RequestParam(defaultValue="10")int pz,
			@RequestParam(defaultValue="")String gid,
			@RequestParam(defaultValue="")String gname
			) {
		
		gid=WebFly.getUtf8(gid);
		gname=WebFly.getUtf8(gname);
		
		Page page=new Page(pn,pz);
		request.setAttribute("gid", gid);
		request.setAttribute("gname", gname);
		request.setAttribute("zhuyuans", FC.getIZhuyuanDao().getByTJ2(page, gid, gname));
		request.setAttribute("page", page);
		
		return "account.jsp";
	}
	
	
	//指定zid结算
	@ResponseBody
	@RequestMapping("doJiesuan.ajax")
	public String doJiesuan(int zid) {
		int a=FC.getIZhuyuanDao().doUpdateJS(zid);
		return Json.toStr("res", a);
	}
	

	//转到account-look.html
	@RequestMapping("account-look.html")
	public String account_look(HttpServletRequest request,
			@RequestParam(defaultValue="1")int pn,
			@RequestParam(defaultValue="10")int pz,
			int gid) {
		
		Page page=new Page(pn, pz);
		request.setAttribute("g", FC.getIGuahaoDao().findById(gid));
		request.setAttribute("payreds", FC.getIPayredDao().getByTJ(page, gid));
		request.setAttribute("page", page);
		
		return "account-look.jsp";
	}
	
	
	
	
	
	@ExceptionHandler
	public void handlerException(Exception e,HttpServletRequest request) throws Exception{
		e.printStackTrace();
		throw e;
	}
	
	
	
	
}

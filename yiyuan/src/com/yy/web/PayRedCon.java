package com.yy.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yy.dao.FC;
import com.yy.model.Payred;
import com.yy.util.Json;
import com.yy.util.Page;
import com.yy.util.WebFly;

/**
 * 收费项目等级表
 * @author kong
 *
 */
@Controller
@RequestMapping("/jsp/hospital/")
public class PayRedCon {

	//转到资源管理charge
	@RequestMapping("charge2.html")
	public String charge(HttpServletRequest request,
			@RequestParam(defaultValue="1")int pn,
			@RequestParam(defaultValue="10")int pz,
			@RequestParam(defaultValue="")String gid,
			@RequestParam(defaultValue="")String gname
			){

		gid=WebFly.getUtf8(gid);
		gname=WebFly.getUtf8(gname);
		
		Page page=new Page(pn,pz);
		request.setAttribute("gid", gid);
		request.setAttribute("gname", gname);
		request.setAttribute("guahaos", FC.getIGuahaoDao().getByTJ2(page, gid,gname));
		request.setAttribute("page", page);
		return "charge2.jsp";
	}
	
	//转到添加收费项
	@RequestMapping("charge-new.html")
	public String charge_new(HttpServletRequest request,
			//@RequestParam(defaultValue="1")int pn,
			//@RequestParam(defaultValue="10")int pz,
			int gid
			) {
		//Page page=new Page(pn,pz);
		//request.setAttribute("payreds", FC.getIPayredDao().getByTJ(page, gid));	//该gid的所有收费记录
		request.setAttribute("guahao", FC.getIGuahaoDao().findById(gid));
		request.setAttribute("pays", FC.getIPayDao().findAll());	//所有收费项
		//request.setAttribute("page", page);
		
		return "charge-new.jsp";
	}
	
	//处理添加收费项目的登记
	@ResponseBody
	@RequestMapping("doAddPayred.ajax")
	public String doAddPayred(Payred payred) {
		int a=FC.getIPayredDao().save(payred);
		return Json.toStr("res", a);
	}
	
	
	
	
	
	
	
}

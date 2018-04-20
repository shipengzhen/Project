package com.yy.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yy.dao.FC;
import com.yy.model.Doctor;
import com.yy.util.Json;
import com.yy.util.Page;
import com.yy.util.WebFly;

/**
 * 门诊医生管理控制器
 */
@Controller
@RequestMapping("/jsp/doctor/")
public class DoctorCon {


	//转到index
	@RequestMapping("index.html")
	public String index(HttpServletRequest request,
			@RequestParam(defaultValue="1")int pn,
			@RequestParam(defaultValue="10")int pz,
			@RequestParam(defaultValue="")String didStr,
			@RequestParam(defaultValue="")String d_zsname,
			@RequestParam(defaultValue="")String kname
			) {
		didStr=WebFly.getUtf8(didStr);
		d_zsname=WebFly.getUtf8(d_zsname);
		kname=WebFly.getUtf8(kname);
		
		Page page=new Page(pn,pz);
		
		request.setAttribute("doctors", FC.getIDoctorDao().getByTJ(page, didStr, d_zsname, kname));
		request.setAttribute("page", page);
		request.setAttribute("didStr", didStr);
		request.setAttribute("d_zsname", d_zsname);
		request.setAttribute("kname", kname);
		
		return "index.jsp";
	}
	

	//转到添加页面
	@RequestMapping("add.html")
	public String addUser(HttpServletRequest request) {
		request.setAttribute("KeRomes", FC.getIKeromeDao().findAll());	//所有科室
		return "add.jsp";
	}
	
	//ajax,处理添加Doctor
	@ResponseBody
	@RequestMapping("doAdd.ajax")
	public String doAdd(HttpServletRequest request,Doctor doctor) {
		java.sql.Timestamp date=(java.sql.Timestamp)WebFly.getStrType
				(request.getParameter("d_csdayDate"), java.sql.Timestamp.class);
		doctor.setD_csday(date);
		int a=FC.getIDoctorDao().save(doctor);
		return Json.toStr("res", a);
	}
	
	//转到修改页
	@RequestMapping("edit.html")
	public String edit(HttpServletRequest request,int did) {
		request.setAttribute("doctor", FC.getIDoctorDao().findById(did));	//要修改的门诊医生
		request.setAttribute("KeRomes", FC.getIKeromeDao().findAll());	//所有科室
		return "edit.jsp";
	}
		
	//ajax，处理修改
	@ResponseBody
	@RequestMapping("doEdit.ajax")
	public String doEdit(HttpServletRequest request,Doctor doctor) {
		java.sql.Timestamp date=(java.sql.Timestamp)WebFly.getStrType
				(request.getParameter("d_csdayDate"), java.sql.Timestamp.class);
		doctor.setD_csday(date);
		int a=FC.getIDoctorDao().update(doctor);
		return Json.toStr("res", a);
	}
		

	//转到查看页面look.html
	@RequestMapping("look.html")
	public String look(HttpServletRequest request,int did) {
		request.setAttribute("doctor", FC.getIDoctorDao().findById(did));	//要修改的用户
		return "look.jsp";
	}
	
	
	
	@ExceptionHandler
	public void handlerException(Exception e,HttpServletRequest request){
		e.printStackTrace();
	}
	
	
	
	
	
	
	
	
}

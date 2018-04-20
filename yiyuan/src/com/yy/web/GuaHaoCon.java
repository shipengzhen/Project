package com.yy.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yy.dao.FC;
import com.yy.model.Guahao;
import com.yy.util.Json;
import com.yy.util.Page;
import com.yy.util.WebFly;

/**
 * ����Һ����ҵ���Con
 */
@Controller
@RequestMapping("/jsp/registration")
public class GuaHaoCon {

	
	//ת��index
	@RequestMapping("index.html")
	public String index(HttpServletRequest request,
			@RequestParam(defaultValue="1")int pn,
			@RequestParam(defaultValue="10")int pz,
			@RequestParam(defaultValue="")String gid,
			@RequestParam(defaultValue="")String d_zsname,
			@RequestParam(defaultValue="")String kname,
			@RequestParam(defaultValue="1971-1-1")String kai,
			@RequestParam(defaultValue="2030-1-1")String end
			) {
		gid=WebFly.getUtf8(gid);
		d_zsname=WebFly.getUtf8(d_zsname);
		kname=WebFly.getUtf8(kname);
		
		Page page=new Page(pn,pz);
		
		request.setAttribute("guahaos", FC.getIGuahaoDao().getByTJ(page, gid, d_zsname, kname, kai, end));
		request.setAttribute("page", page);
		request.setAttribute("gid", gid);
		request.setAttribute("d_zsname", d_zsname);
		request.setAttribute("kname", kname);
		request.setAttribute("kai", kai);
		request.setAttribute("end", end);
		
		return "index.jsp";
	}
	
	//ָ��gid�˺�
	@ResponseBody
	@RequestMapping("TuiHao")
	public String TuiHao(int gid) {
		int a=FC.getIGuahaoDao().doUpdateStatus(gid, "���˺�");
		return Json.toStr("res", a);
	}
	
	//ת�����ҳ��
	@RequestMapping("add.html")
	public String add(HttpServletRequest request) {
		request.setAttribute("keromes", FC.getIKeromeDao().findAll());	//���Ҵ�ȫ
		request.setAttribute("doctors", FC.getIDoctorDao().findAll());	//����ҽ����ȫ
		return "add.jsp";
	}
	
	//ajax,������ӵ�
	@ResponseBody
	@RequestMapping("doAdd.ajax")
	public String doAdd(Guahao guahao) {
		int a=FC.getIGuahaoDao().save(guahao);
		return Json.toStr("res", a);
	}
	
	//���ݿ��һ�ȡҽ��
	@ResponseBody
	@RequestMapping(value="getDoctorByKid.ajax",produces = "text/html;charset=UTF-8")
	public String getDoctorByKid(HttpServletResponse response,int kid) throws IOException {
		return JSON.toJSONString(FC.getIDoctorDao().getJsonByKid(kid));
	}
	
	//ת������ҳ��
	@RequestMapping("edit.html")
	public String edit(HttpServletRequest request,int gid) {
		request.setAttribute("guahao", FC.getIGuahaoDao().findById(gid));
		request.setAttribute("keromes", FC.getIKeromeDao().findAll());	//���Ҵ�ȫ
		request.setAttribute("doctors", FC.getIDoctorDao().findAll());	//����ҽ����ȫ
		return "edit.jsp";
	}
	
	//�����޸�
	@ResponseBody
	@RequestMapping("doEdit")
	public String doEdit(Guahao guahao) {
		int a=FC.getIGuahaoDao().update(guahao);
		return Json.toStr("res", a);
	}
	
	//ת��lookҳ��
	@RequestMapping("look.html")
	public String look(HttpServletRequest request,int gid) {
		request.setAttribute("guahao", FC.getIGuahaoDao().findById(gid));
		return "look.jsp";
	}
	
	
	
	

	@ExceptionHandler
	public void handlerException(Exception e,HttpServletRequest request){
		e.printStackTrace();
	}
	
	
	
}

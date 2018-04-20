package com.yy.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yy.dao.FC;
import com.yy.model.Fayao;
import com.yy.util.Json;
import com.yy.util.Page;
import com.yy.util.WebFly;

/**
 * ���߷�ҩ������
 */
@Controller
@RequestMapping("/jsp/hospital/")
public class FaYaoCon {

	//ת����Դ����index
	@RequestMapping("dispensing.html")
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
		return "dispensing.jsp";
	}
	
	
	//ת�����ҳ��
	@RequestMapping("dispensing-give.html")
	public String dispensing_give(HttpServletRequest request,int gid){
		request.setAttribute("guahao", FC.getIGuahaoDao().findById(gid));
		request.setAttribute("yaos", FC.getIYaoDao().findAll());
		return "dispensing-give.jsp";
	}
	
	//�������
	@ResponseBody
	@RequestMapping("doAddFaYao.ajax")
	public String doAddFaYao(Fayao fayao) {
		int a=FC.getIFayaoDao().save(fayao);
		if(a>0) {
			FC.getIYaoDao().doAddKucun(fayao.getYno(), 0-fayao.getF_num());
		}
		return Json.toStr("res", a);
	}
	
	//
	//ת�����߷�ҩ����lookҳ��
	@RequestMapping("dispensing-look.html")
	public String look(HttpServletRequest request,
			@RequestParam(defaultValue="1")int pn,
			@RequestParam(defaultValue="10")int pz,
			int gid) {
		Page page=new Page(pn,pz);
		
		request.setAttribute("guahao", FC.getIGuahaoDao().findById(gid));
		request.setAttribute("fayaos", FC.getIFayaoDao().getByTJ(page, gid));
		request.setAttribute("page", page);
		return "dispensing-look.jsp";
	}
	
	//ajax,ָ��fid����ҩָ������
	@ResponseBody
	@RequestMapping("doFayao.ajax")
	public String doFayao(int fid,int num) {
		int a=FC.getIFayaoDao().fayao(fid, num);
		return Json.toStr("res", a);
	}
	
	
	


	@ExceptionHandler
	public void handlerException(Exception e,HttpServletRequest request){
		e.printStackTrace();
	}
	
	
	
	
}

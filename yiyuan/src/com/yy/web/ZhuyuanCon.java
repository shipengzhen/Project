package com.yy.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yy.dao.FC;
import com.yy.model.Guahao;
import com.yy.model.Zhuyuan;
import com.yy.util.Json;
import com.yy.util.Page;
import com.yy.util.WebFly;

/**
 * סԺ��ؿ�����
 */
@Controller
@RequestMapping("/jsp/hospital/")
public class ZhuyuanCon {

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
		
		request.setAttribute("zhuyuans", FC.getIZhuyuanDao().getByTJ(page, gid, d_zsname, kname, kai, end));
		request.setAttribute("page", page);
		request.setAttribute("gid", gid);
		request.setAttribute("d_zsname", d_zsname);
		request.setAttribute("kname", kname);
		request.setAttribute("kai", kai);
		request.setAttribute("end", end);
		
		return "index.jsp";
	}
	
	//ajax��ָ��gid��״̬��Ϊָ��ֵ
	@ResponseBody
	@RequestMapping("doUpdateStatus.ajax")
	public String doUpdateStatus(int gid,String status) {
		int a=FC.getIGuahaoDao().doUpdateStatus(gid, status);
		return Json.toStr("res", a);
	}
	
	
	//ת�����Ѻ��ҳ��
	@RequestMapping("add_many.html")
	public String add_many(HttpServletRequest request,int zid){
		request.setAttribute("z", FC.getIZhuyuanDao().findById(zid));
		return "add_many.jsp";
	}
	
	//ajax��ָ��zid�ɷ�
	@ResponseBody
	@RequestMapping("doAdd_many.ajax")
	public String doAdd_many(int zid,double many) {
		int a=FC.getIZhuyuanDao().doAddYJ(zid, many);
		return Json.toStr("res", a);
	}
	
	//ת�����סԺ��Ϣ
	@RequestMapping("add.html")
	public String add() {
		return "add.jsp";
	}
	
	//ajax,�������סԺ��Ϣ
	@ResponseBody
	@RequestMapping("doAdd.ajax")
	public String doAdd(Zhuyuan zhuyuan) {
		System.out.println(zhuyuan);
		int a=FC.getIZhuyuanDao().save(zhuyuan);
		return Json.toStr("res", a);
	}
	
	//ajax,��ѯָ���Һ�id��Ӧ�ĹҺŶ���
	@ResponseBody
	@RequestMapping(value="getGuaHao.ajax",produces="text/html;charset=utf-8")
	public String getGuaHao(@RequestParam(defaultValue="1")int gid) {
		Guahao guahao=FC.getIGuahaoDao().findById(gid);
		return JSON.toJSONString(guahao);
	}
	
	
	//ת���޸�ҳ��
	@RequestMapping("edit.html")
	public String edit(HttpServletRequest request,int zid) {
		request.setAttribute("z", FC.getIZhuyuanDao().findById(zid));
		return "edit.jsp";
	}
	
	//�����޸�
	@ResponseBody
	@RequestMapping("doEdit")
	public String doEdit(Zhuyuan zhuyuan) {
		int a=FC.getIZhuyuanDao().update(zhuyuan);
		return Json.toStr("res", a);
	}
		

	//ת��lookҳ��
	@RequestMapping("look.html")
	public String look(HttpServletRequest request,int zid) {
		request.setAttribute("z", FC.getIZhuyuanDao().findById(zid));
		return "look.jsp";
	}
	
	
	
	
	
	
	
	@ExceptionHandler
	public void handlerException(Exception e,HttpServletRequest request) throws Exception{
		e.printStackTrace();
		throw e;
	}
	
	
}

package com.yy.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yy.dao.FC;
import com.yy.model.Menu;
import com.yy.util.Json;
import com.yy.util.Page;
import com.yy.util.WebFly;

/**
 * �˵���Դ���������
 * @author kong
 *
 */
@Controller
@RequestMapping("/jsp/Resource/")
public class MenuCon {

	
	//ת����Դ����index
	@RequestMapping("index.html")
	public String index(HttpServletRequest request,
			@RequestParam(defaultValue="")String text,
			@RequestParam(defaultValue="1")int pn,
			@RequestParam(defaultValue="10")int pz
			) throws UnsupportedEncodingException {
		
		text=WebFly.getUtf8(text);
		
		Page page=new Page(pn,pz);
		request.setAttribute("text", text);
		request.setAttribute("menus", FC.getIMenuDao().getByPageMH(page, text));
		request.setAttribute("page", page);
		return "index.jsp";
	}
	
	//ת�����ҳ��
	@RequestMapping("add.html")
	public String add() {
		return "add.jsp";
	}
	
	//ajax,�������Menu
	@ResponseBody
	@RequestMapping("doAdd.ajax")
	public String doAdd(Menu menu) {
		int a=FC.getIMenuDao().save(menu);
		return Json.toStr("res", a);
	}
	
	//ajax,����in��ɾ��
	@ResponseBody
	@RequestMapping("doDel.ajax")
	public String doDel(String ids) {
		int a=FC.getIMenuDao().doDelete(ids);
		return Json.toStr("res", a);
	}
	
	//ת���޸�ҳ
	@RequestMapping("edit.html")
	public String edit(HttpServletRequest request,int mid) {
		request.setAttribute("menu", FC.getIMenuDao().findById(mid));
		return "edit.jsp";
	}
	
	//ajax�������޸�
	@ResponseBody
	@RequestMapping("doEdit.ajax")
	public String doEdit(Menu menu) {
		int a=FC.getIMenuDao().update(menu);
		return Json.toStr("res", a);
	}
	
	//@RequestBody
}

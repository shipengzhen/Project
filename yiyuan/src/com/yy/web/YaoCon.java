package com.yy.web;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yy.dao.FC;
import com.yy.model.Yao;
import com.yy.util.Json;
import com.yy.util.Page;
import com.yy.util.WebFly;

/**
 * ҩƷ���������
 */
@Controller
@RequestMapping("/jsp/medicine/")
public class YaoCon {


	/**
	 * ת��index
	 */
	@RequestMapping(value="index.html")
	public String index(HttpServletRequest request,
			@RequestParam(defaultValue="1")int pn,
			@RequestParam(defaultValue="10")int pz,
			@RequestParam(defaultValue="")String y_name,
			@RequestParam(defaultValue="0")int y_type
			) {
		y_name=WebFly.getUtf8(y_name);
		
		Page page=new Page(pn,pz);
		request.setAttribute("y_name", y_name);
		request.setAttribute("y_type", y_type);
		request.setAttribute("yaos", FC.getIYaoDao().getByTJ(page, y_name, y_type));
		request.setAttribute("page", page);
		
		return "index.jsp";
	}
	
	//ת�����ҳ��
	@RequestMapping("add.html")
	public String addUser(HttpServletRequest request) {
		request.setAttribute("roles", FC.getIRoleDao().findAll());
		return "add.jsp";
	}
	
	//�������
	@ResponseBody
	@RequestMapping(value="doAdd",produces = "text/html;charset=UTF-8")
	public String doAdd(HttpServletRequest request,MultipartFile file,Yao yao) throws Exception {
		System.out.println(file);
		System.out.println(yao);
		
		long shu=System.currentTimeMillis();
		String name=shu+".png";
		yao.setY_img(name);
		
		String path = request.getSession().getServletContext().getRealPath("static/yimg/"+name);//·��
		file.transferTo(new File(path));
		
		int a=FC.getIYaoDao().save(yao);

		if(a>0){
			//�ɹ�
			return "<script>" +
					"alert('��ӳɹ���');" +
					"location.href='index.html';" +
					"</script>";
		}else{
			return "<script>" +
					"alert('���ʧ��');" +
					"history.back();" +
					"</script>";
		}
		
	}
	
	//ת��lookҳ��
	@RequestMapping("look.html")
	public String look(HttpServletRequest request,String yno) {
		yno=WebFly.getUtf8(yno);
		request.setAttribute("yao", FC.getIYaoDao().findById(yno));
		return "look.jsp";
	}
	
	//ת����ӿ��ҳ��
	@RequestMapping("add_medicine.html")
	public String add_medicine(HttpServletRequest request,String yno) {
		yno=WebFly.getUtf8(yno);
		request.setAttribute("yao", FC.getIYaoDao().findById(yno));
		return "add_medicine.jsp";
	}
	
	//ajax,������ӿ��
	@ResponseBody
	@RequestMapping("doAdd_medicine")
	public String doAdd_medicine(String yno,int add) {
		int a=FC.getIYaoDao().doAddKucun(yno, add);
		return Json.toStr("res", a);
	}
	
	
	
	
	
	
	@ExceptionHandler
	public void handlerException(Exception e,HttpServletRequest request){
		e.printStackTrace();
	}
	
	
	
	
	
	
}

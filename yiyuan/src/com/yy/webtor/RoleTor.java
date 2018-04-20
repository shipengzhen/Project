package com.yy.webtor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yy.dao.FC;
import com.yy.model.Menu;
import com.yy.model.Usee;
import com.yy.util.DT;

/**
 * 权限验证拦截器
 */
public class RoleTor implements HandlerInterceptor{

	//最终
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//之后
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	//之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		
		String str=DT.getDTString(new Date())+" --> IP:"+request.getRemoteAddr()+" \t请求:\t"
				+ request.getRequestURI()+"?"+request.getQueryString();
		System.out.println(str);
		
		//没登录，权限不足
		Usee usee=(Usee)request.getSession().getAttribute("usee");
		if(usee==null) {
			System.out.println("检查权限-->请求拒绝(可能尚未登录)");
			response.sendError(403);
			return false;
		}
		
		
		//检查权限
		String url=request.getRequestURI();//request.getParameter("toyz");
		Menu menu=FC.getIMenuDao().getByURL(url);
		if(menu!=null&&FC.getIMenuDao().getByRid(usee.getRid()).contains(menu.getMid())==false) {
			System.out.println("检查权限-->请求拒绝(权限不足)");
			response.sendError(403);
			return false;
		}
		
		System.out.println("检查权限-->请求通过");
		return true;
	}	

}

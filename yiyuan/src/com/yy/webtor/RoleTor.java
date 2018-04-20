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
 * Ȩ����֤������
 */
public class RoleTor implements HandlerInterceptor{

	//����
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//֮��
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	//֮ǰ
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		
		String str=DT.getDTString(new Date())+" --> IP:"+request.getRemoteAddr()+" \t����:\t"
				+ request.getRequestURI()+"?"+request.getQueryString();
		System.out.println(str);
		
		//û��¼��Ȩ�޲���
		Usee usee=(Usee)request.getSession().getAttribute("usee");
		if(usee==null) {
			System.out.println("���Ȩ��-->����ܾ�(������δ��¼)");
			response.sendError(403);
			return false;
		}
		
		
		//���Ȩ��
		String url=request.getRequestURI();//request.getParameter("toyz");
		Menu menu=FC.getIMenuDao().getByURL(url);
		if(menu!=null&&FC.getIMenuDao().getByRid(usee.getRid()).contains(menu.getMid())==false) {
			System.out.println("���Ȩ��-->����ܾ�(Ȩ�޲���)");
			response.sendError(403);
			return false;
		}
		
		System.out.println("���Ȩ��-->����ͨ��");
		return true;
	}	

}

package com.wisely.highlight_springmvc4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {// WebApplicationInitializer是Spring提供用来配置Servlet3.0+配置的接口
																	// 从而实现了代替web.xml的位置。实现此接口将会自东北SpringServletContainerInitializer（用来启动Servlet3.0容器）获取到

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(MyMvcConfig.class);
		ctx.setServletContext(servletContext);//新建WebApplicationContext，注册配置类 并将其和当前ServletContext关联

		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));//注册SpringMVC的DispatcherServlet
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}

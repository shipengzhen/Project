package com.wisely.highlight_springmvc4.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 利用@controller注解声明是一个控制器
public class HelloController {
	@RequestMapping("/index") // 利用@requestmapping配置url和方法之前的映射
	public String hello() {
		// TODO Auto-generated method stub
		return "index";// 通过上面viewresolver的bean配置 返回值为index
						// 说明我们的页面放置的路径为/WEB-INF/classes/views/index.jsp
	}
}

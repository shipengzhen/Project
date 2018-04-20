package com.bdqn.sl.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bdqn.common.Menu;
import com.bdqn.sl.pojo.Affiche;
import com.bdqn.sl.pojo.Information;
import com.bdqn.sl.pojo.SysUser;
import com.bdqn.sl.service.IAfficheService;
import com.bdqn.sl.service.IInformationService;
import com.bdqn.sl.service.ISysAuthorityService;
import com.bdqn.sl.service.ISysUserService;
import com.github.pagehelper.PageInfo;

@Controller
public class LoginController {

	@Autowired
	private ISysUserService sysUserService;			//用户
	
	@Resource
	private ISysAuthorityService sysAuthorityService;	//权限
	
	@Autowired
	private IAfficheService AfficheController;		//公告
	

	@Autowired
	private IInformationService informationService; // 资讯
	
	//进入main方法
/*	@RequestMapping("admin/main")
	public String main() {
		
		System.out.println("ddddddddddd");
		
		return "main";
	}*/
	@RequestMapping("/error")
	public String error() {
		return "401";
	}
	
	//进入 首页
	@RequestMapping("admin/main")
	public String main1(Model model,HttpSession session) {
		
		//获取当前对象
		SysUser u=(SysUser) session.getAttribute("User");
		
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(u.getRoleid());		//不同的角色 对应的权限
		System.out.println("main:"+u.getRoleid());
		model.addAttribute("mList",  JSON.toJSON(menus));
		
		Integer type=2;
		if(u.getRoleid()==1) {
			type=1;		//是否为管理员
		}
		
		
		PageInfo<Affiche> info = AfficheController.findAllAffiche(type,1,5);	//公告   
		model.addAttribute("info",info);
		
		List<Information> infolist = informationService.getInfoListMan();		//资讯
		model.addAttribute("infolist", infolist);
		
		return "main";
	}
	
	
	//进入登录
	@RequestMapping("/goLogin")
	public String goLogin() {
		
		//SysUserServiceImpl impl = new SysUserServiceImpl();
		//impl.AddXZ();
		
		return "index";
	}
	
	//登录操作
	@RequestMapping("/doLogin")
	@ResponseBody
	public String doLogin(String loginName,String loginPwd, HttpSession session) {
		System.out.println(loginName+"-"+loginPwd);
		
		if(loginName==null||loginPwd==null) {
			return "failed";
		}
		SysUser sysUser;
		
		try {
			sysUser = sysUserService.findUserByLoginName(loginName, loginPwd);
			
			if(sysUser!=null) {
				if(sysUser.getStatus()==1) {
					return "jy";	//禁用
				}
				if(sysUser.getAssociatorid()==2) {
					return "jh";	//需要激活
				}
				session.setAttribute("User", sysUser);
				session.setAttribute("Userid", sysUser.getUserid());
				session.setAttribute("userRId", sysUser.getRoleid());//用户id
				return "success";	//登录成功
			}else {
				return "pwderror";	//密码错误
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
		
		
	}
	//注销
	@RequestMapping("admin/logon")
	public String logon(HttpSession session) {
		session.setAttribute("User", null);;
		session.setAttribute("userRId",null);
		session.setAttribute("Userid", null);
		return "redirect:/goLogin";
	}
	
}

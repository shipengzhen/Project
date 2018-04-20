package com.bdqn.sl.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.bdqn.common.Menu;
import com.bdqn.sl.pojo.Setmeal;
import com.bdqn.sl.pojo.SysRoletype;
import com.bdqn.sl.pojo.SysUser;
import com.bdqn.sl.service.ISetMealService;
import com.bdqn.sl.service.ISysAuthorityService;
import com.bdqn.sl.service.ISysRoletypeService;
import com.bdqn.sl.service.ISysUserService;
import com.github.pagehelper.PageInfo;

/**
 * 信息查询
 * @author lizhen
 */
@Controller
@RequestMapping("/admin")
public class userInfoController {
	

	@Resource
	private ISysAuthorityService sysAuthorityService; 	// 权限
	
	@Autowired	
	private ISysRoletypeService sysRoletypeService;	//角色类型
	
	@Autowired
	private ISysUserService sysUserService;			//用户
	
	@Resource
	private ISetMealService setMealService;				//套餐表
	
	//进入推荐查询
	@RequestMapping("/goPremium")
	public String goPremium(Model model,HttpSession session,
			@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="5") Integer pageSize,SysUser user1) {
		
		
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
		model.addAttribute("mList", JSON.toJSON(menus));
		
		SysUser u=(SysUser) session.getAttribute("User");		//session 对象
		user1.setUserid(u.getUserid());		//当前对象
		
		List<SysRoletype> RoleTypelist = sysRoletypeService.findRtypeByroleid(2);			//会员类型
	
		List<Setmeal> list = setMealService.findSetmealBysmTypeID(9);		//查询 激活套餐 集合
		if(list!=null&&list.size()>0) {
			model.addAttribute("SetMealList", list);
		}
		
		
		model.addAttribute("rTlist", RoleTypelist);
		
		PageInfo<SysUser> info = sysUserService.findUserTJ(user1, pageNo, pageSize);	//数据集合
		model.addAttribute("info", info);
		model.addAttribute("loginname", user1.getLoginname());
		model.addAttribute("associatorid", user1.getAssociatorid());		
		
		return "userInfo/bonusstock";
	}
	
}

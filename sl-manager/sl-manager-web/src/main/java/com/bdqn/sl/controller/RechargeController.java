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
import com.bdqn.sl.pojo.Recharge;
import com.bdqn.sl.pojo.SysUser;
import com.bdqn.sl.service.ISysAuthorityService;
import com.bdqn.sl.service.IrechargeService;

//银行
@Controller
@RequestMapping("/admin")
public class RechargeController {

	@Resource
	private ISysAuthorityService sysAuthorityService; // 权限
	
	@Autowired
	private IrechargeService rechargeService;	//银行
	
	//新增
	@RequestMapping("/doCz")
	@ResponseBody
	public String doCz(Recharge re,HttpSession session) {
		
		if(re.getMoney()==null) {
			return "nodate";
		}
		try {
			SysUser user=(SysUser) session.getAttribute("User");
			
			re.setUserid(user.getUserid()); //用户id
			rechargeService.AddRe(re);
			return "success";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	//进入充值 页面
	@RequestMapping("/goCz")
	public String goChongzhi(Model model,HttpSession session) {
		
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
		model.addAttribute("mList", JSON.toJSON(menus));
		
		return "bank/chongzhi";
	}
	
	
	
}

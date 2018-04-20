package com.bdqn.sl.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bdqn.common.Menu;
import com.bdqn.sl.pojo.SysDictionary;
import com.bdqn.sl.pojo.SysRole;
import com.bdqn.sl.pojo.SysRoletype;
import com.bdqn.sl.pojo.SysUser;
import com.bdqn.sl.service.ISysAuthorityService;
import com.bdqn.sl.service.ISysDictionaryService2;
import com.bdqn.sl.service.ISysRoleService2;
import com.bdqn.sl.service.ISysRoletypeService;
import com.bdqn.sl.service.ISysUserService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("admin/")
public class SysUserHYController {

	@Autowired
	private ISysDictionaryService2 sysDictionaryService; // 字典

	@Autowired
	private ISysUserService sysUserService; // 用户

	@Autowired
	private ISysRoleService2 sysRoleService; // 角色

	@Autowired
	private ISysRoletypeService sysRoletypeService; // 角色类型

	@Resource
	private ISysAuthorityService sysAuthorityService; // 权限

	
	//修改个人密码
	@RequestMapping("/doupdatePWD")
	@ResponseBody
	public String doupdatePWD(SysUser user, HttpSession session) {
		System.out.println("进入修改密码---");
		
		System.out.println(user.getLoginpwd2());	//支付密码
		System.out.println(user.getLoginpwd());
		System.out.println(user.getOldPwd2());
		
		SysUser user1=(SysUser) session.getAttribute("User");
		user.setUserid(user1.getUserid()); 		//id
		//修改登录密码
		if(user.getLoginpwd()!=null) {
			
			if(!user1.getLoginpwd().equals(user.getOldPwd2())) {	//原密码不对
				return "oldpwdwrong";
			}
			try {
				sysUserService.updateUser(user);	//修改
				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				return "failed";
			}		
		
			//修改支付密码
		}else if(user.getLoginpwd2()!=null) {						
			if(!user1.getLoginpwd2().equals(user.getOldPwd2())) {	//原密码不对
				return "oldpwdwrong";
			}
			try {
				sysUserService.updateUser(user);	//修改
				
				SysUser user2 = sysUserService.findUserbyId(user1.getUserid());
				session.setAttribute("User", user2);
				return "success";
				
			} catch (Exception e) {
				e.printStackTrace();
				return "failed";
			}	
			
		}
		
		return "nodata";
	}
	
	//进入修改密码
	@RequestMapping("/goUpdatePwd")
	public String goUpdatePwd(Model model,HttpSession session) {
		
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
		model.addAttribute("mList", JSON.toJSON(menus));
		
		return "member/modifypersonalpwd";
	}
	
	//修改个人资料
	// 修改
	@RequestMapping(value = "/UpdateUserZJ", method = RequestMethod.POST)
	public String UpdateUserZJ(SysUser user,Model model) {
		List<SysDictionary> backNameList = sysDictionaryService.findDiByTypeCode("bank_type");	 //银行类型
		model.addAttribute("backNameList", backNameList);	
		
		try {
			sysUserService.updateUser(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:goUpdateUserZJ";
	}
	
	//进入修改个人资料
	@RequestMapping("/goUpdateUserZJ")
	public String goUpdateUserZJ(Model model,HttpSession session) {
		
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
		model.addAttribute("mList", JSON.toJSON(menus));
		
		SysUser user1=(SysUser) session.getAttribute("User");
		
		SysUser user = sysUserService.findUserbyId(user1.getUserid());	//session中的id
		
		SysRole role = sysRoleService.findRoleByID(user.getRoleid());	//角色
		SysRoletype roletype = sysRoletypeService.findRoleTypeById(user.getAssociatorid());	//会员类型
		SysUser user2 = sysUserService.findUserbyId(user.getReferee());	//创建人
		SysDictionary dictionary = sysDictionaryService.findDiByID(user.getCardtypeid()); //证件类型
		
		List<SysDictionary> backNameList = sysDictionaryService.findDiByTypeCode("bank_type");	 //银行类型
		model.addAttribute("backNameList", backNameList);	
		
		System.out.println("-----------------------------");
		System.out.println(backNameList.size());
		
		user.setRoleName(role.getRolename());
		user.setHyType(roletype.getRoletypename());
		user.setRefereeName(user2.getUname());
		user.setCardnumberName(dictionary.getValuename());
		
		List<SysDictionary> zjlist = sysDictionaryService.findDiByTypeCode("1"); // 证件类型
		model.addAttribute("zjlist", zjlist);

		
	
		model.addAttribute("currentUser", user);
		
		return "member/modifypersonalinfo";
	}
	
	// 修改
	@RequestMapping(value = "/UpdateUserHY", method = RequestMethod.POST)
	public String UpdateUser(SysUser user,Model model) {

		List<SysDictionary> backNameList = sysDictionaryService.findDiByTypeCode("bank_type");	 //银行类型
		model.addAttribute("backNameList", backNameList);	
		
		try {
			sysUserService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:goUserHYList";
	}

	// 进入会员管理
	@RequestMapping("/goUserHYList")
	public String goUserList(Model model, @RequestParam(required = true, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "5") Integer pageSize, SysUser user, HttpSession session) {

		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
		model.addAttribute("mList", JSON.toJSON(menus));

		SysUser u = (SysUser) session.getAttribute("User");

		user.setUserid(u.getUserid()); // 推荐人
		PageInfo<SysUser> info = sysUserService.userHYList(user, pageNo, pageSize);
		model.addAttribute("info", info);

		List<SysDictionary> zjlist = sysDictionaryService.findDiByTypeCode("1"); // 证件类型
		model.addAttribute("zjlist", zjlist);

		List<SysRoletype> userTypelist = sysRoletypeService.findRtypeByroleid(2);
		model.addAttribute("userTypelist", userTypelist);

		List<SysDictionary> backNameList = sysDictionaryService.findDiByTypeCode("bank_type");	 //银行类型
		model.addAttribute("backNameList", backNameList);
		
		model.addAttribute("loginname", user.getLoginname());
		model.addAttribute("uname", user.getUname());
		model.addAttribute("associatorid", user.getAssociatorid());
		return "member/memberlist";
	}

	// 进入注册成功
	@RequestMapping("/goRegister")
	public String goRegister(Model model, String loginName,HttpSession session) {

		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
		model.addAttribute("mList", JSON.toJSON(menus));

		SysUser sysUser = sysUserService.findUserName(loginName); // 得到对象

		model.addAttribute("registUser", sysUser);

		return "member/registok";
	}

	// 准会员 添加注册会员
	@RequestMapping("/doAddUserByZC")
	public String doAddUserByZC(SysUser user, HttpSession session,Model model) {

		user.setUpdated(new Date());
		user.setCreated(new Date());
		user.setRoleid(2); // 角色 --会员
		user.setAssociatorid(2); // 注册会员 类型
		user.setLoginpwd("123456");
		user.setLoginpwd2("123456");
		SysUser user1 = (SysUser) session.getAttribute("User");

		

		List<SysDictionary> backNameList = sysDictionaryService.findDiByTypeCode("bank_type");	 //银行类型
		model.addAttribute("backNameList", backNameList);	
		
		user.setReferee(user1.getUserid()); // 推荐人
		sysUserService.addUser(user);
		System.out.println("--- 注册会员新增完成");

		return "redirect:goRegister?loginName=" + user.getLoginname();
	}

	// 进入新会员管理
	@RequestMapping("/goAddUserByEmp")
	public String goAddUserByEmp(Model model,HttpSession session) {
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
		model.addAttribute("mList", JSON.toJSON(menus));

		List<SysDictionary> zjlist = sysDictionaryService.findDiByTypeCode("1"); // 证件类型
		model.addAttribute("zjlist", zjlist);
		
		List<SysDictionary> backNameList = sysDictionaryService.findDiByTypeCode("bank_type");	 //银行类型
		model.addAttribute("backNameList", backNameList);	

		return "member/registmember";
	}

	// 进入新增条款
	@RequestMapping("/goSysUserTK")
	public String goSysUserTK(Model model,HttpSession session) {

		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
		model.addAttribute("mList", JSON.toJSON(menus));

		return "member/registrule";
	}

}

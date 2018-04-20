package com.bdqn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bdqn.common.util.JsonUtil;
import com.bdqn.pojo.ReItem;
import com.bdqn.pojo.TbResourceItem;
import com.bdqn.pojo.TbRole;
import com.bdqn.pojo.TbRoleResourceKey;
import com.bdqn.pojo.TbUser;
import com.bdqn.service.TbResourceItemService;
import com.bdqn.service.TbRoleResourceService;
import com.bdqn.service.TbRoleService;
import com.bdqn.service.TbUserService;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONObject;

/**
 * 用户tb_User
 * @author lizhen
 * @date 2018年2月2日
 * @time 下午1:03:13
 */
@Controller
public class TbUserController {

	@Autowired
	private TbUserService userService;			//用户service
	
	@Autowired
	private TbRoleService tbRoleService;		//角色service
	
	@Autowired
	private TbRoleResourceService tbRoleResourceService;		//角色 和资源中间表
	
	@Autowired
	private TbResourceItemService tbResourceItemService;
	
	@RequestMapping("/HMS/doUserEdit")
	public String doUserEdit(TbUser user,Model model) {
		try {
			userService.updateUser(user);
			return "redirect:/HMS/findUserList";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/HMS/findUserList?code=500";
		}
	}
	
	
	//进入编辑界面
	@RequestMapping("/HMS/goUserEdit")
	public String goUserEdit(Integer id,Model model,Integer code) {
		if(code!=null) {
			model.addAttribute("msg", "新增用户失败");
		}
		
		TbUser user = userService.findUserById(id);
		model.addAttribute("user", user);				//用户信息
		List<TbRole> list = tbRoleService.findAllRole();
		model.addAttribute("roleList", list);			//角色集合
		return "/User/editUser";
	}
	
	
	//删除用户 通过id
	@RequestMapping("/HMS/delUser")
	public String delUser(Integer id) {
		try {
			userService.deleteUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/HMS/findUserList";
	}
	
	//查询分页
	@RequestMapping("/HMS/findUserList")
	public String findUserList(@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="3") Integer pageSize,String loginname,Model model) {
		
		try {
			PageInfo<TbUser> list = userService.findList(loginname, pageNo, pageSize);
			List<TbRole> allRole = tbRoleService.findAllRole();
			model.addAttribute("allRole", allRole);				//所有角色
			model.addAttribute("userList", list);				//查询集合
			model.addAttribute("loginname", loginname);			//名称
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "查询失败");
		}
		return "User/index";
	}
	
	
	
	//判断重名
	@RequestMapping("/HMS/doUserByusername")
	@ResponseBody
	public String doUserByusername(String loginName) {
	
		String msg = userService.findUserByName(loginName);
		System.out.println("msg:"+msg);
		if(msg.equals("ok")) 
			return JsonUtil.success();
		return JsonUtil.error("名称以存在!");
		
	}
	
	//新增用户
	@RequestMapping("/HMS/doAddUser")
	public String doAddUser(TbUser user,Model model) {
		try {
			userService.AddTbUser(user);
			return "redirect:/HMS/goUserIndx";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/HMS/goAddUser?code=500";
		}
	}
	
	//进入新增用户界面
	@RequestMapping("/HMS/goAddUser")
	public String goAddUser(Model model,Integer code) {
		
		try {
			if(code!=null) {
			   model.addAttribute("msg", "新增失败");
			}
			List<TbRole> list = tbRoleService.findAllRole();
			model.addAttribute("RoleList", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "User/addUser";
	}
	
	// 进入用户管理
	@RequestMapping("/HMS/goUserIndx")
	public String goUserIndx() {
		return  "redirect:/HMS/findUserList";
	}
	
	
	
	//--------------------------------------------------------------
	//进入首页
	@RequestMapping("/HMS/goIndx")
	public String goIndx(HttpSession session,Model model) {
		TbUser user=(TbUser) session.getAttribute("User");
		Integer roleId=user.getRoleid();			//得到角色id
		List<TbRoleResourceKey> list = tbRoleResourceService.findAllByRoleId(roleId); //根据角色id查询 对应的资源id
		List<Integer> item=new ArrayList<Integer>();
		for (TbRoleResourceKey tbRoleResourceKey : list) {
			item.add(tbRoleResourceKey.getItemid());			//复制到集合中
		}
		if (item.size()==0) {
			return "index";
		}
		List<TbResourceItem> list2 = tbResourceItemService.findIDByList(item);
		List<ReItem> Rlist=new ArrayList<ReItem>();
		
		for (TbResourceItem tbResourceItem : list2) {
			
			ReItem r=new ReItem();
			r.setId(tbResourceItem.getId());
			r.setText(tbResourceItem.getRnam());
			r.setHref(tbResourceItem.getUrl());
			Rlist.add(r);
		}
		
		
		String items=JSON.toJSONString(Rlist);
		
		model.addAttribute("list", items);
		
		return "index";
	}
	
	@RequestMapping("/HMS/doTu")
	public String doTu(HttpSession session) {
		session.removeAttribute("User");
		
		return "login";
	}
	
	
	// 登录
	@RequestMapping("/doLogin")
	public String doLogin(String loginId, String loginPwd, HttpSession session,Model model) {
		if(loginId==null&&loginPwd==null) {
			return "login";
		}
		TbUser user = userService.findTbUserByLoginName(loginId, loginPwd);
		if (user != null) {
			if (user.getStatus() == 1) {
				session.setAttribute("User", user);
				
				
				return "redirect:/HMS/goIndx";
			}
			model.addAttribute("error", "该用户已被禁用,请联系管理员!");
			return "login";
		}
		model.addAttribute("error", "用户名或密码错误!");
		return "login";
	}

	// 进入登录
	@RequestMapping("goLogin")
	public String goLogin() {
		return "login";
	}

}

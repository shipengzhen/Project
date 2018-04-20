/**
 * 
 */
package com.bdqn.sl.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.bdqn.common.Menu;
import com.bdqn.sl.pojo.SysRole;
import com.bdqn.sl.service.ISysAuthorityService;
import com.bdqn.sl.service.ISysRoleService;
import com.bdqn.sl.service.ISysUserService;

/**
 * @描述 角色控制器
 * @作者 施鹏振
 * @创建日期 2018年3月15日
 * @创建时间 下午8:18:13
 */
@Controller
@RequestMapping("admin/")
public class RoleController {

	@Resource
	private ISysRoleService sysRoleService;	//角色
	
	@Resource
	private ISysAuthorityService sysAuthorityService;  //权限
	
	@Resource
	private ISysUserService sysUserService;	//用户

	//角色首页
	@RequestMapping("roleList")
	public ModelAndView roleList(Model model,HttpSession session) {
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
		model.addAttribute("mList", JSON.toJSON(menus));
		return new ModelAndView("backend/rolelist", "roleList", sysRoleService.findRoles());
	}

	// 添加角色
	@RequestMapping("addRole")
	@ResponseBody
	public String addRole(String roleName, Integer status,HttpSession session) {
		
		Integer uid=(Integer) session.getAttribute("Userid");
		
		if (roleName == null || roleName.equals("")) {
			return "nodata";
		}
		if (status == null) {
			return "nodata";
		}
		if (sysRoleService.existRole(roleName)) {
			return "rename";
		}
		if (sysRoleService.addRole(roleName, status, uid)) {
			return "success";
		}
		return "failed";
	}

	// 修改角色
	@RequestMapping("modifyRole")
	@ResponseBody
	public String modifyRole(SysRole role,HttpSession session,
			@RequestParam(value="code",required=false) String code) {
		// code 状态  修改状态 code=1
		System.out.println("--------------------进入修改角色！！");
		System.out.println(code);
		if(code.equals("1")) {
			Integer count = sysUserService.findUserCountByRole(role.getRoleid());
			System.out.println("COUNT:"+count);
			if(count>0) {
				return "nofalse";
			}
		}
		
		Integer uid=(Integer) session.getAttribute("Userid");
		role.setUpdateuid(uid);// 修改人
		if (role.getRoleid() == null) {
			return "nodata";
		}
		if (role.getRolename() != null) {
			if (role.getRolename().equals("")) {
				return "nodata";
			}
			if (sysRoleService.existRole(role.getRolename())) {
				return "rename";
			}
			if (sysRoleService.modifyRole(role)) {
				return "success";
			}
		} else if (role.getStatus() != null) {
			if (sysRoleService.modifyRole(role)) {
				return "success";
			}
		} else {
			return "nodata";
		}
		return "failed";
	}

	//删除角色
	@RequestMapping("delRole")
	@ResponseBody
	public String delRole(Integer roleid) {
		System.out.println(roleid);
		if (roleid==null) {
			return "nodata";
		}
		if (sysUserService.findUserCountByRole(roleid)>0) {
			return "nodel";
		}
		if (sysRoleService.delRole(roleid)) {
			return "success";
		}
		return "failed";
	}
}

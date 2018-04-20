/**
 * 
 */
package com.bdqn.sl.controller;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.bdqn.common.Menu;
import com.bdqn.sl.pojo.SysUser;
import com.bdqn.sl.service.ISysAuthorityService;
import com.bdqn.sl.service.ISysRoleService;

/**
 * @描述 sl-manager-web
 * @作者 施鹏振
 * @创建日期 2018年3月16日
 * @创建时间 下午2:56:30
 */
@Controller
@RequestMapping("admin/")
public class AuthorityController {

	@Resource
	private ISysRoleService sysRoleService;

	@Resource
	private ISysAuthorityService sysAuthorityService;

	//权限
	private void getAutoList(Model model,HttpSession session) {
		//权限
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
		model.addAttribute("mList", JSON.toJSON(menus));
	}
	
	//权限管理 首页
	@RequestMapping("authoritymanage")
	public String authorityManage(Model model,HttpSession session) {
		model.addAttribute("roles", sysRoleService.findRoles());
		sysAuthorityService.findAuthoritys();
		
		//权限
		this.getAutoList(model, session);
		
		return "backend/authoritymanage";
	}

	//权限列表
	@RequestMapping("authoritylist")
	@ResponseBody
	public String authorityList() {
		List<Menu> menus = sysAuthorityService.findAuthoritys();
		return JSON.toJSONString(menus);
	}

	//修改角色权限
	@RequestMapping("modifyAuthority")
	@ResponseBody
	public String modifyAuthority(Integer roleId,String authorityIds) {
		if (roleId==null) {
			return "nodata";
		}
		if (authorityIds==null||authorityIds.equals("")) {
			return "nodata";
		}
		if (sysAuthorityService.modifyAuthority(roleId,StringUtils.split(authorityIds, "-"))) {
			return "success";
		}
		return "failed";
	}
	
	@RequestMapping("getAuthorityDefault")
	@ResponseBody
	public String getAuthorityDefault(Integer roleId,Integer authoriyId)
	{
		List<Integer> integers=sysAuthorityService.findAuthorityIdsByRoleId(roleId);
		for (Integer integer : integers) {
			if (integer==authoriyId) {
				return "success";
			}
		}
		return "failed";
	}
}

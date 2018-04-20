package com.bdqn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdqn.common.util.JsonUtil;
import com.bdqn.pojo.TbResourceItem;
import com.bdqn.pojo.TbRole;
import com.bdqn.pojo.TbRoleResourceKey;
import com.bdqn.service.TbResourceItemService;
import com.bdqn.service.TbRoleResourceService;
import com.bdqn.service.TbRoleService;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONObject;

/**
 * 角色 管理控制器
 * @author lizhen
 * @date 2018年2月3日
 * @time 上午10:45:39
 */
@Controller
@RequestMapping("/HMS")
public class TbRoleController {
	
	//角色
	@Autowired
	private TbRoleService tbRoleService;
	//资源
	@Autowired
	private TbResourceItemService TbRItemServie;
	//中间表
	@Autowired
	private TbRoleResourceService tbRoleResourceService;
	
	//编辑保存
	@RequestMapping("/doditRole")
	public String doditRole(Integer[]items,TbRole role,Model model) {
		try {
			tbRoleService.updateRoleById(items, role);
			return "redirect:/HMS/doFindLikeRoleName";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/HMS/goeditRole?code=500";
		}
	}
	
	//进入编辑界面
	@RequestMapping("/goeditRole")
	public String goeditRole(Integer id,Model model,Integer code) {
		
		try {
			if(code!=null) {
				model.addAttribute("msg", "保存失败");
			}
			TbRole tbRole = tbRoleService.findRoleById(id);		//角色对象
			List<TbResourceItem> TbResourceItemlist = TbRItemServie.findAllRItem(); 	//所有的项
			List<TbRoleResourceKey> RoleResourcelist = tbRoleResourceService.findAllByRoleId(id); //中间表对象
			
			model.addAttribute("tbRole", tbRole);
			model.addAttribute("TbResourceItemlist", TbResourceItemlist);
			model.addAttribute("RoleResourcelist", RoleResourcelist);
			
			return "Role/editRole";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/HMS/doFindLikeRoleName";
		}
		
		
	}
	
	//新增
	@RequestMapping(value="/addRole",method=RequestMethod.POST)
	public String addRole(TbRole tbRole,Integer[]items) {
		
		
		try {
			tbRoleService.insertRole(tbRole);
			tbRoleResourceService.AddRoleResources(items,tbRole.getId());
			
			return "redirect:/HMS/goRoleIndex";
		} catch (Exception e) {
			e.printStackTrace();
			
			return "redirect:/HMS/goRoleAdd?code=500";
		}
	}
	//ajax验证 姓名
	@RequestMapping("/findByRoleName")
	@ResponseBody
	public String findByRoleName(String roleName) {
		Map<String,String> map=new HashMap<String, String>();
		 String msg = tbRoleService.findTbRoleByName(roleName);
		 map.put("msg", msg);
		 
		 return JSONObject.fromObject(map).toString();
	}
	
	//进入添加角色页面
	@RequestMapping("/goRoleAdd")
	public String goRoleAdd(Model model,Integer code) {
		
		//新增失败
		if(code!=null) {
			model.addAttribute("msg", "新增失败");
		}
		try {
			List<TbResourceItem> item = TbRItemServie.findAllRItem();
			model.addAttribute("List", item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Role/addRole";
	}
	//删除
	@RequestMapping("/dodelRole")
	@ResponseBody
	public String dodelRole(Integer id) {
		try {
			tbRoleService.deleteRole(id);
			return JsonUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.error("删除失败!");
		}
	}
	//查询  分页
	@RequestMapping("doFindLikeRoleName")
	public String doFindLikeRoleName(@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="3") Integer pageSize,String rolename,Model model) {
		
		try {
			PageInfo<TbRole> info = tbRoleService.findTbRoleLikeName(rolename, pageNo, pageSize);
			model.addAttribute("rolename", rolename);			//搜索的名称
			model.addAttribute("info", info);					//分页
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "查询失败");
		}
		return "Role/index";
	}
	
	//进入角色管理首页
	@RequestMapping("/goRoleIndex")
	public String goRoleIndex() {
		
		return "redirect:/HMS/doFindLikeRoleName";
	}
	
}

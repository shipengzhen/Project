package com.bdqn.sl.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bdqn.common.JsonUtil;
import com.bdqn.common.Menu;
import com.bdqn.sl.pojo.Affiche;
import com.bdqn.sl.pojo.SysUser;
import com.bdqn.sl.service.IAfficheService;
import com.bdqn.sl.service.ISysAuthorityService;
import com.bdqn.sl.service.ISysRoleAuthorityKeyService;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONObject;

//公共
@Controller
@RequestMapping("/admin")
public class AfficheController {

	@Resource
	private ISysAuthorityService sysAuthorityService; // 权限
	
	@Autowired
	private IAfficheService AfficheController;		//公告
	
	@Autowired
	private ISysRoleAuthorityKeyService sysRoleAuthorityKeyService;	//权限 -lz
	
	//权限
	private void getAutoList(Model model,HttpSession session) {
		//权限
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
		model.addAttribute("mList", JSON.toJSON(menus));
	}
	
	
	//进入详情页面 公告
	@RequestMapping("/goAfficheView")
	public String goAfficheView(Integer id,Model model,HttpSession session) {
		if(id==null||id<=0) {
			return "redirect:main";
		}
		
		Affiche affiche=null;
		try {
			affiche = AfficheController.findAfficheById(id);
			model.addAttribute("affiche", affiche);
			if(affiche==null) {
				return "redirect:main";
			}
			//权限
			this.getAutoList(model, session);

			return "informanage/portalaffichedetail";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:main";
		}
		
	}
	
	//根据id删除
	@RequestMapping("/deleteAffiche")
	@ResponseBody
	public String deleteAffiche(Integer id) {
		
		if(id==null) {
			return "nodata";
		}
		
		try {
			AfficheController.deleteAffiche(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
		
		
	}
	
	//修改
	@RequestMapping("/udpateAffiche")
	public String udpateAffiche(Affiche affiche) {
		
		try {
			AfficheController.UpdateAffiche(affiche);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:affichList";
	}
	
	//根据id获取对象
	@RequestMapping( value="/getaffich",produces= {"text/html;charset=UTF-8"})
	@ResponseBody
	public String getaffich(Integer id) {
		if(id==null) {
			return JSON.toJSONString("nodata");
		}
		try {
			Affiche affiche = AfficheController.findAfficheById(id);
			
			
			return JSON.toJSONString(affiche);
			
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString("failed");
		}
		
	}
	
	//查询分页
	@RequestMapping("/affichList")
	public String affichList(@RequestParam(required=true,defaultValue="1") Integer pageNum,
			@RequestParam(required=false,defaultValue="5") Integer pageSize,Model model,HttpSession session) {
	
		
		SysUser user=(SysUser) session.getAttribute("User");
		Integer type=2;
		if(user.getRoleid()==1) {
			type=1;		//是否为管理员
		}
		
		PageInfo<Affiche> info = AfficheController.findAllAffiche(type,pageNum, pageSize);

		//权限
		this.getAutoList(model, session);
		
		System.out.println("--->"+user.getRoleid());
			//1 :表示 有此权限 
		model.addAttribute("selectAffiche", sysRoleAuthorityKeyService.findRAbyKey(user.getRoleid(),36));	//查看
		model.addAttribute("insertAffiche", sysRoleAuthorityKeyService.findRAbyKey(user.getRoleid(),37));  //新增
		model.addAttribute("updateAffiche", sysRoleAuthorityKeyService.findRAbyKey(user.getRoleid(),38));	//修改
		model.addAttribute("deleteAffiche", sysRoleAuthorityKeyService.findRAbyKey(user.getRoleid(),39));	//删除
			
		
		
		model.addAttribute("info", info);
		
		return "informanage/affiche";
	}
	
	
	//新增公告
	@RequestMapping("/addAffich")
	public String addAffich(Affiche affiche,HttpSession session) {
		
		SysUser user=(SysUser)session.getAttribute("User");
		
		affiche.setCreateuid(user.getUserid());		//创建人
		AfficheController.addAffiche(affiche);
		
		return "redirect:goAffich";
	}
	
	
	//进入公告
	@RequestMapping("/goAffich")
	public String goAffich(Model model) {
		
		return "redirect:affichList";
	}
	
}

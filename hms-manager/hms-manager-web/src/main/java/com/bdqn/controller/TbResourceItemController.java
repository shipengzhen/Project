package com.bdqn.controller;

import java.util.HashMap;
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
import com.bdqn.service.TbResourceItemService;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONObject;

/**
 * 资源管理 项
 * @author lizhen
 * @date 2018年2月1日
 * @time 下午4:54:08
 */
@Controller
@RequestMapping("/HMS")
public class TbResourceItemController {
	
	@Autowired
	private TbResourceItemService TbRItemServie;
	//修改
	@RequestMapping(value="/updateRItem",method=RequestMethod.POST)
	public String updateRItem(TbResourceItem RItem,Model model) {
		try {
			TbRItemServie.updateRItem(RItem);
			return "redirect:/HMS/goResourceIndex";
		} catch (Exception e) {
			model.addAttribute("msg","更新失败！");
			return "Resource/edit";
		}
	}
	//进入修改
	@RequestMapping("/goUpdateRItem")
	public String goUpdateRItem(Integer id,Model model) {
		try {
			model.addAttribute("Item", TbRItemServie.findRItemByid(id));
			return "Resource/edit";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/HMS/goResourceIndex";	
	}
	//新增资源管理项
	@RequestMapping(value="/createRItem",method=RequestMethod.POST)
	public String createRItem(TbResourceItem RItem,Model model) {
		try {
			TbRItemServie.addTRItem(RItem);
			return "redirect:/HMS/goResourceIndex";	
		} catch (Exception e) {
			model.addAttribute("msg","更新失败！");
			return "Resource/add";
		}
	}
	//ajax 验证
	@RequestMapping("/doRibyRname")
	@ResponseBody
	public String doRibyRname(String rnam) {
		Map<String,String> map=new HashMap<String, String>();
		String msg=TbRItemServie.fromTRItemByrnam(rnam);
		map.put("msg", msg);
		
		return JSONObject.fromObject(map).toString();
	}
	
	//进入新增资源项页面
	@RequestMapping("goRIAdd")
	public String goRIAdd() {
		return "Resource/add";
	}
	//删除项 ajax
	@RequestMapping("delRItem")
	@ResponseBody
	public String delRItem(Integer id) {
		
		try {
			TbRItemServie.deleteRItem(id);
			return JsonUtil.success();
		} catch (Exception e) {
			return JsonUtil.error("删除失败!");
		}
	}
	//添加查询
	@RequestMapping("/doResultSelect")
	public String doResultSelect(@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="3") Integer pageSize,String rname,Model model) {
		
	    PageInfo<TbResourceItem> info = TbRItemServie.findTbRIByRname(rname, pageNo, pageSize);
		model.addAttribute("result", info);
		
		if(rname!=null) {
			model.addAttribute("rname", rname);
		}
	
		return "Resource/index";
	}
	
	//进入资源管理 列表
	@RequestMapping("/goResourceIndex")
	public String goResourceIndex() {
	
		return "redirect:/HMS/doResultSelect";
	}
}

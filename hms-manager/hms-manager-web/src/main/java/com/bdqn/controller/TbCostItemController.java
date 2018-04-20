package com.bdqn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdqn.common.util.JsonUtil;
import com.bdqn.pojo.TbCostItem;
import com.bdqn.service.TbCostItemService;
import com.github.pagehelper.PageInfo;

//收费项 
@Controller
@RequestMapping("/HMS")
public class TbCostItemController {
	
	@Autowired
	private TbCostItemService tbCostItemService;	//收费项
	
	//删除
	@RequestMapping("/delCostItem")
	@ResponseBody
	public String delCostItem(Integer id) {
		
		try {
			tbCostItemService.deleCostItem(id);
			return JsonUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.error("删除失败");
		}
	}
	
	//修改
	@RequestMapping("/doUpdateCitem")
	public String doUpdateCitem(TbCostItem ci) {
		try {
			tbCostItemService.UpdateCostItem(ci);
			return "redirect:/HMS/doSelectList";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/HMS/goUpdateCitem?code=500";
		}
		
	}
	
	//进入修改
	@RequestMapping("/goUpdateCitem")
	public String goUpdateCitem(Integer id,Integer code,Model model) {
		
		if(code!=null) {
			model.addAttribute("msg", "修改失败");
		}
		try {
			TbCostItem item = tbCostItemService.findCostItemById(id);
			model.addAttribute("item", item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "hospital/charge-edit";
	}
	
	//条件查询
	@RequestMapping("/doSelectList")
	public String doSelectList(@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="3") Integer pageSize,String costitemname,Model model) {
		
		try {
			PageInfo<TbCostItem> list = tbCostItemService.findCostList(costitemname, pageNo, pageSize);
			model.addAttribute("list", list);
			model.addAttribute("costitemname", costitemname);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "hospital/charge";
	}
	
	
	//新增
	@RequestMapping("/doAddCostItem")
	public String goAddCostItem(TbCostItem ci,Model model) {
		try {
			tbCostItemService.AddCostItem(ci);
			return "redirect:/HMS/gocharge";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "新增失败");
			return "hospital/charge-add";
		}
	}
	
	//进入新增收费项 
	@RequestMapping("/goAddCostItem")
	public String goAddCostItem() {
		return "hospital/charge-add";
	}
	
	//进入收费项 管理  列表 
	@RequestMapping("/gocharge")
	public String gocharge2() {
		return "redirect:/HMS/doSelectList";
	}
}

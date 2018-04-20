package com.bdqn.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bdqn.pojo.TbCostItem;
import com.bdqn.pojo.TbCostsCostsitemKey;
import com.bdqn.pojo.TbRegister;
import com.bdqn.service.TbBeHospitalizedService;
import com.bdqn.service.TbCostItemService;
import com.bdqn.service.TbCostsCostsitemKeyService;
import com.bdqn.service.TbCostsService;
import com.bdqn.service.TbRegisterService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/HMS")
public class TbCostsController {
	
	@Autowired
	private TbRegisterService tbRegisterService2;	//挂号
	
	@Autowired
	private TbCostsService tbCostsService;				//收费项登记
	
	@Autowired
	private TbCostItemService tbCostItemService;	//收费项
	
	@Autowired
	private TbCostsCostsitemKeyService tbCostsCostsitemKeyService;
	
	//进入 收费项查看 
	@RequestMapping("/goCharge2")
	public String goCharge2() {
		return "hospital/charge2-look";
	}
	
	//- - -
	//新增  给 挂号 添加收费项 -->中间表新增 
	@RequestMapping("/doaddCostccostItem")
	public String doaddCostccostItem(TbCostsCostsitemKey ccitem) {
		try {
			System.out.println("----------------------");
			TbCostItem item = tbCostItemService.findCostItemById(ccitem.getItemid());//收费项 信息
			System.out.println(item.getCost());						//收费项价格
			
			
			TbRegister register2 = tbRegisterService2.findReById(ccitem.getCostsid());	//原挂号
			
			TbRegister register = new TbRegister();								//挂号
			register.setId(ccitem.getCostsid());
			
			if(register2.getHfcost()!=null) {
				BigDecimal d=item.getCost();
				d=d.add(register2.getHfcost());
				register.setHfcost(d);
			}else {
				register.setHfcost(item.getCost());
			}
			
			System.out.println(register.getId());
			System.out.println(register.getHfcost());
			
			tbRegisterService2.updateRe(register);
			
			
			tbCostsCostsitemKeyService.AddccItem(ccitem);
			return "redirect:/HMS/docostsList";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/HMS/goaddCostccostItem?code=500";
		}
	
	}
	
	//进入 给 挂号 添加收费项
	@RequestMapping("/goaddCostccostItem")
	public String goaddCostccostItem(Integer id,Model model,Integer code) {
		
		if(code!=null) {
			model.addAttribute("msg", "新增失败");
		}
		try {
			TbRegister register = tbRegisterService2.findReById(id);
			model.addAttribute("register", register);
			
			List<TbCostItem> itenList = tbCostItemService.CostItenList();
			
			model.addAttribute("itenList", itenList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "hospital/charge2-add";
	}
	
	
	//查询分页
	@RequestMapping("/docostsList")
	public String docostsList(@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="3") Integer pageSize,Integer id,String name,Model model) {
		
		try {
			PageInfo<TbRegister> list = tbCostsService.findReList(id, name, pageNo, pageSize);
			model.addAttribute("list", list);
			
			model.addAttribute("id", id);
			model.addAttribute("name", name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "hospital/charge2";
	}
	
	//进入收费项目登记
	@RequestMapping("/gocharge2")
	public String gocharge2() {
		return "redirect:/HMS/docostsList";
	}
}

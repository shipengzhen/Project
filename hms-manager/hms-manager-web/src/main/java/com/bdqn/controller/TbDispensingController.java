package com.bdqn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bdqn.pojo.TbDispensing;
import com.bdqn.pojo.TbMedicine;
import com.bdqn.pojo.TbRegister;
import com.bdqn.service.TbDispensingService;
import com.bdqn.service.TbMedicineService;
import com.bdqn.service.TbRegisterService;
import com.github.pagehelper.PageInfo;

//在原 发药
@Controller
@RequestMapping("/HMS")
public class TbDispensingController {
	
	@Autowired
	private TbDispensingService tbDispensingService;	//在院发药
	
	@Autowired
	private TbRegisterService tbRegisterService;	//挂号
	
	@Autowired
	private TbMedicineService tbMedicineService;	//药品管理
	
	//修改
	@RequestMapping("/doUpdateDi")
	public String doUpdateDi(Integer id,Integer number,Integer rid) {
		try {
			TbDispensing dispensing = new TbDispensing();
			dispensing.setId(id);
			dispensing.setMedicineyf(number);
			tbDispensingService.UpdateDi(dispensing);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/HMS/goDiLook?id="+rid;
	}
	
	//进入详情
	@RequestMapping("/goDiLook")
	public String goDiLook(@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="3") Integer pageSize,Integer id,Model model) {
		
		try {
			PageInfo<TbRegister> pageInfo = tbDispensingService.findReListDi2(id, pageNo, pageSize);
			model.addAttribute("list", pageInfo);
			
			model.addAttribute("id", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "hospital/dispensing-look";
	}
	
	//新增 发药
	@RequestMapping("/doDisAdd")
	public String doDisAdd(TbDispensing di) {
		System.out.println(di.getMedicinenmae());
		try {
			tbDispensingService.AddDi(di);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/HMS/selectDis";
	}
	
	//进入在院 发药
	@RequestMapping("/goDisAdd")
	public String goDisAdd(Integer id,Model model) {
		
		try {
			TbRegister register = tbRegisterService.findReById(id);	//挂号
			model.addAttribute("register", register);
			
			List<TbMedicine> meList = tbMedicineService.MeList();
			model.addAttribute("meList", meList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "hospital/dispensing-give";
	}
	
	//条件查询
	@RequestMapping("/selectDis")
	public String selectDis(@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="3") Integer pageSize,Integer id,Model model) {
		
		System.out.println(id);
		
		try {
			PageInfo<TbRegister> pageInfo = tbDispensingService.findReListDi(pageNo, pageSize, id);
			
			model.addAttribute("list", pageInfo);
			model.addAttribute("id", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "hospital/dispensing";
	}
	
	//进入首页
	@RequestMapping("/goDispensingIndex")
	public String goDispensingIndex() {
		return "redirect:/HMS/selectDis";
	}
}

package com.bdqn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdqn.common.util.JsonUtil;
import com.bdqn.pojo.TbDoctors;
import com.bdqn.pojo.TbOpd;
import com.bdqn.pojo.TbRegister;
import com.bdqn.pojo.TbRegisterSelect;
import com.bdqn.service.TbDoctorsService;
import com.bdqn.service.TbOpdService;
import com.bdqn.service.TbRegisterService;
import com.github.pagehelper.PageInfo;

import net.sf.json.util.JSONUtils;

@Controller
@RequestMapping("/HMS")
public class TbRegisterController {
	
	@Autowired
	private TbRegisterService tbRegisterService;	//挂号
	
	@Autowired
	private TbOpdService  tbOpdService;				//科室
	
	@Autowired
	private TbDoctorsService tbDoctorsService;		//医生
	
	//根据id查询 挂号
	@RequestMapping("/doReByidAjax")
	@ResponseBody
	public String doReByidAjax(Integer id) {
		
			try {
				TbRegister register = tbRegisterService.findReById(id); 	//挂号
				if(register==null) {
					return JsonUtil.error("查询失败");
				}
				
				TbDoctors doctors = tbDoctorsService.findDoctorById(register.getDoctorid()); 	//医生
				TbOpd opd = tbOpdService.findOpdById(register.getOpdid());			//科室
				
				register.setDoctorName(doctors.getDoctorname());	//姓名
				register.setOpdname(opd.getName());
				
				return JsonUtil.success(register);
			} catch (Exception e) {
				e.printStackTrace();
				return JsonUtil.error("查询失败");
			}
	}
	
	
	
	//修改状态
	@RequestMapping("/doUpdateStatus")
	@ResponseBody
	public String doUpdateStatus(Integer id) {
		try {
			TbRegister register = new  TbRegister();
			register.setId(id);
			register.setStatus(2);		//状态2  
			tbRegisterService.updateRe(register);
			return JsonUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.error("修改失败");
		}
		
	}
	
	//修改
	@RequestMapping("/doUpdateRe")
	public String doUpdateRe(TbRegister Re) {
		try {
			tbRegisterService.updateRe(Re);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/HMS/doReList";
	}
	//进入修改
	@RequestMapping("/goUpdateRe")
	public String goUpdateRe(Integer id,Model model) {
		TbRegister register = tbRegisterService.findReById(id); 	//挂号
		model.addAttribute("register", register);
		
		List<TbOpd> opdlist = tbOpdService.opdList(); 		//科室集合
		model.addAttribute("opdlist", opdlist);				
		//医生
		List<TbDoctors> byopdList = tbDoctorsService.findDoctByopdid(register.getOpdid());
		model.addAttribute("doctors", byopdList);
		
		
		return "registration/edit";
	}
	
	//根据id查询 挂号
	@RequestMapping("/doReByid")
	public String doReByid(Integer id,Model model) {
			TbRegister register = tbRegisterService.findReById(id); 	//挂号
			
			TbDoctors doctors = tbDoctorsService.findDoctorById(register.getDoctorid()); 	//医生
			TbOpd opd = tbOpdService.findOpdById(register.getOpdid());			//科室
			
			model.addAttribute("register", register);
			model.addAttribute("opd", opd);
			model.addAttribute("doctors", doctors);
			
			return "registration/look";
	}
	
	//挂号分页查询
	@RequestMapping("/doReList")
	public String doReList(@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="3") Integer pageSize,TbRegisterSelect Res,Model model) {
		
		System.out.println("---");
		System.out.println(Res.getDoctorname());
		System.out.println(Res.getOpdName());
		
		try {
			PageInfo<TbRegister> pageInfo = tbRegisterService.findReList(Res, pageNo, pageSize);
			model.addAttribute("list", pageInfo);
			model.addAttribute("Res", Res);
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "查询错误");
		}
		return "registration/index";
		
	}
	
	
	
	//通过名称查询 科室
	@RequestMapping("/doSelectOpdList")
	@ResponseBody
	public String doSelectOpdList(Integer id) {
		try {
			
			List<TbDoctors> list = tbDoctorsService.findDoctByopdid(id);
			
			return JsonUtil.success(list);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.error("查询失败");
		}
	}
	
	//新增挂号
	@RequestMapping("/doAddRe")
	public String doAddRe(TbRegister re,Model model) {
		try {
			tbRegisterService.addRe(re);
			return "redirect:/HMS/goReIdex";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "新增失败!");
			return "registration/add";
		}
	}
	
	//进入挂号
	@RequestMapping("/goAddRe")
	public String goAddRe(Model model) {
		List<TbOpd> opdlist = tbOpdService.opdList(); 	//科室集合
		
		model.addAttribute("opdlist", opdlist);		
		return "registration/add";
	}
	
	//进入挂号首页
	@RequestMapping("/goReIdex")
	public String goReIndex() {
		return "redirect:/HMS/doReList";
	}
}

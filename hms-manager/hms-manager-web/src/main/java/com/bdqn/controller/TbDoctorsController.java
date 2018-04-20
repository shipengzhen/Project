package com.bdqn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bdqn.pojo.TbDoctors;
import com.bdqn.pojo.TbOpd;
import com.bdqn.service.TbDoctorsService;
import com.bdqn.service.TbOpdService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/HMS")
public class TbDoctorsController {
	
	@Autowired
	private TbOpdService tbOpdService;		//科室
	
	@Autowired
	private TbDoctorsService tbDoctorsService;	//医生
	
	//修改保存
	@RequestMapping("/doEdit")
	public String doEdit(TbDoctors doctor) {
		try {
			tbDoctorsService.updateDoctor(doctor);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/HMS/doSelectDoctor";
	}
	
	//进入修改界面
	@RequestMapping("/goEdit")
	public String goEdit(Integer id,Model model) {
		
		try {
			TbDoctors tbDoctor = tbDoctorsService.findDoctorById(id); 	//医生
			TbOpd opd = tbOpdService.findOpdById(tbDoctor.getOpdid());	//科室
			
			List<TbOpd> list = tbOpdService.opdList(); 		//所有科室
			
			model.addAttribute("tbDoctor", tbDoctor);
			model.addAttribute("opd", opd);
			model.addAttribute("opdlist", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return "doctor/edit";
		
	}
	
	//进入详情界面
	@RequestMapping("/goLook")
	public String goLook(Integer id,Model model) {
		try {
			TbDoctors doctors = tbDoctorsService.findDoctorById(id);	//医生
			
			TbOpd opd = tbOpdService.findOpdById(doctors.getOpdid());	//科室
			model.addAttribute("doctor", doctors);
			model.addAttribute("opd",opd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "doctor/look";
	}
	
	
	//查询 分页
	@RequestMapping("/doSelectDoctor")
	public String doSelectDoctor(TbDoctors doctor,String name,
			@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="3") Integer pageSize,Model model) {
		
		PageInfo<TbDoctors> list = tbDoctorsService.findDoctList(doctor, name, pageNo, pageSize);
		model.addAttribute("list", list);
		model.addAttribute("doctor", doctor);	//查询条件
		model.addAttribute("name", name);
		return "doctor/index";
		
	}
	
	//新增医生
	@RequestMapping("/doAddDoctor")
	public String doAddDoctor(TbDoctors doctor,Model model ) {
		try {
			tbDoctorsService.addDoctor(doctor);
			return "redirect:/HMS/doSelectDoctor";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "新增用户失败");
			return "doctor/add";
		}
	}
	
	//进入新增医生页面
	@RequestMapping("/goAddDoctor")
	public String goAddDoctor(Model model) {
		List<TbOpd> opdList = tbOpdService.opdList();
		model.addAttribute("opdList", opdList);			//科室集合
		return "doctor/add";
	}
	
	//进入医生列表
	@RequestMapping("/goDoctIndex")
	public String goDoctIndex() {
		return "redirect:/HMS/doSelectDoctor";
	}
	
}

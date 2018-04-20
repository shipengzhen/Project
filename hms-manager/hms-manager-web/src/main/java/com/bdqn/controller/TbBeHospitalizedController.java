package com.bdqn.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bdqn.pojo.TbBeHospitalized;
import com.bdqn.pojo.TbCostItem;
import com.bdqn.pojo.TbDoctors;
import com.bdqn.pojo.TbOpd;
import com.bdqn.pojo.TbRegister;
import com.bdqn.pojo.TbRegisterSelect;
import com.bdqn.service.TbBeHospitalizedService;
import com.bdqn.service.TbDoctorsService;
import com.bdqn.service.TbOpdService;
import com.bdqn.service.TbRegisterService;
import com.github.pagehelper.PageInfo;


//住院办理
@Controller
@RequestMapping("/HMS")
public class TbBeHospitalizedController {
	
	@Autowired
	private TbBeHospitalizedService tbBeHospitalizedService;		//住院
	
	@Autowired
	private TbRegisterService tbRegisterService2;	//挂号
	
	@Autowired
	private TbOpdService  tbOpdService2;				//科室
	
	@Autowired
	private TbDoctorsService tbDoctorsService2;		//医生
	
	//--------------住院结算
	
	@RequestMapping("/AccJS")
	public String doAccJS(Integer rid) {
		TbRegister re=new TbRegister();
		re.setId(rid);
		re.setStatus(6);
		try {
			tbRegisterService2.updateRe(re);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/HMS/doSelectAcc";
	}
	
	//进入详情
	@RequestMapping("/goAccLook")
	public String goAccLook( @RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="3") Integer pageSize,Model model,Integer rid) {
		
		try {
			PageInfo<TbCostItem> pageInfo = tbBeHospitalizedService.CosLook(rid, pageNo, pageSize);
			model.addAttribute("list", pageInfo);
			model.addAttribute("rid", rid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "hospital/account-look";
	}
	
	//列表
	@RequestMapping("/doSelectAcc")
	public String doSelectAcc(@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="3") Integer pageSize,TbRegister Re,Model model) {

		System.out.println("---");
		System.out.println(Re.getId());
		System.out.println(Re.getName());
		try {
			PageInfo<TbRegister> list = tbBeHospitalizedService.jsReList(Re, pageNo, pageSize);
			model.addAttribute("list", list);
			model.addAttribute("Re", Re);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "hospital/account";
		
	}
	
	
	
	@RequestMapping("/goAccount")
	public String goAccount() {
		
		
		return "redirect:/HMS/doSelectAcc";
	}
	
	
	
	
	
	
	// -------------------住院办理
	//修改 住院信息
	@RequestMapping("/doEditHos")
	public String doEditHos(TbBeHospitalized hos) {
		try {
			tbBeHospitalizedService.updateHos(hos);
			return "redirect:/HMS/doHosList";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/HMS/goEditHos?id="+hos.getId()+"&code=500";
		}
		
	}
	
	//进入修改界面
	@RequestMapping("/goEditHos")
	public String goEditHos(Integer id,Model model,Integer code) {
		
		if(code!=null) {
			model.addAttribute("msg", "修改失败");
		}
		
		try {
			TbRegister register = tbRegisterService2.findReById(id);			//挂号
			model.addAttribute("register", register);
			
			TbDoctors doctors = tbDoctorsService2.findDoctorById(register.getDoctorid()); 	//医生
			TbOpd opd = tbOpdService2.findOpdById(register.getOpdid());			//科室
			register.setDoctorName(doctors.getDoctorname());	//姓名
			register.setOpdname(opd.getName());					//科室
			
			
			TbBeHospitalized hospitalized = tbBeHospitalizedService.findHosByregister_id(id);		//住院
			if(hospitalized!=null) {
				model.addAttribute("hos", hospitalized);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "hospital/edit";
	}
	
	//缴纳押金
	@RequestMapping("/doUpdateMoney")
	public String doUpdateMoney(TbRegister reg,Model model,BigDecimal yMoeny) {
		
		try {
			yMoeny=yMoeny.add(reg.getCashPledge());
			reg.setCashPledge(yMoeny);;
			tbRegisterService2.updateRe(reg);
			return "redirect:/HMS/goUpdateMoney?id="+reg.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/HMS/goUpdateMoney?id="+reg.getId()+"&code=500";
		}
	}
	
	//进入缴纳押金
	@RequestMapping("/goUpdateMoney")
	public String goUpdateMoney(Integer id,Model model,Integer code) {
		
		if(code!=null) {
			model.addAttribute("msg", "添加失败");
		}
		
		try {
			TbRegister register = tbRegisterService2.findReById(id);
			model.addAttribute("register", register);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "hospital/add_many";
	}
	
	//进入详情界面
	@RequestMapping("/goLookHos")
	public String goLook(Integer id,Model model) {
		try {
			TbRegister register = tbRegisterService2.findReById(id); 	//挂号
			
			TbDoctors doctors = tbDoctorsService2.findDoctorById(register.getDoctorid()); 	//医生
			TbOpd opd = tbOpdService2.findOpdById(register.getOpdid());			//科室
			register.setDoctorName(doctors.getDoctorname());	//姓名
			register.setOpdname(opd.getName());					//科室
			
			model.addAttribute("register", register);
			return "hospital/look";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "查询失败");
			return "redirect:/HMS/doHosList";
		}
	}
	
	//条件查询
	@RequestMapping("/doHosList")
	public String doHosList(@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="3") Integer pageSize,TbRegisterSelect Res,Model model) {
		
		try {
			PageInfo<TbRegister> list = tbBeHospitalizedService.findListHos(Res, pageNo, pageSize);
			
			model.addAttribute("Res", Res);
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "hospital/index";
	}
	
	//新增报销单
	@RequestMapping("/doAddHos")
	public String doAddHos(TbBeHospitalized hos,TbRegister re,Model model) {
		try {
			hos.setId(null);
			hos.setRegisterId(re.getId());
			tbBeHospitalizedService.AddHos(hos);
			re.setStatus(3);
			tbRegisterService2.updateRe(re);
			
			return "redirect:/HMS/gohospitalIndex";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "新增失败");
			return "hospital/add";
		}
		
	}
	
	//进入新增住院办理
	@RequestMapping("/goAddHospital")
	public String goAddHospital() {
		
		return "hospital/add";
	}
	
	//进入住院  首页
	@RequestMapping("/gohospitalIndex")
	public String gohospitalIndex() {
		return "redirect:/HMS/doHosList";
	}
	
	
}

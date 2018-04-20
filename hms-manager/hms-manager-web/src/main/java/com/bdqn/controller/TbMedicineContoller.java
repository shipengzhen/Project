package com.bdqn.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bdqn.pojo.TbMedicine;
import com.bdqn.service.TbMedicineService;
import com.github.pagehelper.PageInfo;

//药品管理
@Controller
@RequestMapping("/HMS")
public class TbMedicineContoller {
	
	@Autowired
	private TbMedicineService tbMedicineService;	//药品管理
	
	//修改
	@RequestMapping("/doMeEdit")
	public String doMeEdit(HttpSession session,HttpServletRequest request, MultipartFile attach,TbMedicine me) {
		System.out.println("11");
		
		String idPicPath = null;
		// 判断文件是否为空
		if (!attach.isEmpty()) {
			System.out.println("12");
			//上传地址
			String path = request.getSession().getServletContext().getRealPath("statics/uploadfiles/");
			// 原文件名
			 String oldFileName = attach.getOriginalFilename();
			// 原文件后缀
			String prefix = FilenameUtils.getExtension("oldFileName--》"+oldFileName);			
			int filesize = 500000;
			if (attach.getSize() > filesize) {			// 上传大小不得超过 500k
				
				return "redirect:/HMS/goMeEdit?error=上传大小不得超过 500k&code=500";
			} else if (prefix.equalsIgnoreCase("jpg")
					|| prefix.equalsIgnoreCase("png")
					|| prefix.equalsIgnoreCase("jpeg")
					|| prefix.equalsIgnoreCase("pneg")) {// 上传图片格式不正确
				//拼接名字					//时间的毫秒数
				String fileName = System.currentTimeMillis()+ "_Personal.jpg";
				
				File targetFile = new File(path, fileName);	//根据 路径 和 名字 构建一个File
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				// 保存
				try {
					attach.transferTo(targetFile);		//transferTo() 方法将文件保存在服务器上
				} catch (Exception e) {
					e.printStackTrace();

					return "redirect:/HMS/goMeEdit?error=上传失败&code=500";
				}
				//路径 + 名字
				idPicPath = path + File.separator + fileName;	
						
				me.setImg("/statics/uploadfiles/"+fileName);
			} else {
				return "redirect:/HMS/goMeEdit?error=上传图片格式不正确&code=500";			
			}

		}
		System.out.println("13");
		try {
			tbMedicineService.UpdayeMe(me);
			
			return "redirect:/HMS/MeList";
			} catch (Exception e) {
			e.printStackTrace();
		
			return "redirect:/HMS/goMeEdit?code=500";
		}
		
		
	}
	
	//进入修改
	@RequestMapping("/goMeEdit")
	public String goMeEdit(String id,Model model,Integer code,String error) {
		
		System.out.println(error);
		if(code!=null) {
			model.addAttribute("msg", "修改失败");
		}
		if(error!=null) {
			model.addAttribute("error",error);
		}
		try {
			TbMedicine medicine = tbMedicineService.findMeById(id);
			model.addAttribute("medicine",medicine);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "medicine/Edit";
	}
	
	//进入 查看
	@RequestMapping("/goLookMe")
	public String goLookMe(String id,Model model) {
		try {
			TbMedicine medicine = tbMedicineService.findMeById(id);
			model.addAttribute("me", medicine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "medicine/look";
	}
	
	//修改库存
	@RequestMapping("/UpdateStock")
	public String UpdateStock(TbMedicine me,Integer Ystock) {
		try {
			if(Ystock!=null) {
				me.setStatus(me.getStatus()+Ystock);
			}
			tbMedicineService.UpdayeMe(me);
			return "redirect:/HMS/MeList";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/HMS/goAddmedicine?code=500";
		}
	}
	
	//进入添加库存
	@RequestMapping("/goAddmedicine")
	public String goAddmedicine(String id,Model model,Integer code) {
		if(code!=null) {
			model.addAttribute("msg", "添加失败");
		}
		
		try {
			TbMedicine medicine = tbMedicineService.findMeById(id);
			model.addAttribute("medicine", medicine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "medicine/add_medicine";
	}
	
	//查询分页
	@RequestMapping("/MeList")
	public String MeList(@RequestParam(required=true,defaultValue="1") Integer pageNo,
			@RequestParam(required=false,defaultValue="3") Integer pageSize,TbMedicine me,Model model) {
		
		try {
			PageInfo<TbMedicine> info = tbMedicineService.findMeList(pageNo, pageSize, me);
			model.addAttribute("list", info);
			model.addAttribute("me", me);
			return "medicine/index";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "查询失败");
		}
		return "medicine/index";
	}
	
	//新增药品 文件上传
	@RequestMapping("/doAddMe")
	public String doAddMe(HttpSession session,HttpServletRequest request, MultipartFile attach,TbMedicine me) {
		
		
		
		String idPicPath = null;
		// 判断文件是否为空
		if (!attach.isEmpty()) {
			//上传地址
			String path = request.getSession().getServletContext().getRealPath("statics/uploadfiles/");
			// 原文件名
			 String oldFileName = attach.getOriginalFilename();
			// 原文件后缀
			String prefix = FilenameUtils.getExtension("oldFileName--》"+oldFileName);			
			int filesize = 500000;
			if (attach.getSize() > filesize) {			// 上传大小不得超过 500k
				request.setAttribute("uploadFileError", " * 上传大小不得超过 500k");
				return "medicine/add";
			} else if (prefix.equalsIgnoreCase("jpg")
					|| prefix.equalsIgnoreCase("png")
					|| prefix.equalsIgnoreCase("jpeg")
					|| prefix.equalsIgnoreCase("pneg")) {// 上传图片格式不正确
				//拼接名字					//时间的毫秒数
				String fileName = System.currentTimeMillis()+ "_Personal.jpg";
				
				File targetFile = new File(path, fileName);	//根据 路径 和 名字 构建一个File
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				// 保存
				try {
					attach.transferTo(targetFile);		//transferTo() 方法将文件保存在服务器上
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("uploadFileError", " * 上传失败！");
					return "medicine/add";
				}
				//路径 + 名字
				idPicPath = path + File.separator + fileName;	
						
				me.setImg("/statics/uploadfiles/"+fileName);
			} else {
				request.setAttribute("uploadFileError", " * 上传图片格式不正确");
				return "medicine/add";
			}
			
		
			me.setStatus(1);
			try {
				tbMedicineService.addMe(me);
				return "redirect:/HMS/goMeIndex";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "新增失败");
				return "medicine/add";
			}
		
		}
		
		request.setAttribute("msg", "新增失败");
		return "medicine/add";
	}
	
	//进入新增药品管理
	@RequestMapping("/goAddMe")
	public String goAddMe() {
		
		return "medicine/add";
	}
	
	//进入首页
	@RequestMapping("/goMeIndex")
	public String goMedicineIndex() {
		
		return "redirect:/HMS/MeList";
	}
}

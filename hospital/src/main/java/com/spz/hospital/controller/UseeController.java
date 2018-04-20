package com.spz.hospital.controller;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spz.hospital.pojo.Usee;
import com.spz.hospital.service.IUseeService;

@RequestMapping("/user/")
public class UseeController {

	private IUseeService useeService;

	public IUseeService getUseeService() {
		return useeService;
	}

	public void setUseeService(IUseeService useeService) {
		this.useeService = useeService;
	}

	// 跳转添加用户页面
	@RequestMapping("addUser")
	public String addUser() {
		return "User/addUser";
	}

	// 跳转修改用户页面
	@RequestMapping("editUser")
	public String editUser() {
		return "User/editUser";
	}

	// 跳转用户管理页面
	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("usees",useeService.getUsees());
		return "User/index";
	}

	// 跳转密码管理页面
	@RequestMapping("password")
	public String password() {
		return "User/password";
	}

	// 修改密码
	@RequestMapping("modifypassword")
	public String modifyPassword(HttpSession session, Model model, String password, String newPassword,
			String againNewPassword) {
		Usee usee = (Usee) session.getAttribute("usee");
		Integer uid = usee.getUid();
		if (newPassword.equals(againNewPassword)) {
			if (useeService.modifyUsee(uid, password, newPassword)) {
				// return "redirect:/login";
				return "User/index";
			}
		} else {
			model.addAttribute("error", "俩次密码不一样");
		}
		return "User/password";
	}
}

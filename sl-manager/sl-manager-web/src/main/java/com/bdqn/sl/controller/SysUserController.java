package com.bdqn.sl.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.bdqn.common.FtpUtil;
import com.bdqn.common.Menu;
import com.bdqn.sl.pojo.SysDictionary;
import com.bdqn.sl.pojo.SysRole;
import com.bdqn.sl.pojo.SysRoletype;
import com.bdqn.sl.pojo.SysUser;
import com.bdqn.sl.service.IPictureService;
import com.bdqn.sl.service.ISysAuthorityService;
import com.bdqn.sl.service.ISysDictionaryService2;
import com.bdqn.sl.service.ISysRoleService2;
import com.bdqn.sl.service.ISysRoletypeService;
import com.bdqn.sl.service.ISysUserService;
import com.github.pagehelper.PageInfo;

/**
 * 用户管理
 * @author lizhen
 */
@Controller
@RequestMapping("/admin")
public class SysUserController {
	
	@Autowired
	private ISysDictionaryService2 sysDictionaryService;		//字典
	
	@Autowired
	private ISysUserService sysUserService;			//用户
	
	@Autowired
	private ISysRoleService2 sysRoleService;			//角色
	
	@Autowired	
	private ISysRoletypeService sysRoletypeService;	//角色类型

	@Resource
	private ISysAuthorityService sysAuthorityService;	//权限
	
	@Autowired
	private IPictureService pictureService;		//图片 上传
	
	
	
	//ajax 判断 loginName 是否重复
	@RequestMapping("/doUserByName")
	@ResponseBody
	public String doUserByName(String loginCode,Integer id) {
		
		try {
			boolean b = sysUserService.findUserByLoginName(loginCode);
			if(b) {				//存在
				return "repeat";
			}
			return "only";		//ok
			
		} catch (Exception e) {
			e.printStackTrace();

			return "failed";	//异常
		}
		
	}
	

	
	//---------管理员
	//删除 用户
	@RequestMapping("/delteUser")
	@ResponseBody
	public String deleteUser(@RequestParam(value="delId",required=false) String delId,
			  @RequestParam(value="delIdCardPicPath",required=false) String delIdCardPicPath,			  
			  @RequestParam(value="delBankPicPath",required=false) String delBankPicPath,			  
			  HttpServletRequest request,HttpSession session) {
		
			sysUserService.deleteUser(Integer.parseInt(delId)); 
				//删除
			
			this.deletePic(delBankPicPath, "0", request, session);
			this.deletePic(delIdCardPicPath, "0", request, session);
		
		
		return "success";
	}
	
	//修改
	@RequestMapping(value="/UpdateUser",method=RequestMethod.POST)
	public String UpdateUser(SysUser user) {
		
		try {
			sysUserService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:userList";
	}

	
	//查看
	@RequestMapping(value="/UserById",produces= {"text/html;charset=UTF-8","application/json"},method=RequestMethod.POST)
	@ResponseBody
	public String UserById(Integer id) {	//associatorId
		System.out.println("进入查看---");
		
		try {
			SysUser user = sysUserService.findUserbyId(id);
			
			SysRole role = sysRoleService.findRoleByID(user.getRoleid());	//角色
			SysRoletype roletype = sysRoletypeService.findRoleTypeById(user.getAssociatorid());	//会员类型
			SysUser user2 = sysUserService.findUserbyId(user.getReferee());	//创建人
			SysDictionary dictionary = sysDictionaryService.findDiByID(user.getCardtypeid()); //证件类型
			
			
			user.setRoleName(role.getRolename());
			user.setHyType(roletype.getRoletypename());
			user.setRefereeName(user2.getUname());
			user.setCardnumberName(dictionary.getValuename());
			
			System.out.println("查看出---");
			return JSON.toJSONString(user);
			
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString("failed");
		}
	}
	
	//查询 分页
	@RequestMapping("/userList")
	public String UserList(
			@RequestParam(required=true,defaultValue="1") Integer pageNo,HttpSession session,
			@RequestParam(required=false,defaultValue="5") Integer pageSize,SysUser user,Model model) {
		
		
		try {
			
			SysUser u=(SysUser) session.getAttribute("User");	//当前用户用户
			user.setUserid(u.getUserid());  //当前
			
			PageInfo<SysUser> info = sysUserService.findUserList(pageNo, pageSize, user);  //分页集合
			model.addAttribute("info", info);
			
			List<SysDictionary> zjlist = sysDictionaryService.findDiByTypeCode("1");	 //证件类型
			model.addAttribute("zjlist", zjlist);	
			
			List<SysDictionary> backNameList = sysDictionaryService.findDiByTypeCode("bank_type");	 //银行类型
			model.addAttribute("backNameList", backNameList);	
			
			
			List<SysRole>  roleList = sysRoleService.findAllRole(); 				 	//角色集合
			model.addAttribute("rList", roleList);
			
			List<SysRoletype> RoleTypelist = sysRoletypeService.findAll();			//会员类型
			model.addAttribute("RoleTypelist", RoleTypelist);
			
			//权限  不同的角色
			List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
			model.addAttribute("mList", JSON.toJSON(menus));
			
			model.addAttribute("user1", user);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return "backend/userlist";
	}
	
	
	//新增
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser(HttpSession session,SysUser user) {
	
		SysUser user1=(SysUser) session.getAttribute("User");
		if(user1==null) {
			System.out.println("进入新增1");
			return "redirect:doLogin";
		}
		user.setLoginpwd("123456");
		user.setLoginpwd2("123456");
		user.setCreateuid(user.getUserid());    //创建人
		sysUserService.addUser(user);
		
		System.out.println("进入新增2");
		return "redirect:userList";
	}
	
	
	//删除图片
	@RequestMapping("/deletePic")
	@ResponseBody
	public String deletePic(@RequestParam(value="picpath",required=false) String picpath,
			 				@RequestParam(value="id",required=false) String id,
			 				HttpServletRequest request,HttpSession session){
		
		System.out.println("进入删除--------------------------------");
		System.out.println(picpath);	
		System.out.println(id);
		
		String result= "failed" ;
		if(picpath == null || picpath.equals("")){
			result = "error"; 
		}else {
			boolean bol=pictureService.delFile(picpath);		//删除图片
			if(bol) {
				if (id.equals("0")||id==null) {
					 return "success";
				 }
				SysUser user=new SysUser();
				user.setUserid(Integer.parseInt(id));
				if(picpath.indexOf("_IDcard") != -1) {
					user.setCardimg("");
				}else if(picpath.indexOf("__bank") != -1) {
					 user.setYhimg("");
				}
				try {
					sysUserService.updateUser(user);
					return "success";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				return "error";
			}
		}
	
		return "error";
	}
	
	//文件 上传 身份证 银行卡
	@RequestMapping(value="/fileUpdate",produces ={"text/html;charset=UTF-8"})
	@ResponseBody
	public String fileUpdate(
			@RequestParam(value = "a_fileInputID", required = false) MultipartFile cardFile, 
            @RequestParam(value = "a_fileInputBank", required = false) MultipartFile bankFile, 
            @RequestParam(value = "m_fileInputID", required = false) MultipartFile mCardFile, 
            @RequestParam(value = "m_fileInputBank", required = false) MultipartFile mBankFile, 
            @RequestParam(value = "loginCode", required = false) String loginCode, 
			HttpServletRequest request,HttpSession session) {
		
			//新增的  身份证
			if (cardFile!= null) {
				
				Map<String, String> map=pictureService.updatePicture(cardFile,"idcard");
				
				if(map.get("code").equals("2")) {
					 return map.get("url");
				}else {
					return "2";
				}
			}
			
			//修改 新增图片 
			if (mCardFile!= null) {
				Map<String, String> map=pictureService.updatePicture(mCardFile,"idcard");
				
				if(map.get("code").equals("2")) {
					 return map.get("url");
				}else {
					return "2";
				}
			}
			
			
			//新增的  银行卡
			if (bankFile!= null) {
				Map<String, String> map=pictureService.updatePicture(bankFile,"bank");
				
				if(map.get("code").equals("2")) {
					 return map.get("url");
				}else {
					return "2";
				}	
			}
			//修改上 银行卡
			if (mBankFile!= null) {
				Map<String, String> map=pictureService.updatePicture(mBankFile,"bank");
				
				if(map.get("code").equals("2")) {
					 return map.get("url");
				}else {
					return "2";
				}
			}
			
			return null;
		
	}
	
	//进入用户列表
	@RequestMapping("/goUserList")
	public String goUserList(Model model) {

		return "redirect:/admin/userList";
	}
	
	//根据角色 id 查询角色类型
	@RequestMapping("/findRoleType")
	@ResponseBody
	public String findRoleType(Integer roleId) {
		
		System.out.println(roleId);
		
		try {
			List<SysRoletype> list = sysRoletypeService.findRtypeByroleid(roleId);
			
			return JSON.toJSONString(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}

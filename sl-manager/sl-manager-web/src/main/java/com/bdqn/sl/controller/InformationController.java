package com.bdqn.sl.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.bdqn.common.FtpUtil;
import com.bdqn.common.Menu;
import com.bdqn.sl.pojo.Information;
import com.bdqn.sl.pojo.SysDictionary;
import com.bdqn.sl.pojo.SysUser;
import com.bdqn.sl.service.IInformationService;
import com.bdqn.sl.service.IPictureService;
import com.bdqn.sl.service.ISysAuthorityService;
import com.bdqn.sl.service.ISysDictionaryService2;
import com.bdqn.sl.service.ISysRoleAuthorityKeyService;
import com.github.pagehelper.PageInfo;

/**
 * 资讯
 * 
 * @author lizhen
 */
@Controller
@RequestMapping("/admin")
public class InformationController {

	@Resource
	private ISysAuthorityService sysAuthorityService; // 权限

	@Autowired
	private ISysDictionaryService2 sysDictionaryService; // 字典

	@Autowired
	private IPictureService pictureService; // 图片 上传

	@Autowired
	private IInformationService informationService; // 资讯

	@Autowired
	private ISysRoleAuthorityKeyService sysRoleAuthorityKeyService;	//权限 -lz

	//下载
	@RequestMapping("/dowload")
	@ResponseBody
	public String dowload(Integer id) {
		
		Information information = informationService.findInfoById(id);
		
		if( pictureService.downloadFile(information.getZfile())) {
			return "success";
		}
		return "error";
	}
	
	
	//判断重名
	@RequestMapping("/findInfoByTitle")
	@ResponseBody
	public String findInfoByTitle(String title) {
		
		try {
			boolean b = informationService.findInfoByTitle(title);
			if(b) {
				return "success";
			}
			return "no";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	
	
	//修改状态
	@RequestMapping("/updateInfoStatus")
	@ResponseBody
	public String updateInfoStatus(Integer id,Integer status) {
		

		
		if(id==null||status==null) {	//没有数据
			return "nodata";
		}
		
		try {
			
			Information information = new Information();
			information.setZid(id);
			information.setStatus(status);
			
			informationService.updateInfo(information);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}
	
	//资讯 详情 页面
	@RequestMapping("/goInfoXQ")
	public String goInfoXQ(Integer id,Model model,HttpSession session) {
		
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
		model.addAttribute("mList", JSON.toJSON(menus));
		
		Information information = informationService.findInfoById(id);
		model.addAttribute("information", information);
		
		//new AutoComm().getAutoList(model, session);
		return "informanage/portalinfodetail";
	}
	
	
	//删除 资讯
	@RequestMapping("/delInfo")
	@ResponseBody
	public String delInfo(Integer id) {
		System.out.println("--------------进入删除");
		System.out.println(id);
		
		
		if(id==null) {
			return "nodata";
		}
		
		Information infoById = informationService.findInfoById(id);
		
		
		System.out.println(infoById.getFilename()+"-- -- - - -- ");
		
		if(infoById.getFilename()!=null&&infoById.getFilename().length()>0) {
			System.out.println("进入 - -有 file");
			String msg = this.delFile(infoById.getZfile(),infoById.getZid().toString());
			
			if(msg.equals("success")) {
				try {
					informationService.delInfo(id);
					return "success";
				} catch (Exception e) {
					e.printStackTrace();
					return "failed";
				}
			}else {
				return "failed";
			}
		}else {
			System.out.println("进入 - -没有 file");
			try {
				informationService.delInfo(id);
				System.out.println("完");
				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				return "failed";
			}
		}
		

	}
	
	//修改保存
	@RequestMapping("/updateInfo")
	public String updateInfo(Information info,HttpSession session) {
		
		try {
			SysUser user=(SysUser) session.getAttribute("User");
			info.setUpdateuid(user.getUserid()); //修改 人名 id
			informationService.updateInfo(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:infoList";
	}
	
	// 删除文件
	@RequestMapping("/delFile")
	@ResponseBody
	public String delFile(@RequestParam(value = "filePath", required = false) String filePath,
			@RequestParam(value = "id", required = false) String id) {

		System.out.println("进入删除文件--------------------------------");
		System.out.println(filePath);
		System.out.println(id);

		if (filePath == null || filePath.equals("")) {
			return  "nodata";
		} else {
			boolean bol = pictureService.delFile(filePath); // 删除图片
			if (bol) {
				if(id!=null) {
					Information information = new Information();
					information.setZid(Integer.parseInt(id)); 	//id
					information.setZfile("");
					information.setZfilesize("");
					information.setFilename("");
					try {
						informationService.updateInfo(information);
						return "success";
					} catch (Exception e) {
						e.printStackTrace();
						return "failed";
					}
				}else {
					return "success";
				}
				
			} else {
				return "failed";
			}
		}

	}

	// 查询
	@RequestMapping(value = "/findInfo", produces = { "text/html;charset=UTF-8", "application/json" })
	@ResponseBody
	public String findInfo(Integer id) {

		try {
			Information information = informationService.findInfoById(id);
			if (information == null) {
				return "nodata";
			}
			return JSON.toJSONString(information);

		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}

	// 查询分页
	@RequestMapping("/infoList")
	public String infoList(@RequestParam(required = true, defaultValue = "1") Integer pageNo, HttpSession session,
			@RequestParam(required = false, defaultValue = "5") Integer pageSize, Information info, Model model) {

		try {
			PageInfo<Information> pageinfo = informationService.FindinfoList(info, pageNo, pageSize); // 分页数据
			model.addAttribute("info", pageinfo);

			List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
			model.addAttribute("mList", JSON.toJSON(menus));

			// 字典
			List<SysDictionary> dilist = sysDictionaryService.findDiByTypeCode("2"); // 字典
			model.addAttribute("dilist", dilist);
			
			SysUser user=(SysUser) session.getAttribute("User");
			//1 :表示 有此权限 
			model.addAttribute("insertInfo", sysRoleAuthorityKeyService.findRAbyKey(user.getRoleid(),40));	//新增
			model.addAttribute("updateInfo", sysRoleAuthorityKeyService.findRAbyKey(user.getRoleid(),41));	//修改
			model.addAttribute("deleteInfo", sysRoleAuthorityKeyService.findRAbyKey(user.getRoleid(),42));  //删除
			model.addAttribute("selectInfo", sysRoleAuthorityKeyService.findRAbyKey(user.getRoleid(),43));	//查看

		} catch (Exception e) {
			model.addAttribute("msg", "查询失败");
			e.printStackTrace();
		}
		return "informanage/information";
	}

	// 新增
	@RequestMapping("/addInfo")
	public String addInfo(Information info, HttpSession session) {
		SysUser user = (SysUser) session.getAttribute("User");

		try {
			info.setCreateuid(user.getUserid()); // 创建人
			info.setUpdateuid(user.getUserid()); // 修改人
			informationService.addInfo(info);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:infoList";
	}

	// 文件长传 修改
	@RequestMapping(value="/addFile", produces= {"text/html;charset=UTF-8","application/json"})
	@ResponseBody
	public String addFile(
			@RequestParam(value = "uploadInformationFile", required = false) MultipartFile uploadInformationFile,
			@RequestParam(value = "uploadInformationFile", required = false) MultipartFile uploadInformationFileM,
			HttpServletRequest request, HttpSession session) {

		// 长传文件
		if (uploadInformationFile != null) {
			Map<String, String> map = pictureService.updateFile(uploadInformationFile);

			if (map.get("code").equals("2")) {
				// return map.get("url");
				return JSON.toJSONString(map);
			} else if (map.get("code").equals("5")) { // 文件过大
				return "1";
			}

		}
		if(uploadInformationFileM!=null) {
			Map<String, String> map = pictureService.updateFile(uploadInformationFileM);

			if (map.get("code").equals("2")) {
				// return map.get("url");
				return JSON.toJSONString(map);
			} else if (map.get("code").equals("5")) { // 文件过大
				return "1";
			}
		}

		return null;
	}

	// 进入资讯首页
	@RequestMapping("/goInformation")
	public String goInformation(Model model) {

		return "redirect:infoList";
	}

}

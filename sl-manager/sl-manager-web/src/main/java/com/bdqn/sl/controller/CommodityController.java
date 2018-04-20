/**
 * 
 */
package com.bdqn.sl.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bdqn.common.Menu;
import com.bdqn.sl.pojo.Commodity;
import com.bdqn.sl.service.ICommodityService;
import com.bdqn.sl.service.ISetMealService;
import com.bdqn.sl.service.ISysAuthorityService;
import com.bdqn.sl.service.ISysDictionaryService;
import com.github.pagehelper.PageInfo;

/**
 * @描述 sl-manager-web
 * @作者 施鹏振
 * @创建日期 2018年3月19日
 * @创建时间 下午4:20:37
 */
@Controller
@RequestMapping("admin/")
public class CommodityController {

	@Resource
	private ISysAuthorityService sysAuthorityService;	//资源

	@Resource
	private ICommodityService commodityService;	//商品

	@Resource
	private ISysDictionaryService sysDictionaryService;	//字典
	
	@Resource
	private ISetMealService setMealService;				//套餐表
	
	//权限
	private void getAutoList(Model model,HttpSession session) {
		//权限
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
		model.addAttribute("mList", JSON.toJSON(menus));
	}
	
	
	// 商品管理
	@RequestMapping("commodityManager")
	public String commodityManager(Model model, @RequestParam(required = false, defaultValue = "") String commoDityname,
			@RequestParam(required = false, defaultValue = "0") Integer status,
			@RequestParam(required = true, defaultValue = "1") Integer pageNo,HttpSession session) {

		// 导航栏
		this.getAutoList(model, session);
		// 商品状态
		model.addAttribute("csList", commodityService.findCommodityStatus());
		// 商品分页
		PageInfo<Commodity> pageInfo = commodityService.findCommodityListPaging(commoDityname, status, null, null, 5,
				pageNo);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("commoDityname", commoDityname);
		model.addAttribute("status", status);
		return "backend/goodsinfolist";
	}

	// 商品列表
	@RequestMapping("commodityList")
	public String commodityList(Model model, @RequestParam(required = false, defaultValue = "") String commoDityname,
			@RequestParam(required = true, defaultValue = "1") Integer pageNo) {

		// 商品状态
		model.addAttribute("csList", commodityService.findCommodityStatus());
		// 商品分页
		PageInfo<Commodity> pageInfo = commodityService.findCommodityListPaging(commoDityname, 1, null, null, 4,
				pageNo);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("commoDityname", commoDityname);
		return "backend/goodslist";
	}

	// 新增商品
	@RequestMapping("addCommodity")
	public String addCommodity(Commodity commodity,HttpSession session) {
		try {
			commodity.setCreateuid(Integer.parseInt(session.getAttribute("Userid").toString()));// 创建人id
			commodityService.addCommodity(commodity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:commodityManager";
	}

	// 修改商品状态  - -
	@RequestMapping("modifyCommodityStates")
	@ResponseBody
	public String modifyStates(Commodity commodity) {		//1 上架       2下架
		System.out.println("进入修改商品状态！！！！");
		
		//findSmBycId
		System.out.println(commodity.getCommodityid());
		System.out.println(commodity.getStatus());
		
		boolean b = setMealService.findSmBycId(commodity.getCommodityid());
		
		if(b) {
			if (commodity.getCommodityid() == null) {
				return "nodata";
			}
			if (commodity.getStatus() == null) {
				return "nodata";
			}
			if (commodityService.modifyCommodityStates(commodity)) {
				return "success";
			}
			return "failed";
		}else {
			return "noyy";			//商品被 套餐中引用 不能下架
		}
	}

	// 查看商品信息
	@RequestMapping(value = "commodityInfo", produces = { "text/html;charset=UTF-8", "application/json" })
	@ResponseBody
	public String commodityInfo(Integer commodityId) {
		if (commodityId == null) {
			return "nodata";
		}
		Commodity commodity = commodityService.findCommodity(commodityId);
		if (commodity != null) {
			return JSON.toJSONString(commodity);
		}
		return "failed";
	}

	// 修改商品信息
	@RequestMapping(value = "modifyCommodity", produces = { "text/html;charset=UTF-8", "application/json" })
	public String modifyCommodity(Commodity commodity,HttpSession session) {
		try {
			
			commodity.setUpdateuid(Integer.parseInt(session.getAttribute("Userid").toString()));// 修改人id
			commodityService.modifyCommodity(commodity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:commodityManager";
	}

	// 删除商品
	@RequestMapping("delCommodity")
	@ResponseBody
	public String delCommodity(Integer commodityId) {
		// System.out.println(commodityId);
		if (commodityService.findSmCountBycId(commodityId) > 0) {
			return "isused";
		}
		if (commodityService.delCommodity(commodityId)) {
			return "success";
		}
		return "failed";
	}

	//新增时商品名称唯一验证
	@RequestMapping("acommodityNameExists")
	@ResponseBody
	public String acommodityNameExists(String commodityName) {
		if (commodityService.acommodityNameExists(commodityName)) {
			return "repeat";
		} else {
			return "only";
		}
	}

	//修改时商品名称唯一验证
	@RequestMapping("mcommodityNameExists")
	@ResponseBody
	public String mcommodityNameExists(String commodityName,String mm_goodsName) {
		if (commodityService.mcommodityNameExists(commodityName, mm_goodsName)) {
			return "repeat";
		} else {
			return "only";
		}
	}
}

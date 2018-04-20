/**
 * 
 */
package com.bdqn.sl.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.bdqn.common.Menu;
import com.bdqn.sl.pojo.Setmeal;
import com.bdqn.sl.service.ICommodityService;
import com.bdqn.sl.service.ISetMealService;
import com.bdqn.sl.service.ISysAuthorityService;
import com.github.pagehelper.PageInfo;

/**
 * @描述 sl-manager-web
 * @作者 施鹏振
 * @创建日期 2018年3月21日
 * @创建时间 上午8:52:41
 */
@Controller
@RequestMapping("admin/")
public class SetMealController {

	@Resource
	private ISysAuthorityService sysAuthorityService;		//权限

	@Resource
	private ISetMealService setMealService;				//套餐表

	@Resource
	private ICommodityService commodityService;	  //商品表

	// 跳转添加套餐页面
	@RequestMapping("addSetMealManager")
	public String addSetMealManager(Model model) {
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(1);
		model.addAttribute("mList", JSON.toJSON(menus));
		// 商品套餐类型
		model.addAttribute("setMealTypes", setMealService.findSetMealType());
		return "backend/addgoodspack";
	}

	// 添加套餐
	@RequestMapping("addSetMeal")
	public String addSetMeal(Model model, Setmeal setmeal, String goodsJson) {
		setmeal.setCreateuid(1);// 创建人Id
		// System.out.println(setmeal.getSmname());
		// System.out.println(setmeal.getSmtypeid());
		// System.out.println(setmeal.getSmprice());
		// System.out.println(setmeal.getSmstatic());
		// System.out.println(setmeal.getSmnumber());
		// System.out.println("哈哈"+setmeal.getSmdoc());
		// System.out.println("heheh"+goodsJson);
		if (setMealService.addSetMeal(setmeal, goodsJson)) {
			return "redirect:setMealManager";
		}
		return "backend/addgoodspack";
	}

	// 查询商品套餐列表(分页)
	@RequestMapping("setMealManager")
	public String setMealManager(Model model, @RequestParam(required = false, defaultValue = "") String smName,
			@RequestParam(required = false, defaultValue = "0") Integer smType,
			@RequestParam(required = false, defaultValue = "0") Integer smStatus,
			@RequestParam(required = true, defaultValue = "1") Integer pageNo) {
		// 导航栏
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(1);
		model.addAttribute("mList", JSON.toJSON(menus));
		// 商品状态
		model.addAttribute("csList", commodityService.findCommodityStatus());
		// 商品类型
		model.addAttribute("setMealTypes", setMealService.findSetMealType());
		PageInfo<Setmeal> pageInfo = setMealService.findSetMealListPaging(smName, smType, smStatus, null, null, pageNo,
				5);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("smName", smName);
		model.addAttribute("smType", smType);
		model.addAttribute("smStatus", smStatus);
		return "backend/goodspacklist";
	}

	// 修改商品套餐状态
	@RequestMapping("modifySetMealStatus")
	@ResponseBody
	public String modifySetMealStatus(Setmeal setmeal,HttpSession session) {
		
		setmeal.setUpdateuid(Integer.parseInt(session.getAttribute("Userid").toString()));// 修改人id
		if (setmeal.getSmid() == null) {
			return "nodata";
		}
		if (setmeal.getSmstatic() == null) {
			return "nodata";
		}
		if (setMealService.modifySetMealStatus(setmeal)) {
			return "success";
		}
		return "failed";
	}

	// 查询商品套餐详情信息
	@RequestMapping("setMealInfo")
	public String setMealInfo(Model model, Integer smId) {
		// System.out.println(smId);
		// 导航栏
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(1);
		model.addAttribute("mList", JSON.toJSON(menus));
		model.addAttribute("setmeal", setMealService.findSetMealBySmId(smId));
		model.addAttribute("commodityList", setMealService.findCommodityListBySmId(smId));
		return "backend/viewgoodspack";
	}

	// 跳转修改商品套餐页面
	@RequestMapping("modifysetMealManager")
	public String modifysetMealManager(Model model, Integer smId) {
		// System.out.println(smId);
		// 导航栏
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(1);
		model.addAttribute("mList", JSON.toJSON(menus));
		model.addAttribute("setmeal", setMealService.findSetMealBySmId(smId));
		model.addAttribute("commodityList", setMealService.findCommodityListBySmId(smId));
		// 商品套餐类型
		model.addAttribute("setMealTypes", setMealService.findSetMealType());
		return "backend/modifygoodspack";
	}

	// 修改商品套餐
	@RequestMapping("modifySetMeal")
	public String modifySetMeal(Model model, Setmeal setmeal, String goodsJson,HttpSession session) {
		
		
		 System.out.println(setmeal.getSmname());
		 System.out.println(setmeal.getSmtypeid());
		 System.out.println(setmeal.getSmprice());
		 System.out.println(setmeal.getSmstatic());
		 System.out.println(setmeal.getSmnumber());
		 System.out.println("哈哈" + setmeal.getSmdoc());
		 System.out.println("heheh" + goodsJson);
		 
		 setmeal.setUpdateuid(Integer.parseInt(session.getAttribute("Userid").toString()));// 修改人id
		if (setMealService.modifySetMeal(setmeal, goodsJson)) {
			return "redirect:setMealManager";
		}
		return "redirect:modifysetMealManager?smId=" + setmeal.getSmid();
	}

	// 删除套餐
	@RequestMapping("delSetMeal")
	@ResponseBody
	public String delSetMeal(Integer smId) {
		// System.out.println(smId);
		if (setMealService.delSetMeal(smId)) {
			return "success";
		}
		return null;
	}

	// 新增时套餐名称唯一验证
	@RequestMapping("asetMealNameNameExists")
	@ResponseBody
	public String asetMealNameNameExists(String setMealName) {
		if (setMealService.asetMealNameNameExists(setMealName)) {
			return "repeat";
		} else {
			return "only";
		}
	}

	// 修改时套餐名称唯一验证
	@RequestMapping("msetMealNameNameExists")
	@ResponseBody
	public String msetMealNameNameExists(String setMealName,String mm_goodsPackName) {
		if (setMealService.msetMealNameNameExists(setMealName, mm_goodsPackName)) {
			return "repeat";
		} else {
			return "only";
		}
	}
}

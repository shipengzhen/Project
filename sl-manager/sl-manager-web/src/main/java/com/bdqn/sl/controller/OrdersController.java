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
import com.bdqn.sl.pojo.Orders;
import com.bdqn.sl.pojo.OrdersCS;
import com.bdqn.sl.pojo.Setmeal;
import com.bdqn.sl.pojo.SysUser;
import com.bdqn.sl.service.ICommodityService;
import com.bdqn.sl.service.IOrdersService;
import com.bdqn.sl.service.ISetMealService;
import com.bdqn.sl.service.ISysAuthorityService;
import com.bdqn.sl.service.ISysDictionaryService;
import com.bdqn.sl.service.ISysUserService;
import com.github.pagehelper.PageInfo;

/**
 * @描述 sl-manager-web
 * @作者 施鹏振
 * @创建日期 2018年3月23日
 * @创建时间 下午3:07:52
 */
@Controller
@RequestMapping("user/")
public class OrdersController {

	@Resource
	private ISysAuthorityService sysAuthorityService;

	@Resource
	private ICommodityService commodityService;

	@Resource
	private ISysDictionaryService sysDictionaryService;

	@Resource
	private IOrdersService ordersService;

	@Resource
	private ISetMealService setMealService;

	@Resource
	private ISysUserService sysUserService;

	//权限
	private void getAutoList(Model model,HttpSession session) {
		//权限
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
		model.addAttribute("mList", JSON.toJSON(menus));
	}
	
	
	// 跳转购买商品页面
	@RequestMapping("shopingCommodity")
	public String shopingCommodity(Model model, @RequestParam(required = false, defaultValue = "") String commoDityname,
			@RequestParam(required = false, defaultValue = "0") Float price1,
			@RequestParam(required = false, defaultValue = "5000") Float price2,
			@RequestParam(required = true, defaultValue = "1") Integer pageNo,HttpSession session) {

		// 导航栏
		this.getAutoList(model, session);
		// 商品状态
		model.addAttribute("csList", commodityService.findCommodityStatus());
		// 商品分页
		PageInfo<Commodity> pageInfo =null;
		SysUser user=(SysUser) session.getAttribute("User");
		if (user.getRoleid()==1) {
			pageInfo=commodityService.findCommodityListPaging(commoDityname, null, price1, price2, 5,
					pageNo);
		}else {
			pageInfo=commodityService.findCommodityListPaging(commoDityname, 1, price1, price2, 5,
					pageNo);
		}
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("commoDityname", commoDityname);
		model.addAttribute("price1", price1);
		model.addAttribute("price2", price2);
		return "user/shopingCommodity";
	}

	// 加入购物车
	@RequestMapping("addShopingCard")
	@ResponseBody
	public String addShopingCard(OrdersCS ordersCS, Orders orders, HttpSession session) {
		// System.out.println(ordersCS.getOcsCsid());
		// System.out.println(ordersCS.getOcsCnum());
		// System.out.println(ordersCS.getCstype());
		// System.out.println(orders.getPrice());
		if (ordersCS.getOcsCsid() == null) {
			return "nodata";
		}
		if (ordersCS.getOcsCnum() == null) {
			return "nodata";
		}
		if (ordersCS.getCstype() == null) {
			return "nodata";
		}
		if (orders.getPrice() == null) {
			return "nodata";
		}
		orders.setPrice(ordersCS.getOcsCnum() * orders.getPrice());
		SysUser user = (SysUser) session.getAttribute("User");
		 orders.setCreateuid(user.getUserid());
		//orders.setCreateuid(1);
		if (ordersService.addShopingCard(ordersCS, orders)) {
			return "success";
		}
		return "failed";
	}

	// 立即购买
	@RequestMapping("addOrders")	
	@ResponseBody
	public String addOrders(OrdersCS ordersCS, Orders orders,
			@RequestParam(required = false, defaultValue = "10") Integer smtypeid,
			@RequestParam(required = false, defaultValue = "") String loginName, HttpSession session) {

		
		if (orders.getOrdertype() == null) {
			return "nodata";
		}
		if (orders.getStatus() == null) {
			return "nodata";
		}
		if (ordersCS.getOcsCsid() == null) {
			return "nodata";
		}
		if (ordersCS.getOcsCnum() == null) {
			return "nodata";
		}
		if (ordersCS.getCstype() == null) {
			return "nodata";
		}
		if (orders.getPrice() == null) {
			return "nodata";
		}
		orders.setPrice(ordersCS.getOcsCnum() * orders.getPrice());
		SysUser user = (SysUser) session.getAttribute("User");
		 orders.setCreateuid(user.getUserid());
		//orders.setCreateuid(1);
		if (ordersService.userMoneyExists(orders.getCreateuid(), orders.getPrice())) {
			return "no";
		}
		if (ordersService.addOrders(ordersCS, orders, smtypeid, loginName)) {
			return "success";
		}
		return "failed";
	}

	// 跳转购买套餐页面
	@RequestMapping("shopingSetMeal")
	public String setMealManager(Model model, @RequestParam(required = false, defaultValue = "") String smName,
			@RequestParam(required = false, defaultValue = "0") Integer smType,
			@RequestParam(required = false, defaultValue = "0") Float price1,
			@RequestParam(required = false, defaultValue = "90000") Float price2,
			@RequestParam(required = true, defaultValue = "1") Integer pageNo,HttpSession session) {
		// 导航栏
		this.getAutoList(model, session);
		// 商品类型
		model.addAttribute("setMealTypes", setMealService.findSetMealType());
		PageInfo<Setmeal> pageInfo = null;
		SysUser user=(SysUser) session.getAttribute("User");
		if(user.getRoleid()==1) {
			pageInfo = setMealService.findSetMealListPaging(smName, smType, null, price1, price2, pageNo,
					5);
		}else {
			pageInfo = setMealService.findSetMealListPaging(smName, smType, 1, price1, price2, pageNo,
					5);
		}
		
		
		System.out.println("-------------1");
		System.out.println(pageInfo.getList().size());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("smName", smName);
		model.addAttribute("smType", smType);
		model.addAttribute("price1", price1);
		model.addAttribute("price2", price2);
		return "user/shopingSetMeal";
	}

	// 订单列表
	@RequestMapping("ordersList")
	public String ordersList(Model model, HttpSession session,
			@RequestParam(required = false, defaultValue = "") Integer ordersId,
			@RequestParam(required = false, defaultValue = "") String loginName,
			@RequestParam(required = false, defaultValue = "0") Integer orderType,
			@RequestParam(required = true, defaultValue = "1") Integer pageNo) {


		System.out.println();
		
		// 导航栏
		this.getAutoList(model, session);
		
		SysUser user = (SysUser) session.getAttribute("User");
		model.addAttribute("pageInfo",
				ordersService.findOrdersListPaging(ordersId, loginName, orderType, user.getUserid(),5, pageNo));
		model.addAttribute("ordersId", ordersId);
		model.addAttribute("loginName", loginName);
		model.addAttribute("orderType", orderType);
		model.addAttribute("roleId", user.getRoleid());
		return "user/ordersList";
	}

	// 验证用户名是否存在  //
	@RequestMapping(value="userExists",produces= {"text/html;charset=UTF-8","application/json"})
	@ResponseBody
	public String userExists(String loginName) {
		if (loginName.equals("")) {
			return "nodata";
		}
		
		SysUser sysUser = ordersService.loginNameExistsByVIP(loginName);
		
		if (sysUser==null) {
			return "failed";
		}
		return JSON.toJSONString(sysUser);
	}

	// 删除订单
	@RequestMapping("delOrders")
	@ResponseBody
	public String delOrders(Integer ordersId) {
		if (ordersId==null) {
			return "nodata";
		}
		if (ordersService.delOrders(ordersId)) {
			return "success";
		}
		return null;
	}

	// 购物车
	@RequestMapping("shopingCard")
	public String shopingCard(Model model, HttpSession session,
			@RequestParam(required = true, defaultValue = "1") Integer pageNo) {
		// 导航栏
		this.getAutoList(model, session);

		SysUser user = (SysUser) session.getAttribute("User");
		model.addAttribute("order", ordersService.findShopingCardOrders(user.getUserid()));
		model.addAttribute("pageInfo", ordersService.findOrdersListPaging(user.getUserid(), 5, pageNo));
		return "user/shopingCard";
	}

	// 删除购物车中的商品
	@RequestMapping("delShopingCardcs")
	@ResponseBody
	public String delShopingCardcs(OrdersCS ordersCS) {
		if (ordersCS.getCstype()==null) {
			return "nodata";
		}
		if (ordersCS.getOcsCsid()==null) {
			return "nodata";
		}
		if (ordersCS.getOcsOid()==null) {
			return "nodata";
		}
		if (ordersService.delShopingCardcs(ordersCS)) {
			return "success";
		}
		return null;
	}
	
	// 结算
	@RequestMapping("settleAccounts")
	@ResponseBody
	public String settleAccounts(Integer oid,Float price,HttpSession session){
		if (oid==null) {
			return "nodata";
		}
		if (price==null) {
			return "nodata";
		}
		SysUser user = (SysUser) session.getAttribute("User");
		if (ordersService.settleAccounts(oid, price, user.getUserid())) {	//- -
			return "success";
		}
		return null;
	}
}

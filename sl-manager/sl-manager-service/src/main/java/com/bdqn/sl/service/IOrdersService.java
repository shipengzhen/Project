/**
 * 
 */
package com.bdqn.sl.service;

import com.bdqn.sl.pojo.Orders;
import com.bdqn.sl.pojo.OrdersCS;
import com.bdqn.sl.pojo.SysRole;
import com.bdqn.sl.pojo.SysUser;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @描述 sl-manager-service
 * @作者 施鹏振
 * @创建日期 2018年3月24日
 * @创建时间 上午9:48:44
 */
public interface IOrdersService {

	/**
	 * 加入购物车
	 * 
	 * @param ordersCS
	 * @param orders
	 * @return boolean
	 */
	public boolean addShopingCard(OrdersCS ordersCS, Orders orders);

	/**
	 * 立即购买
	 * 
	 * @param ordersCS
	 * @param orders
	 * @param smtypeid
	 * @param loginName
	 * @return boolean
	 */
	public boolean addOrders(OrdersCS ordersCS, Orders orders, Integer smtypeid, String loginName);

	/**
	 * 账户余额是否足够(不足返回true)
	 * 
	 * @param uId
	 * @param price
	 * @return boolean
	 */
	public boolean userMoneyExists(Integer uId, Float price);

	/**
	 * 判断会员中是否又该用户(不存在返回true) 改  ：返回对象
	 * 
	 * @param loginName
	 * @return boolean
	 */
	public SysUser loginNameExistsByVIP(String loginName);

	/**
	 * 查询订单分页
	 * 
	 * @param ordersId
	 * @param loginName
	 * @param orderType
	 * @param uId
	 * @param pageSize
	 * @param pageNo
	 * @return PageInfo<Orders>
	 */
	public PageInfo<Orders> findOrdersListPaging(Integer ordersId, String loginName, Integer orderType, Integer uId,
			Integer pageSize, Integer pageNo);

	/**
	 * 删除订单
	 * 
	 * @param ordersId
	 * @return boolean
	 */
	public boolean delOrders(Integer ordersId);

	/**
	 * 查询某用户购物车订单
	 * 
	 * @param uId
	 * @return Orders
	 */
	public Orders findShopingCardOrders(Integer uId);

	/**
	 * 查询某用户购物车商品
	 * 
	 * @param uId
	 * @param pageSize
	 * @param pageNo
	 * @return PageInfo<OrdersCS>
	 */
	public PageInfo<OrdersCS> findOrdersListPaging(Integer uId, Integer pageSize, Integer pageNo);

	/**
	 * 删除购物车中的商品
	 * 
	 * @param ordersCSKey
	 * @return boolean
	 */
	public boolean delShopingCardcs(OrdersCS ordersCS);

	/**
	 * 购物车结算
	 * 
	 * @param oid
	 * @param price
	 * @param uid
	 * @return boolean
	 */
	public boolean settleAccounts(Integer oid, Float price, Integer uid);
	
}

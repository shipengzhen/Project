/**
 * 
 */
package com.bdqn.sl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.bdqn.sl.mapper.CommodityMapper;
import com.bdqn.sl.mapper.OrdersCSMapper;
import com.bdqn.sl.mapper.OrdersMapper;
import com.bdqn.sl.mapper.SetmealMapper;
import com.bdqn.sl.mapper.SysRoleMapper;
import com.bdqn.sl.mapper.SysRoletypeMapper;
import com.bdqn.sl.mapper.SysUserMapper;
import com.bdqn.sl.pojo.Commodity;
import com.bdqn.sl.pojo.Orders;
import com.bdqn.sl.pojo.OrdersCS;
import com.bdqn.sl.pojo.OrdersCSExample;
import com.bdqn.sl.pojo.OrdersCSKey;
import com.bdqn.sl.pojo.OrdersExample;
import com.bdqn.sl.pojo.Setmeal;
import com.bdqn.sl.pojo.SysUser;
import com.bdqn.sl.pojo.SysUserExample;
import com.bdqn.sl.pojo.SysAuthorityExample.Criteria;
import com.bdqn.sl.pojo.SysRole;
import com.bdqn.sl.pojo.SysRoleExample;
import com.bdqn.sl.pojo.SysRoletype;
import com.bdqn.sl.pojo.SysRoletypeExample;
import com.bdqn.sl.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @描述 sl-manager-service
 * @作者 施鹏振
 * @创建日期 2018年3月26日
 * @创建时间 上午9:13:49
 */
@Service
public class OrdersServiceImpl implements IOrdersService {

	@Resource
	private OrdersMapper ordersMapper;

	@Resource
	private OrdersCSMapper ordersCSMapper;

	@Resource
	private SysUserMapper sysUserMapper;

	@Resource
	private SetmealMapper setmealMapper;

	@Resource
	private SysRoletypeMapper sysRoletypeMapper;

	@Resource
	private CommodityMapper commodityMapper;

	@Resource
	private SysRoleMapper sysRoleMapper;

	// 加入购物车
	@Override
	public boolean addShopingCard(OrdersCS ordersCS, Orders orders) {
		OrdersExample example = new OrdersExample();
		com.bdqn.sl.pojo.OrdersExample.Criteria criteria = example.createCriteria();
		criteria.andCreateuidEqualTo(orders.getCreateuid());
		criteria.andOrdertypeEqualTo(2);
		criteria.andStatusEqualTo(2);
		Float price = orders.getPrice();
		if (ordersMapper.countByExample(example) == 0) {
			orders.setPrice(new Float(0));
			orders.setCreated(new Date());
			if (ordersMapper.insertSelective(orders) == 0) {
				return false;
			}
		}
		Orders orders2 = ordersMapper.selectByExample(example).get(0);
		orders2.setCreated(new Date());
		orders2.setPrice(orders2.getPrice() + price);
		if (ordersMapper.updateByPrimaryKeySelective(orders2) == 0) {
			return false;
		}

		Integer oId = orders2.getOrderid();
		OrdersCSKey ordersCSKey = new OrdersCSKey();
		ordersCSKey.setOcsOid(oId);
		ordersCSKey.setCstype(ordersCS.getCstype());
		ordersCSKey.setOcsCsid(ordersCS.getOcsCsid());
		OrdersCS ordersCS2 = ordersCSMapper.selectByPrimaryKey(ordersCSKey);
		if (ordersCS2 == null) {
			ordersCS.setOcsOid(oId);
			if (ordersCSMapper.insertSelective(ordersCS) == 0) {
				return false;
			}
		} else {
			ordersCS2.setOcsCnum(ordersCS2.getOcsCnum() + ordersCS.getOcsCnum());
			if (ordersCSMapper.updateByPrimaryKeySelective(ordersCS2) == 0) {
				return false;
			}
		}

		// 减少商品库存
		if (ordersCS.getCstype() == 1) {
			Commodity commodity = commodityMapper.selectByPrimaryKey(ordersCS.getOcsCsid());
			commodity.setNumber(commodity.getNumber() - ordersCS.getOcsCnum());
			if (commodityMapper.updateByPrimaryKeySelective(commodity) == 0) {
				return false;
			}
		}
		if (ordersCS.getCstype() == 2) {
			Setmeal setmeal = setmealMapper.selectByPrimaryKey(ordersCS.getOcsCsid());
			setmeal.setSmnumber(setmeal.getSmnumber() - ordersCS.getOcsCnum());
			if (setmealMapper.updateByPrimaryKeySelective(setmeal) == 0) {
				return false;
			}
		}
		return true;
	}

	// 立即购买
	@Override
	public boolean addOrders(OrdersCS ordersCS, Orders orders, Integer smtypeid, String loginName) {

		// 新增一个订单
		orders.setCreated(new Date());
		if (ordersMapper.insertSelective(orders) == 0) {
			return false;
		}

		OrdersExample example = new OrdersExample();
		example.setOrderByClause("created desc");
		example.setLimit("1");
		com.bdqn.sl.pojo.OrdersExample.Criteria criteria = example.createCriteria();
		criteria.andOrdertypeEqualTo(1);

		// 新增订单和商品关系
		Integer oId = ordersMapper.selectByExample(example).get(0).getOrderid();
		ordersCS.setOcsOid(oId);
		if (ordersCSMapper.insertSelective(ordersCS) == 0) {
			return false;
		}

		// 判断钱是否足够
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(orders.getCreateuid());
		if (userMoneyExists(orders.getCreateuid(), orders.getPrice())) {
			return false;
		}
		// 购买付钱
		sysUser.setYmoney(sysUser.getYmoney() - orders.getPrice());
		if (sysUserMapper.updateByPrimaryKeySelective(sysUser) == 0) {
			return false;
		}

		// 报单立即购买
		if (smtypeid == 9) {
			// 推荐人奖金
			SysUser user = sysUserMapper.selectByPrimaryKey(orders.getCreateuid());
			Float float1 = (float) (sysUser.getYmoney() + orders.getPrice() * 0.1);
			user.setYmoney(float1);
			if (sysUserMapper.updateByPrimaryKeySelective(user) == 0) {
				return false;
			}
			// 买后更变角色
			SysUserExample example2 = new SysUserExample();
			com.bdqn.sl.pojo.SysUserExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andLoginnameEqualTo(loginName);
			user = sysUserMapper.selectByExample(example2).get(0);
			user.setAssociatorid(findRoleTypeIdByName(findSetMealNameById(ordersCS.getOcsCsid())));
			if (sysUserMapper.updateByExample(user, example2) == 0) {
				return false;
			}
		}

		// 减少商品库存
		if (ordersCS.getCstype() == 1) {
			Commodity commodity = commodityMapper.selectByPrimaryKey(ordersCS.getOcsCsid());
			commodity.setNumber(commodity.getNumber() - ordersCS.getOcsCnum());
			if (commodityMapper.updateByPrimaryKeySelective(commodity) == 0) {
				return false;
			}
		}
		if (ordersCS.getCstype() == 2) {
			Setmeal setmeal = setmealMapper.selectByPrimaryKey(ordersCS.getOcsCsid());
			setmeal.setSmnumber(setmeal.getSmnumber() - ordersCS.getOcsCnum());
			if (setmealMapper.updateByPrimaryKeySelective(setmeal) == 0) {
				return false;
			}
		}

		return true;
	}

	// 账户余额是否足够(不足返回true)
	@Override
	public boolean userMoneyExists(Integer uId, Float price) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(uId);
		if (sysUser.getYmoney() == null) {
			return true;
		}
		if (sysUser.getYmoney() < price) {
			return true;
		}
		return false;
	}

	// 判断会员中是否又该用户(不存在返回true)
	@Override
	public SysUser loginNameExistsByVIP(String loginName) {

		SysUserExample example = new SysUserExample();
		com.bdqn.sl.pojo.SysUserExample.Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(2);
		criteria.andLoginnameEqualTo(loginName);
		criteria.andAssociatoridEqualTo(2);

		List<SysUser> list = sysUserMapper.selectByExample(example);

		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 查询套餐名称
	public String findSetMealNameById(Integer smId) {
		return setmealMapper.selectByPrimaryKey(smId).getSmname();
	}

	// 根据会员名称获取id
	public Integer findRoleTypeIdByName(String roleTypeName) {
		SysRoletypeExample example = new SysRoletypeExample();
		com.bdqn.sl.pojo.SysRoletypeExample.Criteria criteria = example.createCriteria();
		criteria.andRoletypenameEqualTo(roleTypeName);
		List<SysRoletype> roletypes = sysRoletypeMapper.selectByExample(example);
		if (roletypes == null) {
			return null;
		}
		return roletypes.get(0).getId();
	}

	// 查询订单分页
	@Override
	public PageInfo<Orders> findOrdersListPaging(Integer ordersId, String loginName, Integer orderType, Integer uId,
			Integer pageSize, Integer pageNo) {

		OrdersExample example = new OrdersExample();
		com.bdqn.sl.pojo.OrdersExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(1);
		if (uId != 1) {
			criteria.andCreateuidEqualTo(uId);
		}
		if (ordersId != null) {
			criteria.andOrderidEqualTo(ordersId);
		}

		if (loginName != null && !loginName.equals("")) {
			List<Integer> uid = findUidByloginName(loginName);
			if (uid != null) {
				criteria.andCreateuidIn(uid);
			}
		}
		if (orderType != null && orderType != 0) {
			criteria.andOrdertypeEqualTo(orderType);
		}
		PageHelper.startPage(pageNo, pageSize);
		List<Orders> ordersList = ordersMapper.selectByExample(example);
		for (Orders orders : ordersList) {
			orders.setuName(sysUserMapper.selectByPrimaryKey(orders.getCreateuid()).getLoginname());
			orders.setName(sysUserMapper.selectByPrimaryKey(orders.getCreateuid()).getUname());
		}
		return new PageInfo<Orders>(ordersList);
	}

	// 根据登录名查询用户编号
	public List<Integer> findUidByloginName(String loginName) {
		SysUserExample example = new SysUserExample();
		com.bdqn.sl.pojo.SysUserExample.Criteria criteria = example.createCriteria();
		criteria.andLoginnameLike("%" + loginName + "%");
		List<SysUser> list = sysUserMapper.selectByExample(example);
		List<Integer> uidList = new ArrayList<Integer>();
		if (list != null && list.size() > 0) {
			for (SysUser u : list) {
				uidList.add(u.getUserid());
			}
		} else {
			uidList.add(0);
		}
		return uidList;
	}

	// 删除订单
	@Override
	public boolean delOrders(Integer ordersId) {
		if (ordersMapper.deleteByPrimaryKey(ordersId) == 0) {
			return false;
		}
		OrdersCSExample example = new OrdersCSExample();
		com.bdqn.sl.pojo.OrdersCSExample.Criteria criteria = example.createCriteria();
		criteria.andOcsOidEqualTo(ordersId);
		if (ordersCSMapper.deleteByExample(example) == 0) {
			return false;
		}
		return true;
	}

	// 查询某用户购物车订单
	@Override
	public Orders findShopingCardOrders(Integer uId) {
		OrdersExample example = new OrdersExample();
		com.bdqn.sl.pojo.OrdersExample.Criteria criteria = example.createCriteria();
		criteria.andCreateuidEqualTo(uId);
		criteria.andStatusEqualTo(2);
		criteria.andOrdertypeEqualTo(2);
		for (Orders orders : ordersMapper.selectByExample(example)) {
			return orders;
		}
		return null;
	}

	// 查询某用户购物车商品
	@Override
	public PageInfo<OrdersCS> findOrdersListPaging(Integer uId, Integer pageSize, Integer pageNo) {
		PageHelper.startPage(pageNo, pageSize);
		OrdersCSExample example = new OrdersCSExample();
		com.bdqn.sl.pojo.OrdersCSExample.Criteria criteria = example.createCriteria();
		Orders orders = findShopingCardOrders(uId);
		List<OrdersCS> list = null;
		if (orders != null) {
			criteria.andOcsOidEqualTo(orders.getOrderid());
			list = ordersCSMapper.selectByExample(example);
		}
		if (list != null) {
			for (OrdersCS ordersCS : list) {
				if (ordersCS.getCstype() == 1) {
					Commodity commodity = commodityMapper.selectByPrimaryKey(ordersCS.getOcsCsid());
					ordersCS.setName(commodity.getCommodityname());
					ordersCS.setPrice(commodity.getXprice());
				}
				if (ordersCS.getCstype() == 2) {
					Setmeal setmeal = setmealMapper.selectByPrimaryKey(ordersCS.getOcsCsid());
					ordersCS.setName(setmeal.getSmname());
					ordersCS.setPrice(setmeal.getSmprice());
				}
			}
		}
		return new PageInfo<OrdersCS>(list);
	}

	// 删除购物车中的商品
	@Override
	public boolean delShopingCardcs(OrdersCS ordersCS) {
		Orders orders = ordersMapper.selectByPrimaryKey(ordersCS.getOcsOid());
		orders.setPrice(orders.getPrice() - ordersCS.getPrice());
		if (ordersMapper.updateByPrimaryKeySelective(orders) == 0) {
			return false;
		}
		if (ordersCSMapper.deleteByPrimaryKey(ordersCS) == 0) {
			return false;
		}
		// 减少商品库存
		if (ordersCS.getCstype() == 1) {
			Commodity commodity = commodityMapper.selectByPrimaryKey(ordersCS.getOcsCsid());
			commodity.setNumber(commodity.getNumber() + ordersCS.getOcsCnum());
			if (commodityMapper.updateByPrimaryKeySelective(commodity) == 0) {
				return false;
			}
		}
		if (ordersCS.getCstype() == 2) {
			Setmeal setmeal = setmealMapper.selectByPrimaryKey(ordersCS.getOcsCsid());
			setmeal.setSmnumber(setmeal.getSmnumber() + ordersCS.getOcsCnum());
			if (setmealMapper.updateByPrimaryKeySelective(setmeal) == 0) {
				return false;
			}
		}
		return true;
	}

	// 购物车结算
	@Override
	public boolean settleAccounts(Integer oid, Float price, Integer uid) {
		Orders orders = ordersMapper.selectByPrimaryKey(oid);
		orders.setStatus(1);
		if (ordersMapper.updateByPrimaryKeySelective(orders) == 0) {
			return false;
		}
		SysUser user = sysUserMapper.selectByPrimaryKey(uid);
		user.setYmoney(user.getYmoney() - price);
		if (sysUserMapper.updateByPrimaryKeySelective(user) == 0) {
			return false;
		}
		return true;
	}

}

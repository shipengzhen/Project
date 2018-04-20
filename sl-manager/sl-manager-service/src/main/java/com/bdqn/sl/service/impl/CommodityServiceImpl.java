/**
 * 
 */
package com.bdqn.sl.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdqn.sl.mapper.CommodityMapper;
import com.bdqn.sl.mapper.SmCMapper;
import com.bdqn.sl.mapper.SysDictionaryMapper;
import com.bdqn.sl.pojo.Commodity;
import com.bdqn.sl.pojo.CommodityExample;
import com.bdqn.sl.pojo.SmCExample;
import com.bdqn.sl.pojo.SysDictionary;
import com.bdqn.sl.pojo.SysDictionaryExample;
import com.bdqn.sl.service.ICommodityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @描述 sl-manager-service
 * @作者 施鹏振
 * @创建日期 2018年3月20日
 * @创建时间 上午9:27:16
 */
@Service
public class CommodityServiceImpl implements ICommodityService {

	@Resource
	private CommodityMapper commodityMapper;

	@Resource
	private SysDictionaryMapper sysDictionaryMapper;

	@Resource
	private SmCMapper smCMapper;

	// 新增商品
	@Override
	public boolean addCommodity(Commodity commodity) {
		commodity.setCreated(new Date());
		commodity.setUpdated(new Date());
		if (commodityMapper.insertSelective(commodity) > 0) {
			return true;
		}
		return false;
	}

	// 查询商品列表(分页)
	@Override
	public PageInfo<Commodity> findCommodityListPaging(String commoDityname, Integer status, Float price1, Float price2,
			Integer pageSize, Integer pageNo) {
		PageHelper.startPage(pageNo, pageSize);
		CommodityExample example = new CommodityExample();
		example.setOrderByClause("updated desc");
		com.bdqn.sl.pojo.CommodityExample.Criteria criteria = example.createCriteria();
		if (commoDityname != null && !commoDityname.equals("")) {
			criteria.andCommoditynameLike("%" + commoDityname + "%");
		}
		if (status != null && status != 0) {
			criteria.andStatusEqualTo(status);
		}
		if (price1 != null&&price2 != null) {
			criteria.andXpriceBetween(price1, price2);
		}
		return new PageInfo<Commodity>(commodityMapper.selectByExample(example));
	}

	// 修改商品状态
	@Override
	public boolean modifyCommodityStates(Commodity commodity) {
		if (commodityMapper.updateByPrimaryKeySelective(commodity) > 0) {
			return true;
		}
		return false;
	}

	// 查看商品详情
	@Override
	public Commodity findCommodity(Integer commodityId) {
		return commodityMapper.selectByPrimaryKey(commodityId);
	}

	// 修改商品信息
	@Override
	public boolean modifyCommodity(Commodity commodity) {
		commodity.setUpdated(new Date());
		if (commodityMapper.updateByPrimaryKeySelective(commodity) > 0) {
			return true;
		}
		return false;
	}

	// 删除商品
	@Override
	public boolean delCommodity(Integer commodityId) {
		if (commodityMapper.deleteByPrimaryKey(commodityId) > 0) {
			return true;
		}
		return false;
	}

	// 查询商品状态
	@Override
	public List<SysDictionary> findCommodityStatus() {
		SysDictionaryExample example = new SysDictionaryExample();
		com.bdqn.sl.pojo.SysDictionaryExample.Criteria criteria = example.createCriteria();
		criteria.andTypecodeEqualTo("commodtiyStatus");

		return sysDictionaryMapper.selectByExample(example);
	}

	// 查询某商品所在套餐的数量
	@Override
	public Integer findSmCountBycId(Integer commodityId) {
		SmCExample example = new SmCExample();
		com.bdqn.sl.pojo.SmCExample.Criteria criteria = example.createCriteria();
		criteria.andSmcCidEqualTo(commodityId);
		return smCMapper.countByExample(example);
	}

	//商品名称是否存在,存在返回true
	@Override
	public boolean acommodityNameExists(String commodityName) {
		CommodityExample example=new CommodityExample();
		com.bdqn.sl.pojo.CommodityExample.Criteria criteria=example.createCriteria();
		criteria.andCommoditynameEqualTo(commodityName);
		if (commodityMapper.countByExample(example)>0) {
			return true;
		}
		return false;
	}

	//修改时商品名称是否存在,存在返回true
	@Override
	public boolean mcommodityNameExists(String commodityName, String mm_goodsName) {
		CommodityExample example=new CommodityExample();
		com.bdqn.sl.pojo.CommodityExample.Criteria criteria=example.createCriteria();
		criteria.andCommoditynameNotEqualTo(mm_goodsName);
		criteria.andCommoditynameEqualTo(commodityName);
		if (commodityMapper.countByExample(example)>0) {
			return true;
		}
		return false;
	}

}

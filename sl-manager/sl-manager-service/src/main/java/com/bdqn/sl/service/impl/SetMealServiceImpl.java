/**
 * 
 */
package com.bdqn.sl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bdqn.sl.mapper.CommodityMapper;
import com.bdqn.sl.mapper.SetmealMapper;
import com.bdqn.sl.mapper.SmCMapper;
import com.bdqn.sl.mapper.SysDictionaryMapper;
import com.bdqn.sl.pojo.Setmeal;
import com.bdqn.sl.pojo.SetmealExample;
import com.bdqn.sl.pojo.SmC;
import com.bdqn.sl.pojo.SmCExample;
import com.bdqn.sl.pojo.SysDictionary;
import com.bdqn.sl.pojo.SysDictionaryExample;
import com.bdqn.sl.pojo.AfficheExample.Criteria;
import com.bdqn.sl.service.ISetMealService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @描述 sl-manager-service
 * @作者 施鹏振
 * @创建日期 2018年3月22日
 * @创建时间 上午11:01:16
 */
@Service
public class SetMealServiceImpl implements ISetMealService {

	@Resource
	private SysDictionaryMapper sysDictionaryMapper;	//字典

	@Resource
	private SetmealMapper setmealMapper;	//套餐

	@Resource
	private SmCMapper smCMapper;			//中间表

	@Resource
	private CommodityMapper commodityMapper;	//商品

	

	//查询 激活套餐
	@Override
	public List<Setmeal> findSetmealBysmTypeID(Integer smTypeid) {
		
		SetmealExample example = new SetmealExample();
		com.bdqn.sl.pojo.SetmealExample.Criteria criteria = example.createCriteria();
		criteria.andSmtypeidEqualTo(smTypeid);
		
		List<Setmeal> list = setmealMapper.selectByExample(example);
		
		return list;
	}
	
	
	
	//根据 商品 id 查询 套餐
	@Override
	public boolean findSmBycId(Integer cid) {
		
		SmCExample example = new SmCExample();
		com.bdqn.sl.pojo.SmCExample.Criteria criteria = example.createCriteria();
		criteria.andSmcCidEqualTo(cid);
		
		int i = smCMapper.countByExample(example);
		if(i>0) {
			return false;
		}
		return true;
	}

	
	
	//---------------------------------
	// 查询套餐类型
	@Override
	public List<SysDictionary> findSetMealType() {
		SysDictionaryExample example = new SysDictionaryExample();
		com.bdqn.sl.pojo.SysDictionaryExample.Criteria criteria = example.createCriteria();
		criteria.andTypecodeEqualTo("SetMealType");
		return sysDictionaryMapper.selectByExample(example);
	}

	// 添加商品套餐
	@Override
	public boolean addSetMeal(Setmeal setmeal, String goodsJson) {
		setmeal.setCreated(new Date());
		setmeal.setUpdated(new Date());
		if (setmealMapper.insertSelective(setmeal) == 0) {
			return false;
		}
		Integer smId = findNewSetMeal();
		JSONArray jsonArray = (JSONArray) JSONArray.parse(goodsJson);
		for (Object object : jsonArray) {
			JSONObject jsonObject = (JSONObject) object;
			if (jsonObject.getInteger("goodsInfoId") == 0) {
				continue;
			}
			SmC smC = new SmC();
			smC.setSmcSid(smId);
			smC.setSmcCid(jsonObject.getInteger("goodsInfoId"));
			smC.setSmcCnum(jsonObject.getInteger("goodsNum"));
			if (smCMapper.insertSelective(smC) == 0) {
				return false;
			}
		}
		return true;
	}

	// 查询最新新增的套餐编号
	@Override
	public Integer findNewSetMeal() {
		SetmealExample example = new SetmealExample();
		example.setColumns("smid");
		example.setOrderByClause("created desc");
		example.setLimit("1");
		return setmealMapper.selectByExample(example).get(0).getSmid();
	}

	// 查询商品套餐列表(分页)
	@Override
	public PageInfo<Setmeal> findSetMealListPaging(String smName, Integer smType, Integer smStatus,Float price1, Float price2, Integer pageNo,
			Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		SetmealExample example = new SetmealExample();
		example.setOrderByClause("updated desc");
		com.bdqn.sl.pojo.SetmealExample.Criteria criteria = example.createCriteria();
		if (smName != null && !smName.equals("")) {
			criteria.andSmnameLike("%" + smName + "%");
		}
		if (smType != null && smType != 0) {
			criteria.andSmtypeidEqualTo(smType);
		}
		if (smStatus != null && smStatus != 0) {
			criteria.andSmstaticEqualTo(smStatus);
		}
		if (price1 != null&&price2 != null) {
			criteria.andSmpriceBetween(price1, price2);
		}
		List<Setmeal> setmealList = setmealMapper.selectByExample(example);
		for (Setmeal setmeal : setmealList) {
			setmeal.setSmTypeName(sysDictionaryMapper.selectByPrimaryKey(setmeal.getSmtypeid()).getValuename());
		}
		return new PageInfo<Setmeal>(setmealList);
	}

	// 修改商品套餐状态
	@Override
	public boolean modifySetMealStatus(Setmeal setmeal) {
		setmeal.setUpdated(new Date());
		if (setmealMapper.updateByPrimaryKeySelective(setmeal) > 0) {
			return true;
		}
		return false;
	}

	// 查询商品套餐信息
	@Override
	public Setmeal findSetMealBySmId(Integer smId) {
		Setmeal setmeal = setmealMapper.selectByPrimaryKey(smId);
		setmeal.setSmTypeName(sysDictionaryMapper.selectByPrimaryKey(setmeal.getSmtypeid()).getValuename());
		return setmeal;
	}

	// 查询某个套餐所包含的商品
	@Override
	public List<Object[]> findCommodityListBySmId(Integer smId) {
		SmCExample example = new SmCExample();
		com.bdqn.sl.pojo.SmCExample.Criteria criteria = example.createCriteria();
		criteria.andSmcSidEqualTo(smId);
		List<SmC> smCs = smCMapper.selectByExample(example);
		List<Object[]> list = new ArrayList<Object[]>();
		for (SmC smC : smCs) {
			Object[] objects = { commodityMapper.selectByPrimaryKey(smC.getSmcCid()), smC.getSmcCnum() };
			list.add(objects);
		}
		return list;
	}

	// 修改商品套餐
	@Override
	public boolean modifySetMeal(Setmeal setmeal, String goodsJson) {
		if (setmealMapper.updateByPrimaryKeySelective(setmeal)==0) {
			return false;
		}
		SmCExample example=new SmCExample();
		com.bdqn.sl.pojo.SmCExample.Criteria criteria=example.createCriteria();
		criteria.andSmcSidEqualTo(setmeal.getSmid());
		smCMapper.deleteByExample(example);
		JSONArray jsonArray = (JSONArray) JSONArray.parse(goodsJson);
		for (Object object : jsonArray) {
			JSONObject jsonObject = (JSONObject) object;
			if (jsonObject.getInteger("goodsInfoId") == 0) {
				continue;
			}
			SmC smC = new SmC();
			smC.setSmcSid(setmeal.getSmid());
			smC.setSmcCid(jsonObject.getInteger("goodsInfoId"));
			smC.setSmcCnum(jsonObject.getInteger("goodsNum"));
			if (smCMapper.insertSelective(smC) == 0) {
				return false;
			}
		}
		return true;
	}

	// 删除商品套餐
	@Override
	public boolean delSetMeal(Integer smId) {
		SmCExample example=new SmCExample();
		com.bdqn.sl.pojo.SmCExample.Criteria criteria=example.createCriteria();
		criteria.andSmcSidEqualTo(smId);
		smCMapper.deleteByExample(example);
		if (setmealMapper.deleteByPrimaryKey(smId)==0) {
			return false;
		}
		return true;
	}

	
	//新增时套餐名称唯一验证
	@Override
	public boolean asetMealNameNameExists(String setMealName) {
		SetmealExample example=new SetmealExample();
		com.bdqn.sl.pojo.SetmealExample.Criteria criteria=example.createCriteria();
		criteria.andSmnameEqualTo(setMealName);
		if (setmealMapper.countByExample(example)>0) {
			return true;
		}
		return false;
	}

	//修改时套餐名称唯一验证
	@Override
	public boolean msetMealNameNameExists(String setMealName, String mm_goodsPackName) {
		SetmealExample example=new SetmealExample();
		com.bdqn.sl.pojo.SetmealExample.Criteria criteria=example.createCriteria();
		criteria.andSmnameNotEqualTo(mm_goodsPackName);
		criteria.andSmnameEqualTo(setMealName);
		if (setmealMapper.countByExample(example)>0) {
			return true;
		}
		return false;
	}



}

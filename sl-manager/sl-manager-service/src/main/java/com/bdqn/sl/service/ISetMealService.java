/**
 * 
 */
package com.bdqn.sl.service;

import java.util.List;

import com.bdqn.sl.pojo.Setmeal;
import com.bdqn.sl.pojo.SysDictionary;
import com.github.pagehelper.PageInfo;

/**
 * @描述 sl-manager-service
 * @作者 施鹏振
 * @创建日期 2018年3月22日
 * @创建时间 上午11:00:45
 */
public interface ISetMealService {
	
	
	/**
	 * 查询 保单套餐
	 * @param smTypeid
	 * @return
	 */
	List<Setmeal> findSetmealBysmTypeID(Integer smTypeid);
	
	/**
	 * 根据 商品 id 查询 套餐
	 * @param cid  商品名称
	 * @return
	 */
	boolean findSmBycId(Integer cid);
	

	/**
	 * 查询套餐类型
	 * 
	 * @return List<SysDictionary>
	 */
	public List<SysDictionary> findSetMealType();

	/**
	 * 添加商品套餐
	 * 
	 * @param setmeal
	 * @param goodsJson
	 * @return boolean
	 */
	public boolean addSetMeal(Setmeal setmeal, String goodsJson);

	/**
	 * 查询最新新增的套餐编号
	 * 
	 * @return Integer
	 */
	public Integer findNewSetMeal();

	/**
	 * 查询商品套餐列表(分页)
	 * 
	 * @param smName
	 * @param smType
	 * @param smStatus
	 * @param pageNo
	 * @param pageSize
	 * @return PageInfo<Setmeal>
	 */
	public PageInfo<Setmeal> findSetMealListPaging(String smName, Integer smType, Integer smStatus, Float price1,
			Float price2, Integer pageNo, Integer pageSize);

	/**
	 * 修改商品套餐状态
	 * 
	 * @param setmeal
	 * @return boolean
	 */
	public boolean modifySetMealStatus(Setmeal setmeal);

	/**
	 * 查询商品套餐信息
	 * 
	 * @param smId
	 * @return Setmeal
	 */
	public Setmeal findSetMealBySmId(Integer smId);

	/**
	 * 查询某个套餐所包含的商品
	 * 
	 * @param smId
	 * @return List<Object[]>
	 */
	public List<Object[]> findCommodityListBySmId(Integer smId);

	/**
	 * 修改商品套餐
	 * 
	 * @param setmeal
	 * @param goodsJson
	 * @return boolean
	 */
	public boolean modifySetMeal(Setmeal setmeal, String goodsJson);

	/**
	 * 删除商品套餐
	 * 
	 * @param smId
	 * @return boolean
	 */
	public boolean delSetMeal(Integer smId);

	/**
	 * 新增时套餐名称唯一验证
	 * 
	 * @param setMealName
	 * @return boolean
	 */
	public boolean asetMealNameNameExists(String setMealName);
	
	/**
	 * 修改时套餐名称唯一验证
	 * @param setMealName
	 * @param mm_goodsPackName
	 * @return boolean
	 */
	public boolean msetMealNameNameExists(String setMealName,String mm_goodsPackName);
}

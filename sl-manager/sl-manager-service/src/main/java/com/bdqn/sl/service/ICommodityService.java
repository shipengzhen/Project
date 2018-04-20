/**
 * 
 */
package com.bdqn.sl.service;

import java.util.List;

import com.bdqn.sl.pojo.Commodity;
import com.bdqn.sl.pojo.SysDictionary;
import com.github.pagehelper.PageInfo;

/**
 * @描述 sl-manager-service
 * @作者 施鹏振
 * @创建日期 2018年3月20日
 * @创建时间 上午9:15:13
 */
public interface ICommodityService {

	/**
	 * 新增商品
	 * 
	 * @param commodity
	 * @return boolean
	 */
	public boolean addCommodity(Commodity commodity);

	/**
	 * 查询商品列表(分页)
	 * 
	 * @param commoDitynamem
	 * @param status
	 * @param price1
	 * @param price2
	 * @param pageSize
	 * @param pageNo
	 * @return PageInfo<Commodity>
	 */
	public PageInfo<Commodity> findCommodityListPaging(String commoDitynamem, Integer status, Float price1,
			Float price2, Integer pageSize, Integer pageNo);

	/**
	 * 修改商品状态
	 * 
	 * @param commodity
	 * @return boolean
	 */
	public boolean modifyCommodityStates(Commodity commodity);

	/**
	 * 查看商品信息
	 * 
	 * @param commodityId
	 * @return Commodity
	 */
	public Commodity findCommodity(Integer commodityId);

	/**
	 * 修改商品信息
	 * 
	 * @param commodity
	 * @return boolean
	 */
	public boolean modifyCommodity(Commodity commodity);

	/**
	 * 删除商品
	 * 
	 * @param commodityId
	 * @return boolean
	 */
	public boolean delCommodity(Integer commodityId);

	/**
	 * 查询商品状态
	 * 
	 * @return List<SysDictionary>
	 */
	public List<SysDictionary> findCommodityStatus();

	/**
	 * 查询某商品所在套餐的数量
	 * 
	 * @param commodityId
	 * @return Integer
	 */
	public Integer findSmCountBycId(Integer commodityId);

	/**
	 * 新增时商品名称是否存在,存在返回true
	 * 
	 * @param commodityName
	 * @return boolean
	 */
	public boolean acommodityNameExists(String commodityName);

	/**
	 * 修改时商品名称是否存在,存在返回true
	 * 
	 * @param commodityName
	 * @param mm_goodsName
	 * @return boolean
	 */
	public boolean mcommodityNameExists(String commodityName, String mm_goodsName);

}

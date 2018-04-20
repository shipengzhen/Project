package com.bdqn.service;

import java.util.List;

import com.bdqn.pojo.TbCostItem;
import com.github.pagehelper.PageInfo;

//收费项 
public interface TbCostItemService {
	
	/**
	 * 收费项集合
	 * @return
	 * @date 2018年2月23日
	 * @time 下午3:27:50
	 * @author lizhen
	 */
	List<TbCostItem> CostItenList();
	
	void deleCostItem(Integer id);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 * @date 2018年2月23日
	 * @time 下午12:14:05
	 * @author lizhen
	 */
	TbCostItem findCostItemById(Integer id);
	/**
	 * 修改
	 * @param ci
	 * @date 2018年2月23日
	 * @time 下午12:10:42
	 * @author lizhen
	 */
	void UpdateCostItem(TbCostItem ci);
	/**
	 * 新增 收费项
	 * @param ci
	 * @date 2018年2月23日
	 * @time 上午11:36:38
	 * @author lizhen
	 */
	void AddCostItem(TbCostItem ci);
	
	/**
	 * 查询
	 */
	PageInfo<TbCostItem> findCostList(String costitemname,Integer pageNo,Integer pageSize);
}

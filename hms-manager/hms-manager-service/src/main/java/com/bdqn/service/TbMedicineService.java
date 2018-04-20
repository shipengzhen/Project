package com.bdqn.service;

import java.util.List;

import com.bdqn.pojo.TbMedicine;
import com.github.pagehelper.PageInfo;
//药品管理
public interface TbMedicineService {
	
	/**
	 * 药品集合
	 * @return
	 * @date 2018年2月23日
	 * @time 下午11:22:10
	 * @author lizhen
	 */
	List<TbMedicine> MeList();
	/**
	 * 修改
	 * @param me
	 * @date 2018年2月23日
	 * @time 下午7:05:50
	 * @author lizhen
	 */
	void UpdayeMe(TbMedicine me);
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 * @date 2018年2月23日
	 * @time 下午6:35:51
	 * @author lizhen
	 */
	TbMedicine findMeById(String id);
	
	/**
	 * 新增
	 * @param me
	 * @date 2018年2月23日
	 * @time 下午4:10:14
	 * @author lizhen
	 */
	void addMe(TbMedicine me);
	/**
	 * 条件查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @date 2018年2月23日
	 * @time 下午5:51:24
	 * @author lizhen
	 */
	PageInfo<TbMedicine> findMeList(Integer pageNo,Integer pageSize,TbMedicine me);
}

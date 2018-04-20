package com.bdqn.service;

import com.bdqn.pojo.TbDispensing;
import com.bdqn.pojo.TbRegister;
import com.github.pagehelper.PageInfo;

//在院发药
public interface TbDispensingService {
	
	
	/**
	 * 修改
	 * @param di
	 * @date 2018年2月24日
	 * @time 上午10:51:52
	 * @author lizhen
	 */
	void UpdateDi(TbDispensing di);
	/**
	 * look  列表 根据 挂红id查询 药品列表
	 * @return
	 * @date 2018年2月24日
	 * @time 上午10:26:51
	 * @author lizhen
	 */
	PageInfo<TbRegister> findReListDi2(Integer id,Integer pageNo,Integer pageSize);
	/**
	 * 新增
	 * @param di
	 * @date 2018年2月24日
	 * @time 上午10:01:15
	 * @author lizhen
	 */
	void AddDi(TbDispensing di);
	/**
	 * 列表
	 * @date 2018年2月23日
	 * @time 下午10:43:39
	 * @author lizhen
	 */
	PageInfo<TbRegister> findReListDi(Integer pageNo,Integer pageSize,Integer id);
}

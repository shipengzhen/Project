package com.bdqn.service;

import com.bdqn.pojo.TbRegister;
import com.bdqn.pojo.TbRegisterSelect;
import com.github.pagehelper.PageInfo;

/**
 * 挂号
 * @author lizhen
 * @date 2018年2月21日
 * @time 下午9:28:58
 */
public interface TbRegisterService {
	
	
	
	/**
	 * 修改
	 */
	void updateRe(TbRegister re);
	
	/**
	 * 根据id查询  挂号
	 * @param id
	 * @return
	 * @date 2018年2月22日
	 * @time 下午4:32:56
	 * @author lizhen
	 */
	TbRegister findReById(Integer id);
	/**
	 * 查询
	 */
	PageInfo<TbRegister> findReList(TbRegisterSelect res,Integer pageNo,Integer pageSize);
	
	/**
	 * 新增
	 * @param re
	 * @date 2018年2月21日
	 * @time 下午9:40:45
	 * @author lizhen
	 */
	void addRe(TbRegister re);
}

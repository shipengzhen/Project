package com.bdqn.service;

import java.util.List;

import com.bdqn.pojo.TbOpd;

/**
 * 科室
 * @author lizhen
 * @date 2018年2月21日
 * @time 下午3:28:43
 */
public interface TbOpdService {
	
	
	List<TbOpd> findOpdByName(String name);
	/**
	 * 所有科室
	 * @return
	 * @date 2018年2月21日
	 * @time 下午3:29:39
	 * @author lizhen
	 */
	List<TbOpd> opdList();
	
	/**
	 * 通过id查询
	 */
	TbOpd findOpdById(Integer id);
}

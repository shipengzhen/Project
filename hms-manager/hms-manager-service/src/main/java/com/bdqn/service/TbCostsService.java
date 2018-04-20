package com.bdqn.service;

import com.bdqn.pojo.TbRegister;
import com.github.pagehelper.PageInfo;

/**
 * 收费项目
 * @author lizhen
 * @date 2018年2月23日
 * @time 下午2:25:41
 */
public interface TbCostsService {
	

	//条件查询
	PageInfo<TbRegister> findReList(Integer id,String name,Integer pageNo,Integer pageSize);
}

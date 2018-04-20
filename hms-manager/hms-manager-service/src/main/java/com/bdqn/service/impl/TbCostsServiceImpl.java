package com.bdqn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.mapper.TbCostsMapper;
import com.bdqn.pojo.TbRegister;
import com.bdqn.service.TbCostsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 收费项目登记
 * @author lizhen
 * @date 2018年2月23日
 * @time 下午2:25:48
 */
@Service
public class TbCostsServiceImpl implements TbCostsService {

	@Autowired
	private TbCostsMapper tbCostsMapper;
	
	//查询 
	@Override
	public PageInfo<TbRegister> findReList(Integer id,String name,Integer pageNo,Integer pageSize) {
		
		PageHelper.startPage(pageNo, pageSize);
		List<TbRegister> list = tbCostsMapper.findReList(id, name);
		
		PageInfo<TbRegister> info = new PageInfo<TbRegister>(list);
		
		return info;
	}

	
}

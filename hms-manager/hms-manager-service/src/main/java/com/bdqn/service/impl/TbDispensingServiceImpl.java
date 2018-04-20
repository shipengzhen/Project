package com.bdqn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.mapper.TbDispensingMapper;
import com.bdqn.pojo.TbDispensing;
import com.bdqn.pojo.TbRegister;
import com.bdqn.service.TbDispensingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

//在医院发药
@Service
public class TbDispensingServiceImpl implements TbDispensingService {

	@Autowired
	public TbDispensingMapper tbDispensingMapper;
	
	//列表 分页
	@Override
	public PageInfo<TbRegister> findReListDi(Integer pageNo, Integer pageSize, Integer id) {
		
		PageHelper.startPage(pageNo, pageSize);
		List<TbRegister> list = tbDispensingMapper.findReListDi(id);
		
		PageInfo<TbRegister> pageInfo = new PageInfo<TbRegister>(list);
		
		return pageInfo;
	}
	//新增
	@Override
	public void AddDi(TbDispensing di) {
		di.setCreated(new Date());
		di.setUpdated(new Date());
		tbDispensingMapper.insert(di);
	}
	//look
	@Override
	public PageInfo<TbRegister> findReListDi2(Integer id, Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<TbRegister> list = tbDispensingMapper.findLookRe(id);
		PageInfo<TbRegister> pageInfo = new  PageInfo<TbRegister>(list);
		
		return pageInfo;
	}
	//修改
	@Override
	public void UpdateDi(TbDispensing di) {
		di.setUpdated(new Date());
		tbDispensingMapper.updateByPrimaryKeySelective(di);
	}
	
}

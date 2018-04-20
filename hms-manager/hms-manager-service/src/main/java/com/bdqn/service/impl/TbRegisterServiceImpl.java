package com.bdqn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.mapper.TbRegisterMapper;
import com.bdqn.pojo.TbRegister;
import com.bdqn.pojo.TbRegisterSelect;
import com.bdqn.service.TbRegisterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TbRegisterServiceImpl implements TbRegisterService {

	@Autowired
	private TbRegisterMapper tbRegisterMapper;		//挂号
	
	//新增
	@Override
	public void addRe(TbRegister re) {
		re.setUpdated(new Date());
		re.setCreated(new Date());
		re.setStatus(1);
		tbRegisterMapper.insert(re);
	}
	
	//查询分页
	@Override
	public PageInfo<TbRegister> findReList(TbRegisterSelect res,Integer pageNo,Integer pageSize) {
		
		PageHelper.startPage(pageNo, pageSize);			//分页
		List<TbRegister> reList = tbRegisterMapper.findReList(res);
		
		PageInfo<TbRegister> pageInfo = new PageInfo<TbRegister>(reList);
		
		return pageInfo;
	}

	//根据id查询
	@Override
	public TbRegister findReById(Integer id) {
		TbRegister register = tbRegisterMapper.selectByPrimaryKey(id);
		return register;
	}
	
	//修改
	@Override
	public void updateRe(TbRegister re) {
		re.setUpdated(new Date());
		tbRegisterMapper.updateByPrimaryKeySelective(re);
	}

}

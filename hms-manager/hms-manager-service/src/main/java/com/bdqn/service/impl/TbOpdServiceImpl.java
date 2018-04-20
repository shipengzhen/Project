package com.bdqn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.mapper.TbOpdMapper;
import com.bdqn.pojo.TbOpd;
import com.bdqn.pojo.TbOpdExample;
import com.bdqn.pojo.TbOpdExample.Criteria;
import com.bdqn.service.TbOpdService;

@Service
public class TbOpdServiceImpl implements TbOpdService {

	@Autowired
	private TbOpdMapper tbOpdMapper;
	
	//科室集合
	@Override
	public List<TbOpd> opdList() {
		List<TbOpd> list = tbOpdMapper.selectByExample(new TbOpdExample());
		return list;
	}
	//通过id查询
	@Override
	public TbOpd findOpdById(Integer id) {
		TbOpd opd = tbOpdMapper.selectByPrimaryKey(id);
		return opd;
	}
	//通过名称查询 科室集合
	@Override
	public List<TbOpd> findOpdByName(String name) {
		TbOpdExample example = new TbOpdExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		
		List<TbOpd> list = tbOpdMapper.selectByExample(example);
		return list;
	}

}

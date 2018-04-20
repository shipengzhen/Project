package com.bdqn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.mapper.TbCostsCostsitemMapper;
import com.bdqn.pojo.TbCostsCostsitemKey;
import com.bdqn.service.TbCostsCostsitemKeyService;
//收费项 和 添加 用户收费项 中间表
@Service
public class TbCostsCostsitemKeyServiceImpl implements TbCostsCostsitemKeyService {

	@Autowired
	private TbCostsCostsitemMapper tbCostsCostsitemMapper;
	
	//新增
	@Override
	public void AddccItem(TbCostsCostsitemKey ccitem) {
		tbCostsCostsitemMapper.insert(ccitem);
	}
	
}

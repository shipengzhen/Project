package com.bdqn.sl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.sl.mapper.SysDictionaryMapper;
import com.bdqn.sl.pojo.SysDictionary;
import com.bdqn.sl.pojo.SysDictionaryExample;
import com.bdqn.sl.pojo.SysDictionaryExample.Criteria;
import com.bdqn.sl.service.ISysDictionaryService2;

//字典表
@Service
public class SysDictionaryServiceImpl2 implements ISysDictionaryService2 {

	@Autowired
	private SysDictionaryMapper sysDictionaryMapper;	//字典
	
	
	//根据 类型编号 查询
	@Override
	public List<SysDictionary> findDiByTypeCode(String typeCode) {
		
		SysDictionaryExample example = new SysDictionaryExample();
		
		Criteria criteria = example.createCriteria();
		criteria.andTypecodeEqualTo(typeCode);
		
		List<SysDictionary> list = sysDictionaryMapper.selectByExample(example);
		
		return list;
	}

	//根据id查询
	@Override
	public SysDictionary findDiByID(Integer id) {
		SysDictionary dictionary = sysDictionaryMapper.selectByPrimaryKey(id);
		
		return dictionary;
	}

}

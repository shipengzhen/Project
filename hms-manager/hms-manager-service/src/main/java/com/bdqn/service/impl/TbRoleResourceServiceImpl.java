package com.bdqn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.mapper.TbRoleResourceMapper;
import com.bdqn.pojo.TbRoleResourceExample;
import com.bdqn.pojo.TbRoleResourceExample.Criteria;
import com.bdqn.pojo.TbRoleResourceKey;
import com.bdqn.service.TbRoleResourceService;

/**
 * 角色 和资源中间表
 * @author lizhen
 * @date 2018年2月5日
 * @time 上午10:51:19
 */
@Service
public class TbRoleResourceServiceImpl implements TbRoleResourceService {

	@Autowired
	private TbRoleResourceMapper tbRoleResourceMapper;
	
	//新增多个
	@Override
	public void AddRoleResources(Integer[]items, Integer roleId) {
		if (items.length>0) {
			for (Integer itemid : items) {
				TbRoleResourceKey item=new TbRoleResourceKey();
				item.setRoleid(roleId);
				item.setItemid(itemid);
				tbRoleResourceMapper.insert(item);
			}
		}
	}
	//根据角色查询
	@Override
	public List<TbRoleResourceKey> findAllByRoleId(Integer id) {
		
		TbRoleResourceExample example = new TbRoleResourceExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(id);
		
		List<TbRoleResourceKey> list = tbRoleResourceMapper.selectByExample(example);
		return list;
	}
	
	//删除多个 -- 角色id 
	@Override
	public void deleteByRoleId(Integer roleId) {
		
		TbRoleResourceExample example = new TbRoleResourceExample();
		example.createCriteria().andRoleidEqualTo(roleId);
		tbRoleResourceMapper.deleteByExample(example);
	}

}

package com.bdqn.sl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.sl.mapper.SysRoleAuthorityMapper;
import com.bdqn.sl.pojo.SysRoleAuthorityExample;
import com.bdqn.sl.pojo.SysRoleAuthorityExample.Criteria;
import com.bdqn.sl.pojo.SysRoleAuthorityKey;
import com.bdqn.sl.service.ISysRoleAuthorityKeyService;

@Service
public class SysRoleAuthorityKeyServiceImpl implements ISysRoleAuthorityKeyService {

	@Autowired
	private SysRoleAuthorityMapper sysRoleAuthorityMapper;
	
	
	// 通过key找v 是否
	@Override
	public String findRAbyKey(Integer roidId, Integer auId) {
		SysRoleAuthorityExample example = new SysRoleAuthorityExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(roidId);
		criteria.andAuthorityidEqualTo(auId);
		
		List<SysRoleAuthorityKey> list = sysRoleAuthorityMapper.selectByExample(example);
		
		if(list!=null&&list.size()>0) {
			System.out.println("1");
			return "1";
		}
		return "2";
	}

}

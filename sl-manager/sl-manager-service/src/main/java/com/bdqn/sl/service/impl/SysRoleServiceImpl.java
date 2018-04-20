/**
 * 
 */
package com.bdqn.sl.service.impl;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdqn.sl.mapper.SysRoleAuthorityMapper;
import com.bdqn.sl.mapper.SysRoleMapper;
import com.bdqn.sl.pojo.SysRole;
import com.bdqn.sl.pojo.SysRoleAuthorityExample;
import com.bdqn.sl.pojo.SysRoleExample;
import com.bdqn.sl.pojo.SysRoleExample.Criteria;
import com.bdqn.sl.service.ISysRoleService;

/**
 * @描述 sl-manager-service
 * @作者 施鹏振
 * @创建日期 2018年3月15日
 * @创建时间 下午8:43:04
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {

	@Resource
	private SysRoleMapper sysRoleMapper;
	
	@Resource
	private SysRoleAuthorityMapper sysRoleAuthorityMapper;
	
	//新增角色
	@Override
	public boolean addRole(String roleName, Integer status,Integer uId) {
		
		SysRole sysRole=new SysRole();
		sysRole.setRolename(roleName);
		sysRole.setStatus(status);
		sysRole.setCreated(new Date());
		sysRole.setCreateuid(uId);
		if (sysRoleMapper.insertSelective(sysRole)>0) {
			return true;
		}
		return false;
	}

	//判断角色是否存在
	@Override
	public boolean existRole(String roleName) {
		
		SysRoleExample example = new SysRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andRolenameEqualTo(roleName);
		if (sysRoleMapper.countByExample(example)>0) {
			return true;
		}
		return false;
	}

	//查询角色列表
	@Override
	public List<SysRole> findRoles() {
		return sysRoleMapper.selectByExample(null);
	}

	//修改角色
	@Override
	public boolean modifyRole(SysRole role) {
		role.setUpdated(new Date());
		if (sysRoleMapper.updateByPrimaryKeySelective(role)>0) {
			return true;
		}
		return false;
	}

	//删除角色
	@Override
	public boolean delRole(Integer roleid) {
		SysRoleAuthorityExample example=new SysRoleAuthorityExample();
		com.bdqn.sl.pojo.SysRoleAuthorityExample.Criteria criteria=example.createCriteria();
		criteria.andRoleidEqualTo(roleid);
		sysRoleAuthorityMapper.deleteByExample(example);
		if (sysRoleMapper.deleteByPrimaryKey(roleid)>0) {
			return true;
		}
		return false;
	}


}

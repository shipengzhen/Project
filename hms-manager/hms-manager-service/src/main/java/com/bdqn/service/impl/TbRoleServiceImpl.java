package com.bdqn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.mapper.TbRoleMapper;
import com.bdqn.mapper.TbRoleResourceMapper;
import com.bdqn.pojo.TbRole;
import com.bdqn.pojo.TbRoleExample;
import com.bdqn.pojo.TbRoleExample.Criteria;
import com.bdqn.pojo.TbRoleResourceExample;
import com.bdqn.service.TbRoleResourceService;
import com.bdqn.service.TbRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

//角色管理
@Service
public class TbRoleServiceImpl implements TbRoleService {

	@Autowired
	private TbRoleMapper tbRoleMapper;			
	
	@Autowired
	private TbRoleResourceMapper tbRoleResourceMapper;		//中间表mapper
	
	@Autowired
	private TbRoleResourceService tbRoleResourceService;	//中间表service
	
	
	
	//----------------------
	//添加角色
	@Override
	public void insertRole(TbRole tbRole) {
		tbRole.setCreated(new Date());
		tbRole.setUpdated(new Date());
		tbRoleMapper.insert(tbRole);
		

	}
	//通过名称查询
	@Override
	public String findTbRoleByName(String roleName) {
		TbRoleExample example=new TbRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andRolenameEqualTo(roleName);
		
		List<TbRole> list = tbRoleMapper.selectByExample(example);
		if(list.size()>0) {
			return "no";
		}
		return "ok";
		 
		
	}
	//查询分页
	@Override
	public PageInfo<TbRole> findTbRoleLikeName(String roleName, Integer pageNo, Integer pageSize) {
		
		TbRoleExample example = new TbRoleExample(); 
		example.setOrderByClause("updated desc");
		
		Criteria criteria = example.createCriteria();
		if(roleName!=null) {
			criteria.andRolenameLike("%"+roleName+"%");
		}
		PageHelper.startPage(pageNo, pageSize);
		List<TbRole> list = tbRoleMapper.selectByExample(example);
		
		PageInfo<TbRole> pageInfo = new PageInfo<TbRole>(list);
		
		return pageInfo;
	}
	//删除
	@Override
	public void deleteRole(Integer id) {
		tbRoleMapper.deleteByPrimaryKey(id);
		//删除中间表		
		tbRoleResourceService.deleteByRoleId(id);

	}
	//根据id查询
	@Override
	public TbRole findRoleById(Integer id) {
		TbRole role = tbRoleMapper.selectByPrimaryKey(id);
		
		return role;
	}
	//通过id修改
	@Override
	public void updateRoleById(Integer[]items,TbRole role) {
		//修改角色
		role.setUpdated(new Date());
		tbRoleMapper.updateByPrimaryKeySelective(role);
		//删除中间表		
		tbRoleResourceService.deleteByRoleId(role.getId());	
		//新增中间表
		tbRoleResourceService.AddRoleResources(items, role.getId());
		
	}
	//查询所有的 角色
	@Override
	public List<TbRole> findAllRole() {
		TbRoleExample example = new TbRoleExample(); 
		
		return tbRoleMapper.selectByExample(example);
	}

}

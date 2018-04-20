package com.bdqn.sl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.sl.mapper.SysRoleMapper;
import com.bdqn.sl.mapper.SysUserMapper;
import com.bdqn.sl.pojo.SysRole;
import com.bdqn.sl.pojo.SysUser;
import com.bdqn.sl.pojo.SysUserExample;
import com.bdqn.sl.pojo.SysUserExample.Criteria;
import com.bdqn.sl.service.ISysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SysUserServiceImpl implements ISysUserService {
	
	@Autowired
	private SysUserMapper sysUserMapper;		//用户

	@Autowired
	private SysRoleMapper sysRoleMapper;		//角色
	
	//推荐查询------------------------------------
	
	// 推荐查询  查询当前用户所推荐的人
	@Override
	public PageInfo<SysUser> findUserTJ(SysUser user, Integer pageNo, Integer pageSize) {
		
		SysUserExample example = new SysUserExample();
		example.setOrderByClause("created desc");
		Criteria criteria = example.createCriteria();
		if(user.getLoginname()!=null&&user.getLoginname()!="") {		//名称
			criteria.andLoginnameLike("%"+user.getLoginname()+"%"); 
		}
		if(user.getAssociatorid()!=null&&user.getAssociatorid()>0) {	//会员类型
			criteria.andAssociatoridEqualTo(user.getAssociatorid());
		}
		criteria.andRefereeEqualTo(user.getUserid());		//推荐人是当前对象
		criteria.andAssociatoridNotEqualTo(2);              //不等于注册会员
		
		PageHelper.startPage(pageNo, pageSize);	//分页
		List<SysUser> list = sysUserMapper.selectByExample(example);
		
		PageInfo<SysUser> info = new PageInfo<SysUser>(list);
		
		return info;
	}
	
	
	

	
	//------------------------------------
	
	// 会员列表 推荐人是自己 会员管理
	@Override
	public PageInfo<SysUser> userHYList(SysUser user,Integer pageNo,Integer pageSize) {
		
		SysUserExample example = new SysUserExample();
		example.setOrderByClause(" updated desc ");
		Criteria criteria = example.createCriteria();
		
		criteria.andRefereeEqualTo(user.getUserid());   //推荐人是自己的
		criteria.andUseridNotEqualTo(user.getUserid());
		if(user.getLoginname()!=null&&user.getLoginname()!="") {	//模糊查询 用户名称
			criteria.andLoginnameLike("%"+user.getLoginname()+"%");
		}
		if(user.getUname()!=null&&user.getUname()!="") {			//模糊查询真实行名称
			criteria.andUnameLike("%"+user.getUname()+"%");
		}
		if(user.getAssociatorid()!=null&&user.getAssociatorid()>0) {
			criteria.andAssociatoridEqualTo(user.getAssociatorid());	//根据会员类型
		}
		
		PageHelper.startPage(pageNo, pageSize);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		
		
		PageInfo<SysUser> info = new PageInfo<SysUser>(list);
		
		return info;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// -------------------管理员
	/**
	 * 登录 
	 */
	@Override
	public SysUser findUserByLoginName(String loginName, String loginPwd) {
		
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginnameEqualTo(loginName);
		criteria.andLoginpwdEqualTo(loginPwd);
		
		List<SysUser> list = sysUserMapper.selectByExample(example);
		
		if (list.size()>=0) {
			SysRole role = sysRoleMapper.selectByPrimaryKey(list.get(0).getRoleid());
			list.get(0).setRoleName(role.getRolename());
			return list.get(0);
		}
			
		return null;
	}
	/**
	 * 新增用户
	 */
	@Override
	public void addUser(SysUser user) {
		user.setCreated(new Date());
		user.setUpdated(new Date());
		sysUserMapper.insert(user);
	}
	
	/**
	 * 用户 分页查询
	 */
	@Override
	public PageInfo<SysUser> findUserList(Integer pageNo, Integer pageSize, SysUser user) {
		
	SysUserExample example = new SysUserExample();
		
		
		
		Criteria criteria = example.createCriteria();
	
		if(user.getLoginname()!=null&&user.getLoginname()!="") {
			criteria.andLoginnameLike("%"+user.getLoginname()+"%");	
		}
		criteria.andUseridNotEqualTo(user.getUserid());		//不能是当前用户；
		if(user.getRefereeName()!=null&&user.getRefereeName()!="") {
			List<Integer> list = this.findUserIdByRef(user.getRefereeName());		//根据
			if(list!=null&&list.size()>0) {
				criteria.andRefereeIn(list);				//推荐人
			}else {
				criteria.andRefereeEqualTo(-1);
			}
		}
		if(user.getRoleid()!=null&&user.getRoleid()!=0) {
			criteria.andRoleidEqualTo(user.getRoleid());				//角色id
		}
		if(user.getStatus()!=null&&user.getStatus()>=0) {
			criteria.andStatusEqualTo(user.getStatus());				//状态
		}
		
		
		example.setOrderByClause("updated desc ");
		
		PageHelper.startPage(pageNo, pageSize);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		
		list=findrefName(list);		//推荐人
		PageInfo<SysUser> info = new PageInfo<SysUser>(list);
		return info;
		
	}
	
	/**
	 * 根据 用户id 查询推荐人 
	 * @return
	 */
	public List<SysUser> findrefName(List<SysUser> list){
		
		if(list!=null&&list.size()>0) {
			for (int i = 0; i < list.size(); i++) {
				SysUser sysUser = sysUserMapper.selectByPrimaryKey(list.get(i).getReferee());
				list.get(i).setRefereeName(sysUser.getLoginname());
			}
		}
	
		return list;
	}
	
	
	/**
	 * 根据 推荐人 名字  模糊查询 用户id
	 * @return
	 */
	public List<Integer> findUserIdByRef(String referre){
		SysUserExample example = new  SysUserExample();
		
		
		Criteria createCriteria = example.createCriteria();
		createCriteria.andLoginnameLike("%"+referre+"%");
		
		
		List<SysUser> list = sysUserMapper.selectByExample(example);
		
		List<Integer> UserIdList=new ArrayList<Integer>();
		
		System.out.println("推荐人集合"+list.size());
		if(list.size()>0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(i);
				UserIdList.add(i, list.get(i).getUserid());
			}
		}
		System.out.println("循环结束");
		return UserIdList;
	}
	//根据id查询
	@Override
	public SysUser findUserbyId(Integer id) {
		SysUser user = sysUserMapper.selectByPrimaryKey(id);
		
		return user;
	}
	
	//修改
	@Override
	public void updateUser(SysUser user) {
		sysUserMapper.updateByPrimaryKeySelective(user);
	}
	//删除
	@Override
	public void deleteUser(Integer id) {
		sysUserMapper.deleteByPrimaryKey(id);
	}
	//查询某角色的数量  石棚镇
	@Override
	public Integer findUserCountByRole(Integer roleId) {
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(roleId);
		return sysUserMapper.countByExample(example);
	}
	//判断名称重复
	@Override
	public boolean findUserByLoginName(String name) {
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andLoginnameEqualTo(name);
		
		int i = sysUserMapper.countByExample(example);
		
		if(i>0) {
			return true;
		}
		return false;
	}
	//通过名称 找对象
	@Override
	public SysUser findUserName(String loginName) {
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andLoginnameEqualTo(loginName);
		
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}
















	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

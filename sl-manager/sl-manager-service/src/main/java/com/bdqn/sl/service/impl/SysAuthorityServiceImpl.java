/**
 * 
 */
package com.bdqn.sl.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.bdqn.common.Menu;
import com.bdqn.sl.mapper.SysAuthorityMapper;
import com.bdqn.sl.mapper.SysRoleAuthorityMapper;
import com.bdqn.sl.pojo.SysAuthority;
import com.bdqn.sl.pojo.SysAuthorityExample;
import com.bdqn.sl.pojo.SysAuthorityExample.Criteria;
import com.bdqn.sl.pojo.SysRoleAuthorityExample;
import com.bdqn.sl.pojo.SysRoleAuthorityKey;
import com.bdqn.sl.service.ISysAuthorityService;

/**
 * @描述 sl-manager-service
 * @作者 施鹏振
 * @创建日期 2018年3月16日
 * @创建时间 下午3:54:48
 */
@Service
@SuppressWarnings({"unchecked","rawtypes"})
public class SysAuthorityServiceImpl implements ISysAuthorityService {

	@Resource
	private SysAuthorityMapper sysAuthorityMapper;
	
	@Resource
	private SysRoleAuthorityMapper sysRoleAuthorityMapper;
	
	@Resource
	private RedisTemplate redisTemplate;
	
	
	@Override
	public List<SysAuthority> findAuthoritysByParentId(Integer parentId) {
		SysAuthorityExample example=new SysAuthorityExample();
		Criteria criteria=example.createCriteria();
		criteria.andParentidEqualTo(parentId);
		return sysAuthorityMapper.selectByExample(example);
	}
	
	
	//获取全部权限
	@Override
	public List<Menu> findAuthoritys() {
		List<Menu> menus=new ArrayList<Menu>();
		for (SysAuthority sysAuthority : findAuthoritysByParentId(0)) {
			Menu menu = new Menu();
			menu.setSysAuthority(sysAuthority);
			
			List<SysAuthority> authorities2=findAuthoritysByParentId(sysAuthority.getAuthorityid());
			List<Menu> menu2s=new ArrayList<Menu>();
			for (SysAuthority sysAuthority2 : authorities2) {
				Menu menu2=new Menu();
				menu2.setSysAuthority(sysAuthority2);

				List<Menu> menu3s=new ArrayList<Menu>();
				List<SysAuthority> authorities3 =findAuthoritysByParentId(sysAuthority2.getAuthorityid());
				for (SysAuthority sysAuthority3 : authorities3) {
					Menu menu3=new Menu();
					menu3.setSysAuthority(sysAuthority3);
					menu3s.add(menu3);
				}
				menu2.setMenus(menu3s);
				menu2s.add(menu2);
			}
			menu.setMenus(menu2s);
			menus.add(menu);
		}
		return menus;
	}


	//修改角色权限
	@Override
	public boolean modifyAuthority(Integer roleId, String[] authorityIds) {
		try {
			SysRoleAuthorityExample example=new SysRoleAuthorityExample();
			com.bdqn.sl.pojo.SysRoleAuthorityExample.Criteria criteria=example.createCriteria();
			criteria.andRoleidEqualTo(roleId);
			sysRoleAuthorityMapper.deleteByExample(example);
			//删除所有
			for (String string : authorityIds) {
				Integer authorityId=Integer.parseInt(string);
				SysRoleAuthorityKey sysRoleAuthorityKey=new SysRoleAuthorityKey();
				sysRoleAuthorityKey.setRoleid(roleId);
				sysRoleAuthorityKey.setAuthorityid(authorityId);
				if (sysRoleAuthorityMapper.insertSelective(sysRoleAuthorityKey)==0) {
					return false;
				}
			}
			
			this.Addredis(roleId);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//查询某角色所有的权限id
	@Override
	public List<Integer> findAuthorityIdsByRoleId(Integer roleId) {
		SysRoleAuthorityExample example=new SysRoleAuthorityExample();
		com.bdqn.sl.pojo.SysRoleAuthorityExample.Criteria criteria=example.createCriteria();
		criteria.andRoleidEqualTo(roleId);
		List<Integer> authorityIds=new ArrayList<Integer>();
		for (SysRoleAuthorityKey authority : sysRoleAuthorityMapper.selectByExample(example)) {
			authorityIds.add(authority.getAuthorityid());
		}
		return authorityIds;
	}

	//更新 Redis
	private void Addredis(Integer roleId) {
		
		String rid= roleId.toString();
		System.out.println("进了");
		List<Integer> authorityIds=findAuthorityIdsByRoleId(roleId);
		List<SysAuthority> sysAuthorities=new ArrayList<SysAuthority>();
		for (Integer authorityId : authorityIds) {
			SysAuthority sysAuthority=sysAuthorityMapper.selectByPrimaryKey(authorityId);
			sysAuthorities.add(sysAuthority);
		}
		
		List<Menu> menus=new ArrayList<Menu>();
		for (SysAuthority sysAuthority : sysAuthorities) {
			if (sysAuthority.getParentid()==0) {
				Menu menu=new Menu();
				menu.setSysAuthority(sysAuthority);
				List<Menu> menu2s=new ArrayList<Menu>();
				for (SysAuthority sysAuthority2 : sysAuthorities) {
					if (sysAuthority2.getParentid()==sysAuthority.getAuthorityid()) {
						Menu menu2=new Menu();
						menu2.setSysAuthority(sysAuthority2);
						menu2s.add(menu2);
					}
				}
				menu.setMenus(menu2s);
				menus.add(menu);
			}
		}
		//插入 redis
		//序列化
		//byte[] key=redisTemplate.getStringSerializer().serialize(roleId);
		
		System.out.println(rid);
		
		redisTemplate.execute(new RedisCallback<List<Menu>>() {
			@Override
			public List<Menu> doInRedis(RedisConnection connection) throws DataAccessException {
				
				connection.set(rid.getBytes(), redisTemplate.getValueSerializer().serialize(menus));
				return null;
			}
		});
		System.out.println("Redis-- 新增成功 --- ");
	}
	
	
	
	//查询某角色所有的权限 
	@Override
	public List<Menu> findAuthoritysByByRoleId(Integer roleId) {

		System.out.println("------------------------- ------------------------");		
		String rid= roleId.toString();
		
		List<Menu> num=(List<Menu>) redisTemplate.execute(new RedisCallback<List<Menu>>() {
			@Override
			public List<Menu> doInRedis(RedisConnection connection) throws DataAccessException {
				
				byte[] b=connection.get(rid.getBytes());
				if(b!=null) {
					return (List<Menu>)redisTemplate.getValueSerializer().deserialize(b);
				}
				return null;
			}
		});
		
		if(num!=null) {
			System.out.println("没劲数据库");
			return num;
		}
		
		System.out.println("进了");
		List<Integer> authorityIds=findAuthorityIdsByRoleId(roleId);
		List<SysAuthority> sysAuthorities=new ArrayList<SysAuthority>();
		for (Integer authorityId : authorityIds) {
			SysAuthority sysAuthority=sysAuthorityMapper.selectByPrimaryKey(authorityId);
			sysAuthorities.add(sysAuthority);
		}
		
		List<Menu> menus=new ArrayList<Menu>();
		for (SysAuthority sysAuthority : sysAuthorities) {
			if (sysAuthority.getParentid()==0) {
				Menu menu=new Menu();
				menu.setSysAuthority(sysAuthority);
				List<Menu> menu2s=new ArrayList<Menu>();
				for (SysAuthority sysAuthority2 : sysAuthorities) {
					if (sysAuthority2.getParentid()==sysAuthority.getAuthorityid()) {
						Menu menu2=new Menu();
						menu2.setSysAuthority(sysAuthority2);
						menu2s.add(menu2);
					}
				}
				menu.setMenus(menu2s);
				menus.add(menu);
			}
		}
		//插入 redis
		//序列化
		//byte[] key=redisTemplate.getStringSerializer().serialize(roleId);
		
		System.out.println(rid);
		
		redisTemplate.execute(new RedisCallback<List<Menu>>() {
			@Override
			public List<Menu> doInRedis(RedisConnection connection) throws DataAccessException {
				
				connection.set(rid.getBytes(), redisTemplate.getValueSerializer().serialize(menus));
				return null;
			}
		});
		System.out.println("Redis-- 新增成功 --- ");
		
		
		return menus;
	}

	
}

package com.bdqn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.mapper.TbResourceItemMapper;
import com.bdqn.pojo.TbResourceItem;
import com.bdqn.pojo.TbResourceItemExample;
import com.bdqn.pojo.TbResourceItemExample.Criteria;
import com.bdqn.service.TbResourceItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

//资源管理
@Service
public class TbResourceItemServiceImpl implements TbResourceItemService{

	
	@Autowired
	private TbResourceItemMapper tbResourceItemMapper;
	
	//新增项
	@Override
	public void addTRItem(TbResourceItem TbResourceItem) {
		TbResourceItem.setCreated(new Date());
		TbResourceItem.setUpdated(new Date());
		tbResourceItemMapper.insert(TbResourceItem);
	}
	//通过名称查找
	@Override
	public String fromTRItemByrnam(String rnam) {
		TbResourceItemExample example=new TbResourceItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andRnamEqualTo(rnam);
		
		if(tbResourceItemMapper.selectByExample(example).size()>0)
			return "no";
		return "ok";
	}
	//查询 分页 名称
	@Override
	public PageInfo<TbResourceItem> findTbRIByRname(String rname,Integer pageNo,Integer pageSize) {
		
		TbResourceItemExample example=new TbResourceItemExample();
		example.setOrderByClause("updated desc");							//排序
		Criteria criteria = example.createCriteria();
		if(rname!=null) {
			criteria.andRnamLike("%"+rname+"%");
		}
		
		PageHelper.startPage(pageNo, pageSize);									   //分页插件
		List<TbResourceItem> list = tbResourceItemMapper.selectByExample(example);  //dao
		
		PageInfo<TbResourceItem> p=new PageInfo<>(list);
		
		return p;
	}
	//删除项
	@Override
	public void deleteRItem(Integer id) {
		tbResourceItemMapper.deleteByPrimaryKey(id);
	}
	//更新
	@Override
	public void updateRItem(TbResourceItem TbResourceItem) {
		TbResourceItem.setUpdated(new Date());
		tbResourceItemMapper.updateByPrimaryKeySelective(TbResourceItem);
	}
	//通过id查询
	@Override
	public TbResourceItem findRItemByid(Integer id) {
		
		return tbResourceItemMapper.selectByPrimaryKey(id);
	}
	//查询全部
	@Override
	public List<TbResourceItem> findAllRItem() {
		
		TbResourceItemExample example=new TbResourceItemExample();
		Criteria criteria = example.createCriteria();
		
		List<TbResourceItem> list = tbResourceItemMapper.selectByExample(example);
		
		return list;
	}
	//根据集合查询
	@Override
	public List<TbResourceItem> findIDByList(List<Integer> items) {
		
		TbResourceItemExample example=new TbResourceItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(items);
		
		List<TbResourceItem> list = tbResourceItemMapper.selectByExample(example);
		
		return list;
	}

}

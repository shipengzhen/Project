package com.bdqn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.mapper.TbCostItemMapper;
import com.bdqn.pojo.TbCostItem;
import com.bdqn.pojo.TbCostItemExample;
import com.bdqn.pojo.TbCostItemExample.Criteria;
import com.bdqn.service.TbCostItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

//收费项
@Service
public class TbCostItemServiceImpl implements TbCostItemService {

	@Autowired
	private TbCostItemMapper tbCostItemMapper;
	
	//新增收费项
	@Override
	public void AddCostItem(TbCostItem ci) {
		ci.setUpdated(new Date());
		ci.setCreated(new Date());
		tbCostItemMapper.insert(ci);
	}
	
	//分页
	@Override
	public PageInfo<TbCostItem> findCostList(String costitemname, Integer pageNo, Integer pageSize) {
		
		TbCostItemExample example = new TbCostItemExample(); 

		example.setOrderByClause("updated desc");
		Criteria criteria = example.createCriteria();

		if(costitemname!=null) {
			criteria.andCostitemnameLike("%"+costitemname+"%");
		}
		PageHelper.startPage(pageNo, pageSize);
		List<TbCostItem> list = tbCostItemMapper.selectByExample(example);
		
		PageInfo<TbCostItem> pageInfo = new PageInfo<TbCostItem>(list);
		
		return pageInfo;
	}
	//修改
	@Override
	public void UpdateCostItem(TbCostItem ci) {
		ci.setUpdated(new Date());
		tbCostItemMapper.updateByPrimaryKeySelective(ci);
	}
	//根据id查询
	@Override
	public TbCostItem findCostItemById(Integer id) {
		TbCostItem item = tbCostItemMapper.selectByPrimaryKey(id);
		return item;
	}
	
	//根据id删除
	@Override
	public void deleCostItem(Integer id) {
		tbCostItemMapper.deleteByPrimaryKey(id);
	}
	//收费项集合
	@Override
	public List<TbCostItem> CostItenList() {
		TbCostItemExample example = new TbCostItemExample();
		
		List<TbCostItem> list = tbCostItemMapper.selectByExample(example);
		return list;
	}
	
	
}

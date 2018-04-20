package com.bdqn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.mapper.TbMedicineMapper;
import com.bdqn.pojo.TbMedicine;
import com.bdqn.pojo.TbMedicineExample;
import com.bdqn.pojo.TbMedicineExample.Criteria;
import com.bdqn.service.TbMedicineService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

//药品管理
@Service
public class TbMedicineServiceImpl implements TbMedicineService {
	
	@Autowired
	private TbMedicineMapper tbMedicineMapper;
	
	//新增
	@Override
	public void addMe(TbMedicine me) {
		me.setUpdated(new Date());
		me.setCreated(new Date());
		tbMedicineMapper.insert(me);
	}
	//条件查询
	@Override
	public PageInfo<TbMedicine> findMeList(Integer pageNo, Integer pageSize, TbMedicine me) {
		
		TbMedicineExample example = new TbMedicineExample();
		example.setOrderByClause(" updated desc ");
		Criteria criteria = example.createCriteria();
		if(me.getMedicinenmae()!=null) {
			criteria.andMedicinenmaeLike("%"+me.getMedicinenmae()+"%");
		}
		if(me.getMedicinetype()!=null) {
			criteria.andMedicinetypeEqualTo(me.getMedicinetype());
		}
		PageHelper.startPage(pageNo, pageSize);
		List<TbMedicine> list = tbMedicineMapper.selectByExample(example);
		PageInfo<TbMedicine> info = new PageInfo<TbMedicine>(list);
		
		return info;
	}
	//通过id查询
	@Override
	public TbMedicine findMeById(String id) {
		
		TbMedicine medicine = tbMedicineMapper.selectByPrimaryKey(id);
		
		return medicine;
	}
	//修改
	@Override
	public void UpdayeMe(TbMedicine me) {
		me.setUpdated(new Date());
		tbMedicineMapper.updateByPrimaryKeySelective(me);
	}
	@Override
	public List<TbMedicine> MeList() {
		
		List<TbMedicine> list = tbMedicineMapper.selectByExample(new TbMedicineExample());
		
		return list;
	}

}

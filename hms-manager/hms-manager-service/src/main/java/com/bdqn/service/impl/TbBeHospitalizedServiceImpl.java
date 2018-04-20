package com.bdqn.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.mapper.TbBeHospitalizedMapper;
import com.bdqn.mapper.TbRegisterMapper;
import com.bdqn.pojo.TbBeHospitalized;
import com.bdqn.pojo.TbBeHospitalizedExample;
import com.bdqn.pojo.TbBeHospitalizedExample.Criteria;
import com.bdqn.pojo.TbCostItem;
import com.bdqn.pojo.TbRegister;
import com.bdqn.pojo.TbRegisterExample;
import com.bdqn.pojo.TbRegisterSelect;
import com.bdqn.service.TbBeHospitalizedService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 住院办理
 * @author lizhen
 * @date 2018年2月22日
 * @time 下午9:19:48
 */
@Service
public class TbBeHospitalizedServiceImpl implements TbBeHospitalizedService {

	@Autowired
	private TbBeHospitalizedMapper tbBeHospitalizedMapper;	//住院办理
	
	@Autowired
	private TbRegisterMapper tbRegisterMapper;		//挂号
	
	//--住院结算
	
	
	//详情
	@Override
	public PageInfo<TbCostItem> CosLook(Integer rid, Integer pageNo, Integer pageSize) {
		
		PageHelper.startPage(pageNo, pageSize);
		List<TbCostItem> list = tbBeHospitalizedMapper.findCostItem(rid);
		
		PageInfo<TbCostItem> info = new PageInfo<TbCostItem>(list);
		
		return info;
	}

	
	//住院结算列表
	@Override
	public PageInfo<TbRegister> jsReList(TbRegister re, Integer pageNo, Integer pageSize) {
		
		TbRegisterExample example1 = new  TbRegisterExample();
		example1.setOrderByClause(" updated desc ");
		
		com.bdqn.pojo.TbRegisterExample.Criteria createCriteria = example1.createCriteria();
		if(re.getId()!=null) {
			createCriteria.andIdNotEqualTo(re.getId());
		}
		if(re.getName()!=null && re.getName()!="") {
			createCriteria.andNameLike(re.getName());
		}
		
		List<Integer> statuss=new ArrayList<Integer>();
		statuss.add(3);
		statuss.add(6);
		createCriteria.andStatusIn(statuss);
		PageHelper.startPage(pageNo, pageSize);
		List<TbRegister> list = tbRegisterMapper.selectByExample(example1);
		
		PageInfo<TbRegister> info = new PageInfo<TbRegister>(list);
		
		return info;
	}
	
	
	
	
	
	
	//------------
	//新增 住院
	@Override
	public void AddHos(TbBeHospitalized hos) {
		hos.setUpdated(new Date());
		hos.setCreated(new Date());
		tbBeHospitalizedMapper.insert(hos);
	}
	
	//条件查询  分页
	@Override
	public PageInfo<TbRegister> findListHos(TbRegisterSelect res, Integer pageNo, Integer pageSize) {
		
		PageHelper.startPage(pageNo, pageSize);
		List<TbRegister> hosList = tbBeHospitalizedMapper.finHosList(res);
		
		PageInfo<TbRegister> pageInfo = new PageInfo<TbRegister>(hosList);
		
		return pageInfo;
	}
	//根据挂号id查询 住院信息
	@Override
	public TbBeHospitalized findHosByregister_id(Integer reid) {
		TbBeHospitalizedExample example = new TbBeHospitalizedExample();
		Criteria criteria = example.createCriteria();
		criteria.andRegisterIdEqualTo(reid);
		List<TbBeHospitalized> list = tbBeHospitalizedMapper.selectByExample(example);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
	//修改
	@Override
	public void updateHos(TbBeHospitalized hos) {
		hos.setUpdated(new Date());
		tbBeHospitalizedMapper.updateByPrimaryKeySelective(hos);
	}









}

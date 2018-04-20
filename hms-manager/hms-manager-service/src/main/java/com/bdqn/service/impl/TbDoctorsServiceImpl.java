package com.bdqn.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.mapper.TbDoctorsMapper;
import com.bdqn.pojo.TbDoctors;
import com.bdqn.pojo.TbDoctorsExample;
import com.bdqn.pojo.TbDoctorsExample.Criteria;
import com.bdqn.service.TbDoctorsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TbDoctorsServiceImpl implements TbDoctorsService {

	@Autowired
	private TbDoctorsMapper tbDoctorsMapper;
	
	//新增医生
	@Override
	public void addDoctor(TbDoctors doctor) {
		doctor.setUpdated(new Date());
		doctor.setCreated(new Date());
		tbDoctorsMapper.insert(doctor);
	}
	//查询分页
	@Override
	public PageInfo<TbDoctors> findDoctList(TbDoctors doctor, String name, Integer pageNo, Integer pageSize) {
		
		PageHelper.startPage(pageNo, pageSize);			//分页
		List<TbDoctors> list = tbDoctorsMapper.selectTbDoctorList(doctor.getDoctorid(), doctor.getDoctorname(), name);
		
		PageInfo<TbDoctors> Doctorlist = new PageInfo<TbDoctors>(list);
		
		return Doctorlist;
	}
	//通过id查询
	@Override
	public TbDoctors findDoctorById(Integer id) {
		
		TbDoctors doctors = tbDoctorsMapper.selectByPrimaryKey(id);
		return doctors;
	}
	//修改
	@Override
	public void updateDoctor(TbDoctors doctor) {
		doctor.setUpdated(new Date());
		tbDoctorsMapper.updateByPrimaryKeySelective(doctor);
	}
	//通过 opdid 查询
	@Override
	public List<TbDoctors> findDoctByopdid(Integer id) {
		TbDoctorsExample example = new TbDoctorsExample();
		Criteria criteria = example.createCriteria();
		criteria.andOpdidEqualTo(id);
		
		List<TbDoctors> list = tbDoctorsMapper.selectByExample(example);
		return list;
	}

}

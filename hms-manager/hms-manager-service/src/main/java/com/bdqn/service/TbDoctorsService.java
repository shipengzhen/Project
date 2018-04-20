package com.bdqn.service;

import java.util.List;

import com.bdqn.pojo.TbDoctors;
import com.github.pagehelper.PageInfo;

/**
 * 医生
 * @author lizhen
 * @date 2018年2月21日
 * @time 下午4:01:26
 */
public interface TbDoctorsService {
	
	
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 * @date 2018年2月22日
	 * @time 上午11:23:24
	 * @author lizhen
	 */
	List<TbDoctors> findDoctByopdid(Integer id);
	/**
	 * 修改
	 * @param doctor
	 * @date 2018年2月22日
	 * @time 上午11:20:42
	 * @author lizhen
	 */
	void updateDoctor(TbDoctors doctor);
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 * @date 2018年2月21日
	 * @time 下午7:11:06
	 * @author lizhen
	 */
	TbDoctors findDoctorById(Integer id);
	/**
	 * 新增医生
	 * @param doctor
	 * @date 2018年2月21日
	 * @time 下午4:03:08
	 * @author lizhen
	 */
	void addDoctor(TbDoctors doctor);
	
	/**
	 * 查询分页
	 */
	PageInfo<TbDoctors> findDoctList(TbDoctors doctor,String name,Integer pageNo,Integer pageSize);
}

package com.bdqn.service;

import com.bdqn.pojo.TbBeHospitalized;
import com.bdqn.pojo.TbCostItem;
import com.bdqn.pojo.TbRegister;
import com.bdqn.pojo.TbRegisterSelect;
import com.github.pagehelper.PageInfo;

/**
 * 住院办理
 * @author lizhen
 * @date 2018年2月22日
 * @time 下午9:17:15
 */
public interface TbBeHospitalizedService {
	
	//--住院结算
	
	/**
	 * 结算详情
	 * @param rid
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @date 2018年2月24日
	 * @time 下午3:26:38
	 * @author lizhen
	 */
	PageInfo<TbCostItem> CosLook(Integer rid,Integer pageNo,Integer pageSize);
	
	/**
	 * 住院结算列表
	 * @param re
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @date 2018年2月24日
	 * @time 下午12:08:17
	 * @author lizhen
	 */
	PageInfo<TbRegister> jsReList(TbRegister re,Integer pageNo,Integer pageSize);
	
	
	
	/**
	 * 修改
	 * @param hos
	 * @date 2018年2月23日
	 * @time 上午9:53:13
	 * @author lizhen
	 */
	void updateHos(TbBeHospitalized hos);
	/***
	 * 根据挂号id查询 住院
	 * @return
	 * @date 2018年2月23日
	 * @time 上午9:40:08
	 * @author lizhen
	 */
	TbBeHospitalized findHosByregister_id(Integer reid);
	/**
	 * 查询 分页
	 * @param res
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @date 2018年2月22日
	 * @time 下午10:14:59
	 * @author lizhen
	 */
	PageInfo<TbRegister> findListHos(TbRegisterSelect res,Integer pageNo,Integer pageSize);
	/**
	 * 新增 住院单
	 * @param hos
	 * @date 2018年2月22日
	 * @time 下午9:18:27
	 * @author lizhen
	 */
	void AddHos(TbBeHospitalized hos);
}

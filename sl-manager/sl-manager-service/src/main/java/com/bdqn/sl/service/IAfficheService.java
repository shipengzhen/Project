package com.bdqn.sl.service;

import com.bdqn.sl.pojo.Affiche;
import com.github.pagehelper.PageInfo;

//
public interface IAfficheService {
	

	/**
	 * 删除
	 * @param id
	 */
	void deleteAffiche(Integer id);
	
	/**
	 * 修改
	 * @param affiche
	 */
	void UpdateAffiche(Affiche affiche);
	/**
	 * 新增公告
	 * @param affiche
	 */
	void addAffiche(Affiche affiche);
	
	
	/**
	 * 分页集合
	 * @param PageNum
	 * @param PageSize
	 * @return
	 */
	PageInfo<Affiche> findAllAffiche(Integer type,int pageNum, int pageSize);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Affiche findAfficheById(Integer id);
}

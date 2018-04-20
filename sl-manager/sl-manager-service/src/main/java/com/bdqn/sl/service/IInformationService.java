package com.bdqn.sl.service;

import java.util.List;

import com.bdqn.sl.pojo.Information;
import com.github.pagehelper.PageInfo;

/**
 * 资讯
 * @author lizhen
 */
public interface IInformationService {

	
	boolean findInfoByTitle(String title);
	
	/**
	 * 新增 资讯
	 * @param info
	 */
	void addInfo(Information info);
	
	/**
	 * 资讯分页
	 * @return
	 */
	PageInfo<Information> FindinfoList(Information info,Integer pageNo,Integer pageSize);
	
	/**
	 * 根据id 查询
	 * @return
	 */
	Information findInfoById(Integer id);
	/**
	 * 修改
	 */
	void updateInfo(Information info);
	/**
	 * 删除
	 */
	void delInfo(Integer id);
	
	/**
	 * 展示 5 条
	 */
	List<Information> getInfoListMan();
}

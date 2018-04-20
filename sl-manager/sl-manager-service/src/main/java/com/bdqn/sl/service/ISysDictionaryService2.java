package com.bdqn.sl.service;

import java.util.List;

import com.bdqn.sl.pojo.SysDictionary;

/**
 * 字典
 * @author lizhen
 */
public interface ISysDictionaryService2 {
	
	/**
	 * 查询  类型编号 字典
	 * @return
	 */
	List<SysDictionary> findDiByTypeCode(String typeCode);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	SysDictionary findDiByID(Integer id);
	
}

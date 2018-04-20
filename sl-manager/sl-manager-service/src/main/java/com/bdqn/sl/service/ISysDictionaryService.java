/**
 * 
 */
package com.bdqn.sl.service;

import java.util.List;

import com.bdqn.sl.pojo.SysDictionary;

/**
 * @描述 sl-manager-service
 * @作者 施鹏振
 * @创建日期 2018年3月17日
 * @创建时间 下午8:08:59
 */
public interface ISysDictionaryService {

	/**
	 * 查询所有数据字典类型
	 * @return List<SysDictionary>
	 */
	public List<SysDictionary> findDicTypes();
	
	/**
	 * 获取某类型的所有字典类型
	 * @param typecode
	 * @return List<SysDictionary>
	 */
	public List<SysDictionary> findDictionariesByType(String typecode);
	
	/**
	 * 数据类型编号是否存在(存在返回true)
	 * @param typecode
	 * @return boolean
	 */
	public boolean typeCodeIsexit(String typecode);
	
	/**
	 * 数据类型名称是否存在(存在返回true)
	 * @param typename
	 * @return boolean
	 */
	public boolean typeNameIsexit(String typename);
	
	/**
	 * 添加字典类型
	 * @param dictionary
	 * @return boolean
	 */
	public boolean addDicType(SysDictionary dictionary);
	
	/**
	 * 修改字典类型
	 * @param oldTypeCode
	 * @param dictionary
	 * @return boolean
	 */
	public boolean modifyDicType(String oldTypeCode,SysDictionary dictionary);
	
	/**
	 * 修改字典类型时类型名称验证(存在返回true)
	 * @param dictionary
	 * @return boolean
	 */
	public boolean modifyTypeNameIsexit(SysDictionary dictionary);
	
	/**
	 * 修改字典类型时类型编号验证(存在返回true)
	 * @param dictionary
	 * @return boolean
	 */
	public boolean modifyTypeCodeIsexit(SysDictionary dictionary);
	
	/**
	 * 删除字典类型(包括所有该类型的数据)
	 * @param typeCode
	 * @return boolean
	 */
	public boolean delDicType(String typeCode);
	
	/**
	 * 数据名称是否存在(存在返回true)
	 * @param typeCode
	 * @param valueName
	 * @return boolean
	 */
	public boolean valueNameIsexit(String typeCode,String valueName);
	
	/**
	 * 添加字典数据
	 * @param dictionary
	 * @return boolean
	 */
	public boolean addDic(SysDictionary dictionary);
	
	/**
	 * 修改字典数据
	 * @param dictionary
	 * @return boolean
	 */
	public boolean modifyDic(SysDictionary dictionary);
	
	/**
	 * 删除字典数据
	 * @param dictionaryid
	 * @return boolean
	 */
	public boolean delDic(Integer dictionaryid);
	
}

/**
 * 
 */
package com.bdqn.sl.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdqn.sl.mapper.SysDictionaryMapper;
import com.bdqn.sl.pojo.SysDictionary;
import com.bdqn.sl.pojo.SysDictionaryExample;
import com.bdqn.sl.service.ISysDictionaryService;

/**
 * @描述 sl-manager-service
 * @作者 施鹏振
 * @创建日期 2018年3月17日
 * @创建时间 下午8:10:51
 */
@Service
public class SysDictionaryImpl implements ISysDictionaryService {

	@Resource
	private SysDictionaryMapper sysDictionaryMapper;
	
	
	//查询所有数据字典类型
	@Override
	public List<SysDictionary> findDicTypes() {
		SysDictionaryExample example=new SysDictionaryExample();
		example.setColumns("dictionaryId, typeCode, typeName");
		example.setGroupByClause("typeCode");;
		example.setOrderByClause("updated desc");
		List<SysDictionary> dicList=sysDictionaryMapper.selectByExample(example);
		return dicList;
	}


	//获取某类型的所有字典类型
	@Override
	public List<SysDictionary> findDictionariesByType(String typecode) {
		SysDictionaryExample example=new SysDictionaryExample();
		com.bdqn.sl.pojo.SysDictionaryExample.Criteria criteria=example.createCriteria();
		criteria.andTypecodeEqualTo(typecode);
		List<SysDictionary> dicList=sysDictionaryMapper.selectByExample(example);
		return dicList;
	}

	//数据类型编号是否存在(存在返回true)
	@Override
	public boolean typeCodeIsexit(String typecode) {
		SysDictionaryExample example=new SysDictionaryExample();
		com.bdqn.sl.pojo.SysDictionaryExample.Criteria criteria=example.createCriteria();
		criteria.andTypecodeEqualTo(typecode);
		if (sysDictionaryMapper.countByExample(example)>0) {
			return true;
		}
		return false;
	}

	//数据类型名称是否存在(存在返回true)
	@Override
	public boolean typeNameIsexit(String typename) {
		SysDictionaryExample example=new SysDictionaryExample();
		com.bdqn.sl.pojo.SysDictionaryExample.Criteria criteria=example.createCriteria();
		criteria.andTypenameEqualTo(typename);
		if (sysDictionaryMapper.countByExample(example)>0) {
			return true;
		}
		return false;
	}

	//添加字典类型
	@Override
	public boolean addDicType(SysDictionary dictionary) {
		dictionary.setCreated(new Date());
		dictionary.setUpdated(new Date());
		dictionary.setValuename("");
		dictionary.setDescribed("");
		if (sysDictionaryMapper.insertSelective(dictionary)>0) {
			return true;
		}
		return false;
	}


	//修改字典类型
	@Override
	public boolean modifyDicType(String oldTypeCode, SysDictionary dictionary) {
		dictionary.setUpdated(new Date());
		SysDictionaryExample example=new SysDictionaryExample();
		com.bdqn.sl.pojo.SysDictionaryExample.Criteria criteria=example.createCriteria();
		criteria.andTypecodeEqualTo(oldTypeCode);
		if (sysDictionaryMapper.updateByExampleSelective(dictionary, example)>0) {
			return true;
		}
		return false;
	}


	//修改字典类型时类型名称验证(存在返回true)
	@Override
	public boolean modifyTypeNameIsexit(SysDictionary dictionary) {
		SysDictionaryExample example=new SysDictionaryExample();
		com.bdqn.sl.pojo.SysDictionaryExample.Criteria criteria=example.createCriteria();
		criteria.andTypecodeNotEqualTo(dictionary.getTypecode());
		criteria.andTypenameEqualTo(dictionary.getTypename());
		if (sysDictionaryMapper.countByExample(example)>0) {
			return true;
		}
		return false;
	}


	//修改字典类型时类型编号验证(存在返回true)
	@Override
	public boolean modifyTypeCodeIsexit(SysDictionary dictionary) {
		SysDictionaryExample example=new SysDictionaryExample();
		com.bdqn.sl.pojo.SysDictionaryExample.Criteria criteria=example.createCriteria();
		criteria.andTypenameNotEqualTo(dictionary.getTypename());
		criteria.andTypecodeEqualTo(dictionary.getTypecode());
		if (sysDictionaryMapper.countByExample(example)>0) {
			return true;
		}
		return false;
	}


	//删除字典类型(包括所有该类型的数据)
	@Override
	public boolean delDicType(String typeCode) {
		SysDictionaryExample example=new SysDictionaryExample();
		com.bdqn.sl.pojo.SysDictionaryExample.Criteria criteria=example.createCriteria();
		criteria.andTypecodeEqualTo(typeCode);
		if (sysDictionaryMapper.deleteByExample(example)>0) {
			return true;
		}
		return false;
	}


	//数据名称是否存在(存在返回true)
	@Override
	public boolean valueNameIsexit(String typeCode, String valueName) {
		SysDictionaryExample example=new SysDictionaryExample();
		com.bdqn.sl.pojo.SysDictionaryExample.Criteria criteria=example.createCriteria();
		criteria.andTypecodeEqualTo(typeCode);
		criteria.andValuenameEqualTo(valueName);
		if (sysDictionaryMapper.countByExample(example)>0) {
			return true;
		}
		return false;
	}


	//添加字典数据
	@Override
	public boolean addDic(SysDictionary dictionary) {
		dictionary.setCreated(new Date());
		dictionary.setUpdated(new Date());
		if (sysDictionaryMapper.insertSelective(dictionary)>0) {
			return true;
		}
		return false;
	}

	//修改字典数据
	@Override
	public boolean modifyDic(SysDictionary dictionary) {
		dictionary.setUpdated(new Date());
		if (sysDictionaryMapper.updateByPrimaryKeySelective(dictionary)>0) {
			return true;
		}
		return false;
	}

	//删除字典数据
	@Override
	public boolean delDic(Integer dictionaryid) {
		if (sysDictionaryMapper.deleteByPrimaryKey(dictionaryid)>0) {
			return true;
		}
		return false;
	}
}

/**
 * 
 */
package com.bdqn.sl.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bdqn.common.Menu;
import com.bdqn.sl.pojo.SysDictionary;
import com.bdqn.sl.service.ISysAuthorityService;
import com.bdqn.sl.service.ISysDictionaryService;

/**
 * @描述 sl-manager-web
 * @作者 施鹏振
 * @创建日期 2018年3月17日
 * @创建时间 下午4:32:26
 */
@Controller
@RequestMapping("admin/")
public class DictionaryController {

	@Resource
	private ISysAuthorityService sysAuthorityService;

	@Resource
	private ISysDictionaryService sysDictionaryService;

	// 跳转字典数据管理
	@RequestMapping("dictionaryManage")
	public String dictionaryManage(Model model,HttpSession session) {
		
		List<Menu> menus = sysAuthorityService.findAuthoritysByByRoleId(Integer.parseInt(session.getAttribute("userRId").toString()));	//
		model.addAttribute("mList", JSON.toJSON(menus));
		
	
		
		List<SysDictionary> dicList = sysDictionaryService.findDicTypes();
		model.addAttribute("dicList", dicList);
		
		return "backend/dicmanage";
	}

	// 查询数据字典数据
	@RequestMapping(value = "getJsonDic", produces = { "text/html;charset=UTF-8;", "application/json;" })
	@ResponseBody
	public String getJsonDic(String typecode) {
		try {
			if (typecode == null) {
				return "nodata";
			}
			List<SysDictionary> dicList = sysDictionaryService.findDictionariesByType(typecode);
			return JSON.toJSONString(dicList);
		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}

	// 类型编号不能重复验证(添加)
	@RequestMapping("typeCodeIsexit")
	@ResponseBody
	public String typeCodeIsexit(String typecode) {
		if (typecode.equals("")) {
			return null;
		}
		if (sysDictionaryService.typeCodeIsexit(typecode)) {
			return "ok";
		}
		return null;
	}

	// 类型名称不能重复验证(添加)
	@RequestMapping("typeNameIsexit")
	@ResponseBody
	public String typeNameIsexit(String typename) {
		if (typename.equals("")) {
			return null;
		}
		if (sysDictionaryService.typeNameIsexit(typename)) {
			return "ok";
		}
		return null;
	}

	// 添加字典类型
	@RequestMapping("addDicType")
	@ResponseBody
	public String addDicType(SysDictionary dictionary) {
		if (dictionary.getTypecode() == null) {
			return "nodata";
		}
		if (dictionary.getTypename() == null) {
			return "nodata";
		}
		if (sysDictionaryService.typeCodeIsexit(dictionary.getTypecode())) {
			return "recode";
		}
		if (sysDictionaryService.typeNameIsexit(dictionary.getTypename())) {
			return "rename";
		}
		dictionary.setCreateuid(1);
		if (sysDictionaryService.addDicType(dictionary)) {
			return "success";
		}
		return "failed";
	}

	// 修改字典类型
	@RequestMapping("modifylDicType")
	@ResponseBody
	public String modifylDicType(String oldTypeCode, String oldTypeName, SysDictionary dictionary) {
		if (oldTypeCode.equals("")) {
			return "nodata";
		}
		if (dictionary.getTypecode() == null) {
			return "nodata";
		}
		if (dictionary.getTypename() == null) {
			return "nodata";
		}
		if (oldTypeCode.equals(dictionary.getTypecode())) {
			if (sysDictionaryService.modifyTypeNameIsexit(dictionary)) {
				return "rename";
			}
		}
		if (oldTypeName.equals(dictionary.getTypename())) {
			if (sysDictionaryService.modifyTypeCodeIsexit(dictionary)) {
				return "recode";
			}
		}
		// if
		// (oldTypeCode.equals(dictionary.getTypecode())&&oldTypeName.equals(dictionary.getTypename()))
		// {
		// return "nodata";
		// }
		dictionary.setUpdateuid(1);
		if (sysDictionaryService.modifyDicType(oldTypeCode, dictionary)) {
			return "success";
		}
		return "failed";
	}

	// 删除字典类型(包括所有该类型的数据)
	@RequestMapping("delDicType")
	@ResponseBody
	public String delDicType(String typeCode) {
		if (typeCode.equals("")) {
			return "nodata";
		}
		if (sysDictionaryService.delDicType(typeCode)) {
			return "success";
		}
		return "failed";
	}

	// 添加字典数据时非重验证
	@RequestMapping("valueNameIsexit")
	@ResponseBody
	public String valueNameIsexit(String typeCode, String valueName) {
		if (typeCode.equals("")) {
			return null;
		}
		if (valueName.equals("")) {
			return null;
		}
		if (sysDictionaryService.valueNameIsexit(typeCode, valueName)) {
			return "ok";
		}
		return null;
	}

	// 添加字典数据
	@RequestMapping("addDic")
	@ResponseBody
	public String addDic(SysDictionary dictionary) {
		if (dictionary.getTypecode() == null) {
			return "nodata";
		}
		if (dictionary.getTypename() == null) {
			return "nodata";
		}
		if (dictionary.getValuename() == null) {
			return "nodata";
		}
		if (sysDictionaryService.valueNameIsexit(dictionary.getTypecode(), dictionary.getValuename())) {
			return "rename";
		}
		dictionary.setCreateuid(1);
		if (sysDictionaryService.addDic(dictionary)) {
			return "success";
		}
		return "failed";
	}

	// 修改字典数据
	@RequestMapping("modifyDic")
	@ResponseBody
	public String modifyDic(String oldValueName,SysDictionary dictionary) {
		if (dictionary.getDictionaryid() == null) {
			return "nodata";
		}
		if (dictionary.getValuename() == null) {
			return "nodata";
		}
		if (!oldValueName.equals(dictionary.getValuename())) {
			if (sysDictionaryService.valueNameIsexit(dictionary.getTypecode(), dictionary.getValuename())) {
				return "rename";
			}
		}
		dictionary.setUpdateuid(1);
		if (sysDictionaryService.modifyDic(dictionary)) {
			return "success";
		}
		return "failed";
	}

	// 删除字典数据
	@RequestMapping("delDic")
	@ResponseBody
	public String delDic(Integer dictionaryid) {
		if (dictionaryid==null) {
			return "nodata";
		}
		if (sysDictionaryService.delDic(dictionaryid)) {
			return "success";
		}
		return "failed";
	}
}

package com.bdqn.service;

import com.bdqn.pojo.TbCostsCostsitemKey;

//收费项 和 添加 用户收费项 中间表
public interface TbCostsCostsitemKeyService {
	
	/**
	 * 添加 收费项
	 * @param ccitem
	 * @date 2018年2月23日
	 * @time 下午3:38:34
	 * @author lizhen
	 */
	void AddccItem(TbCostsCostsitemKey ccitem);
}

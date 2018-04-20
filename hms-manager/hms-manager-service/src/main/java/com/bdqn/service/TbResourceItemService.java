package com.bdqn.service;

import java.util.List;

import com.bdqn.pojo.TbResourceItem;
import com.github.pagehelper.PageInfo;

/**
 * 资源菜单管理
 * @author lizhen
 * @date 2018年2月1日
 * @time 下午4:49:05
 */
public interface TbResourceItemService {
	
	
	/**
	 * 数组
	 * @param items
	 * @return
	 * @date 2018年2月26日
	 * @time 下午3:48:52
	 * @author lizhen
	 */
	List<TbResourceItem> findIDByList(List<Integer> items);
	
	/**
	 * 新增
	 * @param TbResourceItem
	 * @date 2018年2月2日
	 * @time 下午3:07:19
	 * @author lizhen
	 */
	void addTRItem(TbResourceItem TbResourceItem);
	/**
	 * 通过名称查找  ajax
	 * @param rnam
	 * @return
	 * @date 2018年2月2日
	 * @time 下午3:08:21
	 * @author lizhen
	 */
	String fromTRItemByrnam(String rnam);
	
	/**
	 * 查询分页  通过名称
	 * @param rname
	 * @return
	 * @date 2018年2月2日
	 * @time 下午4:34:01
	 * @author lizhen
	 */
	PageInfo<TbResourceItem> findTbRIByRname(String rname,Integer pageNo,Integer pageSize);
	/**
	 * 通过id 删除
	 * @param id
	 * @date 2018年2月2日
	 * @time 下午7:15:34
	 * @author lizhen
	 */
	void deleteRItem(Integer id);
	/**
	 * 更新
	 * @param TbResourceItem
	 * @date 2018年2月2日
	 * @time 下午7:58:09
	 * @author lizhen
	 */
	void updateRItem(TbResourceItem TbResourceItem);
	/**
	 * 通过id查询
	 * @return
	 * @date 2018年2月2日
	 * @time 下午8:12:33
	 * @author lizhen
	 */
	TbResourceItem findRItemByid(Integer id);
	
	/**
	 * 查询全部
	 * @return
	 * @date 2018年2月5日
	 * @time 上午10:09:02
	 * @author lizhen
	 */
	List<TbResourceItem> findAllRItem();
	
	
	
	
	
}

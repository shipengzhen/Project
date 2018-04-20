package com.bdqn.common;

import java.io.Serializable;
import java.util.List;
import com.bdqn.sl.pojo.SysAuthority;

/**
 * @描述 资源工具类
 * @作者 施鹏振
 * @创建日期 2018年3月15日
 * @创建时间 下午8:14:27
 */
public class Menu implements Serializable {

	//存放数据
	private SysAuthority sysAuthority;
	
	//下个级别
	private List<Menu> menus;

	public SysAuthority getSysAuthority() {
		return sysAuthority;
	}

	public void setSysAuthority(SysAuthority sysAuthority) {
		this.sysAuthority = sysAuthority;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

}

package com.bdqn.sl.service;

/**
 * 角色 和 资源中间表
 * @author lizhen
 */
public interface ISysRoleAuthorityKeyService {

	/**
	 * 通过key找v 是否
	 * @param roidId
	 * @param auId
	 * @return
	 */
	String findRAbyKey(Integer roidId,Integer auId);
}

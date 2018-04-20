package com.bdqn.sl.mapper;

import com.bdqn.sl.pojo.SysRoleAuthorityExample;
import com.bdqn.sl.pojo.SysRoleAuthorityKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleAuthorityMapper {
    int countByExample(SysRoleAuthorityExample example);

    int deleteByExample(SysRoleAuthorityExample example);

    int deleteByPrimaryKey(SysRoleAuthorityKey key);

    int insert(SysRoleAuthorityKey record);

    int insertSelective(SysRoleAuthorityKey record);

    List<SysRoleAuthorityKey> selectByExample(SysRoleAuthorityExample example);

    int updateByExampleSelective(@Param("record") SysRoleAuthorityKey record, @Param("example") SysRoleAuthorityExample example);

    int updateByExample(@Param("record") SysRoleAuthorityKey record, @Param("example") SysRoleAuthorityExample example);
}
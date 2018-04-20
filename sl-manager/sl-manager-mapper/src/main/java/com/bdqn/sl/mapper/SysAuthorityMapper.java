package com.bdqn.sl.mapper;

import com.bdqn.sl.pojo.SysAuthority;
import com.bdqn.sl.pojo.SysAuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAuthorityMapper {
    int countByExample(SysAuthorityExample example);

    int deleteByExample(SysAuthorityExample example);

    int deleteByPrimaryKey(Integer authorityid);

    int insert(SysAuthority record);

    int insertSelective(SysAuthority record);

    List<SysAuthority> selectByExample(SysAuthorityExample example);

    SysAuthority selectByPrimaryKey(Integer authorityid);

    int updateByExampleSelective(@Param("record") SysAuthority record, @Param("example") SysAuthorityExample example);

    int updateByExample(@Param("record") SysAuthority record, @Param("example") SysAuthorityExample example);

    int updateByPrimaryKeySelective(SysAuthority record);

    int updateByPrimaryKey(SysAuthority record);
}
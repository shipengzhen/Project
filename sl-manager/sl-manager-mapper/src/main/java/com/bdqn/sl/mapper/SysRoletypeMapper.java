package com.bdqn.sl.mapper;

import com.bdqn.sl.pojo.SysRoletype;
import com.bdqn.sl.pojo.SysRoletypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoletypeMapper {
    int countByExample(SysRoletypeExample example);

    int deleteByExample(SysRoletypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoletype record);

    int insertSelective(SysRoletype record);

    List<SysRoletype> selectByExample(SysRoletypeExample example);

    SysRoletype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRoletype record, @Param("example") SysRoletypeExample example);

    int updateByExample(@Param("record") SysRoletype record, @Param("example") SysRoletypeExample example);

    int updateByPrimaryKeySelective(SysRoletype record);

    int updateByPrimaryKey(SysRoletype record);
}
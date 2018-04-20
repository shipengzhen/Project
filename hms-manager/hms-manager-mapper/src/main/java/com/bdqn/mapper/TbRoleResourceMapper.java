package com.bdqn.mapper;

import com.bdqn.pojo.TbRoleResourceExample;
import com.bdqn.pojo.TbRoleResourceKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRoleResourceMapper {
    int countByExample(TbRoleResourceExample example);

    int deleteByExample(TbRoleResourceExample example);

    int deleteByPrimaryKey(TbRoleResourceKey key);

    int insert(TbRoleResourceKey record);

    int insertSelective(TbRoleResourceKey record);

    List<TbRoleResourceKey> selectByExample(TbRoleResourceExample example);

    int updateByExampleSelective(@Param("record") TbRoleResourceKey record, @Param("example") TbRoleResourceExample example);

    int updateByExample(@Param("record") TbRoleResourceKey record, @Param("example") TbRoleResourceExample example);
}
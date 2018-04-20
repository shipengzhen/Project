package com.bdqn.sl.mapper;

import com.bdqn.sl.pojo.SmC;
import com.bdqn.sl.pojo.SmCExample;
import com.bdqn.sl.pojo.SmCKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmCMapper {
    int countByExample(SmCExample example);

    int deleteByExample(SmCExample example);

    int deleteByPrimaryKey(SmCKey key);

    int insert(SmC record);

    int insertSelective(SmC record);

    List<SmC> selectByExample(SmCExample example);

    SmC selectByPrimaryKey(SmCKey key);

    int updateByExampleSelective(@Param("record") SmC record, @Param("example") SmCExample example);

    int updateByExample(@Param("record") SmC record, @Param("example") SmCExample example);

    int updateByPrimaryKeySelective(SmC record);

    int updateByPrimaryKey(SmC record);
}
package com.bdqn.sl.mapper;

import com.bdqn.sl.pojo.Information;
import com.bdqn.sl.pojo.InformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InformationMapper {
    int countByExample(InformationExample example);

    int deleteByExample(InformationExample example);

    int deleteByPrimaryKey(Integer zid);

    int insert(Information record);

    int insertSelective(Information record);

    List<Information> selectByExample(InformationExample example);

    Information selectByPrimaryKey(Integer zid);

    int updateByExampleSelective(@Param("record") Information record, @Param("example") InformationExample example);

    int updateByExample(@Param("record") Information record, @Param("example") InformationExample example);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
}
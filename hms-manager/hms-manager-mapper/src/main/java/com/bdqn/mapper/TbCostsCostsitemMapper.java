package com.bdqn.mapper;

import com.bdqn.pojo.TbCostsCostsitemExample;
import com.bdqn.pojo.TbCostsCostsitemKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCostsCostsitemMapper {
    int countByExample(TbCostsCostsitemExample example);

    int deleteByExample(TbCostsCostsitemExample example);

    int deleteByPrimaryKey(TbCostsCostsitemKey key);

    int insert(TbCostsCostsitemKey record);

    int insertSelective(TbCostsCostsitemKey record);

    List<TbCostsCostsitemKey> selectByExample(TbCostsCostsitemExample example);

    int updateByExampleSelective(@Param("record") TbCostsCostsitemKey record, @Param("example") TbCostsCostsitemExample example);

    int updateByExample(@Param("record") TbCostsCostsitemKey record, @Param("example") TbCostsCostsitemExample example);
}
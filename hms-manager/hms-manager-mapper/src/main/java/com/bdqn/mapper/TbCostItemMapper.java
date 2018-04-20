package com.bdqn.mapper;

import com.bdqn.pojo.TbCostItem;
import com.bdqn.pojo.TbCostItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCostItemMapper {
    int countByExample(TbCostItemExample example);

    int deleteByExample(TbCostItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbCostItem record);

    int insertSelective(TbCostItem record);

    List<TbCostItem> selectByExample(TbCostItemExample example);

    TbCostItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbCostItem record, @Param("example") TbCostItemExample example);

    int updateByExample(@Param("record") TbCostItem record, @Param("example") TbCostItemExample example);

    int updateByPrimaryKeySelective(TbCostItem record);

    int updateByPrimaryKey(TbCostItem record);
}
package com.bdqn.sl.mapper;

import com.bdqn.sl.pojo.Commodity;
import com.bdqn.sl.pojo.CommodityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommodityMapper {
    int countByExample(CommodityExample example);

    int deleteByExample(CommodityExample example);

    int deleteByPrimaryKey(Integer commodityid);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    List<Commodity> selectByExample(CommodityExample example);

    Commodity selectByPrimaryKey(Integer commodityid);

    int updateByExampleSelective(@Param("record") Commodity record, @Param("example") CommodityExample example);

    int updateByExample(@Param("record") Commodity record, @Param("example") CommodityExample example);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);
}
package com.bdqn.sl.mapper;

import com.bdqn.sl.pojo.OrdersCS;
import com.bdqn.sl.pojo.OrdersCSExample;
import com.bdqn.sl.pojo.OrdersCSKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersCSMapper {
    int countByExample(OrdersCSExample example);

    int deleteByExample(OrdersCSExample example);

    int deleteByPrimaryKey(OrdersCSKey key);

    int insert(OrdersCS record);

    int insertSelective(OrdersCS record);

    List<OrdersCS> selectByExample(OrdersCSExample example);

    OrdersCS selectByPrimaryKey(OrdersCSKey key);

    int updateByExampleSelective(@Param("record") OrdersCS record, @Param("example") OrdersCSExample example);

    int updateByExample(@Param("record") OrdersCS record, @Param("example") OrdersCSExample example);

    int updateByPrimaryKeySelective(OrdersCS record);

    int updateByPrimaryKey(OrdersCS record);
}
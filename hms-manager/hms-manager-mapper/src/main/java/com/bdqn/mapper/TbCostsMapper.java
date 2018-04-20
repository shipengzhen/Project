package com.bdqn.mapper;

import com.bdqn.pojo.TbCosts;
import com.bdqn.pojo.TbCostsExample;
import com.bdqn.pojo.TbRegister;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCostsMapper {
    int countByExample(TbCostsExample example);

    int deleteByExample(TbCostsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbCosts record);

    int insertSelective(TbCosts record);

    List<TbCosts> selectByExample(TbCostsExample example);

    TbCosts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbCosts record, @Param("example") TbCostsExample example);

    int updateByExample(@Param("record") TbCosts record, @Param("example") TbCostsExample example);

    int updateByPrimaryKeySelective(TbCosts record);

    int updateByPrimaryKey(TbCosts record);
    
    List<TbRegister> findReList(@Param("id") Integer id,@Param("name")String name);
}
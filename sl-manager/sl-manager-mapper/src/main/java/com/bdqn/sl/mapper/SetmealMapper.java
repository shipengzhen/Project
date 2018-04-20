package com.bdqn.sl.mapper;

import com.bdqn.sl.pojo.Setmeal;
import com.bdqn.sl.pojo.SetmealExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SetmealMapper {
    int countByExample(SetmealExample example);

    int deleteByExample(SetmealExample example);

    int deleteByPrimaryKey(Integer smid);

    int insert(Setmeal record);

    int insertSelective(Setmeal record);

    List<Setmeal> selectByExample(SetmealExample example);

    Setmeal selectByPrimaryKey(Integer smid);

    int updateByExampleSelective(@Param("record") Setmeal record, @Param("example") SetmealExample example);

    int updateByExample(@Param("record") Setmeal record, @Param("example") SetmealExample example);

    int updateByPrimaryKeySelective(Setmeal record);

    int updateByPrimaryKey(Setmeal record);
}
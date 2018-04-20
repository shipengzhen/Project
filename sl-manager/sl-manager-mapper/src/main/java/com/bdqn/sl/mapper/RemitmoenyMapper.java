package com.bdqn.sl.mapper;

import com.bdqn.sl.pojo.Remitmoeny;
import com.bdqn.sl.pojo.RemitmoenyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RemitmoenyMapper {
    int countByExample(RemitmoenyExample example);

    int deleteByExample(RemitmoenyExample example);

    int deleteByPrimaryKey(Integer rmid);

    int insert(Remitmoeny record);

    int insertSelective(Remitmoeny record);

    List<Remitmoeny> selectByExample(RemitmoenyExample example);

    Remitmoeny selectByPrimaryKey(Integer rmid);

    int updateByExampleSelective(@Param("record") Remitmoeny record, @Param("example") RemitmoenyExample example);

    int updateByExample(@Param("record") Remitmoeny record, @Param("example") RemitmoenyExample example);

    int updateByPrimaryKeySelective(Remitmoeny record);

    int updateByPrimaryKey(Remitmoeny record);
}
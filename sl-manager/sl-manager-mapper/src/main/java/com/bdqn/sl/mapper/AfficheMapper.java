package com.bdqn.sl.mapper;

import com.bdqn.sl.pojo.Affiche;
import com.bdqn.sl.pojo.AfficheExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AfficheMapper {
    int countByExample(AfficheExample example);

    int deleteByExample(AfficheExample example);

    int deleteByPrimaryKey(Integer gid);

    int insert(Affiche record);

    int insertSelective(Affiche record);

    List<Affiche> selectByExample(AfficheExample example);

    Affiche selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(@Param("record") Affiche record, @Param("example") AfficheExample example);

    int updateByExample(@Param("record") Affiche record, @Param("example") AfficheExample example);

    int updateByPrimaryKeySelective(Affiche record);

    int updateByPrimaryKey(Affiche record);
}
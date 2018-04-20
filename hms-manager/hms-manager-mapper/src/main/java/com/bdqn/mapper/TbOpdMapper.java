package com.bdqn.mapper;

import com.bdqn.pojo.TbOpd;
import com.bdqn.pojo.TbOpdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOpdMapper {
    int countByExample(TbOpdExample example);

    int deleteByExample(TbOpdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbOpd record);

    int insertSelective(TbOpd record);

    List<TbOpd> selectByExample(TbOpdExample example);

    TbOpd selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbOpd record, @Param("example") TbOpdExample example);

    int updateByExample(@Param("record") TbOpd record, @Param("example") TbOpdExample example);

    int updateByPrimaryKeySelective(TbOpd record);

    int updateByPrimaryKey(TbOpd record);
}
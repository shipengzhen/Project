package com.bdqn.mapper;

import com.bdqn.pojo.TbResourceItem;
import com.bdqn.pojo.TbResourceItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbResourceItemMapper {
    int countByExample(TbResourceItemExample example);

    int deleteByExample(TbResourceItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbResourceItem record);

    int insertSelective(TbResourceItem record);

    List<TbResourceItem> selectByExample(TbResourceItemExample example);

    TbResourceItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbResourceItem record, @Param("example") TbResourceItemExample example);

    int updateByExample(@Param("record") TbResourceItem record, @Param("example") TbResourceItemExample example);

    int updateByPrimaryKeySelective(TbResourceItem record);

    int updateByPrimaryKey(TbResourceItem record);
}
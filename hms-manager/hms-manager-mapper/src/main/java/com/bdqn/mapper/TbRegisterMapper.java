package com.bdqn.mapper;

import com.bdqn.pojo.TbRegister;
import com.bdqn.pojo.TbRegisterExample;
import com.bdqn.pojo.TbRegisterSelect;

import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * 挂号
 * @author lizhen
 * @date 2018年2月22日
 * @time 下午12:21:37
 */
public interface TbRegisterMapper {
    int countByExample(TbRegisterExample example);

    int deleteByExample(TbRegisterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRegister record);

    int insertSelective(TbRegister record);

    List<TbRegister> selectByExample(TbRegisterExample example);

    TbRegister selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRegister record, @Param("example") TbRegisterExample example);

    int updateByExample(@Param("record") TbRegister record, @Param("example") TbRegisterExample example);

    int updateByPrimaryKeySelective(TbRegister record);

    int updateByPrimaryKey(TbRegister record);
    /**
     * 条件查询 
     */
    List<TbRegister> findReList(TbRegisterSelect Res);
}



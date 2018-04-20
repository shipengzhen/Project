package com.bdqn.mapper;

import com.bdqn.pojo.TbDispensing;
import com.bdqn.pojo.TbDispensingExample;
import com.bdqn.pojo.TbRegister;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDispensingMapper {
    int countByExample(TbDispensingExample example);

    int deleteByExample(TbDispensingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDispensing record);

    int insertSelective(TbDispensing record);

    List<TbDispensing> selectByExample(TbDispensingExample example);

    TbDispensing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDispensing record, @Param("example") TbDispensingExample example);

    int updateByExample(@Param("record") TbDispensing record, @Param("example") TbDispensingExample example);

    int updateByPrimaryKeySelective(TbDispensing record);

    int updateByPrimaryKey(TbDispensing record);
    /**
     * 在院 发药  首页 列表
     * @return
     * @date 2018年2月23日
     * @time 下午10:37:10
     * @author lizhen
     */
    List<TbRegister> findReListDi(@Param("id") Integer id);
    /**
     * 在院发药 look看
     */
    
    List<TbRegister> findLookRe(@Param("id") Integer id);
    
    
}
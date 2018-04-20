package com.bdqn.mapper;

import com.bdqn.pojo.TbBeHospitalized;
import com.bdqn.pojo.TbBeHospitalizedExample;
import com.bdqn.pojo.TbCostItem;
import com.bdqn.pojo.TbRegister;
import com.bdqn.pojo.TbRegisterSelect;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbBeHospitalizedMapper {
    int countByExample(TbBeHospitalizedExample example);

    int deleteByExample(TbBeHospitalizedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbBeHospitalized record);

    int insertSelective(TbBeHospitalized record);

    List<TbBeHospitalized> selectByExample(TbBeHospitalizedExample example);

    TbBeHospitalized selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbBeHospitalized record, @Param("example") TbBeHospitalizedExample example);

    int updateByExample(@Param("record") TbBeHospitalized record, @Param("example") TbBeHospitalizedExample example);

    int updateByPrimaryKeySelective(TbBeHospitalized record);

    int updateByPrimaryKey(TbBeHospitalized record);
    /**
     * 条件查询
     */
    List<TbRegister> finHosList(TbRegisterSelect Res);
    
    /**
     * 查看 结算
     */
    List<TbCostItem> findCostItem(Integer rid);
    
}
package com.bdqn.mapper;

import com.bdqn.pojo.TbMedicine;
import com.bdqn.pojo.TbMedicineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbMedicineMapper {
    int countByExample(TbMedicineExample example);

    int deleteByExample(TbMedicineExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbMedicine record);

    int insertSelective(TbMedicine record);

    List<TbMedicine> selectByExample(TbMedicineExample example);

    TbMedicine selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbMedicine record, @Param("example") TbMedicineExample example);

    int updateByExample(@Param("record") TbMedicine record, @Param("example") TbMedicineExample example);

    int updateByPrimaryKeySelective(TbMedicine record);

    int updateByPrimaryKey(TbMedicine record);
}
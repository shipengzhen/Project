package com.bdqn.mapper;

import com.bdqn.pojo.TbDoctors;
import com.bdqn.pojo.TbDoctorsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDoctorsMapper {
    int countByExample(TbDoctorsExample example);

    int deleteByExample(TbDoctorsExample example);

    int deleteByPrimaryKey(Integer doctorid);

    int insert(TbDoctors record);

    int insertSelective(TbDoctors record);

    List<TbDoctors> selectByExample(TbDoctorsExample example);

    TbDoctors selectByPrimaryKey(Integer doctorid);

    int updateByExampleSelective(@Param("record") TbDoctors record, @Param("example") TbDoctorsExample example);

    int updateByExample(@Param("record") TbDoctors record, @Param("example") TbDoctorsExample example);

    int updateByPrimaryKeySelective(TbDoctors record);

    int updateByPrimaryKey(TbDoctors record);
    
    List<TbDoctors> selectTbDoctorList(@Param("doctorid")Integer doctorid,
    					@Param("doctorname") String doctorname,
    					@Param("name")String name);
}
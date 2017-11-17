package com.gsccs.sme.plat.rtable.dao;

import com.gsccs.sme.plat.rtable.model.WaterUse;
import com.gsccs.sme.plat.rtable.model.WaterUseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterUseMapper {
    int countByExample(WaterUseExample example);

    int deleteByExample(WaterUseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterUse record);

    int insertSelective(WaterUse record);

    List<WaterUse> selectByExample(WaterUseExample example);

    WaterUse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterUse record, @Param("example") WaterUseExample example);

    int updateByExample(@Param("record") WaterUse record, @Param("example") WaterUseExample example);

    int updateByPrimaryKeySelective(WaterUse record);

    int updateByPrimaryKey(WaterUse record);

	List<WaterUse> selectPageByExample(WaterUseExample example);
}
package com.gsccs.sme.plat.rtable.dao;

import com.gsccs.sme.plat.rtable.model.WaterTake;
import com.gsccs.sme.plat.rtable.model.WaterTakeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterTakeMapper {
    int countByExample(WaterTakeExample example);

    int deleteByExample(WaterTakeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterTake record);

    int insertSelective(WaterTake record);

    List<WaterTake> selectByExample(WaterTakeExample example);

    WaterTake selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterTake record, @Param("example") WaterTakeExample example);

    int updateByExample(@Param("record") WaterTake record, @Param("example") WaterTakeExample example);

    int updateByPrimaryKeySelective(WaterTake record);

    int updateByPrimaryKey(WaterTake record);

	List<WaterTake> selectPageByExample(WaterTakeExample example);
}
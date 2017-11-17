package com.gsccs.sme.plat.rtable.dao;

import com.gsccs.sme.plat.rtable.model.WaterMain;
import com.gsccs.sme.plat.rtable.model.WaterMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterMainMapper {
    int countByExample(WaterMainExample example);

    int deleteByExample(WaterMainExample example);

    int deleteByPrimaryKey(String mainid);

    int insert(WaterMain record);

    int insertSelective(WaterMain record);

    List<WaterMain> selectByExample(WaterMainExample example);

    WaterMain selectByPrimaryKey(String mainid);

    int updateByExampleSelective(@Param("record") WaterMain record, @Param("example") WaterMainExample example);

    int updateByExample(@Param("record") WaterMain record, @Param("example") WaterMainExample example);

    int updateByPrimaryKeySelective(WaterMain record);

    int updateByPrimaryKey(WaterMain record);

	List<WaterMain> selectPageByExample(WaterMainExample example);
}
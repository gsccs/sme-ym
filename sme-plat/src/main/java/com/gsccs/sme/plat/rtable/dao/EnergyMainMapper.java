package com.gsccs.sme.plat.rtable.dao;

import com.gsccs.sme.plat.rtable.model.EnergyMain;
import com.gsccs.sme.plat.rtable.model.EnergyMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnergyMainMapper {
    int countByExample(EnergyMainExample example);

    int deleteByExample(EnergyMainExample example);

    int deleteByPrimaryKey(String mainId);

    int insert(EnergyMain record);

    int insertSelective(EnergyMain record);

    List<EnergyMain> selectByExample(EnergyMainExample example);

    EnergyMain selectByPrimaryKey(String mainId);

    int updateByExampleSelective(@Param("record") EnergyMain record, @Param("example") EnergyMainExample example);

    int updateByExample(@Param("record") EnergyMain record, @Param("example") EnergyMainExample example);

    int updateByPrimaryKeySelective(EnergyMain record);

    int updateByPrimaryKey(EnergyMain record);

	List<EnergyMain> selectPageByExample(EnergyMainExample example);
}
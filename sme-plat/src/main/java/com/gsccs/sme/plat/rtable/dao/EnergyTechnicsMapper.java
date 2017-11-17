package com.gsccs.sme.plat.rtable.dao;

import com.gsccs.sme.plat.rtable.model.EnergyTechnics;
import com.gsccs.sme.plat.rtable.model.EnergyTechnicsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnergyTechnicsMapper {
    int countByExample(EnergyTechnicsExample example);

    int deleteByExample(EnergyTechnicsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EnergyTechnics record);

    int insertSelective(EnergyTechnics record);

    List<EnergyTechnics> selectByExample(EnergyTechnicsExample example);

    EnergyTechnics selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EnergyTechnics record, @Param("example") EnergyTechnicsExample example);

    int updateByExample(@Param("record") EnergyTechnics record, @Param("example") EnergyTechnicsExample example);

    int updateByPrimaryKeySelective(EnergyTechnics record);

    int updateByPrimaryKey(EnergyTechnics record);

	List<EnergyTechnics> selectPageByExample(EnergyTechnicsExample example);
}
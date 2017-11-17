package com.gsccs.sme.plat.rtable.dao;

import com.gsccs.sme.plat.rtable.model.EnergyProduct;
import com.gsccs.sme.plat.rtable.model.EnergyProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnergyProductMapper {
    int countByExample(EnergyProductExample example);

    int deleteByExample(EnergyProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EnergyProduct record);

    int insertSelective(EnergyProduct record);

    List<EnergyProduct> selectByExample(EnergyProductExample example);

    EnergyProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EnergyProduct record, @Param("example") EnergyProductExample example);

    int updateByExample(@Param("record") EnergyProduct record, @Param("example") EnergyProductExample example);

    int updateByPrimaryKeySelective(EnergyProduct record);

    int updateByPrimaryKey(EnergyProduct record);

	List<EnergyProduct> selectPageByExample(EnergyProductExample example);
}
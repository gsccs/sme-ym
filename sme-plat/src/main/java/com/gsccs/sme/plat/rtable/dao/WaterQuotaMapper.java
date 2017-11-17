package com.gsccs.sme.plat.rtable.dao;

import com.gsccs.sme.plat.rtable.model.WaterQuota;
import com.gsccs.sme.plat.rtable.model.WaterQuotaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterQuotaMapper {
    int countByExample(WaterQuotaExample example);

    int deleteByExample(WaterQuotaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterQuota record);

    int insertSelective(WaterQuota record);

    List<WaterQuota> selectByExample(WaterQuotaExample example);

    WaterQuota selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterQuota record, @Param("example") WaterQuotaExample example);

    int updateByExample(@Param("record") WaterQuota record, @Param("example") WaterQuotaExample example);

    int updateByPrimaryKeySelective(WaterQuota record);

    int updateByPrimaryKey(WaterQuota record);

	List<WaterQuota> selectPageByExample(WaterQuotaExample example);
}
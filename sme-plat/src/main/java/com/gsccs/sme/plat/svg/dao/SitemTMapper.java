package com.gsccs.sme.plat.svg.dao;

import com.gsccs.sme.plat.svg.model.SitemT;
import com.gsccs.sme.plat.svg.model.SitemTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SitemTMapper {
    int countByExample(SitemTExample example);

    int deleteByExample(SitemTExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SitemT record);

    int insertSelective(SitemT record);

    List<SitemT> selectByExampleWithBLOBs(SitemTExample example);

    List<SitemT> selectByExample(SitemTExample example);

    SitemT selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SitemT record, @Param("example") SitemTExample example);

    int updateByExampleWithBLOBs(@Param("record") SitemT record, @Param("example") SitemTExample example);

    int updateByExample(@Param("record") SitemT record, @Param("example") SitemTExample example);

    int updateByPrimaryKeySelective(SitemT record);

    int updateByPrimaryKeyWithBLOBs(SitemT record);

    int updateByPrimaryKey(SitemT record);

	List<SitemT> selectPageByExample(SitemTExample example);
}
package com.gsccs.sme.plat.rtable.dao;

import com.gsccs.sme.plat.rtable.model.SolidMain;
import com.gsccs.sme.plat.rtable.model.SolidMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SolidMainMapper {
    int countByExample(SolidMainExample example);

    int deleteByExample(SolidMainExample example);

    int deleteByPrimaryKey(String mainid);

    int insert(SolidMain record);

    int insertSelective(SolidMain record);

    List<SolidMain> selectByExample(SolidMainExample example);

    SolidMain selectByPrimaryKey(String mainid);

    int updateByExampleSelective(@Param("record") SolidMain record, @Param("example") SolidMainExample example);

    int updateByExample(@Param("record") SolidMain record, @Param("example") SolidMainExample example);

    int updateByPrimaryKeySelective(SolidMain record);

    int updateByPrimaryKey(SolidMain record);

	List<SolidMain> selectPageByExample(SolidMainExample example);
}
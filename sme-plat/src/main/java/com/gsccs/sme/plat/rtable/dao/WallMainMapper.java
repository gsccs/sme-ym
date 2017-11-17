package com.gsccs.sme.plat.rtable.dao;

import com.gsccs.sme.plat.rtable.model.WallMain;
import com.gsccs.sme.plat.rtable.model.WallMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WallMainMapper {
    int countByExample(WallMainExample example);

    int deleteByExample(WallMainExample example);

    int deleteByPrimaryKey(String mainid);

    int insert(WallMain record);

    int insertSelective(WallMain record);

    List<WallMain> selectByExample(WallMainExample example);

    WallMain selectByPrimaryKey(String mainid);

    int updateByExampleSelective(@Param("record") WallMain record, @Param("example") WallMainExample example);

    int updateByExample(@Param("record") WallMain record, @Param("example") WallMainExample example);

    int updateByPrimaryKeySelective(WallMain record);

    int updateByPrimaryKey(WallMain record);

	List<WallMain> selectPageByExample(WallMainExample example);
}
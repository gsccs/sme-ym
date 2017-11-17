package com.gsccs.sme.plat.rtable.dao;

import com.gsccs.sme.plat.rtable.model.WallContent;
import com.gsccs.sme.plat.rtable.model.WallContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WallContentMapper {
    int countByExample(WallContentExample example);

    int deleteByExample(WallContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WallContent record);

    int insertSelective(WallContent record);

    List<WallContent> selectByExample(WallContentExample example);

    WallContent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WallContent record, @Param("example") WallContentExample example);

    int updateByExample(@Param("record") WallContent record, @Param("example") WallContentExample example);

    int updateByPrimaryKeySelective(WallContent record);

    int updateByPrimaryKey(WallContent record);

	List<WallContent> selectPageByExample(WallContentExample example);
}
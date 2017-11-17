package com.gsccs.sme.plat.rtable.dao;

import com.gsccs.sme.plat.rtable.model.SolidContent;
import com.gsccs.sme.plat.rtable.model.SolidContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SolidContentMapper {
    int countByExample(SolidContentExample example);

    int deleteByExample(SolidContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SolidContent record);

    int insertSelective(SolidContent record);

    List<SolidContent> selectByExample(SolidContentExample example);

    SolidContent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SolidContent record, @Param("example") SolidContentExample example);

    int updateByExample(@Param("record") SolidContent record, @Param("example") SolidContentExample example);

    int updateByPrimaryKeySelective(SolidContent record);

    int updateByPrimaryKey(SolidContent record);

	List<SolidContent> selectPageByExample(SolidContentExample example);
}
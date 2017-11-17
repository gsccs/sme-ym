package com.gsccs.sme.plat.site.dao;

import com.gsccs.sme.plat.site.model.LinkT;
import com.gsccs.sme.plat.site.model.LinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LinkMapper {
    int countByExample(LinkExample example);

    int deleteByExample(LinkExample example);

    int deleteByPrimaryKey(String id);

    int insert(LinkT record);

    List<LinkT> selectByExample(LinkExample example);
    List<LinkT> selectPageByExample(LinkExample example);
    
    LinkT selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LinkT record, @Param("example") LinkExample example);

    int updateByExample(@Param("record") LinkT record, @Param("example") LinkExample example);

    int updateByPrimaryKeySelective(LinkT record);

    int updateByPrimaryKey(LinkT record);

	List<LinkT> selectByPageExample(LinkExample example);
}
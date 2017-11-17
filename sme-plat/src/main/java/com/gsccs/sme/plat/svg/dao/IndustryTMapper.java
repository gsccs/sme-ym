package com.gsccs.sme.plat.svg.dao;

import com.gsccs.sme.plat.svg.model.IndustryT;
import com.gsccs.sme.plat.svg.model.IndustryTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndustryTMapper {

	int countByExample(IndustryTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(IndustryT record);

	List<IndustryT> selectByExample(IndustryTExample example);

	List<IndustryT> selectPageByExample(IndustryTExample example);

	IndustryT selectByPrimaryKey(Long id);

	int updateByPrimaryKey(IndustryT record);
}
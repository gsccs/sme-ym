package com.gsccs.sme.plat.svg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.sme.plat.svg.model.ExpertT;
import com.gsccs.sme.plat.svg.model.ExpertTExample;

public interface ExpertTMapper {
	int countByExample(ExpertTExample example);

	int deleteByExample(ExpertTExample example);

	int deleteByPrimaryKey(String id);

	int insert(ExpertT record);

	List<ExpertT> selectByExample(ExpertTExample example);

	List<ExpertT> selectPageByExample(ExpertTExample example);

	ExpertT selectByPrimaryKey(String id);

	int updateByExample(@Param("record") ExpertT record,
			@Param("example") ExpertTExample example);

	int updateByPrimaryKey(ExpertT record);
}
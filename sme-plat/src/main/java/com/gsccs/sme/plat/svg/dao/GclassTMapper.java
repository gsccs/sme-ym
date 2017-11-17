package com.gsccs.sme.plat.svg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.sme.api.domain.StatistGroup;
import com.gsccs.sme.plat.svg.model.GclassT;
import com.gsccs.sme.plat.svg.model.GclassTExample;

public interface GclassTMapper {
	
	int countByExample(GclassTExample example);

	int deleteByExample(GclassTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GclassT record);

	List<GclassT> selectByExample(GclassTExample example);

	List<GclassT> selectByPageExample(GclassTExample example);

	GclassT selectByPrimaryKey(Long id);

	int updateByExample(@Param("record") GclassT record,
			@Param("example") GclassTExample example);

	int updateByPrimaryKey(GclassT record);
	
	List<StatistGroup> selectTopicNumGroup();

}
package com.gsccs.sme.plat.svg.dao;

import com.gsccs.sme.api.domain.StatistGroup;
import com.gsccs.sme.plat.svg.model.SclassT;
import com.gsccs.sme.plat.svg.model.SclassTExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SclassTMapper {
	
	int countByExample(SclassTExample example);

	int deleteByExample(SclassTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SclassT record);

	List<SclassT> selectByExample(SclassTExample example);

	List<SclassT> selectByPageExample(SclassTExample example);

	SclassT selectByPrimaryKey(Long id);

	int updateByExample(@Param("record") SclassT record,
			@Param("example") SclassTExample example);

	int updateByPrimaryKey(SclassT record);
	
	List<StatistGroup> selectTopicNumGroup();

}
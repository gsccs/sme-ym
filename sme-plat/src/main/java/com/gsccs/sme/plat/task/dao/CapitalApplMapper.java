package com.gsccs.sme.plat.task.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.sme.api.domain.CapitalAppl;
import com.gsccs.sme.plat.task.model.CapitalApplExample;

public interface CapitalApplMapper {
	int countByExample(CapitalApplExample example);

	int deleteByExample(CapitalApplExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CapitalAppl record);

	int insertSelective(CapitalAppl record);
	List<CapitalAppl> selectReplyedsByExample(CapitalApplExample example);
	List<CapitalAppl> selectPageByExample(CapitalApplExample example);

	CapitalAppl selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CapitalAppl record,
			@Param("example") CapitalApplExample example);

	int updateByExample(@Param("record") CapitalAppl record,
			@Param("example") CapitalApplExample example);

	int updateByPrimaryKeySelective(CapitalAppl record);

	int updateByPrimaryKey(CapitalAppl record);
}
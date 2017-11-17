package com.gsccs.sme.plat.svg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.plat.svg.model.SneedExample;

public interface SneedMapper {

	int countByExample(SneedExample example);

	int deleteByExample(SneedExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Sneed record);

	List<Sneed> selectByExampleWithBLOBs(SneedExample example);

	List<Sneed> selectByExample(SneedExample example);

	List<Sneed> selectPageByExample(SneedExample example);

	Sneed selectByPrimaryKey(Long id);

	int updateByExampleWithBLOBs(@Param("record") Sneed record,
			@Param("example") SneedExample example);

	int updateByExample(@Param("record") Sneed record,
			@Param("example") SneedExample example);

	int updateByPrimaryKeyWithBLOBs(Sneed record);

	int updateByPrimaryKey(Sneed record);
}
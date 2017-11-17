package com.gsccs.sme.plat.rtable.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.sme.api.domain.report.Report;
import com.gsccs.sme.plat.rtable.model.ReportExample;

public interface ReportMapper {
	
	int countByExample(ReportExample example);

	int deleteByExample(ReportExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Report record);

	List<Report> selectPageByExample(ReportExample example);

	Report selectByPrimaryKey(Long id);

	int updateByExample(@Param("record") Report record,
			@Param("example") ReportExample example);

	int updateByPrimaryKey(Report record);
}
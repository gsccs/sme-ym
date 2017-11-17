package com.gsccs.sme.plat.rtable.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.sme.api.domain.report.ReportItem;
import com.gsccs.sme.plat.rtable.model.ReportItemExample;

public interface ReportItemMapper {

	int countByExample(ReportItemExample example);

	int deleteByExample(ReportItemExample example);

	int deleteByPrimaryKey(String id);

	int insert(ReportItem record);

	List<ReportItem> selectPageByExample(ReportItemExample example);

	ReportItem selectByPrimaryKey(String id);

	int updateByExample(@Param("record") ReportItem record,
			@Param("example") ReportItemExample example);

	int updateByPrimaryKeySelective(ReportItem record);

	int updateByPrimaryKey(ReportItem record);
}
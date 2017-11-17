package com.gsccs.sme.plat.svg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.sme.api.domain.corp.Consult;
import com.gsccs.sme.plat.svg.model.ConsultExample;

public interface ConsultMapper {
	
	
	int countByExample(ConsultExample example);

	int deleteByExample(ConsultExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Consult record);

	List<Consult> selectPageByExample(ConsultExample example);
	List<Consult> selectReplyByCorp(ConsultExample example);
	
	Consult selectByPrimaryKey(Long id);

	int updateByExample(@Param("record") Consult record,
			@Param("example") ConsultExample example);

	int updateByPrimaryKeySelective(Consult record);
}
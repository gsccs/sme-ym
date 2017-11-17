package com.gsccs.sme.plat.corp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.sme.api.domain.corp.CorpEnergy;
import com.gsccs.sme.plat.corp.model.CorpEnergyExample;

public interface CorpEnergyMapper {
	
	int countByExample(CorpEnergyExample example);

	int deleteByExample(CorpEnergyExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CorpEnergy record);

	int insertSelective(CorpEnergy record);

	List<CorpEnergy> selectByExample(CorpEnergyExample example);

	CorpEnergy selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CorpEnergy record,
			@Param("example") CorpEnergyExample example);

	int updateByExample(@Param("record") CorpEnergy record,
			@Param("example") CorpEnergyExample example);

	int updateByPrimaryKeySelective(CorpEnergy record);

	int updateByPrimaryKey(CorpEnergy record);
}
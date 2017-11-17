package com.gsccs.sme.plat.svg.dao;

import java.util.List;

import com.gsccs.sme.api.domain.StatistGovNum;
import com.gsccs.sme.api.domain.StatistGroup;
import com.gsccs.sme.plat.svg.model.AppealItemT;
import com.gsccs.sme.plat.svg.model.AppealItemTExample;


public interface AppealItemTMapper {
	
	int countByExample(AppealItemTExample example);

	int deleteByExample(AppealItemTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(AppealItemT record);

	List<AppealItemT> selectPageByExample(AppealItemTExample example);

	AppealItemT selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(AppealItemT record);
	int updateByPrimaryKey(AppealItemT record);
	
	List<StatistGovNum> selectStatBySvg();
}
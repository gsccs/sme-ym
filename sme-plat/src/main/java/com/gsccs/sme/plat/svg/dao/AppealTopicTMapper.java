package com.gsccs.sme.plat.svg.dao;

import java.util.List;

import com.gsccs.sme.plat.svg.model.AppealTopicT;
import com.gsccs.sme.plat.svg.model.AppealTopicTExample;

public interface AppealTopicTMapper {

	int countByExample(AppealTopicTExample example);

	int deleteByExample(AppealTopicTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(AppealTopicT record);

	List<AppealTopicT> selectPageByExample(AppealTopicTExample example);

	AppealTopicT selectByPrimaryKey(Long id);

	int updateByPrimaryKeyWithBLOBs(AppealTopicT record);

	int updateByPrimaryKey(AppealTopicT record);
}
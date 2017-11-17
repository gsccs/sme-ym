package com.gsccs.sme.plat.svg.dao;

import java.util.List;

import com.gsccs.sme.plat.svg.model.AppealAttachT;
import com.gsccs.sme.plat.svg.model.AppealAttachTExample;

public interface AppealAttachTMapper {
	
	int countByExample(AppealAttachTExample example);

	int deleteByExample(AppealAttachTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(AppealAttachT record);

	List<AppealAttachT> selectByExample(AppealAttachTExample example);

	AppealAttachT selectByPrimaryKey(Long id);

	int updateByPrimaryKey(AppealAttachT record);
}
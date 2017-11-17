package com.gsccs.sme.plat.svg.dao;

import com.gsccs.sme.plat.svg.model.AppealPushT;
import com.gsccs.sme.plat.svg.model.AppealPushTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppealPushTMapper {

	int countByExample(AppealPushTExample example);

	int deleteByExample(AppealPushTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(AppealPushT record);

	List<AppealPushT> selectByExample(AppealPushTExample example);

	AppealPushT selectByPrimaryKey(Long id);

	int updateByExample(@Param("record") AppealPushT record,
			@Param("example") AppealPushTExample example);

	int updateByPrimaryKey(AppealPushT record);
}
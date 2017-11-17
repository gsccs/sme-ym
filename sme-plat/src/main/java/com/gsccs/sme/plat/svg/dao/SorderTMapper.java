package com.gsccs.sme.plat.svg.dao;

import com.gsccs.sme.plat.svg.model.SorderT;
import com.gsccs.sme.plat.svg.model.SorderTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SorderTMapper {

	int countByExample(SorderTExample example);

	int deleteByExample(SorderTExample example);

	int deleteByPrimaryKey(String id);

	int insert(SorderT record);

	List<SorderT> selectByExample(SorderTExample example);

	List<SorderT> selectPageByExample(SorderTExample example);

	SorderT selectByPrimaryKey(String id);

	int updateByPrimaryKey(SorderT record);
}
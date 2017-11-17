package com.gsccs.sme.plat.auth.dao;

import com.gsccs.sme.plat.auth.model.DictItemT;
import com.gsccs.sme.plat.auth.model.DictItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictItemTMapper {
	
	int countByExample(DictItemExample example);

	int deleteByExample(DictItemExample example);

	int deleteByPrimaryKey(String id);

	int insert(DictItemT record);

	List<DictItemT> selectByExample(DictItemExample example);

	DictItemT selectByPrimaryKey(String id);

	int updateByExample(@Param("record") DictItemT record,
			@Param("example") DictItemExample example);

	int updateByPrimaryKey(DictItemT record);

	List<DictItemT> selectGroupAndItemList(DictItemExample example);
}
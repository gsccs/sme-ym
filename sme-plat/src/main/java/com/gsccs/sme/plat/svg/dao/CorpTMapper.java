package com.gsccs.sme.plat.svg.dao;

import com.gsccs.sme.plat.svg.model.CorpT;
import com.gsccs.sme.plat.svg.model.CorpTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CorpTMapper {

	int countByExample(CorpTExample example);

	int deleteByExample(CorpTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CorpT record);

	List<CorpT> selectByExampleWithBLOBs(CorpTExample example);

	List<CorpT> selectByExample(CorpTExample example);

	List<CorpT> selectPageByExample(CorpTExample example);

	CorpT selectByPrimaryKey(Long id);

	int updateByExampleWithBLOBs(@Param("record") CorpT record,
			@Param("example") CorpTExample example);

	int updateByExample(@Param("record") CorpT record,
			@Param("example") CorpTExample example);

	int updateByPrimaryKeyWithBLOBs(CorpT record);

	int updateByPrimaryKey(CorpT record);

	List<CorpT> selectByExample(CorpT corpT);
}
package com.gsccs.sme.plat.svg.dao;

import com.gsccs.sme.plat.svg.model.DeclareItemT;
import com.gsccs.sme.plat.svg.model.DeclareItemTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeclareItemTMapper {

	int countByExample(DeclareItemTExample example);

	int deleteByExample(DeclareItemTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(DeclareItemT record);

	List<DeclareItemT> selectPageByExample(DeclareItemTExample example);

	List<DeclareItemT> selectCorpDeclares(DeclareItemTExample example);

	DeclareItemT selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") DeclareItemT record,
			@Param("example") DeclareItemTExample example);

	int updateByExample(@Param("record") DeclareItemT record,
			@Param("example") DeclareItemTExample example);

	int updateByPrimaryKeySelective(DeclareItemT record);

	int updateByPrimaryKey(DeclareItemT record);
}
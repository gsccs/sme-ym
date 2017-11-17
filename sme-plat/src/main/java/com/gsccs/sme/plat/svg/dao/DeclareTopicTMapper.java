package com.gsccs.sme.plat.svg.dao;

import com.gsccs.sme.plat.svg.model.DeclareTopicT;
import com.gsccs.sme.plat.svg.model.DeclareTopicTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeclareTopicTMapper {
	int countByExample(DeclareTopicTExample example);

	int deleteByExample(DeclareTopicTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(DeclareTopicT record);

	int insertSelective(DeclareTopicT record);

	List<DeclareTopicT> selectByExampleWithBLOBs(DeclareTopicTExample example);

	List<DeclareTopicT> selectByExample(DeclareTopicTExample example);

	List<DeclareTopicT> selectPageByExample(DeclareTopicTExample example);

	DeclareTopicT selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") DeclareTopicT record,
			@Param("example") DeclareTopicTExample example);

	int updateByExampleWithBLOBs(@Param("record") DeclareTopicT record,
			@Param("example") DeclareTopicTExample example);

	int updateByExample(@Param("record") DeclareTopicT record,
			@Param("example") DeclareTopicTExample example);

	int updateByPrimaryKeySelective(DeclareTopicT record);

	int updateByPrimaryKeyWithBLOBs(DeclareTopicT record);

	int updateByPrimaryKey(DeclareTopicT record);
}
package com.gsccs.sme.plat.rtable.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.sme.plat.rtable.model.PropT;
import com.gsccs.sme.plat.rtable.model.PropTExample;

public interface PropTMapper {

	int countByExample(PropTExample example);

	int deleteByExample(PropTExample example);

	int deleteByPrimaryKey(String id);

	int insert(PropT record);

	int insertSelective(PropT record);

	List<PropT> selectPageByExample(PropTExample example);

	PropT selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") PropT record,
			@Param("example") PropTExample example);

	int updateByExample(@Param("record") PropT record,
			@Param("example") PropTExample example);

	int updateByPrimaryKeySelective(PropT record);

	int updateByPrimaryKey(PropT record);
}
package com.gsccs.sme.plat.rtable.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.sme.plat.rtable.model.PropvalT;
import com.gsccs.sme.plat.rtable.model.PropvalTExample;

public interface PropvalTMapper {

	int countByExample(PropvalTExample example);

	int deleteByExample(PropvalTExample example);

	int deleteByPrimaryKey(String id);

	int insert(PropvalT record);

	List<PropvalT> selectByExample(PropvalTExample example);

	List<PropvalT> selectCorpProductProps(@Param("productid") String productid,
			@Param("corpid") String corpid);

	List<PropvalT> selectCorpProps(@Param("corpid") String corpid);

	List<PropvalT> selectPageByExample(PropvalTExample example);

	PropvalT selectByPrimaryKey(String id);

	int updateByExample(@Param("record") PropvalT record,
			@Param("example") PropvalTExample example);

	int updateByPrimaryKey(PropvalT record);
}
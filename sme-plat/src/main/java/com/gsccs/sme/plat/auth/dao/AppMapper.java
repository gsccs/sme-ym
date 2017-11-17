package com.gsccs.sme.plat.auth.dao;

import com.gsccs.sme.plat.auth.model.App;
import com.gsccs.sme.plat.auth.model.AppExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AppMapper {

	int countByExample(AppExample example);

	int deleteByExample(AppExample example);

	int deleteByPrimaryKey(Long id);

	int insert(App record);

	int insertSelective(App record);

	List<App> selectByExample(AppExample example);
	List<App> selectPageByExample(AppExample example);

	App selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") App record,
			@Param("example") AppExample example);

	int updateByExample(@Param("record") App record,
			@Param("example") AppExample example);

	int updateByPrimaryKeySelective(App record);

	int updateByPrimaryKey(App record);
}
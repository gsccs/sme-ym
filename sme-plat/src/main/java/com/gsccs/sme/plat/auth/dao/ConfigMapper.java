package com.gsccs.sme.plat.auth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.sme.plat.auth.model.Config;
import com.gsccs.sme.plat.auth.model.ConfigExample;

public interface ConfigMapper {

	int countByExample(ConfigExample example);

	int deleteByExample(ConfigExample example);

	int deleteByPrimaryKey(String code);

	int insert(Config record);

	int insertSelective(Config record);

	List<Config> selectByExample(ConfigExample example);

	Config selectByPrimaryKey(String code);

	int updateByExampleSelective(@Param("record") Config record,
			@Param("example") ConfigExample example);

	int updateByExample(@Param("record") Config record,
			@Param("example") ConfigExample example);

	int updateByPrimaryKeySelective(Config record);

	int updateByPrimaryKey(Config record);

	int updateByCode(Config record);
}
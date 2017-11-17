package com.gsccs.sme.plat.auth.dao;

import com.gsccs.sme.plat.auth.model.Authorization;
import com.gsccs.sme.plat.auth.model.AuthorizationExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AuthorizationMapper {

	int countByExample(AuthorizationExample example);

	int deleteByExample(AuthorizationExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Authorization record);

	int insertSelective(Authorization record);

	List<Authorization> selectByExample(AuthorizationExample example);

	Authorization selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Authorization record,
			@Param("example") AuthorizationExample example);

	int updateByExample(@Param("record") Authorization record,
			@Param("example") AuthorizationExample example);

	int updateByPrimaryKeySelective(Authorization record);

	int updateByPrimaryKey(Authorization record);
}
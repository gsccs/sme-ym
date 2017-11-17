package com.gsccs.sme.plat.auth.dao;

import com.gsccs.sme.plat.auth.model.Role;
import com.gsccs.sme.plat.auth.model.RoleExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RoleMapper {

	int countByExample(RoleExample example);

	int deleteByExample(RoleExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Role record);

	List<Role> selectByExample(RoleExample example);

	Role selectByPrimaryKey(Long id);
	
	Role selectByCode(String rolecode);

	int updateByExampleSelective(@Param("record") Role record,
			@Param("example") RoleExample example);

	int updateByExample(@Param("record") Role record,
			@Param("example") RoleExample example);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);
}
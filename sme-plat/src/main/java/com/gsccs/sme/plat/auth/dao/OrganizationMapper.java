package com.gsccs.sme.plat.auth.dao;

import com.gsccs.sme.plat.auth.model.Organization;
import com.gsccs.sme.plat.auth.model.OrganizationExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrganizationMapper {

	int countByExample(OrganizationExample example);

	int deleteByExample(OrganizationExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Organization record);

	int insertSelective(Organization record);

	List<Organization> selectByExample(OrganizationExample example);

	Organization selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Organization record,
			@Param("example") OrganizationExample example);

	int updateByExample(@Param("record") Organization record,
			@Param("example") OrganizationExample example);

	int updateByPrimaryKeySelective(Organization record);

	int updateByPrimaryKey(Organization record);
}
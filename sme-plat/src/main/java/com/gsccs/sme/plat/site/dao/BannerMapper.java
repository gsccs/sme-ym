package com.gsccs.sme.plat.site.dao;

import com.gsccs.sme.plat.site.model.BannerT;
import com.gsccs.sme.plat.site.model.BannerExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BannerMapper {
	int countByExample(BannerExample example);

	int deleteByExample(BannerExample example);

	int deleteByPrimaryKey(String id);

	int insert(BannerT record);

	int insertSelective(BannerT record);

	List<BannerT> selectPageByExample(BannerExample example);

	BannerT selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") BannerT record,
			@Param("example") BannerExample example);

	int updateByExample(@Param("record") BannerT record,
			@Param("example") BannerExample example);

	int updateByPrimaryKeySelective(BannerT record);

	int updateByPrimaryKey(BannerT record);
}
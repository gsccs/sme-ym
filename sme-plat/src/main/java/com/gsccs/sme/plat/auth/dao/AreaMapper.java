package com.gsccs.sme.plat.auth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.sme.plat.auth.model.AreaExample;
import com.gsccs.sme.plat.auth.model.AreaT;

/**
 * @说明 省份&城市&区&街道 数据操作
 * @开发者 ma hong
 * @年月日 2015年4月16日
 * @时分秒 上午11:39:48
 */
public interface AreaMapper {

	int countByExample(AreaExample example);

	int deleteByExample(AreaExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(AreaT record);

	int insertSelective(AreaT record);

	List<AreaT> selectByExample(AreaExample example);

	List<AreaT> selectPageByExample(AreaExample example);

	AreaT selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") AreaT record,
			@Param("example") AreaExample example);

	int updateByExample(@Param("record") AreaT record,
			@Param("example") AreaExample example);

	int updateByPrimaryKeySelective(AreaT record);

	int updateByPrimaryKey(AreaT record);

	/* 查询出所有省份&直辖市 */
	List<AreaT> selectByParId(Integer parentid);
	
	AreaT selectByCode(Integer code);

}
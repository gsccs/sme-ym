package com.gsccs.sme.plat.svg.dao;

import com.gsccs.sme.plat.svg.model.SvorgT;
import com.gsccs.sme.plat.svg.model.SvorgTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SvorgTMapper {

	int countByExample(SvorgTExample example);

	int deleteByExample(SvorgTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SvorgT record);

	List<SvorgT> selectPageByExample(SvorgTExample example);
	
	List<SvorgT> querySvgByItem(SvorgTExample example);

	SvorgT selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SvorgT record,
			@Param("example") SvorgTExample example);

	int updateByExampleWithBLOBs(@Param("record") SvorgT record,
			@Param("example") SvorgTExample example);

	int updateByExample(@Param("record") SvorgT record,
			@Param("example") SvorgTExample example);

	int updateByPrimaryKeySelective(SvorgT record);

	int updateByPrimaryKeyWithBLOBs(SvorgT record);

	int updateByPrimaryKey(SvorgT record);
}
package com.gsccs.sme.plat.site.dao;

import com.gsccs.sme.plat.site.model.ChanelT;
import com.gsccs.sme.plat.site.model.ChanelTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChanelTMapper {

	int countByExample(ChanelTExample example);

	int deleteByExample(ChanelTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ChanelT record);

	int insertSelective(ChanelT record);

	List<ChanelT> selectByExample(ChanelTExample example);

	ChanelT selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ChanelT record,
			@Param("example") ChanelTExample example);

	int updateByExample(@Param("record") ChanelT record,
			@Param("example") ChanelTExample example);

	int updateByPrimaryKeySelective(ChanelT record);
	
	int updateByPrimaryKeyWithBLOBs(ChanelT record);
}
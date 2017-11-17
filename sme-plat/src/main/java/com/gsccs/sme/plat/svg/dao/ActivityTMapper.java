package com.gsccs.sme.plat.svg.dao;

import com.gsccs.sme.plat.svg.model.ActivityT;
import com.gsccs.sme.plat.svg.model.ActivityTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityTMapper {

	int countByExample(ActivityTExample example);

	int deleteByExample(ActivityTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ActivityT record);

	List<ActivityT> selectByExampleWithBLOBs(ActivityTExample example);

	List<ActivityT> selectByExample(ActivityTExample example);

	List<ActivityT> selectPageByExample(ActivityTExample example);

	ActivityT selectByPrimaryKey(Long id);

	int updateByExampleWithBLOBs(@Param("record") ActivityT record,
			@Param("example") ActivityTExample example);

	int updateByExample(@Param("record") ActivityT record,
			@Param("example") ActivityTExample example);

	int updateByPrimaryKeyWithBLOBs(ActivityT record);

	int updateByPrimaryKey(ActivityT record);

	List<ActivityT> selectPageEnroll(@Param("userid") Long userid, @Param("skip") int skip,
			@Param("pageSize") int pageSize);
	
	int countEnrollAct(@Param("userid") Long userid);
}
package com.gsccs.sme.plat.auth.dao;

import com.gsccs.sme.plat.auth.model.MsgT;
import com.gsccs.sme.plat.auth.model.MsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsgMapper {

	int countByExample(MsgExample example);

	int deleteByExample(MsgExample example);

	int deleteByPrimaryKey(String id);

	int insert(MsgT record);

	int insertSelective(MsgT record);

	List<MsgT> selectPageByExample(MsgExample example);

	MsgT selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") MsgT record,
			@Param("example") MsgExample example);

	int updateByExample(@Param("record") MsgT record,
			@Param("example") MsgExample example);

	int updateByPrimaryKeySelective(MsgT record);

	int updateByPrimaryKey(MsgT record);
}
package com.gsccs.sme.plat.auth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.sme.plat.auth.model.Sms;
import com.gsccs.sme.plat.auth.model.SmsExample;

public interface SmsMapper {

	int countByExample(SmsExample example);

	int deleteByExample(SmsExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Sms record);

	List<Sms> selectPageByExample(SmsExample example);

	Sms selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Sms record,
			@Param("example") SmsExample example);

	int updateByExample(@Param("record") Sms record,
			@Param("example") SmsExample example);

	int updateByPrimaryKeySelective(Sms record);

	int updateByPrimaryKey(Sms record);
}
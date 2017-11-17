package com.gsccs.sme.plat.svg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.sme.api.domain.SneedBid;
import com.gsccs.sme.plat.svg.model.SneedBidExample;

public interface SneedBidMapper {
	
	int countByExample(SneedBidExample example);
	int deleteByExample(SneedBidExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SneedBid record);

	List<SneedBid> selectPageByExample(SneedBidExample example);
	List<SneedBid> selectByExample(SneedBidExample example);

	SneedBid selectByPrimaryKey(Long id);

	int updateByExample(@Param("record") SneedBid record,
			@Param("example") SneedBidExample example);

	int updateByPrimaryKey(SneedBid record);
}
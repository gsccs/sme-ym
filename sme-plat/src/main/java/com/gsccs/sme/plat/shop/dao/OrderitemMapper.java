package com.gsccs.sme.plat.shop.dao;

import com.gsccs.sme.plat.shop.model.OrderitemT;
import com.gsccs.sme.plat.shop.model.OrderitemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderitemMapper {

	int countByExample(OrderitemExample example);

	int deleteByExample(OrderitemExample example);

	int deleteByPrimaryKey(String id);

	int insert(OrderitemT record);

	List<OrderitemT> selectByExample(OrderitemExample example);

	OrderitemT selectByPrimaryKey(String id);

	int updateByExample(@Param("record") OrderitemT record,
			@Param("example") OrderitemExample example);

	int updateByPrimaryKey(OrderitemT record);
}
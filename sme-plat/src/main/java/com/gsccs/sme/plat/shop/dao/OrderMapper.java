package com.gsccs.sme.plat.shop.dao;

import com.gsccs.sme.plat.shop.model.OrderT;
import com.gsccs.sme.plat.shop.model.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
	
	int countByExample(OrderExample example);

	int deleteByExample(OrderExample example);

	int deleteByPrimaryKey(Long id);

	int insert(OrderT record);

	List<OrderT> selectPageByExample(OrderExample example);
	List<OrderT> selectByExample(OrderExample example);

	OrderT selectByPrimaryKey(Long id);

	int updateByExample(@Param("record") OrderT record,
			@Param("example") OrderExample example);

	int updateByPrimaryKeySelective(OrderT record);
}
package com.gsccs.sme.plat.shop.dao;

import com.gsccs.sme.plat.shop.model.ProductT;
import com.gsccs.sme.plat.shop.model.ProductTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductTMapper {

	int countByExample(ProductTExample example);

	int deleteByExample(ProductTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ProductT record);

	List<ProductT> selectPageByExample(ProductTExample example);

	ProductT selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ProductT record,
			@Param("example") ProductTExample example);

	int updateByExampleWithBLOBs(@Param("record") ProductT record,
			@Param("example") ProductTExample example);

	int updateByExample(@Param("record") ProductT record,
			@Param("example") ProductTExample example);

	int updateByPrimaryKeySelective(ProductT record);

	int updateByPrimaryKeyWithBLOBs(ProductT record);

	int updateByPrimaryKey(ProductT record);
}
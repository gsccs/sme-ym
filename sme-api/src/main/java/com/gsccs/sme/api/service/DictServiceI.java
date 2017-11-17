package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.base.Dict;

/**
 * 字典API 提供了标准类目
 * 
 * @author x.d zhang
 * 
 */
public interface DictServiceI {

	/**
	 * 查询字典
	 * @param groupcode    字典分组编码
	 * @param ignorestatus 是否忽略状态
	 * @return
	 */
	public List<Dict> queryDictList(String groupcode,boolean ignorestatus);

}

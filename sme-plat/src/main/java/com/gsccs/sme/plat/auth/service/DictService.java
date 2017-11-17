package com.gsccs.sme.plat.auth.service;

import java.util.List;

import com.gsccs.sme.plat.auth.model.DictGroupT;
import com.gsccs.sme.plat.auth.model.DictItemT;

/**
 * <p>
 * User: x.d zhang
 * <p>
 * Date: 14-1-28
 * <p>
 * Version: 1.0
 */
public interface DictService {

	public void createDictGroupT(DictGroupT dictGroupT);

	public void updateDictGroupT(DictGroupT dictGroupT);

	public void deleteDictGroupT(String id);

	public DictGroupT getGroupById(String id);

	public DictGroupT getGroupByCode(String code);
	
	public DictGroupT getGroupByTitle(String title);
	
	public List<DictItemT> getDictItems(String groupcode);

	public List<DictGroupT> findGroupList(DictGroupT param, int page, int pagesize);
	
	public List<DictGroupT> findGroupList(DictGroupT param);
	
	public Integer countDictGroup(DictGroupT param);
	
	public void createDictItemT(DictItemT dictItemT);

	public void updateDictItemT(DictItemT dictItemT);

	public void deleteDictItemT(String id);

	public DictItemT getDictById(String id);
	
	public List<DictItemT> findDictlist(String ids);

	public List<DictItemT> findItemList(DictItemT param, int page, int pagesize);
	
	public List<DictItemT> findItemList(DictItemT param);
	
	public List<DictItemT> findGroupAndItemList(DictItemT param);
	
	public Integer countDictItem(DictItemT param);

	public List<DictItemT> getDictItemsByCode(String code,DictItemT dictItem);
}

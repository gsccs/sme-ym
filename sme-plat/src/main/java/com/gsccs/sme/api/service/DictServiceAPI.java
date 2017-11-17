package com.gsccs.sme.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.domain.base.Dict;
import com.gsccs.sme.api.service.DictServiceI;
import com.gsccs.sme.plat.auth.model.DictGroupT;
import com.gsccs.sme.plat.auth.model.DictItemT;
import com.gsccs.sme.plat.auth.service.DictService;

/**
 * 字典服务接口
 * 
 * @author x.d zhang
 * 
 */
public class DictServiceAPI implements DictServiceI {

	@Autowired
	private DictService dictService;

	
	@Override
	public List<Dict> queryDictList(String groupcode,boolean ignorestatus) {
		DictGroupT dictGroupT = dictService.getGroupByCode(groupcode);
		if (null != dictGroupT){
			DictItemT dictItemT = new DictItemT();
			dictItemT.setGroupid(dictGroupT.getId());
			List<DictItemT> itemlist = dictService.findItemList(dictItemT, 1, Integer.MAX_VALUE);
			if (null != itemlist && itemlist.size()>0){
				List<Dict> dictList= new ArrayList<>();
				for(DictItemT itemT:itemlist){
					Dict dict = new Dict();
					dict.setId(itemT.getId());
					dict.setTitle(itemT.getTitle());
					dict.setRemark(itemT.getRemark());
					dictList.add(dict);
				}
				return dictList;
			}
		}
		return null;
	}

}

package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import com.gsccs.sme.plat.rtable.model.PropT;
import com.gsccs.sme.plat.rtable.model.PropvalT;

public interface PropService {

	public void addProp(PropT prop);

	public void updateProp(PropT prop);

	public PropT getProp(String id);

	public void delProp(String id);

	public List<PropT> find(PropT prop, String order, int currPage,
			int pageSize);

	public int count(PropT prop);
	
	
	public List<PropvalT> findCorpProp(String corpid,String productid);
	public List<PropvalT> findCorpProp(String corpid);
	
	
	public void addPropv(PropvalT propv);

	public void updatePropv(PropvalT propv);

	public PropvalT getPropv(String id);

	public void delPropv(String id);
	
	public void savePropvalList(List<PropvalT> propvlist);

	public List<PropvalT> find(PropvalT propv, String order, int currPage,
			int pageSize);

	public int count(PropvalT propv);

}

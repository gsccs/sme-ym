package com.gsccs.sme.plat.corp.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.plat.svg.model.CorpT;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface CorpService {

	
	public Long addCorp(CorpT account);
	
	public void updateCorp(CorpT account);

	public CorpT getCorp(Long id);

	public List<CorpT> find(CorpT corpT, String order, int currPage,
			int pageSize);
	
	public List<CorpT> find(CorpT corpT);
	
	public Integer count(CorpT corpT);
	
	public JSONArray findCorpTypeTree();

}

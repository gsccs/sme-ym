package com.gsccs.sme.plat.corp.service;

import java.util.List;

import com.gsccs.sme.api.domain.corp.CorpEnergy;
import com.gsccs.sme.api.domain.corp.CorpMsw;
import com.gsccs.sme.api.domain.corp.CorpRun;
import com.gsccs.sme.api.domain.corp.CorpTech;
import com.gsccs.sme.api.domain.corp.CorpWater;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface DataService {
	
	public Long saveRun(CorpRun param);
	public CorpRun getCorpRun(Long id);
	public List<CorpRun> find(CorpRun param, String order, int currPage,
			int pageSize);
	public Integer count(CorpRun param);
	
	
	public Long saveEnergy(CorpEnergy param);
	public CorpEnergy getCorpEnergy(Long id);
	public List<CorpEnergy> find(CorpEnergy param, String order, int currPage,
			int pageSize);
	public Integer count(CorpEnergy param);
	
	
	public Long saveMsw(CorpMsw param);
	public CorpMsw getCorpMsw(Long id);
	public List<CorpMsw> find(CorpMsw param, String order, int currPage,
			int pageSize);
	public Integer count(CorpMsw param);
	
	
	
	public Long saveTech(CorpTech param);
	public CorpTech getCorpTech(Long id);
	public List<CorpTech> find(CorpTech param, String order, int currPage,
			int pageSize);
	public Integer count(CorpTech param);
	
	
	public Long saveWater(CorpWater param);
	public CorpWater getCorpWater(Long id);
	public List<CorpWater> find(CorpWater param, String order, int currPage,
			int pageSize);
	public Integer count(CorpWater param);

}

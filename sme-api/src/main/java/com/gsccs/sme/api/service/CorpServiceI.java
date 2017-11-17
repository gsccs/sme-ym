package com.gsccs.sme.api.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.domain.corp.Corp;
import com.gsccs.sme.api.domain.corp.CorpEnergy;
import com.gsccs.sme.api.domain.corp.CorpMsw;
import com.gsccs.sme.api.domain.corp.CorpRun;
import com.gsccs.sme.api.domain.corp.CorpTech;
import com.gsccs.sme.api.domain.corp.CorpWater;
import com.gsccs.sme.api.exception.ApiException;


/**
 * 企业API
 * @author x.d zhang
 *
 */
public interface CorpServiceI {
	
	/**
	 * 查询企业信息
	 */
	public Corp getCorp(Long corpId) throws ApiException;
	
	/**
	 * 添加企业
	 * @param corp
	 */
	public void addCorp(Corp corp) throws ApiException;
	
	
	/**
	 * 更新企业资料
	 * @param corp
	 */
	public void updateCorp(Corp corp) throws ApiException;
	
	/**
	 * 查询企业列表
	 * @param account
	 * @return
	 * @throws ApiException
	 */
	public List<Corp> queryCorpList(Corp param, String order, int page,
			int pagesize) throws ApiException;
	
	public Integer count(Corp param);
	
	/**
	 * 企业类型树
	 * @return
	 */
	public JSONArray findCorpTypeTree();
	
	
	public CorpEnergy getCorpEnergy(Long id);
	public Long saveEnergy(CorpEnergy param);

	public List<CorpEnergy> find(CorpEnergy param, String order, int currPage,
			int pageSize);
	public Integer count(CorpEnergy corpT);
	
	
	public Long saveMsw(CorpMsw param);
	public CorpMsw getCorpMsw(Long id);
	public List<CorpMsw> find(CorpMsw param, String order, int currPage,
			int pageSize);
	public Integer count(CorpMsw param);
	
	
	public CorpTech getCorpTech(Long id);
	public Long saveTech(CorpTech param);

	public List<CorpTech> find(CorpTech param, String order, int currPage,
			int pageSize);
	public Integer count(CorpTech param);
	
	public CorpWater getCorpWater(Long id);
	public Long saveWater(CorpWater param);

	public List<CorpWater> find(CorpWater param, String order, int currPage,
			int pageSize);
	public Integer count(CorpWater param);
	
	public CorpRun getCorpRun(Long id);
	public Long saveCorpRun(CorpRun param);

	public List<CorpRun> find(CorpRun param, String order, int currPage,
			int pageSize);
	public Integer count(CorpRun param);
	
	
}

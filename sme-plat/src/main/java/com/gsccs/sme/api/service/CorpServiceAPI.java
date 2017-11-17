package com.gsccs.sme.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.corp.Corp;
import com.gsccs.sme.api.domain.corp.CorpEnergy;
import com.gsccs.sme.api.domain.corp.CorpMsw;
import com.gsccs.sme.api.domain.corp.CorpRun;
import com.gsccs.sme.api.domain.corp.CorpTech;
import com.gsccs.sme.api.domain.corp.CorpWater;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.plat.corp.service.CorpService;
import com.gsccs.sme.plat.corp.service.DataService;
import com.gsccs.sme.plat.svg.model.CorpT;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

/**
 * 企业服务接口API
 * 
 * @author x.d zhang
 */
public class CorpServiceAPI implements CorpServiceI {

	@Autowired
	private CorpService corpService;
	@Autowired
	private DataService dataService;

	@Override
	public Corp getCorp(Long corpId) throws ApiException {
		if (null == corpId) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		CorpT corpT = corpService.getCorp(corpId);
		if (null != corpT) {
			Corp corpo = new Corp();
			BeanUtilsEx.copyProperties(corpo, corpT);
			return corpo;
		}
		return null;
	}

	@Override
	public void addCorp(Corp corp) throws ApiException {
		if (null == corp) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		CorpT corpT = new CorpT();
		BeanUtilsEx.copyProperties(corpT, corp);
		corpService.addCorp(corpT);
	}

	@Override
	public List<Corp> queryCorpList(Corp param, String order, int page,
			int pagesize) throws ApiException {
		List<Corp> list = null;
		CorpT t = null;
		if (null != param) {
			t = new CorpT();
			BeanUtilsEx.copyProperties(t, param);
		}

		List<CorpT> corpTs = corpService.find(t, order, page, pagesize);
		if (null != corpTs && corpTs.size() > 0) {
			list = new ArrayList<Corp>();
			for (CorpT corpT : corpTs) {
				Corp corp_ = new Corp();
				BeanUtilsEx.copyProperties(corp_, corpT);
				list.add(corp_);
			}
		}
		return list;
	}

	@Override
	public Integer count(Corp param) {
		CorpT t = null;
		if (null != param) {
			t = new CorpT();
			BeanUtilsEx.copyProperties(t, param);
		}
		return corpService.count(t);
	}

	@Override
	public JSONArray findCorpTypeTree() {
		return corpService.findCorpTypeTree();
	}

	@Override
	public void updateCorp(Corp corp) throws ApiException {
		if (null == corp) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		CorpT corpT = new CorpT();
		BeanUtilsEx.copyProperties(corpT, corp);
		corpService.updateCorp(corpT);
	}

	@Override
	public Long saveEnergy(CorpEnergy param) {
		return dataService.saveEnergy(param);
	}

	@Override
	public List<CorpEnergy> find(CorpEnergy param, String order, int currPage,
			int pageSize) {
		return dataService.find(param, order, currPage, pageSize);
	}

	@Override
	public Integer count(CorpEnergy param) {
		return dataService.count(param);
	}

	@Override
	public Long saveMsw(CorpMsw param) {
		return dataService.saveMsw(param);
	}

	@Override
	public List<CorpMsw> find(CorpMsw param, String order, int currPage,
			int pageSize) {
		return dataService.find(param, order, currPage, pageSize);
	}

	@Override
	public Integer count(CorpMsw param) {
		return dataService.count(param);
	}

	@Override
	public Long saveTech(CorpTech param) {
		return dataService.saveTech(param);
	}

	@Override
	public List<CorpTech> find(CorpTech param, String order, int currPage,
			int pageSize) {
		return dataService.find(param, order, currPage, pageSize);
	}

	@Override
	public Integer count(CorpTech param) {
		return dataService.count(param);
	}

	@Override
	public Long saveWater(CorpWater param) {
		return dataService.saveWater(param);
	}

	@Override
	public List<CorpWater> find(CorpWater param, String order, int currPage,
			int pageSize) {
		return dataService.find(param, order, currPage, pageSize);
	}

	@Override
	public Integer count(CorpWater param) {
		return dataService.count(param);
	}

	@Override
	public Long saveCorpRun(CorpRun param) {
		return dataService.saveRun(param);
	}

	@Override
	public List<CorpRun> find(CorpRun param, String order, int currPage,
			int pageSize) {
		return dataService.find(param, order, currPage, pageSize);
	}

	@Override
	public Integer count(CorpRun param) {
		return dataService.count(param);
	}

	@Override
	public CorpTech getCorpTech(Long id) {
		return dataService.getCorpTech(id);
	}

	@Override
	public CorpEnergy getCorpEnergy(Long id) {
		return dataService.getCorpEnergy(id);
	}

	@Override
	public CorpWater getCorpWater(Long id) {
		return dataService.getCorpWater(id);
	}

	@Override
	public CorpRun getCorpRun(Long id) {
		return dataService.getCorpRun(id);
	}

	@Override
	public CorpMsw getCorpMsw(Long id) {
		return dataService.getCorpMsw(id);
	}

}

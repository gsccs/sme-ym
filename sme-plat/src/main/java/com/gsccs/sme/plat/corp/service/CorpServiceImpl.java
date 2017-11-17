package com.gsccs.sme.plat.corp.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.plat.auth.dao.DictItemTMapper;
import com.gsccs.sme.plat.auth.model.DictItemT;
import com.gsccs.sme.plat.auth.service.AreaService;
import com.gsccs.sme.plat.svg.dao.CorpTMapper;
import com.gsccs.sme.plat.svg.dao.RegTypeTMapper;
import com.gsccs.sme.plat.svg.model.CorpT;
import com.gsccs.sme.plat.svg.model.CorpTExample;
import com.gsccs.sme.plat.svg.model.IndustryT;
import com.gsccs.sme.plat.svg.model.RegTypeT;
import com.gsccs.sme.plat.svg.model.RegTypeTExample;
import com.gsccs.sme.plat.svg.service.IndustryService;

@Service
public class CorpServiceImpl implements CorpService {

	@Autowired
	private CorpTMapper corpTMapper;
	@Autowired
	private DictItemTMapper dictItemTMapper;
	@Autowired
	private RegTypeTMapper regTypeTMapper;
	@Autowired
	private IndustryService industryService;
	@Autowired
	private AreaService areaService;
	

	@Override
	public Long addCorp(CorpT corpT) {
		if (null != corpT) {
			corpTMapper.insert(corpT);
			return corpT.getId();
		}
		return null;
	}

	@Override
	public CorpT getCorp(Long id) {
		
		CorpT corp = corpTMapper.selectByPrimaryKey(id);

		// 企业注册类型
		if (StringUtils.isNotEmpty(corp.getRegtype())) {
			DictItemT dictItemT = dictItemTMapper.selectByPrimaryKey(corp
					.getRegtype());
			if (null != dictItemT) {
				corp.setRegtypestr(dictItemT.getTitle());
			}
		}
		// 单位性质
		if (StringUtils.isNotEmpty(corp.getNature())) {
			DictItemT dictItemT = dictItemTMapper.selectByPrimaryKey(corp
					.getNature());
			if (null != dictItemT) {
				corp.setNaturestr(dictItemT.getTitle());
			}

		}
		return corp;
	}

	@Override
	public List<CorpT> find(CorpT corpT, String order, int currPage,
			int pageSize) {
		CorpTExample example = new CorpTExample();
		CorpTExample.Criteria criteria = example.createCriteria();
		proSearchParam(corpT, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		if (StringUtils.isNotEmpty(order)) {
			example.setOrderByClause(order);
		}else{
			example.setOrderByClause("istop");
		}
		List<CorpT> corpTs = corpTMapper.selectPageByExample(example);
		if (null != corpTs && corpTs.size()>0){
			for (CorpT corp : corpTs) {
				// 行业
				if (null != corp.getHycode()) {
					IndustryT industryT = industryService.findById(corp.getHycode());
					if (null != industryT) {
						corp.setHytypestr(industryT.getTitle());
					}
				}
				// 企业注册类型
				if (StringUtils.isNotEmpty(corp.getRegtype())) {
					DictItemT dictItemT = dictItemTMapper.selectByPrimaryKey(corp
							.getRegtype());
					if (null != dictItemT) {
						corp.setRegtypestr(dictItemT.getTitle());
					}
				}
				// 单位性质
				if (StringUtils.isNotEmpty(corp.getNature())) {
					DictItemT dictItemT = dictItemTMapper.selectByPrimaryKey(corp
							.getNature());
					if (null != dictItemT) {
						corp.setNaturestr(dictItemT.getTitle());
					}
				}

				String areastr = "";
				if (null != corp.getAcode()) {
					areastr += areaService.getAreaStr(corp.getAcode());
				} else if (null != corp.getCcode()) {
					areastr += areaService.getAreaStr(corp.getCcode());
				} else if (null != corp.getPcode()) {
					areastr += areaService.getAreaStr(corp.getPcode());
				}
				String address = corp.getAddress() == null ? "" : corp
						.getAddress();
				areastr += address;
				corp.setAreastr(areastr);
			}
		}
		return corpTs;
	}

	@Override
	public Integer count(CorpT corpT) {
		CorpTExample example = new CorpTExample();
		CorpTExample.Criteria criteria = example.createCriteria();
		proSearchParam(corpT, criteria);
		return corpTMapper.countByExample(example);
	}

	public void proSearchParam(CorpT corpT, CorpTExample.Criteria criteria) {
		if (null != corpT) {
			if (StringUtils.isNotEmpty(corpT.getTitle())) {
				criteria.andTitleLike("%" + corpT.getTitle() + "%");
			}

			if (null != corpT.getOrgcode()) {
				criteria.andOrgCodeEqualTo(corpT.getOrgcode());
			}

			if (null != corpT.getRegtype()) {
				criteria.andRegtypeEqualTo(corpT.getRegtype());
			}
			
			if (null != corpT.getParkid()) {
				criteria.andParkidEqualTo(corpT.getParkid());
			}
			
			if (null != corpT.getHycode()) {
				criteria.andHycodeEqualTo(corpT.getHycode().toString());
			}
			
			if (null != corpT.getStatus()) {
				criteria.andStatusEqualTo(corpT.getStatus());
			}

		}
	}

	public List<RegTypeT> findALL() {
		RegTypeTExample example = new RegTypeTExample();
		return regTypeTMapper.selectByExample(example);
	}

	@Override
	public JSONArray findCorpTypeTree() {
		List<RegTypeT> roots = findALL();
		if (null != roots) {
			JSONArray rootArray = (JSONArray) JSON.toJSON(roots);
			return treeList(rootArray, 0l);
		}
		return null;
	}

	public JSONArray treeList(JSONArray nodeList, Long parentId) {
		JSONArray nodearray = new JSONArray();
		for (Object object : nodeList) {
			JSONObject json = (JSONObject) JSON.toJSON(object);
			long id = json.getLong("id");
			long pid = json.getLong("parid");
			json.put("text", json.get("title"));
			if (parentId == pid) {
				JSONArray subitems = treeList(nodeList, id);
				json.put("children", subitems);
				nodearray.add(json);
			}
		}
		return nodearray;
	}

	@Override
	public List<CorpT> find(CorpT corpT) {
		CorpTExample example = new CorpTExample();
		CorpTExample.Criteria criteria = example.createCriteria();
		proSearchParam(corpT, criteria);
		return corpTMapper.selectByExample(example);
	}

	@Override
	public void updateCorp(CorpT corpT) {
		if (null != corpT){
			corpTMapper.updateByPrimaryKeyWithBLOBs(corpT);
		}
	}

}

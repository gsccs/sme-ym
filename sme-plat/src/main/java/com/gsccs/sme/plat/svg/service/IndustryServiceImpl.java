package com.gsccs.sme.plat.svg.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.plat.svg.dao.IndustryTMapper;
import com.gsccs.sme.plat.svg.model.IndustryT;
import com.gsccs.sme.plat.svg.model.IndustryTExample;

/**
 * 行业分类信息
 * 
 * @创建时间：2015.4.1
 */
@Service(value = "industryService")
public class IndustryServiceImpl implements IndustryService {

	@Autowired
	private IndustryTMapper industryTMapper;

	/**
	 * 根据id查询
	 */
	@Override
	public IndustryT findById(Long id) {
		return industryTMapper.selectByPrimaryKey(id);
	}

	/**
	 * 添加s
	 */
	@Override
	public void insert(IndustryT IndustryT) {
		if (null != IndustryT) {
			industryTMapper.insert(IndustryT);
		}
	}

	/**
	 * 修改
	 */
	@Override
	public void update(IndustryT industryT) {
		industryTMapper.updateByPrimaryKey(industryT);
	}

	@Override
	public List<IndustryT> find(IndustryT IndustryT, String order,
			int currPage, int pageSize) {
		IndustryTExample example = new IndustryTExample();
		IndustryTExample.Criteria criteria = example.createCriteria();
		proSearchParam(IndustryT, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return industryTMapper.selectPageByExample(example);
	}

	@Override
	public int count(IndustryT IndustryT) {
		IndustryTExample example = new IndustryTExample();
		IndustryTExample.Criteria criteria = example.createCriteria();
		proSearchParam(IndustryT, criteria);
		return industryTMapper.countByExample(example);
	}

	public void proSearchParam(IndustryT IndustryT,
			IndustryTExample.Criteria criteria) {
		if (null != IndustryT) {
			if (StringUtils.isNotEmpty(IndustryT.getTitle())) {
				criteria.andTitleLike("%" + IndustryT.getTitle() + "%");
			}
			if (null != IndustryT.getParid()) {
				criteria.andParidEqualTo(IndustryT.getParid());
			}
		}
	}

	@Override
	public List<IndustryT> findSubIndustry(Long parid) {
		IndustryTExample example = new IndustryTExample();
		IndustryTExample.Criteria criteria = example.createCriteria();
		IndustryT industryT = new IndustryT();
		industryT.setParid(parid);
		proSearchParam(industryT, criteria);
		return industryTMapper.selectByExample(example);
	}

	@Override
	public void delete(Long id) {
		industryTMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public JSONArray findTree() {
		List<IndustryT> roots = find(null, "", 1, Integer.MAX_VALUE);
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
			Long menuId = json.getLong("id");
			Long pid = json.getLong("parid");
			json.put("text", json.get("title"));
			if (parentId == pid) {
				JSONArray subitems = treeList(nodeList, menuId);
				json.put("children", subitems);
				nodearray.add(json);
			}
		}
		return nodearray;
	}
}

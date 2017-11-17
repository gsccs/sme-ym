package com.gsccs.sme.plat.svg.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.plat.svg.dao.RegTypeTMapper;
import com.gsccs.sme.plat.svg.model.RegTypeT;
import com.gsccs.sme.plat.svg.model.RegTypeTExample;

/**
 * 企业注册类型业务
 * 
 * @author x.d zhang
 * 
 */
@Service
public class RegtypeServiceImpl implements RegtypeService {

	@Autowired
	private RegTypeTMapper regTypeTMapper;

	/**
	 * 根据id查询
	 */
	@Override
	public RegTypeT findById(Long id) {
		return regTypeTMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public void insert(RegTypeT chanelT) {
		if (null != chanelT) {
			regTypeTMapper.insert(chanelT);
		}
	}

	/**
	 * 修改卖家账号
	 */
	@Override
	public void update(RegTypeT chanelT) {
		regTypeTMapper.updateByPrimaryKey(chanelT);
	}

	@Override
	public int count(RegTypeT chanelT) {
		RegTypeTExample example = new RegTypeTExample();
		RegTypeTExample.Criteria criteria = example.createCriteria();
		proSearchParam(chanelT, criteria);
		return regTypeTMapper.countByExample(example);
	}

	@Override
	public List<RegTypeT> find(RegTypeT chanelT, String orderstr, int page,
			int pagesize) {
		RegTypeTExample example = new RegTypeTExample();
		RegTypeTExample.Criteria criteria = example.createCriteria();
		proSearchParam(chanelT, criteria);
		return regTypeTMapper.selectByExample(example);
	}

	@Override
	public List<RegTypeT> find(RegTypeT chanelT) {
		RegTypeTExample example = new RegTypeTExample();
		RegTypeTExample.Criteria criteria = example.createCriteria();
		proSearchParam(chanelT, criteria);
		return regTypeTMapper.selectByExample(example);
	}

	@Override
	public void delChannel(Long id) {
		regTypeTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<RegTypeT> findSubChannel(Long parid) {
		if (null != parid) {
			RegTypeT chanelT = new RegTypeT();
			chanelT.setParid(parid);
			RegTypeTExample example = new RegTypeTExample();
			RegTypeTExample.Criteria criteria = example.createCriteria();
			proSearchParam(chanelT, criteria);
			return regTypeTMapper.selectByExample(example);
		}
		return null;
	}

	public void proSearchParam(RegTypeT chanelT, RegTypeTExample.Criteria criteria) {
		if (null != chanelT) {
			if (StringUtils.isNotEmpty(chanelT.getTitle())) {
				criteria.andTitleLike("%" + chanelT.getTitle() + "%");
			}
			if (null != chanelT.getParid()) {
				criteria.andParidEqualTo(chanelT.getParid());
			}
		}
	}

	@Override
	public List<RegTypeT> findByParids(String parids) {
		if (null != parids) {
			RegTypeT chanelT = new RegTypeT();
			RegTypeTExample example = new RegTypeTExample();
			RegTypeTExample.Criteria criteria = example.createCriteria();
			proSearchParam(chanelT, criteria);
			return regTypeTMapper.selectByExample(example);
		}
		return null;
	}

	@Override
	public JSONArray findChannelTree() {
		List<RegTypeT> roots = find(null);
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
			long menuId = json.getLong("id");
			long pid = json.getLong("parid");
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

package com.gsccs.sme.plat.site.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.plat.site.dao.ChanelTMapper;
import com.gsccs.sme.plat.site.model.ChanelT;
import com.gsccs.sme.plat.site.model.ChanelTExample;

/**
 * 信息分类业务
 * 
 * @author x.d zhang
 * 
 */
@Service(value = "channelService")
public class ChannelServiceImpl implements ChannelService {

	@Autowired
	private ChanelTMapper chanelTMapper;

	/**
	 * 根据id查询
	 */
	@Override
	public ChanelT findById(Long id) {
		return chanelTMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insert(ChanelT chanelT) {
		if (null != chanelT) {
			chanelTMapper.insert(chanelT);
		}
	}

	/**
	 * 更新栏目信息
	 */
	@Override
	public void update(ChanelT chanelT) {
		chanelTMapper.updateByPrimaryKeyWithBLOBs(chanelT);
	}

	@Override
	public int count(ChanelT chanelT) {
		ChanelTExample example = new ChanelTExample();
		ChanelTExample.Criteria criteria = example.createCriteria();
		proSearchParam(chanelT, criteria);
		return chanelTMapper.countByExample(example);
	}

	@Override
	public List<ChanelT> find(ChanelT chanelT, String orderstr, int page,
			int pagesize) {
		ChanelTExample example = new ChanelTExample();
		ChanelTExample.Criteria criteria = example.createCriteria();
		proSearchParam(chanelT, criteria);
		return chanelTMapper.selectByExample(example);
	}

	@Override
	public List<ChanelT> find(ChanelT chanelT) {
		ChanelTExample example = new ChanelTExample();
		ChanelTExample.Criteria criteria = example.createCriteria();
		proSearchParam(chanelT, criteria);
		return chanelTMapper.selectByExample(example);
	}

	@Override
	public void delChannel(Long id) {
		chanelTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<ChanelT> findSubChannel(Long parid) {
		if (null != parid) {
			ChanelT chanelT = new ChanelT();
			chanelT.setParid(parid);
			ChanelTExample example = new ChanelTExample();
			ChanelTExample.Criteria criteria = example.createCriteria();
			proSearchParam(chanelT, criteria);
			return chanelTMapper.selectByExample(example);
		}
		return null;
	}

	public void proSearchParam(ChanelT chanelT, ChanelTExample.Criteria criteria) {
		if (null != chanelT) {
			if (StringUtils.isNotEmpty(chanelT.getTitle())) {
				criteria.andTitleLike("%" + chanelT.getTitle() + "%");
			}
			if (null != chanelT.getParid()) {
				criteria.andParidEqualTo(chanelT.getParid());
			}
			if (null != chanelT.getParids()) {
				criteria.andParidsLike("%" + chanelT.getParids() + "%");
			}
		}
	}

	@Override
	public List<ChanelT> findByParids(String parids) {
		if (null != parids) {
			ChanelT chanelT = new ChanelT();
			chanelT.setParids(parids);
			ChanelTExample example = new ChanelTExample();
			ChanelTExample.Criteria criteria = example.createCriteria();
			proSearchParam(chanelT, criteria);
			return chanelTMapper.selectByExample(example);
		}
		return null;
	}

	@Override
	public JSONArray findChannelTree() {
		List<ChanelT> roots = find(null);
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

package com.gsccs.sme.plat.auth.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.auth.dao.DictGroupTMapper;
import com.gsccs.sme.plat.auth.dao.DictItemTMapper;
import com.gsccs.sme.plat.auth.model.DictGroupT;
import com.gsccs.sme.plat.auth.model.DictGroupTExample;
import com.gsccs.sme.plat.auth.model.DictItemT;
import com.gsccs.sme.plat.auth.model.DictItemExample;

@Service
public class DictServiceImpl implements DictService {

	@Autowired
	private DictGroupTMapper dictGroupTMapper;
	@Autowired
	private DictItemTMapper dictItemTMapper;

	@Override
	public void createDictGroupT(DictGroupT groupT) {
		if (null != groupT) {
			String code = groupT.getCode();
			DictGroupT t = getGroupByCode(code);
			if (null != t) { // 已存在

			} else {
				groupT.setId(UUID.randomUUID().toString());
				dictGroupTMapper.insert(groupT);
			}
		}
	}

	@Override
	public void updateDictGroupT(DictGroupT groupT) {
		if (null != groupT) {
			dictGroupTMapper.updateByPrimaryKey(groupT);
		}
	}

	@Override
	public void deleteDictGroupT(String groupid) {
		dictGroupTMapper.deleteByPrimaryKey(groupid);

	}

	@Override
	public DictGroupT getGroupById(String id) {
		return dictGroupTMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DictGroupT getGroupByTitle(String title) {
		
		return dictGroupTMapper.selectByTitle(title);
	}

	@Override
	public DictGroupT getGroupByCode(String code) {
		DictGroupTExample example = new DictGroupTExample();
		DictGroupTExample.Criteria c = example.createCriteria();
		c.andCodeEqualTo(code);
		List<DictGroupT> list = dictGroupTMapper.selectByExample(example);
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<DictGroupT> findGroupList(DictGroupT param, int page,
			int pagesize) {
		DictGroupTExample example = new DictGroupTExample();
		DictGroupTExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return dictGroupTMapper.selectByExample(example);
	}

	@Override
	public void createDictItemT(DictItemT dictItem) {
		if (null != dictItem) {
			dictItem.setId(UUID.randomUUID().toString());
			dictItemTMapper.insert(dictItem);
		}
	}

	@Override
	public void updateDictItemT(DictItemT dictItem) {
		dictItemTMapper.updateByPrimaryKey(dictItem);
	}

	@Override
	public void deleteDictItemT(String id) {
		dictItemTMapper.deleteByPrimaryKey(id);

	}

	@Override
	public DictItemT getDictById(String id) {
		return dictItemTMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DictItemT> findItemList(DictItemT param, int page, int pagesize) {
		DictItemExample example = new DictItemExample();
		DictItemExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return dictItemTMapper.selectByExample(example);
	}

	public void proSearchParam(DictGroupT dictGroupT,
			DictGroupTExample.Criteria criteria) {
		if (null != dictGroupT) {
			if (StringUtils.isNotEmpty(dictGroupT.getCode())) {
				criteria.andCodeEqualTo(dictGroupT.getCode());
			}

			if (StringUtils.isNotEmpty(dictGroupT.getStatus())) {
				criteria.andStatusEqualTo(dictGroupT.getStatus());
			}
		}
	}

	public void proSearchParam(DictItemT dictItemT,
			DictItemExample.Criteria criteria) {
		if (null != dictItemT) {
			if (StringUtils.isNotEmpty(dictItemT.getCode())) {
				criteria.andCodeEqualTo(dictItemT.getCode());
			}
			if (StringUtils.isNotEmpty(dictItemT.getGroupid())) {
				criteria.andGroupidEqualTo(dictItemT.getGroupid());
			}
		}
	}

	@Override
	public Integer countDictGroup(DictGroupT param) {
		DictGroupTExample example = new DictGroupTExample();
		DictGroupTExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return dictGroupTMapper.countByExample(example);
	}

	@Override
	public Integer countDictItem(DictItemT param) {
		DictItemExample example = new DictItemExample();
		DictItemExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return dictItemTMapper.countByExample(example);
	}

	@Override
	public List<DictItemT> getDictItems(String code) {
		DictGroupTExample example = new DictGroupTExample();
		DictGroupTExample.Criteria c = example.createCriteria();
		c.andCodeEqualTo(code);
		List<DictGroupT> list = dictGroupTMapper.selectByExample(example);
		if (null != list && list.size() > 0) {
			DictItemExample example2 = new DictItemExample();
			DictItemExample.Criteria c2 = example2.createCriteria();
			c2.andGroupidEqualTo(list.get(0).getId());
			return dictItemTMapper.selectByExample(example2);
		}
		return null;
	}

	@Override
	public List<DictGroupT> findGroupList(DictGroupT param) {
		DictGroupTExample example = new DictGroupTExample();
		DictGroupTExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return dictGroupTMapper.selectByExample(example);
	}

	@Override
	public List<DictItemT> findItemList(DictItemT param) {
		DictItemExample example = new DictItemExample();
		DictItemExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return dictItemTMapper.selectByExample(example);
	}
	
	@Override
	public List<DictItemT> findGroupAndItemList(DictItemT param) {
		DictItemExample example = new DictItemExample();
		DictItemExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return dictItemTMapper.selectGroupAndItemList(example);
	}

	@Override
	public List<DictItemT> findDictlist(String ids) {
		if (StringUtils.isNotEmpty(ids)) {
			String[] idArray = ids.split(",");
			if (null != idArray && idArray.length > 0) {
				List<String> idlist = Arrays.asList(idArray);
				for (String id : idlist) {
					if (StringUtils.isEmpty(id)) {
						idlist.remove(id);
					}
				}
				if (null != idlist && idlist.size() > 0) {
					DictItemExample example = new DictItemExample();
					DictItemExample.Criteria c = example.createCriteria();
					c.andIdIn(idlist);
					return dictItemTMapper.selectByExample(example);
				}
			}
		}
		return null;
	}

	@Override
	public List<DictItemT> getDictItemsByCode(String code,DictItemT dictItem) {
		DictGroupT dictGroup=dictGroupTMapper.selectByCode(code);
		dictItem.setGroupid(dictGroup.getId());
		return findItemList(dictItem);
	}
}

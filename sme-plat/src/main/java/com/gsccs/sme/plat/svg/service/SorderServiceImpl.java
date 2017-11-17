package com.gsccs.sme.plat.svg.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.svg.dao.SorderTMapper;
import com.gsccs.sme.plat.svg.model.SorderT;
import com.gsccs.sme.plat.svg.model.SorderTExample;
import com.gsccs.sme.plat.utils.DateUtil;

/**
 * 服务订单业务
 * 
 * @author x.d zhang
 * 
 */
@Service(value = "sorderService")
public class SorderServiceImpl implements SorderService {

	@Autowired
	private SorderTMapper sorderTMapper;

	/**
	 * 根据id查询
	 */
	@Override
	public SorderT findById(String id) {
		return sorderTMapper.selectByPrimaryKey(id);
	}

	/**
	 * 添加服务项
	 */
	@Override
	public void insert(SorderT sorderT) {
		if (null != sorderT) {
			sorderT.setId(DateUtil.getOrderNum());
			sorderT.setAddtime(new Date());
			sorderTMapper.insert(sorderT);
		}
	}

	/**
	 * 修改订单
	 */
	@Override
	public void update(SorderT sorderT) {
		sorderTMapper.updateByPrimaryKey(sorderT);
	}

	@Override
	public List<SorderT> find(SorderT sorderT, String order, int currPage,
			int pageSize) {
		SorderTExample example = new SorderTExample();
		SorderTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sorderT, criteria);
		if (StringUtils.isNotEmpty(order)) {
			example.setOrderByClause(order);
		} else {
			example.setOrderByClause("addtime desc");
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return sorderTMapper.selectPageByExample(example);
	}

	@Override
	public int count(SorderT sorderT) {
		SorderTExample example = new SorderTExample();
		SorderTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sorderT, criteria);
		return sorderTMapper.countByExample(example);
	}

	public void proSearchParam(SorderT sorderT, SorderTExample.Criteria criteria) {
		if (null != sorderT) {
			if (null != sorderT.getCorpid()) {
				criteria.andCorpidEqualTo(sorderT.getCorpid());
			}
			if (null != sorderT.getSvgid()) {
				criteria.andSvgidEqualTo(sorderT.getSvgid());
			}

			if (StringUtils.isNotEmpty(sorderT.getStatus())) {
				criteria.andStatusEqualTo(sorderT.getStatus());
			}

			if (null != sorderT.getSitemid()) {
				criteria.andSitemidEqualTo(sorderT.getSitemid());
			}
		}
	}

	@Override
	public List<SorderT> find(SorderT sorderT) {
		SorderTExample example = new SorderTExample();
		SorderTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sorderT, criteria);
		return sorderTMapper.selectByExample(example);
	}

	@Override
	public void delSitem(String id) {
		sorderTMapper.deleteByPrimaryKey(id);
	}

}

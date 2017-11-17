package com.gsccs.sme.plat.svg.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.svg.dao.ExpertTMapper;
import com.gsccs.sme.plat.svg.model.ExpertT;
import com.gsccs.sme.plat.svg.model.ExpertTExample;

/**
 * 专家业务
 * 
 * @创建时间：2015.4.1
 */
@Service(value = "expertService")
public class ExpertServiceImpl implements ExpertService {

	@Autowired
	private ExpertTMapper expertTMapper;

	/**
	 * 根据id查询
	 */
	@Override
	public ExpertT findById(String id) {
		return expertTMapper.selectByPrimaryKey(id);
	}

	/**
	 * 添加卖家账号
	 */
	@Override
	public Long insert(ExpertT expertT) {
		if (null != expertT) {
			expertTMapper.insert(expertT);
			return expertT.getId();
		}
		return null;
	}

	/**
	 * 修改卖家账号
	 */
	@Override
	public void update(ExpertT sellerAccount) {
		expertTMapper.updateByPrimaryKey(sellerAccount);
	}

	@Override
	public List<ExpertT> find(ExpertT account, String order, int currPage,
			int pageSize) {
		ExpertTExample example = new ExpertTExample();
		ExpertTExample.Criteria criteria = example.createCriteria();
		proSearchParam(account, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return expertTMapper.selectPageByExample(example);
	}

	@Override
	public int count(ExpertT expertT) {
		ExpertTExample example = new ExpertTExample();
		ExpertTExample.Criteria criteria = example.createCriteria();
		proSearchParam(expertT, criteria);
		return expertTMapper.countByExample(example);
	}

	public void proSearchParam(ExpertT expertT, ExpertTExample.Criteria criteria) {
		if (null != expertT) {
			if (StringUtils.isNotEmpty(expertT.getTitle())) {
				criteria.andTitleLike("%" + expertT.getTitle() + "%");
			}
		}
	}

	@Override
	public List<ExpertT> find(ExpertT account) {
		ExpertTExample example = new ExpertTExample();
		ExpertTExample.Criteria criteria = example.createCriteria();
		proSearchParam(account, criteria);
		return expertTMapper.selectByExample(example);
	}

	@Override
	public void delSitem(String id) {
		expertTMapper.deleteByPrimaryKey(id);
	}
}

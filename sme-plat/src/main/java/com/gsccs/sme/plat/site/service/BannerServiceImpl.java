package com.gsccs.sme.plat.site.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.site.dao.BannerMapper;
import com.gsccs.sme.plat.site.model.BannerExample;
import com.gsccs.sme.plat.site.model.BannerT;

@Service
public class BannerServiceImpl implements BannerService {

	@Autowired
	private BannerMapper bannerMapper;

	@Override
	public void addBanner(BannerT banner) {
		if (null != banner) {
			banner.setId(UUID.randomUUID().toString());
			bannerMapper.insert(banner);
		}
	}

	@Override
	public BannerT getBanner(String id) {
		return bannerMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(String id) {
		bannerMapper.deleteByPrimaryKey(id);

	}

	@Override
	public List<BannerT> find(BannerT banner, String order, int currPage,
			int pageSize) {
		BannerExample example = new BannerExample();
		BannerExample.Criteria criteria = example.createCriteria();
		proSearchParam(banner, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		
		if(StringUtils.isEmpty(order)){
			example.setOrderByClause("indexnum desc");
		}else{
			example.setOrderByClause(order);
		}
		return bannerMapper.selectPageByExample(example);
	}

	@Override
	public int count(BannerT banner) {
		BannerExample example = new BannerExample();
		BannerExample.Criteria criteria = example.createCriteria();
		proSearchParam(banner, criteria);
		return bannerMapper.countByExample(example);
	}

	@Override
	public void update(BannerT banner) {
		if (null != banner) {
			bannerMapper.updateByPrimaryKeySelective(banner);
		}
	}

	public void proSearchParam(BannerT param, BannerExample.Criteria criteria) {
		if (null != param) {
			if (StringUtils.isNotEmpty(param.getTitle())) {
				criteria.andTitleLike("%" + param.getTitle() + "%");
			}

			if (StringUtils.isNotEmpty(param.getStatus())) {
				criteria.andStatusEqualTo(param.getStatus());
			}

		}
	}

}

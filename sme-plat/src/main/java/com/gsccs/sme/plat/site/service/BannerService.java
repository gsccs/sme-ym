package com.gsccs.sme.plat.site.service;

import java.util.List;

import com.gsccs.sme.plat.site.model.BannerT;
import com.gsccs.sme.plat.site.model.BannerT;

/**
 * 首页Banner管理
 * 
 * @author ZhangTao
 * 
 */
public interface BannerService {

	public void addBanner(BannerT banner);

	public BannerT getBanner(String id);

	public void delete(String id);

	public List<BannerT> find(BannerT banner, String order, int currPage,
			int pageSize);

	public int count(BannerT banner);

	public void update(BannerT banner);

}

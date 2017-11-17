package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.site.Banner;

/**
 * 首页Banner
 * @author ZhangTao
 *
 */
public interface BannerServiceI {

	/**
	 * 热点列表
	 * @param banner
	 * @param page
	 * @param pagesize
	 * @return
	 */
	public List<Banner> find(Banner banner,Integer page,Integer pagesize);
	
}

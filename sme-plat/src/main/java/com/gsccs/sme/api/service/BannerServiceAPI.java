package com.gsccs.sme.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.domain.site.Banner;
import com.gsccs.sme.api.service.BannerServiceI;
import com.gsccs.sme.plat.site.model.BannerT;
import com.gsccs.sme.plat.site.service.BannerService;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

public class BannerServiceAPI implements BannerServiceI {

	@Autowired
	private BannerService bannerService;

	@Override
	public List<Banner> find(Banner param, Integer page, Integer pagesize) {
		List<Banner> list = null;
		BannerT banner = null;
		if (null != param) {
			banner = new BannerT();
			BeanUtilsEx.copyProperties(banner, param);
		}

		List<BannerT> banners = bannerService.find(banner, "", page, pagesize);

		if (null != banners && banners.size() > 0) {
			list = new ArrayList<Banner>();
			for (BannerT bannerT_ : banners) {
				Banner banner_ = new Banner();
				BeanUtilsEx.copyProperties(banner_, bannerT_);
				list.add(banner_);
			}
		}
		return list;
	}
	
	
}

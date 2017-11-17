package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.site.Banner;
import com.gsccs.sme.api.domain.site.Link;

/**
 * 友情链接
 * @author x.d zhang
 *
 */
public interface LinkServiceI {

	/**
	 * 查询友情链接
	 * @param param
	 * @return
	 */
	public List<Link> find(Link param,int page,int pagesize);
	
}

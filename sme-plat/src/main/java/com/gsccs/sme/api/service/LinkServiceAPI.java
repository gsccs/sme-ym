package com.gsccs.sme.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.domain.site.Link;
import com.gsccs.sme.api.service.LinkServiceI;
import com.gsccs.sme.plat.site.model.LinkT;
import com.gsccs.sme.plat.site.service.LinkService;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

/**
 * 友情链接服务
 * @author x.d zhang
 *
 */
public class LinkServiceAPI implements LinkServiceI {

	@Autowired
	private LinkService linkService;

	@Override
	public List<Link> find(Link param, int page, int pagesize) {
		List<Link> list = null;
		if (null != param) {
			LinkT linkT = new LinkT();
			try {
				BeanUtils.copyProperties(linkT, param);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			List<LinkT> linkTs = linkService.find(linkT, "ordernum", page,
					pagesize);
			if (null != linkTs && linkTs.size() > 0) {
				list = new ArrayList<Link>();
				for (LinkT linkt_ : linkTs) {
					Link link_ = new Link();
					BeanUtilsEx.copyProperties(link_, linkt_);
					list.add(link_);
				}
			}
		}
		return list;
	}

}

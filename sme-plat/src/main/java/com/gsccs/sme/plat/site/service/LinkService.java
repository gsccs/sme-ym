package com.gsccs.sme.plat.site.service;

import java.util.List;

import com.gsccs.sme.plat.site.model.LinkT;


public interface LinkService {

	public String add(LinkT link);

	public void update(LinkT link);

	public void del(String id);

	public LinkT findById(String id);

	public List<LinkT> find(LinkT link,String orderstr, int page,
			int pagesize);
	
	public List<LinkT> findAll(LinkT link,String order);
	
	public int count(LinkT link);
}

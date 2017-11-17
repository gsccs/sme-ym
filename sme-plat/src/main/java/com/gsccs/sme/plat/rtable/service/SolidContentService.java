package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import com.gsccs.sme.plat.rtable.model.SolidContent;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface SolidContentService {

	public void addSolidContent(SolidContent solidContent);

	public SolidContent getSolidContent(Integer id);

	public void delSolidContent(Integer id);

	public List<SolidContent> find(SolidContent solidContent, String order,
			int currPage, int pageSize);

	public int count(SolidContent solidContent);

	public void update(SolidContent solidContent);

}

package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import com.gsccs.sme.plat.rtable.model.WallContent;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface WallContentService {

	public void addWallContent(WallContent wallContent);

	public WallContent getWallContent(Integer id);

	public void delWallContent(Integer id);

	public List<WallContent> find(WallContent wallContent, String order,
			int currPage, int pageSize);

	public int count(WallContent wallContent);

	public void update(WallContent wallContent);

}

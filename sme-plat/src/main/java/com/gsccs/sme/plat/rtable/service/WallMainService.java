package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import com.gsccs.sme.plat.rtable.model.WallMain;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface WallMainService {

	public void addWallMain(WallMain wallMain);

	public WallMain getWallMain(String id);

	public void delWallMain(String id);

	public List<WallMain> find(WallMain wallMain, String order,
			int currPage, int pageSize);

	public int count(WallMain wallMain);

	public void update(WallMain wallMain);

}

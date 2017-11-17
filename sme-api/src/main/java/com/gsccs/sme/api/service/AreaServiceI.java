package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.base.Area;

/**
 * 地区位置选择
 */
public interface AreaServiceI {
	
	List<Area> getArea(Integer parid);
	String getAreaStr(Integer code);
	
}

package com.gsccs.sme.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.domain.base.Area;
import com.gsccs.sme.api.service.AreaServiceI;
import com.gsccs.sme.plat.auth.model.AreaT;
import com.gsccs.sme.plat.auth.service.AreaService;

/**
 * 
 * 地域服务层
 * 
 * @author x.d zhang
 */
public class AreaServiceAPI implements AreaServiceI {

	@Autowired
	private AreaService areaService;

	@Override
	public List<Area> getArea(Integer parid) {
		List<Area> areaList = null;
		List<AreaT> list = areaService.getByParId(parid);

		if (null != list) {
			areaList = new ArrayList<Area>();
			Area area = null;

			for (AreaT t : list) {
				area = new Area();
				try {
					BeanUtils.copyProperties(area, t);
					areaList.add(area);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}

		return areaList;
	}

	@Override
	public String getAreaStr(Integer id) {
		return areaService.getAreaStr(id);
	}

}

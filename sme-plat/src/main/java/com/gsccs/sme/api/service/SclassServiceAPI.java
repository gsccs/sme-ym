package com.gsccs.sme.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.domain.Itemtype;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.plat.svg.model.SclassT;
import com.gsccs.sme.plat.svg.service.SclassService;

/**
 * 类目服务接口
 * 
 * @author x.d zhang
 * 
 */
public class SclassServiceAPI implements SclassServiceI {

	@Autowired
	private SclassService sclassService;

	@Override
	public Itemtype getSclass(Long classId) {
		SclassT sclassT = sclassService.findById(classId);
		if (null != sclassT) {
			Itemtype c = new Itemtype();
			try {
				BeanUtils.copyProperties(c, sclassT);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return c;
		}
		return null;
	}

	@Override
	public List<Itemtype> getRootClass(String typeid) {
		List<Itemtype> result = null;
		SclassT sclassT = new SclassT();
		sclassT.setParid(0l);
		sclassT.setTypeid(typeid);
		List<SclassT> list = sclassService.find(sclassT);
		if (null != list && list.size() > 0) {
			result = new ArrayList<Itemtype>();
			Itemtype cate;
			for (SclassT t : list) {
				cate = new Itemtype();
				try {
					BeanUtils.copyProperties(cate, t);
					result.add(cate);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public List<Itemtype> getSubClass(Long classid) {
		List<Itemtype> result = null;
		List<SclassT> list = sclassService.findSubList(classid);
		if (null != list && list.size() > 0) {
			result = new ArrayList<Itemtype>();
			Itemtype cate;
			for (SclassT t : list) {
				cate = new Itemtype();
				try {
					BeanUtils.copyProperties(cate, t);
					result.add(cate);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	

}

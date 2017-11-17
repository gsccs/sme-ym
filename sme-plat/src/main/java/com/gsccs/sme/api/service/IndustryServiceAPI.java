package com.gsccs.sme.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.domain.Industry;
import com.gsccs.sme.api.service.IndustryServiceI;
import com.gsccs.sme.plat.svg.model.IndustryT;
import com.gsccs.sme.plat.svg.service.IndustryService;

/**
 * 行业分类服务接口
 * 
 * @author x.d zhang
 * 
 */
public class IndustryServiceAPI implements IndustryServiceI {

	@Autowired
	private IndustryService industryService;

	@Override
	public Industry getIndustry(Long classId) {
		IndustryT sclassT = industryService.findById(classId);
		if (null != sclassT) {
			Industry c = new Industry();
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
	public List<Industry> getRootList() {
		List<Industry> result = null;
		List<IndustryT> list = industryService.findSubIndustry(0L);
		if (null != list && list.size() > 0) {
			result = new ArrayList<Industry>();
			Industry industry;
			for (IndustryT t : list) {
				industry = new Industry();
				try {
					BeanUtils.copyProperties(industry, t);
					result.add(industry);
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
	public List<Industry> getSubList(Long parid) {
		List<Industry> result = null;
		List<IndustryT> list = industryService.findSubIndustry(parid);
		if (null != list && list.size() > 0) {
			result = new ArrayList<Industry>();
			Industry cate;
			for (IndustryT t : list) {
				cate = new Industry();
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

package com.gsccs.sme.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.Expect;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ExpertServiceI;
import com.gsccs.sme.plat.svg.model.ExpertT;
import com.gsccs.sme.plat.svg.service.ExpertService;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

/**
 * 专家服务接口
 * 
 * @author x.d zhang
 * 
 */
public class ExpertServiceAPI implements ExpertServiceI {

	@Autowired
	private ExpertService expertService;

	@Override
	public Expect getExpert(String id) throws ApiException {
		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		ExpertT expertT = expertService.findById(id);
		if (null != expertT) {
			Expect expert = new Expect();
			try {
				BeanUtils.copyProperties(expert, expertT);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			return expert;
		}
		return null;
	}

	@Override
	public void addExpert(Expect expert) throws ApiException {
		if (null == expert) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		try {
			ExpertT expertT = new ExpertT();
			BeanUtils.copyProperties(expertT, expert);
			expertService.insert(expertT);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateExpert(Expect expert) throws ApiException {
		if (null == expert) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		try {
			ExpertT expertT = new ExpertT();
			BeanUtils.copyProperties(expertT, expert);
			expertService.update(expertT);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Expect> queryExpertList(Expect param, String order, int page,
			int pagesize) throws ApiException {
		List<Expect> list = null;
		ExpertT t = null;
		if (null != param) {
			t = new ExpertT();
			BeanUtilsEx.copyProperties(t, param);
		}

		List<ExpertT> expertTs = expertService.find(t, order, page, pagesize);

		if (null != expertTs && expertTs.size() > 0) {
			list = new ArrayList<Expect>();
			for (ExpertT expertT : expertTs) {
				Expect expert_ = new Expect();
				BeanUtilsEx.copyProperties(expert_, expertT);
				list.add(expert_);
			}
		}
		return list;
	}

	@Override
	public Integer count(Expect param) {
		ExpertT t = null;
		if (null != param) {
			t = new ExpertT();
			BeanUtilsEx.copyProperties(t, param);
		}
		return expertService.count(t);
	}

}

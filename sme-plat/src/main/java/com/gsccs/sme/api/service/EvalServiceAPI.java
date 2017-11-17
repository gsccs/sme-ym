package com.gsccs.sme.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.Sitemeval;
import com.gsccs.sme.api.domain.shop.EvalGoods;
import com.gsccs.sme.api.domain.shop.EvalItem;
import com.gsccs.sme.api.domain.shop.EvalOrder;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.EvalServiceI;
import com.gsccs.sme.plat.svg.model.SevalT;
import com.gsccs.sme.plat.svg.service.SitemService;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

/**
 * 评价服务接口
 * 
 * @author x.d zhang
 * 
 */
public class EvalServiceAPI implements EvalServiceI {

	@Autowired
	private SitemService sitemService;

	@Override
	public void addEvalRemark(Long siteid, EvalGoods detail) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEvalScores(Long siteid, List<EvalOrder> scoreList,
			EvalGoods detail) throws ApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delEvalType(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long addEvalItem(EvalItem evalItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editEvalItem(EvalItem evalItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delEvalItem(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EvalItem> getEvalItems(EvalItem evalItem) {
		// TODO Auto-generated method stub
		return null;
	}

}

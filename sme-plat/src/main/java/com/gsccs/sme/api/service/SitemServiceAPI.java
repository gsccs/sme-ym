package com.gsccs.sme.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.Sitem;
import com.gsccs.sme.api.domain.Sitemeval;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.SitemServiceI;
import com.gsccs.sme.plat.svg.model.SevalT;
import com.gsccs.sme.plat.svg.model.SitemT;
import com.gsccs.sme.plat.svg.service.SclassService;
import com.gsccs.sme.plat.svg.service.SitemService;
import com.gsccs.sme.plat.svg.service.SvorgService;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

/**
 * 服务项服务接口
 * 
 * @author x.d zhang
 * 
 */
public class SitemServiceAPI implements SitemServiceI {

	@Autowired
	private SclassService sclassService;
	@Autowired
	private SitemService sitemService;
	@Autowired
	private SvorgService svorgService;

	@Override
	public Sitem getSitem(Long id) throws ApiException {

		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		SitemT sitemT = sitemService.findById(id);
		if (null != sitemT) {
			Sitem sitem = new Sitem();
			try {
				BeanUtilsEx.copyProperties(sitem, sitemT);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return sitem;
		}
		return null;
	}

	@Override
	public void addSitem(Sitem sitem) throws ApiException {

		if (null == sitem) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		try {
			SitemT sitemT = new SitemT();
			BeanUtils.copyProperties(sitemT, sitem);
			sitemService.insert(sitemT);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delSitem(Long ids) throws ApiException {
	}

	@Override
	public void updateSitem(Sitem sitem) throws ApiException {
		if (null == sitem) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		try {
			SitemT sitemT = new SitemT();
			BeanUtils.copyProperties(sitemT, sitem);
			sitemService.update(sitemT);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Sitem> querySitemList(Sitem param, String order, int page,
			int pagesize) throws ApiException {
		List<Sitem> list = null;
		SitemT t = null;
		if (null != param) {
			t = new SitemT();
			BeanUtilsEx.copyProperties(t, param);
		}

		List<SitemT> sitemTs = sitemService.find(t, order, page, pagesize);

		if (null != sitemTs && sitemTs.size() > 0) {
			list = new ArrayList<Sitem>();
			for (SitemT sitemT : sitemTs) {
				Sitem sitem_ = new Sitem();
				BeanUtilsEx.copyProperties(sitem_, sitemT);
				list.add(sitem_);
			}
		}
		return list;
	}

	@Override
	public int count(Sitem param) {
		if (null != param) {
			SitemT t = new SitemT();
			BeanUtilsEx.copyProperties(t, param);
			return sitemService.count(t);
		}
		return 0;
	}

	@Override
	public void addSitemEval(Sitemeval seval) throws ApiException {
		if (null == seval) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		try {
			SevalT sevalT = new SevalT();
			BeanUtilsEx.copyProperties(sevalT, seval);
			sitemService.insert(sevalT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Sitemeval> findItemEvals(Sitemeval param, String order,
			int page, int pagesize) throws ApiException {
		List<Sitemeval> list = null;
		SevalT t = null;
		if (null != param) {
			t = new SevalT();
			BeanUtilsEx.copyProperties(t, param);
		}

		List<SevalT> sevalTs = sitemService.find(t, order, page, pagesize);

		if (null != sevalTs && sevalTs.size() > 0) {
			list = new ArrayList<Sitemeval>();
			for (SevalT sevalT : sevalTs) {
				Sitemeval seval_ = new Sitemeval();
				BeanUtilsEx.copyProperties(seval_, sevalT);
				list.add(seval_);
			}
		}
		return list;
	}

	@Override
	public int count(Sitemeval param) {
		SevalT t = null;
		if (null != param) {
			t = new SevalT();
			BeanUtilsEx.copyProperties(t, param);
		}
		return sitemService.count(t);
	}

}

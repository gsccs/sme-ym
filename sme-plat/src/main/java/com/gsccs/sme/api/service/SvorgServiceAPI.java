package com.gsccs.sme.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.Svorg;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.SvorgServiceI;
import com.gsccs.sme.plat.svg.model.SvorgT;
import com.gsccs.sme.plat.svg.service.SvorgService;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

public class SvorgServiceAPI implements SvorgServiceI {

	@Autowired
	private SvorgService svorgService;

	@Override
	public Svorg getSvg(Long id) throws ApiException {

		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		SvorgT svorgT = svorgService.findById(id);
		if (null != svorgT) {
			Svorg svorg = new Svorg();
			try {
				BeanUtils.copyProperties(svorg, svorgT);
				return svorg;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void addSvg(Svorg svorg) throws ApiException {
		if (null != svorg) {
			SvorgT svorgT = new SvorgT();
			BeanUtilsEx.copyProperties(svorgT, svorg);
			svorgService.addSvorg(svorgT);
		}

	}

	@Override
	public void updateSvg(Svorg svorg) throws ApiException {

	}

	@Override
	public void delSvg(Long id) throws ApiException {

		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		svorgService.del(id);
	}


	@Override
	public List<Svorg> querySvgList(Svorg o, String orderstr, int page,
			int pagesize) throws ApiException {
		List<Svorg> list = null;
		SvorgT t = new SvorgT();
		if (null != o) {
			BeanUtilsEx.copyProperties(t, o);
		}

		List<SvorgT> svorgTs = svorgService.find(t, orderstr, page, pagesize);

		if (null != svorgTs && svorgTs.size() > 0) {
			list = new ArrayList<Svorg>();
			for (SvorgT sneedt : svorgTs) {
				Svorg sneed_ = new Svorg();
				BeanUtilsEx.copyProperties(sneed_, sneedt);
				list.add(sneed_);
			}
		}
		return list;
	}

	@Override
	public Integer count(Svorg svorg) {
		SvorgT t = new SvorgT();
		if (null != svorg) {
			BeanUtilsEx.copyProperties(t, svorg);
		}
		return svorgService.count(t);
	}

	@Override
	public List<Svorg> querySvgByItemLike(String title) throws ApiException {
		
		return null;
	}

}

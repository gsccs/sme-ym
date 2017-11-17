package com.gsccs.sme.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.corp.Consult;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.plat.svg.service.ConsultService;

/**
 * 
 * @author x.d zhang
 * 
 */
public class ConsultServiceAPI implements ConsultServiceI {

	@Autowired
	private ConsultService consultService;

	@Override
	public Consult getConsult(Long id) throws ApiException {
		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		return consultService.findById(id);
	}

	@Override
	public void addConsult(Consult consult) throws ApiException {
		if (null == consult) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		consultService.insert(consult);
	}

	@Override
	public Datagrid datagrid(Consult param, String order, int page, int pagesize)
			throws ApiException {
		Datagrid datagrid = new Datagrid();
		try {
			datagrid = consultService.datagrid(param, order, page, pagesize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datagrid;
	}

	@Override
	public boolean delete(Long id) throws ApiException {
		consultService.delete(id);
		return false;
	}

	@Override
	public Datagrid getReplyList(Long parid, String order, int page,
			int pagesize) throws ApiException {
		Consult consultT = new Consult();
		consultT.setParid(parid);
		return consultService.datagrid(consultT, order, page, pagesize);
	}

	@Override
	public List<Consult> findConsultList(Consult param, String order, int page,
			int pagesize) throws ApiException {
		return consultService.find(param, order, page, pagesize);
	}

	@Override
	public Integer countConsults(Consult param) throws ApiException {
		return consultService.count(param);
	}

	@Override
	public List<Consult> getReplyListByCorpid(Long corpid, String order,
			int page, int pagesize) throws ApiException {
		return consultService.findReplyByCorpid(corpid, order, page, pagesize);
	}

}

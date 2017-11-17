package com.gsccs.sme.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.CapitalAppl;
import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.api.domain.SneedBid;
import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.plat.corp.service.CorpService;
import com.gsccs.sme.plat.svg.model.SneedAttachT;
import com.gsccs.sme.plat.svg.service.SneedService;

/**
 * 服务需求服务接口
 * 
 * @author x.d zhang
 * 
 */
public class SneedServiceAPI implements SneedServiceI {

	@Autowired
	private SneedService sneedService;
	@Autowired
	private CorpService corpService;

	@Override
	public void addSneed(Sneed sneed) throws ApiException {
		if (null != sneed) {
			Long sneedid = sneedService.addSneed(sneed);
			List<Attach> attachs = sneed.getAttachs();
			if (null != sneedid && null != attachs && attachs.size() > 0) {
				List<SneedAttachT> attachlist = new ArrayList<SneedAttachT>();
				for (Attach attach : attachs) {
					SneedAttachT attachT = new SneedAttachT();
					attachT.setSneedid(sneedid);
					attachT.setFilename(attach.getFilename());
					attachT.setFilepath(attach.getFilepath());
					attachT.setFiletype(attach.getFiletype());
					attachlist.add(attachT);
				}
				sneedService.addAttachs(attachlist);
			}
		}
	}

	@Override
	public Sneed getSneed(Long id) throws ApiException {
		return sneedService.getSneed(id);
	}

	@Override
	public List<Sneed> querySneedList(Sneed param, String orderstr, int page,
			int pagesize) throws ApiException {
		return sneedService.find(param, orderstr, page, pagesize);
	}

	@Override
	public Integer count(Sneed param) throws ApiException {
		return sneedService.count(param);
	}

	@Override
	public void addSneedBid(Long sneedid, Long svgid, String remark)
			throws ApiException {
		if (null == sneedid || null == svgid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		SneedBid sneedBidT = new SneedBid();
		sneedBidT.setSneedid(sneedid);
		sneedBidT.setSvgid(svgid);
		List<SneedBid> list = sneedService.find(sneedid, svgid);
		if (null == list || list.size() <= 0) {
			sneedService.addBid(sneedBidT);
		} else {
			throw new ApiException(APIConst.ERROR_CODE_0003,
					APIConst.ERROR_MSG_0003);
		}
	}

	@Override
	public Datagrid queryBidList(Long sneedid, String orderstr, int page,
			int pagesize) throws ApiException {
		if (null == sneedid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		SneedBid param = new SneedBid();
		param.setSneedid(sneedid);
		List<SneedBid> list = sneedService.find(param, "addtime desc", page,
				pagesize);
		Integer total = sneedService.count(param);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(list);
		datagrid.setTotal(Long.valueOf(total));
		return datagrid;
	}

	@Override
	public void updateSneed(Sneed sneed) throws ApiException {
		if (null != sneed) {
			sneedService.update(sneed);
		}
	}

	@Override
	public void setSneedBidStone(Long bidid) throws ApiException {
		SneedBid sneedBidT = sneedService.find(bidid);
		sneedBidT.setIstoned("1");
		sneedService.updateBid(sneedBidT);
	}

	@Override
	public List<CapitalAppl> find(CapitalAppl param, String order,
			int currPage, int pageSize) {
		return sneedService.find(param, order, currPage, pageSize);
	}

	@Override
	public int count(CapitalAppl param) {
		return sneedService.count(param);
	}

	@Override
	public void addCapitalAppl(CapitalAppl param) {
		sneedService.addCapitalAppl(param);
	}

	@Override
	public CapitalAppl getCapitalAppl(Long id) {
		return sneedService.getCapitalAppl(id);
	}

	@Override
	public void delCapitalAppl(Long id) {
		sneedService.delCapitalAppl(id);
	}

}

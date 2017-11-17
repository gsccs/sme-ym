package com.gsccs.sme.plat.svg.service;

import java.util.List;

import com.gsccs.sme.api.domain.CapitalAppl;
import com.gsccs.sme.api.domain.CapitalReply;
import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.api.domain.SneedBid;
import com.gsccs.sme.plat.svg.model.SneedAttachT;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface SneedService {

	public Long addSneed(Sneed sneed);

	public Sneed getSneed(Long id);

	public void delSneed(Long id);

	public List<Sneed> find(Sneed sneedT);

	public List<Sneed> find(Sneed sneedT, String order, int currPage,
			int pageSize);

	public int count(Sneed sneedT);

	public void update(Sneed sneedT);

	public void addAttachs(List<SneedAttachT> attachs);

	public List<SneedAttachT> findAttachs(Long sneedid);

	// 需求投标
	public List<SneedBid> find(Long sneedid, Long svgid);

	public SneedBid find(Long bidd);

	public void addBid(SneedBid sneedBidT);

	public void updateBid(SneedBid sneedBidT);

	public void delSneedBid(Long id);

	public List<SneedBid> find(SneedBid param, String order, int currPage,
			int pageSize);

	public int count(SneedBid param);

	/**
	 * 融资需求
	 * 
	 * @param param
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public List<CapitalAppl> find(CapitalAppl param, String order,
			int currPage, int pageSize);

	/**
	 * 融资需求响应记录
	 * 
	 * @param param
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public List<CapitalReply> find(CapitalReply param, String order,
			int currPage, int pageSize);

	/**
	 * 融资需求回复记录
	 * 
	 * @param param
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public List<CapitalReply> find(Long applid, String order, int currPage,
			int pageSize);

	public int count(CapitalAppl param);

	public int count(CapitalReply param);

	public void addCapitalAppl(CapitalAppl param);

	public void addCapitalReply(CapitalReply param);

	public CapitalAppl getCapitalAppl(Long id);

	public CapitalReply getCapitalReply(Long id);

	public void delCapitalAppl(Long id);

	public void delCapitalReply(Long id);
}

package com.gsccs.sme.plat.auth.service;

import java.util.List;

import com.gsccs.sme.plat.auth.model.MsgT;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface MsgService {

	public void createMsg(MsgT param);
	public void updateMsg(MsgT param);

	public void deleteMsg(String appId);

	public MsgT findById(String appId);

	public List<MsgT> find(MsgT param, String order, int currPage, int pageSize);

	public Integer count(MsgT param);

}

package com.gsccs.sme.plat.auth.service;

import java.util.List;

import com.gsccs.sme.plat.auth.model.Sms;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface SmsService {

	public Sms createSme(Sms app);

	public void deleteSme(Long appId);

	public List<Sms> find(Sms param, String order, int currPage, int pageSize);

	public Integer count(Sms param);

	public void sendMsg(String[] mobiles, String content);

	public void sendMsg(Long orgid, String content);

}

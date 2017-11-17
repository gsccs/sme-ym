package com.gsccs.sme.plat.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.auth.dao.SessionTMapper;
import com.gsccs.sme.plat.auth.model.SessionT;
import com.gsccs.sme.plat.auth.model.SessionTExample;
import com.gsccs.sme.plat.auth.model.SessionTExample.Criteria;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	private SessionTMapper sessionTMapper;

	@Override
	public String getSession(String appKey, String sessionId) {
		SessionTExample example = new SessionTExample();
		Criteria c = example.createCriteria();
		c.andIdEqualTo(sessionId);
		List<SessionT> stList = sessionTMapper.selectByExample(example);
		if (null == stList || stList.size() == 0) {
			return null;
		}
		return stList.get(0).getSession();
	}

	@Override
	public String createSession(String appKey, String sessionId, String session) {
		SessionT sessionT = new SessionT();
		sessionT.setId(sessionId);
		sessionT.setSession(session);
		sessionTMapper.insert(sessionT);
		return sessionId;

	}

	@Override
	public void updateSession(String appKey, String id, String session) {
		SessionT sessionT = new SessionT();
		sessionT.setId(id);
		sessionT.setSession(session);
		sessionTMapper.updateByPrimaryKey(sessionT);
	}

	@Override
	public void deleteSession(String appKey, String id) {
		sessionTMapper.deleteByPrimaryKey(id);
	}

}

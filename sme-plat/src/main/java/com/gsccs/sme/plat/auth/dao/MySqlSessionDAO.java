package com.gsccs.sme.plat.auth.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.plat.auth.dao.SessionTMapper;
import com.gsccs.sme.plat.auth.model.SessionT;
import com.gsccs.sme.plat.auth.model.SessionTExample;
import com.gsccs.sme.plat.auth.model.SessionTExample.Criteria;
import com.gsccs.sme.plat.utils.SerializableUtils;

/**
 * 会话管理
 * @author x.d zhang
 *
 */
public class MySqlSessionDAO extends CachingSessionDAO {

	@Autowired
	private SessionTMapper sessionTMapper;

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		SessionT sessionT = new SessionT();
		sessionT.setId(sessionId.toString());
		sessionT.setSession(SerializableUtils.serialize(session));
		sessionTMapper.insert(sessionT);
		return session.getId();
	}

	@Override
	protected void doUpdate(Session session) {
		
		if (session instanceof ValidatingSession
				&& !((ValidatingSession) session).isValid()) {
			return; // 如果会话过期/停止 没必要再更新了
		}

		SessionT sessionT = new SessionT();
		sessionT.setId(session.getId().toString());
		sessionT.setSession(SerializableUtils.serialize(session));
		sessionTMapper.updateByPrimaryKey(sessionT);
	}

	@Override
	protected void doDelete(Session session) {
		sessionTMapper.deleteByPrimaryKey(session.getId().toString());
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		SessionTExample example = new SessionTExample();
		Criteria c = example.createCriteria();
		c.andIdEqualTo(sessionId.toString());
		List<SessionT> stList = sessionTMapper.selectByExample(example);
		if (null == stList || stList.size() == 0){
			return null;
		}
		return SerializableUtils.deserialize(stList.get(0).getSession());
	}
}

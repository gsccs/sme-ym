package com.gsccs.sme.shiro.client;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

import com.gsccs.sme.api.service.PermissionServiceI;

/**
 * User: x.d zhang Date: 15-1-13 Version: 1.0
 * 
 */
public class ClientSessionDAO extends CachingSessionDAO {

	private PermissionServiceI permissionAPI;
	private String appKey;

	public PermissionServiceI getPermissionAPI() {
		return permissionAPI;
	}

	public void setPermissionAPI(PermissionServiceI permissionAPI) {
		this.permissionAPI = permissionAPI;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	@Override
	protected void doDelete(Session session) {
		permissionAPI.deleteSession(appKey, session.getId().toString());
	}

	@Override
	protected void doUpdate(Session session) {

		if (session instanceof ValidatingSession
				&& !((ValidatingSession) session).isValid()) {
			return; // 如果会话过期/停止 没必要再更新了
		}
		String id = session.getId().toString();
		String sessionStr = SerializableUtils.serialize(session);
		permissionAPI.updateSession(appKey, id, sessionStr);
	}

	@Override
	protected Serializable doCreate(Session session) {

		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		permissionAPI.createSession(appKey, sessionId.toString(),
				SerializableUtils.serialize(session));
		return session.getId();
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		String session = permissionAPI.getSession(appKey, sessionId.toString());
		if (null != session && session.trim().length() > 0) {
			return SerializableUtils.deserialize(session);
		}
		return null;
	}
}

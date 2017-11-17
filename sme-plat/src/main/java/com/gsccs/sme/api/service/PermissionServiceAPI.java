package com.gsccs.sme.api.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.gsccs.sme.api.domain.base.Permission;
import com.gsccs.sme.api.service.PermissionServiceI;
import com.gsccs.sme.plat.Constants;
import com.gsccs.sme.plat.auth.model.Resource;
import com.gsccs.sme.plat.auth.model.User;
import com.gsccs.sme.plat.auth.service.AuthService;
import com.gsccs.sme.plat.auth.service.ResourceService;
import com.gsccs.sme.plat.auth.service.SessionService;

/**
 * User: x.d zhang Date: 14-3-13 Version: 1.0
 */
public class PermissionServiceAPI implements PermissionServiceI {

	@Autowired
	private AuthService authService;
	@Autowired
	private SessionService sessionService;

	@Autowired
	private ResourceService resourceService;

	/**
	 * @Override public Session getSession(String appKey, Serializable
	 *           sessionId) { return sessionDAO.readSession(sessionId); }
	 * @Override public Serializable createSession(Session session) { return
	 *           sessionDAO.create(session); }
	 * @Override public void updateSession(String appKey, Session session) {
	 *           sessionDAO.update(session); }
	 * @Override public void deleteSession(String appKey, Session session) {
	 *           sessionDAO.delete(session); }
	 **/

	@Override
	public Permission getPermissions(String appKey, String username) {
		Permission permissionContext = new Permission();
		permissionContext.setRoles(authService.findRoles(appKey, username));
		permissionContext.setPermissions(authService.findPermissions(appKey,
				username));
		return permissionContext;
	}

	public List<Resource> menu(User loginUser, Long pid, Model model) {
		Set<String> permissions = authService.findPermissions(
				Constants.SERVER_APP_KEY, loginUser.getAccount());
		if (null == pid) {
			pid = 1l;
		}
		/*
		 * Resource param = new Resource(); param.setParentId(pid);
		 */
		return resourceService.findMenus(permissions);
	}

	@Override
	public String getSession(String appKey, String sessionId) {
		return sessionService.getSession(appKey, sessionId);
	}

	@Override
	public String createSession(String appKey, String sessionId, String session) {
		return sessionService.createSession(appKey, sessionId, session);
	}

	@Override
	public void updateSession(String appKey, String id, String session) {
		sessionService.updateSession(appKey, id, session);
	}

	@Override
	public void deleteSession(String appKey, String id) {
		sessionService.deleteSession(appKey, id);
	}
}

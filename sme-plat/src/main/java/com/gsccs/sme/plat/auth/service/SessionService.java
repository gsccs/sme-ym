package com.gsccs.sme.plat.auth.service;

public interface SessionService {
	
	public String getSession(String appKey, String sessionId);
	
	public String createSession(String appKey, String sessionId, String session);
	
	public void updateSession(String appKey, String id, String session);

	public void deleteSession(String appKey, String id);
}

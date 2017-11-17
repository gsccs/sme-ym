package com.gsccs.sme.shiro.client;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;

import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.app.core.ClientSavedRequest;

/**
 * <p>
 * User: x.d zhang
 * <p>
 * Date: 14-3-14
 * <p>
 * Version: 1.0
 */
public class ClientAuthenticationFilter extends AuthenticationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) {
		Subject subject = getSubject(request, response);
		return subject.isAuthenticated();
	}
	
	

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		String backUrl = request.getParameter("backUrl");
		System.out.println("backUrl:" + backUrl);

		if (!"XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request)
				.getHeader("X-Requested-With"))) {// 不是ajax请求
			
			// saveRequestAndRedirectToLogin(request, response);
			saveRequest(request, backUrl,
					getDefaultBackUrl(WebUtils.toHttp(request)));
			redirectToLogin(request, response);
		} else {
			JSONObject json = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			json.put("success", false);
			json.put("message", "login");
			json.put("code", "login");
			out.write(json.toJSONString());
			//out.println("{message:'login'}");
			out.flush();
			out.close();
		}
		return false;
	}

	protected void saveRequest(ServletRequest request, String backUrl,
			String fallbackUrl) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		HttpServletRequest httpRequest = WebUtils.toHttp(request);
		session.setAttribute("authc.fallbackUrl", fallbackUrl);
		SavedRequest savedRequest = new ClientSavedRequest(httpRequest, backUrl);
		session.setAttribute(WebUtils.SAVED_REQUEST_KEY, savedRequest);
	}

	private String getDefaultBackUrl(HttpServletRequest request) {
		String scheme = request.getScheme();
		String domain = request.getServerName();
		int port = request.getServerPort();
		String contextPath = request.getContextPath();
		StringBuilder backUrl = new StringBuilder(scheme);
		backUrl.append("://");
		backUrl.append(domain);
		if ("http".equalsIgnoreCase(scheme) && port != 80) {
			backUrl.append(":").append(String.valueOf(port));
		} else if ("https".equalsIgnoreCase(scheme) && port != 443) {
			backUrl.append(":").append(String.valueOf(port));
		}
		backUrl.append(contextPath);
		backUrl.append(getSuccessUrl());
		return backUrl.toString();
	}

}

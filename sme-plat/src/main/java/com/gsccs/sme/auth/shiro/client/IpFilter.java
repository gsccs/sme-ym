package com.gsccs.sme.auth.shiro.client;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

/**
 * IP地址过滤
 * 
 * @author x.d zhang
 * 
 */
public class IpFilter extends AuthorizationFilter {

	private static final Logger log = Logger.getLogger(IpFilter.class);

	protected static final String[] blackUrlPathPattern = new String[] {
			"*.jar*", "*.class*", "*.lnk*" };

	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String reqUrl = httpRequest.getRequestURI().toLowerCase().trim();

		String clientip = getIpAddr(httpRequest);
		log.info(new StringBuffer()
		.append("unsafe request >>> ")
		.append(" request time: ")
		.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date())).append("; request ip: ")
		.append(clientip)
		.append("; request url: ")
		.append(httpRequest.getRequestURI()).toString());

		return true;
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		log.info("X-Real-IP:"+ip);
		if (null != ip && !"".equals(ip.trim())
				&& !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		log.info("X-Forwarded-For:"+ip);
		if (null != ip && !"".equals(ip.trim())
				&& !"unknown".equalsIgnoreCase(ip)) {
			// get first ip from proxy ip
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		return request.getRemoteAddr();
	}

}

package com.gsccs.sme.plat.auth.service;

public class OssClientConfig {

	private String oss_ip = "117.156.25.9";
	private int oss_port = 7001;
	private String oss_domain = "http://dns1.smeym.org/";

	private String oss_site = "smeym";
	private String oss_path = "images";

	public String getOss_ip_() {
		return oss_ip;
	}

	public void setOss_ip(String oss_ip) {
		this.oss_ip = oss_ip;
	}

	public int getOss_port() {
		return oss_port;
	}

	public void setOss_port(int oss_port) {
		this.oss_port = oss_port;
	}

	public String getOss_domain() {
		return oss_domain;
	}

	public void setOss_domain(String oss_domain) {
		this.oss_domain = oss_domain;
	}

	public String getOss_site() {
		return oss_site;
	}

	public void setOss_site(String oss_site) {
		this.oss_site = oss_site;
	}

	public String getOss_path() {
		return oss_path;
	}

	public void setOss_path(String oss_path) {
		this.oss_path = oss_path;
	}

}

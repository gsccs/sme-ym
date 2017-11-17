package com.gsccs.sme.plat.bass.service;

import org.apache.solr.client.solrj.beans.Field;

/**
 * 
 * @author x.d zhang
 * 
 */
public class SolrSchema {

	@Field
	private String id;
	@Field
	private String siteid;
	@Field
	private String title;
	@Field
	private String cateid;
	@Field
	private String catestr;
	@Field
	private String url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getCateid() {
		return cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getCatestr() {
		return catestr;
	}

	public void setCatestr(String catestr) {
		this.catestr = catestr;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}

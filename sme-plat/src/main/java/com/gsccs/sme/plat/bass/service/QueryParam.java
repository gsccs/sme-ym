package com.gsccs.sme.plat.bass.service;

/**
 * 查询参数
 * 
 * @author x.d zhang
 * 
 */
public class QueryParam {

	private String siteId;
	private String keyword;
	private String cateId;

	// 分页参数
	private int page = 1;
	private int rows = 10;

	private String order = "score desc";

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getStart() {
		return (getPage() - 1) * getRows();
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}

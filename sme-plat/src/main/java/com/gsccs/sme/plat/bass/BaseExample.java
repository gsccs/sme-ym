package com.gsccs.sme.plat.bass;

/**
 * 共用的属性和方法
 * 
 * @author x.d zhang
 */
public class BaseExample {

	protected int currPage;
	protected int pageSize;
	protected int skip;

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSkip() {
		return (currPage - 1) * pageSize;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}
}

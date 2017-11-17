package com.gsccs.sme.api.domain.base;

import java.util.List;

/**
 * 查询分页结构
 * 
 * @author x.d zhang
 * 
 */
public class Page<T> extends Domain {

	private static final long serialVersionUID = 5825627239529684672L;

	/**
	 * 当前页码数
	 */
	private int pageNum;

	/**
	 * 分页记录个数，如果用户输入的记录数大于50，则一页显示50条记录
	 */
	private int pageSize = 10;

	/**
	 * 总记录个数
	 */
	private long totalRow;

	/**
	 * 当前页记录
	 */
	private List<T> items;

	public Page(int pageNum, int pageSize, long totalRow, List<T> items) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRow = totalRow;
		this.items = items;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(long totalRow) {
		this.totalRow = totalRow;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

}

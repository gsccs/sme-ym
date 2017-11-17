package com.gsccs.sme.api.domain.base;

import java.io.Serializable;

public class Datagrid implements Serializable{

	private Long total;
	private Object rows;
	private Object footer;
	
	public Object getRows() {
		return rows;
	}
	public void setRows(Object rows) {
		this.rows = rows;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Object getFooter() {
		return footer;
	}
	public void setFooter(Object footer) {
		this.footer = footer;
	}
}

package com.gsccs.sme.plat.bass;

public class Datagrid {

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

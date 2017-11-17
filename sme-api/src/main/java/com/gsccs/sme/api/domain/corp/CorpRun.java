package com.gsccs.sme.api.domain.corp;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 企业经营数据
 * 
 * @author x.d zhang
 * 
 */
public class CorpRun extends Domain{

	private Long id;
	private Long corpid;
	private Integer year;
	private Integer employee;
	private Float sale;
	private Float assets;
	private Float profits;
	private Float tax;
	private Float debt;

	private String corptitle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCorpid() {
		return corpid;
	}

	public void setCorpid(Long corpid) {
		this.corpid = corpid;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getEmployee() {
		return employee;
	}

	public void setEmployee(Integer employee) {
		this.employee = employee;
	}

	public Float getSale() {
		return sale;
	}

	public void setSale(Float sale) {
		this.sale = sale;
	}

	public Float getAssets() {
		return assets;
	}

	public void setAssets(Float assets) {
		this.assets = assets;
	}

	public Float getProfits() {
		return profits;
	}

	public void setProfits(Float profits) {
		this.profits = profits;
	}

	public Float getTax() {
		return tax;
	}

	public void setTax(Float tax) {
		this.tax = tax;
	}

	public Float getDebt() {
		return debt;
	}

	public void setDebt(Float debt) {
		this.debt = debt;
	}

	public String getCorptitle() {
		return corptitle;
	}

	public void setCorptitle(String corptitle) {
		this.corptitle = corptitle;
	}

}
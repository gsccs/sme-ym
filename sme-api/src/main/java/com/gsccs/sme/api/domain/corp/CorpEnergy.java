package com.gsccs.sme.api.domain.corp;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 能耗
 * @author x.d zhang
 *
 */
public class CorpEnergy extends Domain {

	private Long id;
	private Long corpid;
	private Integer year;
	private Integer month;
	private Float grossnum;
	private Float addednum;

	private Float allnum;
	private Float electrnum;
	private Float waternum;
	private Float grosspower;
	private Float grosselectr;
	private Float grosswater;
	private Float addedpower;
	private Float addedelectr;
	private Float addedwater;

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

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Float getGrossnum() {
		return grossnum;
	}

	public void setGrossnum(Float grossnum) {
		this.grossnum = grossnum;
	}

	public Float getAddednum() {
		return addednum;
	}

	public void setAddednum(Float addednum) {
		this.addednum = addednum;
	}

	public Float getAllnum() {
		return allnum;
	}

	public void setAllnum(Float allnum) {
		this.allnum = allnum;
	}

	public Float getElectrnum() {
		return electrnum;
	}

	public void setElectrnum(Float electrnum) {
		this.electrnum = electrnum;
	}

	public Float getWaternum() {
		return waternum;
	}

	public void setWaternum(Float waternum) {
		this.waternum = waternum;
	}

	public Float getGrosspower() {
		return grosspower;
	}

	public void setGrosspower(Float grosspower) {
		this.grosspower = grosspower;
	}

	public Float getGrosselectr() {
		return grosselectr;
	}

	public void setGrosselectr(Float grosselectr) {
		this.grosselectr = grosselectr;
	}

	public Float getGrosswater() {
		return grosswater;
	}

	public void setGrosswater(Float grosswater) {
		this.grosswater = grosswater;
	}

	public Float getAddedpower() {
		return addedpower;
	}

	public void setAddedpower(Float addedpower) {
		this.addedpower = addedpower;
	}

	public Float getAddedelectr() {
		return addedelectr;
	}

	public void setAddedelectr(Float addedelectr) {
		this.addedelectr = addedelectr;
	}

	public Float getAddedwater() {
		return addedwater;
	}

	public void setAddedwater(Float addedwater) {
		this.addedwater = addedwater;
	}

}
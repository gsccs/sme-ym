package com.gsccs.sme.api.domain.corp;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 企业用水
 * 
 * @author x.d zhang
 * 
 */
public class CorpWater extends Domain {

	private Long id;

	private Long corpid;
	private Integer year;
	private Integer month;
	private Float qDb;
	private Float qDx;
	private Float qZl;
	private Float qQt;
	private Float qSum;
	private Float yGynew;
	private Float yFgynew;
	private Float yWgnew;

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

	public Float getqDb() {
		return qDb;
	}

	public void setqDb(Float qDb) {
		this.qDb = qDb;
	}

	public Float getqDx() {
		return qDx;
	}

	public void setqDx(Float qDx) {
		this.qDx = qDx;
	}

	public Float getqZl() {
		return qZl;
	}

	public void setqZl(Float qZl) {
		this.qZl = qZl;
	}

	public Float getqQt() {
		return qQt;
	}

	public void setqQt(Float qQt) {
		this.qQt = qQt;
	}

	public Float getqSum() {
		return qSum;
	}

	public void setqSum(Float qSum) {
		this.qSum = qSum;
	}

	public Float getyGynew() {
		return yGynew;
	}

	public void setyGynew(Float yGynew) {
		this.yGynew = yGynew;
	}

	public Float getyFgynew() {
		return yFgynew;
	}

	public void setyFgynew(Float yFgynew) {
		this.yFgynew = yFgynew;
	}

	public Float getyWgnew() {
		return yWgnew;
	}

	public void setyWgnew(Float yWgnew) {
		this.yWgnew = yWgnew;
	}

}
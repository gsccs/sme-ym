package com.gsccs.sme.api.domain;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 行政单位数据统计公
 * 
 * @author x.d zhang
 * 
 */
public class StatistGovNum extends Domain {

	private String id;
	//
	private String title;
	//行政事项数
	private Integer atopicnum;
	//行政服务次数
	private Integer aitemnum;
	//项目社保主题数
	private Integer dtopicnum;
	//项目申报次数
	private Integer ditemnum;
	//信息报送条数
	private Integer infonum;
	//数据报送次数
	private Integer reportnum;


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

	public Integer getAtopicnum() {
		return atopicnum;
	}

	public void setAtopicnum(Integer atopicnum) {
		this.atopicnum = atopicnum;
	}

	public Integer getAitemnum() {
		return aitemnum;
	}

	public void setAitemnum(Integer aitemnum) {
		this.aitemnum = aitemnum;
	}

	public Integer getDtopicnum() {
		return dtopicnum;
	}

	public void setDtopicnum(Integer dtopicnum) {
		this.dtopicnum = dtopicnum;
	}

	public Integer getDitemnum() {
		return ditemnum;
	}

	public void setDitemnum(Integer ditemnum) {
		this.ditemnum = ditemnum;
	}

	public Integer getInfonum() {
		return infonum;
	}

	public void setInfonum(Integer infonum) {
		this.infonum = infonum;
	}

	public Integer getReportnum() {
		return reportnum;
	}

	public void setReportnum(Integer reportnum) {
		this.reportnum = reportnum;
	}

}

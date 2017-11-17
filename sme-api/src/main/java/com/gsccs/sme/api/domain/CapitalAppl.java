package com.gsccs.sme.api.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 融资需求申请
 * @author x.d zhang
 *
 */
public class CapitalAppl extends Domain{

	private Long id;
	private Long corpid;
	private Long svgid;
	private Float loan;
	private String dbtype;
	private Integer month;
	private String usefor;
	private Date addtime;
	private String status;
	private String linker;
	private String linktel;
	private String corptitle;
	private String addtimestr;

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

	public Long getSvgid() {
		return svgid;
	}

	public void setSvgid(Long svgid) {
		this.svgid = svgid;
	}

	public Float getLoan() {
		return loan;
	}

	public void setLoan(Float loan) {
		this.loan = loan;
	}

	public String getDbtype() {
		return dbtype;
	}

	public void setDbtype(String dbtype) {
		this.dbtype = dbtype;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getUsefor() {
		return usefor;
	}

	public void setUsefor(String usefor) {
		this.usefor = usefor;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLinker() {
		return linker;
	}

	public void setLinker(String linker) {
		this.linker = linker;
	}

	public String getLinktel() {
		return linktel;
	}

	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}

	public String getCorptitle() {
		return corptitle;
	}

	public void setCorptitle(String corptitle) {
		this.corptitle = corptitle;
	}

	public String getAddtimestr() {
		if (null != getAddtime()) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			addtimestr = df.format(getAddtime());
		}
		return addtimestr;
	}

	public void setAddtimestr(String addtimestr) {
		this.addtimestr = addtimestr;
	}

}
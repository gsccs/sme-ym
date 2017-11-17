package com.gsccs.sme.api.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.Domain;

/**
 * 申报主题
 * 
 * @author x.d zhang
 * 
 */
public class DeclareTopic extends Domain {

	private Long id;
	private String title;
	private Long svgid;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date starttime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endtime;

	// 申报条件
	private String condit;
	// 申报内容
	private String content;
	// 申报流程
	private String decflow;
	// 申报类型
	private String dectype;
	private String status;

	private List<Attach> attachs;
	private String svgtitle;
	private String dectypestr;
	private String starttimestr;
	private String endtimestr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSvgid() {
		return svgid;
	}

	public void setSvgid(Long svgid) {
		this.svgid = svgid;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCondit() {
		return condit;
	}

	public void setCondit(String condit) {
		this.condit = condit;
	}

	public String getDecflow() {
		return decflow;
	}

	public void setDecflow(String decflow) {
		this.decflow = decflow;
	}

	public String getDectype() {
		return dectype;
	}

	public void setDectype(String dectype) {
		this.dectype = dectype;
	}

	public String getSvgtitle() {
		return svgtitle;
	}

	public void setSvgtitle(String svgtitle) {
		this.svgtitle = svgtitle;
	}

	public String getStarttimestr() {
		if (null != starttime) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			starttimestr = df.format(starttime);
		}
		return starttimestr;
	}

	public void setStarttimestr(String starttimestr) {
		this.starttimestr = starttimestr;
	}

	public String getEndtimestr() {
		if (null != endtime) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			endtimestr = df.format(endtime);
		}
		return endtimestr;
	}

	public void setEndtimestr(String endtimestr) {
		this.endtimestr = endtimestr;
	}
	
	public String getDectypestr() {
		return dectypestr;
	}

	public void setDectypestr(String dectypestr) {
		this.dectypestr = dectypestr;
	}

	public List<Attach> getAttachs() {
		return attachs;
	}

	public void setAttachs(List<Attach> attachs) {
		this.attachs = attachs;
	}

}
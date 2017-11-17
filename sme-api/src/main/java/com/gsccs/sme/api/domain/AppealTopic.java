package com.gsccs.sme.api.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.Domain;

/**
 * 行政诉求办理事项
 * 
 * @author x.d zhang
 * 
 */
public class AppealTopic extends Domain {

	private Long id;
	private String title;
	private Long svgid;
	private Long scode;
	private Long subscode;
	private String remark;
	private Integer daynum;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date addtime;
	private String status;
	private String workflow;

	private String starobj; 	// 办理对象
	private String scondit; 	// 办理条件
	private String swindow; 	// 办理窗口
	private String sbasis; 		// 办理依据

	private Integer indexnum;
	private List<Attach> attachs;

	private String url;
	private String svgtitle;
	private String svglogo;
	private String sclassstr;
	private Integer titlelen;
	private Integer remarklen;
	private String showtitle;
	private String showremark;

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

	public Long getScode() {
		return scode;
	}

	public void setScode(Long scode) {
		this.scode = scode;
	}

	public Long getSubscode() {
		return subscode;
	}

	public void setSubscode(Long subscode) {
		this.subscode = subscode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getDaynum() {
		return daynum;
	}

	public void setDaynum(Integer daynum) {
		this.daynum = daynum;
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

	public String getWorkflow() {
		return workflow;
	}

	public void setWorkflow(String workflow) {
		this.workflow = workflow;
	}

	public String getStarobj() {
		return starobj;
	}

	public void setStarobj(String starobj) {
		this.starobj = starobj;
	}

	public String getScondit() {
		return scondit;
	}

	public void setScondit(String scondit) {
		this.scondit = scondit;
	}

	public String getSwindow() {
		return swindow;
	}

	public void setSwindow(String swindow) {
		this.swindow = swindow;
	}

	public String getSbasis() {
		return sbasis;
	}

	public void setSbasis(String sbasis) {
		this.sbasis = sbasis;
	}

	public Integer getIndexnum() {
		return indexnum;
	}

	public void setIndexnum(Integer indexnum) {
		this.indexnum = indexnum;
	}

	public List<Attach> getAttachs() {
		return attachs;
	}

	public void setAttachs(List<Attach> attachs) {
		this.attachs = attachs;
	}

	public String getSvgtitle() {
		return svgtitle;
	}

	public void setSvgtitle(String svgtitle) {
		this.svgtitle = svgtitle;
	}

	public String getSclassstr() {
		return sclassstr;
	}

	public void setSclassstr(String sclassstr) {
		this.sclassstr = sclassstr;
	}

	public Integer getTitlelen() {
		return titlelen;
	}

	public void setTitlelen(Integer titlelen) {
		this.titlelen = titlelen;
	}

	public String getShowtitle() {
		showtitle = title;
		if (null != titlelen && titlelen > 0) {
			if (null != title && title.length() > titlelen) {
				showtitle = title.substring(0, titlelen);
			}
		}
		return showtitle;
	}

	public void setShowtitle(String showtitle) {
		this.showtitle = showtitle;
	}

	public Integer getRemarklen() {
		return remarklen;
	}

	public void setRemarklen(Integer remarklen) {
		this.remarklen = remarklen;
	}

	public String getShowremark() {
		showremark = remark;
		if (null != remarklen && remarklen > 0) {
			if (null != remark && remark.length() > remarklen) {
				showremark = remark.substring(0, remarklen);
			}
		}
		return showremark;
	}

	public void setShowremark(String showremark) {
		this.showremark = showremark;
	}

	public String getSvglogo() {
		return svglogo;
	}

	public void setSvglogo(String svglogo) {
		this.svglogo = svglogo;
	}

	public String getUrl() {
		url = "/appeal-" + id + ".html";
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
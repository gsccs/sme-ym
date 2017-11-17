package com.gsccs.sme.api.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.Domain;

/**
 * 活动数据结构
 * 
 * @author x.d zhang
 * 
 */
public class Activity extends Domain {

	private static final long serialVersionUID = 4468427473728698992L;

	private Long id;
	private Long svgid; // 主办单位
	private Long scode;
	private Long subscode;
	private String title;
	private String img;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date addtime;
	private Integer clicknum;
	private String linker;
	private String linktel;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date starttime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date endtime;

	private String remark;
	private String status;
	private Integer usernum;
	private String orgnum;
	private Integer pcode;
	private Integer ccode;
	private Integer acode;
	private String address;
	private Long undertake;
	private String content;
	// 是否发布
	private String isrelease;

	private Integer titlelen;
	private Integer remarklen;
	private String dateformat;
	private String showtitle;
	private String showremark;
	private String svgtitle;
	private String svglogo;
	private String sclassstr;
	private String areastr;
	private String starttimestr;
	private String endtimestr;
	private String addtimestr;

	private String url;
	private List<Attach> attachs;

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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Integer getClicknum() {
		return clicknum;
	}

	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getUsernum() {
		return usernum;
	}

	public void setUsernum(Integer usernum) {
		this.usernum = usernum;
	}

	public String getOrgnum() {
		return orgnum;
	}

	public void setOrgnum(String orgnum) {
		this.orgnum = orgnum;
	}

	public Integer getPcode() {
		return pcode;
	}

	public void setPcode(Integer pcode) {
		this.pcode = pcode;
	}

	public Integer getCcode() {
		return ccode;
	}

	public void setCcode(Integer ccode) {
		this.ccode = ccode;
	}

	public Integer getAcode() {
		return acode;
	}

	public void setAcode(Integer acode) {
		this.acode = acode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getUndertake() {
		return undertake;
	}

	public void setUndertake(Long undertake) {
		this.undertake = undertake;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getTitlelen() {
		return titlelen;
	}

	public void setTitlelen(Integer titlelen) {
		this.titlelen = titlelen;
	}

	public String getDateformat() {
		return dateformat;
	}

	public void setDateformat(String dateformat) {
		this.dateformat = dateformat;
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

	public String getAreastr() {
		return areastr;
	}

	public void setAreastr(String areastr) {
		this.areastr = areastr;
	}

	public String getStarttimestr() {
		if (dateformat == null || dateformat.trim().length() == 0) {
			dateformat = "yyyy-MM-dd HH:mm";
		}
		if (starttime != null) {
			starttimestr = new SimpleDateFormat(dateformat).format(starttime);
		}
		return starttimestr;
	}

	public void setStarttimestr(String starttimestr) {
		this.starttimestr = starttimestr;
	}

	public String getEndtimestr() {
		if (dateformat == null || dateformat.trim().length() == 0) {
			dateformat = "yyyy-MM-dd HH:mm";
		}
		if (endtime != null) {
			endtimestr = new SimpleDateFormat(dateformat).format(endtime);
		}
		return endtimestr;
	}

	public void setEndtimestr(String endtimestr) {
		this.endtimestr = endtimestr;
	}

	public String getSvglogo() {
		return svglogo;
	}

	public void setSvglogo(String svglogo) {
		this.svglogo = svglogo;
	}

	public String getIsrelease() {
		return isrelease;
	}

	public void setIsrelease(String isrelease) {
		this.isrelease = isrelease;
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

	public List<Attach> getAttachs() {
		return attachs;
	}

	public void setAttachs(List<Attach> attachs) {
		this.attachs = attachs;
	}

	public String getUrl() {
		url = "/activity-" + id + ".html";
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAddtimestr() {
		if (dateformat == null || dateformat.trim().length() == 0) {
			dateformat = "yyyy-MM-dd HH:mm";
		}
		if (addtime != null) {
			addtimestr = new SimpleDateFormat(dateformat).format(addtime);
		}
		return addtimestr;
	}

	public void setAddtimestr(String addtimestr) {
		this.addtimestr = addtimestr;
	}

}

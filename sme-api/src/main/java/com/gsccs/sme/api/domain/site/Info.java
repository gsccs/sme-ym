package com.gsccs.sme.api.domain.site;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.Domain;

public class Info extends Domain {

	private static final long serialVersionUID = 3897573635852722321L;

	private Long id;
	private String title;
	private Long channelid;
	private List<Long> channelids;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date addtime;
	private String remark;
	private String source;
	private String author;
	private Integer clicknum;
	private String img;
	private String istop;
	private String ishot;
	private String isimg;
	private Integer indexnum;
	private String status;
	private String template;
	private Long svgid;
	private String content;
	private String isrelease;
	private List<Attach> attachs;

	// 信息发布者ID
	private Long userid;
	private Integer titlelen;
	private String shorttitle;
	private Integer remarklen;
	private String showremark;

	private String addtimestr;
	private String dateformat;
	private String showtitle;
	private String channelstr;
	private String svgtitle;
	private String usertitle;

	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public Long getChannelid() {
		return channelid;
	}

	public void setChannelid(Long channelid) {
		this.channelid = channelid;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source == null ? null : source.trim();
	}

	public Integer getClicknum() {
		return clicknum;
	}

	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img == null ? null : img.trim();
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getTitlelen() {
		return titlelen;
	}

	public void setTitlelen(Integer titlelen) {
		this.titlelen = titlelen;
	}

	public String getAddtimestr() {
		if (dateformat == null || dateformat.trim().length() == 0) {
			dateformat = "yyyy-MM-dd";
		}
		if (addtime != null) {
			addtimestr = new SimpleDateFormat(dateformat).format(addtime);
		}
		return addtimestr;
	}

	public void setAddtimestr(String addtimestr) {
		this.addtimestr = addtimestr;
	}

	public String getDateformat() {
		return dateformat;
	}

	public void setDateformat(String dateformat) {
		this.dateformat = dateformat;
	}

	public String getShorttitle() {
		return shorttitle;
	}

	public void setShorttitle(String shorttitle) {
		this.shorttitle = shorttitle;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIstop() {
		return istop;
	}

	public void setIstop(String istop) {
		this.istop = istop;
	}

	public String getIshot() {
		return ishot;
	}

	public void setIshot(String ishot) {
		this.ishot = ishot;
	}

	public String getIsimg() {
		return isimg;
	}

	public void setIsimg(String isimg) {
		this.isimg = isimg;
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

	public Long getSvgid() {
		return svgid;
	}

	public void setSvgid(Long svgid) {
		this.svgid = svgid;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getChannelstr() {
		return channelstr;
	}

	public void setChannelstr(String channelstr) {
		this.channelstr = channelstr;
	}

	public String getSvgtitle() {
		return svgtitle;
	}

	public void setSvgtitle(String svgtitle) {
		this.svgtitle = svgtitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsertitle() {
		return usertitle;
	}

	public void setUsertitle(String usertitle) {
		this.usertitle = usertitle;
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

	
	public List<Long> getChannelids() {
		return channelids;
	}

	public void setChannelids(List<Long> channelids) {
		this.channelids = channelids;
	}

	public String getUrl() {
		if (null == url || url.trim().length() <= 0) {
			url = "/info-" + id + ".html";
		}
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
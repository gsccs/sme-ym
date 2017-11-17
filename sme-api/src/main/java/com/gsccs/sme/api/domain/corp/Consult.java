package com.gsccs.sme.api.domain.corp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.Domain;

/**
 * 咨询域对象
 * 
 * @author x.d zhang
 * 
 */
public class Consult extends Domain {

	private Long id;
	private String title;
	private Long itemid;
	private Long corpid;
	private Long svgid;
	private Date addtime;
	private Long parid;
	private String content;
	private String status;
	private Long userid;
	private Long scode;

	private String sitemtitle;
	private String corptitle;
	private String corplogo;
	private String svgtitle;
	private String svglogo;
	private String addtimestr;
	private String scodestr;
	// 是否公开
	private String isshow;
	// 联系人
	private String linker;
	// 联系电话
	private String linktel;

	private Integer titlelen;
	private Integer remarklen;
	private String showtitle;
	private String showremark;

	private String url;
	private List<Attach> attachs;

	private List<Consult> replyList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParid() {
		return parid;
	}

	public void setParid(Long parid) {
		this.parid = parid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
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

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getSitemtitle() {
		return sitemtitle;
	}

	public void setSitemtitle(String sitemtitle) {
		this.sitemtitle = sitemtitle;
	}

	public String getCorptitle() {
		return corptitle;
	}

	public void setCorptitle(String corptitle) {
		this.corptitle = corptitle;
	}

	public String getCorplogo() {
		return corplogo;
	}

	public void setCorplogo(String corplogo) {
		this.corplogo = corplogo;
	}

	public String getSvgtitle() {
		return svgtitle;
	}

	public void setSvgtitle(String svgtitle) {
		this.svgtitle = svgtitle;
	}

	public String getSvglogo() {
		return svglogo;
	}

	public void setSvglogo(String svglogo) {
		this.svglogo = svglogo;
	}

	public String getAddtimestr() {
		if (addtime != null) {
			addtimestr = new SimpleDateFormat("yyyy-MM-dd").format(addtime);
		}
		return addtimestr;
	}

	public void setAddtimestr(String addtimestr) {
		this.addtimestr = addtimestr;
	}

	public Long getScode() {
		return scode;
	}

	public void setScode(Long scode) {
		this.scode = scode;
	}

	public String getScodestr() {
		return scodestr;
	}

	public void setScodestr(String scodestr) {
		this.scodestr = scodestr;
	}

	public String getIsshow() {
		return isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
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

	public List<Attach> getAttachs() {
		return attachs;
	}

	public void setAttachs(List<Attach> attachs) {
		this.attachs = attachs;
	}

	public Integer getTitlelen() {
		return titlelen;
	}

	public void setTitlelen(Integer titlelen) {
		this.titlelen = titlelen;
	}

	public Integer getRemarklen() {
		return remarklen;
	}

	public void setRemarklen(Integer remarklen) {
		this.remarklen = remarklen;
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

	public String getShowremark() {
		showremark = content;
		if (null != remarklen && remarklen > 0) {
			if (null != content && content.length() > remarklen) {
				showremark = content.substring(0, remarklen);
			}
		}
		return showremark;
	}

	public void setShowremark(String showremark) {
		this.showremark = showremark;
	}

	public String getUrl() {
		if (null == url || url.trim().length() <= 0) {
			url = "/consult-" + id + ".html";
		}
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Consult> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Consult> replyList) {
		this.replyList = replyList;
	}

}
package com.gsccs.sme.api.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.Domain;

/**
 * 服务需求域对象
 * 
 * @author x.d zhang
 * 
 */
public class Sneed extends Domain {

	private Long id;
	private Long corpid;
	private Long scode;
	private Long subscode;
	private String title;
	private String img;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date addtime;
	private Integer clicknum;
	private String linker;
	private String linktel;
	private String barcode;
	private String remark;
	private Double price;
	private Integer salenum;
	private Integer evalnum;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lasttime;
	private String typeid;
	private String status;
	private String isrelease;
	private String content;
	// 需求附件
	private List<Attach> attachs;

	private String corptitle;
	private String corplogo;
	private String addtimestr;
	private Integer titlelen;
	private String showtitle;
	private String sclassstr;

	private String url;

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

	public String getLinktel() {
		return linktel;
	}

	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getSalenum() {
		return salenum;
	}

	public void setSalenum(Integer salenum) {
		this.salenum = salenum;
	}

	public Integer getEvalnum() {
		return evalnum;
	}

	public void setEvalnum(Integer evalnum) {
		this.evalnum = evalnum;
	}

	public Date getLasttime() {
		return lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLinker() {
		return linker;
	}

	public void setLinker(String linker) {
		this.linker = linker;
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

	public Integer getTitlelen() {
		return titlelen;
	}

	public void setTitlelen(Integer titlelen) {
		this.titlelen = titlelen;
	}

	public String getShowtitle() {
		if (null != titlelen && titlelen > 0) {
			if (null == title || title.isEmpty()) {
				showtitle = "";
			} else if (title.length() > titlelen) {
				showtitle = title.substring(0, titlelen);
			} else {
				showtitle = title;
			}
		}
		return showtitle;
	}

	public void setShowtitle(String showtitle) {
		this.showtitle = showtitle;
	}

	public String getUrl() {

		return "/sneed-" + id + ".html";
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAddtimestr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (null != addtime) {
			addtimestr = format.format(addtime);
		}
		return addtimestr;
	}

	public void setAddtimestr(String addtimestr) {
		this.addtimestr = addtimestr;
	}

	public List<Attach> getAttachs() {
		return attachs;
	}

	public void setAttachs(List<Attach> attachs) {
		this.attachs = attachs;
	}

	public String getSclassstr() {
		return sclassstr;
	}

	public void setSclassstr(String sclassstr) {
		this.sclassstr = sclassstr;
	}

	public String getIsrelease() {
		return isrelease;
	}

	public void setIsrelease(String isrelease) {
		this.isrelease = isrelease;
	}
	
	

}

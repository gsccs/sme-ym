package com.gsccs.sme.api.domain.shop;

import java.util.Date;
import java.util.List;

import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.Domain;

/**
 * 服务项目
 * 
 * @author x.d zhang
 * 
 */
public class Product extends Domain {

	private static final long serialVersionUID = 7214112869815458438L;

	private Long id;
	private Long corpid;
	private Long brand;
	private String cateid;
	private String cateids;
	private String title;
	private String img;
	private Integer pcode;
	private Integer ccode;
	private Integer acode;
	private String ishot;
	private String istop;
	private Date addtime;
	private Integer clicknum;
	private String kind;
	private String tags;
	private String barcode;
	private String remark;
	private Double price;
	private Double weight;
	private Integer storenum;
	private Integer locknum;
	private Integer salenum;
	private Integer evalnum;
	private String postage;
	private Date lasttime;
	private Long typeid;
	private String status;
	private String content;

	private String catetitle;
	private String corptitle;
	private String corplogo;
	private Integer titlelen;
	private String showtitle;
	private Integer remarklen;
	private String showremark;
	// 图片
	private List<Attach> images;
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

	public Long getBrand() {
		return brand;
	}

	public void setBrand(Long brand) {
		this.brand = brand;
	}

	public String getCateid() {
		return cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
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

	public String getCateids() {
		return cateids;
	}

	public void setCateids(String cateids) {
		this.cateids = cateids;
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

	public String getIshot() {
		return ishot;
	}

	public void setIshot(String ishot) {
		this.ishot = ishot;
	}

	public String getIstop() {
		return istop;
	}

	public void setIstop(String istop) {
		this.istop = istop;
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

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
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

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getStorenum() {
		return storenum;
	}

	public void setStorenum(Integer storenum) {
		this.storenum = storenum;
	}

	public Integer getLocknum() {
		return locknum;
	}

	public void setLocknum(Integer locknum) {
		this.locknum = locknum;
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

	public String getPostage() {
		return postage;
	}

	public void setPostage(String postage) {
		this.postage = postage;
	}

	public Date getLasttime() {
		return lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}

	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
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

	public List<Attach> getImages() {
		return images;
	}

	public void setImages(List<Attach> images) {
		this.images = images;
	}

	public String getUrl() {
		url = "/product-" + id + ".html";
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCatetitle() {
		return catetitle;
	}

	public void setCatetitle(String catetitle) {
		this.catetitle = catetitle;
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

}

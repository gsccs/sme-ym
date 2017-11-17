package com.gsccs.sme.api.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.gsccs.sme.api.domain.base.Domain;



/**
 * 订单购物项
 * @author x.d zhang
 *
 */
public class PorderItem extends Domain{

	private String id;
	private String orderid;
	private Long productid;
	private Long skuid;
	private Integer num;
	private Double price;
	private Double accout;
	private String buyer;
	private String seller;
	private Date addtime;
	private String state;
	private String title;
	private String specstr;
	private String ptitle;
	private String purl;
	private String adddatestr;
	//是否已评价
	private String iseval;
	
	public String getAdddatestr() {
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		if(null != getAddtime()){
			adddatestr = df.format(getAddtime());
		}
		return adddatestr;
	}

	public void setAdddatestr(String adddatestr) {
		this.adddatestr = adddatestr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public Long getSkuid() {
		return skuid;
	}

	public void setSkuid(Long skuid) {
		this.skuid = skuid;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getAccout() {
		return accout;
	}

	public void setAccout(Double accout) {
		this.accout = accout;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer == null ? null : buyer.trim();
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller == null ? null : seller.trim();
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSpecstr() {
		return specstr;
	}

	public void setSpecstr(String specstr) {
		this.specstr = specstr;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public String getPurl() {
		return purl;
	}

	public void setPurl(String purl) {
		this.purl = purl;
	}

	public String getIseval() {
		return iseval;
	}

	public void setIseval(String iseval) {
		this.iseval = iseval;
	}
	
	
	
}
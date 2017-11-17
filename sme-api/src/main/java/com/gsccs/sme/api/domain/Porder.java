package com.gsccs.sme.api.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 订单结构
 * 
 * @author x.d zhang
 * 
 */
public class Porder extends Domain {

	private static final long serialVersionUID = 3167666115781348253L;

	private Long id;
	// 订单序列号
	private String ordersn;
	// 产品ID
	private Long productid;
	// 买家ID
	private Long buyerid;
	// 商城ID
	private Long sellerid;

	private String paytype;

	// 联系电话
	private String linktel;
	private String linker;
	// 商品价格
	private Double goodsfee;
	// 订单总额
	private Double totalfee;
	// 商品总数
	private Integer totalnum;

	// 下单时间
	private Date addtime;
	private Date lasttime;
	// 订单状态
	private String status;

	// 下单时间
	private String adddatestr;

	private String lastdatestr;
	// 商品名称
	private String producttitle;
	// 买家昵称
	private String buyertitle;
	// 买家昵称
	private String sellertitle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrdersn() {
		return ordersn;
	}

	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}

	public Long getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(Long buyerid) {
		this.buyerid = buyerid;
	}

	public Long getSellerid() {
		return sellerid;
	}

	public void setSellerid(Long sellerid) {
		this.sellerid = sellerid;
	}

	public String getBuyertitle() {
		return buyertitle;
	}

	public void setBuyertitle(String buyertitle) {
		this.buyertitle = buyertitle;
	}

	public String getSellertitle() {
		return sellertitle;
	}

	public void setSellertitle(String sellertitle) {
		this.sellertitle = sellertitle;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype == null ? null : paytype.trim();
	}

	public Double getTotalfee() {
		return totalfee;
	}

	public void setTotalfee(Double totalfee) {
		this.totalfee = totalfee;
	}

	public Long getActivityid() {
		return productid;
	}

	public void setActivityid(Long productid) {
		this.productid = productid;
	}

	public Double getGoodsfee() {
		return goodsfee;
	}

	public void setGoodsfee(Double goodsfee) {
		this.goodsfee = goodsfee;
	}

	public Integer getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}

	public String getProducttitle() {
		return producttitle;
	}

	public void setProducttitle(String producttitle) {
		this.producttitle = producttitle;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public String getLinktel() {
		return linktel;
	}

	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}

	public String getLinker() {
		return linker;
	}

	public void setLinker(String linker) {
		this.linker = linker;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Date getLasttime() {
		return lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdddatestr() {
		if (null != getAddtime()) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			adddatestr = df.format(getAddtime());
		}
		return adddatestr;
	}

	public void setAdddatestr(String adddatestr) {
		this.adddatestr = adddatestr;
	}

	public String getLastdatestr() {
		if (null != getLasttime()) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			lastdatestr = df.format(getLasttime());
		}
		return lastdatestr;
	}

	public void setLastdatestr(String lastdatestr) {
		this.lastdatestr = lastdatestr;
	}

}

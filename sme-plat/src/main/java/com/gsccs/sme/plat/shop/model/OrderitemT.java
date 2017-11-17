package com.gsccs.sme.plat.shop.model;

import java.util.Date;

public class OrderitemT {
	private String id;
	private Long orderid;
	private Long productid;
	private Long goodsid;
	private Integer num;
	private Float price;
	private Float totalfee;
	private String buyerid;
	private String sellerid;
	private Date addtime;
	private String goodstitle;
	private String goodsurl;
	private String specstr;
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public Long getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getTotalfee() {
		return totalfee;
	}

	public void setTotalfee(Float totalfee) {
		this.totalfee = totalfee;
	}

	public String getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
	}

	public String getSellerid() {
		return sellerid;
	}

	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getGoodstitle() {
		return goodstitle;
	}

	public void setGoodstitle(String goodstitle) {
		this.goodstitle = goodstitle;
	}

	public String getGoodsurl() {
		return goodsurl;
	}

	public void setGoodsurl(String goodsurl) {
		this.goodsurl = goodsurl;
	}

	public String getSpecstr() {
		return specstr;
	}

	public void setSpecstr(String specstr) {
		this.specstr = specstr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
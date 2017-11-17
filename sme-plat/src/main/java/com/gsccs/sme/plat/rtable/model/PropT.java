package com.gsccs.sme.plat.rtable.model;

/**
 * 企业数据指标
 * @author x.d zhang
 *
 */
public class PropT {

	private String id;
	//属性编码
	private String code;
	//属性名称
	private String title;
	//显示类型
	private String showtype;
	//数据类型
	private String datatype;
	//数据字典
	private String dictcode;
	//数据单位
	private String unit;
	//报表ID
	private String reportid;
	//状态
	private String status;
	private Integer indexnum;
	//服务机构ID
	private String svgids;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getShowtype() {
		return showtype;
	}

	public void setShowtype(String showtype) {
		this.showtype = showtype;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getDictcode() {
		return dictcode;
	}

	public void setDictcode(String dictcode) {
		this.dictcode = dictcode;
	}

	
	public String getReportid() {
		return reportid;
	}

	public void setReportid(String reportid) {
		this.reportid = reportid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getIndexnum() {
		return indexnum;
	}

	public void setIndexnum(Integer indexnum) {
		this.indexnum = indexnum;
	}

	public String getSvgids() {
		return svgids;
	}

	public void setSvgids(String svgids) {
		this.svgids = svgids;
	}
	
	

}
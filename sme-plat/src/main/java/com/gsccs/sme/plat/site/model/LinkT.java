package com.gsccs.sme.plat.site.model;

public class LinkT {
	
    private String id;
    private String parid;
    private String name;
    private String url;
    private String isok;
    private Integer ordernum;
    private String site;
    private String type;
    private String img;
    private String pagemark;
    private String isclass;
    
    private String typestr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParid() {
        return parid;
    }

    public void setParid(String parid) {
        this.parid = parid == null ? null : parid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIsok() {
        return isok;
    }

    public void setIsok(String isok) {
        this.isok = isok == null ? null : isok.trim();
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getPagemark() {
        return pagemark;
    }

    public void setPagemark(String pagemark) {
        this.pagemark = pagemark == null ? null : pagemark.trim();
    }

	public String getIsclass() {
		return isclass;
	}

	public void setIsclass(String isclass) {
		this.isclass = isclass;
	}

	public String getTypestr() {
		return typestr;
	}

	public void setTypestr(String typestr) {
		this.typestr = typestr;
	}
    
    
}
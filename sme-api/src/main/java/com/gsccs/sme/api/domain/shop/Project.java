package com.gsccs.sme.api.domain.shop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.gsccs.sme.api.domain.base.Domain;

/**
 * 项目清单
 * @author x.d zhang
 *
 */
public class Project extends Domain{
	
    private Integer id;
    private String title;
    private String intype;
    private Long  corpid;
    private String address;
    private String backdrop;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date starttime;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endtime;

    private Double invest;

    private String moneytype;

    private String linker;

    private String linktel;

    private String status;

    private String content;
    
    private Date addtime;
    
    private String starttimestr;
    private String endtimestr;
    private String corptitle;
    private String hycodestr;
    private String moneytypestr;
    private Integer titlelen;
    private String showtitle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIntype() {
        return intype;
    }

    public void setIntype(String intype) {
        this.intype = intype == null ? null : intype.trim();
    }

	public Long getCorpid() {
		return corpid;
	}

	public void setCorpid(Long corpid) {
		this.corpid = corpid;
	}

	public String getCorptitle() {
		return corptitle;
	}

	public void setCorptitle(String corptitle) {
		this.corptitle = corptitle;
	}

	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop == null ? null : backdrop.trim();
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

    

    public Double getInvest() {
		return invest;
	}

	public void setInvest(Double invest) {
		this.invest = invest;
	}

	public String getLinktel() {
		return linktel;
	}

	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}

	public String getStatus() {
		return status;
	}

	

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMoneytype() {
        return moneytype;
    }

    public void setMoneytype(String moneytype) {
        this.moneytype = moneytype == null ? null : moneytype.trim();
    }

    public String getLinker() {
        return linker;
    }

    public void setLinker(String linker) {
        this.linker = linker == null ? null : linker.trim();
    }

    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    
    
	public String getEndtimestr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (null != endtime) {
			return format.format(endtime);
		}
		return endtimestr;
	}

	public void setEndtimestr(String endtimestr) {
		this.endtimestr = endtimestr;
	}
	
	public String getStarttimestr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (null != starttime) {
			return format.format(starttime);
		}
		return starttimestr;
	}

	public void setStarttimestr(String starttimestr) {
		this.starttimestr = starttimestr;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
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

	public Integer getTitlelen() {
		return titlelen;
	}

	public void setTitlelen(Integer titlelen) {
		this.titlelen = titlelen;
	}

	public String getHycodestr() {
		return hycodestr;
	}

	public void setHycodestr(String hycodestr) {
		this.hycodestr = hycodestr;
	}

	public String getMoneytypestr() {
		return moneytypestr;
	}

	public void setMoneytypestr(String moneytypestr) {
		this.moneytypestr = moneytypestr;
	}
	
	
	
	
}
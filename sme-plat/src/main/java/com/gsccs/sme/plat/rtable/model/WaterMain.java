package com.gsccs.sme.plat.rtable.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class WaterMain {
    private String mainid;

    private Long corpid;

    private String txaddress;

    private String yznum;

    private String linker;

    private String linktel;

    private String cznum;

    private String jynum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tjdate;
    
    private String tjdatestr;
    
    private String reportid;
    
    private String corptitle;
    
    private String isattach;

    public String getMainid() {
        return mainid;
    }

    public void setMainid(String mainid) {
        this.mainid = mainid == null ? null : mainid.trim();
    }

    public Long getCorpid() {
        return corpid;
    }

    public void setCorpid(Long corpid) {
        this.corpid = corpid;
    }

    public String getTxaddress() {
        return txaddress;
    }

    public void setTxaddress(String txaddress) {
        this.txaddress = txaddress == null ? null : txaddress.trim();
    }

    public String getYznum() {
        return yznum;
    }

    public void setYznum(String yznum) {
        this.yznum = yznum == null ? null : yznum.trim();
    }

    public String getLinker() {
        return linker;
    }

    public void setLinker(String linker) {
        this.linker = linker == null ? null : linker.trim();
    }

    public String getLinktel() {
        return linktel;
    }

    public void setLinktel(String linktel) {
        this.linktel = linktel == null ? null : linktel.trim();
    }

    public String getCznum() {
        return cznum;
    }

    public void setCznum(String cznum) {
        this.cznum = cznum == null ? null : cznum.trim();
    }

    public String getJynum() {
        return jynum;
    }

    public void setJynum(String jynum) {
        this.jynum = jynum == null ? null : jynum.trim();
    }

    public Date getTjdate() {
        return tjdate;
    }

    public void setTjdate(Date tjdate) {
        this.tjdate = tjdate;
    }

	public String getReportid() {
		return reportid;
	}

	public void setReportid(String reportid) {
		this.reportid = reportid;
	}

	public String getCorptitle() {
		return corptitle;
	}

	public void setCorptitle(String corptitle) {
		this.corptitle = corptitle;
	}

	public String getTjdatestr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(null!=tjdate)
			return format.format(tjdate);
		return tjdatestr;
	}

	public void setTjdatestr(String tjdatestr) {
		this.tjdatestr = tjdatestr;
	}

	public String getIsattach() {
		return isattach;
	}

	public void setIsattach(String isattach) {
		this.isattach = isattach;
	}
}
package com.gsccs.sme.plat.rtable.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class WallMain {
    private String mainid;

    private String name;

    private Long corpid;
    
    private String isattach;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tbdate;
    
    private String tbdatestr;
    
    private String reportid;
    
    private String corptitle;

    public String getMainid() {
        return mainid;
    }

    public void setMainid(String mainid) {
        this.mainid = mainid == null ? null : mainid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getCorpid() {
        return corpid;
    }

    public void setCorpid(Long corpid) {
        this.corpid = corpid;
    }

    public Date getTbdate() {
        return tbdate;
    }

    public void setTbdate(Date tbdate) {
        this.tbdate = tbdate;
    }

	public String getIsattach() {
		return isattach;
	}

	public void setIsattach(String isattach) {
		this.isattach = isattach;
	}

	public String getCorptitle() {
		return corptitle;
	}

	public void setCorptitle(String corptitle) {
		this.corptitle = corptitle;
	}

	public String getReportid() {
		return reportid;
	}

	public void setReportid(String reportid) {
		this.reportid = reportid;
	}

	public String getTbdatestr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(null!=tbdate)
			return format.format(tbdate);
		return tbdatestr;
	}

	public void setTbdatestr(String tbdatestr) {
		this.tbdatestr = tbdatestr;
	}
}
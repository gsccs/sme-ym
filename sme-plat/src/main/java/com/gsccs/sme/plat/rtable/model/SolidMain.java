package com.gsccs.sme.plat.rtable.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SolidMain {
    private String mainid;

    private Long corpid;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tbtime;
    
    private String tbtimestr;

    private String shleader;

    private String tbname;
    
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

    public Date getTbtime() {
        return tbtime;
    }

    public void setTbtime(Date tbtime) {
        this.tbtime = tbtime;
    }

    public String getShleader() {
        return shleader;
    }

    public void setShleader(String shleader) {
        this.shleader = shleader == null ? null : shleader.trim();
    }

    public String getTbname() {
        return tbname;
    }

    public void setTbname(String tbname) {
        this.tbname = tbname == null ? null : tbname.trim();
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

	public String getIsattach() {
		return isattach;
	}

	public void setIsattach(String isattach) {
		this.isattach = isattach;
	}

	public String getTbtimestr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(null!=tbtime)
			return format.format(tbtime);
		return tbtimestr;
	}

	public void setTbtimestr(String tbtimestr) {
		this.tbtimestr = tbtimestr;
	}
}
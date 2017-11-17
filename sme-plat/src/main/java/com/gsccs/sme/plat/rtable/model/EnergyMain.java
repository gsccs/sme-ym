package com.gsccs.sme.plat.rtable.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EnergyMain {
    private String mainId;

    private Long corpid;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startdate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enddate;

    private String qyIndustry;

    private String industryAll;

    private String industryAdd;

    private String a;

    private String b;

    private String c;

    private String d;

    private String e;

    private String f;

    private String g;

    private String h;

    private String i;

    private String header;

    private String writer;

    private String phone;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bcTime;
    
    private String bcTimestr;
    
    private String reportid;
    
    private String corptitle;
    
    private String isattach;
    
    private String startend;

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId == null ? null : mainId.trim();
    }

    public Long getCorpid() {
        return corpid;
    }

    public void setCorpid(Long corpid) {
        this.corpid = corpid;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getQyIndustry() {
        return qyIndustry;
    }

    public void setQyIndustry(String qyIndustry) {
        this.qyIndustry = qyIndustry == null ? null : qyIndustry.trim();
    }

    public String getIndustryAll() {
        return industryAll;
    }

    public void setIndustryAll(String industryAll) {
        this.industryAll = industryAll == null ? null : industryAll.trim();
    }

    public String getIndustryAdd() {
        return industryAdd;
    }

    public void setIndustryAdd(String industryAdd) {
        this.industryAdd = industryAdd == null ? null : industryAdd.trim();
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a == null ? null : a.trim();
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b == null ? null : b.trim();
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c == null ? null : c.trim();
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d == null ? null : d.trim();
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e == null ? null : e.trim();
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f == null ? null : f.trim();
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g == null ? null : g.trim();
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h == null ? null : h.trim();
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i == null ? null : i.trim();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header == null ? null : header.trim();
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer == null ? null : writer.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getBcTime() {
        return bcTime;
    }

    public void setBcTime(Date bcTime) {
        this.bcTime = bcTime;
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

	public String getStartend() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(null!=startdate&&null!=enddate)
			return format.format(startdate)+"到"+format.format(enddate);
		return startend;
	}

	public void setStartend(String startend) {
		this.startend = startend;
	}

	public String getBcTimestr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(null!=bcTime)
			return format.format(bcTime);
		return bcTimestr;
	}

	public void setBcTimestr(String bcTimestr) {
		this.bcTimestr = bcTimestr;
	}
}
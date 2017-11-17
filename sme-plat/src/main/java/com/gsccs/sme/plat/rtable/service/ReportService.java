package com.gsccs.sme.plat.rtable.service;

import java.util.List;

import com.gsccs.sme.api.domain.report.Report;
import com.gsccs.sme.api.domain.report.ReportItem;

/**
 * 报表业务接口
 * 
 * @author x.d zhang
 * 
 */
public interface ReportService {

	public void addReport(Report report);

	public Report getReport(Long id);

	public void delReport(Long id);

	public List<Report> find(Report report, String order, int currPage,
			int pageSize);

	public int count(Report report);

	public void update(Report report);

	public ReportItem getReportItem(String id);

	public void addReportItem(ReportItem reportItem);

	public void editReportItem(ReportItem reportItem);

	public void delReportItem(String id);

	public List<ReportItem> find(ReportItem reportItem, String order,
			int currPage, int pageSize);

	public int count(ReportItem reportItem);

	public void delAttachs(List<Long> attachids);

}

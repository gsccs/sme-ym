package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.report.Report;
import com.gsccs.sme.api.domain.report.ReportItem;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 报表业务接口
 * 
 * @author x.d zhang
 * 
 */
public interface ReportServiceI {

	public Report getReport(Long id) throws ApiException;

	public List<Report> find(Report report, String order, int currPage,
			int pageSize);

	public int count(Report report);
	
	public ReportItem getReportItem(String id) throws ApiException ;
	public void addReportItem(ReportItem reportItem);
	public void editReportItem(ReportItem reportItem);
	public void delReportItem(String id);
	public List<ReportItem> find(ReportItem reportItem, String order, int currPage,
			int pageSize);

}

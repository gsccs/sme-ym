package com.gsccs.sme.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.report.Report;
import com.gsccs.sme.api.domain.report.ReportItem;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.plat.rtable.service.ReportService;

@Service
public class ReportServiceAPI implements ReportServiceI {

	@Autowired
	private ReportService reportService;

	@Override
	public Report getReport(Long id) throws ApiException {
		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		return reportService.getReport(id);
	}

	@Override
	public List<Report> find(Report report, String order, int page, int pagesize) {
		List<Report> list = reportService.find(report, order, page, pagesize);
		return list;
	}

	@Override
	public int count(Report param) {
		return reportService.count(param);
	}

	@Override
	public void addReportItem(ReportItem reportItem) {
		if (null != reportItem) {
			reportService.addReportItem(reportItem);
		}
	}

	@Override
	public void editReportItem(ReportItem reportItem) {
		if (null != reportItem) {
			reportService.editReportItem(reportItem);
		}
		
	}

	@Override
	public void delReportItem(String id) {
		reportService.delReportItem(id);
	}

	@Override
	public List<ReportItem> find(ReportItem param, String order,
			int page, int pagesize) {
		return reportService.find(param, order, page, pagesize);
	}

	@Override
	public ReportItem getReportItem(String id) throws ApiException {
		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		return reportService.getReportItem(id);
	}

}
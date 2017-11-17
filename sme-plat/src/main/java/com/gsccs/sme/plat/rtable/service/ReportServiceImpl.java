package com.gsccs.sme.plat.rtable.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.report.Report;
import com.gsccs.sme.api.domain.report.ReportItem;
import com.gsccs.sme.plat.rtable.dao.ReportAttachTMapper;
import com.gsccs.sme.plat.rtable.dao.ReportItemMapper;
import com.gsccs.sme.plat.rtable.dao.ReportMapper;
import com.gsccs.sme.plat.rtable.model.ReportAttachT;
import com.gsccs.sme.plat.rtable.model.ReportAttachTExample;
import com.gsccs.sme.plat.rtable.model.ReportExample;
import com.gsccs.sme.plat.rtable.model.ReportItemExample;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportMapper reportMapper;
	@Autowired
	private ReportItemMapper reportItemTMapper;
	@Autowired
	private ReportAttachTMapper reportAttachTMapper;

	@Override
	public Report getReport(Long id) {
		Report report = reportMapper.selectByPrimaryKey(id);
		if (null != report) {
			List<ReportAttachT> attachTs = findReportAttachs(id);
			if (null != attachTs && attachTs.size() > 0) {
				List<Attach> attachs = new ArrayList<>();
				for (ReportAttachT attachT : attachTs) {
					Attach attach = new Attach();
					attach.setId(attachT.getId().toString());
					attach.setFilename(attachT.getFilename());
					attach.setFilepath(attachT.getFilepath());
					attach.setFiletype(attachT.getFiletype());
					attachs.add(attach);
				}
				report.setAttachs(attachs);
			}
		}
		return report;
	}

	@Override
	public void delReport(Long id) {
		reportMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Report> find(Report report, String order, int currPage,
			int pageSize) {
		ReportExample example = new ReportExample();
		ReportExample.Criteria criteria = example.createCriteria();
		proSearchParam(report, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		List<Report> listReport = reportMapper.selectPageByExample(example);
		for (Report reportT : listReport) {
			if (StringUtils.isNotEmpty(reportT.getCyc())) {
				switch (reportT.getCyc()) {
				case "D":
					reportT.setCycstr("日");
					break;
				case "W":
					reportT.setCycstr("周");
					break;
				case "M":
					reportT.setCycstr("月");
					break;
				case "Q":
					reportT.setCycstr("季度");
					break;
				case "Y":
					reportT.setCycstr("年");
					break;
				default:
					break;
				}
			}
		}
		return listReport;
	}

	@Override
	public int count(Report report) {
		ReportExample example = new ReportExample();
		ReportExample.Criteria criteria = example.createCriteria();
		proSearchParam(report, criteria);
		return reportMapper.countByExample(example);
	}

	@Override
	public void update(Report report) {
		if (null != report) {
			reportMapper.updateByPrimaryKey(report);
			if (null != report.getAttachs() && report.getAttachs().size() > 0) {
				for (Attach attach : report.getAttachs()) {
					ReportAttachT attachT = new ReportAttachT();
					attachT.setReportid(report.getId());
					attachT.setSvgid(report.getSvgid());
					attachT.setFilename(attach.getFilename());
					attachT.setFilepath(attach.getFilepath());
					attachT.setFiletype(attach.getFiletype());
					attachT.setAddtime(new Date());
					reportAttachTMapper.insert(attachT);
				}
			}
		}
	}

	@Override
	public void addReport(Report report) {
		if (null != report)
		reportMapper.insert(report);
		if (null != report.getAttachs() && report.getAttachs().size() > 0) {
			for (Attach attach : report.getAttachs()) {
				ReportAttachT attachT = new ReportAttachT();
				attachT.setReportid(report.getId());
				attachT.setSvgid(report.getSvgid());
				attachT.setFilename(attach.getFilename());
				attachT.setFilepath(attach.getFilepath());
				attachT.setFiletype(attach.getFiletype());
				attachT.setAddtime(new Date());
				reportAttachTMapper.insert(attachT);
			}
		}
	}

	@Override
	public void addReportItem(ReportItem reportItem) {
		if (null != reportItem) {
			String reportItemid = UUID.randomUUID().toString();
			reportItem.setId(reportItemid);
			reportItem.setAddtime(new Date());
			// reportItem.setIsattach("1");
			reportItemTMapper.insert(reportItem);

			if (null != reportItem.getAttachs()
					&& reportItem.getAttachs().size() > 0) {
				for (Attach attach : reportItem.getAttachs()) {
					ReportAttachT attachT = new ReportAttachT();
					attachT.setReportid(reportItem.getReportid());
					attachT.setItemid(reportItemid);
					attachT.setCorpid(reportItem.getCorpid());
					attachT.setFilename(attach.getFilename());
					attachT.setFilepath(attach.getFilepath());
					attachT.setFiletype(attach.getFiletype());
					attachT.setAddtime(new Date());
					reportAttachTMapper.insert(attachT);
				}
			}
		}
	}

	@Override
	public void editReportItem(ReportItem reportItem) {
		if (null != reportItem) {
			reportItemTMapper.updateByPrimaryKeySelective(reportItem);
			if (null != reportItem.getAttachs()
					&& reportItem.getAttachs().size() > 0) {
				for (Attach attach : reportItem.getAttachs()) {
					ReportAttachT attachT = new ReportAttachT();
					attachT.setReportid(reportItem.getReportid());
					attachT.setItemid(reportItem.getId());
					attachT.setCorpid(reportItem.getCorpid());
					attachT.setFilename(attach.getFilename());
					attachT.setFilepath(attach.getFilepath());
					attachT.setFiletype(attach.getFiletype());
					attachT.setAddtime(new Date());
					reportAttachTMapper.insert(attachT);
				}
			}
		}
	}

	@Override
	public void delReportItem(String id) {
		reportItemTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<ReportItem> find(ReportItem reportItem, String order,
			int currPage, int pageSize) {
		ReportItemExample example = new ReportItemExample();
		ReportItemExample.Criteria criteria = example.createCriteria();
		proSearchParam(reportItem, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return reportItemTMapper.selectPageByExample(example);
	}

	@Override
	public ReportItem getReportItem(String id) {
		ReportItem reportItemT = reportItemTMapper.selectByPrimaryKey(id);

		if (null != reportItemT) {
			List<ReportAttachT> attachTs = findReportItemAttachs(id);
			if (null != attachTs && attachTs.size() > 0) {
				List<Attach> attachs = new ArrayList<>();
				for (ReportAttachT attachT : attachTs) {
					Attach attach = new Attach();
					attach.setId(attachT.getId().toString());
					attach.setFilename(attachT.getFilename());
					attach.setFilepath(attachT.getFilepath());
					attach.setFiletype(attachT.getFiletype());
					attachs.add(attach);
				}
				reportItemT.setAttachs(attachs);
			}
		}

		return reportItemT;
	}

	@Override
	public int count(ReportItem reportItem) {
		ReportItemExample example = new ReportItemExample();
		ReportItemExample.Criteria criteria = example.createCriteria();
		proSearchParam(reportItem, criteria);
		return reportItemTMapper.countByExample(example);
	}

	public void proSearchParam(Report report, ReportExample.Criteria criteria) {
		if (null != report) {
			if (StringUtils.isNotEmpty(report.getTitle())) {
				criteria.andTitleLike("%" + report.getTitle() + "%");
			}
			if (StringUtils.isNotEmpty(report.getCyc())) {
				criteria.andCycEqualTo(report.getCyc());
			}

			if (StringUtils.isNotEmpty(report.getStatus())) {
				criteria.andStatusEqualTo(report.getStatus());
			}

			if (null != report.getSvgid()) {
				criteria.andSvgidEqualTo(report.getSvgid());
			}
		}
	}

	public void proSearchParam(ReportItem param,
			ReportItemExample.Criteria criteria) {
		if (null != param) {
			if (null != param.getReportid()) {
				criteria.andReportidEqualTo(param.getReportid());
			}

			if (null != param.getCorpid()) {
				criteria.andCorpidEqualTo(param.getCorpid());
			}
		}
	}

	@Override
	public void delAttachs(List<Long> ids) {
		ReportAttachTExample example = new ReportAttachTExample();
		ReportAttachTExample.Criteria c = example.createCriteria();
		c.andIdIn(ids);
		reportAttachTMapper.deleteByExample(example);
	}

	public List<ReportAttachT> findReportAttachs(Long reportid) {
		if (null != reportid) {
			ReportAttachTExample example = new ReportAttachTExample();
			ReportAttachTExample.Criteria c = example.createCriteria();
			c.andReportidEqualTo(reportid);
			c.andItemidIsNull();
			return reportAttachTMapper.selectByExample(example);
		}
		return null;
	}

	public List<ReportAttachT> findReportItemAttachs(String reportitemid) {
		if (null != reportitemid) {
			ReportAttachTExample example = new ReportAttachTExample();
			ReportAttachTExample.Criteria c = example.createCriteria();
			c.andItemidEqualTo(reportitemid);
			return reportAttachTMapper.selectByExample(example);
		}
		return null;
	}
}
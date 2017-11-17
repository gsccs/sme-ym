package com.gsccs.sme.plat.corp.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.api.domain.corp.CorpEnergy;
import com.gsccs.sme.api.domain.corp.CorpMsw;
import com.gsccs.sme.api.domain.corp.CorpRun;
import com.gsccs.sme.api.domain.corp.CorpTech;
import com.gsccs.sme.api.domain.corp.CorpWater;
import com.gsccs.sme.plat.auth.dao.DictItemTMapper;
import com.gsccs.sme.plat.corp.dao.CorpEnergyMapper;
import com.gsccs.sme.plat.corp.dao.CorpMswMapper;
import com.gsccs.sme.plat.corp.dao.CorpRunMapper;
import com.gsccs.sme.plat.corp.dao.CorpTechMapper;
import com.gsccs.sme.plat.corp.dao.CorpWaterMapper;
import com.gsccs.sme.plat.corp.model.CorpEnergyExample;
import com.gsccs.sme.plat.corp.model.CorpMswExample;
import com.gsccs.sme.plat.corp.model.CorpRunExample;
import com.gsccs.sme.plat.corp.model.CorpTechExample;
import com.gsccs.sme.plat.corp.model.CorpWaterExample;
import com.gsccs.sme.plat.svg.dao.CorpTMapper;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private CorpTMapper corpTMapper;
	@Autowired
	private DictItemTMapper dictItemTMapper;
	@Autowired
	private CorpEnergyMapper corpEnergyMapper;
	@Autowired
	private CorpWaterMapper corpWaterMapper;
	@Autowired
	private CorpMswMapper corpMswMapper;
	@Autowired
	private CorpTechMapper corpTechMapper;
	@Autowired
	private CorpRunMapper corpRunMapper;

	@Override
	public List<CorpEnergy> find(CorpEnergy param, String order, int currPage,
			int pageSize) {
		CorpEnergyExample example = new CorpEnergyExample();
		CorpEnergyExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		if (StringUtils.isNotEmpty(order)) {
			example.setOrderByClause(order);
		}
		return corpEnergyMapper.selectByExample(example);
	}

	@Override
	public Integer count(CorpEnergy corpT) {
		CorpEnergyExample example = new CorpEnergyExample();
		CorpEnergyExample.Criteria criteria = example.createCriteria();
		proSearchParam(corpT, criteria);
		return corpEnergyMapper.countByExample(example);
	}

	@Override
	public Long saveEnergy(CorpEnergy param) {
		if (null != param) {
			if (null != param.getId()) {
				corpEnergyMapper.updateByPrimaryKey(param);
			} else {
				corpEnergyMapper.insert(param);
			}
			return param.getId();
		}
		return null;
	}

	@Override
	public Long saveMsw(CorpMsw param) {
		if (null != param) {
			if (null != param.getId()) {
				corpMswMapper.updateByPrimaryKeySelective(param);
			} else {
				corpMswMapper.insert(param);
			}
			return param.getId();
		}
		return null;
	}

	@Override
	public List<CorpMsw> find(CorpMsw param, String order, int currPage,
			int pageSize) {
		CorpMswExample example = new CorpMswExample();
		CorpMswExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		if (StringUtils.isNotEmpty(order)) {
			example.setOrderByClause(order);
		}
		return corpMswMapper.selectByExample(example);
	}

	@Override
	public Integer count(CorpMsw param) {
		CorpMswExample example = new CorpMswExample();
		CorpMswExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		return corpMswMapper.countByExample(example);
	}

	@Override
	public Long saveTech(CorpTech param) {
		if (null != param) {
			if (null != param.getId()) {
				corpTechMapper.updateByPrimaryKey(param);
			} else {
				corpTechMapper.insert(param);
			}
			return param.getId();
		}
		return null;
	}

	@Override
	public CorpTech getCorpTech(Long id) {
		return corpTechMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<CorpTech> find(CorpTech param, String order, int currPage,
			int pageSize) {
		CorpTechExample example = new CorpTechExample();
		CorpTechExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		if (StringUtils.isNotEmpty(order)) {
			example.setOrderByClause(order);
		}
		return corpTechMapper.selectByExample(example);
	}

	@Override
	public Integer count(CorpTech param) {
		CorpTechExample example = new CorpTechExample();
		CorpTechExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		return corpTechMapper.countByExample(example);
	}

	@Override
	public Long saveWater(CorpWater param) {
		if (null != param) {
			if (null != param.getId()) {
				corpWaterMapper.updateByPrimaryKey(param);
			} else {
				corpWaterMapper.insert(param);
			}
			return param.getId();
		}
		return null;
	}

	@Override
	public List<CorpWater> find(CorpWater param, String order, int currPage,
			int pageSize) {
		CorpWaterExample example = new CorpWaterExample();
		CorpWaterExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		if (StringUtils.isNotEmpty(order)) {
			example.setOrderByClause(order);
		}
		return corpWaterMapper.selectByExample(example);
	}

	@Override
	public Integer count(CorpWater param) {
		CorpWaterExample example = new CorpWaterExample();
		CorpWaterExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		return corpWaterMapper.countByExample(example);
	}

	@Override
	public Long saveRun(CorpRun param) {
		if (null != param) {
			if (null != param.getId()) {
				corpRunMapper.updateByPrimaryKey(param);
			} else {
				corpRunMapper.insert(param);
			}
			return param.getId();
		}
		return null;
	}

	@Override
	public List<CorpRun> find(CorpRun param, String order, int currPage,
			int pageSize) {
		CorpRunExample example = new CorpRunExample();
		CorpRunExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		if (StringUtils.isNotEmpty(order)) {
			example.setOrderByClause(order);
		}
		return corpRunMapper.selectByExample(example);
	}

	@Override
	public Integer count(CorpRun param) {
		CorpRunExample example = new CorpRunExample();
		CorpRunExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		return corpRunMapper.countByExample(example);
	}

	@Override
	public CorpRun getCorpRun(Long id) {
		return corpRunMapper.selectByPrimaryKey(id);
	}

	@Override
	public CorpEnergy getCorpEnergy(Long id) {
		return corpEnergyMapper.selectByPrimaryKey(id);
	}

	@Override
	public CorpMsw getCorpMsw(Long id) {
		return corpMswMapper.selectByPrimaryKey(id);
	}

	@Override
	public CorpWater getCorpWater(Long id) {
		return corpWaterMapper.selectByPrimaryKey(id);
	}

	public void proSearchParam(CorpEnergy corpT,
			CorpEnergyExample.Criteria criteria) {
		if (null != corpT) {
			if (null != corpT.getCorpid()) {
				criteria.andCorpidEqualTo(corpT.getCorpid());
			}

			if (null != corpT.getYear()) {
				criteria.andYearEqualTo(corpT.getYear());
			}

			if (null != corpT.getMonth()) {
				criteria.andMonthEqualTo(corpT.getMonth());
			}
		}
	}

	public void proSearchParam(CorpMsw param, CorpMswExample.Criteria criteria) {
		if (null != param) {
			if (null != param.getCorpid()) {
				criteria.andCorpidEqualTo(param.getCorpid());
			}

			if (null != param.getYear()) {
				criteria.andYearEqualTo(param.getYear());
			}

			if (null != param.getMonth()) {
				criteria.andMonthEqualTo(param.getMonth());
			}
		}
	}

	public void proSearchParam(CorpWater param,
			CorpWaterExample.Criteria criteria) {
		if (null != param) {
			if (null != param.getCorpid()) {
				criteria.andCorpidEqualTo(param.getCorpid());
			}

			if (null != param.getYear()) {
				criteria.andYearEqualTo(param.getYear());
			}

			if (null != param.getMonth()) {
				criteria.andMonthEqualTo(param.getMonth());
			}
		}
	}

	public void proSearchParam(CorpRun param, CorpRunExample.Criteria criteria) {
		if (null != param) {
			if (null != param.getCorpid()) {
				criteria.andCorpidEqualTo(param.getCorpid());
			}

			if (null != param.getYear()) {
				criteria.andYearEqualTo(param.getYear());
			}

		}
	}

	public void proSearchParam(CorpTech param, CorpTechExample.Criteria criteria) {
		if (null != param) {
			if (null != param.getCorpid()) {
				criteria.andCorpidEqualTo(param.getCorpid());
			}
		}
	}

}

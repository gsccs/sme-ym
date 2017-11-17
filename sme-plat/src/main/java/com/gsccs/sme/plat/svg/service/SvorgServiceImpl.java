package com.gsccs.sme.plat.svg.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.auth.dao.DictItemTMapper;
import com.gsccs.sme.plat.auth.service.AreaService;
import com.gsccs.sme.plat.svg.dao.RegTypeTMapper;
import com.gsccs.sme.plat.svg.dao.SclassTMapper;
import com.gsccs.sme.plat.svg.dao.SvorgTMapper;
import com.gsccs.sme.plat.svg.model.SvorgT;
import com.gsccs.sme.plat.svg.model.SvorgTExample;
import com.gsccs.sme.plat.svg.model.SvorgTExample.Criteria;

/**
 * 服务机构业务
 */
@Service(value = "svorgService")
public class SvorgServiceImpl implements SvorgService {

	@Autowired
	private SvorgTMapper svorgTMapper;
	@Autowired
	private DictItemTMapper dictItemTMapper;
	@Autowired
	private RegTypeTMapper regTypeTMapper;
	@Autowired
	private SclassTMapper sclassTMapper;
	@Autowired
	private IndustryService industryService;
	@Autowired
	private AreaService areaService;
	
	
	@Override
	public Long addSvorg(SvorgT svorgT) {
		System.out.println("save svorg");
		if (null != svorgT) {
			svorgTMapper.insert(svorgT);
			return svorgT.getId();
		}
		return null;
	}

	/**
	 * 根据id查询店铺信息
	 */
	@Override
	public SvorgT findById(Long id) {
		SvorgT svorgT = svorgTMapper.selectByPrimaryKey(id);
		if (null != svorgT) {
			String areastr = "";
			if (null != svorgT.getAcode()) {
				areastr += areaService.getAreaStr(svorgT.getAcode());
			} else if (null != svorgT.getCcode()) {
				areastr += areaService.getAreaStr(svorgT.getCcode());
			} else if (null != svorgT.getPcode()) {
				areastr += areaService.getAreaStr(svorgT.getPcode());
			}
			String address = svorgT.getAddress() == null ? "" : svorgT
					.getAddress();
			areastr += areastr + address;
			svorgT.setAreastr(areastr);
		}
		return svorgT;
	}

	@Override
	public void update(SvorgT svorgT) {
		if (null != svorgT) {
			svorgTMapper.updateByPrimaryKeyWithBLOBs(svorgT);
		}
	}

	@Override
	public void del(Long id) {
		svorgTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<SvorgT> find(SvorgT store, String order, int currPage,
			int pageSize) {
		SvorgTExample example = new SvorgTExample();
		SvorgTExample.Criteria criteria = example.createCriteria();
		proSearchParam(store, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}else{
			example.setOrderByClause("istop");
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		List<SvorgT> svorgTs = svorgTMapper.selectPageByExample(example);
		if (null != svorgTs && svorgTs.size() > 0) {
			for (SvorgT svorg : svorgTs) {

				String areastr = "";
				if (null != svorg.getAcode()) {
					areastr += areaService.getAreaStr(svorg.getAcode());
				} else if (null != svorg.getCcode()) {
					areastr += areaService.getAreaStr(svorg.getCcode());
				} else if (null != svorg.getPcode()) {
					areastr += areaService.getAreaStr(svorg.getPcode());
				}
				String address = svorg.getAddress() == null ? "" : svorg
						.getAddress();
				areastr += address;
				svorg.setAreastr(areastr);
			}
		}
		return svorgTs;
	}

	@Override
	public int count(SvorgT svorgT) {
		SvorgTExample example = new SvorgTExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(svorgT, criteria);
		return svorgTMapper.countByExample(example);
	}

	public void proSearchParam(SvorgT svorgT, SvorgTExample.Criteria criteria) {
		if (null != svorgT) {
			if (null != svorgT.getId()) {
				criteria.andIdEqualTo(svorgT.getId());
			}

			if (StringUtils.isNotEmpty(svorgT.getTitle())) {
				criteria.andTitleLike("%" + svorgT.getTitle() + "%");
			}

			if (null != svorgT.getScode()) {
				criteria.andScodeEqualTo(svorgT.getScode().toString());
			}

			if (null != svorgT.getSubscode()) {
				criteria.andSubscodeEqualTo(svorgT.getSubscode().toString());
			}

			if (null != svorgT.getPcode()) {
				criteria.andPcodeEqualTo(svorgT.getPcode().toString());
			}

			if (null != svorgT.getCcode()) {
				criteria.andCcodeEqualTo(svorgT.getCcode().toString());
			}
			if (null != svorgT.getAcode()) {
				criteria.andAcodeEqualTo(svorgT.getAcode().toString());
			}

			if (null != svorgT.getHycode()) {
				criteria.andHycodeEqualTo(svorgT.getHycode().toString());
			}

			if (StringUtils.isNotEmpty(svorgT.getStatus())) {
				criteria.andStatusEqualTo(svorgT.getStatus());
			}

			if (StringUtils.isNotEmpty(svorgT.getSvgtype())) {
				criteria.andSvgtypeEqualTo(svorgT.getSvgtype());
			}

		}
	}

	@Override
	public List<SvorgT> querySvgByItemLike(String title,int currPage,
			int pageSize) {
		SvorgTExample example = new SvorgTExample();
		SvorgTExample.Criteria criteria = example.createCriteria();
		criteria.andSql("id in(select svgid from sme_sitem where title like '%"+title+"%')");
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return svorgTMapper.querySvgByItem(example);
	}

}

package com.gsccs.sme.plat.svg.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.auth.model.AreaT;
import com.gsccs.sme.plat.auth.model.DictItemT;
import com.gsccs.sme.plat.auth.service.AreaService;
import com.gsccs.sme.plat.auth.service.DictService;
import com.gsccs.sme.plat.svg.dao.SclassTMapper;
import com.gsccs.sme.plat.svg.dao.SevalTMapper;
import com.gsccs.sme.plat.svg.dao.SitemTMapper;
import com.gsccs.sme.plat.svg.model.SclassT;
import com.gsccs.sme.plat.svg.model.SevalT;
import com.gsccs.sme.plat.svg.model.SevalTExample;
import com.gsccs.sme.plat.svg.model.SitemT;
import com.gsccs.sme.plat.svg.model.SitemTExample;

/**
 * 服务项目业务
 * 
 * @author x.d zhang
 * 
 */
@Service(value = "sitemService")
public class SitemServiceImpl implements SitemService {

	@Autowired
	private SitemTMapper sitemTMapper;
	@Autowired
	private SevalTMapper sevalTMapper;
	@Autowired
	private SclassTMapper sclassTMapper;
	@Autowired
	private DictService dictService;
	@Autowired
	private AreaService areaService;

	/**
	 * 根据id查询
	 */
	@Override
	public SitemT findById(Long id) {
		SitemT sitem = sitemTMapper.selectByPrimaryKey(id);
		if (null != sitem) {
			// 服务分类
			Long scode = sitem.getScode();
			// 二级分类
			Long subscode = sitem.getSubscode();
			// 收费模式
			String spaytype = sitem.getSpay();
			// 服务模式
			String spattids = sitem.getSpattern();
			// 服务对象
			String sprojids = sitem.getSproject();

			if (null != scode&&scode!='0') {
				SclassT sclassT = sclassTMapper.selectByPrimaryKey(scode);
				sitem.setSclassstr(sclassT.getTitle());
			}

			if (null != subscode&&scode!='0') {
				SclassT sclassT = sclassTMapper.selectByPrimaryKey(subscode);
				sitem.setSubsclassstr(sclassT.getTitle());
			}

/*			if (StringUtils.isNotEmpty(spaytype)) {
				DictItemT dictItemT = dictService.getDictById(spaytype);
				sitem.setSpaystr(dictItemT.getTitle());
			}*/

			if (StringUtils.isNotEmpty(sprojids)) {
				List<DictItemT> dictItemTs = dictService.findDictlist(sprojids);

				if (null != dictItemTs && dictItemTs.size() > 0) {
					List<String> sprolist = new ArrayList<>();
					for (DictItemT t : dictItemTs) {
						sprolist.add(t.getTitle());
					}
					sitem.setSprolist(sprolist);
				}

			}

			if (StringUtils.isNotEmpty(spattids)) {
				List<DictItemT> dictItemTs = dictService.findDictlist(spattids);
				if (null != dictItemTs && dictItemTs.size() > 0) {
					List<String> spanlist = new ArrayList<>();
					for (DictItemT t : dictItemTs) {
						spanlist.add(t.getTitle());
					}
					sitem.setSpanlist(spanlist);
				}
			}

			if (StringUtils.isNotEmpty(sitem.getAreacodes())) {
				List<AreaT> areas = areaService.findAreaList(sitem
						.getAreacodes());
				if (null != areas && areas.size() > 0) {
					List<String> arealist = new ArrayList<>();
					for (AreaT t : areas) {
						arealist.add(t.getName());
					}
					sitem.setArealist(arealist);
				}
			}
		}

		return sitem;
	}

	/**
	 * 添加服务项
	 */
	@Override
	public void insert(SitemT sitemT) {
		if (null != sitemT) {
			sitemTMapper.insert(sitemT);
		}
	}

	/**
	 * 修改服务项目
	 */
	@Override
	public void update(SitemT sitemT) {
		sitemTMapper.updateByPrimaryKey(sitemT);
	}

	@Override
	public List<SitemT> find(SitemT sitemT, String order, int currPage,
			int pageSize) {
		SitemTExample example = new SitemTExample();
		SitemTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sitemT, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		List<SitemT> sitemTs = sitemTMapper.selectPageByExample(example);

		if (null != sitemTs && sitemTs.size() > 0) {
			for (SitemT sitem : sitemTs) {
				Long scode = sitem.getScode();
				Long subscode = sitem.getSubscode();
				// 收费模式
				String spaytype = sitem.getSpay();

				if (null != scode) {
					SclassT sclassT = sclassTMapper.selectByPrimaryKey(scode);
					sitem.setSclassstr(sclassT.getTitle());
				}

				if (null != subscode) {
					SclassT sclassT = sclassTMapper
							.selectByPrimaryKey(subscode);
					sitem.setSubsclassstr(sclassT.getTitle());
				}

				if (StringUtils.isNotEmpty(spaytype)) {
					DictItemT dictItemT = dictService.getDictById(spaytype);
					sitem.setSpaystr(dictItemT.getTitle());
				}

				if (StringUtils.isNotEmpty(sitem.getAreacodes())) {
					List<AreaT> areas = areaService.findAreaList(sitem
							.getAreacodes());
					if (null != areas && areas.size() > 0) {
						List<String> arealist = new ArrayList<>();
						for (AreaT t : areas) {
							arealist.add(t.getName());
						}
						sitem.setArealist(arealist);
					}
				}
			}
		}
		return sitemTs;
	}

	@Override
	public int count(SitemT sitemT) {
		SitemTExample example = new SitemTExample();
		SitemTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sitemT, criteria);
		return sitemTMapper.countByExample(example);
	}

	@Override
	public void delSitem(Long id) {
		sitemTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<SitemT> findByExample(SitemT sitemT, String orderstr, int page,
			int rows) {
		SitemTExample example = new SitemTExample();
		SitemTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sitemT, criteria);
		if (orderstr != null && orderstr.trim().length() > 0) {
			example.setOrderByClause(orderstr);
		}
		example.setCurrPage(page);
		example.setPageSize(rows);
		return sitemTMapper.selectPageByExample(example);
	}

	@Override
	public void insert(SevalT sevalT) {
		if (null != sevalT) {
			sevalT.setId(UUID.randomUUID().toString());
			sevalT.setAddtime(new Date());
			sevalTMapper.insert(sevalT);
		}
	}

	@Override
	public void update(SevalT sitemT) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delSitem(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public SevalT findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SevalT> find(SevalT sevalT, String orderstr, int page,
			int pagesize) {
		SevalTExample example = new SevalTExample();
		SevalTExample.Criteria c = example.createCriteria();
		proSearchParam(sevalT, c);
		if (orderstr != null && orderstr.trim().length() > 0) {
			example.setOrderByClause(orderstr);
		}
		example.setCurrPage(page);
		example.setPageSize(pagesize);
		return sevalTMapper.selectPageByExample(example);
	}
	
	@Override
	public int count(SevalT sevalT) {
		SevalTExample example = new SevalTExample();
		SevalTExample.Criteria c = example.createCriteria();
		proSearchParam(sevalT, c);
		return sevalTMapper.countByExample(example);
	}


	public void proSearchParam(SitemT sitemT, SitemTExample.Criteria criteria) {
		if (null != sitemT) {
			if (StringUtils.isNotEmpty(sitemT.getTitle())) {
				criteria.andTitleLike("%" + sitemT.getTitle() + "%");
			}
			if (null != sitemT.getSvgid()) {
				criteria.andSvgidEqualTo(sitemT.getSvgid());
			}

			if (null != sitemT.getScode()) {
				criteria.andCodeEqualTo(sitemT.getScode());
			}

			if (null != sitemT.getSubscode()) {
				criteria.andSubcodeEqualTo(sitemT.getSubscode());
			}

			if (null != sitemT.getStatus()) {
				criteria.andStateEqualTo(sitemT.getStatus());
			}

			if (StringUtils.isNotEmpty(sitemT.getAreacodes())) {
				criteria.andAreacodesIn(sitemT.getAreacodes());
			}

		}
	}

	public void proSearchParam(SevalT sevalT, SevalTExample.Criteria criteria) {
		if (null != sevalT) {

			if (null != sevalT.getSitemid()) {
				criteria.andSitemidEqualTo(sevalT.getSitemid());
			}

			if (null != sevalT.getStatus()) {
				criteria.andStatusEqualTo(sevalT.getStatus());
			}

		}
	}

	

}

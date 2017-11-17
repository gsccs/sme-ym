package com.gsccs.sme.plat.rtable.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.rtable.dao.PropTMapper;
import com.gsccs.sme.plat.rtable.dao.PropvalTMapper;
import com.gsccs.sme.plat.rtable.model.PropT;
import com.gsccs.sme.plat.rtable.model.PropTExample;
import com.gsccs.sme.plat.rtable.model.PropvalT;
import com.gsccs.sme.plat.rtable.model.PropvalTExample;

@Service
public class PropServiceImpl implements PropService {

	@Autowired
	private PropTMapper propTMapper;
	@Autowired
	private PropvalTMapper propvalTMapper;

	@Override
	public void addProp(PropT prop) {
		if (null != prop) {
			prop.setId(UUID.randomUUID().toString());
			propTMapper.insert(prop);
		}
	}

	@Override
	public List<PropT> find(PropT prop, String order, int currPage, int pageSize) {
		PropTExample example = new PropTExample();
		PropTExample.Criteria c = example.createCriteria();
		proSearchParam(prop, c);
		example.setPageSize(pageSize);
		example.setCurrPage(currPage);
		return propTMapper.selectPageByExample(example);
	}

	@Override
	public int count(PropT prop) {
		PropTExample example = new PropTExample();
		PropTExample.Criteria c = example.createCriteria();
		proSearchParam(prop, c);
		return propTMapper.countByExample(example);
	}

	@Override
	public PropT getProp(String id) {
		return propTMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateProp(PropT prop) {
		if (null != prop) {
			propTMapper.updateByPrimaryKeySelective(prop);
		}
	}

	@Override
	public void delProp(String id) {
		propTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<PropvalT> findCorpProp(String corpid, String productid) {
		if (StringUtils.isNotEmpty(corpid) && StringUtils.isNotEmpty(productid)) {
			return propvalTMapper.selectCorpProductProps(productid, corpid);
		}
		return null;
	}

	@Override
	public List<PropvalT> findCorpProp(String corpid) {
		if (StringUtils.isNotEmpty(corpid)) {
			return propvalTMapper.selectCorpProps(corpid);
		}
		return null;
	}

	private void proSearchParam(PropT prop, PropTExample.Criteria criteria) {
		if (prop != null) {
			if (prop.getId() != null) {
				criteria.andIdEqualTo(prop.getId());
			}

			if (StringUtils.isNotEmpty(prop.getTitle())) {
				criteria.andTitleLike("%" + prop.getTitle() + "%");
			}

			if (StringUtils.isNotEmpty(prop.getReportid())) {
				criteria.andProductidEqualTo(prop.getReportid());
			}
		}
	}

	private void proSearchParam(PropvalT propval,
			PropvalTExample.Criteria criteria) {
		if (propval != null) {
			if (StringUtils.isNotEmpty(propval.getReportid())) {
				criteria.andProductidEqualTo(propval.getReportid());
			}

			if (StringUtils.isNotEmpty(propval.getCorpid())) {
				criteria.andCorpidEqualTo(propval.getCorpid());
			}

			if (StringUtils.isNotEmpty(propval.getPropid())) {
				criteria.andPropidEqualTo(propval.getPropid());
			}
		}
	}

	@Override
	public void addPropv(PropvalT propv) {
		if (null != propv) {
			propv.setId(UUID.randomUUID().toString());
			propvalTMapper.insert(propv);
		}
	}

	@Override
	public void updatePropv(PropvalT propv) {
		propvalTMapper.updateByPrimaryKey(propv);

	}

	@Override
	public PropvalT getPropv(String id) {
		return propvalTMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delPropv(String id) {
		propvalTMapper.deleteByPrimaryKey(id);

	}

	@Override
	public List<PropvalT> find(PropvalT propv, String order, int currPage,
			int pageSize) {
		PropvalTExample example = new PropvalTExample();
		PropvalTExample.Criteria c = example.createCriteria();
		proSearchParam(propv, c);
		example.setPageSize(pageSize);
		example.setCurrPage(currPage);
		return propvalTMapper.selectPageByExample(example);
	}

	@Override
	public int count(PropvalT propv) {
		PropvalTExample example = new PropvalTExample();
		PropvalTExample.Criteria c = example.createCriteria();
		proSearchParam(propv, c);
		return propvalTMapper.countByExample(example);
	}

	@Override
	public void savePropvalList(List<PropvalT> propvlist) {
		if (null != propvlist && propvlist.size() > 0) {
			for (PropvalT propval : propvlist) {
				if (null != propval
						&& StringUtils.isNotEmpty(propval.getReportid())
						&& StringUtils.isNotEmpty(propval.getCorpid())) {

					List<PropvalT> vallist = this.find(propval, "", 1,
							Integer.MAX_VALUE);
					if (null != vallist && vallist.size() > 0) {
						for (PropvalT propvalT_ : vallist) {
							propvalT_.setPropval(propval.getPropval());
							propvalT_.setAddtime(new Date());
							propvalT_.setRemark(propval.getRemark());
							propvalTMapper.updateByPrimaryKey(propvalT_);
						}
					} else {
						propval.setId(UUID.randomUUID().toString());
						propval.setAddtime(new Date());
						propvalTMapper.insert(propval);
					}
				}

			}
		}
	}

}

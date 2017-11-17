package com.gsccs.sme.plat.svg.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.plat.auth.dao.DictItemTMapper;
import com.gsccs.sme.plat.auth.service.AreaService;
import com.gsccs.sme.plat.bass.BaseExample;
import com.gsccs.sme.plat.svg.dao.ActenrollTMapper;
import com.gsccs.sme.plat.svg.dao.ActivityTMapper;
import com.gsccs.sme.plat.svg.dao.RegTypeTMapper;
import com.gsccs.sme.plat.svg.dao.SclassTMapper;
import com.gsccs.sme.plat.svg.model.ActenrollT;
import com.gsccs.sme.plat.svg.model.ActenrollTExample;
import com.gsccs.sme.plat.svg.model.ActivityT;
import com.gsccs.sme.plat.svg.model.ActivityTExample;
import com.gsccs.sme.plat.svg.model.SclassT;

/**
 * 活动业务
 * 
 * @创建时间：2016.3.1
 */
@Service(value = "activityService")
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityTMapper activityTMapper;
	@Autowired
	private ActenrollTMapper actenrollTMapper;
	@Autowired
	private DictItemTMapper dictItemTMapper;
	@Autowired
	private RegTypeTMapper regTypeTMapper;
	@Autowired
	private SclassTMapper sclassTMapper;
	@Autowired
	private AreaService areaService;

	/**
	 * 根据id查询
	 */
	@Override
	public ActivityT findById(Long id) {
		ActivityT t = activityTMapper.selectByPrimaryKey(id);
		if (null != t) {
			// 服务分类
			Long scode = t.getScode();
			// 二级分类
			Long subscode = t.getSubscode();

			if (null != scode) {
				SclassT sclassT = sclassTMapper.selectByPrimaryKey(scode);
				t.setSclassstr(sclassT.getTitle());
			}

			String areastr = "";
			if (null != t.getAcode()) {
				areastr += areaService.getAreaStr(t.getAcode());
			} else if (null != t.getCcode()) {
				areastr += areaService.getAreaStr(t.getCcode());
			} else if (null != t.getPcode()) {
				areastr += areaService.getAreaStr(t.getPcode());
			}
			String address = t.getAddress() == null ? "" : t.getAddress();
			areastr = areastr + address;
			t.setAreastr(areastr);
		}
		return t;
	}

	/**
	 * 添加服务项
	 */
	@Override
	public void insert(ActivityT activityT) {
		if (null != activityT) {
			activityT.setAddtime(new Date());
			activityT.setStatus("0");
			activityT.setIsrelease("0");
			activityTMapper.insert(activityT);
		}
	}

	/**
	 * 修改活动信息
	 */
	@Override
	public void update(ActivityT activityT) {
		if (null != activityT) {
			if (null == activityT.getAddtime()) {
				activityT.setAddtime(new Date());
			}
			activityTMapper.updateByPrimaryKeyWithBLOBs(activityT);
		}
	}

	@Override
	public List<ActivityT> find(ActivityT sitemT, String order, int currPage,
			int pageSize) {
		ActivityTExample example = new ActivityTExample();
		ActivityTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sitemT, criteria);
		if (StringUtils.isNotEmpty(order)) {
			example.setOrderByClause(order);
		} else {
			example.setOrderByClause(" addtime desc");
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		List<ActivityT> activityTs = activityTMapper
				.selectPageByExample(example);
		if (null != activityTs && activityTs.size() > 0) {
			for (ActivityT activity : activityTs) {
				Long scode = activity.getScode();
				Long subscode = activity.getSubscode();
				if (null != scode) {
					SclassT sclassT = sclassTMapper.selectByPrimaryKey(scode);
					activity.setSclassstr(sclassT.getTitle());
				}
				String areastr = "";
				if (null != activity.getAcode()) {
					areastr += areaService.getAreaStr(activity.getAcode());
				} else if (null != activity.getCcode()) {
					areastr += areaService.getAreaStr(activity.getCcode());
				} else if (null != activity.getPcode()) {
					areastr += areaService.getAreaStr(activity.getPcode());
				}
				String address = activity.getAddress() == null ? "" : activity
						.getAddress();
				areastr = areastr + address;
				activity.setAreastr(areastr);
			}
		}
		return activityTs;
	}

	@Override
	public void delActivity(Long id) {
		activityTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int count(ActivityT sitemT) {
		ActivityTExample example = new ActivityTExample();
		ActivityTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sitemT, criteria);
		return activityTMapper.countByExample(example);
	}

	@Override
	public List<ActivityT> find(ActivityT activityT) {
		ActivityTExample example = new ActivityTExample();
		ActivityTExample.Criteria criteria = example.createCriteria();
		proSearchParam(activityT, criteria);

		return activityTMapper.selectByExample(example);
	}

	@Override
	public void insert(ActenrollT actenrollT) {
		if (null != actenrollT) {
			if (null == actenrollT.getUsernum()) {
				actenrollT.setUsernum(1);
			}
			actenrollT.setAddtime(new Date());
			actenrollTMapper.insert(actenrollT);
		}
	}

	@Override
	public List<ActenrollT> find(ActenrollT actenrollT, String order,
			int currPage, int pageSize) {
		ActenrollTExample example = new ActenrollTExample();
		ActenrollTExample.Criteria criteria = example.createCriteria();
		proSearchParam(actenrollT, criteria);
		if (StringUtils.isNotEmpty(order)) {
			example.setOrderByClause(order);
		} else {
			example.setOrderByClause(" addtime desc");
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return actenrollTMapper.selectPageByExample(example);
	}

	public void proSearchParam(ActivityT sitemT,
			ActivityTExample.Criteria criteria) {
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
			if (null != sitemT.getSvgid()) {
				criteria.andSvgidEqualTo(sitemT.getSvgid());
			}
			if (null != sitemT.getStatus()) {
				criteria.andStatusEqualTo(sitemT.getStatus());
			}
			if (null != sitemT.getIsrelease()) {
				criteria.andReleaseEqualTo(sitemT.getIsrelease());
			}
		}
	}

	public void proSearchParam(ActenrollT actenrollT,
			ActenrollTExample.Criteria criteria) {
		if (null != actenrollT) {

			if (null != actenrollT.getSvgid()) {
				criteria.andSvgidEqualTo(actenrollT.getSvgid());
			}

			if (null != actenrollT.getCorpid()) {
				criteria.andCorpidEqualTo(actenrollT.getCorpid());
			}

			if (null != actenrollT.getUserid()) {
				criteria.andUseridEqualTo(actenrollT.getUserid());
			}

			if (null != actenrollT.getActid()) {
				criteria.andActidEqualTo(actenrollT.getActid());
			}
		}
	}

	@Override
	public void delete(Long actid, Long userid) {
		ActenrollTExample example = new ActenrollTExample();
		ActenrollTExample.Criteria c = example.createCriteria();
		c.andUseridEqualTo(userid);
		c.andActidEqualTo(actid);
		actenrollTMapper.deleteByExample(example);
	}

	@Override
	public Datagrid enrollActList(Long userid, String order, int currPage,
			int pageSize) {
		Datagrid datagrid = new Datagrid();
		BaseExample baseExample = new BaseExample();
		baseExample.setCurrPage(currPage);
		baseExample.setPageSize(pageSize);

		List<ActivityT> activityTs = activityTMapper.selectPageEnroll(userid,
				baseExample.getSkip(), baseExample.getPageSize());
		int total = activityTMapper.countEnrollAct(userid);
		datagrid.setRows(activityTs);
		datagrid.setTotal(Long.valueOf(total));
		return datagrid;
	}

	@Override
	public int count(ActenrollT actenrollT) {
		ActenrollTExample example = new ActenrollTExample();
		ActenrollTExample.Criteria criteria = example.createCriteria();
		proSearchParam(actenrollT, criteria);
		return actenrollTMapper.countByExample(example);
	}

}

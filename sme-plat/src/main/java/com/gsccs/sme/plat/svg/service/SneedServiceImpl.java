package com.gsccs.sme.plat.svg.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.api.domain.CapitalAppl;
import com.gsccs.sme.api.domain.CapitalReply;
import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.api.domain.SneedBid;
import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.plat.svg.dao.SclassTMapper;
import com.gsccs.sme.plat.svg.dao.SneedAttachTMapper;
import com.gsccs.sme.plat.svg.dao.SneedBidMapper;
import com.gsccs.sme.plat.svg.dao.SneedMapper;
import com.gsccs.sme.plat.svg.model.SneedAttachT;
import com.gsccs.sme.plat.svg.model.SneedAttachTExample;
import com.gsccs.sme.plat.svg.model.SneedBidExample;
import com.gsccs.sme.plat.svg.model.SneedExample;
import com.gsccs.sme.plat.task.dao.CapitalApplMapper;
import com.gsccs.sme.plat.task.dao.CapitalReplyMapper;
import com.gsccs.sme.plat.task.model.CapitalApplExample;
import com.gsccs.sme.plat.task.model.CapitalReplyExample;

@Service
public class SneedServiceImpl implements SneedService {

	@Autowired
	private SneedMapper sneedMapper;
	@Autowired
	private SneedBidMapper sneedBidMapper;
	@Autowired
	private SclassTMapper sclassTMapper;
	@Autowired
	private SneedAttachTMapper sneedAttachTMapper;
	@Autowired
	private CapitalApplMapper capitalApplMapper;
	@Autowired
	private CapitalReplyMapper capitalReplyMapper;

	@Override
	public Long addSneed(Sneed sneed) {
		if (null != sneed) {
			sneed.setStatus("0");
			sneed.setAddtime(new Date());
			sneedMapper.insert(sneed);
			List<Attach> attachs = sneed.getAttachs();
			if (null != attachs && attachs.size() > 0) {
				List<SneedAttachT> attachlist = new ArrayList<SneedAttachT>();
				for (Attach attach : attachs) {
					SneedAttachT attachT = new SneedAttachT();
					attachT.setSneedid(sneed.getId());
					attachT.setFilename(attach.getFilename());
					attachT.setFilepath(attach.getFilepath());
					attachT.setFiletype(attach.getFiletype());
					attachlist.add(attachT);
				}
				addAttachs(attachlist);
			}
			return sneed.getId();
		}
		return null;
	}

	@Override
	public Sneed getSneed(Long id) {
		return sneedMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delSneed(Long id) {
		sneedMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Sneed> find(Sneed sneedT) {
		SneedExample example = new SneedExample();
		SneedExample.Criteria criteria = example.createCriteria();
		proSearchParam(sneedT, criteria);
		return sneedMapper.selectByExample(example);
	}

	@Override
	public List<Sneed> find(Sneed sneedT, String order, int currPage,
			int pageSize) {
		SneedExample example = new SneedExample();
		SneedExample.Criteria criteria = example.createCriteria();
		proSearchParam(sneedT, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		if (StringUtils.isNotEmpty(order)) {
			example.setOrderByClause(order);
		} else {
			example.setOrderByClause("addtime desc");
		}
		return sneedMapper.selectPageByExample(example);
	}

	@Override
	public int count(Sneed sneedT) {
		SneedExample example = new SneedExample();
		SneedExample.Criteria criteria = example.createCriteria();
		proSearchParam(sneedT, criteria);
		return sneedMapper.countByExample(example);
	}
	

	@Override
	public void update(Sneed sneedT) {
		if (null != sneedT) {
			sneedMapper.updateByPrimaryKeyWithBLOBs(sneedT);
		}
	}

	@Override
	public void addAttachs(List<SneedAttachT> attachs) {
		if (null != attachs) {
			for (SneedAttachT attachT : attachs) {
				sneedAttachTMapper.insert(attachT);
			}
		}
	}
	
	
	

	@Override
	public List<SneedAttachT> findAttachs(Long sneedid) {
		if (null != sneedid) {
			SneedAttachTExample example = new SneedAttachTExample();
			SneedAttachTExample.Criteria c = example.createCriteria();
			c.andSneedidEqualTo(sneedid);
			return sneedAttachTMapper.selectByExample(example);
		}
		return null;
	}

	@Override
	public void addBid(SneedBid sneedBidT) {
		if (null != sneedBidT && null != sneedBidT.getSneedid()
				&& null != sneedBidT.getSvgid()) {
			List<SneedBid> list = find(sneedBidT.getSneedid(),
					sneedBidT.getSvgid());
			if (null == list || list.size() <= 0) {
				sneedBidT.setAddtime(new Date());
				sneedBidT.setIstoned("0");
				sneedBidT.setStatus("0");
				sneedBidMapper.insert(sneedBidT);
				Sneed sneedT = sneedMapper.selectByPrimaryKey(sneedBidT
						.getSneedid());
				int bidnum = sneedT.getSalenum() == null ? 0 : sneedT
						.getSalenum();
				sneedT.setSalenum(bidnum + 1);
				sneedT.setStatus("1");
				sneedMapper.updateByPrimaryKey(sneedT);
			}
		}
	}

	public void updateBid(SneedBid param) {
		if (null != param) {
			SneedBid bidT = sneedBidMapper.selectByPrimaryKey(param
					.getId());
			if (null == bidT) {
				param.setAddtime(new Date());
				param.setIstoned("0");
				param.setLasttime(new Date());
				sneedBidMapper.insert(param);
			}else{
				param.setLasttime(new Date());
				sneedBidMapper.updateByPrimaryKey(param);
			}
		}
	}

	@Override
	public List<SneedBid> find(SneedBid param, String order, int currPage,
			int pageSize) {
		SneedBidExample example = new SneedBidExample();
		SneedBidExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return sneedBidMapper.selectPageByExample(example);
	}

	@Override
	public int count(SneedBid param) {
		SneedBidExample example = new SneedBidExample();
		SneedBidExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return sneedBidMapper.countByExample(example);
	}

	@Override
	public List<SneedBid> find(Long sneedid, Long svgid) {
		SneedBidExample example = new SneedBidExample();
		SneedBidExample.Criteria c = example.createCriteria();
		if (null != sneedid) {
			c.andSneedidEqualTo(sneedid);
		}
		if (null != svgid) {
			c.andSvgidEqualTo(svgid);
		}
		return sneedBidMapper.selectByExample(example);
	}

	@Override
	public SneedBid find(Long id) {
		return sneedBidMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delSneedBid(Long id) {
		sneedBidMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<CapitalAppl> find(CapitalAppl param, String order,
			int currPage, int pageSize) {
		CapitalApplExample example = new CapitalApplExample();
		CapitalApplExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return capitalApplMapper.selectPageByExample(example);
	}

	@Override
	public int count(CapitalAppl param) {
		CapitalApplExample example = new CapitalApplExample();
		CapitalApplExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		return capitalApplMapper.countByExample(example);
	}

	@Override
	public void addCapitalAppl(CapitalAppl appl) {
		if (null != appl) {
			appl.setAddtime(new Date());
			appl.setStatus("0");
			capitalApplMapper.insert(appl);
		}
	}

	@Override
	public CapitalAppl getCapitalAppl(Long id) {
		return capitalApplMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delCapitalAppl(Long id) {
		CapitalReplyExample example = new CapitalReplyExample();
		CapitalReplyExample.Criteria criteria = example.createCriteria();
		if (null != id) {
			criteria.andApplidEqualTo(id);
		}
		capitalReplyMapper.deleteByExample(example);
		capitalApplMapper.deleteByPrimaryKey(id);
	}

	public void proSearchParam(Sneed sneedT, SneedExample.Criteria criteria) {
		if (null != sneedT) {
			if (StringUtils.isNotEmpty(sneedT.getTitle())) {
				criteria.andTitleLike("%" + sneedT.getTitle() + "%");
			}

			if (null != sneedT.getCorpid()) {
				criteria.andCorpidEqualTo(sneedT.getCorpid());
			}

			if (null != sneedT.getScode()) {
				criteria.andCodeEqualTo(sneedT.getScode());
			}

			if (null != sneedT.getSubscode()) {
				criteria.andSubcodeEqualTo(sneedT.getSubscode());
			}
		}
	}

	public void proSearchParam(SneedBid param,
			SneedBidExample.Criteria criteria) {
		if (null != param) {
			if (null != param.getSneedid()) {
				criteria.andSneedidEqualTo(param.getSneedid());
			}

			if (null != param.getSvgid()) {
				criteria.andSvgidEqualTo(param.getSvgid());
			}

			if (null != param.getIstoned()) {
				criteria.andIstonedEqualTo(param.getIstoned());
			}
		}
	}

	public void proSearchParam(CapitalAppl param,
			CapitalApplExample.Criteria criteria) {
		if (null != param) {
			if (null != param.getCorpid()) {
				criteria.andCorpidEqualTo(param.getCorpid());
			}

			if (null != param.getSvgid()) {
				criteria.andSvgidEqualTo(param.getSvgid());
			}

			if (null != param.getStatus()) {
				criteria.andStatusEqualTo(param.getStatus());
			}
		}
	}

	public void proSearchParam(CapitalReply param,
			CapitalReplyExample.Criteria criteria) {
		if (null != param) {
			if (null != param.getSvgid()) {
				criteria.andSvgidEqualTo(param.getSvgid());
			}

			if (null != param.getStatus()) {
				criteria.andStatusEqualTo(param.getStatus());
			}

			if (null != param.getIsstoned()) {
				criteria.andIsstonedEqualTo(param.getIsstoned());
			}
		}
	}

	public List<CapitalReply> find(CapitalReply param, String order,
			int currPage, int pageSize) {
		CapitalReplyExample example = new CapitalReplyExample();
		CapitalReplyExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return capitalReplyMapper.selectAllByExample(example);
	}
	
	@Override
	public List<CapitalReply> find(Long applid, String order, int currPage,
			int pageSize) {
		CapitalReplyExample example = new CapitalReplyExample();
		CapitalReplyExample.Criteria criteria = example.createCriteria();
		if (null != applid) {
			criteria.andApplidEqualTo(applid);
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return capitalReplyMapper.selectApplByExample(example);
	}

	@Override
	public int count(CapitalReply param) {
		CapitalReplyExample example = new CapitalReplyExample();
		CapitalReplyExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		return capitalReplyMapper.countByExample(example);
	}
	
	@Override
	public void addCapitalReply(CapitalReply param) {
		if (null != param) {
			param.setAddtime(new Date());
			capitalReplyMapper.insert(param);
		}
	}

	@Override
	public CapitalReply getCapitalReply(Long id) {
		return capitalReplyMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delCapitalReply(Long id) {
		capitalReplyMapper.deleteByPrimaryKey(id);
	}

	

}
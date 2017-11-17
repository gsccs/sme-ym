package com.gsccs.sme.plat.svg.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.plat.auth.model.MsgT;
import com.gsccs.sme.plat.auth.service.MsgService;
import com.gsccs.sme.plat.svg.dao.DeclareAttachTMapper;
import com.gsccs.sme.plat.svg.dao.DeclareItemTMapper;
import com.gsccs.sme.plat.svg.dao.DeclareTopicTMapper;
import com.gsccs.sme.plat.svg.dao.DeclareTraceTMapper;
import com.gsccs.sme.plat.svg.model.DeclareAttachT;
import com.gsccs.sme.plat.svg.model.DeclareAttachTExample;
import com.gsccs.sme.plat.svg.model.DeclareItemT;
import com.gsccs.sme.plat.svg.model.DeclareItemTExample;
import com.gsccs.sme.plat.svg.model.DeclareTopicT;
import com.gsccs.sme.plat.svg.model.DeclareTopicTExample;
import com.gsccs.sme.plat.svg.model.DeclareTraceT;
import com.gsccs.sme.plat.svg.model.DeclareTraceTExample;

/**
 * 项目申报业务实现类
 * 
 * @创建时间：2016.3.1
 */
@Service(value = "declareService")
public class DeclareServiceImpl implements DeclareService {

	@Autowired
	private DeclareItemTMapper declareItemTMapper;
	@Autowired
	private DeclareTopicTMapper declareTopicTMapper;
	@Autowired
	private DeclareAttachTMapper declareAttachTMapper;
	@Autowired
	private DeclareTraceTMapper declareTraceTMapper;
	@Autowired
	private MsgService msgService;

	@Override
	public Long insertTopic(DeclareTopicT topicT) {
		if (null != topicT) {
			declareTopicTMapper.insert(topicT);
			Long topicid = topicT.getId();
			List<Attach> attachs = topicT.getAttachs();
			if (null != attachs && attachs.size()>0){
				for(Attach attach:attachs){
					DeclareAttachT declareAttachT = new DeclareAttachT();
					declareAttachT.setTopicid(topicid);
					declareAttachT.setFilename(attach.getFilename());
					declareAttachT.setFilepath(attach.getFilepath());
					declareAttachT.setFiletype(attach.getFiletype());
					declareAttachTMapper.insert(declareAttachT);
				}
			}
			return topicid;
		}
		return null;
	}

	@Override
	public void updateTopic(DeclareTopicT topicT) {
		if (null != topicT) {
			declareTopicTMapper.updateByPrimaryKey(topicT);
		}

	}

	@Override
	public void delTopics(List<Long> ids) {
		DeclareTopicTExample example = new DeclareTopicTExample();
		DeclareTopicTExample.Criteria c = example.createCriteria();
		c.andIdIn(ids);
		declareTopicTMapper.deleteByExample(example);
	}

	@Override
	public void delTopics(Long ids) {
		declareTopicTMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public DeclareTopicT findTopicById(Long id) {
		return declareTopicTMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertItem(DeclareItemT itemT) {
		if (null != itemT) {
			itemT.setAddtime(new Date());
			itemT.setStatus("0");
			declareItemTMapper.insert(itemT);
			Long sitemid = itemT.getId();
			List<Attach> attachs = itemT.getAttachs();
			if (null != attachs && attachs.size()>0){
				for(Attach attach:attachs){
					DeclareAttachT declareAttachT = new DeclareAttachT();
					declareAttachT.setCorpid(itemT.getCorpid());
					declareAttachT.setItemid(sitemid);
					declareAttachT.setTopicid(itemT.getTopicid());
					declareAttachT.setFilename(attach.getFilename());
					declareAttachT.setFilepath(attach.getFilepath());
					declareAttachT.setFiletype(attach.getFiletype());
					declareAttachTMapper.insert(declareAttachT);
				}
			}
		}
	}

	@Override
	public void updateItem(DeclareItemT itemT) {
		if (null != itemT) {
			itemT.setEndtime(new Date());
			declareItemTMapper.updateByPrimaryKeySelective(itemT);
			
			List<Attach> attachs = itemT.getAttachs();
			if (null != attachs && attachs.size()>0){
				for(Attach attach:attachs){
					DeclareAttachT declareAttachT = new DeclareAttachT();
					declareAttachT.setCorpid(itemT.getCorpid());
					declareAttachT.setItemid(itemT.getId());
					declareAttachT.setTopicid(itemT.getTopicid());
					declareAttachT.setFilename(attach.getFilename());
					declareAttachT.setFilepath(attach.getFilepath());
					declareAttachT.setFiletype(attach.getFiletype());
					declareAttachTMapper.insert(declareAttachT);
				}
			}
		}
	}

	@Override
	public void delItems(List<Long> ids) {
		DeclareItemTExample example = new DeclareItemTExample();
		DeclareItemTExample.Criteria c = example.createCriteria();
		c.andIdIn(ids);
		declareItemTMapper.deleteByExample(example);
	}

	@Override
	public void delAttachs(List<Long> ids) {
		DeclareAttachTExample example = new DeclareAttachTExample();
		DeclareAttachTExample.Criteria c = example.createCriteria();
		c.andIdIn(ids);
		declareAttachTMapper.deleteByExample(example);
	}

	@Override
	public void delAttachs(Long id) {
		declareAttachTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public DeclareItemT findItemById(Long id) {
		return declareItemTMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DeclareTopicT> find(DeclareTopicT topicT, String order,
			int page, int pageSize) {
		DeclareTopicTExample example = new DeclareTopicTExample();
		DeclareTopicTExample.Criteria criteria = example.createCriteria();
		proSearchParam(topicT, criteria);
		example.setCurrPage(page);
		example.setPageSize(pageSize);
		example.setOrderByClause("starttime desc");
		return declareTopicTMapper.selectPageByExample(example);
	}

	@Override
	public int count(DeclareTopicT topicT) {
		DeclareTopicTExample example = new DeclareTopicTExample();
		DeclareTopicTExample.Criteria criteria = example.createCriteria();
		proSearchParam(topicT, criteria);
		return declareTopicTMapper.countByExample(example);
	}

	@Override
	public List<DeclareItemT> findItemByCorp(DeclareItemT itemT, String order,
			int page, int pageSize) {
		DeclareItemTExample example = new DeclareItemTExample();
		DeclareItemTExample.Criteria criteria = example.createCriteria();
		proSearchParam(itemT, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		example.setCurrPage(page);
		example.setPageSize(pageSize);
		return declareItemTMapper.selectCorpDeclares(example);
	}

	@Override
	public List<DeclareItemT> findCorpDeclares(DeclareItemT itemT) {
		DeclareItemTExample example = new DeclareItemTExample();
		DeclareItemTExample.Criteria criteria = example.createCriteria();
		proSearchParam(itemT, criteria);
		return declareItemTMapper.selectCorpDeclares(example);
	}

	@Override
	public int count(DeclareItemT itemT) {
		DeclareItemTExample example = new DeclareItemTExample();
		DeclareItemTExample.Criteria criteria = example.createCriteria();
		proSearchParam(itemT, criteria);
		return declareItemTMapper.countByExample(example);
	}

	@Override
	public List<DeclareAttachT> find(DeclareAttachT param) {
		DeclareAttachTExample example = new DeclareAttachTExample();
		DeclareAttachTExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		return declareAttachTMapper.selectByExample(example);
	}

	public void proSearchParam(DeclareTopicT topicT,
			DeclareTopicTExample.Criteria criteria) {
		if (null != topicT) {
			if (null != topicT.getSvgid()) {
				criteria.andSvgidEqualTo(topicT.getSvgid());
			}
		}
	}

	public void proSearchParam(DeclareItemT itemT,
			DeclareItemTExample.Criteria criteria) {
		if (null != itemT) {
			if (null != itemT.getCorpid()) {
				criteria.andCorpidEqualTo(itemT.getCorpid());
			}
			if (null != itemT.getTopicid()) {
				criteria.andTopicidEqualTo(itemT.getTopicid());
			}
		}
	}

	public void proSearchParam(DeclareAttachT attachT,
			DeclareAttachTExample.Criteria criteria) {
		if (null != attachT) {
			if (null != attachT.getTopicid()) {
				criteria.andTopicidEqualTo(attachT.getTopicid());
			}
			if (null != attachT.getCorpid()) {
				criteria.andCorpidEqualTo(attachT.getCorpid());
			}
			if(null != attachT.getItemid()){
				criteria.andItemidEqualTo(attachT.getItemid());
			}else{
				criteria.andItemidIsNull();
			}
			
		}
	}

	@Override
	public void insertAttach(List<DeclareAttachT> attachTs) {
		if (null != attachTs && attachTs.size() > 0) {
			for (DeclareAttachT attachT : attachTs) {
				declareAttachTMapper.insert(attachT);
			}
		}
	}

	@Override
	public List<DeclareItemT> findItemBySvg(DeclareItemT itemT, String order,
			int page, int pageSize) {
		DeclareItemTExample example = new DeclareItemTExample();
		DeclareItemTExample.Criteria criteria = example.createCriteria();
		proSearchParam(itemT, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		example.setCurrPage(page);
		example.setPageSize(pageSize);
		return declareItemTMapper.selectPageByExample(example);
	}

	@Override
	public List<DeclareTraceT> findItemTraces(Long itemid, String order,
			int page, int pagesize) {
		DeclareTraceTExample example = new DeclareTraceTExample();
		DeclareTraceTExample.Criteria criteria = example.createCriteria();
		if (null!=itemid){
			criteria.andItemidEqualTo(itemid);
		}else{
			criteria.andItemidEqualTo(0l);
		}
		example.setCurrPage(page);
		example.setPageSize(pagesize);
		return declareTraceTMapper.selectPageByExample(example);
	}

	@Override
	public JSONArray findItemTraces(Long itemid) {
		List<DeclareTraceT> list = findItemTraces(itemid,"",1,Integer.MAX_VALUE);
		if (null != list){
			return (JSONArray) JSONArray.toJSON(list);
		}
		return new JSONArray();
	}
}

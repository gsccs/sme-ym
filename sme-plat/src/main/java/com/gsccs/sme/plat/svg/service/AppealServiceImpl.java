package com.gsccs.sme.plat.svg.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.api.domain.StatistGovNum;
import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.plat.auth.service.SmsService;
import com.gsccs.sme.plat.auth.service.UserService;
import com.gsccs.sme.plat.svg.dao.AppealAttachTMapper;
import com.gsccs.sme.plat.svg.dao.AppealItemTMapper;
import com.gsccs.sme.plat.svg.dao.AppealPushTMapper;
import com.gsccs.sme.plat.svg.dao.AppealTopicTMapper;
import com.gsccs.sme.plat.svg.dao.AppealTraceTMapper;
import com.gsccs.sme.plat.svg.model.AppealAttachT;
import com.gsccs.sme.plat.svg.model.AppealAttachTExample;
import com.gsccs.sme.plat.svg.model.AppealItemT;
import com.gsccs.sme.plat.svg.model.AppealItemTExample;
import com.gsccs.sme.plat.svg.model.AppealPushT;
import com.gsccs.sme.plat.svg.model.AppealPushTExample;
import com.gsccs.sme.plat.svg.model.AppealTopicT;
import com.gsccs.sme.plat.svg.model.AppealTopicTExample;
import com.gsccs.sme.plat.svg.model.AppealTraceT;
import com.gsccs.sme.plat.svg.model.AppealTraceTExample;

/**
 * 项目申报业务实现类
 * 
 * @创建时间：2016.3.1
 */
@Service(value = "appealService")
public class AppealServiceImpl implements AppealService {

	@Autowired
	private AppealItemTMapper appealItemTMapper;
	@Autowired
	private AppealTopicTMapper appealTopicTMapper;
	@Autowired
	private AppealAttachTMapper appealAttachTMapper;
	@Autowired
	private AppealTraceTMapper appealTraceTMapper;
	@Autowired
	private AppealPushTMapper appealPushTMapper;
	@Autowired
	private SmsService smsService;
	@Autowired
	private UserService userService;
	

	public void insertTopic(AppealTopicT topicT) {
		if (null == topicT) {
			return;
		}
		topicT.setAddtime(new Date());
		appealTopicTMapper.insert(topicT);
		if (null != topicT.getAttachs() && topicT.getAttachs().size() > 0) {
			for (Attach attach : topicT.getAttachs()) {
				AppealAttachT attachT = new AppealAttachT();
				attachT.setTopicid(topicT.getId());
				attachT.setFilename(attach.getFilename());
				attachT.setFilepath(attach.getFilepath());
				attachT.setFiletype(attach.getFiletype());
				appealAttachTMapper.insert(attachT);
			}
		}
	}

	@Override
	public void updateTopic(AppealTopicT topicT) {
		if (null == topicT) {
			return;
		}
		appealTopicTMapper.updateByPrimaryKeyWithBLOBs(topicT);
		
		if (null != topicT.getAttachs() && topicT.getAttachs().size() > 0) {
			for (Attach attach : topicT.getAttachs()) {
				AppealAttachT attachT = new AppealAttachT();
				attachT.setTopicid(topicT.getId());
				attachT.setFilename(attach.getFilename());
				attachT.setFilepath(attach.getFilepath());
				attachT.setFiletype(attach.getFiletype());
				saveAttach(attachT);
			}
		}
	}
	
	public void saveAttach(AppealAttachT attachT){
		if (null ==attachT){
			return;
		}
		AppealAttachTExample example = new AppealAttachTExample();
		AppealAttachTExample.Criteria c = example.createCriteria();
		c.andFilenameEqualTo(attachT.getFilename());
		List<AppealAttachT> list = appealAttachTMapper.selectByExample(example);
		if (null != list && list.size()>0){
			return;
		}else{
			appealAttachTMapper.insert(attachT);
		}
		
		
	}

	@Override
	public void delTopics(List<Long> ids) {
		AppealTopicTExample example = new AppealTopicTExample();
		AppealTopicTExample.Criteria c = example.createCriteria();
		c.andIdIn(ids);
		appealTopicTMapper.deleteByExample(example);
	}

	@Override
	public AppealTopicT findTopicById(Long id) {
		AppealTopicT topicT = appealTopicTMapper.selectByPrimaryKey(id);
		if (null != topicT) {
			List<AppealAttachT> attachTs = findTopicAttachs(id);
			if (null != attachTs && attachTs.size() > 0) {
				List<Attach> attachs = new ArrayList<>();
				for (AppealAttachT attachT : attachTs) {
					Attach attach = new Attach();
					attach.setId(attachT.getId().toString());
					attach.setFilename(attachT.getFilename());
					attach.setFilepath(attachT.getFilepath());
					attach.setFiletype(attachT.getFiletype());
					attachs.add(attach);
				}
				topicT.setAttachs(attachs);
			}
		}
		return topicT;
	}

	public List<AppealAttachT> findTopicAttachs(Long topicid) {
		if (null != topicid) {
			AppealAttachTExample example = new AppealAttachTExample();
			AppealAttachTExample.Criteria c = example.createCriteria();
			c.andTopicidEqualTo(topicid);
			c.andItemidIsNull();
			return appealAttachTMapper.selectByExample(example);
		}
		return null;
	}

	public List<AppealAttachT> findItemAttachs(Long itemid) {
		if (null != itemid) {
			AppealAttachTExample example = new AppealAttachTExample();
			AppealAttachTExample.Criteria c = example.createCriteria();
			c.andItemidEqualTo(itemid);
			return appealAttachTMapper.selectByExample(example);
		}
		return null;
	}

	@Override
	public void insertItem(AppealItemT itemT) {
		if (null == itemT) {
			return;
		}
		itemT.setStatus("0"); // 已提交
		itemT.setPushnum(0);
		itemT.setAddtime(new Date());
		appealItemTMapper.insert(itemT);
		
		if (null != itemT.getAttachs() && itemT.getAttachs().size() > 0) {
			for (Attach attach : itemT.getAttachs()) {
				AppealAttachT attachT = new AppealAttachT();
				attachT.setItemid(itemT.getId());
				attachT.setTopicid(itemT.getTopicid());
				attachT.setFilename(attach.getFilename());
				attachT.setFilepath(attach.getFilepath());
				attachT.setFiletype(attach.getFiletype());
				appealAttachTMapper.insert(attachT);
			}
		}

		// 保存轨迹
		AppealTraceT traceT = new AppealTraceT();
		traceT.setContent("提交事项申请");
		traceT.setItemid(itemT.getId());
		traceT.setCorpid(itemT.getCorpid());
		traceT.setStatus("1");
		this.insertTrace(traceT);
		
		//发送短信
		//smsService.sendMsg(itemT.getSvgid(), "您有新的申请，请尽快登录平台受理！");
	}

	@Override
	public void updateItem(AppealItemT itemT) {
		if (null != itemT) {
			itemT.setEndtime(new Date());
			appealItemTMapper.updateByPrimaryKeySelective(itemT);
			
			if (null != itemT.getAttachs() && itemT.getAttachs().size() > 0) {
				for (Attach attach : itemT.getAttachs()) {
					AppealAttachT attachT = new AppealAttachT();
					attachT.setItemid(itemT.getId());
					attachT.setTopicid(itemT.getTopicid());
					attachT.setFilename(attach.getFilename());
					attachT.setFilepath(attach.getFilepath());
					attachT.setFiletype(attach.getFiletype());
					appealAttachTMapper.insert(attachT);
				}
			}
			
			if(null != itemT.getStatus() && itemT.getStatus().equals("2")){
				//发送短信
				smsService.sendMsg(itemT.getCorpid(), "您的申请已受理，请尽快登录平台确认！");
			}
		}

	}

	@Override
	public void delItems(List<Long> ids) {
		AppealAttachTExample example1 = new AppealAttachTExample();
		AppealAttachTExample.Criteria c1 = example1.createCriteria();
		c1.andItemidIn(ids);
		appealAttachTMapper.deleteByExample(example1);
		AppealItemTExample example = new AppealItemTExample();
		AppealItemTExample.Criteria c = example.createCriteria();
		c.andIdIn(ids);
		appealItemTMapper.deleteByExample(example);
	}

	@Override
	public void delAttachs(List<Long> ids) {
		AppealAttachTExample example = new AppealAttachTExample();
		AppealAttachTExample.Criteria c = example.createCriteria();
		c.andIdIn(ids);
		appealAttachTMapper.deleteByExample(example);
	}

	@Override
	public AppealItemT findItemById(Long id) {
		AppealItemT itemT = appealItemTMapper.selectByPrimaryKey(id);
		if (null != itemT) {
			List<AppealAttachT> attachTs = findItemAttachs(id);
			List<Attach> attachs = new ArrayList<>();
			for (AppealAttachT attachT : attachTs) {
				Attach attach = new Attach();
				attach.setId(attachT.getId().toString());
				attach.setFilename(attachT.getFilename());
				attach.setFilepath(attachT.getFilepath());
				attach.setFiletype(attachT.getFiletype());
				attachs.add(attach);
			}
			itemT.setAttachs(attachs);
		}
		return itemT;
	}

	@Override
	public List<AppealTopicT> find(AppealTopicT topicT, String order, int page,
			int pageSize) {
		AppealTopicTExample example = new AppealTopicTExample();
		AppealTopicTExample.Criteria criteria = example.createCriteria();
		proSearchParam(topicT, criteria);
		example.setCurrPage(page);
		example.setPageSize(pageSize);
		return appealTopicTMapper.selectPageByExample(example);
	}

	@Override
	public int count(AppealTopicT topicT) {
		AppealTopicTExample example = new AppealTopicTExample();
		AppealTopicTExample.Criteria criteria = example.createCriteria();
		proSearchParam(topicT, criteria);
		return appealTopicTMapper.countByExample(example);
	}

	@Override
	public List<AppealItemT> find(AppealItemT itemT, String order, int page,
			int pageSize) {
		AppealItemTExample example = new AppealItemTExample();
		AppealItemTExample.Criteria criteria = example.createCriteria();
		proSearchParam(itemT, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		example.setCurrPage(page);
		example.setPageSize(pageSize);
		return appealItemTMapper.selectPageByExample(example);
	}

	@Override
	public int count(AppealItemT itemT) {
		AppealItemTExample example = new AppealItemTExample();
		AppealItemTExample.Criteria criteria = example.createCriteria();
		proSearchParam(itemT, criteria);
		return appealItemTMapper.countByExample(example);
	}

	@Override
	public List<AppealAttachT> find(AppealAttachT param) {
		AppealAttachTExample example = new AppealAttachTExample();
		AppealAttachTExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		return appealAttachTMapper.selectByExample(example);
	}

	@Override
	public List<AppealTraceT> find(Long appealid) {
		if (null != appealid) {
			AppealTraceTExample example = new AppealTraceTExample();
			AppealTraceTExample.Criteria c = example.createCriteria();
			c.andItemidEqualTo(appealid);

			return appealTraceTMapper.selectByExample(example);
		}
		return null;
	}

	@Override
	public void insertTrace(AppealTraceT traceT) {
		if (null != traceT) {
			traceT.setAddtime(new Date());
			appealTraceTMapper.insert(traceT);
		}
	}

	@Override
	public void insertAppealPush(AppealPushT pushT) {
		if (null != pushT) {
			pushT.setAddtime(new Date());
			appealPushTMapper.insert(pushT);
		}
	}

	@Override
	public AppealPushT findAppealPushById(Long id) {
		return appealPushTMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<AppealPushT> find(AppealPushT param) {
		AppealPushTExample example = new AppealPushTExample();
		AppealPushTExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		return appealPushTMapper.selectByExample(example);
	}

	public void proSearchParam(AppealTopicT topicT,
			AppealTopicTExample.Criteria criteria) {
		if (null != topicT) {
			if (null != topicT.getSvgid()) {
				criteria.andSvgidEqualTo(topicT.getSvgid());
			}
			if (null != topicT.getScode()) {
				criteria.andScodeEqualTo(topicT.getScode());
			}
			if (null != topicT.getSubscode()) {
				criteria.andSubscodeEqualTo(topicT.getSubscode());
			}
		}
	}

	public void proSearchParam(AppealItemT itemT,
			AppealItemTExample.Criteria criteria) {
		if (null != itemT) {
			if (null != itemT.getCorpid()) {
				criteria.andCorpidEqualTo(itemT.getCorpid());
			}

			if (null != itemT.getTopicid()) {
				criteria.andTopicidEqualTo(itemT.getTopicid());
			}

			if (null != itemT.getStatus()) {
				criteria.andStatusEqualTo(itemT.getStatus());
			}

			if (null != itemT.getSvgid()) {
				criteria.andSvgidEqualTo(itemT.getSvgid());
			}

		}
	}

	public void proSearchParam(AppealAttachT attachT,
			AppealAttachTExample.Criteria criteria) {
		if (null != attachT) {
			if (null != attachT.getCorpid()) {
				criteria.andCorpidEqualTo(attachT.getCorpid());
			}
			if (null != attachT.getItemid()) {
				criteria.andItemidEqualTo(attachT.getItemid());
			}
		}
	}

	public void proSearchParam(AppealPushT param,
			AppealPushTExample.Criteria criteria) {
		if (null != param) {
			if (null != param.getItemid()) {
				criteria.andItemidEqualTo(param.getItemid());
			}
			if (null != param.getTopicid()) {
				criteria.andTopicidEqualTo(param.getTopicid());
			}

			if (null != param.getSvgid()) {
				criteria.andSvgidEqualTo(param.getSvgid());
			}

			if (null != param.getTasktype()) {
				criteria.andTasktypeEqualTo(param.getTasktype());
			}
		}
	}

	@Override
	public List<StatistGovNum> statistSvgAppealNum() {
		return appealItemTMapper.selectStatBySvg();
	}

}

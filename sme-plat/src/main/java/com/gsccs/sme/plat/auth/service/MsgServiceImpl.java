package com.gsccs.sme.plat.auth.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.auth.dao.MsgMapper;
import com.gsccs.sme.plat.auth.model.MsgExample;
import com.gsccs.sme.plat.auth.model.MsgT;

/**
 * 平台消息
 * @author x.d zhang
 *
 */
@Service
public class MsgServiceImpl implements MsgService {

	@Autowired
	private MsgMapper msgMapper;

	public void createMsg(MsgT param) {
		if (null != param) {
			String id = UUID.randomUUID().toString();
			param.setId(id);
			param.setAddtime(new Date());
			param.setStatus("0");
			msgMapper.insert(param);
		}
	}

	public void updateMsg(MsgT param) {
		if (null != param) {
			msgMapper.updateByPrimaryKeySelective(param);
		}
	}

	public void deleteMsg(String appId) {
		msgMapper.deleteByPrimaryKey(appId);
	}

	@Override
	public MsgT findById(String id) {
		return msgMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<MsgT> find(MsgT param, String order, int currPage, int pageSize) {
		MsgExample example = new MsgExample();
		MsgExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return msgMapper.selectPageByExample(example);
	}

	@Override
	public Integer count(MsgT param) {
		MsgExample example = new MsgExample();
		MsgExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		return msgMapper.countByExample(example);
	}

	public void proSearchParam(MsgT param, MsgExample.Criteria criteria) {
		if (null != param) {
			if (StringUtils.isNotEmpty(param.getTitle())) {
				criteria.andTitleLike("%" + param.getTitle() + "%");
			}

			if (null != param.getReceiver()){
				criteria.andReceiverEqualTo(param.getReceiver());
			}
			
			if (null != param.getSender()){
				criteria.andSenderEqualTo(param.getSender());
			}
		}
	}
}

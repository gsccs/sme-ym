package com.gsccs.sme.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.DeclareItem;
import com.gsccs.sme.api.domain.DeclareTopic;
import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.DeclareServiceI;
import com.gsccs.sme.plat.svg.model.DeclareAttachT;
import com.gsccs.sme.plat.svg.model.DeclareItemT;
import com.gsccs.sme.plat.svg.model.DeclareTopicT;
import com.gsccs.sme.plat.svg.service.DeclareService;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

/**
 * 项目申报服务接口
 * 
 * @author x.d zhang
 * 
 */
public class DeclareServiceAPI implements DeclareServiceI {

	@Autowired
	private DeclareService declareService;

	@Override
	public DeclareTopic getTopic(Long id) throws ApiException {
		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		DeclareTopicT topicT = declareService.findTopicById(id);
		if (null != topicT) {
			DeclareTopic topic = new DeclareTopic();
			try {
				BeanUtils.copyProperties(topic, topicT);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			DeclareAttachT param = new DeclareAttachT();
			param.setTopicid(id);
			param.setItemid(null); // 只获取项目主题附件
			List<DeclareAttachT> attachTs = declareService.find(param);
			if (null != attachTs && attachTs.size() > 0) {
				List<Attach> attachs = new ArrayList<>();
				for (DeclareAttachT attachT : attachTs) {
					Attach attach = new Attach();
					attach.setId(attachT.getId().toString());
					attach.setFilename(attachT.getFilename());
					attach.setFilepath(attachT.getFilepath());
					attach.setFiletype(attachT.getFiletype());
					attachs.add(attach);
				}
				topic.setAttachs(attachs);
			}
			return topic;
		}
		return null;
	}

	@Override
	public DeclareItem getItem(Long id) throws ApiException {
		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		DeclareItemT itemT = declareService.findItemById(id);
		if (null != itemT) {
			DeclareItem item = new DeclareItem();
			try {
				BeanUtils.copyProperties(item, itemT);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			return item;
		}
		return null;
	}

	@Override
	public void addDeclareItem(DeclareItem sitem) throws ApiException {
		if (null == sitem) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		try {
			DeclareItemT itemT = new DeclareItemT();
			BeanUtils.copyProperties(itemT, sitem);
			declareService.insertItem(itemT);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Datagrid queryItemList(DeclareItem param, String order, int page,
			int pagesize) throws ApiException {
		Datagrid datagrid = new Datagrid();
		List<DeclareItem> list = null;
		DeclareItemT itemT = null;
		if (null != param) {
			itemT = new DeclareItemT();
			BeanUtilsEx.copyProperties(itemT, param);
		}

		List<DeclareItemT> topicTs = declareService.findItemByCorp(itemT,
				order, page, pagesize);
		int total = declareService.count(itemT);
		if (null != topicTs && topicTs.size() > 0) {
			list = new ArrayList<DeclareItem>();
			for (DeclareItemT sitemT : topicTs) {
				DeclareItem sitem_ = new DeclareItem();
				BeanUtilsEx.copyProperties(sitem_, sitemT);
				list.add(sitem_);
			}
		}
		datagrid.setRows(list);
		datagrid.setTotal(Long.valueOf(total));
		return datagrid;
	}

	@Override
	public Datagrid queryTopicList(DeclareTopic param, String order, int page,
			int pagesize) throws ApiException {
		Datagrid datagrid = new Datagrid();
		List<DeclareTopic> list = null;
		DeclareTopicT itemT = null;
		if (null != param) {
			itemT = new DeclareTopicT();
			BeanUtilsEx.copyProperties(itemT, param);
		}

		List<DeclareTopicT> topicTs = declareService.find(itemT, order, page,
				pagesize);
		int total = declareService.count(itemT);
		if (null != topicTs && topicTs.size() > 0) {
			list = new ArrayList<DeclareTopic>();
			for (DeclareTopicT topicT : topicTs) {
				DeclareTopic declareTopic = new DeclareTopic();
				BeanUtilsEx.copyProperties(declareTopic, topicT);
				list.add(declareTopic);
			}
		}
		datagrid.setRows(list);
		datagrid.setTotal(Long.valueOf(total));
		return datagrid;
	}

	@Override
	public List<Attach> queryAttachList(Attach param) throws ApiException {
		List<Attach> list = null;
		DeclareAttachT itemT = null;
		if (null != param) {
			itemT = new DeclareAttachT();
			BeanUtilsEx.copyProperties(itemT, param);
		}

		List<DeclareAttachT> attachTs = declareService.find(itemT);
		if (null != attachTs && attachTs.size() > 0) {
			list = new ArrayList<Attach>();
			for (DeclareAttachT attachT : attachTs) {
				Attach attach = new Attach();
				attach.setId(attachT.getId().toString());
				attach.setFilename(attachT.getFilename());
				attach.setFilepath(attachT.getFilepath());
				attach.setFiletype(attachT.getFiletype());
				list.add(attach);
			}
		}
		return list;
	}

	@Override
	public void deleteTopics(List<Long> ids) throws ApiException {
		if (null != ids && ids.size() > 0) {
			declareService.delTopics(ids);
		}
	}

	@Override
	public void deleteTopics(Long ids) throws ApiException {
		if (null != ids) {
			declareService.delTopics(ids);
		}
	}

	@Override
	public void deleteItems(List<Long> ids) throws ApiException {
		if (null != ids && ids.size() > 0) {
			declareService.delItems(ids);
		}
	}

	@Override
	public void deleteAttachs(List<Long> ids) throws ApiException {
		if (null != ids && ids.size() > 0) {
			declareService.delAttachs(ids);
		}
	}

	@Override
	public void editDeclareItem(DeclareItem sitem) throws ApiException {
		if (null == sitem) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		try {
			DeclareItemT itemT = new DeclareItemT();
			BeanUtils.copyProperties(itemT, sitem);
			declareService.updateItem(itemT);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	public JSONArray queryTraces(Long itemid) throws ApiException {
		if (null == itemid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		return declareService.findItemTraces(itemid);
	}

}

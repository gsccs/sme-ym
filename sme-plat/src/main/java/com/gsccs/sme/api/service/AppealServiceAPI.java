package com.gsccs.sme.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.AppealItem;
import com.gsccs.sme.api.domain.AppealTopic;
import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AppealServiceI;
import com.gsccs.sme.plat.svg.model.AppealAttachT;
import com.gsccs.sme.plat.svg.model.AppealItemT;
import com.gsccs.sme.plat.svg.model.AppealTopicT;
import com.gsccs.sme.plat.svg.model.AppealTraceT;
import com.gsccs.sme.plat.svg.service.AppealService;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

/**
 * 行政诉求服务接口
 * 
 * @author x.d zhang
 * 
 */
public class AppealServiceAPI implements AppealServiceI {

	@Autowired
	private AppealService appealService;

	@Override
	public AppealTopic getTopic(Long id) throws ApiException {
		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		AppealTopicT topicT = appealService.findTopicById(id);
		if (null != topicT) {
			AppealTopic topic = new AppealTopic();
			try {
				BeanUtils.copyProperties(topic, topicT);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			return topic;
		}
		return null;
	}

	@Override
	public AppealItem getItem(Long id) throws ApiException {
		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		AppealItemT itemT = appealService.findItemById(id);
		if (null != itemT) {
			AppealItem item = new AppealItem();
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
	public void addAppealItem(AppealItem sitem) throws ApiException {
		if (null == sitem) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		try {
			AppealItemT itemT = new AppealItemT();
			BeanUtils.copyProperties(itemT, sitem);
			appealService.insertItem(itemT);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Datagrid queryItemList(AppealItem param, String order, int page,
			int pagesize) throws ApiException {
		Datagrid datagrid = new Datagrid();
		List<AppealItem> list = null;
		AppealItemT itemT = null;
		if (null != param) {
			itemT = new AppealItemT();
			BeanUtilsEx.copyProperties(itemT, param);
		}

		List<AppealItemT> appealItemTs = appealService.find(itemT, order, page,
				pagesize);
		int total = appealService.count(itemT);
		if (null != appealItemTs && appealItemTs.size() > 0) {
			list = new ArrayList<AppealItem>();
			for (AppealItemT sitemT : appealItemTs) {
				AppealItem sitem_ = new AppealItem();
				BeanUtilsEx.copyProperties(sitem_, sitemT);
				list.add(sitem_);
			}
		}
		datagrid.setRows(list);
		datagrid.setTotal(Long.valueOf(total));
		return datagrid;
	}

	@Override
	public Datagrid queryTopicList(AppealTopic param, String order, int page,
			int pagesize) throws ApiException {
		Datagrid datagrid = new Datagrid();
		List<AppealTopic> list = null;
		AppealTopicT itemT = null;
		if (null != param) {
			itemT = new AppealTopicT();
			BeanUtilsEx.copyProperties(itemT, param);
		}

		List<AppealTopicT> sitemTs = appealService.find(itemT, order, page,
				pagesize);
		int total = appealService.count(itemT);
		if (null != sitemTs && sitemTs.size() > 0) {
			list = new ArrayList<AppealTopic>();
			for (AppealTopicT sitemT : sitemTs) {
				AppealTopic sitem_ = new AppealTopic();
				BeanUtilsEx.copyProperties(sitem_, sitemT);
				list.add(sitem_);
			}
		}
		datagrid.setRows(list);
		datagrid.setTotal(Long.valueOf(total));
		return datagrid;
	}

	@Override
	public List<Attach> queryAttachList(Attach param) throws ApiException {
		List<Attach> list = null;
		AppealAttachT appealAttachT = null;
		if (null != param) {
			appealAttachT = new AppealAttachT();
			BeanUtilsEx.copyProperties(appealAttachT, param);
		}

		List<AppealAttachT> attachTs = appealService.find(appealAttachT);
		if (null != attachTs && attachTs.size() > 0) {
			list = new ArrayList<Attach>();
			for (AppealAttachT attachT : attachTs) {
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
			appealService.delTopics(ids);
		}
	}

	@Override
	public void deleteTopics(Long id) throws ApiException {
		if (null != id) {
			List<Long> ids = new ArrayList<>();
			ids.add(id);
			appealService.delTopics(ids);
		}
	}

	@Override
	public void deleteItems(List<Long> ids) throws ApiException {
		if (null != ids && ids.size() > 0) {
			appealService.delItems(ids);
		}

	}

	@Override
	public void deleteAttachs(List<Long> ids) throws ApiException {
		if (null != ids && ids.size() > 0) {
			appealService.delAttachs(ids);
		}
	}

	@Override
	public void editAppealItem(AppealItem sitem) throws ApiException {
		if (null == sitem) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		try {
			AppealItemT itemT = new AppealItemT();
			BeanUtils.copyProperties(itemT, sitem);
			appealService.updateItem(itemT);
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
		List<AppealTraceT> list = appealService.find(itemid);
		if (null != list) {
			return (JSONArray) JSONArray.toJSON(list);
		}
		return new JSONArray();
	}

	@Override
	public Integer countTopic(AppealTopic param) {
		AppealTopicT itemT = null;
		if (null != param) {
			itemT = new AppealTopicT();
			BeanUtilsEx.copyProperties(itemT, param);
		}
		return appealService.count(itemT);
	}

	@Override
	public Integer countItem(AppealItem param) {
		AppealItemT itemT = null;
		if (null != param) {
			itemT = new AppealItemT();
			BeanUtilsEx.copyProperties(itemT, param);
		}
		return appealService.count(itemT);
	}

}

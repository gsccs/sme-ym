package com.gsccs.sme.plat.svg.service;

import java.util.List;

import com.gsccs.sme.api.domain.StatistGovNum;
import com.gsccs.sme.api.domain.StatistGroup;
import com.gsccs.sme.plat.svg.model.AppealAttachT;
import com.gsccs.sme.plat.svg.model.AppealItemT;
import com.gsccs.sme.plat.svg.model.AppealPushT;
import com.gsccs.sme.plat.svg.model.AppealTopicT;
import com.gsccs.sme.plat.svg.model.AppealTraceT;

/**
 * 行政诉求业务
 * 
 * @author x.d zhang
 * 
 */
public interface AppealService {

	public void insertTopic(AppealTopicT topicT);

	public void updateTopic(AppealTopicT topicT);

	public void delTopics(List<Long> ids);

	public AppealTopicT findTopicById(Long id);
	
	public void insertItem(AppealItemT itemT);

	public void updateItem(AppealItemT itemT);

	public void delItems(List<Long> ids);

	public void delAttachs(List<Long> ids);

	public AppealItemT findItemById(Long id);

	/**
	 * 分页查询
	 */
	public List<AppealItemT> find(AppealItemT itemT, String order,
			int currPage, int pageSize);

	public int count(AppealItemT itemT);

	/**
	 * 分页查询
	 */
	public List<AppealTopicT> find(AppealTopicT topicT, String order,
			int currPage, int pageSize);

	public int count(AppealTopicT topicT);

	public List<AppealAttachT> find(AppealAttachT param);

	public List<AppealTraceT> find(Long itemid);

	public void insertTrace(AppealTraceT traceT);
	
	public void insertAppealPush(AppealPushT pushT);

	public AppealPushT findAppealPushById(Long id);

	public List<AppealPushT> find(AppealPushT param);
	
	List<StatistGovNum> statistSvgAppealNum();
}

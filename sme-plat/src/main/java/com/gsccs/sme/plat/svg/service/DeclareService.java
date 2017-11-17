package com.gsccs.sme.plat.svg.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.sme.plat.svg.model.DeclareAttachT;
import com.gsccs.sme.plat.svg.model.DeclareItemT;
import com.gsccs.sme.plat.svg.model.DeclareTopicT;
import com.gsccs.sme.plat.svg.model.DeclareTraceT;

public interface DeclareService {

	public Long insertTopic(DeclareTopicT topicT);

	public void updateTopic(DeclareTopicT topicT);

	public void delTopics(List<Long> ids);
	
	public void delTopics(Long ids);

	public DeclareTopicT findTopicById(Long id);

	public void insertItem(DeclareItemT itemT);

	public void updateItem(DeclareItemT itemT);

	public void delItems(List<Long> ids);
	
	public void insertAttach(List<DeclareAttachT> attachTs) ;
	
	public void delAttachs(List<Long> ids);
	
	public void delAttachs(Long id);

	public DeclareItemT findItemById(Long id);

	/**
	 * 分页查询
	 */
	public List<DeclareTopicT> find(DeclareTopicT topicT, String order,
			int currPage, int pageSize);

	public int count(DeclareTopicT topicT);

	/**
	 * 分页查询
	 */
	public List<DeclareItemT> findItemByCorp(DeclareItemT itemT, String order,
			int currPage, int pageSize);
	public List<DeclareItemT> findItemBySvg(DeclareItemT itemT, String order,
			int currPage, int pageSize);
	public List<DeclareItemT> findCorpDeclares(DeclareItemT itemT);

	public int count(DeclareItemT itemT);

	public List<DeclareAttachT> find(DeclareAttachT param);

	public List<DeclareTraceT> findItemTraces(Long itemid, String order,
			int currPage, int pageSize);
	public JSONArray findItemTraces(Long itemid);
}

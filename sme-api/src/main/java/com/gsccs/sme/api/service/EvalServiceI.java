package com.gsccs.sme.api.service;

import java.util.List;

import com.gsccs.sme.api.domain.Sitemeval;
import com.gsccs.sme.api.domain.shop.EvalGoods;
import com.gsccs.sme.api.domain.shop.EvalItem;
import com.gsccs.sme.api.domain.shop.EvalOrder;
import com.gsccs.sme.api.exception.ApiException;

/**
 * 评价服务接口
 * 
 * @author x.d zhang
 * 
 */
public interface EvalServiceI {

	/**
	 * 增加评价描述
	 * 
	 * @param detail
	 */
	public void addEvalRemark(Long siteid, EvalGoods detail);

	/**
	 * 增加评价打分
	 * 
	 * @param scores
	 */
	public void addEvalScores(Long siteid, List<EvalOrder> scoreList,
			EvalGoods detail) throws ApiException;

	/**
	 * 删除评分项目
	 * 
	 * @param id
	 */
	public void delEvalType(Long id);

	/**
	 * 添加打分项
	 * 
	 * @param evalItem
	 */
	public Long addEvalItem(EvalItem evalItem);

	/**
	 * 编辑打分项
	 * 
	 * @param evalItem
	 */
	public void editEvalItem(EvalItem evalItem);

	/**
	 * 删除打分项
	 * 
	 * @param id
	 */
	public void delEvalItem(Long id);

	/**
	 * 根据条件查询打分项
	 * 
	 * @param evalItem
	 * @return
	 */
	public List<EvalItem> getEvalItems(EvalItem evalItem);

}

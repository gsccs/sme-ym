package com.gsccs.sme.plat.svg.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.api.domain.StatistGroup;
import com.gsccs.sme.plat.svg.dao.GclassTMapper;
import com.gsccs.sme.plat.svg.model.GclassT;
import com.gsccs.sme.plat.svg.model.GclassTExample;

/**
 * 行政事项分类业务
 * 
 * @创建时间：2015.4.1
 */
@Service(value = "aclassService")
public class GclassServiceImpl implements GclassService {

	@Autowired
	private GclassTMapper aclassTMapper;

	/**
	 * 根据id查询
	 */
	@Override
	public GclassT findById(Long id) {
		return aclassTMapper.selectByPrimaryKey(id);
	}

	/**
	 * 添加卖家账号
	 */
	@Override
	public void insert(GclassT sclassT) {
		if (null != sclassT) {
			aclassTMapper.insert(sclassT);
		}
	}

	/**
	 * 修改卖家账号
	 */
	@Override
	public void update(GclassT sclassT) {
		aclassTMapper.updateByPrimaryKey(sclassT);
	}

	@Override
	public int count(GclassT sclassT) {
		GclassTExample example = new GclassTExample();
		GclassTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sclassT, criteria);
		return aclassTMapper.countByExample(example);
	}

	@Override
	public List<GclassT> find(GclassT sclassT,String orderstr, int page,
			int pagesize) {
		GclassTExample example = new GclassTExample();
		GclassTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sclassT, criteria);
		example.setCurrPage(page);
		example.setPageSize(pagesize);
		if (StringUtils.isNotEmpty(orderstr)){
			example.setOrderByClause(orderstr);
		}else{
			example.setOrderByClause("indexnum desc");
		}
		return aclassTMapper.selectByPageExample(example);
	}
	
	@Override
	public List<GclassT> find(GclassT sclassT) {
		GclassTExample example = new GclassTExample();
		GclassTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sclassT, criteria);
		example.setOrderByClause("indexnum desc");
		return aclassTMapper.selectByExample(example);
	}

	@Override
	public void delSclass(Long id) {
		aclassTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<GclassT> findSubList(Long parid) {
		if (null != parid){
			GclassT sclassT = new GclassT();
			sclassT.setParid(parid);
			GclassTExample example = new GclassTExample();
			GclassTExample.Criteria criteria = example.createCriteria();
			proSearchParam(sclassT, criteria);
			example.setOrderByClause("indexnum desc");
			return aclassTMapper.selectByExample(example);
		}
		return null;
	}

	public void proSearchParam(GclassT sclassT, GclassTExample.Criteria criteria) {
		if (null != sclassT) {
			if (StringUtils.isNotEmpty(sclassT.getTitle())) {
				criteria.andTitleLike("%" + sclassT.getTitle() + "%");
			}
			if (null != sclassT.getParid()){
				criteria.andParidEqualTo(sclassT.getParid());
			}
		}
	}

	@Override
	public List<StatistGroup> statistAppealTopicNum() {
		return aclassTMapper.selectTopicNumGroup();
	}

	
}

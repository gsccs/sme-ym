package com.gsccs.sme.plat.svg.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.api.domain.StatistGroup;
import com.gsccs.sme.plat.svg.dao.SclassTMapper;
import com.gsccs.sme.plat.svg.model.SclassT;
import com.gsccs.sme.plat.svg.model.SclassTExample;

/**
 * 服务分类业务
 * 
 * @创建时间：2015.4.1
 */
@Service(value = "sclassService")
public class SclassServiceImpl implements SclassService {

	@Autowired
	private SclassTMapper sclassTMapper;

	/**
	 * 根据id查询
	 */
	@Override
	public SclassT findById(Long id) {
		return sclassTMapper.selectByPrimaryKey(id);
	}

	/**
	 * 添加卖家账号
	 */
	@Override
	public void insert(SclassT sclassT) {
		if (null != sclassT) {
			sclassTMapper.insert(sclassT);
		}
	}

	/**
	 * 修改卖家账号
	 */
	@Override
	public void update(SclassT sclassT) {
		sclassTMapper.updateByPrimaryKey(sclassT);
	}

	@Override
	public int count(SclassT sclassT) {
		SclassTExample example = new SclassTExample();
		SclassTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sclassT, criteria);
		return sclassTMapper.countByExample(example);
	}

	@Override
	public List<SclassT> find(SclassT sclassT,String orderstr, int page,
			int pagesize) {
		SclassTExample example = new SclassTExample();
		SclassTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sclassT, criteria);
		example.setCurrPage(page);
		example.setPageSize(pagesize);
		return sclassTMapper.selectByPageExample(example);
	}
	
	@Override
	public List<SclassT> find(SclassT sclassT) {
		SclassTExample example = new SclassTExample();
		SclassTExample.Criteria criteria = example.createCriteria();
		proSearchParam(sclassT, criteria);
		return sclassTMapper.selectByExample(example);
	}

	@Override
	public void delSclass(Long id) {
		sclassTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<SclassT> findSubList(Long parid) {
		if (null != parid){
			SclassT sclassT = new SclassT();
			sclassT.setParid(parid);
			SclassTExample example = new SclassTExample();
			SclassTExample.Criteria criteria = example.createCriteria();
			proSearchParam(sclassT, criteria);
			return sclassTMapper.selectByExample(example);
		}
		return null;
	}

	public void proSearchParam(SclassT sclassT, SclassTExample.Criteria criteria) {
		if (null != sclassT) {
			if (StringUtils.isNotEmpty(sclassT.getTitle())) {
				criteria.andTitleLike("%" + sclassT.getTitle() + "%");
			}
			if (null != sclassT.getParid()){
				criteria.andParidEqualTo(sclassT.getParid());
			}
			
			if (StringUtils.isNotEmpty(sclassT.getTypeid())){
				criteria.andTypeidEqualTo(sclassT.getTypeid());
			}
		}
	}

	@Override
	public List<SclassT> findByParids(String parids) {
		if (null != parids){
			SclassT sclassT = new SclassT();
			sclassT.setParids(parids);
			SclassTExample example = new SclassTExample();
			SclassTExample.Criteria criteria = example.createCriteria();
			proSearchParam(sclassT, criteria);
			return sclassTMapper.selectByExample(example);
		}
		return null;
	}
	
	
	@Override
	public List<StatistGroup> statistAppealTopicNum() {
		return sclassTMapper.selectTopicNumGroup();
	}

}

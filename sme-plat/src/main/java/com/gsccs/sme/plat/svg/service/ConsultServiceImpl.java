package com.gsccs.sme.plat.svg.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.corp.Consult;
import com.gsccs.sme.plat.svg.dao.ConsultMapper;
import com.gsccs.sme.plat.svg.model.ConsultExample;

/**
 * 服务咨询业务
 * 
 * @author x.d zhang
 * 
 */
@Service
public class ConsultServiceImpl implements ConsultService {

	@Autowired
	private ConsultMapper consultMapper;

	/**
	 * 根据id查询
	 */
	@Override
	public Consult findById(Long id) {
		Consult consult = consultMapper.selectByPrimaryKey(id);
		if (null != consult){
			consult.setReplyList(findByParId(consult.getId()));
		}
		return consult;
	}

	/**
	 * 添加咨询记录
	 */
	@Override
	public void insert(Consult consiltT) {
		if (null != consiltT) {
			consiltT.setAddtime(new Date());
			consiltT.setStatus("0");
			consultMapper.insert(consiltT);
		}
	}

	/**
	 * 修改咨询记录
	 */
	@Override
	public void update(Consult consiltT) {
		consultMapper.updateByPrimaryKeySelective(consiltT);
	}

	@Override
	public List<Consult> find(Consult param, String order, int currPage,
			int pageSize) {
		ConsultExample example = new ConsultExample();
		ConsultExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		//criteria.andParidIsNull();
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		List<Consult> consults = consultMapper.selectPageByExample(example);
		if (null != consults && consults.size()>0){
			for(Consult consult:consults){
				consult.setReplyList(findByParId(consult.getId()));
			}
		}
		return consults;
	}

	@Override
	public int count(Consult consiltT) {
		ConsultExample example = new ConsultExample();
		ConsultExample.Criteria criteria = example.createCriteria();
		proSearchParam(consiltT, criteria);
		return consultMapper.countByExample(example);
	}

	
	public void proSearchParam(Consult consiltT,
			ConsultExample.Criteria criteria) {
		if (null != consiltT) {

			if (null != consiltT.getItemid()) {
				criteria.andItemidEqualTo(consiltT.getItemid());
			}

			if (null != consiltT.getCorpid()) {
				criteria.andCorpidEqualTo(consiltT.getCorpid());
			}

			if (null != consiltT.getSvgid()) {
				criteria.andSvgidEqualTo(consiltT.getSvgid());
			}

			if (null != consiltT.getParid()) {
				criteria.andParidEqualTo(consiltT.getParid());
				System.out.println("parid:"+consiltT.getParid());
			} else {
				criteria.andParidIsNull();
			}

			if (StringUtils.isNotEmpty(consiltT.getStatus())) {
				criteria.andStatusEqualTo(consiltT.getStatus());
			}

			if (null != consiltT.getScode()) {
				criteria.andScodeEqualTo(consiltT.getScode());
			}

			if (StringUtils.isNotEmpty(consiltT.getIsshow())) {
				criteria.andIsshowEqualTo(consiltT.getIsshow());
			}
		} else {
			criteria.andParidIsNull();
		}
	}

	@Override
	public void delete(Long id) {
		Consult consiltT = consultMapper.selectByPrimaryKey(id);
		if (null != consiltT) {
			ConsultExample example = new ConsultExample();
			ConsultExample.Criteria c = example.createCriteria();
			c.andParidEqualTo(consiltT.getId());
			consultMapper.deleteByExample(example);
		}
		consultMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Datagrid datagrid(Consult consiltT, String order, int currPage,
			int pageSize) {
		Datagrid datagrid = new Datagrid();
		List<Consult> list = find(consiltT, order, currPage, pageSize);
		int count = count(consiltT);
		datagrid.setRows(list);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	@Override
	public List<Consult> findReplyByCorpid(Long corpid, String order,
			int currPage, int pageSize) {
		if (null != corpid) {
			ConsultExample example = new ConsultExample();
			ConsultExample.Criteria criteria = example.createCriteria();
			criteria.andCorpidEqualTo(corpid);
			if (order != null && order.trim().length() > 0) {
				example.setOrderByClause(order);
			}
			example.setCurrPage(currPage);
			example.setPageSize(pageSize);
			return consultMapper.selectReplyByCorp(example);
		}
		return null;
	}
	
	
	public List<Consult> findByParId(Long parid){
		ConsultExample example = new ConsultExample();
		ConsultExample.Criteria criteria = example.createCriteria();
		criteria.andParidEqualTo(parid);
		example.setCurrPage(1);
		example.setPageSize(Integer.MAX_VALUE);
		return consultMapper.selectPageByExample(example);
		
	}

}

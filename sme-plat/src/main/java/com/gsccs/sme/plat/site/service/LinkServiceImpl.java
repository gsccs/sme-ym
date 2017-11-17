package com.gsccs.sme.plat.site.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.site.dao.LinkMapper;
import com.gsccs.sme.plat.site.model.LinkExample;
import com.gsccs.sme.plat.site.model.LinkExample.Criteria;
import com.gsccs.sme.plat.site.model.LinkT;

/**
 * 友情链接业务
 * 
 * @创建时间：2015.4.1
 */
@Service
public class LinkServiceImpl implements LinkService {

	@Autowired
	private LinkMapper linkMapper;

	/**
	 * 添加
	 * 
	 * @param link
	 * @return
	 */
	public String add(LinkT link) {
		link.setId(UUID.randomUUID().toString());
		link.setIsok("1");
		linkMapper.insert(link);
		return link.getId();
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public LinkT findById(String id) {
		return linkMapper.selectByPrimaryKey(id);
	}

	/**
	 * 检验是否已存在页面标识
	 * 
	 * @param siteid
	 * @param type
	 * @param isClass
	 * @return
	 */
	public boolean hasPagemark(String siteid, String type, boolean isClass,
			String pagemark) {
		LinkExample example = new LinkExample();
		Criteria criteria = example.createCriteria();
		criteria.andSiteEqualTo(siteid);
		criteria.andTypeEqualTo(type);
		criteria.andPagemarkEqualTo(pagemark);
		if (isClass) {
			criteria.andSql(" (parid is null or parid = '') ");
		} else {
			criteria.andSql(" (parid is not null and parid != '') ");
		}
		return linkMapper.countByExample(example) > 0;
	}

	/**
	 * 分页查询
	 */
	public List<LinkT> find(LinkT link, String order, int currPage, int pageSize) {
		LinkExample example = new LinkExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(link, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		List<LinkT> listLink= linkMapper.selectPageByExample(example);
		for(LinkT linkT:listLink){
			if(StringUtils.isNotEmpty(linkT.getParid())){
			linkT.setTypestr(linkMapper.selectByPrimaryKey(linkT.getParid()).getName());
			}
		}
		return  listLink;
	}

	/**
	 * 分页查询
	 */
	public List<LinkT> findAll(LinkT link, String order) {
		LinkExample example = new LinkExample();
		Criteria criteria = example.createCriteria();
		proSearchParamAll(link, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		return linkMapper.selectByExample(example);
	}

	/**
	 * 统计
	 * 
	 * @param info
	 * @return
	 */
	public int count(LinkT link) {
		LinkExample example = new LinkExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(link, criteria);
		return linkMapper.countByExample(example);
	}
	
	//获取分类列表
	public void proSearchParamAll(LinkT link, Criteria criteria) {
				criteria.andParidIsNull();
	}

	/**
	 * 处理查询条件
	 * 
	 * @param info
	 * @param criteria
	 */
	public void proSearchParam(LinkT link, Criteria criteria) {
		if (link != null) {
			if (link.getName() != null && link.getName().trim().length() > 0) {
				criteria.andNameLike("%" + link.getName().trim() + "%");
			}
			if (link.getPagemark() != null
					&& link.getPagemark().trim().length() > 0) {
				criteria.andPagemarkLike("%" + link.getPagemark().trim() + "%");
			}
			if ("1".equals(link.getIsclass())) {
				criteria.andSql(" (parid is null or parid = '') ");
			} else {
				criteria.andSql(" (parid is not null and parid != '') ");
			}
			/*
			 * if (link.getClassName()!=null &&
			 * link.getClassName().trim().length()>0) { criteria.andSql(
			 * " (parid in (select id from cms_link where name like '%"
			 * +link.getClassName()+"%')) ");; }
			 */
			if (link.getIsok() != null && link.getIsok().trim().length() > 0) {
				criteria.andIsokEqualTo(link.getIsok());
			}
			if (link.getParid() != null && link.getParid().trim().length() > 0) {
				criteria.andParidEqualTo(link.getParid());
			}
			if (link.getType() != null && link.getType().trim().length() > 0) {
				criteria.andTypeEqualTo(link.getType());
			}
			
		}
	}

	/**
	 * 删除分类
	 * 
	 * @param id
	 */
	public void delClass(String id) {
		if (id != null && id.trim().length() > 0) {
			// 先删除子链接
			LinkExample example = new LinkExample();
			Criteria criteria = example.createCriteria();
			criteria.andParidEqualTo(id);
			linkMapper.deleteByExample(example);
			// 删除此分类
			linkMapper.deleteByPrimaryKey(id);
		}
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void del(String id) {
		if (id != null && id.trim().length() > 0) {
			// 删除此分类
			linkMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public void update(LinkT link) {
		if (null != link) {
			linkMapper.updateByPrimaryKey(link);
		}
	}

}

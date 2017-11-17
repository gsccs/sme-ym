package com.gsccs.sme.plat.site.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.bass.service.SolrSchema;
import com.gsccs.sme.plat.bass.service.SolrService;
import com.gsccs.sme.plat.site.dao.ChanelTMapper;
import com.gsccs.sme.plat.site.dao.ContentAttachTMapper;
import com.gsccs.sme.plat.site.dao.ContentMapper;
import com.gsccs.sme.plat.site.model.ChanelT;
import com.gsccs.sme.plat.site.model.Content;
import com.gsccs.sme.plat.site.model.ContentAttachT;
import com.gsccs.sme.plat.site.model.ContentAttachTExample;
import com.gsccs.sme.plat.site.model.ContentExample;

@Service("contentService")
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private ContentMapper contentMapper;
	@Autowired
	private ContentAttachTMapper contentAttachTMapper;
	@Autowired
	private ChanelTMapper chanelTMapper;
	@Autowired
	private SolrService solrService;

	@Override
	public void addContent(Content content) {
		if (null != content) {
			content.setAddtime(new Date());
			content.setStatus(content.getStatus()==null?"0":content.getStatus());
			content.setIsrelease("0");
			contentMapper.insert(content);
			indexContent(content);
		}
	}

	@Override
	public Content getContent(Long id) {
		return contentMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delContent(Long id) {
		contentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Content> find(Content content) {
		ContentExample example = new ContentExample();
		ContentExample.Criteria criteria = example.createCriteria();
		proSearchParam(content, criteria);
		return contentMapper.selectByExample(example);
	}

	@Override
	public List<Content> find(Content content, String order, int currPage,
			int pageSize) {
		ContentExample example = new ContentExample();
		ContentExample.Criteria criteria = example.createCriteria();
		proSearchParam(content, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		
		if(StringUtils.isEmpty(order)){
			example.setOrderByClause("addtime desc");
		}else{
			example.setOrderByClause(order);
		}
		return contentMapper.selectPageByExample(example);
	}

	public void proSearchParam(Content content, ContentExample.Criteria criteria) {
		if (null != content) {
			if (StringUtils.isNotEmpty(content.getTitle())) {
				criteria.andTitleLike("%" + content.getTitle() + "%");
			}
			if (null != content.getChannelid()) {
				criteria.andChannelEqualTo(content.getChannelid());
			}

			if (null != content.getSvgid()){
				criteria.andSvgidEqualTo(content.getSvgid());
			}
			if (StringUtils.isNotEmpty(content.getStatus())) {
				criteria.andStatusEqualTo(content.getStatus());
			}
			if (StringUtils.isNotEmpty(content.getIsrelease())) {
				criteria.andReleaseEqualTo(content.getIsrelease());
			}
			
			if (StringUtils.isNotEmpty(content.getIshot())) {
				criteria.andIshotEqualTo(content.getIshot());
			}
			
			if (StringUtils.isNotEmpty(content.getIstop())) {
				criteria.andIstopEqualTo(content.getIstop());
			}
			
			if (null != content.getChannelids() && content.getChannelids().size()>0) {
				criteria.andChannelIn(content.getChannelids());
			}
		}
	}

	@Override
	public int count(Content content) {
		ContentExample example = new ContentExample();
		ContentExample.Criteria criteria = example.createCriteria();
		proSearchParam(content, criteria);
		return contentMapper.countByExample(example);
	}

	@Override
	public void update(Content content) {
		if (null != content) {
			contentMapper.updateByPrimaryKeySelective(content);
			indexContent(content);
		}
	}
	
	@Override
	public void addAttach(ContentAttachT attachT) {
		if (null != attachT) {
			contentAttachTMapper.insert(attachT);
		}
	}

	@Override
	public void delAttachs(List<Long> ids) {
		if (null != ids && ids.size() > 0) {
			ContentAttachTExample example = new ContentAttachTExample();
			ContentAttachTExample.Criteria c = example.createCriteria();
			c.andIdIn(ids);
			contentAttachTMapper.deleteByExample(example);
		}
	}

	@Override
	public List<ContentAttachT> findAttachs(Long infoid) {
		if (null != infoid) {
			ContentAttachTExample example = new ContentAttachTExample();
			ContentAttachTExample.Criteria c = example.createCriteria();
			c.andInfoidEqualTo(infoid);
			return contentAttachTMapper.selectByExample(example);
		}
		return null;
	}

	@Override
	public void index() {
		List<Content> list = this.find(null, "", 1, Integer.MAX_VALUE);
		if (null != list){
			List<SolrSchema> schemas = new ArrayList<>();
			for(Content content :list){
				SolrSchema schema = new SolrSchema();
				schema.setId("1_"+content.getId());
				schema.setSiteid("1");
				schema.setCateid(content.getChannelid()+"");
				schema.setCatestr(content.getChannelid()+"-"+content.getChannelstr());
				schema.setTitle(content.getTitle());
				schema.setUrl("/info-"+content.getId()+".html");
				schemas.add(schema);
			}
			solrService.init();
			solrService.addBeans(schemas);
		}
	}
	
	
	private void indexContent(Content content){
		if (content==null){
			return;
		}
		SolrSchema schema = new SolrSchema();
		schema.setId("1_"+content.getId()+"");
		schema.setSiteid("1");
		schema.setTitle(content.getTitle());
		schema.setCateid(content.getChannelid()+"");
		schema.setUrl("/info-"+content.getId()+".html");
		ChanelT chanelT = chanelTMapper.selectByPrimaryKey(content.getChannelid());
		if (null!=chanelT){
			schema.setCatestr(chanelT.getTitle());
		}
		
		solrService.init();
		List<SolrSchema> list = new ArrayList<>();
		list.add(schema);
		solrService.addBeans(list);
	}
	
}
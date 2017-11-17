package com.gsccs.sme.plat.site.service;

import java.util.List;

import com.gsccs.sme.plat.site.model.Content;
import com.gsccs.sme.plat.site.model.ContentAttachT;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface ContentService {

	public void addContent(Content conten);

	public Content getContent(Long id);

	public void delContent(Long id);

	public List<Content> find(Content content);

	public List<Content> find(Content content, String order, int currPage,
			int pageSize);

	public int count(Content content);

	public void update(Content content);

	public void addAttach(ContentAttachT attachT);
	public void delAttachs(List<Long> ids);
	public List<ContentAttachT> findAttachs(Long infoid);

	public void index();
}

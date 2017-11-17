package com.gsccs.sme.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.APIConst;
import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.site.Info;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.InfoServiceI;
import com.gsccs.sme.plat.site.model.Content;
import com.gsccs.sme.plat.site.model.ContentAttachT;
import com.gsccs.sme.plat.site.service.ContentService;
import com.gsccs.sme.plat.svg.service.SclassService;
import com.gsccs.sme.plat.utils.BeanUtilsEx;

/**
 * 信息服务接口
 * 
 * @author x.d zhang
 * 
 */
public class InfoServiceAPI implements InfoServiceI {

	@Autowired
	private SclassService sclassService;
	@Autowired
	private ContentService contentService;

	@Override
	public Info getInfo(Long id,boolean andAttach) throws ApiException {
		if (null == id) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		
		Content content = contentService.getContent(id);
		if (null != content) {
			Info info = new Info();
			try {
				BeanUtilsEx.copyProperties(info, content);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (andAttach){
				List<ContentAttachT> attachTs = contentService.findAttachs(content
						.getId());
				if (null != attachTs && attachTs.size() > 0) {
					List<Attach> attachs = new ArrayList<>();
					for (ContentAttachT attachT : attachTs) {
						Attach attach = new Attach();
						attach.setId(attachT.getId().toString());
						attach.setFilename(attachT.getFilename());
						attach.setFilepath(attachT.getFilepath());
						attach.setFiletype(attachT.getFiletype());
						attachs.add(attach);
					}
					info.setAttachs(attachs);
				}
			}
			return info;
		}
		return null;
	}

	@Override
	public void addInfo(Info info) throws ApiException {

		if (null == info) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		try {
			Content content = new Content();
			BeanUtils.copyProperties(content, info);
			contentService.addContent(content);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delInfos(List<Long> ids) throws ApiException {
		if (ids != null) {
			for (Long id : ids) {
				contentService.delContent(id);
			}
		}
	}

	@Override
	public void updateInfo(Info info) throws ApiException {
		if (null == info) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		try {
			Content content = new Content();
			BeanUtils.copyProperties(content, info);
			contentService.update(content);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Info> queryInfoList(Info param, String order, int page,
			int pagesize) throws ApiException {
		List<Info> list = null;
		Content content = null;
		if (null != param) {
			content = new Content();
			BeanUtilsEx.copyProperties(content, param);
		}

		List<Content> contents = contentService.find(content, order, page, pagesize);

		if (null != contents && contents.size() > 0) {
			list = new ArrayList<Info>();
			for (Content content_ : contents) {
				Info info_ = new Info();
				BeanUtilsEx.copyProperties(info_, content_);
				list.add(info_);
			}
		}
		return list;
	}

	@Override
	public int count(Info param) throws ApiException {
		if (null != param) {
			Content t = new Content();
			BeanUtilsEx.copyProperties(t, param);
			return contentService.count(t);
		}
		return 0;
	}

	@Override
	public List<Attach> queryAttachs(Long infoid) {
		List<Attach> attachs = null;
		List<ContentAttachT> attachTs = contentService.findAttachs(infoid);
		if (null != attachTs && attachTs.size() > 0) {
			attachs = new ArrayList<>();
			for (ContentAttachT attachT : attachTs) {
				Attach attach = new Attach();
				attach.setId(attachT.getId().toString());
				attach.setFilename(attachT.getFilename());
				attach.setFilepath(attachT.getFilepath());
				attach.setFiletype(attachT.getFiletype());
				attachs.add(attach);
			}
		}
		return attachs;
	}

}

package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsccs.sme.api.domain.site.Link;
import com.gsccs.sme.api.service.LinkServiceI;

import freemarker.core.Environment;
import freemarker.ext.beans.BeanModel;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.SimpleNumber;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 链接分类标签 ;classid 分类id; pagemark 分类页面标识 ; type 类型:1下拉 2图片 3文字
 * 
 * 返回值 linkClass 分类对象 index 索引
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Service("linkClassListTag")
public class LinkClassListTag extends BaseDirective implements
		TemplateDirectiveModel {
	@Resource
	private LinkServiceI linkAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {

		// 获取参数
		String type = getParam(params, "type");
		String pagemark = getParam(params, "pagemark");
		// 是否倒序
		Integer desc = getParamInt(params, "desc", 0);

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				// 查询
				Link link = new Link();
				link.setIsclass("1");
				link.setType(type);
				link.setIsok("1");
				link.setId(getParam(params, "classid"));
				link.setPagemark(pagemark);

				List<Link> linkList = linkAPI.find(link, 1, Integer.MAX_VALUE);
				if (linkList != null && linkList.size() > 0) {
					if (desc.intValue()==1){
						Collections.reverse(linkList);
					}
					for (int i = 0; i < linkList.size(); i++) {
						loopVars[0] = new BeanModel(linkList.get(i),
								new BeansWrapper());
						if (loopVars.length > 1) {
							loopVars[1] = new SimpleNumber(i);
						}
						body.render(env.getOut());
					}
				}
			}
		}
	}

}

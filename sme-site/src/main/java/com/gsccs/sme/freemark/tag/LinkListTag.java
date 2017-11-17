package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.io.Writer;
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
 * 链接标签
 * 
 * 参数 classId 分类id pagemark 页面标识，多个之间使用, classPagemark 分类页面标识，多个之间使用, siteid
 * 站点id type 类型 1 下拉 2 图片 3 文字 num 数量
 * 
 * 返回值 link 链接对象 index 索引
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Service("linkListTag")
public class LinkListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private LinkServiceI linkAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {

		// 获取参数
		String classId = getParam(params, "classId");
		String type = getParam(params, "type");
		int num = getParamInt(params, "num", 1000);

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				// 查询
				Link link = new Link();
				link.setParid(classId);
				link.setType(type);
				link.setIsok("1");

				List<Link> linkList = linkAPI.find(link, 1, num);
				if (linkList != null && linkList.size() > 0) {
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

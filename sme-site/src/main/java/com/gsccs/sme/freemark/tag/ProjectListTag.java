package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.AppealTopic;
import com.gsccs.sme.api.domain.DeclareTopic;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.shop.Project;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AppealServiceI;
import com.gsccs.sme.api.service.DeclareServiceI;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.ProjectServiceI;

import freemarker.core.Environment;
import freemarker.ext.beans.BeanModel;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.SimpleNumber;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 
 * Title: ProjectListTag.java
 * 
 * Description: 项目列表标签
 * 
 * 参数 parid 空字符:所有;"0":一级类目;
 * 
 * 返回值 project 活动对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_project_list siteid="${site.id}" ;declare,index>
 * 
 * </@sme_project_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("projectListTag")
public class ProjectListTag extends BaseDirective implements
		TemplateDirectiveModel {
	@Resource
	private ProjectServiceI projectAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 标题长度
		Integer titlelen = getParamInt(params, "titlelen", 0);
		String dateformat = getParam(params, "dateformat");

		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 排序
		String order = getParam(params, "order", "1");
		// 行业
		String hycode = getParam(params, "hycode");

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Project project = new Project();
				try {
					if (null != hycode) {
						project.setIntype(hycode);
					}
					List<Project> list = projectAPI.queryProjectList(project,
							order, 1, num);

					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							if (null != list.get(i)) {
								if (titlelen > 0) {
									list.get(i).setTitlelen(titlelen);
								}
								
								loopVars[0] = new BeanModel(list.get(i),
										new BeansWrapper());
								if (loopVars.length > 1) {
									loopVars[1] = new SimpleNumber(i);
								}
								body.render(env.getOut());
							}
						}
					}
				} catch (ApiException e) {
					e.printStackTrace();
				} catch (TemplateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

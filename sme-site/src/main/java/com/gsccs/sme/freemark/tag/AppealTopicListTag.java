package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.AppealTopic;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.AppealServiceI;

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
 * Title: AppealListTag.java
 * 
 * Description: 行政事项列表标签
 * 
 * 参数 parid 空字符:所有;"0":一级类目;
 * 
 * 返回值 appeal 活动对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_appeal_list siteid="${site.id}" ;appeal,index>
 * 
 * </@sme_appeal_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("appealTopicListTag")
public class AppealTopicListTag extends BaseDirective implements
		TemplateDirectiveModel {
	@Resource
	private AppealServiceI appealAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 标题长度
		int titlelen = getParamInt(params, "titlelen", 0);
		int remarklen = getParamInt(params, "remarklen", 0);
		// 排序
		String order = getParam(params, "order", "1");
		// 服务机构
		Long svgid = getParamLong(params, "svgid", 0);
		// 服务分类
		Long gcode = getParamLong(params, "gcode", 0);

		// 业务状态
		String status = getParam(params, "status", "1");

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				AppealTopic appealTopic = new AppealTopic();
				try {
					if (null != svgid && svgid != 0) {
						appealTopic.setSvgid(svgid);
					}

					if (null != gcode && gcode > 0) {
						appealTopic.setScode(gcode);
					}

					appealTopic.setStatus(status);
					
					Datagrid datagrid = appealAPI.queryTopicList(appealTopic,
							order, 1, num);

					List<AppealTopic> list = null;
					if (null != datagrid && null != datagrid.getRows()) {
						list = (List<AppealTopic>) datagrid.getRows();
					}
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							if (null != list.get(i)) {
								if (titlelen > 0) {
									list.get(i).setTitlelen(titlelen);
								}
								if (remarklen > 0) {
									list.get(i).setRemarklen(remarklen);
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

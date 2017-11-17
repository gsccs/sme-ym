package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.AppealItem;
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
 * Title: AppealItemListTag.java
 * 
 * Description: 行政记录列表标签
 * 
 * 返回值 appeal 服务记录对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_appealitem_list topicid="${topicid}" svgid="${svgid}"
 * corpid="${corpid}" ;appealItem,index>
 * 
 * </@sme_appealitem_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("appealItemListTag")
public class AppealItemListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private AppealServiceI appealAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 排序
		String order = getParam(params, "order", "1");
		// 服务机构
		Long topicid = getParamLong(params, "topicid", 0);
		// 服务机构
		Long svgid = getParamLong(params, "svgid", 0);
		// 服务机构
		Long corpid = getParamLong(params, "corpid", 0);
		// 业务状态
		String status = getParam(params, "status");

		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				AppealItem item = new AppealItem();
				try {
					if (null != topicid && topicid > 0) {
						item.setTopicid(topicid);
					}
					if (null != svgid && svgid > 0) {
						item.setSvgid(svgid);
					}

					if (null != corpid && corpid > 0) {
						item.setCorpid(corpid);
					}

					if (StringUtils.isNotEmpty(status)){
						item.setStatus(status);
					}

					Datagrid datagrid = appealAPI.queryItemList(item, order, 1,
							num);

					List<AppealItem> list = null;
					if (null != datagrid && null != datagrid.getRows()) {
						list = (List<AppealItem>) datagrid.getRows();
					}
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							if (null != list.get(i)) {
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

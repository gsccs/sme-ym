package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.domain.corp.Consult;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ConsultServiceI;

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
 * Title: ConsultListTag.java
 * 
 * Description: 咨询列表标签
 * 
 * 参数 scode 分类
 * 
 * 返回值 consult 咨询象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_consult_list scode="${scode}" titlelen="10"
 * dateformat="yyyy-MM-dd" ;consult,index> 
 * </@sme_consult_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("consultListTag")
public class ConsultListTag extends BaseDirective implements
		TemplateDirectiveModel {
	@Resource
	private ConsultServiceI consultAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 标题长度
		int titlelen = getParamInt(params, "titlelen", 0);
		int remarklen = getParamInt(params, "remarklen", 0);
		// 标题长度
		String dateformat = getParam(params, "dateformat");
		// 类别
		Long scode = getParamLong(params, "scode", 0);
		// 发布企业
		Long corpid = getParamLong(params, "corpid", 0);
		// 服务机构
		Long svgid = getParamLong(params, "svgid", 0);
		// 咨询ID
		Long parid = getParamLong(params, "parid", 0);
		// 排序
		String order = getParam(params, "order", "1");
		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				try {
					Consult consult = new Consult();
					if (scode != 0) {
						consult.setScode(scode);
					}
					
					if (null != corpid && corpid != 0) {
						consult.setCorpid(corpid);
					}
					
					if (null != parid && parid != 0) {
						consult.setParid(parid);
					}
					
					List<Consult> list = consultAPI.findConsultList(consult, order,
							1, num);
					
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

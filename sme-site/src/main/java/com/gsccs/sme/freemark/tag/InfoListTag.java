package com.gsccs.sme.freemark.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.sme.api.domain.Sitem;
import com.gsccs.sme.api.domain.site.Info;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.InfoServiceI;
import com.gsccs.sme.api.service.SclassServiceI;

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
 * Title: InfoListTag.java
 * 
 * Description: 信息列表标签
 * 
 * 参数 parid
 * 
 * 返回值 info 信息对象 index 索引
 * 
 * 使用示例
 * 
 * <@sme_info_list channelid="${channel.id}" titlelen="10"
 * dateformat="yyyy-MM-dd" ;infolist,index> </@sme_info_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("infoListTag")
public class InfoListTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private SclassServiceI sclassAPI;
	@Resource
	private InfoServiceI infoAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) {

		// 显示数量
		int num = getParamInt(params, "num", 10);
		// 标题长度
		int titlelen = getParamInt(params, "titlelen", 0);
		int remarklen = getParamInt(params, "remarklen", 0);
		// 标题长度
		String dateformat = getParam(params, "dateformat");
		// 栏目ID
		long channelid = getParamLong(params, "channelid", 0);
		// 发布企业
		Long svgid = getParamLong(params, "svgid", 0);
		// 排序
		String order = getParam(params, "order", "addtime desc");
		// 置顶
		String top = getParam(params, "top");
		// 热点
		String hot = getParam(params, "hot");
		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				try {
					Info info = new Info();

					if (channelid != 0) {
						info.setChannelid(channelid);
					}
					if (null != svgid && svgid != 0) {
						info.setSvgid(svgid);
					}
					
					if (StringUtils.isNotEmpty(top)) {
						info.setIstop(top);
					}
					
					if (StringUtils.isNotEmpty(hot)) {
						info.setIshot(hot);
					}
					List<Info> infolist = infoAPI.queryInfoList(info, order, 1,
							num);
					if (infolist != null && infolist.size() > 0) {
						for (int i = 0; i < infolist.size(); i++) {
							if (null != infolist.get(i)) {
								if (titlelen > 0) {
									infolist.get(i).setTitlelen(titlelen);
								}
								if (remarklen > 0) {
									infolist.get(i).setRemarklen(remarklen);
								}
								if (StringUtils.isNotEmpty(dateformat)) {
									infolist.get(i).setDateformat(dateformat);
								}
								loopVars[0] = new BeanModel(infolist.get(i),
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

package com.gsccs.sme.freemark.tag;

import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateModelException;

/**
 * 自定义标签共同的功能
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
public class BaseDirective {

	/**
	 * 获得参数
	 * 
	 * @param params
	 * @param name
	 * @return
	 */
	public String getParam(Map params, String name) {
		String value = "";
		if (params.get(name) != null
				&& params.get(name).toString().length() > 0) {
			value = params.get(name).toString();
		}
		return value;
	}

	/**
	 * 获得参数并传递默认值
	 * 
	 * @param params
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public String getParam(Map params, String name, String defaultValue) {
		String value = defaultValue;
		if (params.get(name) != null
				&& params.get(name).toString().length() > 0) {
			value = params.get(name).toString();
		}
		return value;
	}

	/**
	 * 获得int参数并传递默认值
	 * 
	 * @param params
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public int getParamInt(Map params, String name, int defaultValue) {
		int value = defaultValue;
		if (params.get(name) != null
				&& params.get(name).toString().length() > 0) {
			try {
				value = Integer.parseInt(params.get(name).toString());
			} catch (Exception e) {
			}
		}
		return value;
	}

	
	/**
	 * 获得long参数并传递默认值
	 * 
	 * @param params
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public long getParamLong(Map params, String name, long defaultValue) {
		long value = defaultValue;
		if (params.get(name) != null
				&& params.get(name).toString().trim().length() > 0) {
			try {
				value = Long.parseLong(params.get(name).toString());
			} catch (Exception e) {
			}
		}
		return value;
	}

	
	/**
	 * 获得数据
	 * 
	 * @param params
	 * @param name
	 * @return
	 * @throws TemplateModelException
	 */
	public String getData(Environment env, String name)
			throws TemplateModelException {
		String value = "";
		if (env.getDataModel().get(name) != null
				&& env.getDataModel().get(name).toString().length() > 0) {
			value = env.getDataModel().get(name).toString();
		}
		return value;
	}

	/**
	 * 获得数据并传递默认值
	 * 
	 * @param params
	 * @param name
	 * @param defaultValue
	 * @return
	 * @throws TemplateModelException
	 */
	public String getData(Environment env, String name, String defaultValue)
			throws TemplateModelException {
		String value = defaultValue;
		if (env.getDataModel().get(name) != null
				&& env.getDataModel().get(name).toString().length() > 0) {
			value = env.getDataModel().get(name).toString();
		}
		return value;
	}

}

package com.gsccs.sme.web.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.gsccs.sme.api.domain.site.Channel;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModelException;

/**
 * freemarker工具类
 * 
 * @author x.d zhang
 * @version 1.0
 */
@Component
public class FreeMarkerUtil {

	/**
	 * 生成静态页面主方法 默认编码为UTF-8
	 * 
	 * @param context
	 *            ServletContext
	 * @param data
	 *            一个Map的数据结果集
	 * @param templatePath
	 *            ftl模版路径
	 * @param htmlPath
	 *            生成静态页面的路径
	 * @throws TemplateException
	 * @throws IOException
	 */
	public static void createHTML(ServletContext context,
			Map<String, Object> data, String templatePath, String htmlPath)
			throws IOException, TemplateException {
		createHTML(context, data, "UTF-8", templatePath, "UTF-8", htmlPath);
	}

	/**
	 * 生成静态页面主方法 默认编码为UTF-8
	 * 
	 * @param dir
	 *            模板本地磁盘存储路径
	 * @param data
	 *            一个Map的数据结果集
	 * @param templatePath
	 *            ftl模版路径
	 * @param htmlPath
	 *            生成静态页面的路径
	 * @throws TemplateException
	 * @throws IOException
	 */
	public static void createHTML(File dir, Map<String, Object> data,
			String templatePath, String htmlPath) throws IOException,
			TemplateException {
		createHTML(dir, data, "UTF-8", templatePath, "UTF-8", htmlPath);
	}

	/**
	 * 生成静态页面主方法
	 * 
	 * @param context
	 *            ServletContext
	 * @param data
	 *            一个Map的数据结果集
	 * @param templatePath
	 *            ftl模版路径
	 * @param templateEncode
	 *            ftl模版编码
	 * @param htmlPath
	 *            生成静态页面的路径
	 * @param htmlEncode
	 *            生成静态页面的编码
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void createHTML(ServletContext context,
			Map<String, Object> data, String templetEncode,
			String templatePath, String htmlEncode, String htmlPath)
			throws IOException, TemplateException {

		Configuration freemarkerCfg = initCfg(context, templetEncode);

		// 指定模版路径
		Template template = freemarkerCfg.getTemplate(templatePath,
				templetEncode);
		template.setEncoding(templetEncode);
		// 静态页面路径
		File htmlFile = new File(htmlPath);
		if (!htmlFile.getParentFile().exists()) {
			htmlFile.getParentFile().mkdirs();
		}
		Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(htmlFile), htmlEncode));
		// 处理模版
		template.process(data, writer);
		writer.flush();
		writer.close();
	}

	/**
	 * 生成静态页面主方法
	 * 
	 * @param File
	 *            模板磁盘存储路径
	 * @param data
	 *            一个Map的数据结果集
	 * @param templatePath
	 *            ftl模版路径
	 * @param templateEncode
	 *            ftl模版编码
	 * @param htmlPath
	 *            生成静态页面的路径
	 * @param htmlEncode
	 *            生成静态页面的编码
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void createHTML(File dir, Map<String, Object> data,
			String templetEncode, String templatePath, String htmlEncode,
			String htmlPath) throws IOException, TemplateException {

		Configuration freemarkerCfg = initCfg(dir, templetEncode);

		// 指定模版路径
		Template template = freemarkerCfg.getTemplate(templatePath,
				templetEncode);
		template.setEncoding(templetEncode);
		// 静态页面路径
		File htmlFile = new File(htmlPath);
		if (!htmlFile.getParentFile().exists()) {
			htmlFile.getParentFile().mkdirs();
		}

		Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(htmlFile), htmlEncode));
		// 处理模版
		template.process(data, writer);
		writer.flush();
		writer.close();
	}

	/**
	 * 处理页面后，装处理结果放入指定Out
	 * 
	 * @param context
	 * @param data
	 * @param templatePath
	 * @throws TemplateModelException
	 */
	public static void createWriter(ServletContext context,
			Map<String, Object> data, String templatePath, Writer writer)
			throws TemplateModelException {
		createWriter(context, data, "UTF-8", templatePath, "UTF-8", writer);
	}

	/**
	 * 处理页面后，装处理结果放入指定Out
	 * 
	 * @param dir
	 * @param data
	 * @param templatePath
	 * @throws TemplateModelException
	 * @throws IOException
	 */
	public static void createWriter(File dir, Map<String, Object> data,
			String templatePath, Writer writer) throws TemplateModelException,
			IOException {
		createWriter(dir, data, "UTF-8", templatePath, "UTF-8", writer);
	}

	public static void createWriter(ServletContext context,
			Map<String, Object> data, String templetEncode,
			String templatePath, String htmlEncode, Writer writer)
			throws TemplateModelException {

		Configuration freemarkerCfg = initCfg(context, templetEncode);

		try {
			// 指定模版路径
			Template template = freemarkerCfg.getTemplate(templatePath,
					templetEncode);
			template.setEncoding(templetEncode);
			// 处理模版
			template.process(data, writer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createWriter(File dir, Map<String, Object> data,
			String templetEncode, String templatePath, String htmlEncode,
			Writer writer) throws TemplateModelException, IOException {

		Configuration freemarkerCfg = initCfg(dir, templetEncode);

		try {
			// 指定模版路径
			Template template = freemarkerCfg.getTemplate(templatePath,
					templetEncode);
			template.setEncoding(templetEncode);
			// 处理模版
			template.process(data, writer);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 初始化freemarker配置
	 * 
	 * @return
	 * @throws TemplateModelException
	 */
	public static Configuration initCfg(ServletContext context,
			String templetEncode) throws TemplateModelException {

		FreeMarkerConfigurer freeMarkerConfigurer = (FreeMarkerConfigurer) SpringUtils
				.getBean("freeMarkerConfigurer");

		Configuration freemarkerCfg = freeMarkerConfigurer.getConfiguration();
		// 加载模版
		// 模版文件存储在工程目录下
		freemarkerCfg.setServletContextForTemplateLoading(context, "/");
		freemarkerCfg.setEncoding(Locale.getDefault(), templetEncode);

		return freemarkerCfg;
	}

	/**
	 * 初始化freemarker配置
	 * 
	 * @return
	 * @throws TemplateModelException
	 * @throws IOException
	 */
	public static Configuration initCfg(File dir, String templetEncode)
			throws TemplateModelException, IOException {

		FreeMarkerConfigurer freeMarkerConfigurer = (FreeMarkerConfigurer) SpringUtils
				.getBean("freeMarkerConfigurer");

		Configuration freemarkerCfg = freeMarkerConfigurer.getConfiguration();
		// 加载模版:模版文件存储在本地磁盘
		freemarkerCfg.setDirectoryForTemplateLoading(dir);
		freemarkerCfg.setEncoding(Locale.getDefault(), templetEncode);

		return freemarkerCfg;
	}
	
	
	public void testObj(){
		List<Channel> channels = new ArrayList<>();
		Channel channel1 = new Channel();
		channel1.setId(1l);
		Channel channel2 = new Channel();
		channel2.setId(1l);
		Channel channel3 = new Channel();
		channel3.setId(1l);
		channels.add(channel1);
		channels.add(channel2);
		channels.add(channel3);
		
		System.out.println("old:"+channels.get(0).getId());
		Collections.reverse(channels);
		System.out.println("new:"+channels.get(0).getId());
	}
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		System.out.println("old:"+list.get(0));
		Collections.reverse(list);
		System.out.println("new:"+list.get(0));
	}
}
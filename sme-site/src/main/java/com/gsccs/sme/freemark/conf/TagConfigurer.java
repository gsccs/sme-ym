package com.gsccs.sme.freemark.conf;

import java.io.IOException;
import java.util.List;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.gsccs.sme.shiro.tag.ShiroTags;

import freemarker.cache.TemplateLoader;
import freemarker.template.TemplateException;

public class TagConfigurer extends FreeMarkerConfigurer {

	// HtmlTemplateLoader 这个类用来自定义html模板
	/*@Override
	protected TemplateLoader getAggregateTemplateLoader(
			List<TemplateLoader> templateLoaders) {

		return new HtmlTemplateLoader(
				super.getAggregateTemplateLoader(templateLoaders));
	}*/

	@Override
	public void afterPropertiesSet() throws IOException, TemplateException {
		super.afterPropertiesSet();
		this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
	}

}

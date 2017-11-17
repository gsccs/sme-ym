package com.gsccs.sme.freemark.conf;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.apache.commons.io.IOUtils;

import freemarker.cache.TemplateLoader;

public class HtmlTemplateLoader implements TemplateLoader {
	
	private static final String HTML_ESCAPE_PREFIX = "<#escape x as x?html>";
	private static final String HTML_ESCAPE_SUFFIX = "</#escape>";

	private final TemplateLoader delegate;

	public HtmlTemplateLoader(TemplateLoader delegate) {
		this.delegate = delegate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * freemarker.cache.TemplateLoader#closeTemplateSource(java.lang.Object)
	 */
	@Override
	public void closeTemplateSource(Object templateSource) throws IOException {
		delegate.closeTemplateSource(templateSource);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see freemarker.cache.TemplateLoader#findTemplateSource(java.lang.String)
	 */
	@Override
	public Object findTemplateSource(String name) throws IOException {
		return delegate.findTemplateSource(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see freemarker.cache.TemplateLoader#getLastModified(java.lang.Object)
	 */
	@Override
	public long getLastModified(Object templateSource) {
		return delegate.getLastModified(templateSource);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see freemarker.cache.TemplateLoader#getReader(java.lang.Object,
	 * java.lang.String) 在读取template文件之后, 在前后套上<#escape>标签
	 */
	@Override
	public Reader getReader(Object templateSource, String encoding)
			throws IOException {
		Reader reader = delegate.getReader(templateSource, encoding);
		String templateText = IOUtils.toString(reader);
		return new StringReader(HTML_ESCAPE_PREFIX + templateText
				+ HTML_ESCAPE_SUFFIX);
	}
}

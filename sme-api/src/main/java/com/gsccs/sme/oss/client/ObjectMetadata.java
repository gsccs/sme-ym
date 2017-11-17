package com.gsccs.sme.oss.client;

public class ObjectMetadata {

	private String fileid;
	private String domain;
	private String schema;
	private String path;
	private byte[] content;
	private Long contentLength;
	private String contentType;
	private String type;

	
	
	public String getFileid() {
		return fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		if (null != domain && domain.trim().length() > 0) {
			if (domain.trim().endsWith("/")) {
				domain = domain.trim().substring(0, domain.trim().length() - 1);
			}
		}
		this.domain = domain;
	}
	
	
	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		if (null != path && path.trim().length() > 0) {
			if (!path.trim().startsWith("/")) {
				path = "/" + path.trim();
			}
			if (!path.trim().endsWith("/")) {
				path = path.trim() + "/";
			}
		}
		this.path = path;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Long getContentLength() {
		return contentLength;
	}

	public void setContentLength(Long contentLength) {
		this.contentLength = contentLength;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getType() {
		if (null==type || type.equals("")){
			type=".jpg";
		}else if(!type.startsWith(".")){
			type = "."+type;
		}
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static enum ExtensionType {
		jpg(".jpg"), png(".png"), bpm(".bmp"), gif(".gif");

		private final String type;

		private ExtensionType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}

}

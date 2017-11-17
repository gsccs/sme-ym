package com.gsccs.sme.plat.bass;

/**
 * 文件json
 * @创建人：x.j  niu 
 * @类名称：FileTreeGrid
 * @创建时间：2015年4月14日 上午10:17:22
 */
public class FileTreeGrid {

	private String id;
	private String text;
	/*
	private String fileName;*/
	private String iconCls;
	private String state;
	private String parentId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	/*public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}*/
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	
}

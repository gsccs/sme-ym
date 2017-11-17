package com.gsccs.sme.web.util;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传的表单
 * @author x.d zhang
 *
 */
public class FileUploadForm {

	private List<MultipartFile> files;
	
	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
}

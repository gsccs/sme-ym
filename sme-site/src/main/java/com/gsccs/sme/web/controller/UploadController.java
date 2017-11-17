package com.gsccs.sme.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.api.domain.base.Attach;
import com.gsccs.sme.api.domain.base.JsonMsg;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.oss.client.ObjectMetadata;
import com.gsccs.sme.oss.client.OssClient;

/**
 * 附件管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
public class UploadController {

	@Autowired
	private ConfigServiceI configAPI;

	private static String IP = "172.16.28.9";
	private static int PORT = 7001;
	private static String DOMAIN = "http://dns1.smeym.org/";

	private static String SITE = "smeym";
	private static String PATH = "images";
	
	// 最大文件大小 5M
	private static long maxSize = 10000000;

	// 定义允许上传的文件扩展名
	HashMap<String, String> extMap = new HashMap<String, String>();

	/**
	 * 初始化参数
	 */
	private void initConf() {
		IP = configAPI.getConfigVal("OSS_IP");
		PORT = Integer.valueOf(configAPI.getConfigVal("OSS_PORT"));
		DOMAIN = configAPI.getConfigVal("OSS_DOMAIN");
		SITE = configAPI.getConfigVal("OSS_SITE");
		PATH = configAPI.getConfigVal("OSS_PATH");

		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
	}

	@RequestMapping(value = "/keditorupload", method = RequestMethod.POST)
	@ResponseBody
	public void keditorupload(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//初始化参数
			initConf();
			// response.setContentType("text/html; charset=UTF-8");
			response.setContentType("application/json; charset=UTF-8");
			if (!ServletFileUpload.isMultipartContent(request)) {
				response.getWriter().println(getError(false, "请选择文件。"));
				response.getWriter().flush();
				return;
			}

			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			List items = upload.parseRequest(request);
			Iterator itr = items.iterator();
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				String fileName = item.getName();
				if (!item.isFormField()) {
					// 检查文件大小
					if (item.getSize() > maxSize) {
						response.getWriter().println(
								getError(false, "上传文件大小超过限制。"));
						response.getWriter().flush();
						return;
					}
					// 检查扩展名
					String fileExt = fileName.substring(
							fileName.lastIndexOf(".") + 1).toLowerCase();
					String filetype = null;
					Iterator<String> its = extMap.keySet().iterator();
					while (its.hasNext()) {
						String key = its.next();
						if (Arrays.<String> asList(extMap.get(key).split(","))
								.contains(fileExt)) {
							filetype = key;
							break;
						}
					}

					if (StringUtils.isEmpty(filetype)) {
						response.getWriter().println(
								getError(false, "上传文件扩展名是不允许的扩展名。"));
					}
					OssClient client = new OssClient(IP, PORT);
					byte[] content = item.get();

					ObjectMetadata metadata = new ObjectMetadata();
					metadata.setDomain(DOMAIN);
					metadata.setSchema(SITE);
					metadata.setPath(PATH);
					metadata.setType(fileExt);
					metadata.setContent(content);

					JSONObject obj = client.putObject(metadata);

					JSONObject result = new JSONObject();
					result.put("error", 0);
					result.put("url", obj.get("url").toString());
					response.getWriter().println(result);
					response.getWriter().flush();
					return;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JSONObject getError(boolean success, String message) {
		// System.out.println("success:" + success);
		// System.out.println("message:" + message);
		JSONObject obj = new JSONObject();
		if (success) {
			obj.put("error", 0);
		} else {
			obj.put("error", 1);
		}
		obj.put("message", message);
		return obj;
	}

	@RequestMapping("/uploadfile")
	@ResponseBody
	public JsonMsg uploadify(HttpServletRequest request,
			HttpServletResponse response) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		JsonMsg msg = new JsonMsg();
		try {
			//初始化参数
			initConf();
			
			DiskFileItemFactory diskFileItemFactory_ = new DiskFileItemFactory();
			ServletFileUpload fUpload = new ServletFileUpload(diskFileItemFactory_);

			if (!ServletFileUpload.isMultipartContent(request)) {
				msg.setSuccess(false);
				msg.setMsg("请选择文件。");
				return msg;
			}
			
			Attach attach = new Attach();
			attach.setId(df.format(new Date()));
			List<FileItem> list_ = (List<FileItem>) fUpload
					.parseRequest(request);
			for (FileItem item : list_) {
				String fileName = item.getName();
				if (fileName != null) {
					attach.setFilename(fileName);

					// 检查文件大小
					if (item.getSize() > maxSize) {
						msg.setSuccess(false);
						msg.setMsg("上传文件大小超过限制。");
						return msg;
					}
					// 检查扩展名
					String fileExt = fileName.substring(
							fileName.lastIndexOf(".") + 1).toLowerCase();
					String filetype = null;
					Iterator<String> its = extMap.keySet().iterator();
					while (its.hasNext()) {
						String key = its.next();
						if (Arrays.<String> asList(extMap.get(key).split(","))
								.contains(fileExt)) {
							filetype = key;
							break;
						}
					}

					if (StringUtils.isEmpty(filetype)) {
						msg.setSuccess(false);
						msg.setMsg("上传文件扩展名是不允许的扩展名。");
						return msg;
					}

					OssClient client = new OssClient(IP, PORT);
					byte[] content = item.get();

					ObjectMetadata metadata = new ObjectMetadata();
					metadata.setDomain(DOMAIN);
					metadata.setSchema(SITE);
					metadata.setPath(PATH);
					metadata.setType(fileExt);
					metadata.setContent(content);

					JSONObject obj = client.putObject(metadata);
					attach.setFilepath(obj.get("url").toString());
				}
			}
			msg.setSuccess(true);
			msg.setMsg("上传成功!");
			msg.setData(attach);
		} catch (FileUploadException e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMsg("上传失败!" + e.getLocalizedMessage());
		} catch (IOException e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMsg("上传失败!" + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMsg("上传失败!" + e.getLocalizedMessage());
		}
		return msg;
	}

	private JSONObject getError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj;
	}

	public static void main(String args[]) throws Exception {
		testExp();
	}

	public void fileupload() throws Exception {
		OssClient client = new OssClient(IP, PORT);
		File file = new File("E:\\DSC_4623.JPG");
		InputStream input = new FileInputStream(file);
		byte[] content = new byte[input.available()];

		input.read(content);

		// byte[] content = item.get();

		ObjectMetadata.ExtensionType exten = ObjectMetadata.ExtensionType.jpg;
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setDomain(DOMAIN);
		metadata.setSchema(PATH);
		metadata.setPath("images");
		metadata.setType("jpg");
		metadata.setContent(content);

		JSONObject obj = client.putObject(metadata);
		String filePath = obj.get("url").toString();
		System.out.println("filepath:" + filePath);
	}

	public static void testExp() {
		// 定义允许上传的文件扩展名
		HashMap<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

		String fileExt = "gif";

	}

}

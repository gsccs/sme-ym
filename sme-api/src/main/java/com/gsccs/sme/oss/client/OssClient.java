package com.gsccs.sme.oss.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 开放存储客户端
 * 
 * @author x.d zhang
 */
public class OssClient {

	private final static String PROTOCOL = "http://";
	private static int CLIENT_COUNT = 1;
	private static String IP = "localhost";
	private static int PORT = 9080;

	public OssClient(String ip, int port) {
		this.IP = ip;
		this.PORT = port;
	}
	
	JSONObject putObject(String schema, String path, byte[] content)
			throws Exception {
		JSONObject resultJsonObject = null;
		if (null == schema || schema.trim().isEmpty() || null == path
				|| path.trim().isEmpty() || null == content) {
			resultJsonObject = new JSONObject();
			resultJsonObject.put("status", false);
			resultJsonObject.put("msg", "参数不完整");
			return resultJsonObject;
		}

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();

		builder.addTextBody("schema", schema);
		builder.addTextBody("path", path);
		builder.addBinaryBody("content", content);
		HttpEntity httpEntity = builder.build();

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(PROTOCOL + IP + ":" + PORT);
		httppost.setEntity(httpEntity);
		CloseableHttpResponse response = httpclient.execute(httppost);
		// 得到httpResponse的实体数据
		HttpEntity resEntity = response.getEntity();
		BufferedReader bufferedReader = null;
		StringBuilder entityStringBuilder = new StringBuilder();
		if (resEntity != null) {
			try {
				bufferedReader = new BufferedReader(new InputStreamReader(
						resEntity.getContent(), "UTF-8"), 8 * 1024);
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					entityStringBuilder.append(line);
				}
				// 利用从HttpEntity中得到的String生成JsonObject
				resultJsonObject = JSON.parseObject(entityStringBuilder.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		EntityUtils.consume(resEntity);
		response.close();
		return resultJsonObject;
	}

	/**
	 * 上传资源文件
	 * 
	 * @param domain
	 *            域名
	 * @param schema
	 *            站点
	 * @param path
	 *            保存路径
	 * @param content
	 *            文件内容
	 * @param extension
	 *            扩展名
	 * @return domain/path/文件名.extension
	 * @throws Exception
	 */
	public JSONObject putObject(ObjectMetadata metadata) throws Exception {
		JSONObject resultJsonObject = null;
		if (null == metadata || null == metadata.getSchema()|| metadata.getSchema().trim().isEmpty() || null == metadata.getContent()) {
			resultJsonObject = new JSONObject();
			resultJsonObject.put("status", false);
			resultJsonObject.put("msg", "参数不完整");
			return resultJsonObject;
		}

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();

		if (null != metadata.getFileid()){
			builder.addTextBody("fileid", metadata.getFileid());
		}
		if (null != metadata.getDomain()){
			builder.addTextBody("domain", metadata.getDomain());
		}
		if (null != metadata.getSchema()){
			builder.addTextBody("schema", metadata.getSchema());
		}
		if (null != metadata.getPath()){
			builder.addTextBody("path", metadata.getPath());
		}
		if (null != metadata.getType()){
			builder.addTextBody("extension", metadata.getType());
		}
		if (null != metadata.getContent()){
			builder.addBinaryBody("content", metadata.getContent());
		}
		HttpEntity httpEntity = builder.build();

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(PROTOCOL + IP + ":" + PORT);
		httppost.setEntity(httpEntity);
		CloseableHttpResponse response = httpclient.execute(httppost);
		// 得到httpResponse的实体数据
		HttpEntity resEntity = response.getEntity();
		BufferedReader bufferedReader = null;
		StringBuilder entityStringBuilder = new StringBuilder();
		if (resEntity != null) {
			try {
				bufferedReader = new BufferedReader(new InputStreamReader(
						resEntity.getContent(), "UTF-8"), 8 * 1024);
				String line = null;
				
				while ((line = bufferedReader.readLine()) != null) {
					entityStringBuilder.append(line);
				}
				// 利用从HttpEntity中得到的String生成JsonObject
				resultJsonObject = JSON.parseObject(entityStringBuilder.toString());
				
				if (null != resultJsonObject
						&& resultJsonObject.get("code").equals("1000")) {
					String fileid = resultJsonObject.getString("id");
					String path = resultJsonObject.getString("path");
					if (null != path){
						if (!path.startsWith("/")){
							path = "/"+path;
						}
						if (!path.endsWith("/")){
							path = path+"/";
						}
					}
					resultJsonObject.put("url", metadata.getDomain() + path + fileid
							+ metadata.getType());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		EntityUtils.consume(resEntity);
		response.close();
		return resultJsonObject;
	}

}

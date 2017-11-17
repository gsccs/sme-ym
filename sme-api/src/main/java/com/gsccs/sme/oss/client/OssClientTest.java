package com.gsccs.sme.oss.client;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.alibaba.fastjson.JSONObject;

public class OssClientTest {

	public static void main(String[] args) {
		
		String path = "20160505";
		if (!path.startsWith("/")){
			path = "/"+path;
		}
		if (!path.endsWith("/")){
			path = path+"/";
		}
		System.out.println(path);
	}
	
	
	public static void osstest(){
		try {
			OssClient client = new OssClient("101.227.249.205", 7070);
			File file = new File("C:\\Users\\ZhangTao\\Pictures\\0003.jpg");
			byte[] content = FileUtils.getByte(file);

			ObjectMetadata.ExtensionType exten = ObjectMetadata.ExtensionType.jpg;
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setDomain("http://img.titles.top/1001/");
			metadata.setSchema("1001");
			metadata.setPath("1000");
			metadata.setType(".jpg");
			metadata.setContent(content);

			JSONObject obj = client.putObject(metadata);
			String filePath = obj.get("url").toString();
			System.out.println(filePath);

		} catch (Exception ex) {
			Logger.getLogger(OssClient.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

}

package com.gsccs.b2c;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.UUID;

public class CSVTester {
	private static String infilePath = "E:\\中通申信\\网站项目\\政府行业\\白银档案局\\20150303\\档案查询（2014）.csv";
	private static String outfilePath = "E:\\中通申信\\网站项目\\政府行业\\白银档案局\\20150303\\insert-script-2014.sql";
	public static void main(String[] args) throws IOException {
		File csvfile = new File(infilePath);
		
		File sqlfile = new File(outfilePath);
		
		InputStreamReader isr = new InputStreamReader(new FileInputStream(
				csvfile), "GBK");
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(sqlfile));
		BufferedReader buffR = new BufferedReader(isr);
		String line = "";
		// 去除第一行
		buffR.readLine();
		// 读取到最后一行
		// boolean isExist = false;
		int i=1;
		
		String sqlPrefix="insert into cms_archive(id,fileId,archiveId,archiveYear,retentionPeriod,fileName,fileType,contributor,fileTime,fileNum) values ";
		while ((line = buffR.readLine()) != null) {
			String item[] = line.split(",");
			
			
			//System.out.print(i+"行，"+item.length+"列     ");
			//System.out.println(sqlPrefix+ " ('"+UUID.randomUUID().toString()+"','"+item[0]+"','"+item[1]+"','"+item[7].substring(0, 4)+"','"+item[3]+"','"+item[4]+"','"+item[5]+"','"+item[6]+"','"+item[7]+"','"+item[8]+"')");
			osw.write(sqlPrefix+ " ('"+UUID.randomUUID().toString()+"','"+item[0]+"','"+item[1]+"','"+item[7].substring(0, 4)+"','"+item[3]+"','"+item[4]+"','"+item[5]+"','"+item[6]+"','"+item[7]+"','"+item[8]+"');\n");
			/** System.out.print(item[1]+" | ");
			System.out.print(item[2]+" | ");
			System.out.print(item[3]+" | ");
			System.out.print(item[4]+" | ");
			System.out.print(item[5]+" | ");
			System.out.print(item[6]+" | ");
			System.out.print(item[7]+" | ");
			System.out.print(item[8]+" | ");
			System.out.println();**/
			i++;
		}
		buffR.close();
		osw.flush();
		osw.close();
		
	}
}

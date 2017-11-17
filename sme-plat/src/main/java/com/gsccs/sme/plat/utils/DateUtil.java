package com.gsccs.sme.plat.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @创建人：x.j niu
 * @类名称：DateUtil
 * @创建时间：2015年4月22日 下午5:03:34
 */
public class DateUtil {

	/**
	 * 根据当前时间到毫秒生成订单号
	 * 
	 * @return
	 */
	public static String getOrderNum() {
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat(
				"yyyyMMddHHmmssSS");
		return dateFormatGmt.format(new Date());
	}
}

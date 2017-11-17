package com.gsccs.sme.plat.utils;

import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class DateConvert implements Converter {

	public Object convert(Class type, Object obj) {
		if (null == obj){
			return null;
		}
		if (obj instanceof Date){
			return obj;
		}
		return null;
	}

}

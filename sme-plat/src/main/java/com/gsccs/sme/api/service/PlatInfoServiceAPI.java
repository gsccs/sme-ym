package com.gsccs.sme.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.gsccs.sme.api.service.PlatInfoServiceI;
import com.gsccs.sme.plat.statist.service.StatistService;

public class PlatInfoServiceAPI implements PlatInfoServiceI {

	@Autowired
	private StatistService statistService;

	@Override
	public JSONObject statist() {
		return statistService.platStatist();
	}
	
	
}

package com.gsccs.sme.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.plat.auth.model.Config;
import com.gsccs.sme.plat.auth.service.ConfigService;

public class ConfigServiceAPI implements ConfigServiceI {
	
	@Autowired
	private ConfigService configService;

	@Override
	public String getConfigVal(String key) {
		Config conf = configService.findByCode(key);
		return conf.getConfigvalue();
	}

}

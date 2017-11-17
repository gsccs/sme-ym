package com.gsccs.sme.test;

import org.apache.shiro.crypto.hash.ConfigurableHashService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsccs.sme.api.domain.Location;
import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.corp.Corp;
import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.AccountServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dubbo-server-consumer.xml")
public class ConfigServiceTest {

	@Autowired
	private ConfigServiceI configAPI;

	@Test
	public void getConfig() throws Throwable {
		String val =  configAPI.getConfigVal("ROOT_PATH");
		System.out.println(val);
		
	}

	
}

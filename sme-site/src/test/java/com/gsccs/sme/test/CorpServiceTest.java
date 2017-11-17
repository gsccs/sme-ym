package com.gsccs.sme.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.corp.Corp;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.AccountServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dubbo-server-consumer.xml")
public class CorpServiceTest {

	@Autowired
	private AccountServiceI userAPI;

	@Autowired
	private CorpServiceI corpAPI;

	
	
	@Test
	public void list() {
		int page = 1;
		int pagesize = 10;
		try {
			List<Corp> corplist = corpAPI.queryCorpList(null, "addtime desc", page, pagesize);
					//.queryInfoList(null, "addtime desc", page, pagesize);
			System.out.println("end ###############"+corplist.size());
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

	
}

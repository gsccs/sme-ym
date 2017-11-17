package com.gsccs.sme.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsccs.sme.api.domain.DeclareTopic;
import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.api.domain.base.Datagrid;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.DeclareServiceI;
import com.gsccs.sme.api.service.SneedServiceI;
import com.gsccs.sme.api.service.AccountServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dubbo-server-consumer.xml")
public class DeclareServiceTest {

	@Autowired
	private AccountServiceI userAPI;

	@Autowired
	private DeclareServiceI declareAPI;


	@Test
	public void list() {
		int page = 1;
		int pagesize = 10;
		try {
			Datagrid datagrid = declareAPI.queryTopicList(null, "", page,
					pagesize);
			System.out.println("end ###############"+datagrid.getTotal());
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

}

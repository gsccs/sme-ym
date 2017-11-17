package com.gsccs.sme.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsccs.sme.api.domain.Itemtype;
import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.api.domain.site.Info;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.InfoServiceI;
import com.gsccs.sme.api.service.SclassServiceI;
import com.gsccs.sme.api.service.AccountServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dubbo-server-consumer.xml")
public class SclassServiceTest {

	@Autowired
	private AccountServiceI userAPI;

	@Autowired
	private SclassServiceI sclassAPI;

	//@Test
	public void addInfo() throws Throwable {
		System.out.println("start ###############");
		Sneed sneed = new Sneed();
		sneed.setTitle("测试试试");
		sneed.setCorpid(101l);
		sneed.setLasttime(new Date());
		sneed.setAddtime(new Date());
		sneed.setContent("测试内容");
		//sneedAPI.addSneed(sneed);
		System.out.println("end ###############");
	}

	@Test
	public void list() {
		int page = 1;
		int pagesize = 10;
		try {
			List<Itemtype> list = sclassAPI.getRootClass("S");
			System.out.println("end ###############"+list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}

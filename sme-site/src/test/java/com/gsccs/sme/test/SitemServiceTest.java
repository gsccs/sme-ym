package com.gsccs.sme.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsccs.sme.api.domain.Sitem;
import com.gsccs.sme.api.domain.Sitemeval;
import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.api.domain.shop.Product;
import com.gsccs.sme.api.domain.site.Info;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.InfoServiceI;
import com.gsccs.sme.api.service.ProductServiceI;
import com.gsccs.sme.api.service.SitemServiceI;
import com.gsccs.sme.api.service.AccountServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dubbo-server-consumer.xml")
public class SitemServiceTest {

	@Autowired
	private AccountServiceI userAPI;

	@Autowired
	private SitemServiceI sitemAPI;

	// @Test
	public void add() throws Throwable {
		Sitem sitem = new Sitem();
		sitem.setAddtime(new Date());
		sitem.setTitle("20160313测试");
		sitemAPI.addSitem(sitem);
	}

	@Test
	public void list() {
		int page = 1;
		int pagesize = 10;
		try {
			List<Sitem> list = sitemAPI.querySitemList(null, "addtime desc",
					page, pagesize);
			System.out.println("end ###############" + list.size());
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

	// @Test
	public void addEval() throws Throwable {
		Sitemeval sitem = new Sitemeval();
		sitem.setAddtime(new Date());
		sitem.setSitemid(1001l);
		sitem.setScore(4);
		sitem.setContent("20160313测试");
		sitemAPI.addSitemEval(sitem);
	}

	//@Test
	public void listEval() throws Throwable {
		Sitemeval sitem = new Sitemeval();
		sitem.setSitemid(1001l);
		List<Sitemeval> sitemevals = sitemAPI.findItemEvals(sitem, "addtime desc", 1, Integer.MAX_VALUE);
		System.out.println("list size:"+sitemevals.size());
	}

}

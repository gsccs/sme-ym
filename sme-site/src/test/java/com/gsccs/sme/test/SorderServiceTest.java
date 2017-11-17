package com.gsccs.sme.test;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsccs.sme.api.domain.Sorder;
import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.corp.Corp;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.PorderServiceI;
import com.gsccs.sme.api.service.SorderServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.util.CustomDate;

/**
 * 服务订单测试
 * 
 * @author x.d zhang
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dubbo-server-consumer.xml")
public class SorderServiceTest {

	@Autowired
	private AccountServiceI userAPI;

	@Autowired
	private SorderServiceI sorderAPI;

	@Test
	public void create() {

		Sorder sorder = new Sorder();
		try {
			sorder.setId("20160312");
			sorder.setCorpid(2l);
			sorder.setSvgid(1001l);
			sorder.setSitemid(1001l);
			sorderAPI.createSorder(sorder);
			System.out.println("create ###############");
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void list() {
		int page = 1;
		int pagesize = 10;
		try {
			List<Sorder> sorders = sorderAPI.getCorpSorderList(1011l, null, "",
					1, Integer.MAX_VALUE);
			System.out.println("end ###############" + sorders.size());
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String args[]){
		String id = CustomDate.getOrderNum();
		System.out.println(id);
	}

}

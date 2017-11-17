package com.gsccs.sme.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsccs.sme.api.domain.Porder;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.PorderServiceI;
import com.gsccs.sme.api.service.AccountServiceI;
import com.gsccs.sme.web.util.CustomDate;

/**
 * 产品订单测试
 * 
 * @author x.d zhang
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dubbo-server-consumer.xml")
public class PorderServiceTest {

	@Autowired
	private AccountServiceI userAPI;

	@Autowired
	private PorderServiceI porderAPI;

	//@Test
	public void create() {

		Porder porder = new Porder();
		try {
			porder.setBuyerid(1l);
			porder.setProductid(180l);
			porder.setTotalnum(1);
			porderAPI.createOrder(porder);
			System.out.println("create ###############");
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void list() {
		try {
			Porder porder = new Porder();
			porder.setBuyerid(1l);
			List<Porder> sorders = porderAPI.getOrderList(porder, "",
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

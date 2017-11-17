package com.gsccs.sme.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.api.domain.shop.Product;
import com.gsccs.sme.api.domain.site.Info;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.InfoServiceI;
import com.gsccs.sme.api.service.ProductServiceI;
import com.gsccs.sme.api.service.AccountServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dubbo-server-consumer.xml")
public class ProductServiceTest {

	@Autowired
	private AccountServiceI userAPI;

	@Autowired
	private ProductServiceI productAPI;

	@Test
	public void add() throws Throwable {
		Product product = new Product();
		product.setAddtime(new Date());
		product.setTitle("20160313测试");
		productAPI.addProduct(product);
	}

	@Test
	public void list() {
		int page = 1;
		int pagesize = 10;
		try {
			List<Product> list = productAPI.queryProductList(null, "addtime desc", page, pagesize);
			System.out.println("end ###############"+list.size());
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}
	
	
	

}

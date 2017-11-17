package com.gsccs.sme.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsccs.sme.api.domain.Location;
import com.gsccs.sme.api.domain.Account;
import com.gsccs.sme.api.domain.corp.Corp;
import com.gsccs.sme.api.service.CorpServiceI;
import com.gsccs.sme.api.service.AccountServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dubbo-server-consumer.xml")
public class UserServiceTest {

	@Autowired
	private AccountServiceI userAPI;
	@Autowired
	private CorpServiceI corpAPI;

	//@Test
	public void getUser() throws Throwable {
		String username = "admin";
	}
	
	
	@Test
	public void addUser() throws Throwable {
		
		Account user2 = new Account();
		user2.setAccount("test106");
		user2.setPassword("000000");
		//user2.setOrgid(1017l);
		user2.setOrgname("测试机构");
		user2.setUsertype("S");
		user2.setName("测试人");
		user2.setPhone("1539310000");
		user2.setEmail("1539310000@189.cn");
		Location location = new Location();
		location.setPcode(62);
		location.setCcode(6209);
		userAPI.registAccount(user2);
		
		String username = "test105";
	}

	
}

package com.gsccs.sme.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsccs.sme.api.domain.Sneed;
import com.gsccs.sme.api.domain.base.Dict;
import com.gsccs.sme.api.service.AreaServiceI;
import com.gsccs.sme.api.service.DictServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dubbo-server-consumer.xml")
public class AreaServiceTest {

	@Autowired
	private AreaServiceI areaAPI;

	@Test
	public void list() {
		String areastr = areaAPI.getAreaStr(620102008);
		System.out.println("end ###############"+areastr);
	}
	
	
	

}

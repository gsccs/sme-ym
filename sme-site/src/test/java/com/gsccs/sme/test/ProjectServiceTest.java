package com.gsccs.sme.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gsccs.sme.api.domain.shop.Project;
import com.gsccs.sme.api.exception.ApiException;
import com.gsccs.sme.api.service.ProjectServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dubbo-server-consumer.xml")
public class ProjectServiceTest {

	@Autowired
	private ProjectServiceI projectAPI;

	
	@Test
	public void list() {
		int page = 1;
		int pagesize = 10;
		try {
			List<Project> list = projectAPI.queryProjectList(null, "addtime desc", page, pagesize);
			System.out.println("end ###############"+list.size());
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}
	
	
	

}

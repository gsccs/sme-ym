package com.gsccs.sme.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Consumer {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "dubbo-server-consumer.xml","spring-redis.xml" });
		context.start();
		/*// 获取远程服务代理
		SellerServiceI sellerAPI = (SellerServiceI) context
				.getBean("sellerAPI");*/
		/*CateServiceI cateAPI = (CateServiceI) context
				.getBean("cateAPI");*/
		
		/*EvalServiceI evalAPI = (EvalServiceI) context
				.getBean("evalAPI");*/
		//testCategory(cateAPI);
		//testEval(evalAPI);
		
	}
	
	
	
	
}

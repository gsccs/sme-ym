package com.gsccs.sme.plat.job;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.gsccs.sme.api.service.InfoServiceI;
import com.gsccs.sme.plat.site.service.ContentService;
import com.gsccs.sme.plat.utils.SpringUtils;

/**
 * 站点信息索引作业
 * @author x.d zhang
 *
 */
public class InfoIndexJob extends QuartzJobBean{

	
	protected static final Logger log=Logger.getLogger(InfoIndexJob.class);  
    
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		 log.info("-----信息索引任务执行-----"); 
		 ContentService contentService =  SpringUtils.getBean("contentService");
		 contentService.index();
	}

}

package com.gsccs.sme.plat.auth.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.plat.auth.dao.SmsMapper;
import com.gsccs.sme.plat.auth.model.Config;
import com.gsccs.sme.plat.auth.model.Sms;
import com.gsccs.sme.plat.auth.model.SmsExample;
import com.gsccs.sme.plat.auth.model.User;
import com.mascloud.model.MoModel;
import com.mascloud.model.StatusReportModel;
import com.mascloud.model.SubmitReportModel;
import com.mascloud.sdkclient.Client;

@Service
public class SmsServiceImpl implements SmsService {
	
	private String SMS_URL = "http://mas.ecloud.10086.cn/app/sdk/login";
	private String SMS_ACCOUNT = "gjjln";
	private String SMS_PASSWORD = "123456";
	//private String SMS_ECNAME = "陇南市住房公积金管理中心";
	private String SMS_ECNAME = "玉门市中小企业服务平台";
	
	@Autowired
	private ConfigService configService;
	@Autowired
	private UserService userService;
	@Autowired
	private SmsMapper smsMapper;

	public Sms createSme(Sms app) {
		smsMapper.insert(app);
		return smsMapper.selectByPrimaryKey(app.getId());
	}
	
	
	public void saveSms(String[] phones,String content) {
		if (null !=phones && phones.length>0){
			for(String phone:phones){
				Sms sms = new Sms();
				sms.setPhone(phone);
				sms.setContent(content);
				sms.setAddtime(new Date());
				smsMapper.insert(sms);
			}
		}
	}


	public void deleteSme(Long appId) {
		smsMapper.deleteByPrimaryKey(appId);
	}

	@Override
	public List<Sms> find(Sms param, String order, int currPage, int pageSize) {
		SmsExample example = new SmsExample();
		SmsExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return smsMapper.selectPageByExample(example);
	}

	@Override
	public Integer count(Sms param) {
		SmsExample example = new SmsExample();
		SmsExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		return smsMapper.countByExample(example);
	}

	public void proSearchParam(Sms param, SmsExample.Criteria criteria) {
		if (null != param) {
			if (StringUtils.isNotEmpty(param.getPhone())) {
				criteria.andPhoneEqualTo(param.getPhone());
			}

			if (StringUtils.isNotEmpty(param.getContent())) {
				criteria.andContentLike("%" + param.getContent() + "%");
			}
		}
	}

	private void init() {
		Config SMS_URL_CONF = configService.findByCode("SMS_URL");
		Config SMS_ACCOUNT_CONF = configService.findByCode("SMS_ACCOUNT");
		Config SMS_PASSWORD_CONF = configService.findByCode("SMS_URL");
		Config SMS_ECNAME_CONF = configService.findByCode("SMS_URL");
		if (SMS_URL_CONF != null) {
			SMS_URL = SMS_URL_CONF.getConfigvalue();
		}
		if (SMS_ACCOUNT_CONF != null) {
			SMS_ACCOUNT = SMS_ACCOUNT_CONF.getConfigvalue();
		}
		if (SMS_PASSWORD_CONF != null) {
			SMS_PASSWORD = SMS_PASSWORD_CONF.getConfigvalue();
		}
		if (SMS_ECNAME_CONF != null) {
			SMS_ECNAME = SMS_ECNAME_CONF.getConfigvalue();
		}
	}

	@Override
	public void sendMsg(String[] mobiles, String content) {
		try {
			// 初始化参数
			//init();

			final Client client = Client.getInstance();
			// 正式环境IP，登录验证URL，用户名，密码，集团客户名称
			client.login(SMS_URL, SMS_ACCOUNT, SMS_PASSWORD, SMS_ECNAME);
			// 测试环境IP
			// client.login("http://112.33.1.13/app/sdk/login", "sdk2",
			// "123","光谷信息");
			int sendResult = client.sendDSMS(mobiles, content, "", 1,
					"S2D5VcR6", UUID.randomUUID().toString(), true);
			System.out.println("推送结果: " + sendResult);

			// 获取提交报告线程
			Thread t1 = new Thread() {
				public void run() {
					while (true) {
						List<SubmitReportModel> list = client.getSubmitReport();
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			};
			t1.start();

			// 获取状态报告线程
			Thread t2 = new Thread() {
				public void run() {
					while (true) {
						List<StatusReportModel> StatusReportlist = client
								.getReport();
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			};
			t2.start();

			// 获取上行线程
			Thread t3 = new Thread() {
				public void run() {
					while (true) {
						List<MoModel> lis = client.getMO();
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			};
			t3.start();
			saveSms(mobiles, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendMsg(Long orgid, String content) {
		if (null == orgid || StringUtils.isEmpty(content)){
			return;
		}
		List<User> userlist = userService.findByOrgId(orgid);
		if (null != userlist && userlist.size() > 0) {
			List<String> phones = new ArrayList<>();
			for (User user : userlist) {
				if (null != user && StringUtils.isNotEmpty(user.getPhone())) {
					phones.add(user.getPhone());
				}
			}
			
			/*if (null != phones && phones.size()>0){
				sendMsg((String[]) phones.toArray(), content);
				saveSms((String[]) phones.toArray(), content);
			}*/
		}
	}
	
	public static void main(String[] args) {
		SmsService smsService = new SmsServiceImpl();
		smsService.sendMsg(new String[]{"15193176118"}, "测试");
	}
}

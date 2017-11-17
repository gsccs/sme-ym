package com.gsccs.sme.mail.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.sme.api.service.ConfigServiceI;
import com.gsccs.sme.app.core.Const;
import com.gsccs.sme.web.util.DES;


@Service
public class MailServiceImpl implements MailService {

	public static final String MAIL_HOST = "MAIL_HOST";
	public static final String MAIL_PORT = "MAIL_PORT";
	public static final String MAIL_SENDER = "MAIL_SENDER";
	public static final String MAIL_PWD = "MAIL_PWD";

	public static final String MAIL_PROTOCOL = "smtp";

	public static final String HOST = "smtp.163.com";
	public static final String PROTOCOL = "smtp";
	public static final int PORT = 25;
	public static final String FROM = "niuxj1123@163.com";// 发件人的email
	public static final String PWD = "niuxj890409jun";// 发件人密码

	@Autowired
	private ConfigServiceI configAPI;

	/**
	 * 获取Session
	 * 
	 * @return
	 */
	private Session getSession() {
		Properties props = new Properties();
		props.put("mail.smtp.host", configAPI.getConfigVal(MAIL_HOST));// 设置服务器地址
		props.put("mail.store.protocol", MAIL_PROTOCOL);// 设置协议
		props.put("mail.smtp.port", configAPI.getConfigVal(MAIL_PORT));// 设置端口
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.localhost", "localhost");
		// props.put("mail.smtp.auth", "false");
		Authenticator authenticator = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(
						configAPI.getConfigVal(MAIL_SENDER),
						configAPI.getConfigVal(MAIL_PWD));
			}

		};
		Session session = javax.mail.Session.getInstance(props, authenticator);
		// Session session = Session.getDefaultInstance(props , authenticator);
		return session;
	}

	public void send(String toEmail, String subject,String content) {
		Session session = getSession();
		try {
			System.out.println("--send--" + content);
			// Instantiate a message
			Message msg = new MimeMessage(session);

			// Set message attributes
			msg.setFrom(new InternetAddress(configAPI.getConfigVal(MAIL_SENDER)));
			InternetAddress[] address = { new InternetAddress(toEmail) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setContent(content, "text/html;charset=utf-8");

			// Send the message
			Transport.send(msg);
		} catch (MessagingException e) {
			System.out.println(toEmail+" 邮件发送失败。");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(
				"点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
		sb.append("<a href=\"http://localhost:8080/springmvc/user/register?action=activate&email=");
		sb.append("niuxj1123@163.com");
		sb.append("&validateCode=");
		sb.append("1111");
		sb.append("\">http://localhost:8080/springmvc/user/register?action=activate&email=");
		sb.append("niuxj1123@163.com");
		sb.append("&validateCode=");
		sb.append("1111");
		sb.append("</a>");

		// 发送邮件
		//MailService mailService = new MailServiceImpl();
		//mailService.send("823321202@qq.com", sb.toString());
		String account="admin";
		String email="email";
		try {
			//d0271a9275050ce11fe7dd888f6a2f16
			//51befd8df43a2e342272175401ea4d6a
			
			//String encodeCode =  new DES("SMEYM").encrypt(account+"|"+email+"|"+new Date().getTime());
			//System.out.println(encodeCode);
			String encodeCode = "51befd8df43a2e3456158cdb494086a478b0a4327ecc44d81e47450b95781d93";
			String decode = new DES(Const.DES_KEY).decrypt(encodeCode);
			String params[] = decode.split("\\|");
			
			String datestr = params[2];
			long diff = new Date().getTime()-Long.valueOf(datestr);
			long hours = diff / 1000 % 60;
					//diff / (60 * 60 * 1000) % 24;
			System.out.println(""+hours);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

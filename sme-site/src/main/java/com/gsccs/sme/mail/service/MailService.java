package com.gsccs.sme.mail.service;

/**
 * 邮件服务接口
 * @author x.d zhang
 *
 */
public interface MailService {

	public void send(String receAddr, String subject, String content);

}

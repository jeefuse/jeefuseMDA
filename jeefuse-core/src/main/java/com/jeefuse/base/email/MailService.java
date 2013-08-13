package com.jeefuse.base.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**邮件发送服务抽象类,注入邮件发送器 mailSender.
 * @author <a href="mailto:yonclv@gmail.com">yonclv</a>
 */
public abstract class MailService {

	static Logger logger = LoggerFactory.getLogger(SimpleMailService.class);

	protected JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * 发送邮件.
	 */
	
	public abstract void sendMail(String[] receviers,MailMessage mailMessage);


}

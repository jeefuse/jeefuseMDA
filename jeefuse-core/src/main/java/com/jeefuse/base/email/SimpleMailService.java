package com.jeefuse.base.email;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * 文本邮件服务类.
 * 
 * 演示多线程群发文本邮件.
 * 
 * @author calvin
 */
public class SimpleMailService {

	static Logger logger = LoggerFactory.getLogger(SimpleMailService.class);

	private JavaMailSender mailSender;

	private Executor executor = Executors.newFixedThreadPool(20);

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * 发送纯文本的用户修改通知邮件.
	 * 
	 * 用Executor多线程群发邮件演示.
	 */
	public void sendNotificationMail(String userName) {

		//简化演示,发送三封地址相同的邮件.
		String[] receviers = new String[] { "yonclv@gmail.com", "yonclv@gmail.com",
				"yonclv@gmail.com" };

		for (String receiver : receviers) {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom("yonclv@gmail.com");
			msg.setTo(receiver);
			msg.setSubject("用户修改通知");
			msg.setText(userName + "被修改.");

			executor.execute(new MailTask(mailSender, msg));
		}
	}

	/**
	 * 群发邮件任务类.
	 */
	private static class MailTask implements Runnable {

		private JavaMailSender mailSender;
		private SimpleMailMessage msg;

		public MailTask(JavaMailSender mailSender, SimpleMailMessage msg) {
			this.mailSender = mailSender;
			this.msg = msg;
		}

		public void run() {
			try {
				mailSender.send(msg);
				logger.info("纯文本邮件已发送至" + msg.getTo());
			} catch (MailException e) {
				logger.error("发送邮件失败", e);
			}
		}
	}
}

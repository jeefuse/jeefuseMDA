package com.jeefuse.base.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**发送邮件任务类.
 * @author <a href="mailto:yonclv@gmail.com">yonclv</a>
 */
public class MailTask implements Runnable {
	static Logger logger = LoggerFactory.getLogger(MailTask.class);

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

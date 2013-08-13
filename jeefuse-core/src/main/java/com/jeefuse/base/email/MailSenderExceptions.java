package com.jeefuse.base.email;

import com.jeefuse.base.exception.ApplicationException;

/**邮件发送异常
 * @author <a href="mailto:yonclv@gmail.com">yonclv</a>
 */
@SuppressWarnings("serial")
public class MailSenderExceptions extends ApplicationException {

	public MailSenderExceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public MailSenderExceptions(String message) {
		super(message);
	}

	public MailSenderExceptions(Throwable cause) {
		super(cause);
	}

}

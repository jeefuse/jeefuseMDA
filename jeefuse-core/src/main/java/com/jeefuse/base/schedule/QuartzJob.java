package com.jeefuse.base.schedule;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 被Quartz定时执行的任务类.
 */
public class QuartzJob {

	private static Logger logger = LoggerFactory.getLogger(QuartzJob.class);


	protected void executeCronLog() {
		long userCount = System.currentTimeMillis();
		logger.info("Hello, now is {}, there is {} user in table, print by Quartz cron job", new Date(), userCount);
	}

	protected void executeTimerLog() {
		long userCount = System.currentTimeMillis();
		logger.info("Hello, now is {}, there is {} user in table, print by Quartz timer job", new Date(), userCount);
	}
}

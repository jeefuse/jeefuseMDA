package com.jeefuse.base.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Spring的支持数据库访问,事务控制和依赖注入的JUnit4 集成测试基类.
 * <p>
 * 子类需要设置application context 文件位置信息.如
 * 
 * @ContextConfiguration(locations = { "classpath:applicationContext.xml" })
 */
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public abstract class SpringTransactionalTestCase extends AbstractTransactionalJUnit4SpringContextTests {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
}

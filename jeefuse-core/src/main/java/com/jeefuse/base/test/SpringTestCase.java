package com.jeefuse.base.test;

import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * 基于Spring的JUnit4 集成测试基类.
 * <p>
 * 子类需要定义applicationContext文件的位置,如:
 * 
 * @ContextConfiguration(locations = { "/applicationContext-test.xml" })
 * 
 */
public class SpringTestCase extends AbstractJUnit4SpringContextTests {

}

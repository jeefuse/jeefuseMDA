package com.jeefuse.base.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Spring的支持数据库访问,事务控制和依赖注入的JUnit4 集成测试基类.
 * <p>
 * 子类需要定义applicationContext文件的位置, 如:
 * 
 * @ContextConfiguration(locations = { "classpath:applicationContext.xml" })
 * @author yonclv
 * @email yonclv@gmail.com
 */
public abstract class SpringTransactionalHibernateTestCase extends SpringTransactionalTestCase {

	/**
	 * 刷新默认的sessionFactory,强制Hibernate执行SQL以验证ORM配置.
	 * 但只要不执行commit操作,SQL执行的结果不会实际提交到测试数据库中. sessionFactory名默认为"sessionFactory".
	 */
	public void flush() {
		flush("sessionFactory");
	}

	/**
	 * 刷新sessionFactory,强制Hibernate执行SQL以验证ORM配置.
	 * 但只要不执行commit操作,SQL执行的结果不会实际提交到测试数据库中.
	 * 
	 * @param sessionFactoryName
	 *            applicationContext中sessionFactory的名称.
	 */
	public void flush(final String sessionFactoryName) {
		((SessionFactory) applicationContext.getBean(sessionFactoryName)).getCurrentSession().flush();
	}

	/**
	 * 返回"sessionFactory" 会话.
	 * 
	 * @return
	 */
	protected Session getSession() {
		SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
		return sessionFactory.getCurrentSession();
	}
}

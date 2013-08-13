package com.jeefuse.base.service;

import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**获取当前系统中的Spring applicationContext.
 * @author  yonclv
 * @created 2009-8-6
 */
public class SpringContextUtils {
	
	/**
	 * 获取当前系统 Web 环境下的Spring applicationContext.
	 * @return
	 */
	public static ApplicationContext getWebApplicationContext(){
		return ContextLoader.getCurrentWebApplicationContext();
	}
	
	/**
	 * 根据servletContext 获取Spring applicationContext.
	 * @return
	 */
	public static ApplicationContext getWebApplicationContext(ServletContext servletContext){
		return WebApplicationContextUtils.getWebApplicationContext(servletContext);
	}
	
	/**
	 * 根据ID获取当前系统 Web 环境下的Spring管理的bean.
	 * @param id
	 * @return
	 */
	public static Object getBean(String id){
		return getWebApplicationContext().getBean(id);
	}
	
	/**
	 * 根据类型获取当前系统 Web 环境下的Spring管理的bean.
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map getBeanOfType(Class clazz){
		return getWebApplicationContext().getBeansOfType(clazz);
	}
	
}

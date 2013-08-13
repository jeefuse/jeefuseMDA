package com.jeefuse.base.utils.reflect;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * 反射工具类.
 * 
 * 提供侵犯隐私的直接读取field的能力. 对要求高性能时请谨慎使用反射.
 */
public class BeanUtil {

	protected static Logger logger = LoggerFactory.getLogger(BeanUtil.class);

	private BeanUtil() {
	}

	/**
	 * 直接读取对象属性值,无视private/protected修饰符,不经过getter函数.
	 */
	public static Object getFieldValue(Object object, String fieldName) throws NoSuchFieldException {
		Field field = getDeclaredField(object, fieldName);
		if (!field.isAccessible()) {
			field.setAccessible(true);
		}

		Object result = null;
		try {
			result = field.get(object);
		} catch (IllegalAccessException e) {
			logger.error("获取字断值异常{}", e.getMessage());
		}
		return result;
	}

	/**
	 * 直接读取对象属性值,无视private/protected修饰符,不经过getter函数.可取关联对象.如obj.name形式.
	 */
	public static Object getRelFieldValue(Object object, String fieldName) throws NoSuchFieldException {
		//如果是obj.name形式即是关联对象.
		if(-1!=fieldName.indexOf(".")){
			String relObjectName=fieldName.substring(0,fieldName.indexOf("."));
			Object result = getFieldValue(object, relObjectName);
			return getRelFieldValue(result,fieldName.substring(fieldName.indexOf(".")+1));
		}
		return getFieldValue(object, fieldName);
	}
	
	/**
	 * 直接设置对象属性值,无视private/protected修饰符,不经过setter函数.
	 */
	public static void setFieldValue(Object object, String fieldName, Object value) throws NoSuchFieldException {
		Field field = getDeclaredField(object, fieldName);
		if (!field.isAccessible()) {
			field.setAccessible(true);
		}
		try {
			field.set(object, value);
		} catch (IllegalAccessException e) {
			logger.error("设置字段值异常:{}", e.getMessage());
		}
	}

	/**
	 * 循环向上转型,获取对象的DeclaredField.
	 */
	public static Field getDeclaredField(Object object, String fieldName) throws NoSuchFieldException {
		Assert.notNull(object);
		return getDeclaredField(object.getClass(), fieldName);
	}

	/**
	 * 循环向上转型,获取类的DeclaredField.
	 */
	@SuppressWarnings("unchecked")
	public static Field getDeclaredField(Class clazz, String fieldName) throws NoSuchFieldException {
		Assert.notNull(clazz);
		Assert.hasText(fieldName);
		for (Class superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				return superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) {
				// Field不在当前类定义,继续向上转型
			}
		}
		throw new NoSuchFieldException("No such field: " + clazz.getName() + '.' + fieldName);
	}
}

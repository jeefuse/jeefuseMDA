package com.jeefuse.base.utils.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jeefuse.base.utils.random.Randomizer;

/**
 * 填充对象数据工具.主要用于测试环境下生成准备数据.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class PopulateUtil {
	/**
	 * 填充对象字段值.
	 */
	static public <T> T populateValue(Class<T> clazz) {
		try {
			T object = clazz.newInstance();
			populateValue(object);
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 填充对象字段值.
	 */
	@SuppressWarnings("unused")
	static public void populateValue(Object model) {
		try {
			Class<?> clazz = model.getClass();
			Object object = model;
			if (null == object) {
				object = clazz.newInstance();
			}
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				String modifier = Modifier.toString(field.getModifiers());
				if (modifier.contains("final") || modifier.contains("static")) {
					continue;
				}
				String name = field.getName();
				Class<?> type = field.getType();
				String simpleTypeName = type.getName();
				Object value = null;
				if (-1 != simpleTypeName.indexOf(".")) {
					simpleTypeName = simpleTypeName.substring(simpleTypeName.lastIndexOf(".") + 1);
				}
				if (simpleTypeName.equalsIgnoreCase("Integer")) {
					value = Randomizer.nextString(6);
				} else if (simpleTypeName.equalsIgnoreCase("String")) {
					value = Randomizer.nextString(1);
				} else if (simpleTypeName.equalsIgnoreCase("Double")) {
					value = Randomizer.nextDouble();
				} else if (simpleTypeName.equalsIgnoreCase("Float")) {
					value = Randomizer.nextFloat();
				} else if (simpleTypeName.equalsIgnoreCase("Long")) {
					value = Randomizer.nextLong();
				} else if (simpleTypeName.equalsIgnoreCase("Boolean")) {
					value = Randomizer.nextBoolean();
				} else if (simpleTypeName.equalsIgnoreCase("Date")) {
					value = new Date();
				}
				BeanUtil.setFieldValue(object, name, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建loop个对象,并填充对象字段值.
	 */
	public static <T> List<T> populateValue(Class<T> clazz, int loop) {
		try {
			List<T> list = new ArrayList<T>();
			for (int i = 0; i < loop; i++) {
				list.add(populateValue(clazz));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

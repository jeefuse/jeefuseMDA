package com.jeefuse.base.utils.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.swing.JOptionPane;

/**
 * 使用反射分析类结构.
 * 
 * @author <a href="mailto:yonclv@gmail.com">yonclv</a>
 */
public class ClassUtil {

	public static String[] getFieldsName(Class<?> clazz){
		Field[] fields = clazz.getDeclaredFields();
		String[] fieldNames=new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			fieldNames[i]=f.getName();
		}
		return fieldNames;
	}

	/**
	 * 打印类的所有公共字段名,包括超类.
	 * 
	 * @param clazz
	 * @return
	 */
	public static void printFields(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			Class<?> type = f.getType(); // getType()返回字段的数据类型
			String name = f.getName(); // getName()返回字段名称
			// getModifiers()返回一个代表访问控制符的整数
			// Modifier.toString()将该整数转换为对应的访问控制符字符串
			String modifier = Modifier.toString(f.getModifiers());
			// type.getName()返回数据类型名称
			System.out.print(modifier + "   " + type.getName() + "   " + name+"\n");

		}
	}

	/**
	 *该方法打印方法的详细信息
	 */
	public static void printMethods(Class<?> cl)
    {
        Method[] methods = cl.getDeclaredMethods();
       
        for (int i = 0; i < methods.length; i++)
        {
            Method m = methods[i];
			Class<?> retType = m.getReturnType();
            String name = m.getName();
            String modifier = Modifier.toString(m.getModifiers());
            System.out.print(modifier+"   "+ retType.getName() +" "+ name + "(");
           
			Class<?>[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++)
            {
                if (j > 0) {
					System.out.print(", ");
				}
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

	/**
	 *打印构造器的详细信息
	 */
	public static void printConstructors(Class<?> cl)
    {
		// 定义构造器数组
		Constructor<?>[] constructors = cl.getDeclaredConstructors();
       
        for (int i = 0; i < constructors.length; i++)
        {
			// 将数组元素赋给一个构造器对象
			Constructor<?> constr = constructors[i];
			String name = constr.getName(); // 获取构造器名称
			// 打印访问修饰符
            System.out.print(Modifier.toString(constr.getModifiers()));
            System.out.print("   "+ name + "(");

			/**
			 *定义一个参数类型数组该数组是Class对象 getParameterTypes()返回该构造器参数类型的数组 打印参数类型名称
			 */
			Class<?>[] paramTypes = constr.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++)
            {
                if (j > 0) {
					System.out.print(", ");
				}
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }
    
	public static void printClass(Class<?> clazz) {
		Class<?> supercl = clazz.getSuperclass(); // 获得超类的Class对象
        System.out.println("class "+ clazz.getCanonicalName());
		// 判断超类是否为空或为Object
        if (supercl != null && supercl != Object.class) {
			System.out.println("extends "+ supercl.getName());
		}
		System.out.println("\n构造方法:\n");
		printConstructors(clazz);
		System.out.println("\n字段:\n");
		printFields(clazz);
		System.out.println("\n方法:\n");
		ClassUtil.printMethods(clazz);
    }
    
    public static void main(String[] args)
    {
		String name = ClassUtil.class.getName();
		if (null == name) {
			if (args.length > 0) {
				name = args[0];
			} else {
				name = JOptionPane.showInputDialog("输入一个类名:按(java.lang.Double)格式");
			}
		}
       
        try
        {
			Class<?> clazz = Class.forName(name);
            printClass(clazz);
        }
		// 当使用class对象时注意捕获该异常，异常为类型未创建
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
			System.out.println("类型创建失败!");
        }
        System.exit(0);
    }

}

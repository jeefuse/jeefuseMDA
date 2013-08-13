package com.jeefuse.base.exception;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * 验证工具类,验证失败抛出ApplicationException异常,该异常表明是应用程序的异常,该 异常信息显示给用户.
 * 
 * @author yonclv
 */
public abstract class AppAssert {

	/**
	 * this expression must be true.
	 */
    public static void isTrue(boolean expression, String message)
    {
        if(!expression)
			throw new InvalidParamException(message);
        else
            return;
    }

	/**
	 * this expression must be true.
	 */
    public static void isTrue(boolean expression)
    {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

	/**
	 * the object argument must be null.
	 */
    public static void isNull(Object object, String message)
    {
        if(object != null)
			throw new InvalidParamException(message);
        else
            return;
    }

	/**
	 * the object argument must be null.
	 */
    public static void isNull(Object object)
    {
        isNull(object, "[Assertion failed] - the object argument must be null");
    }

	/**
	 * this argument is required; it must not be null.
	 */
    public static void notNull(Object object, String message)
    {
        if(object == null)
			throw new InvalidParamException(message);
        else
            return;
    }

	/**
	 * this argument is required; it must not be null.
	 */
    public static void notNull(Object object)
    {
		notNull(object, " this argument is required; it must not be null");
    }

    public static void hasLength(String text, String message)
    {
        if(!StringUtils.hasLength(text))
			throw new InvalidParamException(message);
        else
            return;
    }

	/**
	 * this String argument must have length; it must not be null or empty.
	 */
    public static void hasLength(String text)
    {
		hasLength(text, " this String argument must have length; it must not be null or empty");
    }

	/**
	 * this String argument must have text; it must not be null, empty, or
	 * blank.
	 */
    public static void isNotblank(String text, String message)
    {
        if(!StringUtils.hasText(text))
			throw new InvalidParamException(message);
        else
            return;
    }

	/**
	 * this String argument must have text; it must not be null, empty, or
	 * blank.
	 */
    public static void isNotBlank(String text)
    {
		isNotblank(text, " this String argument must have text; it must not be null, empty, or blank");
    }

	/**
	 * this String argument must not contain the substring [" + substring+ "]"
	 */
    public static void doesNotContain(String textToSearch, String substring, String message)
    {
        if(StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) && textToSearch.indexOf(substring) != -1)
			throw new InvalidParamException(message);
        else
            return;
    }

	/**
	 * this String argument must not contain the substring [" + substring + "]"
	 */
    public static void doesNotContain(String textToSearch, String substring)
    {
		doesNotContain(textToSearch, substring, " this String argument must not contain the substring [" + substring
				+ "]");
    }

	/**
	 * this array must not contain any null elements.
	 */
    public static void noNullElements(Object array[], String message)
    {
        if(array != null)
        {
            for(int i = 0; i < array.length; i++)
                if(array[i] == null)
					throw new InvalidParamException(message);

        }
    }

	/**
	 * this array must not contain any null elements.
	 */
    public static void noNullElements(Object array[])
    {
		noNullElements(array, " this array must not contain any null elements");
    }

	/**
	 * this collection must not be empty: it must contain at least 1 element.
	 */
	public static void notEmpty(Collection<?> collection, String message)
    {
        if(CollectionUtils.isEmpty(collection))
			throw new InvalidParamException(message);
        else
            return;
    }

	/**
	 * this collection must not be empty: it must contain at least 1 element
	 */
	public static void notEmpty(Collection<?> collection)
    {
		notEmpty(collection, " this collection must not be empty: it must contain at least 1 element");
    }

	/**
	 * the obj must be an instance of clazz.
	 */
	public static void isInstanceOf(Class<?> clazz, Object obj)
    {
        isInstanceOf(clazz, obj, "");
    }

	/**
	 * the obj must be an instance of clazz.
	 */
	public static void isInstanceOf(Class<?> type, Object obj, String message)
    {
        notNull(type, "Type to check against must not be null");
        if(!type.isInstance(obj))
			throw new InvalidParamException(message + "Object of class ["
					+ (obj == null ? "null" : obj.getClass().getName()) + "] must be an instance of " + type);
        else
            return;
    }

	/**
	 * subType must be assignable to superType.
	 */
	public static void isAssignable(Class<?> superType, Class<?> subType)
    {
        isAssignable(superType, subType, "");
    }

	/**
	 * subType must be assignable to superType.
	 */
	public static void isAssignable(Class<?> superType, Class<?> subType, String message)
    {
        notNull(superType, "Type to check against must not be null");
        if(subType == null || !superType.isAssignableFrom(subType))
			throw new InvalidParamException(message + subType + " is not assignable to " + superType);
        else
            return;
    }

	/**
	 * this expression must be true.
	 */
    public static void state(boolean expression, String message)
    {
        if(!expression)
			throw new InvalidStateException(message);
        else
            return;
    }

	/**
	 * this expression must be true.
	 */
    public static void state(boolean expression)
    {
		state(expression, " this state invariant must be true");
    }

}

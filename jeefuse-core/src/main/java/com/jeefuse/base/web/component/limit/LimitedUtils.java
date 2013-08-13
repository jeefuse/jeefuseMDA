package com.jeefuse.base.web.component.limit;

import java.util.List;

/**
 * @author  yonclv
 * @created 2009-7-23
 */
public class LimitedUtils {
	
    /**
     * Convert the input value to a String. A String[] or List will be converted
     * to a String by using the value in the first position. In addition will
     * attempt to do a String conversion for other object types using the
     * String.valueOf() method.
     * 
     * @param value
     *            The input object to convert to a String.
     * @return The converted value.
     */
    @SuppressWarnings("unchecked")
	public static String getValue(Object value) {
        if (value instanceof Object[]) {
            if (((Object[]) value).length == 1) {
                return String.valueOf(((Object[]) value)[0]);
            }
        } else if (value instanceof List) {
            List<?> valueList = (List<?>) value;
            if (((List<?>) valueList).size() == 1) {
                return String.valueOf(((List<?>) valueList).get(0));
            }
        }

        if (value != null) {
            return String.valueOf(value);
        }

        return "";
    }
}

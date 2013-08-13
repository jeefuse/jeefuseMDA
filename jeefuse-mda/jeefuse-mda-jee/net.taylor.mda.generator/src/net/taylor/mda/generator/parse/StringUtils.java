package net.taylor.mda.generator.parse;

import java.util.Collection;
import java.util.Iterator;

public class StringUtils {
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0)
			return true;
		for (int i = 0; i < strLen; i++)
			if (!Character.isWhitespace(str.charAt(i)))
				return false;

		return true;
	}

	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}

	public static String trim(String str) {
		return str != null ? str.trim() : null;
	}

	public static String trimToNull(String str) {
		String ts = trim(str);
		return isEmpty(ts) ? null : ts;
	}

	public static String trimToEmpty(String str) {
		return str != null ? str.trim() : "";
	}

    public static String join(Collection<?> collection, String separator)
    {
        if(collection == null)
            return "";
        else
            return join(collection.iterator(), separator);
    }
    
	public static String join(Iterator<?> iterator, String separator) {
		  if(iterator == null)
	            return "";
	        if(!iterator.hasNext())
	            return "";
	        Object first = iterator.next();
	        if(!iterator.hasNext())
	            return first.toString();
	        StringBuffer buf = new StringBuffer(256);
	        if(first != null)
	            buf.append(first);
	        do
	        {
	            if(!iterator.hasNext())
	                break;
	            buf.append(separator);
	            Object obj = iterator.next();
	            if(obj != null)
	                buf.append(obj);
	        } while(true);
	        return buf.toString();
	}



}

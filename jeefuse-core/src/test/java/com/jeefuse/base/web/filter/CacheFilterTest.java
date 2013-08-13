package com.jeefuse.base.web.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import org.junit.Test;

public class CacheFilterTest {

	@Test
	public void testMain() {
		Properties prop = new Properties();
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(
				"cache/web-cache.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Pattern> patternList = new ArrayList<Pattern>();
		Enumeration keys = prop.propertyNames();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			String value = prop.getProperty(key);
			System.out.println("-----------------------value:" + value);
			patternList.add(Pattern.compile(value, Pattern.CASE_INSENSITIVE));
		}
		for (Pattern pattern : patternList) {
			if (pattern.matcher("/css/adasdafsdf/safsdf/demo.js").matches()) {
				System.out.println("-----------------------true");
			}
		}
	}

}

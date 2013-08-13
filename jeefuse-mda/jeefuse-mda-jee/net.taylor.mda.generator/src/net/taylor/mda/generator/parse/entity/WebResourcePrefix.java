package net.taylor.mda.generator.parse.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * web页面后缀规则.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public enum WebResourcePrefix {
	jsp("/WEB-INF/content"),
	js("/resources/content"),
	jsp_site("/WEB-INF/content"), 
	js_site("/resources/content");

	private WebResourcePrefix(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static List<String> toValuesList() {
		List<String> list = new ArrayList<String>();
		for (WebResourcePrefix o : WebResourcePrefix.values()) {
			list.add(o.getValue());
		}
		return list;
	}
}

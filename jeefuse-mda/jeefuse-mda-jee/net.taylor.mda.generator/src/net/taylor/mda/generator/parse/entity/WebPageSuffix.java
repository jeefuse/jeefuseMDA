package net.taylor.mda.generator.parse.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * web页面后缀规则.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public enum WebPageSuffix {
	jsp_index(".jsp"),
	jsp_manager("-manager.jsp"),
	jsp_importExcelFile("-importExcel.jsp"),
	jsp_listForSelect("-listForSelect.jsp"),
	jsp_galleryAD("-galleryAD.jsp"),
	jsp_input("-input.jsp"),
	jsp_site_list("-list.jsp"),
	jsp_site_detail("-detail.jsp"),
	js_site_list("-list.js"),
	js_site_detail("-detail.js"),
	js_input("-input.js"),
	js_listForSelect("-listForSelect.js"),
	js_manager("-manager.js"),
	js_extjs(".js");
	
	
	private WebPageSuffix(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static List<String> toValuesList(){
		List<String> list=new ArrayList<String>();
		for(WebPageSuffix o:WebPageSuffix.values()){
			list.add(o.getValue());
		}
		return list;
	}
}

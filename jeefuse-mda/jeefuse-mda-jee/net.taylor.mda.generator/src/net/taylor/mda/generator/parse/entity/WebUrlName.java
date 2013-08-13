package net.taylor.mda.generator.parse.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * url 请求命名规则.
 * @author yonclv
 * @email yonclv@gmail.com
 */
public enum WebUrlName {
	listOutJson("listOutJson")
	,listTreeOutJson("listTreeOutJson")
	,systempage_edit("edit")
	,systempage_input("input")
	,deleteOutJson("deleteOutJson")
	,deleteFileOutJson("deleteFileOutJson")
	,deleteImageOutJson("deleteImageOutJson")
	,deleteAllOutJson("deleteAllOutJson")
	,deleteOrphanOutJson("deleteOrphanOutJson")
	,deleteDescendantOutJson("deleteDescendantOutJson")
	,saveOutJson("saveOutJson")
	,updateOutJson("updateOutJson")
	,manage("manage")
	,input("input")
	,edit("edit")
	,exportExcelFile("exportExcelFile")
	,importExcelFile("importExcelFile")
	,importExcelFileProcess("importExcelFileProcess")
	,getOutJson("getOutJson")
	/********o2mManager********/
	,relO2MManage("manage")
	,listForSelect("listForSelect")
	,listForSelectOutJson("listForSelectOutJson")
	,relM2OAndO2OSelectPage("listForSelect")
	/**web site */
	,site_viewList("list")
	,site_viewDetail("detail")
	/**web maintain */
	,maintain_maintain("maintain")
	,maintain_edit("edit")
	;
	
	
	private WebUrlName(String value) {
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
		for(WebUrlName o:WebUrlName.values()){
			list.add(o.getValue());
		}
		return list;
	}
}

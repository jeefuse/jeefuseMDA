package net.taylor.mda.generator.parse;

import java.util.Iterator;
import java.util.List;

import net.taylor.mda.generator.parse.entity.EntityHelper;
import net.taylor.mda.generator.parse.page.HtmlFont;
import net.taylor.mda.generator.parse.stereotype.TreeStereotypeHelper;
import net.taylor.mda.generator.util.ClassHelper;
import net.taylor.mda.generator.util.NameHelper;

import org.eclipse.uml2.uml.Property;

public class GenHelper {

	static public boolean isContainsIgnoreCase(List<String> names,String name){
		for(String str:names){
			if(str.equalsIgnoreCase(name))
				return true;
		}
		return false;
	}
	
	public static String genEntityToStringBuilder(org.eclipse.uml2.uml.Class uml2clazz) {
		StringBuilder sb=new StringBuilder();
		String delimiter="\n";
		String tab="\t\t\t\t";
		sb.append("new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)");
		sb.append(delimiter);
		sb.append(tab);
		List<Property> listProperty=EntityHelper.getAllProperties(uml2clazz);
		for(int len=listProperty.size(),i=0;i<len;i++){
			Property property=listProperty.get(i);
			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
			if(TreeStereotypeHelper.isParentIdProperty(property)){
				sb.append("/*.append(\""+propertyUncapSafeName+"\",getParentId())*/");
			}else if(EntityHelper.isIDProperty(property)){
				//sb.append(".append(\"id\","+NameHelper.uncapSafeName(property)+")");
				sb.append(".append(\"id\",getId())");
			}else if(ClassHelper.isSimple(property)){
				sb.append(".append(\""+propertyUncapSafeName+"\","+propertyUncapSafeName+")");
			}else{
				sb.append("//.append(\""+propertyUncapSafeName+"\","+propertyUncapSafeName+")");
			}
			if((i+1)%4==0){
				sb.append(delimiter);
				sb.append(tab);
			}
		}
		sb.append(delimiter);
		sb.append(tab);
		sb.append(".toString()");
		return sb.toString();
	}
	
	public static String getFontLiteral(int count) {
		int total=HtmlFont.values().length;
		int index=count%total;
		return HtmlFont.values()[index].getColor();
	}
	
	public static String constructPostDataJsObject(List<String> list){
		if(null==list||list.isEmpty())
			return "{}";
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		for(Iterator<String> it=list.iterator();it.hasNext();){
			sb.append(it.next());
			if(it.hasNext())
				sb.append(",");
		}
		sb.append("}");
		return sb.toString();
	}

}

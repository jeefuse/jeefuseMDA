package net.taylor.mda.generator.parse.sql;

import java.util.List;

import net.taylor.mda.generator.parse.entity.EntityHelper;
import net.taylor.mda.generator.parse.stereotype.ColumnStereotypeHelper;
import net.taylor.mda.generator.parse.stereotype.JoinColumnStereotypeHelper;
import net.taylor.mda.generator.util.ClassHelper;
import net.taylor.mda.generator.util.NameHelper;

import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

public class SqlMapHelper {

	
	static public String getInsertColumn(List<Property> listProperty){
		StringBuilder sb=new StringBuilder();
		String delimiter="\n";
		String tab="\t\t";
		sb.append("(");
		sb.append(delimiter);
		sb.append(tab);
		for(int len=listProperty.size(),i=0;i<len;i++){
			Property property=listProperty.get(i);
			//String propertyUncapSafeName=NameHelper.uncapSafeName(property);
			if(i>0){
				sb.append(",");
			}
			String columnName;
			if(ClassHelper.isSimple(property)){
				columnName=ColumnStereotypeHelper.getApplyColumn_name(property);
			}else{
				columnName=JoinColumnStereotypeHelper.getApplyColumn_name(property);
			}
			sb.append(columnName);
			if((i+1)%4==0){
				sb.append(delimiter);
				sb.append(tab);
			}
		}
		sb.append(delimiter);
		sb.append(tab);
		sb.append(")");
		return sb.toString();
	}
	
	static public String getInsertColumnValue(List<Property> listProperty){
		StringBuilder sb=new StringBuilder();
		String delimiter="\n";
		String tab="\t\t";
		sb.append("(");
		sb.append(delimiter);
		sb.append(tab);
		for(int len=listProperty.size(),i=0;i<len;i++){
			Property property=listProperty.get(i);
			String propertyUncapSafeName=NameHelper.uncapSafeName(property);
			//String columnName=ColumnStereotypeHelper.getValue_name(property);
			if(i>0){
				sb.append(",");
			}
			if(ClassHelper.isOneToOne(property)||ClassHelper.isManyToOne(property)){
				Type propertyType=property.getType();
				org.eclipse.uml2.uml.Class relTargetClass=(org.eclipse.uml2.uml.Class)propertyType;
				Property propertyTypeIdProperty=EntityHelper.getIDProperty(relTargetClass);
				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
				sb.append("#"+propertyUncapSafeName+"."+propertyTypeIdPropertyUncapSafeName+"#");
			}else{
				sb.append("#"+propertyUncapSafeName+"#");
			}
			if((i+1)%4==0){
				sb.append(delimiter);
				sb.append(tab);
			}
		}
		sb.append(delimiter);
		sb.append(tab);
		sb.append(")");
		return sb.toString();
	}
}

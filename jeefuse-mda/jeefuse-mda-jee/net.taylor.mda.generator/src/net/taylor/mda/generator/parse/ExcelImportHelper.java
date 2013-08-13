package net.taylor.mda.generator.parse;

import net.taylor.mda.generator.util.TypeHelper;

import org.eclipse.uml2.uml.Type;

public class ExcelImportHelper {

	public static String getExcelCheckString(Type type) {
		try {
			if ("String".equals(type.getName()))
				return "getString";
			if ("Boolean".equals(type.getName()))
				return "getBoolean";
			if ("Date".equals(type.getName()))
				return "getDate";
			if ("Time".equals(type.getName()))
				return "getDate";
			if(TypeHelper.isDouble(type)){
				return "getDouble";
			}
			if ("Timestamp".equals(type.getName()))
				return "getDate";
			if (type.getName().equals("Currency")) {
				return "getDouble";
			}
			if (type.getName().equals("Byte[]"))
				return "getString";
			if (type.getName().equals("Percentage"))
				return "getDouble";
			if (type.getName().equals("Integer"))
				return "getInteger";
			if (type.getName().equals("Long"))
				return "getLong";
			if (type.getName().equals("Decimal"))
				return "getBigDecimal";
			if (type.getName().equals("Text"))
				return "getString";
			if (type.getName().equals("Link"))
				return "getString";
			return "getString";
		} catch (Exception e) {
			return null;
		}
	}

}

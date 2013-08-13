package com.jeefuse.base.modules.export.core;

/**
 * 导出类型.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public enum ExportType {
	EXCEL, PDF, XML, CSV;

	public String toParam() {
		switch (this) {
		case EXCEL:
			return "excel";
		case PDF:
			return "pdf";
		case XML:
			return "xml";
		case CSV:
			return "csv";
		default:
			return "";
		}
	}

	public static ExportType valueOfParam(String param) {
		for (ExportType exportType : ExportType.values()) {
			if (exportType.toParam().equals(param))
				return exportType;
		}
		return null;
	}

}

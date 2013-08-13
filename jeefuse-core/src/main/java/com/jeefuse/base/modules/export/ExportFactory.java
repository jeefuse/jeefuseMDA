package com.jeefuse.base.modules.export;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.base.modules.export.exception.UnSupportExportTypeException;

public class ExportFactory {

	/**
	 * Http导出文件. 导出类型为csv,excel,jexcel,pdf,pdfp之一.
	 * 
	 * @param request
	 *            http request
	 * @param items
	 *            导出数据集
	 * @param columnProperties
	 *            导出例
	 * @param columnTitles
	 *            导出例标题
	 * @return
	 */
	public static ExportFacade createExportFacade(HttpServletRequest request, HttpServletResponse response,
			Collection<?> items, String[] columnProperties, String[] columnTitles, String exportFileName) {
		return ExportFacade.instance(request, response, items, columnProperties, columnTitles, exportFileName);
    }

	/**
	 * Http导出文件. 导出类型为csv,excel,jexcel,pdf,pdfp之一.
	 * 
	 * @param request
	 * @param response
	 * @param items
	 * @param columnFields
	 * @param exportFileName
	 * @return
	 * @throws UnSupportExportTypeException
	 */
	public static ExportFacade createExportFacade(HttpServletRequest request, HttpServletResponse response,
			Collection<?> items, ColumnField<?>[] columnFields, String exportFileName) {
		return ExportFacade.instance(request, response, items, columnFields, exportFileName);
	}
}

package com.jeefuse.base.modules.export;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.base.model.parse.PropertyValueGet;
import com.jeefuse.base.modules.export.core.ModelExport;
import com.jeefuse.base.modules.export.exporter.cvs.HttpModelCvsExport;
import com.jeefuse.base.modules.export.exporter.excel.HttpModelExcelExport;
import com.jeefuse.base.modules.export.exporter.pdf.HttpModelPdfExport;

/**
 * 基于模型数据的导出文件工厂.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class ModelExportFactory {

	/**
	 * Http导出PDF文件.
	 * 
	 * @param <T>
	 * @param response
	 * @param exportFileName
	 *            导出文件名
	 * @param columnFields
	 *            导出字段数组
	 * @param items
	 *            导出数据例表
	 * @param propertyValueGet
	 *            模型对象属性的获取或设置
	 * @return
	 */
	public static <T> ModelExport createPdfExport(HttpServletRequest request, HttpServletResponse response,
			String exportFileName, ColumnField<T>[] columnFields, Collection<T> items,
			PropertyValueGet<T> propertyValueGet) {
		return new HttpModelPdfExport<T>(request, response, exportFileName, columnFields, items, propertyValueGet);
	}

	/**
	 * Http导出Csv文件.
	 * 
	 * @param <T>
	 * @param response
	 * @param exportFileName
	 *            导出文件名
	 * @param columnFields
	 *            导出字段数组
	 * @param items
	 *            导出数据例表
	 * @param propertyValueGet
	 *            模型对象属性的获取或设置
	 * @return
	 */
	public static <T> ModelExport createCsvExport(HttpServletResponse response, String exportFileName,
			ColumnField<T>[] columnFields, Collection<T> items, PropertyValueGet<T> propertyValueGet) {
		return new HttpModelCvsExport<T>(response, exportFileName, columnFields, items, propertyValueGet);
	}

	/**
	 * Http导出Excel文件.
	 * 
	 * @param <T>
	 * @param response
	 * @param exportFileName
	 *            导出文件名
	 * @param columnFields
	 *            导出字段数组
	 * @param items
	 *            导出数据例表
	 * @param propertyValueGet
	 *            模型对象属性的获取或设置
	 * @return
	 */
	public static <T> ModelExport createExcelExport(HttpServletResponse response, String exportFileName,
			ColumnField<T>[] columnFields, Collection<T> items, PropertyValueGet<T> propertyValueGet) {
		return new HttpModelExcelExport<T>(response, exportFileName, columnFields, items, propertyValueGet);
	}

}

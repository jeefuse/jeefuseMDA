package com.jeefuse.base.modules.imports;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.base.modules.export.exporter.excel.ExcelHeaderView;

public class ModelImportFactory {

	/**
	 * 获取excel导入模板流.
	 * 
	 * @param os
	 *            输出流
	 * @param columnFields
	 *            excel 显示的字段
	 * @param caption
	 *            excel sheet 标题
	 * @throws IOException
	 */
	public static void outExcelImportTemplateStream(OutputStream os, ColumnField<?>[] columnFields, String caption)
			throws IOException {
		ExcelHeaderView view = new ExcelHeaderView(columnFields, caption);
		HSSFWorkbook workbook = (HSSFWorkbook) view.render();
		workbook.write(os);
	}


}

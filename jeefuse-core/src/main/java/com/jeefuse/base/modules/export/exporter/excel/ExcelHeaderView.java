package com.jeefuse.base.modules.export.exporter.excel;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import com.jeefuse.base.model.parse.ColumnField;

public class ExcelHeaderView {

	private ColumnField<?>[] columnFields;
	private String caption;

	public ExcelHeaderView(ColumnField<?>[] columnFields, String caption) {
		this.columnFields = columnFields;
		this.caption = caption;
	}

	public byte[] getBytes() {
		HSSFWorkbook render = (HSSFWorkbook) render();
		return render.getBytes();
	}

	public Workbook render() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		if (StringUtils.isEmpty(caption)) {
			caption = "Export Data";
		}
		HSSFSheet sheet = workbook.createSheet(caption);

		// renderer header
		HSSFRow hssfRow = sheet.createRow(0);
		int columncount = 0;
		for (ColumnField<?> col : columnFields) {
			HSSFCell cell = hssfRow.createCell(columncount++);
			cell.setCellValue(new HSSFRichTextString(col.getFieldLabel()));
		}
		return workbook;
	}

}

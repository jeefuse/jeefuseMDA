package com.jeefuse.base.modules.imports.excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.jeefuse.base.exception.ApplicationException;
import com.jeefuse.base.modules.imports.ModelImport;
import com.jeefuse.base.modules.imports.excel.utils.ExcelCheck;

public abstract class AbstractExcelImport<T> implements ModelImport<T> {
	private Workbook wb = null;

	public AbstractExcelImport(InputStream is) throws IOException {
		this.wb = new HSSFWorkbook(is);
		is.close();
	}

	public List<T> importToModel() {
		List<T> list = new ArrayList<T>();
		try {

			Sheet sheet = wb.getSheetAt(0);
			Row headerRow = sheet.getRow(0);
			String[] columnNames = getRowHearderName(headerRow);
			int rowCount = sheet.getLastRowNum();
			for (int i = 1; i <= rowCount; i++) {
				list.add(readExcelToModel(sheet.getRow(i), columnNames));
			}
			return list;
		} catch (Exception e) {
			throw new ApplicationException("导入出现错误:\n" + e.getMessage(), e);
		}
	}

	private String[] getRowHearderName(Row row) {
		int cellLenght = row.getLastCellNum();
		String[] columnNames = new String[cellLenght];
		Cell cell = null;
		for (int i = 0; i < cellLenght; i++) {
			cell = row.getCell(i);
			columnNames[i] = ExcelCheck.getString(cell);
			if (StringUtils.isBlank(columnNames[i]))
				throw new ApplicationException("例名不能为空:第" + (cell.getRowIndex() + 1) + "行,"
						+ (cell.getColumnIndex() + 1) + "例);");
		}
		return columnNames;
	}

	/**
	 * 读取Excel中的行记录到对象.
	 * 
	 * @return
	 */
	protected abstract T readExcelToModel(Row row, String[] columnNames);
}

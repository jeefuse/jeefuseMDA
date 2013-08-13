package com.jeefuse.base.modules.imports.excel.utils;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.jeefuse.base.exception.InvalidDataException;
import com.jeefuse.base.modules.imports.excel.exception.ExcelCheckException;
import com.jeefuse.base.utils.common.DateUtil;

/**
 * excel 导入数据检查工具类.
 * 
 * 
 * @author <a href="mailto:yonclv@gmail.com">yonclv</a>
 */
public class ExcelCheck {

	public static boolean isNull(Cell cell) {
		if (null == cell)
			return true;
		return false;
	}

	public static boolean isBlank(Cell cell) {
		if (null == cell)
			return true;
		if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
			return true;
		if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			return StringUtils.isBlank(cell.getStringCellValue());
		return false;
	}

	public static void checkColumnMatch(Row row, int columNum) {
		if (null == row)
			throw new InvalidDataException("数据单元格必需为'" + columNum + "'例!");
		int cellCount = row.getLastCellNum();
		if (cellCount != columNum)
			throw new InvalidDataException("数据单元格必需为'" + columNum + "'例!");
	}

	public static void checkNoNull(Cell cell) throws ExcelCheckException {
		if (null == cell)
			throw new InvalidDataException("存在为空的单元格,请检查!");
	}

	public static void checkBlank(Cell cell) throws ExcelCheckException {
		checkNoNull(cell);
		if (cell.getCellType() != Cell.CELL_TYPE_BLANK)
			throw new InvalidDataException("第" + (cell.getRowIndex() + 1) + "行,"
					+ (cell.getColumnIndex() + 1) + "例输入错误!该项保留为空!");
	}

	public static void checkBoolean(Cell cell) throws ExcelCheckException {
		checkNoNull(cell);
		if (cell.getCellType() != Cell.CELL_TYPE_BOOLEAN)
			throw new InvalidDataException("第" + (cell.getRowIndex() + 1) + "行,"
					+ (cell.getColumnIndex() + 1) + "例输入错误!该项需输入true或false!");
	}

	public static void checkString(Cell cell) throws ExcelCheckException {
		if (cell.getCellType() != Cell.CELL_TYPE_STRING)
			throw new InvalidDataException("第" + (cell.getRowIndex() + 1) + "行,"
					+ (cell.getColumnIndex() + 1) + "例:输入错误!该项需输入字符数据!");
	}

	public static void checkFormula(Cell cell) throws ExcelCheckException {
		checkNoNull(cell);
		if (cell.getCellType() != Cell.CELL_TYPE_FORMULA)
			throw new InvalidDataException("第" + (cell.getRowIndex() + 1) + "行,"
					+ (cell.getColumnIndex() + 1) + "例输入错误!该项需输入公式!");
	}

	public static void checkNumeric(Cell cell) throws ExcelCheckException {
		checkNoNull(cell);
		if (cell.getCellType() != Cell.CELL_TYPE_NUMERIC)
			throw new InvalidDataException("第" + (cell.getRowIndex() + 1) + "行,"
					+ (cell.getColumnIndex() + 1) + "例输入错误!该项需输入数字!");
	}

	public static void checkError(Cell cell) throws ExcelCheckException {
		checkNoNull(cell);
		if (cell.getCellType() != Cell.CELL_TYPE_ERROR)
			throw new InvalidDataException("第" + (cell.getRowIndex() + 1) + "行,"
					+ (cell.getColumnIndex() + 1) + "例输入错误!" + cell.getErrorCellValue());
	}

	public static String getString(Cell cell) {
		if (isBlank(cell))
			return null;
		checkString(cell);
		return cell.getStringCellValue();
	}

	public static String getString(Cell cell, String defaultValue) {
		if (isBlank(cell))
			return defaultValue;
		checkString(cell);
		return cell.getStringCellValue();
	}

	public static boolean getBoolean(Cell cell) {
		if (isBlank(cell))
			return false;
		checkBoolean(cell);
		return cell.getBooleanCellValue();
	}

	public static boolean getBoolean(Cell cell, boolean defaultValue) {
		if (isBlank(cell))
			return defaultValue;
		checkBoolean(cell);
		return cell.getBooleanCellValue();
	}

	public static Double getDouble(Cell cell) {
		if (isBlank(cell))
			return null;
		checkNumeric(cell);
		return cell.getNumericCellValue();
	}

	public static Double getDouble(Cell cell, Double defaultValue) {
		if (isBlank(cell))
			return defaultValue;
		checkNumeric(cell);
		return cell.getNumericCellValue();
	}

	public static BigDecimal getBigDecimal(Cell cell) {
		if (isBlank(cell))
			return null;
		Double d = getDouble(cell);
		return BigDecimal.valueOf(d);
	}

	public static BigDecimal getBigDecimal(Cell cell, BigDecimal defaultValue) {
		if (isBlank(cell))
			return defaultValue;
		Double d = getDouble(cell);
		return BigDecimal.valueOf(d);
	}

	public static Integer getInteger(Cell cell) {
		if (isBlank(cell))
			return null;
		Double d = getDouble(cell);
		return d.intValue();
	}
	
	public static Integer getInteger(Cell cell, Integer defaultValue) {
		if (isBlank(cell))
			return defaultValue;
		Double d = getDouble(cell);
		return d.intValue();
	}
	
	public static Long getLong(Cell cell) {
		if (isBlank(cell))
			return null;
		Double d = getDouble(cell);
		return d.longValue();
	}

	public static Date getDate(Cell cell) throws InvalidDataException {
		if (isBlank(cell))
			return null;
		if (cell.getCellType() != Cell.CELL_TYPE_STRING)
			throw new InvalidDataException("第" + (cell.getRowIndex() + 1) + "行," + (cell.getColumnIndex() + 1)
					+ "该项需要输入正确的日期格式!如:2088-01-10 01:11:12");
		try {
			String cellString = cell.getStringCellValue();
			String[] dataTimes = StringUtils.split(cellString, " ");
			if (dataTimes.length > 1) {
				String[] minis = StringUtils.split(dataTimes[1], ".");
				if(minis.length>1)
					return DateUtil.parseDate(cellString, "yyyy-MM-dd HH:mm:ss.SSS");
				String[] times = StringUtils.split(minis[0], ":");
				switch (times.length) {
				case 1:
					return DateUtil.parseDate(cellString, "yyyy-MM-dd HH");
				case 2:
					return DateUtil.parseDate(cellString, "yyyy-MM-dd HH:mm");
				case 3:
					return DateUtil.parseDate(cellString, "yyyy-MM-dd HH:mm:ss");
				}
			}
			return DateUtil.parseDate(cellString, "yyyy-MM-dd");
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidDataException("第" + (cell.getRowIndex() + 1) + "行," + (cell.getColumnIndex() + 1)
					+ "该项需要输入正确的日期格式!如:2088-01-10 01:11:12");
		}
	}

}

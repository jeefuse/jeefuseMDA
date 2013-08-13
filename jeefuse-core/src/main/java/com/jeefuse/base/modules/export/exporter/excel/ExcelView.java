package com.jeefuse.base.modules.export.exporter.excel;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jmesa.view.component.Column;
import org.jmesa.view.component.Row;
import org.jmesa.view.component.Table;

import com.jeefuse.base.modules.export.view.BaseView;

public class ExcelView extends BaseView{
	private final static int defaultColumnWidth = 20;



    public ExcelView(Table table, Collection<?> items) {
		super(table, items);
	}

	public byte[] getBytes() {
        HSSFWorkbook render = (HSSFWorkbook) render();
        return render.getBytes();
    }

    public Object render() {
		HSSFWorkbook wb = new HSSFWorkbook();
        Table table = this.getTable();
        String caption = table.getCaption();
        if (StringUtils.isEmpty(caption)) {
            caption = "Export Data";
        }
		// create sheet
		HSSFSheet sheet = wb.createSheet(caption);
		sheet.setDefaultColumnWidth(defaultColumnWidth);
		// sheet.setHorizontalyonclventer(true);

		// set default style
		// HSSFFont hf = wb.createFont();
		// hf.setColor((short) 4); // 1:白色,2:红色,3:绿色,4:蓝色,5:黄色,6:紫色
		// HSSFCellStyle defaultStyle = wb.createCellStyle();
		// defaultStyle.setBorderBottom((short) 1); // 设置边框线
		// defaultStyle.setBorderLeft((short) 1);
		// defaultStyle.setBorderRight((short) 1);
		// defaultStyle.setBorderTop((short) 1);
		// defaultStyle.setFont(hf);
		// sheet.setDefaultColumnStyle(0, defaultStyle);

		// create row header
        Row row = table.getRow();
        row.getRowRenderer();
        List<Column> columns = table.getRow().getColumns();
        HSSFRow hssfRow = sheet.createRow(0);
        int columncount = 0;
        for (Column col : columns) {
            HSSFCell cell = hssfRow.createCell(columncount++);
            cell.setCellValue(new HSSFRichTextString(col.getTitle()));
        }

		// create row body
        Collection<?> items = getItems();
        int rowcount = 1;
        for (Object item : items) {
            HSSFRow r = sheet.createRow(rowcount++);
            columncount = 0;
            for (Column col : columns) {
                HSSFCell cell = r.createCell(columncount++);
                Object value = col.getCellRenderer().render(item, rowcount);
                if (value == null) {
                    value = "";
                }

                if (value instanceof Number) {
                    Double number = Double.valueOf(value.toString());
                    cell.setCellValue(number);
                } else {
                    cell.setCellValue(new HSSFRichTextString(value.toString()));
                }
            }
        }
		return wb;
    }
}

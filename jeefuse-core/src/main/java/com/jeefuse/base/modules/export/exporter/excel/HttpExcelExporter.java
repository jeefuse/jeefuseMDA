package com.jeefuse.base.modules.export.exporter.excel;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jmesa.view.View;

import com.jeefuse.base.modules.export.exporter.AbstractHttpExporter;

public class HttpExcelExporter extends AbstractHttpExporter {

	public HttpExcelExporter(View view, HttpServletResponse response) {
		super(view, response);
	}

	public HttpExcelExporter(View view, HttpServletResponse response, String fileName) {
		super(view, response, fileName);
	}

	public void export() throws Exception {
		HSSFWorkbook workbook = (HSSFWorkbook) this.getView().render();
		responseHeaders();
		workbook.write(response.getOutputStream());
	}

	@Override
	public String getContextType() {
		return "application/vnd.ms-excel;charset=UTF-8";
	}

	@Override
	public String getExtensionName() {
		return "xls";
	}
}

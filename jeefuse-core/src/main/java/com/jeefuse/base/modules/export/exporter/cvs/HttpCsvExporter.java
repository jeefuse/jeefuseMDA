package com.jeefuse.base.modules.export.exporter.cvs;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.jmesa.view.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeefuse.base.modules.export.exporter.AbstractHttpExporter;

public class HttpCsvExporter extends AbstractHttpExporter {
	private Logger logger = LoggerFactory.getLogger(HttpCsvExporter.class);
	
	public HttpCsvExporter(View view, HttpServletResponse response) {
		super(view, response);
	}

	public HttpCsvExporter(View view, HttpServletResponse response, String fileName) {
		super(view, response, fileName);
	}

	public void export() throws Exception {
		ServletOutputStream outputStream = null;
		try {
			outputStream = getResponse().getOutputStream();
			responseHeaders();
			byte[] contents = getView().getBytes();
			outputStream.write(contents);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			logger.error("export error:" + e.getMessage(), e);
		} finally {
			if (null != outputStream) {
				outputStream.close();
			}
		}
	}

	@Override
	public String getContextType() {
		return "text/csv;charset=UTF-8";
	}

	@Override
	public String getExtensionName() {
		return "txt";
	}
}

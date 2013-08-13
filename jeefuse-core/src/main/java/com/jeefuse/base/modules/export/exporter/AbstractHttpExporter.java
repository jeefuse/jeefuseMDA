package com.jeefuse.base.modules.export.exporter;

import javax.servlet.http.HttpServletResponse;

import org.jmesa.util.ExportUtils;
import org.jmesa.view.View;
import org.jmesa.view.ViewExporter;

import com.jeefuse.base.utils.charset.EncodeUtil;

public abstract class AbstractHttpExporter implements ViewExporter {
	private View view;
	private String fileName;
	protected HttpServletResponse response;

	public AbstractHttpExporter(View view, HttpServletResponse response) {
		this(view, response, null);
	}

	public AbstractHttpExporter(View view, HttpServletResponse response, String fileName) {
		this.view = view;
		this.response = response;
		this.fileName = fileName;
		if (fileName == null) {
			this.fileName = ExportUtils.exportFileName(view, getExtensionName());
		}
	}

	public void responseHeaders() throws Exception {
		response.setContentType(getContextType());
		response.setCharacterEncoding("UTF-8");
		if (-1 == fileName.indexOf(".")) {
			fileName = fileName + "." + getExtensionName();
		}
		String downLoadfileName = fileName;
		try {
			downLoadfileName = EncodeUtil.toUtf8String(fileName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename=\"" + downLoadfileName + "\"");
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "public");
		response.setDateHeader("Expires", (System.currentTimeMillis() + 3000));
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	protected HttpServletResponse getResponse() {
		return response;
	}

	public abstract String getContextType();

	public abstract String getExtensionName();

}

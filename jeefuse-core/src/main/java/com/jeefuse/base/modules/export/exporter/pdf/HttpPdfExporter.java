package com.jeefuse.base.modules.export.exporter.pdf;

import java.io.ByteArrayInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jmesa.view.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.resource.FSEntityResolver;
import org.xhtmlrenderer.util.XRLog;

import com.jeefuse.base.modules.export.exporter.AbstractHttpExporter;

public class HttpPdfExporter extends AbstractHttpExporter{
	 private Logger logger = LoggerFactory.getLogger(HttpPdfExporter.class);
	 private HttpServletRequest request;

	    public HttpPdfExporter(View view, HttpServletRequest request, HttpServletResponse response) {
	        super(view, response);
	        this.request = request;
	    }

	    public HttpPdfExporter(View view,HttpServletRequest request, HttpServletResponse response, String fileName) {
	        super(view, response, fileName);
	        this.request = request;
	    }

	    public void export() throws Exception {
	    	ServletOutputStream outputStream=null;
	    	try{
	    	outputStream= getResponse().getOutputStream();
	        byte[] contents = getView().getBytes();
			responseHeaders();
	        System.setProperty("xr.util-logging.loggingEnabled", "false");
	        System.setProperty("xr.util-logging.java.util.logging.ConsoleHandler.level", "WARN");
	        System.setProperty("xr.util-logging..level", "WARN");
	        System.setProperty("xr.util-logging.plumbing.level", "WARN");
	        System.setProperty("xr.util-logging.plumbing.config.level", "WARN");
	        System.setProperty("xr.util-logging.plumbing.exception.level", "WARN");
	        System.setProperty("xr.util-logging.plumbing.general.level", "WARN");
	        System.setProperty("xr.util-logging.plumbing.init.level", "WARN");
	        System.setProperty("xr.util-logging.plumbing.load.level", "WARN");
	        System.setProperty("xr.util-logging.plumbing.load.xml-entities.level", "WARN");
	        System.setProperty("xr.util-logging.plumbing.match.level", "WARN");
	        System.setProperty("xr.util-logging.plumbing.cascade.level", "WARN");
	        System.setProperty("xr.util-logging.plumbing.css-parse.level", "WARN");
	        System.setProperty("xr.util-logging.plumbing.layout.level", "WARN");
	        System.setProperty("xr.util-logging.plumbing.render.level", "WARN");

	        XRLog.setLoggingEnabled(false);

	        ITextRenderer renderer = new ITextRenderer();

	        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	        FSEntityResolver er= FSEntityResolver.instance();
	        builder.setEntityResolver(er);
	        Document doc = builder.parse(new ByteArrayInputStream(contents));

	        renderer.setDocument(doc, getBaseUrl());
	        renderer.layout();
	
	        renderer.createPDF(outputStream);
	        outputStream.close();
		} catch (Exception e) {
			logger.error("export error:" + e.getMessage(),e);
		} finally {
			if (null != outputStream) {
				outputStream.close();
			}
		}
	    }

	    /**
	     * @return The base url to the web application.
	     */
	    private String getBaseUrl() {
	        if (request != null)
				return request.getRequestURL().toString();
	        return null;
	    }

	    @Override
	    public String getContextType() {
	        return "application/pdf;charset=UTF-8";
	    }

	    @Override
	    public String getExtensionName() {
	        return "pdf";
	    }
}

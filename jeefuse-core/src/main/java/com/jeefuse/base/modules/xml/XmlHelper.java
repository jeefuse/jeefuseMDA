package com.jeefuse.base.modules.xml;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.impl.Constants;

/**
 * 基于dom4j的xml基本操作工具类.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class XmlHelper {

	/**
	 * 将document内容转为String.
	 * 
	 * @param document
	 *            需要转化的document对象
	 * @throws IOException
	 */
	public static String docToString(Document document) throws IOException {
		String s = "";
		XMLWriter writer = null;
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			OutputFormat format = new OutputFormat("  ", true, "UTF-8");
			writer = new XMLWriter(out, format);
			writer.write(document);
			s = out.toString("GB2312");
		} finally {
			if (null != writer) {
				try {
					writer.close();
				} catch (Exception e) {

				}
			}
		}
		return s;
	}

	/**
	 * 将字符串转为Document.
	 * 
	 * @param s
	 *            xml格式的字符串
	 * @return
	 * @throws DocumentException
	 */
	public static Document stringToDoc(String s) throws DocumentException {
		Document doc = DocumentHelper.parseText(s);
		return doc;
	}

	/**
	 * 将Document对象保存为一个xml文件.
	 * 
	 * @param document
	 *            需要保存的document对象
	 * @param filename
	 *            保存的文件名
	 * @param encoding
	 *            格式 默认为UTF-8格式
	 * @throws IOException
	 */
	public static void docToXmlFile(Document document, String filename, String encoding) throws IOException {
		XMLWriter writer = null;
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			if (null != encoding) {
				format.setEncoding(encoding);
			} else {
				format.setEncoding("UTF-8");
			}
			writer = new XMLWriter(new FileWriter(new File(filename)), format);
			writer.write(document);
			writer.close();
		} finally {
			if (null != writer) {
				try {
					writer.close();
				} catch (Exception e) {

				}
			}
		}
	}

	/**
	 * 将xml格式的字符串保存为本地文件，如果字符串格式不符合xml规则，则返回失败.
	 * 
	 * @param str
	 *            需要保存的字符串
	 * @param filename
	 *            保存的文件名
	 * @param encoding
	 *            encode 默认为UTF-8格式
	 * @return true:保存成功 flase:失败
	 */
	public static void stringToXmlFile(String str, String filename, String encoding) throws DocumentException,
			IOException {
		Document doc = DocumentHelper.parseText(str);
		docToXmlFile(doc, filename, encoding);
	}

	/**
	 * 载入一个xml文档.
	 * 
	 * @param filename
	 *            文件路径
	 * @return 成功返回Document对象，失败返回null
	 * @throws DocumentException
	 */
	public static Document read(String filename) throws DocumentException {
		Document document = null;
		SAXReader saxReader = new SAXReader();
		document = saxReader.read(new File(filename));
		return document;
	}

	/**
	 * 载入一个xml文档.
	 * 
	 * @param file
	 *            文件
	 * @return 成功返回Document对象
	 * @throws DocumentException
	 * @throws SAXException
	 */
	public static Document read(File file) throws DocumentException, SAXException {
		Document document = null;
		SAXReader saxReader = new SAXReader();
		saxReader.setFeature(Constants.XERCES_FEATURE_PREFIX + Constants.LOAD_EXTERNAL_DTD_FEATURE, false);
		document = saxReader.read(file);
		return document;
	}
}

package com.jeefuse.base.web.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.record.formula.functions.T;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeefuse.base.modules.flexgrid.FlexiGridModel;
import com.jeefuse.base.modules.flexgrid.FlexiGridModelFactory;
import com.jeefuse.base.modules.json.JsonUtil;
import com.jeefuse.base.modules.json.JsonWriter;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.result.ResultMsg;

/**
 * 直接输出工具类.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class RenderUtil {
	private final static Logger logger = LoggerFactory.getLogger(RenderUtil.class);
	// -- header 常量定义 --//
	private static final String HEADER_ENCODING = "encoding";
	private static final String HEADER_NOCACHE = "no-cache";
	private static final String DEFAULT_ENCODING = "UTF-8";
	private static final boolean DEFAULT_NOCACHE = true;

	// -- content-type 常量定义 --//
	private static final String TEXT_TYPE = "text/plain";
	private static final String JSON_TYPE = "application/json";
	private static final String XML_TYPE = "text/xml";
	private static final String HTML_TYPE = "text/html";

	// 数据常量定义
	private static final String NOLOGIN_MSG = "您还未登录或当前会话已过期!请您登录后操作.谢谢!";

	/**
	 * 分析并设置contentType与headers.
	 */
	private static HttpServletResponse initResponse(final String contentType, final String... headers) {
		// 分析headers参数
		String encoding = DEFAULT_ENCODING;
		boolean noCache = DEFAULT_NOCACHE;
		for (String header : headers) {
			String headerName = StringUtils.substringBefore(header, ":");
			String headerValue = StringUtils.substringAfter(header, ":");

			if (StringUtils.equalsIgnoreCase(headerName, HEADER_ENCODING)) {
				encoding = headerValue;
			} else if (StringUtils.equalsIgnoreCase(headerName, HEADER_NOCACHE)) {
				noCache = Boolean.parseBoolean(headerValue);
			} else
				throw new IllegalArgumentException(headerName + "不是一个合法的header类型");
		}

		HttpServletResponse response = ServletActionContext.getResponse();

		// 设置headers参数
		String fullContentType = contentType + ";charset=" + encoding;
		response.setContentType(fullContentType);
		if (noCache) {
			response.setDateHeader("Expires", 0L);
			response.setHeader("Cache-Control", "no-cache");
		}
		return response;
	}

	/**
	 * 取得HttpSession的简化函数.
	 */
	public static HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	/**
	 * 取得HttpRequest的简化函数.
	 */
	public static HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * 取得HttpResponse的简化函数.
	 */
	public static HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * 取得Request Parameter的简化方法.
	 */
	public static String getParameter(String name) {
		return getRequest().getParameter(name);
	}

	/**
	 * 直接输出内容的简便函数.
	 * 
	 * eg. render("text/plain", "hello", "encoding:GBK"); render("text/plain",
	 * "hello", "no-cache:false"); render("text/plain", "hello", "encoding:GBK",
	 * "no-cache:false");
	 * 
	 * @param headers
	 *            可变的header数组，目前接受的值为"encoding:"或"no-cache:",默认值分别为UTF-8和true.
	 */
	public static void render(final String contentType, final String content, final String... headers) {
		HttpServletResponse response = initResponse(contentType, headers);
		try {
			response.getWriter().write(content);
			if (logger.isDebugEnabled()) {
				logger.debug("response type[" + contentType + "] data:\n" + content);
			}
			response.getWriter().flush();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * 直接输出文本.
	 * 
	 * @see #render(String, String, String...)
	 */
	public static void renderText(final String text) {
		render(TEXT_TYPE, text);
	}

	/**
	 * 直接输出HTML.
	 * 
	 * @see #render(String, String, String...)
	 */
	public static void renderHtml(final String html) {
		render(HTML_TYPE, html);
	}

	/**
	 * 直接输出JSON String ,contentType:html 使用Jackson转换Java对象.
	 * 
	 * @param data
	 *            可以是List<POJO>, POJO[], POJO, 也可以Map名值对.
	 * @see #render(String, String, String...)
	 */
	public static void renderHtml(final Object data) {
		String jsonString = "";
		try {
			StringWriter stringWriter = new StringWriter();
			JsonUtil.mapper.writeValue(stringWriter, data);
			jsonString = stringWriter.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		renderHtml(jsonString);
	}

	/**
	 * 直接输出JSON String ,contentType:html,使用JsonWriter构造输出对象.
	 */
	public static void renderHtml(JsonWriter jsonWriter) {
		String jsonString = "";
		try {
			StringWriter stringWriter = new StringWriter();
			jsonWriter.writeJson(stringWriter);
			jsonString = stringWriter.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		renderHtml(jsonString);
	}

	/**
	 * 直接输出JSON,返回ResultMsg对象.
	 * 
	 * @param success
	 *            是否成功
	 * @param data
	 *            返回数据
	 * @param msg
	 *            返回信息
	 */
	@SuppressWarnings("hiding")
	public static <T> void renderHtmlResultMsg(boolean success, T data, String msg) {
		ResultMsg<T> result = new ResultMsg<T>();
		result.setSuccess(success);
		result.setData(data);
		result.setMessage(msg);
		renderHtml(result);
	}

	
	/**
	 * 直接输出JSON text ,contentType:html操作成功.
	 */
	public static void renderHtmlResultMsgSuccess(String msg) {
		renderHtmlResultMsg(true, null, msg);
	}

	/**
	 * 直接输出JSON text ,contentType:html操作成功.
	 */
	public static void renderHtmlResultMsgNoLogin() {
		renderHtmlResultMsg(false, null, NOLOGIN_MSG);
	}

	/**
	 * 直接输出JSON text ,contentType:html操作失败.
	 */
	public static void renderHtmlResultMsgError(String msg) {
		renderHtmlResultMsg(false, null, msg);
	}

	/**
	 * 直接输出JSON text ,contentType:html操作失败.
	 */
	public static void renderHtmlResultMsgError() {
		final String msg = "操作失败!";
		renderHtmlResultMsg(false, null, msg);
	}

	/**
	 * 直接输出XML.
	 * 
	 * @see #render(String, String, String...)
	 */
	public static void renderXml(final String xml) {
		render(XML_TYPE, xml);
	}

	/**
	 * 直接输出JSON.
	 * 
	 * @param jsonString
	 *            json字符串.
	 * @see #render(String, String, String...)
	 */
	public static void renderJson(final String jsonString) {
		render(JSON_TYPE, jsonString);
	}

	/**
	 * 直接输出JSON,使用Jackson转换Java对象.
	 * 
	 * @param data
	 *            可以是List<POJO>, POJO[], POJO, 也可以Map名值对.
	 * @see #render(String, String, String...)
	 */
	public static void renderJson(final Object data) {
		String jsonString = "";
		try {
			jsonString = JsonUtil.mapper.writeValueAsString(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		render(JSON_TYPE, jsonString);
	}

	/**
	 * 直接输出JSON,使用JsonWriter构造输出对象.
	 */
	public static void renderJson(JsonWriter jsonWriter) {
		String jsonString = "";
		try {
			StringWriter stringWriter = new StringWriter();
			jsonWriter.writeJson(stringWriter);
			jsonString = stringWriter.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		render(JSON_TYPE, jsonString);
	}

	@SuppressWarnings("hiding")
	public static <T> void renderHtmlNoLogin() {
		String str = NOLOGIN_MSG;
		ResultMsg<T> result = new ResultMsg<T>();
		result.setSuccess(false);
		result.setMessage(str);
		result.setUnlogin(true);
		renderHtml(result);
	}

	/**
	 * 直接输出JSON,返回ResultMsg对象.
	 * 
	 * @param success
	 *            是否成功
	 * @param data
	 *            返回数据
	 * @param msg
	 *            返回信息
	 */
	@SuppressWarnings("hiding")
	public static <T> void renderJsonResultMsg(boolean success, T data, String msg) {
		ResultMsg<T> result = new ResultMsg<T>();
		result.setSuccess(success);
		result.setData(data);
		result.setMessage(msg);
		renderJson(result);
	}

	/**
	 * 直接输出JSON,返回ResultMsg对象,提示会话长时间没有操作信息.
	 */
	public static void renderJsonNoLogin() {
		String str = NOLOGIN_MSG;
		ResultMsg<T> result = new ResultMsg<T>();
		result.setSuccess(false);
		result.setMessage(str);
		result.setUnlogin(true);
		renderJson(result);
	}

	/**
	 * 直接输出JSON,操作成功.
	 */
	public static void renderJsonResultMsgSuccess() {
		final String msg = "操作成功!";
		renderJsonResultMsg(true, null, msg);
	}

	/**
	 * 直接输出JSON,操作成功.
	 */
	public static void renderJsonResultMsgSuccess(String msg) {
		renderJsonResultMsg(true, null, msg);
	}

	/**
	 * 直接输出JSON,操作失败.
	 */
	public static void renderJsonResultMsgError() {
		final String msg = "操作失败!";
		renderJsonResultMsg(false, null, msg);
	}

	/**
	 * 直接输出JSON,操作失败.
	 */
	public static void renderJsonResultMsgError(String msg) {
		renderJsonResultMsg(false, null, msg);
	}

	/**
	 * 输出flexGrid格式json数据.
	 */
	public static void renderJsonFlexGrid(Page<?> page) {
		FlexiGridModel model = FlexiGridModelFactory.createFlexiGridModel(page.getPageNo(), page.getTotalCount(), page.getResult());
		renderJson(model);
	}

	/**
	 * 输出flexGrid格式json数据.
	 */
	public static void renderJsonFlexGrid(int pageNo, int totalCount, List<?> result) {
		FlexiGridModel model = FlexiGridModelFactory.createFlexiGridModel(pageNo, totalCount, result);
		renderJson(model);
	}
}

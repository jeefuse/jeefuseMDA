package com.jeefuse.base.web.utils;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * web context utils.
 * 
 * @author yonclv
 * @created 2009-8-13
 */
public class WebContextUtil {


	public static String getRequestURI(HttpServletRequest request) {
		return request.getRequestURI();
	}

	public static String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

	/**
	 * 获取上下文访问路径.添加项目上下文，如站内地址是"/site/index.html",context是"/jeefuse", 则最终结果是
	 * "/jeefuse/site/index.html"
	 * 
	 * @param requestUri
	 *            相对于项目上下文访问路径.
	 * @return
	 */
	public static String getContextUrl(HttpServletRequest request, String requestUri) {
		if (StringUtils.isBlank(requestUri))
			return "#";
		if (isUrl(requestUri))
			return requestUri;
		String contextPath = getContextPath(request);
		if (null == contextPath)
			return requestUri;
		if (StringUtils.startsWith(requestUri, "/"))
			return contextPath + requestUri;
		return contextPath + "/" + requestUri;
	}

	/**
	 * 获取上下文访问路径.
	 * 
	 * @param requestUri
	 *            相对于项目上下文访问路径.
	 * @param params
	 *            参数
	 * @return
	 */
	public static String getContexUrlWithParams(HttpServletRequest request, String requestUri, Map<String, String> params) {
		if (StringUtils.isBlank(requestUri))
			return "/";
		StringBuilder sb = new StringBuilder();
		sb.append(requestUri);
		if (null != params && !params.isEmpty()) {
			if (-1 == requestUri.indexOf("?")) {
				sb.append("?");
			}
			Iterator<String> keyIt = params.keySet().iterator();
			while (keyIt.hasNext()) {
				String key = keyIt.next();
				sb.append(key).append("=").append(params.get(key));
				if (keyIt.hasNext()) {
					sb.append("&");
				}
			}
		}
		return getContextUrl(request, sb.toString());
	}

	/**
	 * 获取完整的URL.
	 * 
	 * @return
	 */
	public static String getFullUrl(HttpServletRequest request) {
		String scheme = request.getScheme();
		String serverPort = String.valueOf(request.getServerPort());
		String serverName = request.getServerName();
		String contextPath = request.getContextPath();
		StringBuilder sb = new StringBuilder(60);
		sb.append(scheme).append("://").append(serverName).append(":").append(serverPort);
		sb.append(contextPath);
		return sb.toString();
	}

	/**
	 * 获取完整的URL.
	 * 
	 * @param requestUri
	 *            相对于项目的访问路径
	 * @return
	 */
	public static String getFullUrl(HttpServletRequest request, String requestUri) {
		String scheme = request.getScheme();
		String serverPort = String.valueOf(request.getServerPort());
		String serverName = request.getServerName();
		StringBuilder sb = new StringBuilder(60);
		sb.append(scheme).append("://").append(serverName).append(":").append(serverPort);
		sb.append(getContextUrl(request, requestUri));
		return sb.toString();

	}

	/**
	 * 获取完整的URL.
	 * 
	 * @param requestUri
	 *            相对于项目的访问路径
	 * @param params
	 *            参数
	 * @return
	 */
	public static String getFullUrl(HttpServletRequest request, String requestUri, Map<String, String> params) {
		String scheme = request.getScheme();
		String serverPort = String.valueOf(request.getServerPort());
		String serverName = request.getServerName();
		StringBuilder sb = new StringBuilder(60);
		sb.append(scheme).append("://").append(serverName).append(":").append(serverPort);
		sb.append(getContexUrlWithParams(request, requestUri, params));
		return sb.toString();
	}

	/**
	 * 判断是否是URL.
	 * 
	 * @param url
	 *            判断的URL
	 * @return
	 */
	public static boolean isUrl(String url) {
		String regExp = "(http[s]?|ftp):\\/\\/[^\\/\\.]+?\\..+\\w$";
		if (url.matches(regExp))
			return true;
		return false;
	}

}

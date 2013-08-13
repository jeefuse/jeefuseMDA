package com.jeefuse.base.web.uploadFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jeefuse.base.web.utils.WebContextUtil;

/**
 * 获取上传文件保存路径规则。
 * 
 * @author yonclv
 * @date 2013-5-20
 * @email yonclv@gmail.com
 */
public final class UploadFileFactory {

	/**
	 * 获取上传文件保存路径规则.
	 */
	public static final ContextUploadFileRule getUploadFileRule(HttpServletRequest request, String userId, String uploadRootDir,
			UploadFileDataType fileType) {
		ContextUploadFileRule upploadFile = new ContextUploadFileRule(request, userId, uploadRootDir, fileType);
		return upploadFile;
	}

	/**
	 * 获取上传文件保存路径规则.
	 */
	public static final ContextUploadFileRule getUploadFileRule(ServletContext servletContext, String userId, String uploadRootDir,
			UploadFileDataType fileType) {
		ContextUploadFileRule upploadFile = new ContextUploadFileRule(servletContext, userId, uploadRootDir, fileType);
		return upploadFile;
	}

	/**
	 * 获取文件访问URL路径.
	 * 
	 * @param fileRelativePath
	 * @return
	 */
	public static final String getUploadFileWebVisitUrl(String fileRelativePath) {
		String contextHref = WebContextUtil.getFullUrl(ServletActionContext.getRequest());
		if (contextHref.endsWith("/"))
			return contextHref + fileRelativePath;
		else
			return contextHref + "/" + fileRelativePath;
	}

}

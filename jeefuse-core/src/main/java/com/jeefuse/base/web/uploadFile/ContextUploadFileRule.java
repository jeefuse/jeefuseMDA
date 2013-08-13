package com.jeefuse.base.web.uploadFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.util.Assert;

import com.jeefuse.base.web.utils.WebContextUtil;

/**
 * web context 构造上传文件规则.
 * 
 * @author yonclv
 */
public class ContextUploadFileRule implements UploadFileRule {

	/**
	 * 允许上传文件后缀,例{ "jpg", "gif", "jpeg","png", "bmp"},为空表不限.
	 */
	private String[] allowExtentionTypes = null;
	/**
	 * 允许上传文件的表单字段名,例{ "attachField","imageField"},为空表不限.
	 */
	private String[] allowFieldNames = null;
	/**
	 * 允许上传文件的大小.
	 */
	private long acceptFileSize = 0;

	private String rootPath = null;

	private String fileRelativeDir = null;

	private UploadFilePathAnalyzer uploadFilePathAnalyzer = null;

	public ContextUploadFileRule(HttpServletRequest request) {
		this.rootPath = request.getSession().getServletContext().getRealPath("/");
	}

	/**
	 * 上传文件保存路径规则.
	 * 
	 * @param request
	 *            HTTP请求
	 * @param userId
	 *            用户ID
	 * @param uploadRootDir
	 *            上传的目录
	 * @param fileType
	 *            文件类型
	 */
	public ContextUploadFileRule(HttpServletRequest request, String userId, String uploadRootDir, UploadFileDataType fileType) {
		Assert.notNull(request);
		Assert.notNull(userId);
		Assert.notNull(fileType);
		this.rootPath = request.getSession().getServletContext().getRealPath("/");
		uploadFilePathAnalyzer = new UploadFilePathAnalyzer(userId, uploadRootDir, fileType);
		fileRelativeDir = uploadFilePathAnalyzer.getRelativeDir();
	}

	/**
	 * 上传文件保存路径规则.
	 * 
	 * @param servletContext
	 *            servletContext
	 * @param userId
	 *            用户ID
	 * @param uploadRootDir
	 *            上传的目录
	 * @param fileType
	 *            文件类型
	 */
	public ContextUploadFileRule(ServletContext servletContext, String userId, String uploadRootDir, UploadFileDataType fileType) {
		Assert.notNull(userId);
		Assert.notNull(fileType);
		this.rootPath = servletContext.getRealPath("/");
		uploadFilePathAnalyzer = new UploadFilePathAnalyzer(userId, uploadRootDir, fileType);
		fileRelativeDir = uploadFilePathAnalyzer.getRelativeDir();
	}

	/**
	 * 上传文件保存路径规则.
	 * 
	 * @param uploadFileRootAbsolutePath
	 *            上传文件保存绝对根路径
	 * @param userId
	 *            用户ID
	 * @param uploadRootDir
	 *            上传的目录
	 * @param fileType
	 *            文件类型
	 */
	public ContextUploadFileRule(String uploadFileRootAbsolutePath, String userId, String uploadRootDir, UploadFileDataType fileType) {
		this.rootPath = uploadFileRootAbsolutePath;
		uploadFilePathAnalyzer = new UploadFilePathAnalyzer(userId, uploadRootDir, fileType);
		fileRelativeDir = uploadFilePathAnalyzer.getRelativeDir();
	}

	public String getFileRootPath() {
		return rootPath;
	}

	public UploadFilePathAnalyzer getUploadFilePathAnalyzer() {
		return uploadFilePathAnalyzer;
	}

	public String getFileRelativeDir() {
		return fileRelativeDir;
	}

	public String getFileRelativePath(String fileName) {
		return fileRelativeDir + "/" + fileName;
	}

	public String getFileAbsoluteDir() {
		return rootPath + fileRelativeDir + "/";
	}

	public String getFileAbsolutePath(String fileName) {
		return rootPath + fileRelativeDir + "/" + fileName;
	}

	public String getFileAbsolutePathByRelativePath(String fileRelativePath) {
		return rootPath + fileRelativePath;
	}

	public String getWebVisitUrl(String fileName) {
		String contextHref = WebContextUtil.getFullUrl(ServletActionContext.getRequest());
		if (contextHref.endsWith("/"))
			return contextHref + fileRelativeDir + "/" + fileName;
		else
			return contextHref + "/" + fileRelativeDir + "/" + fileName;
	}

	/**
	 * 是否是允许上传的文件扩展名.
	 * 
	 * @param extention
	 * @return
	 */
	public boolean isAcceptExtentionType(String extention) {
		if (null != allowExtentionTypes && allowExtentionTypes.length > 0) {
			for (String allowExt : allowExtentionTypes) {
				if (allowExt.equalsIgnoreCase(extention))
					return true;
			}
			return false;
		}
		return true;
	}

	public boolean isAcceptField(String field) {
		if (null != allowFieldNames && allowFieldNames.length > 0) {
			for (String acceptName : allowFieldNames) {
				if (acceptName.equalsIgnoreCase(field))
					return true;
			}
			return false;
		}
		return true;
	}

	public String[] getAllowExtentionTypes() {

		return allowExtentionTypes;
	}

	public String[] getAllowFieldNames() {

		return allowFieldNames;
	}

	public void setAcceptExtentionType(String[] exts) {
		allowExtentionTypes = exts;
	}

	public void setAcceptFileSize(long size) {
		acceptFileSize = size;
	}

	public long getAcceptFileSize() {
		return acceptFileSize;
	}

	public boolean isAcceptFileSize(long fileSize) {
		if (getAcceptFileSize() > 0) {
			if (getAcceptFileSize() < fileSize)
				return false;
		}
		return true;
	}

	public void setAllowFieldNames(String[] allowFieldNames) {
		this.allowFieldNames = allowFieldNames;
	}

}

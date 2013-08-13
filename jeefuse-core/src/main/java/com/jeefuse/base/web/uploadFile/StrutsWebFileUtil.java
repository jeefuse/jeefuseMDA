package com.jeefuse.base.web.uploadFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeefuse.base.utils.common.RandomUtil;
import com.jeefuse.base.utils.file.FileHelper;

/**
 * web 文件上传、下载工具.
 * 
 * @author yonclv 2009-10-20
 */
public class StrutsWebFileUtil {
	private static final int FILE_BUFFER_SIZE = 1024*8;
	private static Logger logger = LoggerFactory.getLogger(StrutsWebFileUtil.class);

	/**
	 * 获取所有上传文件.
	 * 
	 * @param request
	 *            HttpServletRequest
	 */
	public static List<File> getUploadFile(HttpServletRequest request) {
		if (request instanceof MultiPartRequestWrapper) {
			List<File> fileList = new ArrayList<File>();
			MultiPartRequestWrapper req = (MultiPartRequestWrapper) request;
			Enumeration<String> fileParams = req.getFileParameterNames();
			while (fileParams.hasMoreElements()) {
				String fileField = fileParams.nextElement();
				File[] files = req.getFiles(fileField);
				for (File file : files) {
					fileList.add(file);
				}
			}
			return fileList;
		}
		return null;
	}

	/**
	 * 获取指定字段名的上传文件.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param fieldName
	 *            html input name
	 */
	public static List<File> getUploadFile(HttpServletRequest request, String fieldName) {
		if (request instanceof MultiPartRequestWrapper) {
			List<File> fileList = new ArrayList<File>();
			MultiPartRequestWrapper req = (MultiPartRequestWrapper) request;
			Enumeration<String> fileParams = req.getFileParameterNames();
			while (fileParams.hasMoreElements()) {
				String fileField = fileParams.nextElement();
				if (fileField.equals(fieldName)) {
					File[] files = req.getFiles(fileField);
					for (File file : files) {
						fileList.add(file);
					}
					return fileList;
				}
			}
		}
		return null;
	}

	/**
	 * http多文件上传,在struts框架中使用,基于struts中的MultiPartRequestWrapper解析上传文件.
	 * 
	 * @param uploadRule
	 *            上传文件保存规则.
	 * @param request
	 *            http 请求
	 * @return
	 * @throws FileUploadException
	 */
	public static List<UploadFileField> uploadFile(UploadFileRule uploadRule, HttpServletRequest request) {
		return uploadFile(uploadRule, request, true);
	}

	/**
	 * http多文件上传,在struts框架中使用,基于struts中的MultiPartRequestWrapper解析上传文件.
	 * 
	 * @param uploadRule
	 *            上传文件保存规则.
	 * @param request
	 *            http 请求
	 * @param isGenName
	 *            是否自动生成上传文件名.
	 * @return
	 * @throws FileUploadException
	 */
	public static List<UploadFileField> uploadFile(UploadFileRule uploadRule, HttpServletRequest request,
			boolean isGenName) throws FileUploadException {
		if (request instanceof MultiPartRequestWrapper) {
			List<UploadFileField> uploadFiles = new ArrayList<UploadFileField>();
			MultiPartRequestWrapper req = (MultiPartRequestWrapper) request;
			if (null != uploadRule.getAllowExtentionTypes() && uploadRule.getAllowExtentionTypes().length > 0) {
				String[] allowExtentionTypes = uploadRule.getAllowExtentionTypes();
				logger.debug("检查上传的文件...充许文件扩展名为:" + StringUtils.join(allowExtentionTypes, ","));
				Enumeration<String> chkfileParams = req.getFileParameterNames();
				while (chkfileParams.hasMoreElements()) {
					String fileField = chkfileParams.nextElement();
					File[] files = req.getFiles(fileField);
					String[] fileNames = req.getFileNames(fileField);
					for (int r = 0; r < fileNames.length; r++) {
						String fileName = fileNames[r];
						String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
						if (!uploadRule.isAcceptExtentionType(fileExt))
							throw new FileUploadException(req.getFileNames(fileField) + "上传的文件格式不正确,只支持"
									+ StringUtils.join(allowExtentionTypes, ",") + " 格式的文件！请您检查！");
						File file = files[r];
						long size = file.length();
						if (size == 0)
							throw new FileUploadException("验证失败!上传文件的内容不能为空!文件名:" + fileName);
						if (!uploadRule.isAcceptFileSize(size))
							throw new FileUploadException("验证失败!上传文件的大小不能超过!" + uploadRule.getAcceptFileSize()
									+ ", 文件名:" + fileName);
					}
				}
			}
			String saveFileAboluteDir = uploadRule.getFileAbsoluteDir();
			File dirFile = new File(saveFileAboluteDir);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}
			Enumeration<String> fileParams = req.getFileParameterNames();
			while (fileParams.hasMoreElements()) {
				String fileField = fileParams.nextElement();
				logger.debug("当前上传文件字段:" + fileField);
				if (uploadRule.isAcceptField(fileField)) {
					String[] fileNames = req.getFileNames(fileField);
					String[] contentTypes = req.getContentTypes(fileField);
					File[] files = req.getFiles(fileField);
					for (int j = 0; j < files.length; j++) {
						if (null != files[j]) {
							File file = files[j];
							long size = file.length();
							String fileName = fileNames[j];
							String contentType = contentTypes[j];
							String extention = fileName.substring(fileName.lastIndexOf(".") + 1);
							String saveFileName = fileName;
							if (isGenName) {
								saveFileName = RandomUtil.dateTimeMillisecondSerial() + "." + extention;
							}
							File destiFile = new File(uploadRule.getFileAbsolutePath(saveFileName));
							try {
								FileHelper.copy(file, destiFile);
							} catch (IOException e) {
								throw new FileUploadException("文件上传失败!", e);
							}
							logger.debug("文件名:" + fileName);
							logger.debug("文件大小:" + file.length());
							logger.debug("文件类型:" + contentType);
							logger.debug("文件实际保存在:" + destiFile.getAbsolutePath());
							UploadFileField uploadFile = new UploadFileField();
							uploadFile.setFileName(saveFileName);
							uploadFile.setFileType(contentType);
							uploadFile.setSize(size);
							uploadFile.setExtention(extention);
							uploadFile.setFileField(fileField);
							uploadFile.setSavePath(destiFile.getAbsolutePath());
							uploadFile.setVisitPath(uploadRule.getFileRelativePath(saveFileName));
							uploadFiles.add(uploadFile);
						}
					}
				} else {
					logger.info("不允许上传文件的字段:" + fileField);
				}
			}
			return uploadFiles;
		}
		return null;
	}

	/**
	 * 下载文件
	 * 
	 * @param downLoadPath
	 *            下载文件路径(绝对路径)
	 */
	public static void downLoadFile(String downLoadPath, HttpServletResponse response) {
		try {
			File downloadFile = new File(downLoadPath);
			logger.info("下载文件 路径:" + downloadFile.getAbsolutePath());
			if (null != downloadFile && downloadFile.exists() && downloadFile.isFile()) {
				String fileName = downloadFile.getName();
				response.reset();
				response.setHeader("pragma", "no-cache");
				response.setHeader("cache-control", "no-cache");
				response.setDateHeader("Expires", 0);
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/octet-stream;charset=UTF-8");
				response.setContentLength((int) downloadFile.length());
				String downLoadfileName = fileName;
				try {
					downLoadfileName = new String(fileName.getBytes("UTF-8"));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				response.setHeader("Content-Disposition", "attachment; filename=" + downLoadfileName);
				OutputStream output = null;
				InputStream input = null;
				try {
					output = new BufferedOutputStream(response.getOutputStream());
					input = new BufferedInputStream(new FileInputStream(downloadFile));
					//					output = response.getOutputStream();
					//					input = new FileInputStream(downloadFile);
					int n = 0;
					int buffersize = FILE_BUFFER_SIZE;
					byte[] buffer = new byte[buffersize];
					while ((n = input.read(buffer)) != -1) {
						output.write(buffer, 0, n);
					}
					response.flushBuffer();
				} finally {
					if (null != input) {
						input.close();
					}
					if (null != output) {
						output.close();
					}
				}
			} else {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write("<font color=\"blue\">很抱歉!您下载的文件不存在！</font>");
				logger.info("文件下载失败！当前下载的文件不存在!");

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8");
			try {
				PrintWriter out = response.getWriter();
				out.write("<font color=\"blue\">很抱歉!文件下载失败！</font>");
			} catch (IOException e) {
			}
			logger.error("文件下载失败！");
		}
	}

	/**
	 * 删除文件.
	 * 
	 * @param userFileRule
	 *            文件上传规则
	 * @param relateSavePath
	 *            文件相对servlet保存数径
	 */
	public static void deleteFile(UploadFileRule fileRule, String relativeSavePath) {
		String delFilePath = fileRule.getFileAbsolutePathByRelativePath(relativeSavePath);
		deleteFile(delFilePath);
	}

	/**
	 * 删除文件.
	 * 
	 * @param fileAbsolutePath
	 *            绝对路径
	 */
	public static void deleteFile(String fileAbsolutePath) {
		File delFile = new File(fileAbsolutePath);
		if (null != delFile && delFile.exists()) {
			boolean success = delFile.delete();
			if (logger.isDebugEnabled()) {
				logger.debug("deleted file:" + delFile.getAbsolutePath() + (success ? " success!" : " failed!"));
			}
		} else {
			logger.debug("deleted file don't exist:" + fileAbsolutePath);
		}
	}
}

package com.jeefuse.base.web.uploadFile;

/**
 * 上传文件类型.
 * 
 * @author yonclv
 */
public interface UploadFileDataType {


	/**
	 * 类型名
	 */
	public String getName();

	/**
	 * 保存目录
	 */
	public String getSavedDirectory();
}

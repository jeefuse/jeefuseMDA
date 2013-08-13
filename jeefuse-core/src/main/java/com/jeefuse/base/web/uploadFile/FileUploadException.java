package com.jeefuse.base.web.uploadFile;

import com.jeefuse.base.web.exception.WebException;

/**
 * 文件上传异常.
 * @author yonclv
 * 2009-10-12
 */
@SuppressWarnings("serial")
public class FileUploadException extends WebException {

	public FileUploadException(String message) {
		super(message);
		
	}

	public FileUploadException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public FileUploadException(Throwable cause) {
		super(cause);
		
	}

}

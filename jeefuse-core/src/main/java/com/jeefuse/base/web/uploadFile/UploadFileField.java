package com.jeefuse.base.web.uploadFile;

/**
 * 上传文件构造.
 * 
 * @author yonclv 2009-10-12
 */
public class UploadFileField {
	protected String fileName;
	protected String savePath;
	protected String visitPath;//访问路径
	protected String extention;
	protected Long size;
	protected String fileField;// 文件上传字段
	protected String fileType;

	public UploadFileField() {

	}

	public UploadFileField(String fileName, String savePath, String extention, String fileType, Long size, String fileField) {
		this.fileName = fileName;
		this.savePath = savePath;
		this.extention = extention;
		this.fileType = fileType;
		this.size = size;
		this.fileField = fileField;
	}

	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getFileField() {
		return fileField;
	}

	public void setFileField(String fileField) {
		this.fileField = fileField;
	}

	/**
	 * 相对servlet保存路径.
	 * 
	 * @return
	 */
	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 文件上传相对路径
	 */
	public String getVisitPath() {
		return visitPath;
	}

	public void setVisitPath(String visitPath) {
		this.visitPath = visitPath;
	}
}

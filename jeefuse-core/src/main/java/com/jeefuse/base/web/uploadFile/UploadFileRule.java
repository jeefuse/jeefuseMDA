package com.jeefuse.base.web.uploadFile;

/**
 * 上传文件保存规则.定义上传文件保存路径：getFileRootPath()+getFileRelativeDir()+fileName;
 * 
 * @author yonclv
 */
public interface UploadFileRule {

	/**
	 * 获取保存文件的根路径.
	 */
	public String getFileRootPath();

	/**
	 * 获取保存文件的绝对目录.
	 */
	public String getFileAbsoluteDir();

	/**
	 * 获取保存文件的绝对路径.
	 */
	public String getFileAbsolutePath(String fileName);

	/**
	 * 获取保存文件的相对路径.
	 */
	public String getFileRelativePath(String fileName);

	/**
	 * 获取保存文件的相对目录路径.
	 */
	public String getFileRelativeDir();

	/**
	 * 根据文件保存的相对路径获取文件实际存放的绝对路径.
	 */
	public String getFileAbsolutePathByRelativePath(String fileRelativePath);

	/**
	 * 获取WEB访问路径.
	 */
	public String getWebVisitUrl(String fileName);

	/**
	 * 获得允许上传扩展类型.如{ "jpg", "gif", "jpeg","png", "bmp"},为空表不限.
	 * 
	 */
	public String[] getAllowExtentionTypes();

	/**
	 * 是否是允许上传的文件扩展名.允许返回true,不充许返回false
	 * 
	 */
	public boolean isAcceptExtentionType(String extention);

	/**
	 * 设置允许上传的扩展名.如{ "jpg", "gif", "jpeg","png", "bmp"},为空表不限.
	 */
	public void setAcceptExtentionType(String[] exts);

	/**
	 * 允许上传文件的表单字段名,如{ "attachField","imageField"}为空表不限.
	 * 
	 */
	public String[] getAllowFieldNames();

	/**
	 * 设置允许上传文件的表单字段名,如{ "attachField","imageField"}为空表不限.
	 */
	public void setAllowFieldNames(String[] allowFieldNames);

	/**
	 * 是否是允许上传的字段名.
	 * 
	 */
	public boolean isAcceptField(String fieldName);

	/**
	 * 设置允许上传的单个文件的大小
	 */
	public void setAcceptFileSize(long size);

	/**
	 * 是否允许的上传文件大小范围内.
	 */
	public boolean isAcceptFileSize(long fileSize);

	/**
	 * 获取允许的上传文件大小.
	 */
	public long getAcceptFileSize();


}

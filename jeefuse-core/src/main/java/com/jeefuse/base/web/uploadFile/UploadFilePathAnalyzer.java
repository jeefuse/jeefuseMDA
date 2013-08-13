package com.jeefuse.base.web.uploadFile;


/**
 * 上传文件相对路径解析.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class UploadFilePathAnalyzer {

	private final String userId;
	private final UploadFileDataType fileDateType;
	private final String uploadRootDir;
	private final String relationPath;

	public UploadFilePathAnalyzer(String userId, String uploadRootDir, UploadFileDataType fileDateType) {
		this.userId = userId;
		this.fileDateType = fileDateType;
		this.uploadRootDir = uploadRootDir;
		StringBuffer partPath = new StringBuffer();
		partPath.append(uploadRootDir);
		partPath.append("/");
		partPath.append(userId);
		partPath.append("/");
		partPath.append(fileDateType.getSavedDirectory());
		relationPath = partPath.toString();
	}

	public UploadFileDataType getFileDateType() {
		return fileDateType;
	}

	public String getRelationPath() {
		return relationPath;
	}

	public String getUploadRootDir() {
		return uploadRootDir;
	}

	public String getRelativeDir() {
		return relationPath;
	}

	public String getUserId() {
		return userId;
	}

}

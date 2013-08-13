package com.jeefuse.base.web.uploadFile;

/**
 * 上传文件类型.
 * 
 * @author yonclv
 */
public enum CommonUploadFileDataType implements UploadFileDataType {
	/**
	 * 图片
	 */
	image("image", "image"),
	/**
	 * 附件
	 */
	attachfiles("attachfiles", "attachfiles"),
	/**
	 * 视频
	 */
	video("video", "vid"),
	/**
	 * 归档文件
	 */
	archive("archive", "arc"),
	/**
	 * 网上硬盘
	 */
	webHarddisk("webHarddisk", "har"),
	/**
	 * fckEditor文件保存路经
	 */
	fckfiles("fckfiles", "fck");

	private String name;
	private String directory;

	private CommonUploadFileDataType(String name, String directory) {
		this.name = name;
		this.directory = directory;
	}

	public String toParam() {
		if (null != this)
			return name;
		return null;
	}

	public static CommonUploadFileDataType valueOfParam(String param) {
		for (CommonUploadFileDataType item : CommonUploadFileDataType.values()) {
			if (item.toParam().equals(param))
				return item;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jeefuse.base.web.uploadFile.UploadFileDataType#getName()
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jeefuse.base.web.uploadFile.UploadFileDataType#getSavedDirectory()
	 */
	public String getSavedDirectory() {
		return directory;
	}
}

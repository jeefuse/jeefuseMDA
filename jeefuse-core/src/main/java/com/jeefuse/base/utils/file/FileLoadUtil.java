package com.jeefuse.base.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeefuse.base.exception.LoadFileException;

/**
 * 加载文件工具类.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class FileLoadUtil {
	private static Logger log = LoggerFactory.getLogger(FileLoadUtil.class);

	/**
	 * 从类路径中加载文件.
	 * 
	 * @param resource
	 *            文件路径(类路径)
	 * @return
	 */
	public static InputStream getResourceAsStream(String resource) throws LoadFileException {
		String stripped = resource.startsWith("/") ? resource.substring(1) : resource;
		InputStream stream = null;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader != null) {
			stream = classLoader.getResourceAsStream(stripped);
		}
		if (stream == null) {
			stream = FileLoadUtil.class.getResourceAsStream(resource);
		}
		if (stream == null) {
			stream = FileLoadUtil.class.getClassLoader().getResourceAsStream(stripped);
		}
		if (stream == null)
			throw new LoadFileException(resource + " not found!");
		else
			return stream;
	}

	/**
	 * 从类路径中加载文件.若没有找到则从系统文件路径中加载.
	 * 
	 * @param resource
	 *            文件路径(类路径或系统文件路径)
	 * @return
	 */
	public static InputStream getResourceFromClassPathOrFilePath(String resource) throws LoadFileException {
		String stripped = resource.startsWith("/") ? resource.substring(1) : resource;
		InputStream stream = null;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader != null) {
			stream = classLoader.getResourceAsStream(stripped);
		}
		if (stream == null) {
			stream = FileLoadUtil.class.getResourceAsStream(resource);
		}
		if (stream == null) {
			stream = FileLoadUtil.class.getClassLoader().getResourceAsStream(stripped);
		}
		if (stream == null) {
			File file = null;
			try {
				file = new File(resource);
				stream = new FileInputStream(file);
			} catch (Exception e) {
				log.warn("Unable to load config file:" + resource);
			}
		}
		if (stream == null)
			throw new LoadFileException(resource + " not found");
		else
			return stream;
	}

	/**
	 * 从URL中加载文件,若没有找到则从类路径中加载文件.
	 * 
	 * @param path
	 *            文件路径
	 * @return
	 */
	public static final InputStream getConfigStream(String path) throws LoadFileException {
		URL url = locateConfig(path);
		if (url == null) {
			String msg = "Unable to locate config file: " + path;
			log.error(msg);
			throw new LoadFileException(msg);
		}
		try {
			return url.openStream();
		} catch (IOException e) {
			throw new LoadFileException("Unable to open config file: " + path, e);
		}
	}

	/**
	 * 返回统一资源定位(URL).若没有找到会从类路径中查找.
	 * 
	 * @param path
	 *            查找路径
	 * @return
	 */
	public static final URL locateConfig(String path) {
		try {
			return new URL(path);
		} catch (MalformedURLException e) {
			return findAsResource(path);
		}
	}

	/**
	 * 从类路径中查找,并返回统一资源定位(URL).
	 * 
	 * @param path
	 *            查找路径
	 * @return
	 */
	public static final URL findAsResource(String path) {
		URL url = null;
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		if (contextClassLoader != null) {
			url = contextClassLoader.getResource(path);
		}
		if (url != null)
			return url;
		url = (FileLoadUtil.class).getClassLoader().getResource(path);
		if (url != null)
			return url;
		else {
			url = ClassLoader.getSystemClassLoader().getResource(path);
			return url;
		}
	}
}

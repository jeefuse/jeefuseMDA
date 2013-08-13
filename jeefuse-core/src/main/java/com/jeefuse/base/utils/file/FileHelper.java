package com.jeefuse.base.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件处理操作.
 * 
 * @author yonclv mailTo:yonclv@gmail.com
 */
public final class FileHelper {
	private static final int DEFAULT_BUFFER_SIZE = 1024 * 8 * 2;
	private static Logger logger = LoggerFactory.getLogger(FileHelper.class);
	/**
	 * get the extension of file.
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtension(final String filename) {
		final int index = filename.lastIndexOf('.');
		if (-1 == index)
			return null;
		else
			return filename.substring(index + 1);
	}

	/*****************************************************************
	 * stream copy method inputStream to OutputStream Reader to Writer
	 * inputStream to Writer /
	 *****************************************************************/

	/**
	 * Copy bytes from an <code>InputStream</code> to an
	 * <code>OutputStream</code>.
	 */
	public static void copy(final InputStream input, final OutputStream output) throws IOException {
		copy(input, output, DEFAULT_BUFFER_SIZE);
	}

	/**
	 * Copy bytes from an <code>InputStream</code> to an
	 * <code>OutputStream</code>.
	 * 
	 * @param bufferSize
	 *            Size of internal buffer to use.
	 */
	public static void copy(final InputStream input, final OutputStream output, final int bufferSize)
			throws IOException {
		final byte[] buffer = new byte[bufferSize];
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
		}
	}

	/**
	 * Copy chars from a <code>Reader</code> to a <code>Writer</code>.
	 */
	public static void copy(final Reader input, final Writer output) throws IOException {
		copy(input, output, DEFAULT_BUFFER_SIZE);
	}

	/**
	 * Copy chars from a <code>Reader</code> to a <code>Writer</code>.
	 * 
	 * @param bufferSize
	 *            Size of internal buffer to use.
	 */
	public static void copy(final Reader input, final Writer output, final int bufferSize) throws IOException {
		final char[] buffer = new char[bufferSize];
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
		}
	}

	/**
	 * Copy and convert bytes from an <code>InputStream</code> to chars on a
	 * <code>Writer</code>. The platform's default encoding is used for the
	 * byte-to-char conversion.
	 */
	public static void copy(final InputStream input, final Writer output) throws IOException {
		copy(input, output, DEFAULT_BUFFER_SIZE);
	}

	/**
	 * Copy and convert bytes from an <code>InputStream</code> to chars on a
	 * <code>Writer</code>. The platform's default encoding is used for the
	 * byte-to-char conversion.
	 * 
	 * @param bufferSize
	 *            Size of internal buffer to use.
	 */
	public static void copy(final InputStream input, final Writer output, final int bufferSize) throws IOException {
		final InputStreamReader in = new InputStreamReader(input);
		copy(in, output, bufferSize);
	}

	/**
	 * Copy and convert bytes from an <code>InputStream</code> to chars on a
	 * <code>Writer</code>, using the specified encoding.
	 * 
	 * @param encoding
	 *            The name of a supported character encoding. See the <a
	 *            href="http://www.iana.org/assignments/character-sets">IANA
	 *            Charset Registry</a> for a list of valid encoding types.
	 */
	public static void copy(final InputStream input, final Writer output, final String encoding) throws IOException {
		final InputStreamReader in = new InputStreamReader(input, encoding);
		copy(in, output);
	}

	/**
	 * Copy and convert bytes from an <code>InputStream</code> to chars on a
	 * <code>Writer</code>, using the specified encoding.
	 * 
	 * @param encoding
	 *            The name of a supported character encoding. See the <a
	 *            href="http://www.iana.org/assignments/character-sets">IANA
	 *            Charset Registry</a> for a list of valid encoding types.
	 * @param bufferSize
	 *            Size of internal buffer to use.
	 */
	public static void copy(final InputStream input, final Writer output, final String encoding, final int bufferSize)
			throws IOException {
		final InputStreamReader in = new InputStreamReader(input, encoding);
		copy(in, output, bufferSize);
	}

	/*****************************************************************
	 * inputStream to string /
	 *****************************************************************/

	/**
	 * Get the contents of an <code>InputStream</code> as a String. The
	 * platform's default encoding is used for the byte-to-char conversion.
	 */
	public static String toString(final InputStream input) throws IOException {
		return toString(input, DEFAULT_BUFFER_SIZE);
	}

	/**
	 * Get the contents of an <code>InputStream</code> as a String. The
	 * platform's default encoding is used for the byte-to-char conversion.
	 * 
	 * @param bufferSize
	 *            Size of internal buffer to use.
	 */
	public static String toString(final InputStream input, final int bufferSize) throws IOException {
		final StringWriter sw = new StringWriter();
		copy(input, sw, bufferSize);
		return sw.toString();
	}

	/**
	 * Get the contents of an <code>InputStream</code> as a String.
	 * 
	 * @param encoding
	 *            The name of a supported character encoding. See the <a
	 *            href="http://www.iana.org/assignments/character-sets">IANA
	 *            Charset Registry</a> for a list of valid encoding types.
	 */
	public static String toString(final InputStream input, final String encoding) throws IOException {
		return toString(input, encoding, DEFAULT_BUFFER_SIZE);
	}

	/**
	 * Get the contents of an <code>InputStream</code> as a String.
	 * 
	 * @param encoding
	 *            The name of a supported character encoding. See the <a
	 *            href="http://www.iana.org/assignments/character-sets">IANA
	 *            Charset Registry</a> for a list of valid encoding types.
	 * @param bufferSize
	 *            Size of internal buffer to use.
	 */
	public static String toString(final InputStream input, final String encoding, final int bufferSize)
			throws IOException {
		final StringWriter sw = new StringWriter();
		copy(input, sw, encoding, bufferSize);
		return sw.toString();
	}

	/*****************************************************************
	 * file to string /
	 *****************************************************************/

	public static String toString(final File srcfile, final String encoding, final int bufferSize) throws IOException {
		if (!srcfile.exists())
			return null;
		InputStream in = null;
		StringWriter sw = null;
		try {
			in = new FileInputStream(srcfile);
			sw = new StringWriter();
			copy(in, sw, encoding, bufferSize);
			return sw.toString();
		} finally {
			if (null != in) {
				in.close();
			}
			if (null != sw) {
				sw.close();
			}
		}
	}

	/*****************************************************************
	 * string to file /
	 *****************************************************************/

	public static void stringToFile(final String str, final File dstfile, final String encoding) throws IOException {
		if (null == dstfile || (!dstfile.exists()))
			return;
		OutputStreamWriter outwriter = null;
		try {
			outwriter = new OutputStreamWriter(new FileOutputStream(dstfile), encoding);
			outwriter.write(str);
			outwriter.flush();
		} finally {
			if (null != outwriter) {
				outwriter.close();
			}
		}
	}

	/*****************************************************************
	 * String -> OutputStream /
	 *****************************************************************/

	/**
	 * Serialize chars from a <code>String</code> to bytes on an
	 * <code>OutputStream</code>, and flush the <code>OutputStream</code>.
	 */
	public static void copy(final String input, final OutputStream output) throws IOException {
		copy(input, output, DEFAULT_BUFFER_SIZE);
	}

	/**
	 * Serialize chars from a <code>String</code> to bytes on an
	 * <code>OutputStream</code>, and flush the <code>OutputStream</code>.
	 * 
	 * @param bufferSize
	 *            Size of internal buffer to use.
	 */
	public static void copy(final String input, final OutputStream output, final int bufferSize) throws IOException {
		final StringReader in = new StringReader(input);
		final OutputStreamWriter out = new OutputStreamWriter(output);
		copy(in, out, bufferSize);
		out.flush();
	}

	/**
	 * Copy chars from a <code>String</code> to a <code>Writer</code>.
	 */
	public static void copy(final String input, final Writer output) throws IOException {
		output.write(input);
	}

	/*****************************************************************
	 * copy file /
	 *****************************************************************/

	public static void copy(final File src, final File dst, final int BUFFER_SIZE) throws IOException {
		if (null == src || null == dst)
			return;
		int byteSize = BUFFER_SIZE;
		if (byteSize == 0 || byteSize > DEFAULT_BUFFER_SIZE) {
			byteSize = DEFAULT_BUFFER_SIZE;
		}
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dst);
			copy(in, out, byteSize);
			out.flush();
		} finally {
			if (null != in) {
				in.close();
			}
			if (null != out) {
				out.close();
			}
		}
	}

	public static void copy(String srcpath, String despath) throws IOException {
		copy(srcpath, despath, DEFAULT_BUFFER_SIZE);
	}

	public static void copy(String srcpath, String despath, final int BUFFER_SIZE) throws IOException {
		if (null == despath)
			return;
		File srcFile = new File(srcpath);
		if (srcFile.exists()) {
			int byteSize = BUFFER_SIZE;
			if (byteSize == 0 || byteSize > DEFAULT_BUFFER_SIZE) {
				byteSize = DEFAULT_BUFFER_SIZE;
			}
			InputStream in = null;
			FileOutputStream out = null;
			try {
				in = new FileInputStream(srcpath);
				out = new FileOutputStream(despath);
				copy(in, out, byteSize);
				out.flush();
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		}
	}

	/**
	 * Copy bytes from a <code>File</code> to an <code>File</code>.
	 * 
	 * @param bufferSize
	 *            Size of internal buffer to use.
	 */
	public static void copy(final File input, final File output) throws IOException {
		FileInputStream fis = new FileInputStream(input);
		FileOutputStream fos = new FileOutputStream(output);
		try {
			copy(fis, fos);
			fos.flush();
		} finally {
			fis.close();
			fos.close();
		}
	}

	/**
	 * copy directory
	 * 
	 * @param srcDir
	 * @param destineDir
	 * @throws IOException
	 */
	public static void xcopy(File srcDir, File destineDir) throws IOException {
		try {
			if (!srcDir.exists() || srcDir.getCanonicalPath().equals(destineDir.getCanonicalPath()))
				return;
		} catch (IOException ioexception) {
		}
		if (!destineDir.exists()) {
			destineDir.mkdirs();
		}
		File chs[] = srcDir.listFiles();
		for (int i = 0; i < chs.length; i++) {
			if (chs[i].isFile()) {
				File destineFile = new File(destineDir, chs[i].getName());
				copy(chs[i], destineFile);
			} else {
				File destine = new File(destineDir, chs[i].getName());
				destine.mkdirs();
				xcopy(chs[i], destine);
			}
		}
	}

	/**
	 * delete files and file directory
	 * 
	 * @param file
	 */
	public static void deleteChildrenFiles(File file) {
		if (file.isDirectory()) {
			File[] childrenFiles = file.listFiles();
			for (int i = 0; i < childrenFiles.length; i++) {
				deleteChildrenFiles(childrenFiles[i]);
			}
			file.delete();
		} else {
			file.delete();
		}
	}

	public static void deleteFile(String fileAbsolutePath) {
		File delFile = new File(fileAbsolutePath);
		if (null != delFile && delFile.exists()) {
			boolean success = delFile.delete();
			if (logger.isDebugEnabled()) {
				logger.debug("deleted file:" + delFile.getAbsolutePath() + (success ? " success!" : " failed!"));
			}
		}
	}
}
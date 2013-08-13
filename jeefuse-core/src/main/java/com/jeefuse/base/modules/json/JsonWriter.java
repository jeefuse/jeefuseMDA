package com.jeefuse.base.modules.json;

import java.io.IOException;
import java.io.Writer;

/**
 * 写入json数据.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public interface JsonWriter {

	public void writeJson(Writer writer) throws IOException;


}

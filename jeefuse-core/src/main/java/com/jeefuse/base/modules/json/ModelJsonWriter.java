package com.jeefuse.base.modules.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;

/**
 * 输出model对象json.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public abstract class ModelJsonWriter<T> implements JsonWriter {

	/**
	 * model字段写入JsonGenerator.
	 * <ul>
	 * 例:
	 * 
	 * <pre>
	 * g.writeStringField(&quot;gender&quot;, Gender.MALE);
	 * g.writeNumberField(&quot;total&quot;, total);
	 * g.writeBooleanField(&quot;verified&quot;, false);
	 * g.writeFieldName(&quot;userImage&quot;);
	 * g.writeBinary(binaryData);
	 * </pre>
	 * 
	 * @param g
	 *            JsonGenerator
	 * @param data
	 */
	protected abstract void writeJsonModel(JsonGenerator g, T model) throws JsonProcessingException, IOException;

}

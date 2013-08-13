package com.jeefuse.base.modules.keyLabel.render;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;

import com.jeefuse.base.modules.json.JsonUtil;
import com.jeefuse.base.modules.json.JsonWriter;
import com.jeefuse.base.modules.keyLabel.KeyLabel;

/**
 * 构造KeyLabel JSON数据.
 * <p>
 * 格式:[{"key":"key1","label":"lable1"},{"key":"key2","label": "lable2"}]
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class KeyLabelJsonWriter<T extends KeyLabel> implements JsonWriter {

	private static final String SUCCESS = "success";
	private static final String MESSAGE = "message";
	private static final String DATA = "data";

	private List<T> list;// 返回数据
	private boolean success = true;// 是否成功

	private String message;// 返回信息

	public KeyLabelJsonWriter(List<T> list) {
		this.list = list;
	}

	public KeyLabelJsonWriter(List<T> list, boolean success, String message) {
		this.success = success;
		this.list = list;
		this.message = message;
	}

	public void writeJson(Writer writer) throws IOException {
		JsonGenerator g = JsonUtil.jsonFactory.createJsonGenerator(writer);
		writeJson(g);
	}

	public void writeJson(JsonGenerator g) throws JsonGenerationException, IOException {
		g.writeStartObject();
		g.writeBooleanField(SUCCESS, success);
		g.writeStringField(MESSAGE, message);
		g.writeArrayFieldStart(DATA);
		if (null != list && !list.isEmpty()) {
			for (T model : list) {
				// write model data
				g.writeStartObject();
				g.writeStringField("key", model.getKey());
				g.writeStringField("label", model.getLabel());
				g.writeEndObject();
			}
		}
		g.writeEndArray();
		// write model data end
		g.writeEndObject();
		g.flush();
		g.close();
	}

}

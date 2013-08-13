package com.jeefuse.base.modules.json;

import java.io.IOException;
import java.io.Writer;

import org.codehaus.jackson.JsonGenerator;

import com.jeefuse.base.web.result.ResultMsg;

/**
 * 运用jackson.输出ResultMsg格式的json数据.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public abstract class ResultJsonWriter<T> extends ModelJsonWriter<T> {
	private static final String SUCCESS = "success";
	private static final String MESSAGE = "message";
	private static final String DATA = "data";

	private boolean success = true;// 是否成功
	private T data;// 返回数据
	private String message;// 返回信息


	public ResultJsonWriter(ResultMsg<T> msg) {
		this.success = msg.isSuccess();
		this.data = msg.getData();
		this.message = msg.getMessage();
	}

	public ResultJsonWriter(boolean success, T model, String message) {
		this.success = success;
		this.data = model;
		this.message = message;
	}

	public void writeJson(Writer writer) throws IOException {
		JsonGenerator g = JsonUtil.jsonFactory.createJsonGenerator(writer);
		writeJson(g);
	}

	public void writeJson(JsonGenerator g) {
		try {
			// JsonFactory f = new JsonFactory();
			// JsonGenerator g = f.createJsonGenerator(writer);
			g.writeStartObject();
			g.writeBooleanField(SUCCESS, success);
			g.writeStringField(MESSAGE, message);
			// write model data

			g.writeObjectFieldStart(DATA);
			if (null == data) {
				g.writeNull();
			} else {
				writeJsonModel(g, data);
			}
			g.writeEndObject();
			// write model data end
			g.writeEndObject();
			g.flush();
			g.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}

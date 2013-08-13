package com.jeefuse.base.modules.keyLabel;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.springframework.util.Assert;

import com.jeefuse.base.modules.json.JsonUtil;
import com.jeefuse.base.modules.keyLabel.render.KeyLabelJsonWriter;
import com.jeefuse.base.web.utils.RenderUtil;

/**
 * keyLabel格式render.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class KeyLabelRenderUtil {

	/**
	 * 渲染为HTML checkbox.
	 * 
	 * @param <T>
	 * @param keyLabelList
	 *            keyLabel数据例表
	 * @param checkKeys
	 *            勾选的key
	 * @param inputFieldName
	 *            html dom元素名
	 */
	public static final <T extends KeyLabel> String renderHtmlCheckboxs(T[] keyLabels, List<String> checkKeys,
			String inputFieldName) {
		if (null == keyLabels || keyLabels.length == 0)
			return null;
		StringBuilder sb = new StringBuilder(100);
		int loops = keyLabels.length;
		for (int i = 0; i < loops; i++) {
			KeyLabel keyLabel = keyLabels[i];
			sb.append("<input type='checkbox' class='checkbox'");
			sb.append("	name='").append(inputFieldName).append("'");
			sb.append("	value='").append(keyLabel.getKey()).append("'");
			sb.append("	id='").append(keyLabel.getKey()).append("-").append(i).append("'");
			if (null != checkKeys && checkKeys.contains(keyLabel.getKey())) {
				sb.append(" checked='checked'");
			}
			sb.append("/>");
			sb.append("<label for='").append(keyLabel.getKey()).append("-").append(i);
			sb.append("' class='checkboxLabel'>");
			sb.append(keyLabel.getLabel());
			sb.append("</label>");
		}
		return sb.toString();
	}

	/**
	 * 渲染为HTML checkbox.
	 * 
	 * @param <T>
	 * @param keyLabelList
	 *            keyLabel数据例表
	 * @param checkKeys
	 *            勾选的key
	 * @param inputFieldName
	 *            html dom元素名
	 */
	public static final <T extends KeyLabel> String renderHtmlCheckboxs(List<T> keyLabelList, List<String> checkKeys,
			String inputFieldName) {
		if (null == keyLabelList || keyLabelList.isEmpty())
			return null;
		StringBuilder sb = new StringBuilder(100);
		int loops = keyLabelList.size();
		for (int i = 0; i < loops; i++) {
			KeyLabel keyLabel = keyLabelList.get(i);
			sb.append("<input type='checkbox' class='checkbox'");
			sb.append("	name='").append(inputFieldName).append("'");
			sb.append("	value='").append(keyLabel.getKey()).append("'");
			sb.append("	id='").append(keyLabel.getKey()).append("-").append(i).append("'");
			if (null != checkKeys && checkKeys.contains(keyLabel.getKey())) {
				sb.append(" checked='checked'");
			}
			sb.append("/>");
			sb.append("<label for='" + keyLabel.getKey()).append("-").append(i);
			sb.append("' class='checkboxLabel'>");
			sb.append(keyLabel.getLabel());
			sb.append("</label>");
		}
		return sb.toString();
	}

	/**
	 * 渲染为HTML radio.
	 * 
	 * @param <T>
	 * @param keyLabelList
	 *            keyLabel数据例表
	 * @param checkKeys
	 *            勾选的key
	 * @param domName
	 *            html dom元素名
	 */
	public static final <T extends KeyLabel> String renderHtmlRadios(List<T> keyLabelList, String checkKey,
			String domName) {
		if (null == keyLabelList || keyLabelList.isEmpty())
			return null;
		StringBuilder sb = new StringBuilder(100);
		int loops = keyLabelList.size();
		for (int i = 0; i < loops; i++) {
			KeyLabel keyLabel = keyLabelList.get(i);
			sb.append("<input type='radio'");
			sb.append("	name='").append(domName).append("'");
			sb.append("	value='").append(keyLabel.getKey()).append("'");
			sb.append("	id='").append(keyLabel.getKey()).append("-").append(i).append("'");
			if (null != checkKey && checkKey.equals(keyLabel.getKey())) {
				sb.append(" checked");
			}
			sb.append(" class='radio'/>");
			sb.append("<label for='").append(keyLabel.getKey()).append("-").append(i);
			sb.append("' class='radioLabel'>");
			sb.append(keyLabel.getLabel());
			sb.append("</label>");
		}
		return sb.toString();
	}

	/**
	 * 渲染为HTML radio.
	 * 
	 * @param <T>
	 * @param keyLabelList
	 *            keyLabel数据例表
	 * @param checkKeys
	 *            勾选的key
	 * @param domName
	 *            html dom元素名
	 * @param onclickMethod
	 *            执行方法.
	 * @return
	 */
	public static final <T extends KeyLabel> String renderHtmlRadios(List<T> keyLabelList, String checkKey,
			String domName, String onclickMethod) {
		if (null == keyLabelList || keyLabelList.isEmpty())
			return null;
		StringBuilder sb = new StringBuilder(100);
		int loops = keyLabelList.size();
		for (int i = 0; i < loops; i++) {
			KeyLabel keyLabel = keyLabelList.get(i);
			sb.append("<input type='radio'");
			sb.append("	name='").append(domName).append("'");
			sb.append("	value='").append(keyLabel.getKey()).append("'");
			sb.append("	id='").append(keyLabel.getKey()).append("-").append(i).append("'");
			if (null != checkKey && checkKey.equals(keyLabel.getKey())) {
				sb.append(" checked");
			}
			sb.append(" onclick='").append(onclickMethod).append("'");
			sb.append(" class='radio'/>");
			sb.append("<label for='").append(keyLabel.getKey()).append("-").append(i);
			sb.append("' class='radioLabel'>");
			sb.append(keyLabel.getLabel());
			sb.append("</label>");
		}
		return sb.toString();
	}

	/**
	 * 渲染为HTML select的option.
	 * 
	 * @param <T>
	 * @param keyLabelList
	 *            keyLabel数据例表
	 * @param checkKeys
	 *            勾选的key
	 */
	public static final <T extends KeyLabel> String renderHtmlSelect(List<T> keyLabelList, String checkKey) {
		if (null == keyLabelList || keyLabelList.isEmpty())
			return null;
		StringBuilder sb = new StringBuilder(100);
		for (KeyLabel item : keyLabelList) {
			sb.append(" <option value=\"" + item.getKey() + "\"");
			if (null != checkKey && item.getKey().equals(checkKey)) {
				sb.append(" selected=\"selected\" ");
			}
			sb.append(">");
			sb.append(item.getLabel());
			sb.append("</option>");
		}
		return sb.toString();
	}

	public static final <T extends KeyLabel> String renderHtmlSelect(T[] values, String checkKey) {
		if (null == values || values.length == 0)
			return null;
		StringBuilder sb = new StringBuilder(100);
		for (KeyLabel item : values) {
			sb.append(" <option value=\"").append(item.getKey()).append("\"");
			if (null != checkKey && item.getKey().equals(checkKey)) {
				sb.append(" selected=\"selected\" ");
			}
			sb.append(">");
			sb.append(item.getLabel());
			sb.append("</option>");
		}
		return sb.toString();
	}


	/**
	 * 渲染为HTML查询链接.
	 * 
	 * @param <T>
	 * @param keyLabelList
	 * @param baseHref
	 * @param inputFieldName
	 * @return
	 */
	public static final <T extends KeyLabel> String renderHtmlLinkItem(Collection<T> keyLabelList, String baseHref,
			String inputFieldName) {
		if (null == keyLabelList || keyLabelList.isEmpty())
			return null;
		Assert.notNull(baseHref);
		String tempHref = baseHref;
		if (-1 == tempHref.indexOf("?")) {
			tempHref = tempHref + "?" + inputFieldName + "=";
		} else {
			tempHref = tempHref + "&" + inputFieldName + "=";
		}
		StringBuilder sb = new StringBuilder(100);
		for (KeyLabel item : keyLabelList) {
			sb.append(" <a href='").append(tempHref).append(item.getKey());
			sb.append("' title='查找");
			sb.append(item.getLabel());
			sb.append("'>").append(item.getLabel()).append("</a>");
		}
		return sb.toString();
	}

	/**
	 * 构造JSON格式. 例：
	 * <P>
	 * <br>
	 * { <br>
	 * success:true|false, <br>
	 * message:"", <br>
	 * data:[{"key":"key1","label":"lable1"},{"key":"key2","label":"lable2"}]
	 * <br>
	 * 
	 * @param <T>
	 * @param list
	 * @return
	 * @throws IOException
	 */
	public static final <T extends KeyLabel> String contructResultMsgJson(List<T> list) throws IOException {
		StringWriter writer = new StringWriter();
		KeyLabelJsonWriter<T> jsonWriter = new KeyLabelJsonWriter<T>(list);
		jsonWriter.writeJson(writer);
		return writer.toString();
	}

	/**
	 * 输出 JSON格式. 例：
	 * <P>
	 * <br>
	 * { <br>
	 * success:true|false, <br>
	 * message:"", <br>
	 * data:[{"key":"key1","label":"lable1"},{"key":"key2","label":"lable2"}]
	 * <br>
	 * 
	 * @param <T>
	 * @param list
	 * @return
	 * @throws IOException
	 */
	public static final <T extends KeyLabel> void renderResultMsgJson(List<T> list) throws IOException {
		RenderUtil.renderJson(contructResultMsgJson(list));
	}

	/**
	 * 构造JSON格式. 例：
	 * [{"key":"key1","label":"lable1"},{"key":"key2","label":"lable2"}]
	 * 
	 * @param <T>
	 * @param keyLabelList
	 *            keyLabel数据例表
	 * @throws IOException
	 */
	public static final <T extends KeyLabel> String contructJson(List<T> list) {
		StringWriter writer = new StringWriter();
		JsonGenerator g;
		try {
			g = JsonUtil.jsonFactory.createJsonGenerator(writer);
			g.writeStartArray();
			if (null != list && !list.isEmpty()) {
				for (T model : list) {
					g.writeStartObject();
					g.writeStringField("key", model.getKey());
					g.writeStringField("label", model.getLabel());
					g.writeEndObject();
				}
			}
			g.writeEndArray();
			g.flush();
			g.close();
			return writer.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return "[]";
		}
	}

	/**
	 * 构造JSON格式. 例：
	 * [{"key":"key1","label":"lable1"},{"key":"key2","label":"lable2"}]
	 * 
	 * @param <T>
	 * @param keyLabelList
	 *            keyLabel数据例表
	 * @throws IOException
	 */
	public static final <T extends KeyLabel> String contructJson(T[] arr) {
		StringWriter writer = new StringWriter();
		JsonGenerator g;
		try {
			g = JsonUtil.jsonFactory.createJsonGenerator(writer);
			g.writeStartArray();
			if (null != arr && arr.length > 0) {
				for (T model : arr) {
					g.writeStartObject();
					g.writeStringField("key", model.getKey());
					g.writeStringField("label", model.getLabel());
					g.writeEndObject();
				}
			}
			g.writeEndArray();
			g.flush();
			g.close();
			return writer.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return "[]";
		}
	}

}

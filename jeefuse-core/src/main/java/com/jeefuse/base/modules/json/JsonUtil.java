package com.jeefuse.base.modules.json;

import java.io.IOException;
import java.io.Writer;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 * 应用jackson plugin 输出json格式的数据.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class JsonUtil {
	public static ObjectMapper mapper = new ObjectMapper();
	public static JsonFactory jsonFactory = new JsonFactory();

	public static String writeValueAsString(final Object data) {
		try {
			return JsonUtil.mapper.writeValueAsString(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 转换json数据为对象.
	 * 
	 * @param <T>
	 * @param json
	 * @param clazz
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@SuppressWarnings("cast")
	public static <T> T readValue(String json, Class<T> clazz) throws JsonParseException, JsonMappingException,
			IOException {
		return (T) mapper.readValue(json, clazz);
	}

	/**
	 * 转换json数组为List对象. 例:<br/>
	 * List&lt;User> users = JsonUtil.readValue(userJson, new
	 * TypeReference&lt;ArrayList&lt;User>>() { });
	 * 
	 * @param <T>
	 * @param json
	 * @param typeReference
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T readValue(String json, TypeReference<T> typeReference) throws JsonParseException,
			JsonMappingException, IOException {
		return (T) mapper.readValue(json, typeReference);
	}

	/**
	 * 转换对象为JSON数据.
	 * 
	 * @param <T>
	 * @param writer
	 * @param object
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> void writeValue(Writer writer, T object) throws JsonParseException, JsonMappingException,
			IOException {
		mapper.writeValue(writer, object);
	}

}

package com.jeefuse.base.modules.keyLabel;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class KeyLabelRenderUtilTest {
	protected final Logger logger = LoggerFactory.getLogger(KeyLabelRenderUtilTest.class);

	@Test
	public void testRenderJson() {
		String json = "";
		long start = System.currentTimeMillis();
		int loop = 1000000;
		for (int i = 0; i < loop; i++) {
			List<KeyLabelImpl> keyLabelList = new ArrayList<KeyLabelImpl>();
			keyLabelList.add(new KeyLabelImpl("key1", "lable1"));
			keyLabelList.add(new KeyLabelImpl("key2", "lable2"));
			keyLabelList.add(new KeyLabelImpl("key3", "lable3"));
			json = KeyLabelRenderUtil.contructJson(keyLabelList);
		}
		long end = System.currentTimeMillis();
		logger.info(json);
		logger.info("using time:" + (end - start));
	}



}

package com.jeefuse.base.utils.random;

import java.util.Random;

/**产生随机字符串
 * @author <a href="mailto:yonclv@gmail.com">yonclv</a>
 */
public class RandomString {

	private static Random randGen = null;
	private static char[] numbersAndLetters = null;
	private static Object initLock = new Object();

	/**
	 * 产生随机字符串
	 */
	public static final String randomString(int length) {

		if (length < 1) {
			return null;
		}
		if (randGen == null) {
			synchronized (initLock) {
				if (randGen == null) {
					randGen = new Random();
					numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz"
							+ "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ")
							.toCharArray();
				}
			}
		}
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
		}
		return new String(randBuffer);
	}

}

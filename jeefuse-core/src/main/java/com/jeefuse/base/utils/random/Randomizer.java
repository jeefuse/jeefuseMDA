package com.jeefuse.base.utils.random;

import java.util.Random;



/**随机数和字符串生成器.
 * @author <a href="mailto:yonclv@gmail.com">yonclv</a>
 */
public class Randomizer {
	private static final Random rnd = new Random();
	private static final int NORMAL = -1;
	private static final int NUMBER = 0;
	private static final int UPPER_CHARACTER = 1;
	private static final int LOWER_CHARACTER = 2;
	private static final int SIZE = 3;
	private static final int[] MAX_MEMBER = { 10, 26, 26 };
	private static final int[] BASE_ASCII = { 48, 65, 97 };

	/** */
	/**
	 * 随机生成数字和字母组成的字符串。
	 * 
	 * @param length
	 *            字符串长度
	 * @param type
	 *            类型(NORMAL/NUMBER)
	 * @return 字符串
	 */
	private static String nextString(int length, int type) {
		char[] charArray = new char[length];
		int curType = type;
		for (int i = 0; i < length; i++) {
			if (type == NORMAL)
				curType = rnd.nextInt(SIZE);
			charArray[i] = (char) (rnd.nextInt(MAX_MEMBER[curType]) + BASE_ASCII[curType]);
		}
		return new String(charArray);
	}

	/** */
	/**
	 * 随机生成数字和字母组成的字符串。
	 * 
	 * @param length
	 *            字符串长度
	 * @return 字符串
	 */
	public static String nextString(int length) {
		return nextString(length, NORMAL);
	}

	/** */
	/**
	 * 随机生成数字组成的字符串。
	 * 
	 * @param length
	 *            字符串长度
	 * @return 字符串
	 */
	public static String nextNumber(int length) {
		return nextString(length, NUMBER);
	}

	/** */
	/**
	 * 随机生成大写字母组成的字符串。
	 * 
	 * @param length
	 *            字符串长度
	 * @return 字符串
	 */
	public static String nextUpperString(int length) {
		return nextString(length, UPPER_CHARACTER);
	}

	/** */
	/**
	 * 随机生成小写字母组成的字符串。
	 * 
	 * @param length
	 *            字符串长度
	 * @return 字符串
	 */
	public static String nextLowerString(int length) {
		return nextString(length, LOWER_CHARACTER);
	}

	/** */
	/**
	 * 随机生成大于零的整数。
	 * 
	 * @see {@link Random#nextInt()}
	 * @return 整数
	 */
	public static int nextInt() {
		return rnd.nextInt();
	}

	/** */
	/**
	 * 随机生成0<value<max的整数
	 * 
	 * @see {@link Random#nextInt(int)}
	 * @param max
	 *            最大整数
	 * @return 整数
	 */
	public static int nextInt(int max) {
		return rnd.nextInt(max);
	}

	/** */
	/**
	 * 生成布尔值。
	 * 
	 * @see {@link Random#nextBoolean()}
	 * @return 布尔值
	 */
	public static boolean nextBoolean() {
		return rnd.nextBoolean();
	}

	/** */
	/**
	 * 生成字节数组。
	 * 
	 * @see {@link Random#nextBytes(byte[])}
	 * @param bytes
	 *            用来存储生成的字节数组
	 */
	public static void nextBytes(byte[] bytes) {
		rnd.nextBytes(bytes);
	}

	/** */
	/**
	 * 生成浮点数。
	 * 
	 * @see {@link Random#nextDouble()}
	 * @return 双精度浮点数
	 */
	public static double nextDouble() {
		return rnd.nextDouble();
	}

	/** */
	/**
	 * 生成浮点数。
	 * 
	 * @see {@link Random#nextFloat()}
	 * @return 单精度浮点数
	 */
	public static float nextFloat() {
		return rnd.nextFloat();
	}

	/** */
	/**
	 * 生成高斯浮点数。
	 * 
	 * @see {@link Random#nextGaussian()}
	 * @return 双精度浮点数
	 */
	public static double nextGaussian() {
		return rnd.nextGaussian();
	}

	/** */
	/**
	 * 生成长整数。
	 * 
	 * @see {@link Random#nextLong()}
	 * @return 长整数
	 */
	public static long nextLong() {
		return rnd.nextLong();
	}
}

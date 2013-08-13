package com.jeefuse.base.utils.common;

/**
 * 格 式化字节大小及时间显示.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class FormatUtil {

	/**
	 * 格式化字节大小
	 * 
	 * @param d
	 *            bytes number
	 * @return
	 */
	static public String formatSize(long d) {
		if (d < 1024)
			return d + "bytes";
		else if (d > 1048576)
			return (Math.round(((d * 10) / 1048576)) / 10) + "M";
		else
			return (Math.round(((d * 10) / 1024)) / 10) + "KB";
	}

	/**
	 * 格式化d为*年*天*时*分*秒,d为毫秒数.
	 * 
	 * @param d
	 *            毫秒数
	 * @return
	 */
	static public String formatTime(long d) {
		StringBuilder sb = new StringBuilder();
		long temp = d;
		long compare = Long.parseLong("31536000000");
		if (temp >= compare) {// 年
			sb.append(temp / compare);
			sb.append("年");
			temp %= compare;
		}
		compare = Long.parseLong("86400000");
		if (temp >= compare) {// 天
			sb.append(temp / compare);
			sb.append("天");
			temp %= compare;
		}
		compare = Long.parseLong("3600000");
		if (temp >= compare) {// 时
			sb.append(temp / compare);
			sb.append("时");
			temp %= compare;
		}
		compare = Long.parseLong("60000");
		if (temp >= compare) {// 分
			sb.append(temp / compare);
			temp %= compare;
			sb.append("分");
		}
		compare = Long.parseLong("1000");
		if (temp >= compare) {// 秒
			sb.append(temp / compare);
			temp %= compare;
			sb.append("秒");
		}
		return sb.toString();

	}
}

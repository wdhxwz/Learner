package com.wangdh.learner.base;

import java.util.Formatter;

/**
 * <p>
 * 字节 16进制字串转换工具类
 * </p>
 */
public class Byte2Hex {

	/**
	 * 
	 * 字节转换为 16 进制字符串
	 * 
	 * @param b
	 * 			字节
	 * @return
	 */
	public static String byte2Hex( byte b ) {
		String hex = Integer.toHexString(b);
		if ( hex.length() > 2 ) {
			hex = hex.substring(hex.length() - 2);
		}
		while ( hex.length() < 2 ) {
			hex = "0" + hex;
		}
		return hex;
	}


	/**
	 * 
	 * 字节数组转换为 16 进制字符串
	 * 
	 * @param bytes
	 * 			字节数组
	 * @return
	 */
	public static String byte2Hex( byte[] bytes ) {
		Formatter formatter = new Formatter();
		for ( byte b : bytes ) {
			formatter.format("%02x", b);
		}
		String hash = formatter.toString();
		formatter.close();
		return hash;
	}
	
	/**
	 * 将16进制字符串转换为字节
	 * @param strhex
	 * @return
	 */
	public static byte[] hex2byte(String strhex) {
		if (strhex == null)
			return null;

		int l = strhex.length();
		if (l % 2 == 1)
			return null;

		byte[] b = new byte[l / 2];
		for (int i = 0; i != l / 2; ++i)
			b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2),
					16);

		return b;
	}
}
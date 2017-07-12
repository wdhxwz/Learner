package com.wangdh.learner.base;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Logger;

/**
 * <p>
 * MD5加密工具类
 * </p>
 * 
 */
public class MD5 {
	private static final Logger logger = Logger.getLogger("MD5");
	public static final String ALGORITHM = "MD5";

	/**
	 * @Description 字符串加密为MD5 中文加密一致通用,必须转码处理： plainText.getBytes("UTF-8")
	 * @param plainText
	 *            需要加密的字符串
	 * @return
	 */
	public static String toMD5(String plainText) {
		StringBuffer rlt = new StringBuffer();
		try {
			rlt.append(md5String(plainText.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			logger.severe(" CipherHelper toMD5 exception.");
			e.printStackTrace();
		}
		return rlt.toString();
	}

	/**
	 * MD5 参数签名生成算法
	 * 
	 * @param HashMap<String,String>
	 *            params 请求参数集，所有参数必须已转换为字符串类型
	 * @param String
	 *            secret 签名密钥
	 * @return 签名
	 * @throws IOException
	 */
	public static String getSignature(HashMap<String, String> params, String secret) {
		Map<String, String> sortedParams = new TreeMap<String, String>(params);
		Set<Entry<String, String>> entrys = sortedParams.entrySet();
		StringBuilder basestring = new StringBuilder();
		for (Entry<String, String> param : entrys) {
			basestring.append(param.getKey()).append("=").append(param.getValue());
		}
		return getSignature(basestring.toString(), secret);
	}

	/**
	 * MD5 参数签名生成算法
	 * 
	 * @param String
	 *            sigstr 签名字符串
	 * @param String
	 *            secret 签名密钥
	 * @return 签名
	 * @throws IOException
	 */
	public static String getSignature(String sigstr, String secret) {
		StringBuilder basestring = new StringBuilder(sigstr);
		basestring.append("#");
		basestring.append(toMD5(secret));
		return toMD5(basestring.toString());
	}

	public static byte[] md5Raw(byte[] data) {
		byte[] md5buf = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance(ALGORITHM);
			md5buf = md5.digest(data);
		} catch (Exception e) {
			md5buf = null;
			logger.severe("md5Raw error.");
			e.printStackTrace();
		}
		return md5buf;
	}

	public static String md5String(byte[] data) {
		String md5Str = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance(ALGORITHM);
			byte[] buf = md5.digest(data);
			for (int i = 0; i < buf.length; i++) {
				md5Str += Byte2Hex.byte2Hex(buf[i]);
			}
		} catch (Exception e) {
			md5Str = null;
			logger.severe("md5String error.");
			e.printStackTrace();
		}
		return md5Str;
	}

	/**
	 * MD5加密，与.net系统等使用的方式一致
	 * 
	 * @param data
	 * @return
	 */
	public static String hashMD5(String data) {
		try {
			byte[] bytes = null;
			MessageDigest messageDigest = null;

			bytes = data.getBytes("UTF-8");
			messageDigest = MessageDigest.getInstance(ALGORITHM);

			messageDigest.update(bytes);
			bytes = messageDigest.digest();
			StringBuilder buf = new StringBuilder(bytes.length * 2);
			int i;

			for (i = 0; i < bytes.length; i++) {
				if (bytes[i] < 0) {
					buf.append(Long.toString(bytes[i] & 0xff));
				} else {
					buf.append(Long.toString(bytes[i]));
				}
			}
			return buf.toString();
		} catch (Exception e) {
			logger.severe("hashMD5, md5String error." + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		String s = new String("admin");
		String secret = "oas-management-secret";
		System.out.println(toMD5(s));
		System.out.println(getSignature(s, secret));
		// String md5String = hashMD5("1qaz1qaz");
		// System.out.println(toMD5(md5String));
	}
}
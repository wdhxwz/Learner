package com.wangdh.learner.mybatis.Utils;

import com.wangdh.learner.mybatis.base.BaseEnum;

/**
 * 枚举类型工具类
 * 
 * @author wdhcxx
 *
 */
public class EnumUtils {

	public static <T extends BaseEnum<?>> T parse(Class<T> enumClass, Object value) {
		T[] enumConstants = enumClass.getEnumConstants();
		for (T enumConstant : enumConstants) {
			// 不同类型调用equals都会返回false
			// "1".equals(1) return false
			// obj instanceof class 成立才会进行比较，否则直接返回false
			if (enumConstant.getValue().equals(value)) {
				return enumConstant;
			}
		}

		throw new IllegalArgumentException(enumClass + " not exists enum value:" + value);
	
	}
}

package com.wangdh.learner.mybatis.base;

/**
 * 枚举的基接口
 * 
 * @author wdhcxx
 */
public interface BaseEnum<valueType> {
	valueType getValue();
	String getName();
}

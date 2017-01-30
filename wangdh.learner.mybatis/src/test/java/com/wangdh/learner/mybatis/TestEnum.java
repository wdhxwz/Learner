package com.wangdh.learner.mybatis;

import com.wangdh.learner.mybatis.Utils.EnumUtils;

import wangdh.learner.mybatis.enums.SexEnum;

public class TestEnum {

	public static void main(String[] args) {
		String abc = "1";
		Integer bbb = 2;
		SexEnum sexEnum = EnumUtils.parse(SexEnum.class, abc);
		System.out.println(sexEnum.getName() + "=" + sexEnum.getValue());
		System.out.println(abc.equals(""));
		System.out.println(bbb.equals(""));
	}

}

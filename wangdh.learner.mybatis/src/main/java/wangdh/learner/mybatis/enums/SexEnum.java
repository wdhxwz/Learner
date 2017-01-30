package wangdh.learner.mybatis.enums;

import com.wangdh.learner.mybatis.base.BaseEnum;

public enum SexEnum implements BaseEnum<String> {
	男("男", "1"), 女("女", "0");

	private String name;
	private String code;

	@Override
	public String getValue() {
		return this.code;
	}

	@Override
	public String getName() {
		return this.name;
	}

	private SexEnum(String name, String code) {
		this.code = code;
		this.name = name;
	}
}

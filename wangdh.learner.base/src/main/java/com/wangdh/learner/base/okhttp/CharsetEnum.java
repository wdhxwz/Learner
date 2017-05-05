package com.wangdh.learner.base.okhttp;

public enum CharsetEnum {
	UTF8("UTF8", "UTF-8");

	CharsetEnum(String text, String value) {
		this.text = text;
		this.value = value;
	}

	private String text;
	private String value;

	public String getText() {
		return text;
	}

	public String getValue() {
		return value;
	}
}

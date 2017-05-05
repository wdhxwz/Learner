package com.wangdh.learner.base.okhttp;

public enum ContentTypeEnum {
	JSON("json", "application/json");

	ContentTypeEnum(String text, String value) {
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

/**
 * 
 */
package wangdh.learner.rabbitmq.common;

/**
 * @author wdhcxx
 *
 */
public enum ExchangeType {
	topic("topic", "topic"), direct("direct", "direct"), fanout("fanout", "fanout"), header("header", "header");

	private String code;
	private String text;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	ExchangeType(String code, String text) {
		this.code = code;
		this.text = text;
	}
}
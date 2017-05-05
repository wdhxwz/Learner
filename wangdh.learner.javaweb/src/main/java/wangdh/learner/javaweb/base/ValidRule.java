package wangdh.learner.javaweb.base;

/**
 * 验证规则
 * @author wangdh
 * 2017年2月17日下午3:36:11
 */
public class ValidRule {
	private Object value;
	private ValidType validType;
	private int validOrder;
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public ValidType getValidType() {
		return validType;
	}
	public void setValidType(ValidType validType) {
		this.validType = validType;
	}
	public int getValidOrder() {
		return validOrder;
	}
	public void setValidOrder(int validOrder) {
		this.validOrder = validOrder;
	}
	
	
}

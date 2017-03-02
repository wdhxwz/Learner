package wangdh.learner.javaweb.base;

import java.util.List;

import wangdh.learner.javaweb.interfaces.IValidator;

public class InnerOpenApiContext {
	private String targetService;

	public String getTargetService() {
		return targetService;
	}

	public void setTargetService(String targetService) {
		this.targetService = targetService;
	}
	
	private String optType;
	private String channelNo;
	
	
	private String ip;
	private String timestamp;
	
	private String requestIp;
	
	
	private String data;
	private String rawData;
	private String signData;
	
	// 验证
	private List<IValidator> validators;

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	public String getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getRawData() {
		return rawData;
	}

	public void setRawData(String rawData) {
		this.rawData = rawData;
	}

	public String getSignData() {
		return signData;
	}

	public void setSignData(String signData) {
		this.signData = signData;
	}

	public List<IValidator> getValidators() {
		return validators;
	}

	public void setValidators(List<IValidator> validators) {
		this.validators = validators;
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}	
}
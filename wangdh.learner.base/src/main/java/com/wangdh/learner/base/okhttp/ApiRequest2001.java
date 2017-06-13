package com.wangdh.learner.base.okhttp;

/**
 * 查询指定渠道下用户的账户列表
 * @author wdhcxx
 *
 */
public class ApiRequest2001 extends ApiRequest{
	private static final long serialVersionUID = 16046829195261061L;
	
	/**
	 * 渠道编号
	 */
	private String channelNo;
	private String name;
	

	public String getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}		
}
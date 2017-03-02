package wangdh.learner.javaweb.requestFrom;

import javax.servlet.http.HttpServletRequest;

import wangdh.learner.javaweb.interfaces.IRequestFrom;

public class DefaultRequestFrom implements IRequestFrom {

	@Override
	public String getRequestFrom(HttpServletRequest request) {
		// 获取请求参数，该参数经过Base64加密和urlEncode
		String requestData = request.getParameter("data");
		
		// 对requestData进行url解密，urlDecodeData
		// 对urlDecodeData进行base64解密，得到base64DecodeData
		// 从base64DecodeData中获取channelNo的值
		
		
		return requestData;
	}

}

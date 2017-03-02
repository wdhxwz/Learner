package wangdh.learner.javaweb.factory;

import wangdh.learner.javaweb.base.OASConfig;
import wangdh.learner.javaweb.interfaces.IRequestAdapter;
import wangdh.learner.javaweb.interfaces.IResponseAdapter;

public class AdapterFactory {

	public static IRequestAdapter getRequestAdapter(String flag) {
		IRequestAdapter requestAdapter = OASConfig.requestAdapterMap.get(flag);
		if (requestAdapter == null) {
			throw new RuntimeException("没有找到请求适配器");
		}

		return requestAdapter;
	}
	
	public static IResponseAdapter getResponseAdapter(String flag) {
		IResponseAdapter responseAdapter = OASConfig.reqponseAdapterMap.get(flag);
		if (responseAdapter == null) {
			throw new RuntimeException("没有找到响应适配器");
		}

		return responseAdapter;
	}
}
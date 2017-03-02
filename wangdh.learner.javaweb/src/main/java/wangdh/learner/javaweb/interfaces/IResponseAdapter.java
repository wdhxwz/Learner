package wangdh.learner.javaweb.interfaces;

import wangdh.learner.javaweb.base.ServiceResult;

public interface IResponseAdapter {
	Object buildServiceResponse(ServiceResult serviceResult);
	ServiceResult buildServiceResult(Object response);
}

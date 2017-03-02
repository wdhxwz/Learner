package wangdh.learner.javaweb.interfaces;

import javax.servlet.http.HttpServletRequest;

import wangdh.learner.javaweb.base.InnerOpenApiContext;

public interface IRequestAdapter {
	InnerOpenApiContext buildContext(HttpServletRequest request);

	Object buildServiceRequest(InnerOpenApiContext context);
}

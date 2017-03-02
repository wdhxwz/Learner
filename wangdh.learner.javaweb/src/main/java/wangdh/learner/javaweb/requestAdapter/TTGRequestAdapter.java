package wangdh.learner.javaweb.requestAdapter;

import javax.servlet.http.HttpServletRequest;

import wangdh.learner.javaweb.base.InnerOpenApiContext;
import wangdh.learner.javaweb.interfaces.IRequestAdapter;

public class TTGRequestAdapter implements IRequestAdapter{

	@Override
	public InnerOpenApiContext buildContext(HttpServletRequest request) {
		InnerOpenApiContext context = new InnerOpenApiContext();
		
		return context;
	}

	@Override
	public Object buildServiceRequest(InnerOpenApiContext context) {
		
		return null;
	}
}
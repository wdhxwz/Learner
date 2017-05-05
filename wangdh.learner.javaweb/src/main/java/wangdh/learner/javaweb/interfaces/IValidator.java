package wangdh.learner.javaweb.interfaces;

import wangdh.learner.javaweb.base.InnerOpenApiContext;

public interface IValidator {
	boolean valid(InnerOpenApiContext context);
	int getOrder();
}

package wangdh.learner.javaweb.interfaces;

import wangdh.learner.javaweb.base.InnerOpenApiContext;
import wangdh.learner.javaweb.base.ServiceResult;

public interface ISecurityManager {
	ServiceResult validate(InnerOpenApiContext context);
}

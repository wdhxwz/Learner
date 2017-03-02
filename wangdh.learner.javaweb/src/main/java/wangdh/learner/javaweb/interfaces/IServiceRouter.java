package wangdh.learner.javaweb.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IServiceRouter {
	void service(HttpServletRequest request, HttpServletResponse response);
}

package wangdh.learner.javaweb.interfaces;

import javax.servlet.http.HttpServletRequest;

/**
 * 确定调用者
 * 
 * @author wangdh 2017年2月17日下午2:37:21
 */
public interface IRequestFrom {
	String getRequestFrom(HttpServletRequest request);
}

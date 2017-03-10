package wangdh.learner.javaweb.router;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wangdh.learner.javaweb.base.InnerOpenApiContext;
import wangdh.learner.javaweb.base.ServiceResult;
import wangdh.learner.javaweb.businessService.DefaultBusinessService;
import wangdh.learner.javaweb.factory.AdapterFactory;
import wangdh.learner.javaweb.interfaces.IBusinessService;
import wangdh.learner.javaweb.interfaces.IRequestAdapter;
import wangdh.learner.javaweb.interfaces.IRequestFrom;
import wangdh.learner.javaweb.interfaces.IResponseAdapter;
import wangdh.learner.javaweb.interfaces.ISecurityManager;
import wangdh.learner.javaweb.interfaces.IServiceRouter;
import wangdh.learner.javaweb.requestFrom.DefaultRequestFrom;
import wangdh.learner.javaweb.responseAdapter.DefaultResponseAdapter;
import wangdh.learner.javaweb.security.DefaultSecurityManager;

public class DefaultServiceRouter implements IServiceRouter {

	public void service(HttpServletRequest request, HttpServletResponse response) {
		IResponseAdapter responseAdapter = null;
		ServiceResult serviceResult = null;
		try {
			// String requestPath = request.getServletPath();
			// IRequestFrom requestFrom = new DefaultRequestFrom();

			// OASConfig类加载OAS.properties的配置
			// requestFrom:
			IRequestFrom requestFrom = null;
			
			if (requestFrom == null) {
				requestFrom = new DefaultRequestFrom();
			}
			String source = requestFrom.getRequestFrom(request);

			// 获取请求适配器
			IRequestAdapter requestAdapter = AdapterFactory.getRequestAdapter(source);

			// 根据请求适配器构造上下文
			InnerOpenApiContext context = requestAdapter.buildContext(request);

			// 获取安全校验器并做校验
			ISecurityManager securityManager = new DefaultSecurityManager();
			serviceResult = securityManager.validate(context);

			// 响应适配器
			responseAdapter = AdapterFactory.getResponseAdapter(source);

			// 判断是否有验证错误,进行响应适配，然后返回
			if (serviceResult == null) {
				// 适配到目标服务的报文
				String targetService = context.getTargetService();
				IRequestAdapter targetServiceRequestAdapter = AdapterFactory.getRequestAdapter(targetService);
				Object data = targetServiceRequestAdapter.buildServiceRequest(context);

				// 执行业务
				IBusinessService businessService = new DefaultBusinessService();
				Object responseData = businessService.service(data);

				// 目标服务响应适配
				IResponseAdapter targetServiceResponseAdapter = AdapterFactory.getResponseAdapter(targetService);
				serviceResult = targetServiceResponseAdapter.buildServiceResult(responseData);
				
				
				// 第三方過來，验证数据
				// 内部服务给第三方，加密
				
				
			}
		} catch (Exception e) {
			// 构造错误响应
		} finally {
			if (responseAdapter == null) {
				responseAdapter = new DefaultResponseAdapter();
			}
			Object responseData = responseAdapter.buildServiceResponse(serviceResult);
			try {
				response.getWriter().write(responseData.toString());
			} catch (IOException e) {
				// 记录日志
			}
		}

	}
}

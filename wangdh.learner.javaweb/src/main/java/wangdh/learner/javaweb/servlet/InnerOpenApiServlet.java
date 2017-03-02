package wangdh.learner.javaweb.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wangdh.learner.javaweb.interfaces.IRequestFrom;
import wangdh.learner.javaweb.interfaces.IServiceRouter;
import wangdh.learner.javaweb.router.DefaultServiceRouter;

public class InnerOpenApiServlet extends HttpServlet{
	private static final long serialVersionUID = 8902922063137617896L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IServiceRouter serviceRouter = new DefaultServiceRouter();
		serviceRouter.service(request, response);
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 读取配置
		Map<String, IRequestFrom> requestFromMap = new ConcurrentHashMap<>();
		InputStream inputStream =  this.getClass().getResourceAsStream("");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			Set<Object> keys = properties.keySet();
			
			
		} catch (IOException e) {
			// 记录日子
		}
	}
	
	@Override
	public void destroy() {

	}
}
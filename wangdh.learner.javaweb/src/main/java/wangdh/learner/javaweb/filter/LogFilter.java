package wangdh.learner.javaweb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 记录请求响应日志
 */
@WebFilter(urlPatterns = "*",filterName = "logFilter")
public class LogFilter implements javax.servlet.Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("处理开始时间：" + System.currentTimeMillis());
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("处理结束时间：" + System.currentTimeMillis());
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroy...");
    }
}

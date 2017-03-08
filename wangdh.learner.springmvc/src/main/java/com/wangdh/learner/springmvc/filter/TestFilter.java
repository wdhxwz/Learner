package com.wangdh.learner.springmvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class TestFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("destroy");

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		arg0.setAttribute("content", "text/html;charset=UTF-8");
		System.out.println(arg0.getContentType());
		
		arg2.doFilter(arg0, arg1);
		System.out.println(((HttpServletResponse) arg1).getContentType());
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init");

	}
}
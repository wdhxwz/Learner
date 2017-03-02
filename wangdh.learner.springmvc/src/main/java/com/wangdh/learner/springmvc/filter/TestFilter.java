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
		arg2.doFilter(arg0, arg1);
		arg1.setContentType("text/json");
		System.out.println(((HttpServletResponse)arg1).getContentType());
		arg1.getWriter().write("hahaha");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init");

	}
}
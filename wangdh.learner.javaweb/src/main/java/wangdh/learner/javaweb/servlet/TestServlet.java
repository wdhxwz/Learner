package wangdh.learner.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = -4068119453361247838L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("请求TestServlet");
		String localAddr = request.getServletPath();
		out.println("请求路径：" + localAddr);
	}
}
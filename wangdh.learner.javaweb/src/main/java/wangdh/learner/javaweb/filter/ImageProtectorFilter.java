package wangdh.learner.javaweb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"*.png","*.jpg","*.gif"}
        ,filterName = "imageProtectorFilter"
        )
public class ImageProtectorFilter implements javax.servlet.Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String referer  = request.getHeader("referer");
        System.out.println("referer = " + referer);

        if(referer != null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            throw new ServletException("Image not available");
        }
    }

    @Override
    public void destroy() {

    }
}
package com.wangdh.learner.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/6/27 10:20
 * @Description:
 */
@Controller
@RequestMapping("/test")
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/getServerInfo")
    @ResponseBody
    public String getServerInfo(HttpServletRequest request, HttpServletResponse response) {
        logger.info("request.getContextPath():{}", request.getContextPath());
        logger.info("request.getPathInfo():{}", request.getPathInfo());
        logger.info("request.getRequestURI():{}", request.getRequestURI());
        logger.info("request.getServletPath():{}", request.getServletPath());
        String rootPath = request.getServletContext().getRealPath("");
        logger.info("rootPath:{}", rootPath);

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            logger.info(
                    cookies[0].getName() + ","
                            + cookies[0].getMaxAge() + ","
                            + cookies[0].getDomain() + ","
                            + cookies[0].getPath() + ","
                            + cookies[0].getValue() + ","
                            + cookies[0].getSecure() + ","
                            + cookies[0].isHttpOnly());
        }

        //写入cookie
        Cookie cookie = new Cookie("mycookieID", String.valueOf(System.currentTimeMillis()));
        cookie.setHttpOnly(true);
        cookie.setMaxAge(24 * 60 * 60);//24小时后过期 -以秒为单位的，基于当前时间的有效值
        cookie.setDomain("www.max.com"); //设置域名，表示该cookie仅对www.max.com是有效
        cookie.setPath("/");//设置路径为根路径，表示该cookie对根路劲下所有path有效

        // 将cookie返回给浏览器
        response.addCookie(cookie);

        // 删除cookie
        // cookie是没有真正的删除操作的，只能通过cookie的有效时间，设置为负值即可。过去时间的cookie
        // cookie.setMaxAge(-1);

        return "200";
    }
}

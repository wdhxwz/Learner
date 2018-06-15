package com.wangdh.learner.springmvc.controller;

import com.wangdh.learner.springmvc.model.User;
import com.wangdh.learner.springmvc.response.ApiResult;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/6/15 10:06
 * @Description:
 */
@Controller
@RequestMapping("/api")
public class ApiController {

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public ApiResult getUserInfo(HttpServletResponse response){
        User user = new User();
        user.setName("krista");

        ApiResult apiResult = new ApiResult().buildSuccess().setData(user);

        response.setHeader("Access-Control-Allow-Origin", "*");

        return  apiResult;
    }
}

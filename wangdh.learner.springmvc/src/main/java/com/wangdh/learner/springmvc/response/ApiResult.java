package com.wangdh.learner.springmvc.response;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/6/15 10:07
 * @Description:
 */
public class ApiResult {
    private int code;
    private Object data;
    private String message;

    public ApiResult buildSuccess(){
        code = ResponseCode.SUCCESS.getCode();
        message = "";
        return  this;
    }
    public ApiResult setData(Object data){
        this.data = data;
        return  this;
    }

    public ApiResult setCode(int code){
        this.code = code;
        return  this;
    }

    public ApiResult setMessage(String message){
        this.message = message;
        return  this;
    }

    public int getCode() {
        return code;
    }
    public Object getData() {
        return data;
    }
    public String getMessage() {
        return message;
    }
}
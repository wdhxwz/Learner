package com.wangdh.learner.springmvc.response;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/6/15 10:12
 * @Description:
 */
public enum ResponseCode {
    SUCCESS(200,"SUCCESS")
    ;
    private Integer code;
    private String name;

    ResponseCode(Integer code,String name){
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}

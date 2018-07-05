package com.wangdh.learner.designpattern.decorator;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/7/5 18:59
 * @Description:
 */
public class HWCellPhone implements CellPhone{
    @Override
    public String call() {
        return "我正在使用华为手机打电话...";
    }

    @Override
    public String play() {
        return "我正在使用华为手机玩游戏...";
    }

    @Override
    public String message() {
        return "我正在使用华为手机发短信...";
    }
}
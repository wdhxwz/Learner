package com.wangdh.learner.designpattern.decorator;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/7/5 19:04
 * @Description:
 */
public class VideoPhone extends CellPhoneDecorator{
    public VideoPhone(CellPhone cellPhone) {
        super(cellPhone);
    }

    @Override
    public String call() {
        return super.call() + "；我这电话是能视频的";
    }
}
package com.wangdh.learner.designpattern.decorator;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/7/5 19:09
 * @Description:
 */
public class VRPhone extends CellPhoneDecorator{
    public VRPhone(CellPhone cellPhone) {
        super(cellPhone);
    }

    @Override
    public String play() {
        return super.play() + ";我这手机是能VR玩游戏的";
    }
}
